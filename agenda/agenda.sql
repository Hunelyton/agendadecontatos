create database agenda;

show databases;

use agenda;

create table contatos(
	id int primary key auto_increment,
    nome varchar(100) not null,
    telefone varchar(15) not null,
    email varchar(100)
);
show tables;
describe contatos;


/*CRUD CREATE*/
/*adicionando informaçãoes no BD manualmente*/
insert into contatos(nome,telefone,email) values ('Hunelyton Mendes','13981196498','hunelyton.mendes@gmail.com');


/* CRUD READ */

select * from contatos;




