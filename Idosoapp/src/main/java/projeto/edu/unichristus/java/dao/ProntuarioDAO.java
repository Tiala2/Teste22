package projeto.edu.unichristus.java.dao;

import projeto.edu.unichristus.java.model.ProntuarioMedico;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {
    private static List<ProntuarioMedico> prontuarios = new ArrayList<>();

    public void salvar(ProntuarioMedico prontuario) {
        prontuarios.add(prontuario);
    }

    public List<ProntuarioMedico> listarTodos() {
        return new ArrayList<>(prontuarios);
    }

    public ProntuarioMedico buscarPorId(int id) {
        for (ProntuarioMedico prontuario : prontuarios) {
            if (prontuario.getId() == id) {
                return prontuario;
            }
        }
        return null;
    }

    public boolean remover(int id) {
        return prontuarios.removeIf(p -> p.getId() == id);
    }
}
