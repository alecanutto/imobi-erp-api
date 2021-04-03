package com.acanuto.imobi.erp.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "tb_contratos")
public class Contrato {

	@Id
	private long id;
	
	private String grupo;

	private String titulo;

	private String descricao;
	
	private Date dataCadastro;
	
	private boolean ativo;
	
}
