package com.acanuto.imobi.erp.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.acanuto.imobi.erp.model.interfaces.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDTO extends Pessoa {
	
	@ApiModelProperty(notes = "Cargo")
	@Size(max = 30, message = "O campo cargo deve conter no máximo 30 caracteres.")
	private String cargo;
	
	@ApiModelProperty(notes = "Remuneração")
	@Digits(integer = 9, fraction = 2)
	@PositiveOrZero(message = "O valor de remuneração deve ser um número positivo ou zero.")
	private BigDecimal remuneracao;

	@ApiModelProperty(notes = "Data de admissão")
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private Date dataAdmissao;

	@ApiModelProperty(notes = "Data de demissão")
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private Date dataDemissao;
	
	@ApiModelProperty(notes = "Dados de login")
	private UsuarioDTO login;

}
