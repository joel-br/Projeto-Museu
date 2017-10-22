create database museuweb;
use museuweb;

CREATE TABLE tb_visitante(
	nome varchar(50),
    telefone varchar(50),
    rg varchar(50),
    email varchar(50),
    endereco varchar(50),
    tipoVisitante varchar(50),
    codVisitante varchar(50));

CREATE TABLE tb_obra(
	titulo varchar(50),
    dataCriacao datetime,
	estadoConservacao varchar(50),
    autor varchar(50),
    disponibilidade varchar(50),
    tipoObra varchar(50),
    codObra int);

CREATE TABLE tb_exposicao(
	tempoExposicao varchar(50),
    nomeExposicao varchar(50),
    descExposicao varchar(50),
    salaReservada varchar(50),
    maximoVisitantes int);

CREATE TABLE tb_restauracao(
	codObra int,
    estado varchar(50),
    empresa varchar(50),
    Duracao varchar(50),
    dataLimite datetime);

CREATE TABLE tb_evento(
	responsavel varchar(50),
    numVisitantes int,
    descricao varchar(50),
    nomeEvento varchar(50),
    dataEvento datetime);

CREATE TABLE tb_estoque(
	nome varchar(50),
    preco double,
    estado varchar(50));
    
    
CREATE TABLE tb_usuario(
	user varchar(50),
    senha varchar(50),
    pergunta varchar(50),
    resp varchar(50),
    id int);
