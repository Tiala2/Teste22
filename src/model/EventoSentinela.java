package model;

/**
 * Classe de domínio para Evento Sentinela.
 * Representa um evento adverso ou incidente relevante envolvendo uma idosa.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class EventoSentinela {
    private String idosaCpf;
    private String data;
    private String tipo;
    private String descricao;

    public EventoSentinela(String idosaCpf, String data, String tipo, String descricao) {
        this.idosaCpf = idosaCpf;
        this.data = data;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getIdosaCpf() { return idosaCpf; }
    public String getData() { return data; }
    public String getTipo() { return tipo; }
    public String getDescricao() { return descricao; }

    public void setIdosaCpf(String idosaCpf) { this.idosaCpf = idosaCpf; }
    public void setData(String data) { this.data = data; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
