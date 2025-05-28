package projeto.edu.unichristus.java.controller;

import projeto.edu.unichristus.java.model.EventoSentinela;
import projeto.edu.unichristus.java.dao.EventoSentinelaDAO;
import java.util.List;

public class EventoSentinelaController {
    private EventoSentinelaDAO eventoDAO;

    public EventoSentinelaController() {
        this.eventoDAO = new EventoSentinelaDAO();
    }

    public void adicionarEvento(EventoSentinela evento) {
        try {
            eventoDAO.salvar(evento);
        } catch (Exception e) {
            System.err.println("Erro ao adicionar evento sentinela: " + e.getMessage());
        }
    }

    public List<EventoSentinela> listarEventos() {
        try {
            return eventoDAO.listarTodos();
        } catch (Exception e) {
            System.err.println("Erro ao listar eventos sentinela: " + e.getMessage());
            return null;
        }
    }

    public EventoSentinela buscarPorId(int id) {
        try {
            return eventoDAO.buscarPorId(id);
        } catch (Exception e) {
            System.err.println("Erro ao buscar evento sentinela: " + e.getMessage());
            return null;
        }
    }

    public boolean removerEvento(int id) {
        try {
            return eventoDAO.remover(id);
        } catch (Exception e) {
            System.err.println("Erro ao remover evento sentinela: " + e.getMessage());
            return false;
        }
    }
}
