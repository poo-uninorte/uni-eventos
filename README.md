<h1 align="center">
    <img alt="Launchbase" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzYRmq9ITJGG2Gr7xNbMYB4oK8wZrTddByeA&usqp=CAU" width="300px" />
</h1>

<h3 align="center">
  PROJETO UNIEVENTOS
</h3>

<blockquote align="center">“Tivemos um bom combate, quase morremos de raiva, guardamos a nossa fé”</blockquote>

<br>
<br>

## :file_cabinet: Tutorial

    Primeiro passo: Crie um banco de dados vazio no MySQL Worchbench com o nome que quiser.
    
    Segundo passo: Configure a classe HibernateUtil com as informações do banco de dados criado
    
<br>
<br>

## :file_cabinet: Problema com o fuso horário do banco de dados
  Ao fazer a importação e as configurações necessárias, observamos que o banco de dados apresenta pequenos problemas de compatibilidade com o Hibernate. Desta forma, no    banco   de dados, insira a seguinte query e execute:

    SET @@global.time_zone = '+3:00';**
       
    Agora execute o AppMainConsole descomentando a linha do método inicializaBancoDeDados().
    
<br>
<br>

## :calendar: Data de entrega

    01/07/2020


---

Feito pelos alunos Odilon, Mylena, Valdenilson e Manassés com :purple_heart:


