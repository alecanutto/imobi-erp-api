package com.acanuto.imobi.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acanuto.imobi.erp.model.PermissaoAcesso;
import com.acanuto.imobi.erp.repository.PermissaoAcessoRepository;
import com.acanuto.imobi.erp.util.ManipulateDB;

@Component
public class PermissaoAcessoService {
	
	@Autowired
	private ManipulateDB db;

	@Autowired
	private PermissaoAcessoRepository repository;

	public void save(PermissaoAcesso permissao) throws Exception {		
		
		if (permissao == null) {
			throw new Exception("Dados da permissão não informado!");
		}		
		
		// verificação de alteração de registro
		if (permissao.getId() > 0 && !repository.existsById(permissao.getId())) {
			throw new Exception("Cadastro não encontrado!");
		}
				
		if ((boolean) db.getField("select exists (select descricao from tb_permissoes where id <> "
				+ permissao.getId() + " and descricao = '" + permissao.getDescricao() + "');")) {
			throw new RuntimeException("Permissão de acesso já cadastrada!");
		}
		
		repository.save(permissao);
	}

	public void saveAll(List<PermissaoAcesso> permissoes) throws Exception {
		permissoes.forEach((permissao) -> {
			try {
				save(permissao);
			} catch (Exception e) {
				throw new RuntimeException("falha ao gravar permissão " + permissao.getDescricao() + "!");
			}
		});		
	}

	public List<PermissaoAcesso> getAllByUserId(long userId) {
		return repository.getAllByUserId(userId);
	}

}
