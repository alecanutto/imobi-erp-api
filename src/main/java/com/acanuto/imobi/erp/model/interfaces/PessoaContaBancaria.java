package com.acanuto.imobi.erp.model.interfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class PessoaContaBancaria extends IBanco {

	private String tipoConta;

	private String favorecido;

	private String cpfCnpj;

}
