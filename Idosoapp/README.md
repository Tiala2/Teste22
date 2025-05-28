# Recanto do Sagrado Coração (RSC) - Aplicação de Gestão de Pacientes

## Descrição do Projeto
Este projeto é uma aplicação desktop desenvolvida em Java para a gestão de pacientes em uma casa de repouso para idosas, chamada Recanto do Sagrado Coração. A aplicação tem como objetivo facilitar o gerenciamento de prontuários médicos, consultas, vacinas e relatórios de saúde das idosas.

## Tecnologias Utilizadas
- **Java JDK**: Linguagem de programação utilizada para o desenvolvimento da aplicação.
- **MySQL ou PostgreSQL**: Banco de dados utilizado para armazenar as informações dos pacientes e suas interações.
- **Maven**: Gerenciador de dependências utilizado para facilitar a construção do projeto.
- **Git e GitHub**: Ferramentas utilizadas para controle de versão e colaboração no desenvolvimento do projeto.

## Estrutura do Projeto
A estrutura do projeto é organizada em pacotes, seguindo o padrão de arquitetura MVC (Model-View-Controller):

- **Model**: Contém as classes que representam os dados da aplicação, como `Paciente`, `ProntuarioMedico`, `Consulta`, entre outros.
- **View**: Contém as classes responsáveis pela interface gráfica da aplicação.
- **Controller**: Contém as classes que gerenciam a lógica de negócios e a interação entre a visão e o modelo.
- **DAO**: Contém as classes responsáveis pela persistência de dados no banco de dados.

## Funcionalidades
- Cadastro e gerenciamento de pacientes.
- Registro de consultas médicas e diagnósticos.
- Controle de vacinas e histórico de vacinação.
- Geração de relatórios de saúde e eventos sentinelas.
- Persistência de dados em banco de dados.

## Instruções de Instalação
1. Clone o repositório do projeto:
   ```
   git clone <URL_DO_REPOSITORIO>
   ```
2. Navegue até o diretório do projeto:
   ```
   cd recanto-rsc-app
   ```
3. Configure o banco de dados no arquivo `src/main/resources/application.properties`.
4. Compile o projeto utilizando Maven:
   ```
   mvn clean install
   ```
5. Execute a aplicação:
   ```
   mvn exec:java -Dexec.mainClass="br.edu.unichristus.recantorsc.Main"
   ```

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## Licença
Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

# Idosoapp

Esta pasta contém o código-fonte principal do sistema Recanto do Sagrado Coração (RSC), incluindo:
- Modelos de dados (model)
- DAOs (persistência)
- Controllers (lógica de negócio)
- Views (interface Swing)

> Se você está vendo este arquivo, a pasta Idosoapp está corretamente versionada no GitHub.