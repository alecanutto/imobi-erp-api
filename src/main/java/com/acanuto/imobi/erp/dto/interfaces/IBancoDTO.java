package com.acanuto.imobi.erp.dto.interfaces;

import java.util.Date;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IBancoDTO {

	@ApiModelProperty(notes = "Código")
	private long id;

	@ApiModelProperty(notes = "PIX")
	@Size(max = 255, message = "O campo pix deve conter no máximo 255 caracteres.")
	private String pix;

	@ApiModelProperty(notes = "Código do banco")
	@Size(max = 150, message = "O campo código do banco deve conter no máximo 150 caracteres.")
	private String codigoBanco;

	@ApiModelProperty(notes = "Nome do banco")
	@Size(max = 60, message = "O campo nome do banco deve conter no máximo 60 caracteres.")
	private String nome;

	@ApiModelProperty(notes = "Número da agência")
	@Size(max = 10, message = "O campo número agência deve conter no máximo 10 caracteres.")
	private String numeroAgencia;

	@ApiModelProperty(notes = "Número da conta")
	@Size(max = 10, message = "O campo número deve conter no máximo 10 caracteres.")
	private String numeroConta;

	@ApiModelProperty(notes = "Status do cadastro")
	private boolean ativo;

	@ApiModelProperty(notes = "Observações")
	@Size(max = 200, message = "O campo observação deve conter no máximo 200 caracteres.")
	private String obs;

	@ApiModelProperty(notes = "Data de cadastro")
	private Date dataCadastro;
	
}
