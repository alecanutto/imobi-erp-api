package com.acanuto.imobi.erp.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.enums.Enums.EnumTipoContaBancaria;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "tb_plano_contas")
public class PlanoContas {
	
	@Id
	private String codigo;

	private String descricao;

	private EnumTipoContaBancaria tipoConta;
	
	private boolean ativo;
	
	private Date dataCadastro;

}
