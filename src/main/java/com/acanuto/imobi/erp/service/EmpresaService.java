package com.acanuto.imobi.erp.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.EmpresaDTO;
import com.acanuto.imobi.erp.model.Empresa;
import com.acanuto.imobi.erp.repository.EmpresaRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;
import com.acanuto.imobi.erp.validator.EmpresaValidator;

@Component
public class EmpresaService {

	@Autowired
	private ManipulateDB db;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmpresaRepository repository;

	private EmpresaValidator empresaValidator;

	public void save(EmpresaDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados da empresa não informado!");
		}

		if (repository.existsById(dto.getId())) {
			throw new Exception("Empresa já cadastrada!");
		}

		Empresa emp = modelMapper.map(dto, Empresa.class);
		
		empresaValidator = new EmpresaValidator(emp);

		if (!empresaValidator.validate()) {
			throw new Exception(StringUtils.collectionToDelimitedString(empresaValidator.getListErrors(), ","));
		}		

		String nome = (String) db.getField(
				"select nome from tb_empresa where id <> " + emp.getId() + " and cnpj = '" + emp.getCnpj() + "';");

		if (StringUtils.hasText(nome)) {
			throw new Exception("CNPJ já cadastrado para a empresa " + nome + "!");
		}

		repository.save(emp);
	}

	public Optional<Empresa> getById(long id) {
		return repository.findById(id);
	}

	public boolean existsById(long id) {
		return repository.existsById(id);
	}

	public Iterable<Empresa> getAll() {
		return repository.findAll();
	}

}
