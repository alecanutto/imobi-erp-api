package com.acanuto.imobi.erp.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.FuncionarioDTO;
import com.acanuto.imobi.erp.model.Funcionario;
import com.acanuto.imobi.erp.repository.FuncionarioRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;
import com.acanuto.imobi.erp.validator.FuncionarioValidator;

@Component
public class FuncionarioService {

	@Autowired
	private ManipulateDB db;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private ModelMapper modelMapper;

	private FuncionarioValidator funcionarioValidator;

	@Autowired
	private FuncionarioRepository repository;

	public Funcionario save(FuncionarioDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados do funcionário não informado!");
		}

		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Registro não encontrado!");
		}

		Funcionario func = modelMapper.map(dto, Funcionario.class);

		funcionarioValidator = new FuncionarioValidator(func);

		if (!funcionarioValidator.validate()) {
			throw new Exception(StringUtils.collectionToDelimitedString(funcionarioValidator.getListErrors(), ","));
		}

		if (StringUtils.hasLength(func.getCpf())) {
			String nome = (String) db.getField("select nome from tb_funcionarios where id <> " + func.getId()
					+ " and cpf = '" + func.getCpf() + "';");

			if (StringUtils.hasText(nome)) {
				throw new Exception("CPF já cadastrado para o usuário " + nome + "!");
			}
		}

		if (StringUtils.hasText(dto.getUsuario())) {
			if ((boolean) db.getField("select exists (select id from tb_funcionarios where id <> " + func.getId()
					+ " and usuario = '" + dto.getUsuario() + "');")) {
				throw new Exception("Usuário já cadastrado!");
			}
		} else {
			throw new Exception("Usuário não informado!");
		}

		if (!StringUtils.hasText(func.getSenha())) {
			func.setSenha("1234");
		}

		func.setSenha(encoder.encode(func.getSenha()));

		try {
			return repository.save(func);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return func;

	}

	public Optional<Funcionario> getById(long id) {
		return repository.findById(id);
	}

	public Optional<Funcionario> getByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	public boolean alterSenha(long id, String senha) {

		if (!repository.existsById(id)) {
			return false;
//			throw new Exception("Registro não encontrado!");
		}

		if (!StringUtils.hasText(senha)) {
			senha = "1234";
		}

		senha = encoder.encode(senha);

		return db.execute("update tb_funcionarios set senha = '" + senha + "' where id = " + id);

	}

	public Optional<Funcionario> getByUsuario(String usuario) {
		return repository.findByUsuario(usuario);
	}

	public Iterable<Funcionario> getAll() {
		return repository.findAll();
	}

}
