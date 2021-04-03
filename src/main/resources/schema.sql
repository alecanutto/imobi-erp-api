CREATE DATABASE "Imobiliaria_DB"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SEQUENCE seq_tb_funcionarios;

CREATE TABLE tb_funcionarios (
	id bigint NOT NULL default nextval('seq_tb_funcionarios'),	
    nome character varying(150),
	rg character varying(25),
    cpf character varying(11), 
    data_nasc date,
	estado_civil character varying(20),
    sexo character(1),
	endereco character varying(150),
	numero character varying(10),
	bairro character varying(100),
	complemento character varying(60),
    uf character(2),
	cidade character varying(100),
	cep character varying(8),
	cod_ibge character varying(7),
	naturalidade character varying(60),
	nacionalidade character varying(60),
    fone character varying(11),
    cel character varying(11),
    email character varying(150),	
    cargo character varying(30),
    remuneracao numeric(9,2) default 0,
	data_admissao date,
	data_demissao date,
	data_cadastro date DEFAULT CURRENT_DATE,
	ativo boolean DEFAULT true, 
    obs character varying(200),	
    CONSTRAINT tb_funcionarios_pkey PRIMARY KEY (id),
	CONSTRAINT tb_funcionarios_uk_cpf UNIQUE (cpf),
	CONSTRAINT tb_funcionarios_ck_sexo CHECK (sexo IN ('F','M','X'))
);

CREATE SEQUENCE seq_tb_usuarios;

