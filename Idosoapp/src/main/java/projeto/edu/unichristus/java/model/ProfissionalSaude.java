package projeto.edu.unichristus.java.model;

public class ProfissionalSaude {
    private int id;
    private String nome;
    private String especialidade;
    private String registroProfissional;

    public ProfissionalSaude() {}

    public ProfissionalSaude(int id, String nome, String especialidade, String registroProfissional) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public String getRegistroProfissional() { return registroProfissional; }
    public void setRegistroProfissional(String registroProfissional) { this.registroProfissional = registroProfissional; }
}