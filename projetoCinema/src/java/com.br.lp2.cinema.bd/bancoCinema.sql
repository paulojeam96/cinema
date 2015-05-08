Create table atendente(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(40),
    senha varchar(15)
);

Create table ator(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(20),
    datanascimento date,
    nacionalidade varchar(20)
);

Create table cliente(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(30),
    anoNasc int,
    tipo varchar(15)
);

Create table diretor(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id int,
    nome varchar(30),
    senha varchar(30)
);

Create table distribuidora(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(50)
);

Create table filme(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_diretor int,
    id_genero int,
    id_listaAtores int,
    id_distribuidora int,
    nome varchar(50),
    classificacao int,
    ano int,
    duracao int,
    situacao varchar(15),
    idioma varchar(20)
);

Create table genero(
    pk int not null primary key generated always as identity(start with 1, increment by 1), 
    nome varchar(20)
);

Create table gerente(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(40),
    senha varchar(15)
);

Create table InfoAtor(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_ator int,
    papel varchar(50),
    part varchar(50)
);

Create table ingresso(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id int,
    inteira boolean,
    tipo varchar(20)
);

Create table ListaAtores(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_infoator int
);

Create table ListaIngressos(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_ingresso int
);

Create table sala(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    num int,
    lotacao int,
    poltEsp int,
    estados varchar(30)
);

Create table sessao(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_filme int,
    id_sala int,
    diaHora date,
    legendado boolean,
    id_listaIngressos int
);

alter table filme add FOREIGN KEY(id_diretor) references Diretor(pk);
alter table filme add FOREIGN KEY(id_genero) references genero(pk);
alter table filme add FOREIGN KEY(id_listaAtores) references listaAtores(pk);
alter table filme add FOREIGN KEY(id_distribuidora) references  distribuidora(pk);
alter table infoator add FOREIGN KEY(id_ator) references ator(pk);
alter table ListaAtores add FOREIGN KEY(id_infoator) references infoator(pk);
alter table ListaIngressos add FOREIGN KEY(id_ingresso) references ingresso(pk);
alter table sessao add FOREIGN KEY(id_filme) references filme(pk);
alter table sessao add FOREIGN KEY(id_sala) references sala(pk);
alter table sessao add FOREIGN KEY(id_listaIngressos) references listaingressos(pk);