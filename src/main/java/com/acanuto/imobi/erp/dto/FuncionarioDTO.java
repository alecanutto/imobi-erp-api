package com.acanuto.imobi.erp.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.acanuto.imobi.erp.dto.interfaces.PessoaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDTO extends PessoaDTO {
	
	@ApiModelProperty(notes = "Cargo")
	@Size(max = 30, message = "O campo cargo deve conter no m�ximo 30 caracteres.")
	private String cargo;
	
	@ApiModelProperty(notes = "Remunera��o")
	@Digits(integer = 9, fraction = 2)
	@PositiveOrZero(message = "O valor de remunera��o deve ser um n�mero positivo ou zero.")
	private BigDecimal remuneracao;
	
	@ApiModelProperty(notes = "Usu�rio")
	@Size(max = 30, message = "O campo usu�rio deve conter no m�ximo 30 caracteres.")
	private String usuario;
	
	@ApiModelProperty(notes = "Senha")
	@Size(min = 4, message = "O campo senha deve conter no m�nimo 4 caracteres.")
	private String senha;
	
	@ApiModelProperty(notes = "Usuario")
	private boolean usuarioSistema;

	@ApiModelProperty(notes = "Data de admiss�o")
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private Date dataAdmissao;

	@ApiModelProperty(notes = "Data de demiss�o")
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private Date dataDemissao;

}
