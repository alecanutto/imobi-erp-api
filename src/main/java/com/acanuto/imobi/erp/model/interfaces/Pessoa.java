package com.acanuto.imobi.erp.model.interfaces;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa extends Endereco {

	@Id
	private long id;

	private String nome;

	private String rg;

	private String cpf;

	private Date dataNasc;

	private String estadoCivil;

	private String sexo;	

	private String naturalidade;

	private String nacionalidade;

	private String fone;

	private String cel;

	private String email;

	private Date dataCadastro;

	private boolean ativo;

	private String obs;	

}
