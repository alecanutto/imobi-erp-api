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

	@ApiModelProperty(notes = "Código")
	private long id;

	@ApiModelProperty(notes = "Nome", required = true)
	@NotBlank(message = "O campo nome é obrigatório.")
	@Size(max = 150, message = "O campo nome deve conter no máximo 150 caracteres.")
	private String nome;

	@ApiModelProperty(notes = "Número de telefone")
	@Size(max = 11, message = "O campo telefone deve conter no máximo 11 dígitos.")
	private String fone;	
	
	@ApiModelProperty(notes = "Tipo")
	@Size(max = 30, message = "O campo tipo deve conter no máximo 30 dígitos.")
	private String tipo;

	@ApiModelProperty(notes = "Observação")
	@Size(max = 200, message = "O observação tipo deve conter no máximo 200 dígitos.")
	private String obs;
	
}
