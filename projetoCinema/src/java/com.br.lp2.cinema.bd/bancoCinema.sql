Create table atendente(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(40),
    senha varchar(15)
);

Create table comum(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(40),
    senha varchar(40),
    codigo int
);

Create table ator(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(20),
    datanascimento varchar(10),
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
    id int,
    nome varchar(50)
);

Create table filme(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_diretor int,
    id_genero int,
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
    id int,
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
    diaHora varchar(20),
    legendado boolean,
    id_listaIngressos int
);

alter table filme add FOREIGN KEY(id_diretor) references Diretor(pk);
alter table filme add FOREIGN KEY(id_genero) references genero(pk);
alter table filme add FOREIGN KEY(id_distribuidora) references  distribuidora(pk);
alter table infoator add FOREIGN KEY(id_ator) references ator(pk);
alter table infoator add FOREIGN KEY(id_filme) references filme(pk);
alter table ListaAtores add FOREIGN KEY(id_infoator) references infoator(pk);
alter table ListaIngressos add FOREIGN KEY(id_ingresso) references ingresso(pk);
alter table sessao add FOREIGN KEY(id_filme) references filme(pk);
alter table sessao add FOREIGN KEY(id_sala) references sala(pk);
alter table sessao add FOREIGN KEY(id_listaIngressos) references listaingressos(pk);


insert into ator(nome, datanascimento, nacionalidade) values('Liam Neeson', '23/09/1966', 'americano'), ('Will Smith', '23/08/1977', 'philly'), ('Chris Hemsworth', '21/09/1966', 'asgardiano'), ('Oliver Queen', '23/09/1966', 'something else'), ('Tony Stark', '23/09/1980', 'marte');
insert into gerente (nome, senha) values ('Paulo', 'paulo'), ('Gerson', 'gerson'), ('Cacique', 'cacique');
insert into atendente (nome, senha) values ('Ana Paula', '123'), ('Ana Luiza', '123'), ('Jackson', '123');
insert into comum(nome, senha, codigo) values ('Gabriel', 'comum', 1);
insert into diretor (id, nome) values(1, 'Jubiraca'), (2, 'Tom Hanks'), (3, 'Roberto Brasileiro'), (4, 'Aurelio');
insert into genero(id, nome) values(1, 'acao'), (2, 'comedia'), (3, 'aventura'), (4, 'terror'), (5, 'adulto'), (6, 'suspense'), (7, 'musical'), (8, 'comedia-romantica'), (9, 'documentario');
insert into distribuidora(id, nome) values(1, 'paramount'), (2, 'disney'), (3, 'marvel'), (4, 'brasileirinhas'), (5, 'paramuitos');
insert into sala(num, lotacao, poltEsp, estados) values (3, 40, 4, 'EXIBICAO'), (1, 40, 4, 'EXIBICAO'), (2, 40, 4, 'MANUTENCAO'), (4, 40, 4, 'ESPERA');
insert into ingresso(id, inteira, tipo) values (1, true, 'GERAL'), (2, false, 'OBESO'), (3, false, 'CADEIRANTE'), (4, true, 'GERAL');
insert into ListaIngressos(id_ingresso) values(1), (2), (2);
insert into cliente(nome, anoNasc, tipo) values ('Jose', 1956, 'GERAL'), ('jOAO', 1946, 'OBESO'), ('Maria', 1856, 'CADEIRANTE'), ('Pereto', 1990, 'GERAL'); 
insert into filme (id_diretor, id_genero, id_distribuidora, nome, classificacao, ano, duracao, situacao, idioma) values(2, 2, 3, 'Busca Implacavel', 14, 2012, 120, 'cartaz', 'ingles'), (3, 2, 3, 'Homem de Ferro', 16, 2010, 120, 'estreia', 'portugues'), (4, 3, 1, 'A Lenda Do Aluno Solitario', 10, 2015, 200, 'estreia', 'portugues'), (1, 4, 3, 'jogos mortais', 14, 2012, 120, 'cartaz', 'ingles');
insert into InfoAtor(id_ator, id_filme, papel, part) values(1, 1, 'Brian Mills', 'protagonista'), (2, 3, 'Paulo Jeam', 'protagonista'), (3, 4, 'Fala Mansa', 'coadjuvante'), (4, 2, 'Tom Sawyer', 'protagonista');
insert into ListaAtores(id_infoAtor) values(1), (2), (3), (4);
insert into sessao (id_filme, id_sala, diaHora, legendado, id_ListaIngressos) values(3, 1, '23/07 14:00', true, 1), (1, 2, '23/07 15:00', false, 2), (2, 3, '23/07 16:00', true, 2);


select * from sessao;