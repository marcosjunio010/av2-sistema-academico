# Testes de carga e stress (JMeter)

Os testes de carga da aplicação foram feitos com **Apache JMeter**.

### Arquivo do plano

- `test-plan.jmx` → faz requisições em cima do endpoint `GET /api/alunos`, com:
  - 20 usuários simulados
  - 5 repetições por usuário
  - endpoint padrão: `http://localhost:8080/api/alunos`

### Como rodar o teste

1. Instalar o JMeter (site oficial: https://jmeter.apache.org/download_jmeter.cgi)
2. Abrir o JMeter
3. Menu **File → Open** e selecionar o arquivo `test-plan.jmx` que está na pasta `load-tests`
4. Ajustar a URL se o backend não estiver em `localhost:8080`
5. Clicar em **Start** para rodar
6. Ver os resultados no listener (Gráfico / Tabela) e observar:
   - tempo médio de resposta
   - throughput
   - taxa de erro

Essas informações atendem o pedido de testes de desempenho (carga/stress) do enunciado.
