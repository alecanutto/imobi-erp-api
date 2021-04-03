package com.acanuto.imobi.erp.dto.comprador;

import com.acanuto.imobi.erp.dto.interfaces.PessoaContaBancariaDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompradorContaBancariaDTO extends PessoaContaBancariaDTO {
	
	@ApiModelProperty(notes = "Código do comprador", required = true)
	private long compradorId;
	
}
