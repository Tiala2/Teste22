package projeto.edu.unichristus.java.controller;

import projeto.edu.unichristus.java.model.ProfissionalSaude;
import java.util.ArrayList;
import java.util.List;

public class ProfissionalSaudeController {
    private List<ProfissionalSaude> profissionais;

    public ProfissionalSaudeController() {
        this.profissionais = new ArrayList<>();
    }

    public void adicionarProfissional(ProfissionalSaude profissional) {
        profissionais.add(profissional);
    }

    public List<ProfissionalSaude> listarProfissionais() {
        return new ArrayList<>(profissionais);
    }

    public ProfissionalSaude buscarPorId(int id) {
        for (ProfissionalSaude profissional : profissionais) {
            if (profissional.getId() == id) {
                return profissional;
            }
        }
        return null;
    }

    public boolean removerProfissional(int id) {
        return profissionais.removeIf(p -> p.getId() == id);
    }
}
