package projeto.edu.unichristus.java.model;

public class Prescricao {
    private int id;
    private String medicamento;
    private String posologia;
    private String duracao;
    private String observacoes;

    public Prescricao() {}

    public Prescricao(int id, String medicamento, String posologia, String duracao, String observacoes) {
        this.id = id;
        this.medicamento = medicamento;
        this.posologia = posologia;
        this.duracao = duracao;
        this.observacoes = observacoes;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMedicamento() { return medicamento; }
    public void setMedicamento(String medicamento) { this.medicamento = medicamento; }
    public String getPosologia() { return posologia; }
    public void setPosologia(String posologia) { this.posologia = posologia; }
    public String getDuracao() { return duracao; }
    public void setDuracao(String duracao) { this.duracao = duracao; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
