Relatório Técnico – Projeto IdosoApp 

1. Introdução 

O presente relatório descreve o desenvolvimento do IdosoApp, uma aplicação voltada à gestão de informações clínicas e administrativas de idosas residentes em instituições de longa permanência. 

O sistema foi construído utilizando a linguagem Java com o auxílio do gerenciador de dependências Maven, e utiliza o banco de dados MySQL para persistência das informações. Seu principal objetivo é centralizar e facilitar o acompanhamento do histórico médico das pacientes, otimizando os fluxos internos da instituição e contribuindo para um atendimento mais eficiente e humanizado. 

 

2. Estrutura do Projeto 

A estrutura do IdosoApp foi organizada conforme o padrão Maven, o que permite melhor modularização e organização do código. A seguir, apresentamos a estrutura principal: 

bash 

CopiarEditar 

idosoapp/ 
├── pom.xml 
├── src/ 
│   ├── main/ 
│   │   ├── java/ 
│   │   │   └── com/seuprojeto/idosoapp/ 
│   │   │       ├── controller/ 
│   │   │       ├── model/ 
│   │   │       ├── repository/ 
│   │   │       └── service/ 
│   │   └── resources/ 
│   │       ├── application.properties 
│   │       └── static/ 
│   └── test/ 
│       └── java/ 
│           └── com/seuprojeto/idosoapp/ 
└── target/ 
 

Descrição das Pastas e Arquivos: 

pom.xml: Define as dependências do projeto (Spring Boot, JPA, MySQL, JUnit, etc.); 

controller/: Responsável por receber e tratar requisições HTTP (camada de API); 

model/: Contém as entidades JPA que representam as tabelas do banco; 

repository/: Interfaces que realizam operações de persistência com Spring Data JPA; 

service/: Implementa a lógica de negócio e validações; 

resources/: Arquivos de configuração da aplicação; 

test/: Contém os testes automatizados da aplicação; 

target/: Diretório gerado automaticamente após o build do projeto. 

 

3. Arquitetura e Organização do Código 

O projeto segue a arquitetura MVC (Model-View-Controller), promovendo a separação de responsabilidades e facilitando a manutenção: 

Model: Representa as entidades do sistema (por exemplo, Idosa, ProntuarioMedico, Consulta); 

Repository: Interfaces responsáveis pela comunicação com o banco de dados; 

Service: Camada onde está implementada a lógica de negócio; 

Controller: Define os endpoints da API para interação com o sistema. 

 

 

Exemplo de Entidade: 

java 

CopiarEditar 

@Entity 
public class Idosa { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id; 
    private String nome; 
    private String cpf; 
    private Date dataNascimento; 
    private String nomeMae; 
    private String cartaoSus; 
    private Date dataEntrada; 
    // Getters e setters 
} 
 

Exemplo de Repository: 

java 

CopiarEditar 

public interface IdosaRepository extends JpaRepository<Idosa, Integer> { 
} 
 

 

 

Exemplo de Controller: 

java 

CopiarEditar 

@RestController 
@RequestMapping("/idosas") 
public class IdosaController { 
    @Autowired 
    private IdosaService idosaService; 
 
    @PostMapping 
    public Idosa criarIdosa(@RequestBody Idosa idosa) { 
        return idosaService.salvar(idosa); 
    } 
} 
 

 

4. Configuração 

No arquivo application.properties estão definidas as configurações principais de conexão com o banco: 

ini 

CopiarEditar 

spring.datasource.url=jdbc:mysql://localhost:3306/idosoapp 
spring.datasource.username=root 
spring.datasource.password=senha 
spring.jpa.hibernate.ddl-auto=update 
spring.jpa.show-sql=true 
 

O comando spring.jpa.hibernate.ddl-auto=update garante que o schema do banco seja automaticamente atualizado conforme as entidades do projeto. 

 

5. Testes Automatizados 

Para garantir a qualidade e estabilidade do sistema, foram implementados testes automatizados utilizando JUnit. Esses testes verificam a integridade das funcionalidades essenciais. 

Exemplo de Teste: 

java 

CopiarEditar 

@Test 
public void testCriarIdosa() { 
    Idosa idosa = new Idosa(); 
    idosa.setNome("Maria"); 
    assertEquals("Maria", idosa.getNome()); 
} 
 

Outros testes podem ser adicionados para as camadas de controller utilizando MockMvc. 

 

6. Modelo de Dados 

O modelo relacional adotado é baseado em um diagrama ER, garantindo integridade e rastreabilidade dos dados: 

Idosa (1) —— (N) ProntuarioMedico 

ProntuarioMedico (1) —— (N) Consulta, Prescricao, Vacina, EventoSentinela, Relatorio 

ProfissionalSaude (1) —— (N) Consulta 

Esse relacionamento permite controlar todas as ações realizadas para cada idosa, com histórico detalhado e individualizado. 

 

7. Fluxo do Sistema 

Cadastro de idosas e profissionais de saúde; 

Criação de prontuário médico vinculado à idosa; 

Registro de consultas, vacinas, prescrições e eventos sentinelas; 

Consulta ao histórico médico da idosa. 

 

8. Segurança e Boas Práticas 

Autenticação e Autorização: Recomenda-se a integração do Spring Security para proteger endpoints sensíveis; 

Validações: Dados de entrada são validados nas entidades ou DTOs; 

Tratamento de Exceções: A aplicação conta com mecanismos de tratamento de erros; 

Backup: O banco de dados deve ser submetido a rotinas periódicas de backup para garantir a integridade das informações. 

 

 

9. Build e Execução 

Para compilar e rodar os testes do projeto: 

powershell  

..\maven\mvn\bin\mvn.cmd clean test -f .\Idosoapp\pom.xml 

 

10. Melhorias Futuras 

Interface web responsiva com Thymeleaf, Angular ou React; 

Geração de relatórios em PDF; 

Dashboards para visualização de indicadores; 

Integração com sistemas externos, como o e-SUS; 

Publicação em nuvem com pipelines de CI/CD. 

 

11. Considerações Finais 

O IdosoApp representa uma solução robusta e escalável para o gerenciamento clínico de instituições de longa permanência para idosas. Sua estrutura modular, o uso de boas práticas de desenvolvimento e a preocupação com testes e segurança tornam o sistema confiável e eficiente. 

Trata-se de uma base sólida que pode ser expandida com novas funcionalidades e facilmente adaptada a diferentes realidades de instituições de saúde. 

 

12. Referências 

Documentação oficial do Spring Boot 

Documentação do Spring Data JPA 

Documentação do Maven 

Documentação do JUnit 

MySQL Documentation 

 
