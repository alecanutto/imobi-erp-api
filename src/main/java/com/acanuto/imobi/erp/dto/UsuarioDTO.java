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

	@ApiModelProperty(notes = "Nome do usu�rio", required = true)
	@NotBlank(message = "Usu�rio deve ser preenchido corretamente.")
	private String usuario;

	@ApiModelProperty(notes = "Senha do usu�rio", required = true)
	@NotBlank(message = "Senha deve ser preenchida corretamente.")
	@Size(min = 6, message = "Senha deve conter no m�nimo 6 caracteres.")
	private String senha;
	
	@ApiModelProperty(notes = "Status do usu�rio")
	private boolean ativo;

}
