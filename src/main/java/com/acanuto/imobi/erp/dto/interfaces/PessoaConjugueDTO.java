package com.acanuto.imobi.erp.dto.interfaces;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PessoaConjugueDTO {

	@ApiModelProperty(notes = "Tipo da conta")
	private long id;

	@ApiModelProperty(notes = "Nome")
	@Size(max = 150, message = "O campo nome deve conter no máximo 150 caracteres.")

	private String nome;

	@ApiModelProperty(notes = "CPF")
	@Size(max = 11, message = "O campo cpf deve conter no máximo 150 caracteres.")
	private String cpf;

	@ApiModelProperty(notes = "Celular")
	@Size(max = 11, message = "O campo celular deve conter no máximo 11 caracteres.")
	private String cel;

	@ApiModelProperty(notes = "Email")
	@Size(max = 150, message = "O campo email deve conter no máximo 150 caracteres.")
	private String email;

}
