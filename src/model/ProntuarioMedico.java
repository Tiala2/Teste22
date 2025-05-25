package model;

/**
 * Classe de domínio para Prontuário Médico.
 * Armazena o histórico médico de uma idosa.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class ProntuarioMedico {
    private String idosaCpf;
    private String historico;

    public ProntuarioMedico(String idosaCpf, String historico) {
        this.idosaCpf = idosaCpf;
        this.historico = historico;
    }

    public String getIdosaCpf() { return idosaCpf; }
    public String getHistorico() { return historico; }

    public void setIdosaCpf(String idosaCpf) { this.idosaCpf = idosaCpf; }
    public void setHistorico(String historico) { this.historico = historico; }
}
