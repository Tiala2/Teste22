package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para operações de persistência de Evento Sentinela.
 * Fornece métodos para inserir, listar, buscar, atualizar e remover eventos sentinela no banco de dados.
 * Utiliza JDBC e SQLite por padrão.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class EventoSentinelaDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:banco_rsc.db");
    }

    public void inserir(EventoSentinela evento) throws SQLException {
        String sql = "INSERT INTO evento_sentinela (idosa_cpf, data, tipo, descricao) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, evento.getIdosaCpf());
            stmt.setString(2, evento.getData());
            stmt.setString(3, evento.getTipo());
            stmt.setString(4, evento.getDescricao());
            stmt.executeUpdate();
        }
    }

    public List<EventoSentinela> listarTodos() throws SQLException {
        List<EventoSentinela> eventos = new ArrayList<>();
        String sql = "SELECT * FROM evento_sentinela";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                EventoSentinela e = new EventoSentinela(
                    rs.getString("idosa_cpf"),
                    rs.getString("data"),
                    rs.getString("tipo"),
                    rs.getString("descricao")
                );
                eventos.add(e);
            }
        }
        return eventos;
    }

    public EventoSentinela buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM evento_sentinela WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new EventoSentinela(
                        rs.getString("idosa_cpf"),
                        rs.getString("data"),
                        rs.getString("tipo"),
                        rs.getString("descricao")
                    );
                }
            }
        }
        return null;
    }

    public void atualizar(int id, EventoSentinela evento) throws SQLException {
        String sql = "UPDATE evento_sentinela SET idosa_cpf=?, data=?, tipo=?, descricao=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, evento.getIdosaCpf());
            stmt.setString(2, evento.getData());
            stmt.setString(3, evento.getTipo());
            stmt.setString(4, evento.getDescricao());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM evento_sentinela WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
