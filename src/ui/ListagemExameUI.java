package ui;

import model.Exame;
import model.ExameDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Tela de listagem de exames cadastrados.
 * Permite buscar exames por CPF da idosa e visualizar todos os exames registrados.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class ListagemExameUI extends JFrame {
    private JTextField cpfBuscaField;
    private JButton buscarButton;
    private JTable tabelaExames;
    private DefaultTableModel tableModel;
    private ExameDAO exameDAO;

    public ListagemExameUI() {
        super("Listagem de Exames");
        exameDAO = new ExameDAO();
        inicializarComponentes();
        configurarLayout();
        configurarListeners();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        carregarExames("");
    }

    private void inicializarComponentes() {
        cpfBuscaField = new JTextField(14);
        buscarButton = new JButton("Buscar por CPF");
        tableModel = new DefaultTableModel(new Object[]{"CPF", "Data", "Tipo", "Resultado"}, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaExames = new JTable(tableModel);
    }

    private void configurarLayout() {
        setLayout(new BorderLayout());
        JPanel topo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topo.add(new JLabel("CPF da Idosa:"));
        topo.add(cpfBuscaField);
        topo.add(buscarButton);
        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabelaExames), BorderLayout.CENTER);
    }

    private void configurarListeners() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarExames(cpfBuscaField.getText().trim());
            }
        });
    }

    private void carregarExames(String cpf) {
        try {
            tableModel.setRowCount(0);
            List<Exame> exames = exameDAO.listarTodos();
            for (Exame ex : exames) {
                if (cpf.isEmpty() || ex.getIdosaCpf().equals(cpf)) {
                    tableModel.addRow(new Object[]{ex.getIdosaCpf(), ex.getData(), ex.getTipo(), ex.getResultado()});
                }
            }
            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Nenhum exame encontrado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar exames: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
