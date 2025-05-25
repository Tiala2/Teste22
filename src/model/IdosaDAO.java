package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para operações de persistência de Idosa.
 * Fornece métodos para inserir, listar, buscar, atualizar e remover idosas no banco de dados.
 * Utiliza JDBC e SQLite por padrão.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class IdosaDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:banco_rsc.db");
    }

    public void inserir(Idosa idosa) throws SQLException {
        String sql = "INSERT INTO idosa (nome, cpf, data_nascimento) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idosa.getNome());
            stmt.setString(2, idosa.getCpf());
            stmt.setString(3, idosa.getDataNascimento());
            stmt.executeUpdate();
        }
    }

    public List<Idosa> listarTodas() throws SQLException {
        List<Idosa> idosas = new ArrayList<>();
        String sql = "SELECT * FROM idosa";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Idosa i = new Idosa(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("data_nascimento")
                );
                idosas.add(i);
            }
        }
        return idosas;
    }

    public Idosa buscarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM idosa WHERE cpf = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Idosa(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("data_nascimento")
                    );
                }
            }
        }
        return null;
    }

    public void atualizar(String cpf, Idosa idosa) throws SQLException {
        String sql = "UPDATE idosa SET nome=?, data_nascimento=? WHERE cpf=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idosa.getNome());
            stmt.setString(2, idosa.getDataNascimento());
            stmt.setString(3, cpf);
            stmt.executeUpdate();
        }
    }

    public void remover(String cpf) throws SQLException {
        String sql = "DELETE FROM idosa WHERE cpf = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        }
    }
}
