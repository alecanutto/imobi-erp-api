package com.acanuto.imobi.erp.dto.interfaces;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class PessoaReferenciaDTO {

	@ApiModelProperty(notes = "C�digo")
	private long id;

	@ApiModelProperty(notes = "Nome", required = true)
	@NotBlank(message = "O campo nome � obrigat�rio.")
	@Size(max = 150, message = "O campo nome deve conter no m�ximo 150 caracteres.")
	private String nome;

	@ApiModelProperty(notes = "N�mero de telefone")
	@Size(max = 11, message = "O campo telefone deve conter no m�ximo 11 d�gitos.")
	private String fone;	
	
	@ApiModelProperty(notes = "Tipo")
	@Size(max = 30, message = "O campo tipo deve conter no m�ximo 30 d�gitos.")
	private String tipo;

	@ApiModelProperty(notes = "Observa��o")
	@Size(max = 200, message = "O observa��o tipo deve conter no m�ximo 200 d�gitos.")
	private String obs;
	
}
