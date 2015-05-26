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
    nome varchar(30)
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
    id_filme int,
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
alter table infoator add FOREIGN KEY(id_filme) references filme(pk);
alter table ListaAtores add FOREIGN KEY(id_infoator) references infoator(pk);
alter table ListaIngressos add FOREIGN KEY(id_ingresso) references ingresso(pk);
alter table sessao add FOREIGN KEY(id_filme) references filme(pk);
alter table sessao add FOREIGN KEY(id_sala) references sala(pk);
alter table sessao add FOREIGN KEY(id_listaIngressos) references listaingressos(pk);

insert into gerente (nome, senha) values ('Paulo', 'paulo');
insert into atendente (nome, senha) values ('Ana Paula', '123');
insert into filme (id_diretor, id_genero, id_listaAtores, id_distribuidora, nome, classificacao, ano, duracao, situacao, idioma) values(1, 1, 1, 1, 'Busca Implacável', 14, 2012, 120, 'cartaz', 'ingles');
insert into diretor (id, nome) values(1, 'Jubiraca');
insert into genero(nome) values('Ação');
insert into ListaAtores(id_infoAtor) values(1);
insert into InfoAtor(id_ator, id_filme, papel, part) values(1, 1, 'principal', '');
insert into ator(nome, datanascimento, nacionalidade) values('Liam Neeson', '', 'americano')
insert into distribuidora(nome) values('paramount');

SELECT * FROM gerente;
SELECT * FROM atendente;