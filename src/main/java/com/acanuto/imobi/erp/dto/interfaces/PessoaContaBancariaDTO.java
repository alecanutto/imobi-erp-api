package com.acanuto.imobi.erp.dto.interfaces;

import javax.validation.constraints.Size;

import com.acanuto.imobi.erp.enums.Enums.EnumTipoContaBancaria;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PessoaContaBancariaDTO extends IBancoDTO{

	@ApiModelProperty(notes = "Tipo da conta")
	private EnumTipoContaBancaria tipoConta;

	@ApiModelProperty(notes = "Favorecido")
	@Size(max = 150, message = "O campo favorecido deve conter no máximo 150 caracteres.")
	private String favorecido;

	@ApiModelProperty(notes = "CPF/CNPJ")
	@Size(max = 14, message = "O campo cnpf/cnpj deve conter no máximo 14 caracteres.")
	private String cpfCnpj;

}
