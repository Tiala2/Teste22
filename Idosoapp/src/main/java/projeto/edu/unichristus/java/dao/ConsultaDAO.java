package projeto.edu.unichristus.java.dao;

import projeto.edu.unichristus.java.model.Consulta;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    private static List<Consulta> consultas = new ArrayList<>();

    public void salvar(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> listarTodos() {
        return new ArrayList<>(consultas);
    }

    public Consulta buscarPorId(int id) {
        for (Consulta consulta : consultas) {
            if (consulta.getId() == id) {
                return consulta;
            }
        }
        return null;
    }

    public boolean remover(int id) {
        return consultas.removeIf(c -> c.getId() == id);
    }
}
