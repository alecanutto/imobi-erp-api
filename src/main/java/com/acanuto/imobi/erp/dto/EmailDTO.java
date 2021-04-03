package com.acanuto.imobi.erp.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDTO {

	@ApiModelProperty(notes = "C�digo")
	private long id;

	@ApiModelProperty(notes = "Email")
	@Size(max = 150, message = "O campo email deve conter no m�ximo 150 caracteres.")
	private String email;

	@ApiModelProperty(notes = "Servidor")
	@Size(max = 150, message = "O campo servidor smpt deve conter no m�ximo 150 caracteres.")
	private String smtp;
	
	@ApiModelProperty(notes = "N�mero da porta")
	@Max(value = 9999, message = "O campo n�mero da porta n�o deve exceder 9999.")
	private int porta;
	
	@ApiModelProperty(notes = "Usu�rio")
	@Size(max = 150, message = "O campo usu�rio deve conter no m�ximo 150 caracteres.")
	private String usuario;
	
	@ApiModelProperty(notes = "Senha")
	@Size(max = 255, message = "O campo senha deve conter no m�ximo 255 caracteres.")
	private String senha;

	@ApiModelProperty(notes = "Suporta tls?")
	private boolean tls;
	
	@ApiModelProperty(notes = "Email de c�pia")
	@Size(max = 150, message = "O campo email de c�pia deve conter no m�ximo 150 caracteres.")
	private String copia;	
	
}
