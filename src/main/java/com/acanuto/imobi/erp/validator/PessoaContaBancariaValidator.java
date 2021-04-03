package com.acanuto.imobi.erp.validator;

import java.util.ArrayList;
import java.util.List;

import com.acanuto.imobi.erp.model.interfaces.PessoaContaBancaria;
import com.acanuto.imobi.erp.util.Function;

import lombok.Getter;
import lombok.Setter;

public class PessoaContaBancariaValidator<T extends PessoaContaBancaria> {

	private T pessoa;

	public PessoaContaBancariaValidator(T pessoa) {
		this.pessoa = pessoa;
	}

	@Getter
	@Setter
	private List<String> listErrors = new ArrayList<String>();

	public boolean validate() {
		
		String cpfCnpj = pessoa.getCpfCnpj();
		
		if (cpfCnpj.length() == 11) {
			if (!Function.ValidCPF(pessoa.getCpfCnpj())) {
				listErrors.add("CPF inválido.");
			}
		} else {
			if (!Function.ValidCNPJ(pessoa.getCpfCnpj())) {
				listErrors.add("CNPJ inválido.");
			}
		}		
		
		return listErrors.size() == 0;
	}

}