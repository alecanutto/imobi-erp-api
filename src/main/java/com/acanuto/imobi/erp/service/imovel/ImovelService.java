package com.acanuto.imobi.erp.service.imovel;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.dto.imovel.ImovelDTO;
import com.acanuto.imobi.erp.enums.Enums.EnumFinalidadeImovel;
import com.acanuto.imobi.erp.enums.Enums.EnumOcupacaoImovel;
import com.acanuto.imobi.erp.enums.Enums.EnumSituacaoImovel;
import com.acanuto.imobi.erp.model.imovel.Imovel;
import com.acanuto.imobi.erp.repository.imovel.ImovelRepository;

@Component
public class ImovelService {

	@Autowired
	private ImovelRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public Imovel save(ImovelDTO dto) throws Exception {

		if (dto == null) {
			throw new Exception("Dados é inválido!");
		}

		if (dto.getId() > 0 && !repository.existsById(dto.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}

		Imovel imovel = modelMapper.map(dto, Imovel.class);

		return repository.save(imovel);

	}

	public Optional<Imovel> getById(long id) {
		return repository.findById(id);
	}

	public void deleteById(long id) {
		repository.deleteById(id);
	}

	public List<Imovel> getAll() {
		return repository.findAll();
	}

	public List<Imovel> getAllByFinalidade(EnumFinalidadeImovel finalidade) {
		return repository.findAllByFinalidade(finalidade);
	}

	public List<Imovel> getAllBySituacao(EnumSituacaoImovel situacao) {
		return repository.findAllBySituacao(situacao);
	}

	public List<Imovel> getAllByOcupacao(EnumOcupacaoImovel ocupacao) {
		return repository.findAllByOcupacao(ocupacao);
	}

	public List<Imovel> getAllByImovelTipoId(long imovelTipoId) {
		return repository.findAllByImovelTipoId(imovelTipoId);
	}

	public List<Imovel> getAllByDataCadastroBetween(Date dataInicial, Date dataFinal) {
		return repository.findAllByDataCadastroBetween(dataInicial, dataFinal);
	}

	public List<Imovel> getAllByDataCaptacaoBetween(Date dataInicial, Date dataFinal) {
		return repository.findAllByDataCaptacaoBetween(dataInicial, dataFinal);
	}

	public Optional<Imovel> getByTituloStartingWith(String titulo) {
		return repository.findByTituloStartingWith(titulo);
	}

}
