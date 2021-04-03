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

	@ApiModelProperty(notes = "Código", required = true)
	@NotBlank(message = "O campo código é obrigatório.")
	@Size(max = 5, message = "O campo nome deve conter no máximo 5 caracteres.")
	private String codigo;

	@ApiModelProperty(notes = "Descrição", required = true)
	@NotBlank(message = "O campo descrição é obrigatório.")
	@Size(max = 40, message = "O campo descrição deve conter no máximo 40 caracteres.")
	private String descricao;

	@ApiModelProperty(notes = "Tipo da conta", required = true)
	private EnumTipoContaBancaria tipoConta;
	
	@ApiModelProperty(notes = "Status")
	private boolean ativo;

}
