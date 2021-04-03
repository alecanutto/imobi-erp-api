package com.acanuto.imobi.erp.repository.imovel;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.acanuto.imobi.erp.enums.Enums.EnumFinalidadeImovel;
import com.acanuto.imobi.erp.enums.Enums.EnumOcupacaoImovel;
import com.acanuto.imobi.erp.enums.Enums.EnumSituacaoImovel;
import com.acanuto.imobi.erp.model.imovel.Imovel;

public interface ImovelRepository extends CrudRepository<Imovel, Long> {
	
	List<Imovel> findAll(); 	
	
	List<Imovel> findAllByFinalidade(EnumFinalidadeImovel finalidade); 	
	
	List<Imovel> findAllBySituacao(EnumSituacaoImovel situacao); 	
	
	List<Imovel> findAllByOcupacao(EnumOcupacaoImovel ocupacao); 	
	
	List<Imovel> findAllByImovelTipoId(long imovelTipoId); 	
	
	List<Imovel> findAllByDataCadastroBetween(Date dataInicial, Date dataFinal); 	
	
	List<Imovel> findAllByDataCaptacaoBetween(Date dataInicial, Date dataFinal); 	
	
	Optional<Imovel> findByTituloStartingWith(String titulo);

}
