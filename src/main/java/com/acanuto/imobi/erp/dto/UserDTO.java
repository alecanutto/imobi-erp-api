package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

	@ApiModelProperty(notes = "Nome do usu�rio")
	@NotBlank(message = "Usu�rio deve ser preenchido corretamente.")
	private String usuario;

	@ApiModelProperty(notes = "Senha do usu�rio")
	@NotBlank(message = "Senha deve ser preenchida corretamente.")
	private String senha;
	
	@ApiModelProperty(notes = "Status do usu�rio")
	private boolean ativo;

}
