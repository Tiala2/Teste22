package projeto.edu.unichristus.java.model;

import java.time.LocalDate;

public class Idosa {
    private int id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String nomeMae;
    private String cartaoSUS;
    private LocalDate dataEntrada;

    public Idosa() {}

    public Idosa(int id, String nome, String cpf, LocalDate dataNascimento, String nomeMae, String cartaoSUS, LocalDate dataEntrada) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.nomeMae = nomeMae;
        this.cartaoSUS = cartaoSUS;
        this.dataEntrada = dataEntrada;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getNomeMae() { return nomeMae; }
    public void setNomeMae(String nomeMae) { this.nomeMae = nomeMae; }
    public String getCartaoSUS() { return cartaoSUS; }
    public void setCartaoSUS(String cartaoSUS) { this.cartaoSUS = cartaoSUS; }
    public LocalDate getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }
}
