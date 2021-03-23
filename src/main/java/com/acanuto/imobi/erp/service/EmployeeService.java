package com.acanuto.imobi.erp.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.EmployeeDTO;
import com.acanuto.imobi.erp.model.Employee;
import com.acanuto.imobi.erp.model.User;
import com.acanuto.imobi.erp.repository.EmployeeRepository;
import com.acanuto.imobi.erp.repository.UserRepository;
import com.acanuto.imobi.erp.validator.EmployeeValidator;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private ModelMapper modelMapper;	

	private EmployeeValidator employeeValidator;

	public Employee save(EmployeeDTO employeeDTO) throws Exception {
		
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		employeeValidator = new EmployeeValidator(employee);
		employeeValidator.validate();
		
		if (!employeeValidator.isValid()) {
			throw new Exception(StringUtils.collectionToDelimitedString(employeeValidator.getListErrors(), ","));
		}
		if (repository.existsByCPF(employee.getCpf())) {
			throw new Exception("CPF já cadastrado!");
		}
		if (userRepository.existsByUsername(employeeDTO.getLogin().getUsuario())) {
			throw new Exception("Login já cadastrado!");
		}

		employee = repository.save(employee);

		// register new user
		if (employeeDTO.getLogin() != null && StringUtils.hasText(employeeDTO.getLogin().getUsuario())
				&& StringUtils.hasText(employeeDTO.getLogin().getSenha())) {
			String passwordCript = encoder.encode(employeeDTO.getLogin().getSenha());
			employeeDTO.getLogin().setSenha(passwordCript);
			User user = new User(employee.getId(), employeeDTO.getLogin().getUsuario(),
					employeeDTO.getLogin().getSenha(), employeeDTO.getLogin().isAtivo());
			userRepository.save(user);
		}

		return repository.save(employee);

	}

	public Optional<Employee> getById(long id) {
		return repository.findById(id);
	}

	public Optional<Employee> getByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	public Optional<Employee> getByUsername(String username) {
		return repository.findByUsername(username);
	}

	public Iterable<Employee> getAll() {
		return repository.findAll();
	}

}
