package com.acanuto.imobi.erp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {	

	private long id;
	private String nome;
	private String rg;
	private String cpf;
	private LocalDate dataNasc;
	private String endereco;
	private String numero;
	private String bairro;
	private String uf;
	private String cidade;
	private String cep;
	private String cod_ibge;
	private String fone;
	private String cel;
	private String email;
	private String cargo;
	private BigDecimal remuneracao;
	private LocalDate dataCadastro;
	private LocalDate dataAdmissao;
	private LocalDate dataDemissao;
	private boolean ativo;
	private String obs;	
	private UserDTO login;
	
}
