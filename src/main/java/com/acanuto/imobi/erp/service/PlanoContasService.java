package com.acanuto.imobi.erp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.acanuto.imobi.erp.dto.PlanoContasDTO;
import com.acanuto.imobi.erp.model.PlanoContas;
import com.acanuto.imobi.erp.repository.PlanoContasRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;

@Component
public class PlanoContasService {

	@Autowired
	private ManipulateDB db;

	@Autowired
	private PlanoContasRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public PlanoContas save(PlanoContasDTO dto) throws Exception {
		try {

			if (dto == null) {
				throw new Exception("Dados do plano de contas inválida!", new NullPointerException());
			}
			
			if (!StringUtils.hasText(dto.getCodigo())) {
				throw new Exception("Código do planoo de contas é inválido!", new NullPointerException());
			}

			PlanoContas pContas = modelMapper.map(dto, PlanoContas.class);
			return repository.save(pContas);

		} catch (Exception e) {
			throw new Exception("Falha ao salvar dados!", e);
		}
	}

	public String getMaxGrupo() throws Exception {
		try {
			return (String) db.getField("select left(codigo, 2) from tb_plano_contas where tipo_conta = 1;");
		} catch (Exception e) {
			throw new Exception("Falha ao consultar MaxGrupo.", e);
		}
	}

	public String getMaxCodigo(String grupo) throws Exception {
		try {
			return (String) db.getField("select right(codigo, 2) from tb_plano_contas where tipo_conta <> 1 and left(codigo, 2) = " + grupo + ";");
		} catch (Exception e) {
			throw new Exception("Falha ao consultar MaxCódigo.", e);
		}
	}

	public Optional<PlanoContas> getByCodigo(String codigo) {
		return repository.findByCodigo(codigo);
	}

	public Optional<PlanoContas> getByDescricao(String descricao) {
		return repository.findByDescricao(descricao);
	}

	public List<PlanoContas> getAllByGrupo(String grupo) {
		return repository.findAllByGrupo(grupo);
	}

	public List<PlanoContas> getAllByTipo(int tipo) {
		return repository.findAllByTipo(tipo);
	}
}
