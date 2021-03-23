package com.acanuto.imobi.erp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "tbl_funcionarios")
public class Employee {

	@Id
	@Column(value = "campo0")
	private long id;

	@Column(value = "campo1")
	private String nome;

	@Column(value = "campo2")
	private String rg;

	@Column(value = "campo3")
	private String cpf;

	@Column(value = "campo4")
	private LocalDate dataNasc;

	@Column(value = "campo5")
	private String endereco;

	@Column(value = "campo6")
	private String numero;

	@Column(value = "campo7")
	private String bairro;

	@Column(value = "campo8")
	private String uf;

	@Column(value = "campo9")
	private String cidade;

	@Column(value = "campo10")
	private String cep;

	@Column(value = "campo11")
	private String codIbge;

	@Column(value = "campo12")
	private String fone;

	@Column(value = "campo13")
	private String cel;

	@Column(value = "campo14")
	private String email;

	@Column(value = "campo15")
	private String cargo;

	@Column(value = "campo16")
	private BigDecimal remuneracao;

	@Column(value = "campo17")
	private LocalDate dataCadastro;

	@Column(value = "campo18")
	private LocalDate dataAdmissao;

	@Column(value = "campo19")
	private LocalDate dataDemissao;

	@Column(value = "campo20")
	private boolean ativo;

	@Column(value = "campo21")
	private String obs;	

}
