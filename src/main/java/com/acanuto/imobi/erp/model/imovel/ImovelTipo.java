package com.acanuto.imobi.erp.model.imovel;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "tb_tipo_imovel")
public class ImovelTipo {
	
	@Id
	private long id;

	private String descricao;
	
	private Date dataCadastro;
	
	private boolean ativo;

}
