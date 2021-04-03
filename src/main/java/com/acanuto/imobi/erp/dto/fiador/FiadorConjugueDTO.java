package com.acanuto.imobi.erp.dto.fiador;

import com.acanuto.imobi.erp.dto.interfaces.PessoaConjugueDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiadorConjugueDTO extends PessoaConjugueDTO {
	
	@ApiModelProperty(notes = "Código do fiador", required = true)
	private long fiadorId;

}
