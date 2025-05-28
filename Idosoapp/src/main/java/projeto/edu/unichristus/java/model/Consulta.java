package projeto.edu.unichristus.java.model;

import java.time.LocalDateTime;

public class Consulta {
    private int id;
    private LocalDateTime dataHora;
    private ProfissionalSaude profissional;
    private String tipo;
    private String motivo;
    private String diagnostico;

    public Consulta() {}

    public Consulta(int id, LocalDateTime dataHora, ProfissionalSaude profissional, String tipo, String motivo, String diagnostico) {
        this.id = id;
        this.dataHora = dataHora;
        this.profissional = profissional;
        this.tipo = tipo;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public ProfissionalSaude getProfissional() { return profissional; }
    public void setProfissional(ProfissionalSaude profissional) { this.profissional = profissional; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }
}
