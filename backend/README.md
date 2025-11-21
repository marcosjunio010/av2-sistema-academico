# Sistema Acadêmico - Backend

Este é o backend do trabalho da disciplina. Fiz um sistema acadêmico simples com alunos e cursos, autenticação, monitoramento e documentação da API.

## Tecnologias

- Java 17
- Spring Boot 3 (Web, Security, Data JPA, Actuator)
- Banco H2 em memória
- Springdoc (Swagger)
- Micrometer + Prometheus (métricas)
- Integração pensada para Keycloak (OAuth2 Resource Server)

## Como rodar localmente

1. Entrar na pasta `backend`
2. Rodar o comando:

```bash
mvn spring-boot:run
```

ou, se preferir empacotar primeiro:

```bash
mvn clean package
java -jar target/sistema-academico-0.0.1-SNAPSHOT.jar
```

A API sobe em: `http://localhost:8080`

## Endpoints úteis

- Swagger: `http://localhost:8080/swagger-ui/index.html`
- H2 Console: `http://localhost:8080/h2-console`  
  - JDBC URL: `jdbc:h2:mem:testdb`
  - usuário: `sa`
  - senha: (vazia)

- Actuator / Prometheus: `http://localhost:8080/actuator/prometheus`

## Autenticação

A segurança está configurada com Spring Security + suporte a JWT (Keycloak).  
O arquivo `application.yml` já deixa comentado o issuer do Keycloak para ser ajustado quando o servidor estiver configurado.

Na hora de testar local, posso usar:
- Keycloak apontando para a minha API
- Ou simplificar os testes usando usuários em memória (ajustando a configuração se precisar)

## Monitoramento com Prometheus e Grafana

Na raiz do projeto (fora da pasta backend) existem:

- `docker-compose.yml`
- `prometheus.yml`

Passos que usei:

1. Com o backend rodando em `localhost:8080`, na raiz do projeto rodei:

```bash
docker-compose up -d
```

2. Acessos:

- Prometheus: `http://localhost:9090`
- Grafana: `http://localhost:3000` (login padrão admin / admin)

No Grafana, dá para adicionar o Prometheus como fonte de dados e montar um dashboard usando o endpoint `/actuator/prometheus` da aplicação.

## Testes de carga e stress (JMeter)

Os testes de carga estão na pasta `load-tests`.

- Arquivo: `load-tests/test-plan.jmx`

Ferramenta usada: **Apache JMeter**.

O plano faz requisições no endpoint `GET /api/alunos`, simulando vários usuários ao mesmo tempo.  
Para rodar:

1. Abrir o JMeter
2. Carregar o arquivo `test-plan.jmx`
3. Conferir se a URL está batendo com o backend (por padrão `http://localhost:8080`)
4. Rodar o teste e observar:
   - tempo médio de resposta
   - throughput
   - taxa de erro

Esses dados atendem o requisito de testes de desempenho (carga/stress) do enunciado.

## Deploy no Render (backend)

Os passos básicos que planejei para deploy no Render:

1. Subir o código completo para um repositório no GitHub
2. Criar uma conta no Render (se ainda não tiver)
3. Em **New → Web Service**, escolher o repositório do projeto
4. Configurar:
   - Runtime: Java 17
   - Build command: `mvn clean package`
   - Start command: `java -jar target/sistema-academico-0.0.1-SNAPSHOT.jar`
5. Ajustar variáveis de ambiente se for usar banco externo ou Keycloak
6. Fazer o deploy e depois testar os endpoints pelo link gerado pelo Render

## Referências usadas

Não decorei tudo, então consultei bastante a documentação e alguns vídeos:

- Documentação oficial Spring Boot: https://docs.spring.io/spring-boot/docs/current/reference/html
- Spring Data JPA: https://docs.spring.io/spring-data/jpa/docs/current/reference/html
- Spring Security: https://docs.spring.io/spring-security/reference
- Springdoc (OpenAPI / Swagger): https://springdoc.org
- Actuator: https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html
- JMeter: https://jmeter.apache.org/usermanual/index.html
- Prometheus: https://prometheus.io/docs/introduction/overview
- Grafana: https://grafana.com/docs/grafana/latest

Também usei os links que o professor deixou de referência (JMeter e vídeos no YouTube) para entender melhor a parte de testes de carga.
