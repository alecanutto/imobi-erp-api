package com.acanuto.imobi.erp.dto.fiador;

import com.acanuto.imobi.erp.dto.interfaces.PessoaContaBancariaDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiadorContaBancariaDTO extends PessoaContaBancariaDTO {
	
	@ApiModelProperty(notes = "Código do fiador", required = true)
	private long fiadorId;
}
