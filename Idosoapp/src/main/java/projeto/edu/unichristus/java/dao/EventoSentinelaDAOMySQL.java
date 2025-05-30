package projeto.edu.unichristus.java.dao;

import projeto.edu.unichristus.java.model.EventoSentinela;
import projeto.edu.unichristus.java.model.TipoEventoSentinela;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.util.Properties;

public class EventoSentinelaDAOMySQL {
    private String url;
    private String user;
    private String password;

    public EventoSentinelaDAOMySQL() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            url = prop.getProperty("db.url");
            user = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void salvar(EventoSentinela evento, int prontuarioId) {
        String sql = "INSERT INTO evento_sentinela (tipo, data_ocorrencia, prontuario_id) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, evento.getTipo().name());
            stmt.setDate(2, evento.getDataOcorrencia() != null ? Date.valueOf(evento.getDataOcorrencia()) : null);
            stmt.setInt(3, prontuarioId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<EventoSentinela> listarTodos() {
        List<EventoSentinela> lista = new ArrayList<>();
        String sql = "SELECT * FROM evento_sentinela";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                EventoSentinela evento = new EventoSentinela(
                    rs.getInt("id"),
                    TipoEventoSentinela.valueOf(rs.getString("tipo")),
                    rs.getDate("data_ocorrencia") != null ? rs.getDate("data_ocorrencia").toLocalDate() : null
                );
                lista.add(evento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public EventoSentinela buscarPorId(int id) {
        String sql = "SELECT * FROM evento_sentinela WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new EventoSentinela(
                        rs.getInt("id"),
                        TipoEventoSentinela.valueOf(rs.getString("tipo")),
                        rs.getDate("data_ocorrencia") != null ? rs.getDate("data_ocorrencia").toLocalDate() : null
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM evento_sentinela WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<EventoSentinela> listarPorIdosaEPeriodo(int prontuarioId, int mes, int ano) {
        List<EventoSentinela> lista = new ArrayList<>();
        String sql = "SELECT * FROM evento_sentinela WHERE prontuario_id = ? AND MONTH(data_ocorrencia) = ? AND YEAR(data_ocorrencia) = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, prontuarioId);
            stmt.setInt(2, mes);
            stmt.setInt(3, ano);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    EventoSentinela evento = new EventoSentinela(
                        rs.getInt("id"),
                        TipoEventoSentinela.valueOf(rs.getString("tipo")),
                        rs.getDate("data_ocorrencia") != null ? rs.getDate("data_ocorrencia").toLocalDate() : null
                    );
                    lista.add(evento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<EventoSentinela> listarPorTipoEPeriodo(TipoEventoSentinela tipo, int mes, int ano) {
        List<EventoSentinela> lista = new ArrayList<>();
        String sql = "SELECT * FROM evento_sentinela WHERE tipo = ? AND MONTH(data_ocorrencia) = ? AND YEAR(data_ocorrencia) = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipo.name());
            stmt.setInt(2, mes);
            stmt.setInt(3, ano);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    EventoSentinela evento = new EventoSentinela(
                        rs.getInt("id"),
                        tipo,
                        rs.getDate("data_ocorrencia") != null ? rs.getDate("data_ocorrencia").toLocalDate() : null
                    );
                    lista.add(evento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
