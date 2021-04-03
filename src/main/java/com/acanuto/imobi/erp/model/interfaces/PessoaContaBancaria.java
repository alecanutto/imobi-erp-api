package com.acanuto.imobi.erp.model.interfaces;

import com.acanuto.imobi.erp.enums.Enums.EnumTipoContaBancaria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class PessoaContaBancaria extends IBanco {

	private EnumTipoContaBancaria tipoConta;

	private String favorecido;

	private String cpfCnpj;

}
