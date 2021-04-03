package com.acanuto.imobi.erp.validator;

import java.util.ArrayList;
import java.util.List;

import com.acanuto.imobi.erp.model.interfaces.Pessoa;
import com.acanuto.imobi.erp.util.Function;

import lombok.Getter;
import lombok.Setter;

public class PessoaValidator<T extends Pessoa> {

	private T pessoa;

	public PessoaValidator(T pessoa) {
		this.pessoa = pessoa;
	}

	@Getter
	@Setter
	private List<String> listErrors = new ArrayList<String>();

	public boolean validate() {
		if (!Function.ValidCPF(pessoa.getCpf())) {
			listErrors.add("CPF inválido.");
		}
		return listErrors.size() == 0;
	}

}
