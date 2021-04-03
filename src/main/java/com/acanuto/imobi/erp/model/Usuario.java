package com.acanuto.imobi.erp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "tb_usuarios")
public class Usuario {

	@Id
	private long id;	

	private long funcionarioId;

	private String login;

	private String senha;

	private boolean ativo;

}