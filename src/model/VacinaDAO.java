package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para operações de persistência de Vacina.
 * Fornece métodos para inserir, listar, buscar, atualizar e remover vacinas no banco de dados.
 * Utiliza JDBC e SQLite por padrão.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class VacinaDAO {
    private Connection getConnection() throws SQLException {
        // Exemplo: ajuste a string de conexão conforme seu banco
        return DriverManager.getConnection("jdbc:sqlite:banco_rsc.db");
    }

    public void inserir(Vacina vacina) throws SQLException {
        String sql = "INSERT INTO vacina (idosa_cpf, data, tipo, lote) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vacina.getIdosaCpf());
            stmt.setString(2, vacina.getData());
            stmt.setString(3, vacina.getTipo());
            stmt.setString(4, vacina.getLote());
            stmt.executeUpdate();
        }
    }

    public List<Vacina> listarTodas() throws SQLException {
        List<Vacina> vacinas = new ArrayList<>();
        String sql = "SELECT * FROM vacina";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vacina v = new Vacina(
                    rs.getString("idosa_cpf"),
                    rs.getString("data"),
                    rs.getString("tipo"),
                    rs.getString("lote")
                );
                vacinas.add(v);
            }
        }
        return vacinas;
    }

    public Vacina buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM vacina WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Vacina(
                        rs.getString("idosa_cpf"),
                        rs.getString("data"),
                        rs.getString("tipo"),
                        rs.getString("lote")
                    );
                }
            }
        }
        return null;
    }

    public void atualizar(int id, Vacina vacina) throws SQLException {
        String sql = "UPDATE vacina SET idosa_cpf=?, data=?, tipo=?, lote=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vacina.getIdosaCpf());
            stmt.setString(2, vacina.getData());
            stmt.setString(3, vacina.getTipo());
            stmt.setString(4, vacina.getLote());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM vacina WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
