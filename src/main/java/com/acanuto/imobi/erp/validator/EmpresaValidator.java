package com.acanuto.imobi.erp.validator;

import java.util.ArrayList;
import java.util.List;

import com.acanuto.imobi.erp.model.Empresa;
import com.acanuto.imobi.erp.util.Function;

import lombok.Getter;
import lombok.Setter;

public class EmpresaValidator {
	
	private Empresa empresa;

	public EmpresaValidator(Empresa empresa) {
		this.empresa = empresa;
	}

	@Getter
	@Setter
	private List<String> listErrors = new ArrayList<String>();

	public boolean validate() {
		if (!Function.ValidCNPJ(empresa.getCnpj())) {
			listErrors.add("CNPJ inválido.");
		}

		return listErrors.size() == 0;
	}
}
