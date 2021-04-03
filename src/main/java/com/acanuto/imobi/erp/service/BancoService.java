package com.acanuto.imobi.erp.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.BancoDTO;
import com.acanuto.imobi.erp.model.Banco;
import com.acanuto.imobi.erp.repository.BancoRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;

@Component
public class BancoService {
	
	@Autowired
	private ManipulateDB db;

	@Autowired
	private BancoRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public Banco save(BancoDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados da conta bancária inválida!");
		}
		
		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		Banco banco = modelMapper.map(dto, Banco.class);
	
		// verifica se já existe um número pix cadastrado
		String nome = (String) db.getField("select nome from tb_bancos where id <> " + banco.getId()
				+ " and pix = '" + banco.getPix() + "';");

		if (StringUtils.hasText(nome)) {
			throw new Exception("Pix já cadastrado para o banco " + nome + "!");
		}
		
		return repository.save(banco);

	}

	public Optional<Banco> getById(long id) {
		return repository.findById(id);
	}	

	public Optional<Banco> getByPix(String pix) {
		return repository.findByPix(pix);
	}

	public Iterable<Banco> getAll() {
		return repository.findAll();
	}

}
