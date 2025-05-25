package ui;

import model.ProntuarioMedico;
import model.ProntuarioMedicoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Tela de listagem de prontuários médicos cadastrados.
 * Permite buscar prontuários por CPF da idosa e visualizar todos os registros.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class ListagemProntuarioUI extends JFrame {
    private JTextField cpfBuscaField;
    private JButton buscarButton;
    private JTable tabelaProntuarios;
    private DefaultTableModel tableModel;
    private ProntuarioMedicoDAO prontuarioDAO;

    public ListagemProntuarioUI() {
        super("Listagem de Prontuários Médicos");
        prontuarioDAO = new ProntuarioMedicoDAO();
        inicializarComponentes();
        configurarLayout();
        configurarListeners();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        carregarProntuarios("");
    }

    private void inicializarComponentes() {
        cpfBuscaField = new JTextField(14);
        buscarButton = new JButton("Buscar por CPF");
        tableModel = new DefaultTableModel(new Object[]{"CPF", "Histórico Médico"}, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaProntuarios = new JTable(tableModel);
    }

    private void configurarLayout() {
        setLayout(new BorderLayout());
        JPanel topo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topo.add(new JLabel("CPF da Idosa:"));
        topo.add(cpfBuscaField);
        topo.add(buscarButton);
        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabelaProntuarios), BorderLayout.CENTER);
    }

    private void configurarListeners() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarProntuarios(cpfBuscaField.getText().trim());
            }
        });
    }

    private void carregarProntuarios(String cpf) {
        try {
            tableModel.setRowCount(0);
            List<ProntuarioMedico> prontuarios = prontuarioDAO.listarTodos();
            for (ProntuarioMedico p : prontuarios) {
                if (cpf.isEmpty() || p.getIdosaCpf().equals(cpf)) {
                    tableModel.addRow(new Object[]{p.getIdosaCpf(), p.getHistorico()});
                }
            }
            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Nenhum prontuário encontrado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar prontuários: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
