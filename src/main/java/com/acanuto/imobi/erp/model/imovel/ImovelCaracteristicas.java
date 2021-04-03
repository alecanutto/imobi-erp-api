package com.acanuto.imobi.erp.model.imovel;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "tb_imovel_caracteristicas")
public class ImovelCaracteristicas {

	@Id
	private long id;
	
	private long imovelId;

	private long caracteristicaId;
	
}
