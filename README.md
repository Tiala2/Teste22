# Recanto do Sagrado Coração - Sistema de Gestão

Sistema desktop Java para gestão de casa de repouso de idosas, seguindo o padrão MVC, com interface Swing, integração com banco de dados, documentação, testes e visual moderno.

## Funcionalidades
- Cadastro, listagem, edição e exclusão de Idosas, Consultas, Exames, Vacinas, Prontuários Médicos e Eventos Sentinela
- Navegação entre telas
- Validação de dados (ex: CPF, datas)
- Tratamento de erros detalhado
- Integração com banco de dados SQLite
- Documentação Javadoc
- Pronto para trabalho em grupo com Git

## Estrutura do Projeto
```
teste/
  src/
    model/         # Entidades e DAOs
    controller/    # Controllers (lógica de negócio)
    ui/            # Telas Swing
  docs/            # Documentação do banco
  README.md        # Este arquivo
  .gitignore       # Arquivos a serem ignorados pelo Git
```

## Como Executar
1. Instale o Java (JDK 8+)
2. Compile o projeto:
   ```
   javac -d bin src/model/*.java src/model/*DAO.java src/controller/*.java src/ui/*.java
   ```
3. Execute a tela principal (exemplo):
   ```
   java -cp bin ui.CadastroIdosaUI
   ```
4. O banco SQLite será criado automaticamente (banco_rsc.db)

## Como Contribuir
- Faça um fork/clique em "Code" > "Download ZIP"
- Crie uma branch para sua feature/correção
- Faça commits pequenos e descritivos
- Abra um Pull Request para revisão

## Contato
Equipe RSC - 2025

---

> Projeto acadêmico. Para uso real, recomenda-se revisão de segurança, privacidade e LGPD.
