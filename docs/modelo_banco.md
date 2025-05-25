# Documentação do Banco de Dados - Recanto do Sagrado Coração (RSC)

## Tabelas Principais

### idosa
- **id** (int, PK): Identificador único
- **nome** (varchar): Nome completo
- **cpf** (varchar): CPF
- **data_nascimento** (date): Data de nascimento
- **nome_mae** (varchar): Nome da mãe
- **cartao_sus** (varchar): Cartão SUS
- **data_entrada** (date): Data de entrada na instituição

### prontuario_medico
- **id** (int, PK): Identificador único
- **idosa_id** (int, FK): Referência para idosa

### consulta
- **id** (int, PK): Identificador único
- **prontuario_id** (int, FK): Referência para prontuário
- **data_hora** (datetime): Data e hora da consulta
- **profissional_nome** (varchar): Nome do profissional
- **tipo** (varchar): Tipo da consulta
- **motivo** (varchar): Motivo
- **diagnostico** (varchar): Diagnóstico
- **anotacoes** (varchar): Anotações

### exame
- **id** (int, PK): Identificador único
- **consulta_id** (int, FK): Referência para consulta
- **tipo** (varchar): Tipo do exame
- **data_solicitacao** (date): Data de solicitação
- **resultado** (varchar): Resultado
- **data_resultado** (date): Data do resultado

### vacina
- **id** (int, PK): Identificador único
- **idosa_id** (int, FK): Referência para idosa
- **nome** (varchar): Nome da vacina
- **data_aplicacao** (date): Data de aplicação

### evento_sentinela
- **id** (int, PK): Identificador único
- **idosa_id** (int, FK): Referência para idosa
- **tipo** (varchar): Tipo do evento
- **data_ocorrencia** (date): Data do evento

## Relacionamentos
- Uma idosa pode ter vários prontuários, vacinas e eventos sentinela.
- Um prontuário pode ter várias consultas.
- Uma consulta pode ter vários exames.

---

> **Dica:** Mantenha este arquivo atualizado sempre que alterar a estrutura do banco.
