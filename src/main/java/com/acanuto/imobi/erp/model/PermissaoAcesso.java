package com.acanuto.imobi.erp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "tb_permissoes")
public class PermissaoAcesso {

	@Id
	private long id;

	private String descricao;

	private long usuarioId;

	private boolean permitido;

}