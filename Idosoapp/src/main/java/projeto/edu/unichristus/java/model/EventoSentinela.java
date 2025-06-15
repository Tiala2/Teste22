package projeto.edu.unichristus.java.model;

import java.time.LocalDate;

public class EventoSentinela {
    private int id;
    private TipoEventoSentinela tipo;
    private LocalDate dataOcorrencia;

    public EventoSentinela() {}

    public EventoSentinela(int id, TipoEventoSentinela tipo, LocalDate dataOcorrencia) {
        this.id = id;
        this.tipo = tipo;
        this.dataOcorrencia = dataOcorrencia;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public TipoEventoSentinela getTipo() { return tipo; }
    public void setTipo(TipoEventoSentinela tipo) { this.tipo = tipo; }
    public LocalDate getDataOcorrencia() { return dataOcorrencia; }
    public void setDataOcorrencia(LocalDate dataOcorrencia) { this.dataOcorrencia = dataOcorrencia; }
}