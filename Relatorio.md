# Roteiro de Apresentação - Sistema RSC

## 1. Contextualização
O Recanto do Sagrado Coração (RSC) é uma casa de repouso para idosas que necessita de um sistema informatizado para gerenciar prontuários médicos, eventos sentinela, vacinas e dados pessoais das residentes.

## 2. Descrição do Problema
- Cadastro e consulta de idosas.
- Registro de prontuários médicos, consultas, exames, vacinas e eventos sentinela.
- Geração de relatórios para acompanhamento da saúde e eventos.

## 3. Proposta de Solução/Implementação
- Aplicação desktop Java, orientada a objetos, com interface Swing.
- Persistência dos dados em banco MySQL.
- Estrutura modular: cada entidade possui sua classe, DAO e tela de cadastro.
- Diagrama de classes e modelo de dados implementados conforme requisitos.

## 4. Tecnologias Utilizadas
- Java JDK
- Swing (interface gráfica)
- MySQL (banco de dados)
- Git/GitHub (controle de versão)

## 5. Dificuldades e Limitações
- Integração entre interface gráfica e banco de dados.
- Modelagem dos relacionamentos entre entidades.
- Conversão de datas e tratamento de erros de entrada.
- Limitações: funcionalidades de relatório podem ser expandidas.

## 6. Aspectos a Melhorar
- Interface gráfica pode ser aprimorada.
- Adicionar autenticação de usuários.
- Melhorar validação de dados e mensagens de erro.

## 7. Conclusão
- O sistema atende aos requisitos principais do edital.
- Permite cadastro, consulta e geração de relatórios das idosas e seus eventos de saúde.
- Estrutura pronta para expansão e melhorias futuras.

---

# Apresentação do Trabalho de Extensão

## 1. Links de Referência
- [Recanto Sagrado Coração (Facebook)](https://www.facebook.com/RECANTOSAGRADOCORA/)
- [MySQL](https://www.mysql.com/)
- [PostgreSQL](https://www.postgresql.org/)

## 2. Contextualização
O projeto visa informatizar o prontuário médico institucional de idosas do Recanto do Sagrado Coração, facilitando o registro, acompanhamento e análise de eventos sentinela, consultas, prescrições, vacinas e relatórios, promovendo maior segurança e qualidade no cuidado.

## 3. Descrição do Problema
A aplicação deve atender às seguintes funcionalidades:
- Cadastro e gerenciamento de idosas.
- Registro de consultas, prescrições, vacinas e eventos sentinela.
- Geração de relatórios.
- Persistência dos dados (inicialmente em memória, podendo evoluir para MySQL/PostgreSQL).
- Interface para controle e visualização dos dados.
- Testes unitários para garantir a qualidade do código.

## 4. Proposta de Solução/Implementação
- **Estratégia:** Utilização de arquitetura em camadas (Model, DAO, Controller), separando regras de negócio, persistência e interface.
- **Estrutura:**
  - **Modelos:** Representam as entidades do domínio (Idosa, Consulta, EventoSentinela, etc.).
  - **DAOs:** Responsáveis pela persistência dos dados.
  - **Controllers:** Intermediam a lógica de negócio e a interface.
  - **Testes:** Cobrem todos os modelos com JUnit.
- **Diagramas:** Foram utilizados diagramas de classes para padronizar e alinhar o desenvolvimento.

## 5. Tecnologias Utilizadas
- **Java** (linguagem principal)
- **JUnit 4/5** (testes unitários)
- **Maven** (gerenciamento de dependências e build)
- **Git/GitHub** (controle de versão)
- **MySQL/PostgreSQL** (planejado para persistência futura)
- **VS Code** (IDE)

## 6. Dificuldades e Limitações
- **Dificuldades técnicas:** Ajuste do ambiente Maven no Windows, conflitos de submódulo Git, padronização dos testes conforme os métodos reais das classes.
- **Como foram superadas:** Orientação detalhada, comandos específicos para Windows, revisão e alinhamento dos testes.
- **Limitações:** Persistência atual apenas em memória; integração com banco relacional pode ser implementada futuramente.
- **Melhorias possíveis:** Interface gráfica/web, relatórios avançados, integração direta com banco de dados.

## 7. Conclusão
O sistema entregue contempla todos os requisitos iniciais: cadastro, registro, controle e testes das principais entidades do prontuário médico institucional. O código está padronizado, testado e pronto para evoluções, aderente aos objetivos do trabalho de extensão.

---


