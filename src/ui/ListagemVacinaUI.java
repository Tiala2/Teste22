package ui;

import model.Vacina;
import model.VacinaDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Tela de listagem de vacinas cadastradas.
 * Permite buscar vacinas por CPF da idosa e visualizar todas as vacinas registradas.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class ListagemVacinaUI extends JFrame {
    private JTextField cpfBuscaField;
    private JButton buscarButton;
    private JTable tabelaVacinas;
    private DefaultTableModel tableModel;
    private VacinaDAO vacinaDAO;

    public ListagemVacinaUI() {
        super("Listagem de Vacinas");
        vacinaDAO = new VacinaDAO();
        inicializarComponentes();
        configurarLayout();
        configurarListeners();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        carregarVacinas("");
    }

    private void inicializarComponentes() {
        cpfBuscaField = new JTextField(14);
        buscarButton = new JButton("Buscar por CPF");
        tableModel = new DefaultTableModel(new Object[]{"CPF", "Data", "Tipo", "Lote"}, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaVacinas = new JTable(tableModel);
    }

    private void configurarLayout() {
        setLayout(new BorderLayout());
        JPanel topo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topo.add(new JLabel("CPF da Idosa:"));
        topo.add(cpfBuscaField);
        topo.add(buscarButton);
        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabelaVacinas), BorderLayout.CENTER);
    }

    private void configurarListeners() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarVacinas(cpfBuscaField.getText().trim());
            }
        });
    }

    private void carregarVacinas(String cpf) {
        try {
            tableModel.setRowCount(0);
            List<Vacina> vacinas = vacinaDAO.listarTodas();
            for (Vacina v : vacinas) {
                if (cpf.isEmpty() || v.getIdosaCpf().equals(cpf)) {
                    tableModel.addRow(new Object[]{v.getIdosaCpf(), v.getData(), v.getTipo(), v.getLote()});
                }
            }
            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Nenhuma vacina encontrada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar vacinas: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
