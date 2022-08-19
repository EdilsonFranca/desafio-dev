#Projeto Movimentações Finanaceira API REST (Desafio Dev)<br>

<h4><strong>-Requisitos:</strong></h4><br>
*Java11; <br>
*Spring Boot  2.7.3<br>
*Mysql;<br>
*Maven instalado e configurado;<br>

<h5>-Swagger: http://localhost:8080/swagger-ui.html</h5><br>

<strong>Api</strong> <br> 
GET  http://localhost:8080        busca todas as Movimentações Finanaceira <br>
GET  http://localhost:8080/name   busca todas as Movimentações Finanaceira pelo name passado na url<br>
POST http://localhost:8080        recebe um arquivo de texto CNAB como parameto obrigatório ,extrai as linhas e salva cada linha uma movimentações finanaceira<br>

<strong>configuração do banco de dados</strong><br>
src/main/java/com/br/bycoders/DataConfiguration.java<br>

dataSource.setUrl("jdbc:mysql://localhost:3306/coloca_aqui_seu_banco?enabledTLSProtocols=TLSv1.2&useTimezone=true&serverTimezone=UTC");<br>
dataSource.setUsername("seu_usuario");<br>
dataSource.setPassword("sua_senha");<br>
