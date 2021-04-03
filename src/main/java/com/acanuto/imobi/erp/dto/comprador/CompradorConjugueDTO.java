package com.acanuto.imobi.erp.dto.comprador;

import com.acanuto.imobi.erp.dto.interfaces.PessoaConjugueDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompradorConjugueDTO extends PessoaConjugueDTO {
	
	@ApiModelProperty(notes = "Código do comprador", required = true)
	private long compradorId;

}
