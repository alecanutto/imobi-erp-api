package com.acanuto.imobi.erp.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.model.Employee;
import com.acanuto.imobi.erp.util.Function;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeValidator {
	
	private Employee employee;
	
	public EmployeeValidator(Employee employee) {
		this.employee = employee;
	}
	
	private List<String> listErrors = new ArrayList<String>();

	private final boolean isValid = listErrors.size() == 0;

	public void validate() {
		if (StringUtils.hasText(employee.getCpf()) && !Function.ValidCPF(employee.getCpf())) {
				listErrors.add("CPF inválido.");			
		}
	}

}
