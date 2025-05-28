package projeto.edu.unichristus.java.dao;

import projeto.edu.unichristus.java.model.Prescricao;
import java.util.ArrayList;
import java.util.List;

public class PrescricaoDAO {
    private static List<Prescricao> prescricoes = new ArrayList<>();

    public void salvar(Prescricao prescricao) {
        prescricoes.add(prescricao);
    }

    public List<Prescricao> listarTodos() {
        return new ArrayList<>(prescricoes);
    }

    public Prescricao buscarPorId(int id) {
        for (Prescricao prescricao : prescricoes) {
            if (prescricao.getId() == id) {
                return prescricao;
            }
        }
        return null;
    }

    public boolean remover(int id) {
        return prescricoes.removeIf(p -> p.getId() == id);
    }
}
