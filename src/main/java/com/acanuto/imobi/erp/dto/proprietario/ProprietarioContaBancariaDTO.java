package com.acanuto.imobi.erp.dto.proprietario;

import com.acanuto.imobi.erp.dto.interfaces.PessoaContaBancariaDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProprietarioContaBancariaDTO extends PessoaContaBancariaDTO {
	
	@ApiModelProperty(notes = "C�digo do propriet�rio", required = true)
	private long proprietarioId;
	
}
