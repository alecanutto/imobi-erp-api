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
	
	@ApiModelProperty(notes = "Código")
	private long id;

	@ApiModelProperty(notes = "Nome", required = true)
	@NotBlank(message = "O campo nome é obrigatório.")
	@Size(max = 150, message = "O campo nome deve conter no máximo 150 caracteres.")
	private String nome;	
	
	@ApiModelProperty(notes = "Nome fantasia")
	@Size(max = 150, message = "O campo nome fantasia deve conter no máximo 150 caracteres.")
	private String nomeFantasia;

	@ApiModelProperty(notes = "Inscrição Estadual")
	@Size(max = 150, message = "O campo inscrição estadual deve conter no máximo 25 caracteres.")
	private String ie;
	
	@ApiModelProperty(notes = "Inscrição Municipal")
	@Size(max = 150, message = "O campo endereço deve conter no máximo 150 caracteres.")
	private String im;

	@ApiModelProperty(notes = "CNPJ", required = true)
	@NotBlank(message = "O campo cnpj é obrigatório.")
	@Size(max = 14, message = "O campo cnpj deve conter no máximo 14 caracteres.")
	private String cnpj;
	
	@ApiModelProperty(notes = "Data de expedição")
	@Size(max = 6, message = "O campo data de expedição deve conter no máximo 150 caracteres.")
	private Date dataExpedicao;
	
	@ApiModelProperty(notes = "Complemento")
	@Size(max = 60, message = "O campo complemento deve conter no máximo 60 caracteres.")
	private String complemento;

	@ApiModelProperty(notes = "Endereço")
	@Size(max = 150, message = "O campo endereço deve conter no máximo 150 caracteres.")
	private String endereco;
	
	@ApiModelProperty(notes = "Número")
	@Size(max = 10, message = "O campo número deve conter no máximo 10 caracteres.")
	private String numero;
	
	@ApiModelProperty(notes = "Bairro")
	@Size(max = 100, message = "O campo bairro deve conter no máximo 100 caracteres.")
	private String bairro;
	
	@ApiModelProperty(notes = "UF")
	@Size(max = 2, message = "o campo uf deve conter no máximo 2 caracteres.")
	private String uf;
	
	@ApiModelProperty(notes = "Cidade")
	@Size(max = 100, message = "O campo cidade deve conter no máximo 100 caracteres.")
	private String cidade;
	
	@ApiModelProperty(notes = "CEP")
	@Size(max = 8, message = "O campo cep deve conter no máximo 8 dígitos.")
	private String cep;
	
	@ApiModelProperty(notes = "Código do IBGE")
	@Size(max = 7, message = "O campo código do ibge deve conter no máximo 7 dígitos.")
	private String codIbge;
	
	@ApiModelProperty(notes = "Número de telefone")
	@Size(max = 11, message = "O campo telefone deve conter no máximo 11 dígitos.")
	private String fone;
	
	@ApiModelProperty(notes = "Número de celular")
	@Size(max = 11, message = "O campo celular deve conter no máximo 11 dígitos.")
	private String cel;
		
	@ApiModelProperty(notes = "E-mail")
	@Size(max = 150, message = "O campo e-mail deve conter no máximo 150 caracteres.")
	private String email;
	
	@ApiModelProperty(notes = "Site")
	@Size(max = 150, message = "O campo site deve conter no máximo 150 caracteres.")
	private String site;	
	
}
