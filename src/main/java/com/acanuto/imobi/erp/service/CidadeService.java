package com.acanuto.imobi.erp.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.CidadeDTO;
import com.acanuto.imobi.erp.model.Cidade;
import com.acanuto.imobi.erp.repository.CidadeRepository;

@Component
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public Cidade save(CidadeDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}

		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		Cidade cidade = modelMapper.map(dto, Cidade.class);
		return repository.save(cidade);

	}

	public Cidade getByUfAndCidade(String uf, String cidade) {
		return repository.findByUfAndCidadeStartingWith(uf, cidade);
	}

	public List<Cidade> getAllByUf(String uf) {
		return repository.findAllByUf(uf);
	}

	public List<Cidade> getAllUF() {
		return repository.findAllUf();
	}

	public List<Cidade> getAll() {
		List<Cidade> cidades = new ArrayList<>();
		repository.findAll().forEach(cidades::add);
		return cidades;
	}

	public void deleteById(long id) {
		repository.deleteById(id);
	}

}