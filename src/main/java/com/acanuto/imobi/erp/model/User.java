package com.acanuto.imobi.erp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "tbl_usuarios")
public class User {

	@Id
	@Column(value = "campo0")
	private long id;	

	@Column(value = "campo1")
	private long codFuncionario;

	@Column(value = "campo2")
	private String usuario;

	@Column(value = "campo3")
	private String senha;

	@Column(value = "campo4")
	private boolean ativo;
	
	public User(long codFuncionario, String usuario, String senha, boolean ativo) {
		super();
		this.codFuncionario = codFuncionario;
		this.usuario = usuario;
		this.senha = senha;
		this.ativo = ativo;
	}

}