# Teste API Transações financeiras

# Regras e validações

Para garantir o cumprimento das regras de negócio, definimos algumas premissas:
- Todo cliente deve ser atrelado a uma conta bancária no momento do seu cadastro
- A conta bancária já deve ser criada com um valor inicial definido, mesmo que seja 0
- A conta deve ter um valor único, mesmo que o número da agência  seja  diferente.
- Não pode ser feito o cadastro de pessoa física com CPF ou RG já presentes no sistema
- Não pode ser feito o cadastro de pessoa jurídica com CNPJ já presentes no sistema
- Todas as buscas por clientes devem retornar apenas aqueles que estão ativos no sistema

# Endpoints desenvolvidos

http://localhost:8090/swagger-ui/index.html

- O Swagger busca controllers para documentar.


# Endpoints para acessar

|-------------------------------------------------------------------------|

-verbo Post http://localhost:8090/cliente/pj

{
"telefone": "1137279661",
"celular": "11997649175",
"nome": "Priscila e Lívia Marketing ME",
"cnpj": "69080968000171",
"nome_fantasia": "Priscila e Lívia Marketing ME",
"nome_contato": "Priscila fulana",
"email": "producao@priscilaeliviamarketingme.com.br",
"conta": {        
"numero_conta": 250100,
"agencia": 123,
"operacaoConta": "CONTACORRENTEPJ",
"saldo": 15000.00 },
"endereco": {        
"cep": "09962720",
"rua": "Travessa Senhor do Bonfim",
"numero": 890,
"complemento": "s/complemento",
"bairro": "Diadema",
"cidade": "São Paulo",
"uf": "SP"}
}

-verbo Post http://localhost:8090/cliente/pf

{
"telefone": "8535825284",
"rg": "203625237",
"cpf": "14857746832",
"celular": "85985390965",
"nome": "Rita Caroline Souza",
"email": "rita@gol.com",
"dt_nascimento": "1989-01-02",
"genero": "FEMININO",
"conta": {        
"numero_conta": 25050,
"agencia": 123,
"operacaoConta": "CONTACORRENTEPF",
"saldo": 5000.00 },
"endereco": {        
"cep": "04268020",
"rua": "Rua Arcipreste de Arndrade",
"numero": 506,
"complemento": "s/complemento",
"bairro": "Ipiranga",
"cidade": "São Paulo",
"uf": "SP"}
}




|-------------------------------------------------------------------------|

# Ferramentas utilizadas

- Java 17 com module path
- Spring Boot 2.7.5
- Swagger
- Maven
- H2
- IntelliJ