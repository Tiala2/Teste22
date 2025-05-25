package model;

/**
 * Classe de domínio para Vacina.
 * Representa uma vacina aplicada em uma idosa, com informações de lote, tipo e data.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class Vacina {
    private String idosaCpf;
    private String data;
    private String tipo;
    private String lote;

    public Vacina(String idosaCpf, String data, String tipo, String lote) {
        this.idosaCpf = idosaCpf;
        this.data = data;
        this.tipo = tipo;
        this.lote = lote;
    }

    public String getIdosaCpf() { return idosaCpf; }
    public String getData() { return data; }
    public String getTipo() { return tipo; }
    public String getLote() { return lote; }

    public void setIdosaCpf(String idosaCpf) { this.idosaCpf = idosaCpf; }
    public void setData(String data) { this.data = data; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setLote(String lote) { this.lote = lote; }
}
