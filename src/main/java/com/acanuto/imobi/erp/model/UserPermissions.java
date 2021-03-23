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
@Table(value = "tbl_permissoes")
public class UserPermissions {

	@Id
	@Column(value = "campo0")
	private long id;

	@Column(value = "campo1")
	private String nomePermissao;
	
	@Column(value = "campo2")
	private long codUsuario;

	@Column(value = "campo3")
	private boolean permitido;

}