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
@Table(value = "tb_imovel_documentos")
public class ImovelDocumentos {

	@Id
	private long id;
	
	private long imovelId;

	private String categoria;
	
	private String titulo;
	
	private Byte documento; 
 	
	private Date dataCadastro;
		
}
