create table pacientes(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(11)not null unique,
    email varchar(50) not null unique,
    telefone varchar(20)not null,
    logradouro varchar (100) not null,
    numero varchar (10) not null,
    bairro varchar(30) not null,
    cep varchar(30)not null,
    cidade varchar(50)not null,
    uf varchar(2)not null,

    primary key(id)

);