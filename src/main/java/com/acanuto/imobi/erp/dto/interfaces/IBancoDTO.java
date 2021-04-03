package com.acanuto.imobi.erp.dto.interfaces;

import java.util.Date;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IBancoDTO {

	@ApiModelProperty(notes = "C�digo")
	private long id;

	@ApiModelProperty(notes = "PIX")
	@Size(max = 255, message = "O campo pix deve conter no m�ximo 255 caracteres.")
	private String pix;

	@ApiModelProperty(notes = "C�digo do banco")
	@Size(max = 150, message = "O campo c�digo do banco deve conter no m�ximo 150 caracteres.")
	private String codigoBanco;

	@ApiModelProperty(notes = "Nome do banco")
	@Size(max = 60, message = "O campo nome do banco deve conter no m�ximo 60 caracteres.")
	private String nome;

	@ApiModelProperty(notes = "N�mero da ag�ncia")
	@Size(max = 10, message = "O campo n�mero ag�ncia deve conter no m�ximo 10 caracteres.")
	private String numeroAgencia;

	@ApiModelProperty(notes = "N�mero da conta")
	@Size(max = 10, message = "O campo n�mero deve conter no m�ximo 10 caracteres.")
	private String numeroConta;

	@ApiModelProperty(notes = "Status do cadastro")
	private boolean ativo;

	@ApiModelProperty(notes = "Observa��es")
	@Size(max = 200, message = "O campo observa��o deve conter no m�ximo 200 caracteres.")
	private String obs;

	@ApiModelProperty(notes = "Data de cadastro")
	private Date dataCadastro;
	
}
