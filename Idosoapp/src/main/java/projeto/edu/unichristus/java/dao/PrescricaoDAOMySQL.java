package projeto.edu.unichristus.java.dao;

import projeto.edu.unichristus.java.model.Prescricao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.util.Properties;

public class PrescricaoDAOMySQL {
    private String url;
    private String user;
    private String password;

    public PrescricaoDAOMySQL() {
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

    public void salvar(Prescricao prescricao, int prontuarioId) {
        String sql = "INSERT INTO prescricao (medicamento, posologia, duracao, observacoes, prontuario_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prescricao.getMedicamento());
            stmt.setString(2, prescricao.getPosologia());
            stmt.setString(3, prescricao.getDuracao());
            stmt.setString(4, prescricao.getObservacoes());
            stmt.setInt(5, prontuarioId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Prescricao> listarTodos() {
        List<Prescricao> lista = new ArrayList<>();
        String sql = "SELECT * FROM prescricao";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Prescricao prescricao = new Prescricao(
                    rs.getInt("id"),
                    rs.getString("medicamento"),
                    rs.getString("posologia"),
                    rs.getString("duracao"),
                    rs.getString("observacoes")
                );
                lista.add(prescricao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Prescricao buscarPorId(int id) {
        String sql = "SELECT * FROM prescricao WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Prescricao(
                        rs.getInt("id"),
                        rs.getString("medicamento"),
                        rs.getString("posologia"),
                        rs.getString("duracao"),
                        rs.getString("observacoes")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM prescricao WHERE id = ?";
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
}
