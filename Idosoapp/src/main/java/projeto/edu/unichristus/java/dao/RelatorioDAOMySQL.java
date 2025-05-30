package projeto.edu.unichristus.java.dao;

import projeto.edu.unichristus.java.model.Relatorio;
import projeto.edu.unichristus.java.model.TipoEventoSentinela;
import projeto.edu.unichristus.java.model.EventoSentinela;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.util.Properties;

public class RelatorioDAOMySQL {
    private String url;
    private String user;
    private String password;

    public RelatorioDAOMySQL() {
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

    public void salvar(Relatorio relatorio, int prontuarioId) {
        String sql = "INSERT INTO relatorio (descricao, tipo, prontuario_id) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, relatorio.getDescricao());
            stmt.setString(2, relatorio.getTipo());
            stmt.setInt(3, prontuarioId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Relatorio> listarTodos() {
        List<Relatorio> lista = new ArrayList<>();
        String sql = "SELECT * FROM relatorio";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Relatorio relatorio = new Relatorio(
                    rs.getInt("id"),
                    rs.getString("descricao"),
                    rs.getString("tipo")
                );
                lista.add(relatorio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Relatorio buscarPorId(int id) {
        String sql = "SELECT * FROM relatorio WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Relatorio(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("tipo")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM relatorio WHERE id = ?";
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

    public Map<TipoEventoSentinela, Double> percentualIdosasPorEvento(List<Integer> idsIdosas, int mes, int ano, EventoSentinelaDAOMySQL eventoDAO) {
        Map<TipoEventoSentinela, Integer> contagemPorTipo = new HashMap<>();
        Map<TipoEventoSentinela, Double> percentualPorTipo = new HashMap<>();
        int totalIdosas = idsIdosas.size();
        for (TipoEventoSentinela tipo : TipoEventoSentinela.values()) {
            int count = 0;
            for (Integer idProntuario : idsIdosas) {
                List<EventoSentinela> eventos = eventoDAO.listarPorTipoEPeriodo(tipo, mes, ano);
                boolean idosaTeveEvento = eventos.stream().anyMatch(e -> e.getId() == idProntuario);
                if (idosaTeveEvento) count++;
            }
            contagemPorTipo.put(tipo, count);
            percentualPorTipo.put(tipo, totalIdosas > 0 ? (count * 100.0) / totalIdosas : 0.0);
        }
        return percentualPorTipo;
    }
}
