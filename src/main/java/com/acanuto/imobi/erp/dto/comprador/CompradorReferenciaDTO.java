package com.acanuto.imobi.erp.dto.comprador;

import com.acanuto.imobi.erp.dto.interfaces.PessoaReferenciaDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompradorReferenciaDTO extends PessoaReferenciaDTO {

	@ApiModelProperty(notes = "Código do comprador", required = true)
	private long compradorId;
	
}
