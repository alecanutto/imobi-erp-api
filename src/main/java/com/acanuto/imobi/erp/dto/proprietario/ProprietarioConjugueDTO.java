package com.acanuto.imobi.erp.dto.proprietario;

import com.acanuto.imobi.erp.dto.interfaces.PessoaConjugueDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProprietarioConjugueDTO extends PessoaConjugueDTO {
	
	@ApiModelProperty(notes = "Código do proprietário", required = true)
	private long proprietarioId;

}
