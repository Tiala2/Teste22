package model;

/**
 * Classe de domínio para Idosa.
 * Representa uma idosa residente na casa de repouso.
 * Contém informações pessoais essenciais para cadastro e identificação.
 *
 * @author Equipe RSC
 * @since 2025-05-25
 */
public class Idosa {
    private String nome;
    private String cpf;
    private String dataNascimento;

    public Idosa(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getDataNascimento() { return dataNascimento; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
}
