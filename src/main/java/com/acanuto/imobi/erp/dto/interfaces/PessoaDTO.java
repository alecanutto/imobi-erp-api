package com.acanuto.imobi.erp.dto.interfaces;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.acanuto.imobi.erp.enums.Enums.EnumSexo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PessoaDTO extends EnderecoDTO {

	@ApiModelProperty(notes = "C�digo")
	private long id;

	@ApiModelProperty(notes = "Nome", required = true)
	@NotBlank(message = "O campo nome � obrigat�rio.")
	@Size(max = 150, message = "O campo nome deve conter no m�ximo 150 caracteres.")
	private String nome;

	@ApiModelProperty(notes = "RG")
	@Size(max = 25, message = "O campo rg deve conter no m�ximo 25 caracteres.")
	private String rg;

	@ApiModelProperty(notes = "CPF")
	@Size(max = 11, message = "O campo cpf deve conter no m�ximo 11 d�gitos.")
	private String cpf;

	@ApiModelProperty(notes = "Data de nascimento")
	private Date dataNasc;
	
	@ApiModelProperty(notes = "Estado civil")
	@Size(max = 20, message = "O campo estado civil deve conter no m�ximo 20 caracteres.")
	private String estadoCivil;	

	@ApiModelProperty(notes = "Sexo")
	private EnumSexo sexo;
	
	@ApiModelProperty(notes = "Naturalidade")
	@Size(max = 60, message = "O campo naturalidade deve conter no m�ximo 60 caracteres.")
	private String naturalidade;

	@ApiModelProperty(notes = "Nacionalidade")
	@Size(max = 60, message = "O campo nacionalidade deve conter no m�ximo 60 caracteres.")
	private String nacionalidade;
	
	@ApiModelProperty(notes = "N�mero de telefone")
	@Size(max = 11, message = "O campo telefone deve conter no m�ximo 11 d�gitos.")
	private String fone;
	
	@ApiModelProperty(notes = "N�mero de celular")
	@Size(max = 11, message = "O campo celular deve conter no m�ximo 11 d�gitos.")
	private String cel;
		
	@ApiModelProperty(notes = "E-mail")
	@Size(max = 150, message = "O campo e-mail deve conter no m�ximo 150 caracteres.")
	private String email;

	@ApiModelProperty(notes = "Data de cadastro")
	private Date dataCadastro;
	
	@ApiModelProperty(notes = "Status do cadastro")
	private boolean ativo;
	
	@ApiModelProperty(notes = "Observa��o")
	@Size(max = 200, message = "O campo observa��o deve conter no m�ximo 200 caracteres.")
	private String obs;	
	
}
