package com.acanuto.imobi.erp.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaDTO {
	
	@ApiModelProperty(notes = "C�digo")
	private long id;

	@ApiModelProperty(notes = "Nome", required = true)
	@NotBlank(message = "O campo nome � obrigat�rio.")
	@Size(max = 150, message = "O campo nome deve conter no m�ximo 150 caracteres.")
	private String nome;	
	
	@ApiModelProperty(notes = "Nome fantasia")
	@Size(max = 150, message = "O campo nome fantasia deve conter no m�ximo 150 caracteres.")
	private String nomeFantasia;

	@ApiModelProperty(notes = "Inscri��o Estadual")
	@Size(max = 150, message = "O campo inscri��o estadual deve conter no m�ximo 25 caracteres.")
	private String ie;
	
	@ApiModelProperty(notes = "Inscri��o Municipal")
	@Size(max = 150, message = "O campo endere�o deve conter no m�ximo 150 caracteres.")
	private String im;

	@ApiModelProperty(notes = "CNPJ", required = true)
	@NotBlank(message = "O campo cnpj � obrigat�rio.")
	@Size(max = 14, message = "O campo cnpj deve conter no m�ximo 14 caracteres.")
	private String cnpj;
	
	@ApiModelProperty(notes = "Data de expedi��o")
	@Size(max = 6, message = "O campo data de expedi��o deve conter no m�ximo 150 caracteres.")
	private Date dataExpedicao;
	
	@ApiModelProperty(notes = "Complemento")
	@Size(max = 60, message = "O campo complemento deve conter no m�ximo 60 caracteres.")
	private String complemento;

	@ApiModelProperty(notes = "Endere�o")
	@Size(max = 150, message = "O campo endere�o deve conter no m�ximo 150 caracteres.")
	private String endereco;
	
	@ApiModelProperty(notes = "N�mero")
	@Size(max = 10, message = "O campo n�mero deve conter no m�ximo 10 caracteres.")
	private String numero;
	
	@ApiModelProperty(notes = "Bairro")
	@Size(max = 100, message = "O campo bairro deve conter no m�ximo 100 caracteres.")
	private String bairro;
	
	@ApiModelProperty(notes = "UF")
	@Size(max = 2, message = "o campo uf deve conter no m�ximo 2 caracteres.")
	private String uf;
	
	@ApiModelProperty(notes = "Cidade")
	@Size(max = 100, message = "O campo cidade deve conter no m�ximo 100 caracteres.")
	private String cidade;
	
	@ApiModelProperty(notes = "CEP")
	@Size(max = 8, message = "O campo cep deve conter no m�ximo 8 d�gitos.")
	private String cep;
	
	@ApiModelProperty(notes = "C�digo do IBGE")
	@Size(max = 7, message = "O campo c�digo do ibge deve conter no m�ximo 7 d�gitos.")
	private String codIbge;
	
	@ApiModelProperty(notes = "N�mero de telefone")
	@Size(max = 11, message = "O campo telefone deve conter no m�ximo 11 d�gitos.")
	private String fone;
	
	@ApiModelProperty(notes = "N�mero de celular")
	@Size(max = 11, message = "O campo celular deve conter no m�ximo 11 d�gitos.")
	private String cel;
		
	@ApiModelProperty(notes = "E-mail")
	@Size(max = 150, message = "O campo e-mail deve conter no m�ximo 150 caracteres.")
	private String email;
	
	@ApiModelProperty(notes = "Site")
	@Size(max = 150, message = "O campo site deve conter no m�ximo 150 caracteres.")
	private String site;	
	
}
