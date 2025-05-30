package projeto.edu.unichristus.java.controller;

import projeto.edu.unichristus.java.model.Prescricao;
import projeto.edu.unichristus.java.dao.PrescricaoDAOMySQL;
import java.util.List;

public class PrescricaoController {
    private PrescricaoDAOMySQL prescricaoDAO;

    public PrescricaoController() {
        this.prescricaoDAO = new PrescricaoDAOMySQL();
    }

    public void adicionarPrescricao(Prescricao prescricao, int prontuarioId) {
        try {
            prescricaoDAO.salvar(prescricao, prontuarioId);
        } catch (Exception e) {
            System.err.println("Erro ao adicionar prescrição: " + e.getMessage());
        }
    }

    public List<Prescricao> listarPrescricoes() {
        try {
            return prescricaoDAO.listarTodos();
        } catch (Exception e) {
            System.err.println("Erro ao listar prescrições: " + e.getMessage());
            return null;
        }
    }

    public Prescricao buscarPorId(int id) {
        try {
            return prescricaoDAO.buscarPorId(id);
        } catch (Exception e) {
            System.err.println("Erro ao buscar prescrição: " + e.getMessage());
            return null;
        }
    }

    public boolean removerPrescricao(int id) {
        try {
            return prescricaoDAO.remover(id);
        } catch (Exception e) {
            System.err.println("Erro ao remover prescrição: " + e.getMessage());
            return false;
        }
    }
}
