package com.acanuto.imobi.erp.dto.fiador;

import com.acanuto.imobi.erp.dto.interfaces.PessoaTrabalhoDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiadorTrabalhoDTO extends PessoaTrabalhoDTO {

	@ApiModelProperty(notes = "Código do fiador", required = true)
	private long fiadorId;
	
}
