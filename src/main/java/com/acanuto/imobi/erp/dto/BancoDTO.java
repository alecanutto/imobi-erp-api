package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.Size;

import com.acanuto.imobi.erp.dto.interfaces.IBancoDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BancoDTO extends IBancoDTO{
	
	@ApiModelProperty(notes = "Nome da agência")
	@Size(max = 60, message = "O campo nome da agência deve conter no máximo 60 caracteres.")
	private String nomeAgencia;	

	@ApiModelProperty(notes = "Gerente")
	@Size(max = 150, message = "O campo gerente deve conter no máximo 150 caracteres.")
	private String gerente;
	
	@ApiModelProperty(notes = "Telefone")
	@Size(max = 11, message = "O campo telefone deve conter no máximo 11 caracteres.")
	private String fone;
	
}
