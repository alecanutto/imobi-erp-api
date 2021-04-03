package com.acanuto.imobi.erp.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.model.interfaces.PessoaConjugue;
import com.acanuto.imobi.erp.util.Function;

import lombok.Getter;
import lombok.Setter;

public class PessoaConjugueValidator<T extends PessoaConjugue> {

	private T pessoa;

	public PessoaConjugueValidator(T pessoa) {
		this.pessoa = pessoa;
	}

	@Getter
	@Setter
	private List<String> listErrors = new ArrayList<String>();

	public boolean validate() {
		if (StringUtils.hasText(pessoa.getCpf()) && !Function.ValidCPF(pessoa.getCpf())) {
			listErrors.add("CPF inválido.");
		}
		return listErrors.size() == 0;
	}

}
