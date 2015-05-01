Create table cinema.atendente(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(40),
    senha varchar(15)
);

Create table cinema.ator(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(20),
    datanascimento date
    nacionalidade varchar(20),
);

Create table cinema.cliente(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(30),
    anoNasc int,
    tipo varchar(15)
);

Create table cinema.diretor(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id int,
    nome varchar(30)
);

Create table cinema.distribuidora(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(50)
);

Create table cinema.filme(
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

Create table cinema.genero(
    pk int not null primary key generated always as identity(start with 1, increment by 1), 
    nome varchar(20)
);

Create table cinema.gerente(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(40),
    senha varchar(15)
);

Create table cinema.InfoAtor(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_ator int,
    papel varchar(50),
    part varchar(50)
);

Create table cinema.ingresso(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id int,
    inteira boolean,
    tipo varchar(20)
);

Create table cinema.ListaAtores(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_infoator int
);

Create table cinema.ListaIngressos(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_ingresso int
);

Create table cinema.sala(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    num int,
    lotacao int,
    poltEsp int,
    estados varchar(30)
);

Create table cinema.sessao(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_filme int,
    id_sala int,
    diaHora date,
    legendado boolean,
    id_listaIngressos int
);

alter table cinema.filme add FOREIGN KEY(id_diretor) references cinema.Diretor(pk);
alter table cinema.filme add FOREIGN KEY(id_genero) references cinema.genero(pk);
alter table cinema.filme add FOREIGN KEY(id_listaAtores) references cinema.listaAtores(pk);
alter table cinema.filme add FOREIGN KEY(id_distribuidora) references cinema. distribuidora(pk);
alter table cinema.infoator add FOREIGN KEY(id_ator) references cinema.ator(pk);
alter table cinema.ListaAtores add FOREIGN KEY(id_infoator) references cinema.infoator(pk);
alter table cinema.ListaIngressos add FOREIGN KEY(id_ingresso) references cinema.ingresso(pk);
alter table cinema.sessao add FOREIGN KEY(id_filme) references cinema.filme(pk);
alter table cinema.sessao add FOREIGN KEY(id_sala) references cinema.sala(pk);
alter table cinema.sessao add FOREIGN KEY(id_listaIngressos) references cinema.listaingressos(pk);