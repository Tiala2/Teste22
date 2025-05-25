package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para operações de persistência de Consulta.
 * Fornece métodos para inserir, listar, buscar, atualizar e remover consultas no banco de dados.
 * Utiliza JDBC e SQLite por padrão.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class ConsultaDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:banco_rsc.db");
    }

    public void inserir(Consulta consulta) throws SQLException {
        String sql = "INSERT INTO consulta (idosa_cpf, data, medico, especialidade) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, consulta.getIdosaCpf());
            stmt.setString(2, consulta.getData());
            stmt.setString(3, consulta.getMedico());
            stmt.setString(4, consulta.getEspecialidade());
            stmt.executeUpdate();
        }
    }

    public List<Consulta> listarTodas() throws SQLException {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM consulta";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Consulta c = new Consulta(
                    rs.getString("idosa_cpf"),
                    rs.getString("data"),
                    rs.getString("medico"),
                    rs.getString("especialidade")
                );
                consultas.add(c);
            }
        }
        return consultas;
    }

    public Consulta buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM consulta WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Consulta(
                        rs.getString("idosa_cpf"),
                        rs.getString("data"),
                        rs.getString("medico"),
                        rs.getString("especialidade")
                    );
                }
            }
        }
        return null;
    }

    public void atualizar(int id, Consulta consulta) throws SQLException {
        String sql = "UPDATE consulta SET idosa_cpf=?, data=?, medico=?, especialidade=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, consulta.getIdosaCpf());
            stmt.setString(2, consulta.getData());
            stmt.setString(3, consulta.getMedico());
            stmt.setString(4, consulta.getEspecialidade());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM consulta WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
