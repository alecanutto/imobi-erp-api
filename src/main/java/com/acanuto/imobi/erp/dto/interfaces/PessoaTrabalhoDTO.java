package com.acanuto.imobi.erp.dto.interfaces;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class PessoaTrabalhoDTO extends EnderecoDTO {
	
	@ApiModelProperty(notes = "C�digo")
	private long id;
	
	@ApiModelProperty(notes = "Cargo")
	@Size(max = 30, message = "O campo cargo deve conter no m�ximo 30 caracteres.")
	private String cargo;
	
	@ApiModelProperty(notes = "Favorecido")
	@Digits(integer = 9, fraction = 2)
	@PositiveOrZero(message = "O valor de renda deve ser um n�mero positivo ou zero.")
	private double renda;
	
	@ApiModelProperty(notes = "Favorecido")
	@Digits(integer = 9, fraction = 2)
	@PositiveOrZero(message = "O valor de outras rendas deve ser um n�mero positivo ou zero.")
	private double outraRenda;
			
	@ApiModelProperty(notes = "Empresa")
	@Size(max = 150, message = "O campo empresa deve conter no m�ximo 150 caracteres.")
	private String empresa;
	
	@ApiModelProperty(notes = "CNPJ")
	@Size(max = 14, message = "O campo cnpj deve conter no m�ximo 14 caracteres.")
	private String cnpj;
	
	@ApiModelProperty(notes = "Data Admiss�o")
	private Date dataAdmissao;
	
	@ApiModelProperty(notes = "N�mero de telefone")
	@Size(max = 11, message = "O campo telefone deve conter no m�ximo 11 d�gitos.")
	private String fone;
		
	@ApiModelProperty(notes = "E-mail")
	@Size(max = 150, message = "O campo e-mail deve conter no m�ximo 150 caracteres.")
	private String email;

}
