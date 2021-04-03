package com.acanuto.imobi.erp.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.acanuto.imobi.erp.model.PermissaoAcesso;

public interface PermissaoAcessoRepository extends CrudRepository<PermissaoAcesso, Long> {

	@Query(value = "select * from tb_permissoes where usuario_id = :usuarioId;")
	List<PermissaoAcesso> getAllByUserId(@Param("usuarioId") long usuarioId);
	
	@Query(value = "select exists (select id from tb_permissoes where descricao = :descricao and usuario_id = :usuarioId);")
	boolean existsByDescription(@Param("descricao") String descricao, @Param("usuarioId") Long usuarioId);	

}
