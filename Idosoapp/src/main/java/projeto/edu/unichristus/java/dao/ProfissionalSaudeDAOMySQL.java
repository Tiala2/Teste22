package projeto.edu.unichristus.java.dao;

import projeto.edu.unichristus.java.model.ProfissionalSaude;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.util.Properties;

public class ProfissionalSaudeDAOMySQL {
    private String url;
    private String user;
    private String password;

    public ProfissionalSaudeDAOMySQL() {
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

    public void salvar(ProfissionalSaude prof) {
        String sql = "INSERT INTO profissional_saude (nome, especialidade, registro_profissional) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prof.getNome());
            stmt.setString(2, prof.getEspecialidade());
            stmt.setString(3, prof.getRegistroProfissional());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ProfissionalSaude> listarTodos() {
        List<ProfissionalSaude> lista = new ArrayList<>();
        String sql = "SELECT * FROM profissional_saude";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ProfissionalSaude prof = new ProfissionalSaude(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("especialidade"),
                    rs.getString("registro_profissional")
                );
                lista.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public ProfissionalSaude buscarPorId(int id) {
        String sql = "SELECT * FROM profissional_saude WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ProfissionalSaude(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("especialidade"),
                        rs.getString("registro_profissional")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM profissional_saude WHERE id = ?";
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
