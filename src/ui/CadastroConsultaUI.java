import java.time.LocalDateTime;

public interface Consulta {
    // Atributos
    LocalDateTime getDataHora();
    void setDataHora(LocalDateTime dataHora);

    ProfissionalSaude getProfissionalResponsavel();
    void setProfissionalResponsavel(ProfissionalSaude profissional);

    String getTipo(); // ex: rotina, emergência, especializada
    void setTipo(String tipo);

    String getMotivoConsulta();
    void setMotivoConsulta(String motivo);

    String getDiagnostico(); // Ex: CID-10
    void setDiagnostico(String cid10);

    String getAnotacoesProfissional();
    void setAnotacoesProfissional(String anotacoes);

    // Métodos
    void registrarDiagnostico(String cid10, String anotacoes);

    void gerarEncaminhamento(String tipoEncaminhamento, String detalhes);
}
