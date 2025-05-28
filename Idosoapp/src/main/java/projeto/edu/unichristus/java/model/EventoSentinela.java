package projeto.edu.unichristus.java.model;

import java.time.LocalDate;

public class EventoSentinela {
    private int id;
    private String tipo;
    private LocalDate dataOcorrencia;

    public EventoSentinela() {}

    public EventoSentinela(int id, String tipo, LocalDate dataOcorrencia) {
        this.id = id;
        this.tipo = tipo;
        this.dataOcorrencia = dataOcorrencia;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public LocalDate getDataOcorrencia() { return dataOcorrencia; }
    public void setDataOcorrencia(LocalDate dataOcorrencia) { this.dataOcorrencia = dataOcorrencia; }
}