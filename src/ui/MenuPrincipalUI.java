package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPrincipalUI extends JFrame {
    public MenuPrincipalUI() {
        super("Menu Principal - Sistema RSC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1, 10, 10));

        JButton btnIdosa = new JButton("Cadastro de Idosa");
        JButton btnConsulta = new JButton("Cadastro de Consulta");
        JButton btnExame = new JButton("Cadastro de Exame");
        JButton btnVacina = new JButton("Cadastro de Vacina");
        JButton btnProntuario = new JButton("Cadastro de Prontuário Médico");
        JButton btnEvento = new JButton("Cadastro de Evento Sentinela");
        JButton btnListIdosa = new JButton("Listagem de Idosas");
        JButton btnListConsulta = new JButton("Listagem de Consultas");
        JButton btnListExame = new JButton("Listagem de Exames");
        JButton btnListVacina = new JButton("Listagem de Vacinas");
        JButton btnListProntuario = new JButton("Listagem de Prontuários");
        JButton btnListEvento = new JButton("Listagem de Eventos Sentinela");

        btnIdosa.addActionListener((ActionEvent e) -> new CadastroIdosaUI());
        btnConsulta.addActionListener((ActionEvent e) -> new CadastroConsultaUI());
        btnExame.addActionListener((ActionEvent e) -> new CadastroExameUI());
        btnVacina.addActionListener((ActionEvent e) -> new CadastroVacinaUI());
        btnProntuario.addActionListener((ActionEvent e) -> new CadastroProntuarioUI());
        btnEvento.addActionListener((ActionEvent e) -> new CadastroEventoSentinelaUI());
        btnListIdosa.addActionListener((ActionEvent e) -> new ListagemIdosaUI());
        btnListConsulta.addActionListener((ActionEvent e) -> new ListagemConsultaUI());
        btnListExame.addActionListener((ActionEvent e) -> new ListagemExameUI());
        btnListVacina.addActionListener((ActionEvent e) -> new ListagemVacinaUI());
        btnListProntuario.addActionListener((ActionEvent e) -> new ListagemProntuarioUI());
        btnListEvento.addActionListener((ActionEvent e) -> new ListagemEventoSentinelaUI());

        add(btnIdosa);
        add(btnConsulta);
        add(btnExame);
        add(btnVacina);
        add(btnProntuario);
        add(btnEvento);
        add(btnListIdosa);
        add(btnListConsulta);
        add(btnListExame);
        add(btnListVacina);
        add(btnListProntuario);
        add(btnListEvento);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipalUI().setVisible(true));
    }
}
