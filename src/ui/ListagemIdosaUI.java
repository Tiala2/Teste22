package ui;

import model.Idosa;
import model.IdosaDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Tela de listagem de idosas cadastradas.
 * Permite buscar idosas por CPF e visualizar todas as residentes.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class ListagemIdosaUI extends JFrame {
    private JTextField cpfBuscaField;
    private JButton buscarButton;
    private JTable tabelaIdosas;
    private DefaultTableModel tableModel;
    private IdosaDAO idosaDAO;

    public ListagemIdosaUI() {
        super("Listagem de Idosas");
        idosaDAO = new IdosaDAO();
        inicializarComponentes();
        configurarLayout();
        configurarListeners();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        carregarIdosas("");
    }

    private void inicializarComponentes() {
        cpfBuscaField = new JTextField(14);
        buscarButton = new JButton("Buscar por CPF");
        tableModel = new DefaultTableModel(new Object[]{"Nome", "CPF", "Data Nasc."}, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaIdosas = new JTable(tableModel);
    }

    private void configurarLayout() {
        setLayout(new BorderLayout());
        JPanel topo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topo.add(new JLabel("CPF da Idosa:"));
        topo.add(cpfBuscaField);
        topo.add(buscarButton);
        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabelaIdosas), BorderLayout.CENTER);
    }

    private void configurarListeners() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarIdosas(cpfBuscaField.getText().trim());
            }
        });
    }

    private void carregarIdosas(String cpf) {
        try {
            tableModel.setRowCount(0);
            List<Idosa> idosas = idosaDAO.listarTodas();
            for (Idosa i : idosas) {
                if (cpf.isEmpty() || i.getCpf().equals(cpf)) {
                    tableModel.addRow(new Object[]{i.getNome(), i.getCpf(), i.getDataNascimento()});
                }
            }
            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Nenhuma idosa encontrada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar idosas: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
