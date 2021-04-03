package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.acanuto.imobi.erp.enums.Enums.EnumTipoContaBancaria;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanoContasDTO {

	@ApiModelProperty(notes = "C�digo", required = true)
	@NotBlank(message = "O campo c�digo � obrigat�rio.")
	@Size(max = 5, message = "O campo nome deve conter no m�ximo 5 caracteres.")
	private String codigo;

	@ApiModelProperty(notes = "Descri��o", required = true)
	@NotBlank(message = "O campo descri��o � obrigat�rio.")
	@Size(max = 40, message = "O campo descri��o deve conter no m�ximo 40 caracteres.")
	private String descricao;

	@ApiModelProperty(notes = "Tipo da conta", required = true)
	private EnumTipoContaBancaria tipoConta;
	
	@ApiModelProperty(notes = "Status")
	private boolean ativo;

}
