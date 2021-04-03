package com.acanuto.imobi.erp.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.FuncionarioDTO;
import com.acanuto.imobi.erp.dto.UsuarioDTO;
import com.acanuto.imobi.erp.model.Funcionario;
import com.acanuto.imobi.erp.model.Usuario;
import com.acanuto.imobi.erp.repository.FuncionarioRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;
import com.acanuto.imobi.erp.validator.FuncionarioValidator;

@Component
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ManipulateDB db;

	private FuncionarioValidator funcionarioValidator;

	public Funcionario save(FuncionarioDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados do funcionário não informado!");
		}

		Funcionario func = modelMapper.map(dto, Funcionario.class);

		funcionarioValidator = new FuncionarioValidator(func);

		if (!funcionarioValidator.validate()) {
			throw new Exception(StringUtils.collectionToDelimitedString(funcionarioValidator.getListErrors(), ","));
		}
		if (StringUtils.hasLength(func.getCpf()) && funcionarioRepository.existsByCpf(func.getCpf())) {
			throw new Exception("CPF já cadastrado!");
		}

		if (dto.getLogin() != null && StringUtils.hasText(dto.getLogin().getUsuario())
				&& usuarioService.existsByLogin(dto.getLogin().getUsuario())) {
			throw new Exception("Login já cadastrado!");
		}

		func = funcionarioRepository.save(func);

		saveUser(dto.getLogin(), func.getId());

		return func;

	}

	public Funcionario update(FuncionarioDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados do funcionário não infomado!");
		}

		Funcionario func = modelMapper.map(dto, Funcionario.class);

		if (!funcionarioRepository.existsById(func.getId())) {
			throw new Exception("Registro não encontrado!");
		}

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

		if (dto.getLogin() != null && StringUtils.hasText(dto.getLogin().getUsuario())) {
			if ((boolean) db.getField("select exists (select id from tb_usuarios where funcionario_id <> "
					+ func.getId() + " and login = '" + dto.getLogin().getUsuario() + "');")) {
				throw new Exception("Login já cadastrado!");
			}
		}		

		func = funcionarioRepository.save(func);

		long idUsuario = (long) db.getField("select id from tb_usuarios where funcionario_id = " + func.getId());

		if (idUsuario > 0) {
			dto.setId(idUsuario);
			updateUser(dto.getLogin(), func.getId());
		} else {
			saveUser(dto.getLogin(), func.getId());
		}

		return func;

	}

	public Optional<Funcionario> getById(long id) {
		return funcionarioRepository.findById(id);
	}

	public Optional<Funcionario> getByCpf(String cpf) {
		return funcionarioRepository.findByCpf(cpf);
	}

	public Optional<Funcionario> getByUsername(String username) {
		return funcionarioRepository.findByLogin(username);
	}

	public Iterable<Funcionario> getAll() {
		return funcionarioRepository.findAll();
	}

	private void saveUser(UsuarioDTO usuario, long idFunc) throws Exception {
		Usuario user = new Usuario(0, idFunc, usuario.getUsuario(), usuario.getSenha(), usuario.isAtivo());
		usuarioService.save(user);
	}

	private void updateUser(UsuarioDTO usuario, long idFunc) throws Exception {
		Usuario user = new Usuario(0, idFunc, usuario.getUsuario(), usuario.getSenha(), usuario.isAtivo());
		usuarioService.update(user);
	}

}
