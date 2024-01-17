# Teste API Transações financeiras

# Regras e validações

Para garantir o cumprimento das regras de negócio, definimos algumas premissas:
- Todo cliente deve ser atrelado a uma conta bancária no momento do seu cadastro
- A conta bancária já deve ser criada com um valor inicial definido, mesmo que seja 0
- A conta deve ter um valor único, mesmo que o número da agência  seja  diferente.
- Não pode ser feito o cadastro de pessoa física com CPF ou RG já presentes no sistema
- Não pode ser feito o cadastro de pessoa jurídica com CNPJ já presentes no sistema
- Todas as buscas por clientes devem retornar apenas aqueles que estão ativos no sistema

# Tabelas e Endpoints desenvolvidos

http://localhost:8090/swagger-ui/index.html

- O Swagger busca controllers para documentar.

# Ferramentas utilizadas

- Java 17 com module path
- Spring Boot 2.7.5
- Swagger
- Maven
- H2
- IntelliJ