package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para operações de persistência de Prontuário Médico.
 * Fornece métodos para inserir, listar, buscar, atualizar e remover prontuários médicos no banco de dados.
 * Utiliza JDBC e SQLite por padrão.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class ProntuarioMedicoDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:banco_rsc.db");
    }

    public void inserir(ProntuarioMedico prontuario) throws SQLException {
        String sql = "INSERT INTO prontuario_medico (idosa_cpf, historico) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prontuario.getIdosaCpf());
            stmt.setString(2, prontuario.getHistorico());
            stmt.executeUpdate();
        }
    }

    public List<ProntuarioMedico> listarTodos() throws SQLException {
        List<ProntuarioMedico> prontuarios = new ArrayList<>();
        String sql = "SELECT * FROM prontuario_medico";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ProntuarioMedico p = new ProntuarioMedico(
                    rs.getString("idosa_cpf"),
                    rs.getString("historico")
                );
                prontuarios.add(p);
            }
        }
        return prontuarios;
    }

    public ProntuarioMedico buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM prontuario_medico WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ProntuarioMedico(
                        rs.getString("idosa_cpf"),
                        rs.getString("historico")
                    );
                }
            }
        }
        return null;
    }

    public void atualizar(int id, ProntuarioMedico prontuario) throws SQLException {
        String sql = "UPDATE prontuario_medico SET idosa_cpf=?, historico=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prontuario.getIdosaCpf());
            stmt.setString(2, prontuario.getHistorico());
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM prontuario_medico WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
