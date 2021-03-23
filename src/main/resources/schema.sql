CREATE SEQUENCE seq_tbl_funcionarios;
CREATE SEQUENCE seq_tbl_usuarios;
CREATE SEQUENCE seq_tbl_permissoes;

CREATE TABLE tbl_funcionarios (
	campo0 bigint NOT NULL default nextval('seq_tbl_funcionarios'),	
    campo1 character varying(150),
	campo2 character varying(25),
    campo3 character varying(11), 
    campo4 date,
    campo5 character varying(150),
	campo6 character varying(10),
	campo7 character varying(100),
    campo8 character(2),
	campo9 character varying(100),
	campo10 character varying(8),
	campo11 character varying(7),
    campo12 character varying(11),
    campo13 character varying(11),
    campo14 character varying(150),	
    campo15 character varying(30),
    campo16 numeric(8,2),
    campo17 date DEFAULT CURRENT_DATE,
	campo18 date,
	campo19 date,
	campo20 boolean DEFAULT true, 
    campo21 character varying(200),	
    CONSTRAINT tbl_funcionarios_pkey PRIMARY KEY (campo0)
);

CREATE TABLE public.tbl_usuarios
(
    campo0 bigint NOT NULL default nextval('seq_tbl_usuarios'),
    campo1 bigint NOT NULL,
	campo2 character varying(30),
    campo3 character varying(255),
	campo4 boolean DEFAULT true,    
    CONSTRAINT tbl_usuarios_pkey PRIMARY KEY (campo0),
    CONSTRAINT tbl_usuarios_uk_campo2 UNIQUE (campo2),
    CONSTRAINT tbl_usuarios_fk_campo1 FOREIGN KEY (campo1)
        REFERENCES public.tbl_funcionarios (campo0) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE TABLE public.tbl_permissoes
(
    campo0 bigint NOT NULL default nextval('seq_tbl_permissoes'),
    campo1 character varying(4) NOT NULL,
    campo2 bigint NOT NULL,
    campo3 boolean DEFAULT false,
    CONSTRAINT tbl_permissoes_pkey PRIMARY KEY (campo0),
    CONSTRAINT tbl_permissoes_fk_campo2 FOREIGN KEY (campo2)
        REFERENCES public.tbl_usuarios (campo0) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

