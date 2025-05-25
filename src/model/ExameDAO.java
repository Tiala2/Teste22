package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para operações de persistência de Exame.
 * Fornece métodos para inserir, listar, buscar, atualizar e remover exames no banco de dados.
 * Utiliza JDBC e SQLite por padrão.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class ExameDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:banco_rsc.db");
    }

    public void inserir(Exame exame) throws SQLException {
        String sql = "INSERT INTO exame (idosa_cpf, data, tipo, resultado) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, exame.getIdosaCpf());
            stmt.setString(2, exame.getData());
            stmt.setString(3, exame.getTipo());
            stmt.setString(4, exame.getResultado());
            stmt.executeUpdate();
        }
    }

    public List<Exame> listarTodos() throws SQLException {
        List<Exame> exames = new ArrayList<>();
        String sql = "SELECT * FROM exame";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Exame e = new Exame(
                    rs.getString("idosa_cpf"),
                    rs.getString("data"),
                    rs.getString("tipo"),
                    rs.getString("resultado")
                );
                exames.add(e);
            }
        }
        return exames;
    }

    public Exame buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM exame WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Exame(
                        rs.getString("idosa_cpf"),
                        rs.getString("data"),
                        rs.getString("tipo"),
                        rs.getString("resultado")
                    );
                }
            }
        }
        return null;
    }

    public void atualizar(int id, Exame exame) throws SQLException {
        String sql = "UPDATE exame SET idosa_cpf=?, data=?, tipo=?, resultado=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, exame.getIdosaCpf());
            stmt.setString(2, exame.getData());
            stmt.setString(3, exame.getTipo());
            stmt.setString(4, exame.getResultado());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM exame WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
