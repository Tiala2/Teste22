package model;

/**
 * Classe de domínio para Exame.
 * Representa um exame realizado por uma idosa, incluindo tipo, data e resultado.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class Exame {
    private String idosaCpf;
    private String data;
    private String tipo;
    private String resultado;

    public Exame(String idosaCpf, String data, String tipo, String resultado) {
        this.idosaCpf = idosaCpf;
        this.data = data;
        this.tipo = tipo;
        this.resultado = resultado;
    }

    public String getIdosaCpf() { return idosaCpf; }
    public String getData() { return data; }
    public String getTipo() { return tipo; }
    public String getResultado() { return resultado; }

    public void setIdosaCpf(String idosaCpf) { this.idosaCpf = idosaCpf; }
    public void setData(String data) { this.data = data; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setResultado(String resultado) { this.resultado = resultado; }
}
