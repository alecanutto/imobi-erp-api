package com.acanuto.imobi.erp.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "tb_caracteristicas")
public class Caracteristicas {

	@Id
	private long id;

	private String categoria;

	private String descricao;

	private Date dataCadastro;

	private boolean ativo;

}
