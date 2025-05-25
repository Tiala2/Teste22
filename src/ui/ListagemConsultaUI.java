package ui;

import model.Consulta;
import model.ConsultaDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Tela de listagem de consultas cadastradas.
 * Permite buscar consultas por CPF da idosa e visualizar todas as consultas registradas.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class ListagemConsultaUI extends JFrame {
    private JTextField cpfBuscaField;
    private JButton buscarButton;
    private JTable tabelaConsultas;
    private DefaultTableModel tableModel;
    private ConsultaDAO consultaDAO;

    public ListagemConsultaUI() {
        super("Listagem de Consultas");
        consultaDAO = new ConsultaDAO();
        inicializarComponentes();
        configurarLayout();
        configurarListeners();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        carregarConsultas("");
    }

    private void inicializarComponentes() {
        cpfBuscaField = new JTextField(14);
        buscarButton = new JButton("Buscar por CPF");
        tableModel = new DefaultTableModel(new Object[]{"CPF", "Data", "Médico", "Especialidade"}, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaConsultas = new JTable(tableModel);
    }

    private void configurarLayout() {
        setLayout(new BorderLayout());
        JPanel topo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topo.add(new JLabel("CPF da Idosa:"));
        topo.add(cpfBuscaField);
        topo.add(buscarButton);
        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabelaConsultas), BorderLayout.CENTER);
    }

    private void configurarListeners() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarConsultas(cpfBuscaField.getText().trim());
            }
        });
    }

    private void carregarConsultas(String cpf) {
        try {
            tableModel.setRowCount(0);
            List<Consulta> consultas = consultaDAO.listarTodas();
            for (Consulta c : consultas) {
                if (cpf.isEmpty() || c.getIdosaCpf().equals(cpf)) {
                    tableModel.addRow(new Object[]{c.getIdosaCpf(), c.getData(), c.getMedico(), c.getEspecialidade()});
                }
            }
            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Nenhuma consulta encontrada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar consultas: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
