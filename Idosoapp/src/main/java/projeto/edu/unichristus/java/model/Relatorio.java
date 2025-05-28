package projeto.edu.unichristus.java.model;

public class Relatorio {
    // Exemplo de atributos para relatórios
    private int id;
    private String descricao;
    private String tipo;

    public Relatorio() {}

    public Relatorio(int id, String descricao, String tipo) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
