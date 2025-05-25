package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.ProntuarioMedicoController;
import model.ProntuarioMedico;

/**
 * Tela de cadastro de prontuário médico.
 * Permite registrar o histórico médico de uma idosa.
 * Inclui validação de campos, feedback visual e integração com o controller.
 *
 * Validações:
 *  - Nenhum campo pode ser vazio
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class CadastroProntuarioUI extends JFrame {
    private JTextField idosaCpfField;
    private JTextArea historicoArea;
    private JButton salvarButton;
    private JButton voltarButton;
    private ProntuarioMedicoController controller;

    public CadastroProntuarioUI() {
        super("Cadastro de Prontuário Médico");
        controller = new ProntuarioMedicoController();
        inicializarComponentes();
        configurarLayout();
        configurarListeners();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarComponentes() {
        idosaCpfField = new JTextField(14);
        historicoArea = new JTextArea(5, 25);
        historicoArea.setLineWrap(true);
        historicoArea.setWrapStyleWord(true);
        salvarButton = new JButton("Salvar");
        voltarButton = new JButton("Voltar");
    }

    private void configurarLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titulo = new JLabel("Cadastro de Prontuário Médico");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titulo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("CPF da Idosa:"), gbc);
        gbc.gridx = 1;
        add(idosaCpfField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        gbc.anchor = GridBagConstraints.NORTH;
        add(new JLabel("Histórico Médico:"), gbc);
        gbc.gridx = 1;
        JScrollPane scroll = new JScrollPane(historicoArea);
        add(scroll, gbc);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2;
        JPanel botoes = new JPanel();
        botoes.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        botoes.add(salvarButton);
        botoes.add(voltarButton);
        add(botoes, gbc);
    }

    private void configurarListeners() {
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cpf = idosaCpfField.getText().trim();
                    String historico = historicoArea.getText().trim();
                    if (cpf.isEmpty() || historico.isEmpty()) {
                        throw new IllegalArgumentException("Preencha todos os campos.");
                    }
                    ProntuarioMedico prontuario = new ProntuarioMedico(cpf, historico);
                    controller.cadastrarProntuario(prontuario);
                    JOptionPane.showMessageDialog(CadastroProntuarioUI.this, "Prontuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(CadastroProntuarioUI.this, ex.getMessage(), "Erro de validação", JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(CadastroProntuarioUI.this, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        voltarButton.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroProntuarioUI().setVisible(true));
    }
}