CREATE TABLE tb_usuarios
(
    id bigint NOT NULL default nextval('seq_tb_usuarios'),
    funcionario_id bigint NOT NULL,
	login character varying(30),
    senha character varying(255),
	ativo boolean DEFAULT true,    
    CONSTRAINT tb_usuarios_pkey PRIMARY KEY (id),
    CONSTRAINT tb_usuarios_uk_login UNIQUE (login),
    CONSTRAINT tb_usuarios_fk_funcionario_id FOREIGN KEY (funcionario_id)
        REFERENCES public.tb_funcionarios (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_permissoes;

CREATE TABLE tb_permissoes
(
    id bigint NOT NULL default nextval('seq_tb_permissoes'),
    descricao character varying(4) NOT NULL,
    usuario_id bigint NOT NULL,
    permitido boolean DEFAULT false,
    CONSTRAINT tb_permissoes_pkey PRIMARY KEY (id),
    CONSTRAINT tb_permissoes_uk_descricao UNIQUE (descricao),
    CONSTRAINT tb_permissoes_fk_usuario_id FOREIGN KEY (usuario_id)
        REFERENCES public.tb_usuarios (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_proprietarios;

CREATE TABLE tb_proprietarios
(
    id bigint NOT NULL DEFAULT nextval('seq_tb_proprietarios'),
    nome character varying(150),
    rg character varying(25),
    cpf character varying(11),
    data_nasc date,
    estado_civil character varying(20),
    sexo character(1),
	endereco character varying(150) ,
	numero character varying(10),	
    bairro character varying(100),
	complemento character varying(60),
	uf character(2),
	cidade character varying(100),
    cep character varying(8),
   	cod_ibge character varying(7),
	naturalidade character varying(60),
	nacionalidade character varying(60),
    fone character varying(11),
    cel character varying(11),
    email character varying(150),
    data_cadastro date DEFAULT CURRENT_DATE,
    ativo boolean DEFAULT true,
    obs character varying(200),
    CONSTRAINT tb_proprietarios_pkey PRIMARY KEY (id),
	CONSTRAINT tb_proprietarios_uk_cpf UNIQUE (cpf),
	CONSTRAINT tb_proprietarios_ck_sexo CHECK (sexo IN ('F','M','X'))
);

CREATE SEQUENCE seq_tb_proprietario_bancos;

CREATE TABLE tb_proprietario_bancos
(
    id bigint NOT NULL DEFAULT nextval('seq_tb_proprietario_bancos'),
	proprietario_id bigint NOT NULL,
	pix character varying(255),
    codigo_banco character varying(4),
	nome character varying(60),
    numero_agencia character varying(10),
    numero_conta character varying(11),
    tipo_conta character(1),
	favorecido character varying(150) ,
	cpf_cnpj character varying(10),	
    data_cadastro date DEFAULT CURRENT_DATE,
    obs character varying(200),
	ativo boolean DEFAULT true,
    CONSTRAINT tb_proprietario_bancos_pkey PRIMARY KEY (id),
	CONSTRAINT tb_proprietario_bancos_uk_pix UNIQUE (pix),
	CONSTRAINT tb_proprietario_bancos_fk_proprietario_id FOREIGN KEY (proprietario_id)
        REFERENCES public.tb_proprietarios (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_proprietario_referencias;

CREATE TABLE tb_proprietario_referencias (
	id bigint NOT NULL default nextval('seq_tb_proprietario_referencias'),	
	proprietario_id bigint NOT NULL,
    nome character varying(150), 
	tipo character varying(30),
	fone character varying(11),
	obs character varying(20),
    CONSTRAINT tb_proprietario_referencias_pkey PRIMARY KEY (id),
	CONSTRAINT tb_proprietario_referencias_fk_proprietario_id FOREIGN KEY (proprietario_id)
        REFERENCES public.tb_proprietarios (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_proprietario_trabalho;

CREATE TABLE tb_proprietario_trabalho (
	id bigint NOT NULL default nextval('seq_tb_proprietario_trabalho'),	
    proprietario_id bigint NOT NULL,
    cargo character varying(30), 
	renda numeric(9,2) default 0,
	outraRenda numeric(9,2) default 0,
	empresa character varying(150),
	cnpj character varying(14) ,
	data_admissao date,
	fone character varying(11),
	email character varying(150),	
	endereco character varying(150) ,
	numero character varying(10),	
    bairro character varying(100),
	complemento character varying(60),
	uf character(2),
	cidade character varying(100),
    cep character varying(8),
   	cod_ibge character varying(7)	
    CONSTRAINT tb_proprietario_trabalho_pkey PRIMARY KEY (id),
	CONSTRAINT tb_proprietario_trabalho_fk_proprietario_id FOREIGN KEY (proprietario_id)
        REFERENCES public.tb_proprietarios (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_proprietario_conjugue;

CREATE TABLE tb_proprietario_conjugue (
	id bigint NOT NULL default nextval('seq_tb_proprietario_conjugue'),	
    proprietario_id bigint NOT NULL,
	nome character varying(150),
	cpf character varying(11) ,
	cel character varying(11),
	email character varying(150),	
    CONSTRAINT tb_proprietario_conjugue_pkey PRIMARY KEY (id),
	CONSTRAINT tb_proprietario_conjugue_fk_proprietario_id FOREIGN KEY (proprietario_id)
        REFERENCES public.tb_proprietarios (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_compradores;

CREATE TABLE tb_compradores
(
    id bigint NOT NULL DEFAULT nextval('seq_tb_compradores'),
    nome character varying(150),
    rg character varying(25),
    cpf character varying(11),
    data_nasc date,
    estado_civil character varying(20),
    sexo character(1),	
	endereco character varying(150) ,
	numero character varying(10),	
    bairro character varying(100),
	complemento character varying(60),
	uf character(2),
	cidade character varying(100),
    cep character varying(8),
   	cod_ibge character varying(7),
	naturalidade character varying(60),
	nacionalidade character varying(60),
    fone character varying(11),
    cel character varying(11),
    email character varying(150),
    data_cadastro date DEFAULT CURRENT_DATE,
    ativo boolean DEFAULT true,
    obs character varying(200),
    CONSTRAINT tb_compradores_pkey PRIMARY KEY (id),
	CONSTRAINT tb_compradores_uk_cpf UNIQUE (cpf),
	CONSTRAINT tb_compradores_ck_sexo CHECK (sexo IN ('F','M','X'))
);

CREATE SEQUENCE seq_tb_comprador_bancos;

CREATE TABLE tb_comprador_bancos
(
    id bigint NOT NULL DEFAULT nextval('seq_tb_comprador_bancos'),
	comprador_id bigint NOT NULL,
	pix character varying(255),
    codigo_banco character varying(4),
	nome character varying(60),
    numero_agencia character varying(10),
    numero_conta character varying(11),
    tipo_conta character(1),
	favorecido character varying(150) ,
	cpf_cnpj character varying(10),	
    data_cadastro date DEFAULT CURRENT_DATE,
    obs character varying(200),
	ativo boolean DEFAULT true,
    CONSTRAINT tb_comprador_bancos_pkey PRIMARY KEY (id),
	CONSTRAINT tb_comprador_bancos_uk_pix UNIQUE (pix),
	CONSTRAINT tb_comprador_bancos_fk_comprador_id FOREIGN KEY (comprador_id)
        REFERENCES public.tb_compradores (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_comprador_referencias;

CREATE TABLE tb_comprador_referencias (
	id bigint NOT NULL default nextval('seq_tb_comprador_referencias'),	
	comprador_id bigint NOT NULL,
    nome character varying(150),
	tipo character varying(30),
	fone character varying(11),
	obs character varying(20),
    CONSTRAINT tb_comprador_referencias_pkey PRIMARY KEY (id),
	CONSTRAINT tb_comprador_referencias_fk_comprador_id FOREIGN KEY (comprador_id)
        REFERENCES public.tb_compradores (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_comprador_trabalho;

CREATE TABLE tb_comprador_trabalho (
	id bigint NOT NULL default nextval('seq_tb_comprador_trabalho'),	
    comprador_id bigint NOT NULL,
    cargo character varying(30), 
	renda numeric(9,2) default 0,
	outraRenda numeric(9,2) default 0,
	empresa character varying(150),
	cnpj character varying(14) ,
	data_admissao date,
	fone character varying(11),
	email character varying(150),	
	endereco character varying(150) ,
	numero character varying(10),	
    bairro character varying(100),
	complemento character varying(60),
	uf character(2),
	cidade character varying(100),
    cep character varying(8),
   	cod_ibge character varying(7)	
    CONSTRAINT tb_comprador_trabalho_pkey PRIMARY KEY (id),
	CONSTRAINT tb_comprador_trabalho_fk_comprador_id FOREIGN KEY (comprador_id)
        REFERENCES public.tb_compradores (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_comprador_conjugue;

CREATE TABLE tb_comprador_conjugue (
	id bigint NOT NULL default nextval('seq_tb_comprador_conjugue'),	
    comprador_id bigint NOT NULL,
	nome character varying(150),
	cpf character varying(11) ,
	cel character varying(11),
	email character varying(150),	
    CONSTRAINT tb_comprador_conjugue_pkey PRIMARY KEY (id),
	CONSTRAINT tb_comprador_conjugue_fk_comprador_id FOREIGN KEY (comprador_id)
        REFERENCES public.tb_compradores (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_fiadores;

CREATE TABLE tb_fiadores
(
    id bigint NOT NULL DEFAULT nextval('seq_tb_fiadores'),
    nome character varying(150),
    rg character varying(25),
    cpf character varying(11),
    data_nasc date,
    estado_civil character varying(20),
    sexo character(1),	
	endereco character varying(150) ,
	numero character varying(10),	
    bairro character varying(100),
	complemento character varying(60),
	uf character(2),
	cidade character varying(100),
    cep character varying(8),
   	cod_ibge character varying(7),
	naturalidade character varying(60),
	nacionalidade character varying(60),
    fone character varying(11),
    cel character varying(11),
    email character varying(150),
    data_cadastro date DEFAULT CURRENT_DATE,
    ativo boolean DEFAULT true,
    obs character varying(200),
    CONSTRAINT tb_fiadores_pkey PRIMARY KEY (id),
	CONSTRAINT tb_fiadores_uk_cpf UNIQUE (cpf),
	CONSTRAINT tb_fiadores_ck_sexo CHECK (sexo IN ('F','M','X'))
);

CREATE SEQUENCE seq_tb_fiador_bancos;

CREATE TABLE tb_fiador_bancos
(
    id bigint NOT NULL DEFAULT nextval('seq_tb_fiador_bancos'),
	fiador_id bigint NOT NULL,
	pix character varying(255),
    codigo_banco character varying(4),
	nome character varying(60),
    numero_agencia character varying(10),
    numero_conta character varying(11),
    tipo_conta character(1),
	favorecido character varying(150) ,
	cpf_cnpj character varying(10),	
    data_cadastro date DEFAULT CURRENT_DATE,
    obs character varying(200),
	ativo boolean DEFAULT true,
    CONSTRAINT tb_fiador_bancos_pkey PRIMARY KEY (id),
	CONSTRAINT tb_fiador_bancos_uk_pix UNIQUE (pix),
	CONSTRAINT tb_fiador_bancos_fk_fiador_id FOREIGN KEY (fiador_id)
        REFERENCES public.tb_fiadores (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_fiador_referencias;

CREATE TABLE tb_fiador_referencias (
	id bigint NOT NULL default nextval('seq_tb_fiador_referencias'),	
	fiador_id bigint NOT NULL,
    nome character varying(150), 
	tipo character varying(30),
	fone character varying(11),
	obs character varying(20),
    CONSTRAINT tb_fiador_referencias_pkey PRIMARY KEY (id),
	CONSTRAINT tb_fiador_referencias_fk_fiador_id FOREIGN KEY (fiador_id)
        REFERENCES public.tb_fiadores (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_fiador_trabalho;

CREATE TABLE tb_fiador_trabalho (
	id bigint NOT NULL default nextval('seq_tb_fiador_trabalho'),	
    fiador_id bigint NOT NULL,
    cargo character varying(30), 
	renda numeric(9,2) default 0,
	outraRenda numeric(9,2) default 0,
	empresa character varying(150),
	cnpj character varying(14) ,
	data_admissao date,
	fone character varying(11),
	email character varying(150),	
	endereco character varying(150) ,
	numero character varying(10),	
    bairro character varying(100),
	complemento character varying(60),
	uf character(2),
	cidade character varying(100),
    cep character varying(8),
   	cod_ibge character varying(7)	
    CONSTRAINT tb_fiador_trabalho_pkey PRIMARY KEY (id),
	CONSTRAINT tb_fiador_trabalho_fk_fiador_id FOREIGN KEY (fiador_id)
        REFERENCES public.tb_fiadores (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_fiador_conjugue;

CREATE TABLE tb_fiador_conjugue (
	id bigint NOT NULL default nextval('seq_tb_fiador_conjugue'),	
    fiador_id bigint NOT NULL,
	nome character varying(150),
	cpf character varying(11) ,
	cel character varying(11),
	email character varying(150),	
    CONSTRAINT tb_fiador_conjugue_pkey PRIMARY KEY (id),
	CONSTRAINT tb_fiador_conjugue_fk_fiador_id FOREIGN KEY (fiador_id)
        REFERENCES public.tb_fiadores (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_bancos;

CREATE TABLE tb_bancos
(
    id bigint NOT NULL DEFAULT nextval('seq_tb_bancos'),
	pix character varying(255),
    codigo_banco character varying(4),
	nome character varying(60),
    numero_agencia character varying(10),
    numero_conta character varying(11),
  	nome_agencia character varying(60),
	gerente character varying(150) ,
	fone character varying(11),	
    data_cadastro date DEFAULT CURRENT_DATE,
    obs character varying(200),
	ativo boolean DEFAULT true,
    CONSTRAINT tb_bancos_pkey PRIMARY KEY (id),
	CONSTRAINT tb_bancos_uk_pix UNIQUE (pix)
);

CREATE TABLE tb_plano_contas
(
    codigo character varying(5) NOT NULL,
	descricao character varying(40) NOT NULL,
    tipo_conta int NOT NULL,
    data_cadastro date DEFAULT CURRENT_DATE,   
	ativo boolean DEFAULT true,
    CONSTRAINT tb_plano_contas_pkey PRIMARY KEY (codigo)
);

CREATE SEQUENCE seq_tb_empresa;

CREATE TABLE tb_empresa (
	id bigint NOT NULL default nextval('seq_tb_empresa'),	
    nome character varying(150),
	nome_fantasia character varying(150),
	ie character varying(25),
	im character varying(25),
    cnpj character varying(14), 
    data_expedicao date,
    endereco character varying(150),
	numero character varying(10),
	bairro character varying(100),
	complemento character varying(60),
    uf character(2),
	cidade character varying(100),
	cep character varying(8),
	cod_ibge character varying(7),
    fone character varying(11),
    cel character varying(11),
    email character varying(150),	
	data_cadastro date DEFAULT CURRENT_DATE,
    CONSTRAINT tb_empresa_pkey PRIMARY KEY (id),
	CONSTRAINT tb_empresa_uk_cnpj UNIQUE (cnpj)	
);

CREATE SEQUENCE seq_tb_contratos;

CREATE TABLE tb_contratos
(
    id bigint NOT NULL DEFAULT nextval('seq_tb_contratos'),
    grupo character varying(30) NOT NULL,
    titulo character varying(60) NOT NULL,
    descricao bytea,
    data_cadastro date DEFAULT CURRENT_DATE,
    ativo boolean DEFAULT true,
    CONSTRAINT tb_contratos_pkey PRIMARY KEY (id)
)

CREATE SEQUENCE seq_tb_tipos_imoveis;

CREATE TABLE tb_tipos_imoveis (
	id bigint NOT NULL default nextval('seq_tb_tipos_imoveis'),	
    descricao character varying(50), 
	data_cadastro date DEFAULT CURRENT_DATE,
	ativo boolean,	
    CONSTRAINT tb_tipos_imoveis_pkey PRIMARY KEY (id),
	CONSTRAINT tb_tipos_imoveis_uk_descricao UNIQUE (descricao)	
);

CREATE SEQUENCE seq_tb_imoveis;

CREATE TABLE tb_imoveis (
	id bigint NOT NULL default nextval('seq_tb_imoveis'),	
    titulo character varying(100), 
	proprietario_id bigint NOT NULL,	
	referencia character varying(100),
	data_captacao date,
	data_exclusividade date,
	obs character varying(200),
	valor_locacao numeric(9,2) default 0,
	valor_venda numeric(9,2) default 0,
	valor_iptu numeric(9,2) default 0,	
	quarto int default 0,
    suite int default 0,
	banheiro int default 0,
	sala int default 0,
	vaga_coberta int default 0,
	vaga_descoberta int default 0,
	varanda int default 0,
	area_total numeric(9,2) default 0,	
	area_construida numeric(9,2) default 0,
	tipo_imovel_id int not null,	
	finalidade int not null default 0,
	situacao int not null default 1,
	ocupacao int not null default 0,
	registro_prefeitura character varying(15),	
	registro_matricula character varying(15),
	registro_energia character varying(15),
	registro_agua character varying(15),
	data_construcao date,		
	data_cadastro date DEFAULT CURRENT_DATE,
    CONSTRAINT tb_imoveis_pkey PRIMARY KEY (id),
	CONSTRAINT tb_imoveis_ck_finalidade CHECK (finalidade >= 0 AND finalidade < 3),
	CONSTRAINT tb_imoveis_ck_situacao CHECK (situacao >= 0 AND situacao < 8),
	CONSTRAINT tb_imoveis_ck_ocupacao CHECK (ocupacao >= 0 AND ocupacao < 3),
	CONSTRAINT tb_imoveis_fk_tipo_imovel_id FOREIGN KEY (tipo_imovel_id)
        REFERENCES public.tb_tipos_imoveis (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE seq_tb_imovel_documentos;

CREATE TABLE tb_imovel_documentos (
	id bigint NOT NULL default nextval('seq_tb_imovel_documentos'),	
	imovel_id bigint not null,
    categoria character varying(30), 
	titulo character varying(50), 
	documento bytea, 
	data_cadastro date DEFAULT CURRENT_DATE,
    CONSTRAINT tb_imovel_documentos_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE seq_tb_caracteristicas;

CREATE TABLE tb_caracteristicas (
	id bigint NOT NULL default nextval('seq_tb_caracteristicas'),	
    categoria character varying(30), 
	descricao character varying(50), 
	data_cadastro date DEFAULT CURRENT_DATE,
	ativo boolean,
    CONSTRAINT tb_caracteristicas_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE seq_tb_imovel_caracteristicas;

CREATE TABLE tb_imovel_caracteristicas (
	id bigint NOT NULL default nextval('seq_tb_imovel_caracteristicas'),
	imovel_id bigint not null, 
	caracteristica_id bigint not null, 
    CONSTRAINT tb_imovel_caracteristicas_pkey PRIMARY KEY (id),
	CONSTRAINT tb_imovel_caracteristicas_fk_imovel_id FOREIGN KEY (imovel_id)
        REFERENCES public.tb_imoveis (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
	CONSTRAINT tb_imovel_caracteristicas_fk_caracteristica_id FOREIGN KEY (caracteristica_id)
        REFERENCES public.tb_caracteristicas (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_tb_cidades;

CREATE TABLE tb_cidades (
    id bigint NOT NULL default nextval('seq_tb_cidades'),
    cod_ibge character varying(7),		
	cep character varying(8),   
	uf character(2),
	cidade character varying(100),
    cod_uf character(2)   
);


