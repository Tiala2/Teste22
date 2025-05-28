package projeto.edu.unichristus.java.controller;

import projeto.edu.unichristus.java.model.Relatorio;
import java.util.ArrayList;
import java.util.List;

public class RelatorioController {
    private List<Relatorio> relatorios;

    public RelatorioController() {
        this.relatorios = new ArrayList<>();
    }

    public void adicionarRelatorio(Relatorio relatorio) {
        relatorios.add(relatorio);
    }

    public List<Relatorio> listarRelatorios() {
        return new ArrayList<>(relatorios);
    }

    public Relatorio buscarPorId(int id) {
        for (Relatorio relatorio : relatorios) {
            if (relatorio.getId() == id) {
                return relatorio;
            }
        }
        return null;
    }

    public boolean removerRelatorio(int id) {
        return relatorios.removeIf(r -> r.getId() == id);
    }
}
