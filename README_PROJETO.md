# Bem vindo a Aplicação que ajudará Sr.Samwell a controlar seus pedidos

## Requisitos
 - Tenha certeza que o java 8 está instalado e configurado na sua máquina
 - Tem o docker instalado? Para conexão com o Banco de Dados, utilizo PostGreSQL dockerizado.
 - Maven instalado, necessário para baixar dependências e iniciar o projeto.
 
### Docker
 - Para instalar docker em máquina linux: `sudo apt-get install docker.io`
 - https://www.docker.com/

#### Baixando e inicializando container PostGreSQL
 - `docker pull postgres` - atualizar com as últimas alterações do container.
 - `docker network create --driver bridge postgres-network` - criar uma rede bridge para comunicação.
 - `docker run --name docker-postgresql --network=postgres-network -e "POSTGRES_PASSWORD=Postgres2018!" -p 5432:5432 -v /home/${USER}/Desenvolvimento/PostgreSQL:/var/lib/postgresql/data -d postgres` - criará container e dará o star nele. Talvez seja preciso trocar a variável ${USER} pelo usuário da máquina.
 - `docker ps` - verificar se o container está de pé.

 
#### Baixando e inicializando container PgAdmin4 (interface web para gerenciamento do PostGreSQL)
 - `docker pull dpage/pgadmin4` - atualizar com as últimas alterações do container
 - `docker run --name docker-pgadmin --network=postgres-network -p 15432:80 -e "PGADMIN_DEFAULT_EMAIL=${EMAIL}" -e "PGADMIN_DEFAULT_PASSWORD=PgAdmin2018!" -d dpage/pgadmin4` - criará container e dará o star nele. Troque a variável ${EMAIL} pelo seu e-mail, será útil para logar-se no PgAdmin4.
 - `docker ps` - verificar se o container está de pé.
 -  http://localhost:15432 - acessar o PgAdmin4.
 - Para montar o server PostGreSQL no PgAdmin, vá em SERVER, NEW SERVER. Coloque o nome do container `docker-postgresql` como host, usuário `postgres` e senha `definida no docker run do container postgres`
 
#### Iniciando a Aplicação
 - Crie uma pasta para o projeto
 - Baixe o projeto ou dê um `git clone`
 - Dê um clean no projeto com o maven `mvn clean`
 - Compile o projeto `mvn install`
 - Inicialize o projeto - `mvn spring-boot:run`