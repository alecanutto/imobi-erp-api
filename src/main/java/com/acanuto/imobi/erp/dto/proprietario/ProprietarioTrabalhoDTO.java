package com.acanuto.imobi.erp.dto.proprietario;

import com.acanuto.imobi.erp.dto.interfaces.PessoaTrabalhoDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProprietarioTrabalhoDTO extends PessoaTrabalhoDTO {

	@ApiModelProperty(notes = "Código do proprietário", required = true)
	private long proprietarioId;
	
}
