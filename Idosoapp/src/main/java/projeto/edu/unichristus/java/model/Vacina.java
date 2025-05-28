package projeto.edu.unichristus.java.model;

import java.time.LocalDate;

public class Vacina {
    private int id;
    private String nome;
    private LocalDate dataOcorrencia;

    public Vacina() {}

    public Vacina(int id, String nome, LocalDate dataOcorrencia) {
        this.id = id;
        this.nome = nome;
        this.dataOcorrencia = dataOcorrencia;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public LocalDate getDataOcorrencia() { return dataOcorrencia; }
    public void setDataOcorrencia(LocalDate dataOcorrencia) { this.dataOcorrencia = dataOcorrencia; }
}