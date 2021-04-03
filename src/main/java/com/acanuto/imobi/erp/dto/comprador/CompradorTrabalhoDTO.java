package com.acanuto.imobi.erp.dto.comprador;

import com.acanuto.imobi.erp.dto.interfaces.PessoaTrabalhoDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompradorTrabalhoDTO extends PessoaTrabalhoDTO {

	@ApiModelProperty(notes = "Código do comprador", required = true)
	private long compradorId;
	
}
