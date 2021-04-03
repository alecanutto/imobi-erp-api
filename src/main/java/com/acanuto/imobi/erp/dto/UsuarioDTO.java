package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO {

	@ApiModelProperty(notes = "Nome do usuário", required = true)
	@NotBlank(message = "Usuário deve ser preenchido corretamente.")
	private String usuario;

	@ApiModelProperty(notes = "Senha do usuário", required = true)
	@NotBlank(message = "Senha deve ser preenchida corretamente.")
	@Size(min = 6, message = "Senha deve conter no mínimo 6 caracteres.")
	private String senha;
	
	@ApiModelProperty(notes = "Status do usuário")
	private boolean ativo;

}
