package projeto.edu.unichristus.java.controller;

import projeto.edu.unichristus.java.model.Relatorio;
import projeto.edu.unichristus.java.dao.RelatorioDAOMySQL;
import projeto.edu.unichristus.java.model.TipoEventoSentinela;
import projeto.edu.unichristus.java.dao.EventoSentinelaDAOMySQL;
import java.util.List;
import java.util.Map;

public class RelatorioController {
    private RelatorioDAOMySQL relatorioDAO;

    public RelatorioController() {
        this.relatorioDAO = new RelatorioDAOMySQL();
    }

    public void adicionarRelatorio(Relatorio relatorio, int prontuarioId) {
        try {
            relatorioDAO.salvar(relatorio, prontuarioId);
        } catch (Exception e) {
            System.err.println("Erro ao adicionar relatório: " + e.getMessage());
        }
    }

    public List<Relatorio> listarRelatorios() {
        try {
            return relatorioDAO.listarTodos();
        } catch (Exception e) {
            System.err.println("Erro ao listar relatórios: " + e.getMessage());
            return null;
        }
    }

    public Relatorio buscarPorId(int id) {
        try {
            return relatorioDAO.buscarPorId(id);
        } catch (Exception e) {
            System.err.println("Erro ao buscar relatório: " + e.getMessage());
            return null;
        }
    }

    public boolean removerRelatorio(int id) {
        try {
            return relatorioDAO.remover(id);
        } catch (Exception e) {
            System.err.println("Erro ao remover relatório: " + e.getMessage());
            return false;
        }
    }

    public Map<TipoEventoSentinela, Double> percentualIdosasPorEvento(List<Integer> idsIdosas, int mes, int ano, EventoSentinelaDAOMySQL eventoDAO) {
        return relatorioDAO.percentualIdosasPorEvento(idsIdosas, mes, ano, eventoDAO);
    }
}
