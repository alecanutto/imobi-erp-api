package com.acanuto.imobi.erp.service.imovel;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.imovel.ImovelTipoDTO;
import com.acanuto.imobi.erp.model.imovel.ImovelTipo;
import com.acanuto.imobi.erp.repository.imovel.ImovelTipoRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;

@Component
public class ImovelTipoService {

	@Autowired
	private ManipulateDB db;

	@Autowired
	private ImovelTipoRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public ImovelTipo save(ImovelTipoDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados da conta bancária inválida!");
		}

		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		ImovelTipo tipoImovel = modelMapper.map(dto, ImovelTipo.class);

		// verifica se já existe um registro cadastrado
		long id = (long) db.getField("select id from tb_tipos_imoveis where id <> " + tipoImovel.getId()
				+ " and descricao = '" + tipoImovel.getDescricao() + "';");

		if (id > 0) {
			throw new Exception("Descrição já cadastrado para o imóvel de registro n°. " + id + "!");
		}

		return repository.save(tipoImovel);

	}

	public Optional<ImovelTipo> getById(long id) {
		return repository.findById(id);
	}

	public void deleteById(long id) {
		repository.deleteById(id);
	}

	public List<ImovelTipo> getAll() {
		return repository.findAll();
	}

}
