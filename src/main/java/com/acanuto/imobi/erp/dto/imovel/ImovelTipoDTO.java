package com.acanuto.imobi.erp.dto.imovel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelTipoDTO {
	
	@ApiModelProperty(notes = "Código")
	private long id;

	@ApiModelProperty(notes = "Descrição", required = true)
	@NotBlank(message = "O campo descrição é obrigatório.")
	@Size(max = 30, message = "O campo descrição deve conter no máximo 50 caracteres.")
	private String descricao;
		
	@ApiModelProperty(notes = "Status")
	private boolean ativo;

}
