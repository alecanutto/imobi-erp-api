package com.acanuto.imobi.erp.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.model.Funcionario;
import com.acanuto.imobi.erp.util.Function;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioValidator {

	private Funcionario funcionario;

	public FuncionarioValidator(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	private List<String> listErrors = new ArrayList<String>();

	public boolean validate() {
		if (StringUtils.hasText(funcionario.getCpf()) && !Function.ValidCPF(funcionario.getCpf())) {
			listErrors.add("CPF inválido.");
		}

		return listErrors.size() == 0;
	}

}
