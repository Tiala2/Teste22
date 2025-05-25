package ui;

import model.EventoSentinela;
import model.EventoSentinelaDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Tela de listagem de eventos sentinela cadastrados.
 * Permite buscar eventos por CPF da idosa e visualizar todos os registros.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class ListagemEventoSentinelaUI extends JFrame {
    private JTextField cpfBuscaField;
    private JButton buscarButton;
    private JTable tabelaEventos;
    private DefaultTableModel tableModel;
    private EventoSentinelaDAO eventoDAO;

    public ListagemEventoSentinelaUI() {
        super("Listagem de Eventos Sentinela");
        eventoDAO = new EventoSentinelaDAO();
        inicializarComponentes();
        configurarLayout();
        configurarListeners();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        carregarEventos("");
    }

    private void inicializarComponentes() {
        cpfBuscaField = new JTextField(14);
        buscarButton = new JButton("Buscar por CPF");
        tableModel = new DefaultTableModel(new Object[]{"CPF", "Data", "Tipo", "Descrição"}, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaEventos = new JTable(tableModel);
    }

    private void configurarLayout() {
        setLayout(new BorderLayout());
        JPanel topo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topo.add(new JLabel("CPF da Idosa:"));
        topo.add(cpfBuscaField);
        topo.add(buscarButton);
        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabelaEventos), BorderLayout.CENTER);
    }

    private void configurarListeners() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarEventos(cpfBuscaField.getText().trim());
            }
        });
    }

    private void carregarEventos(String cpf) {
        try {
            tableModel.setRowCount(0);
            List<EventoSentinela> eventos = eventoDAO.listarTodos();
            for (EventoSentinela ev : eventos) {
                if (cpf.isEmpty() || ev.getIdosaCpf().equals(cpf)) {
                    tableModel.addRow(new Object[]{ev.getIdosaCpf(), ev.getData(), ev.getTipo(), ev.getDescricao()});
                }
            }
            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Nenhum evento encontrado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar eventos: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
