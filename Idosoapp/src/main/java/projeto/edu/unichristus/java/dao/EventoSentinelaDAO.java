package projeto.edu.unichristus.java.dao;

import projeto.edu.unichristus.java.model.EventoSentinela;
import java.util.ArrayList;
import java.util.List;

public class EventoSentinelaDAO {
    private static List<EventoSentinela> eventos = new ArrayList<>();

    public void salvar(EventoSentinela evento) {
        eventos.add(evento);
    }

    public List<EventoSentinela> listarTodos() {
        return new ArrayList<>(eventos);
    }

    public EventoSentinela buscarPorId(int id) {
        for (EventoSentinela evento : eventos) {
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null;
    }

    public boolean remover(int id) {
        return eventos.removeIf(e -> e.getId() == id);
    }
}
