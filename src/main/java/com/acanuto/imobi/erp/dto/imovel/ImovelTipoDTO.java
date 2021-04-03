package com.acanuto.imobi.erp.dto.imovel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelTipoDTO {
	
	@ApiModelProperty(notes = "C�digo")
	private long id;

	@ApiModelProperty(notes = "Descri��o", required = true)
	@NotBlank(message = "O campo descri��o � obrigat�rio.")
	@Size(max = 30, message = "O campo descri��o deve conter no m�ximo 50 caracteres.")
	private String descricao;
		
	@ApiModelProperty(notes = "Status")
	private boolean ativo;

}
