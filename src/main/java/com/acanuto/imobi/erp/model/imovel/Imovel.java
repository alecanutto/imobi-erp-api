package com.acanuto.imobi.erp.model.imovel;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.enums.Enums.EnumFinalidadeImovel;
import com.acanuto.imobi.erp.enums.Enums.EnumOcupacaoImovel;
import com.acanuto.imobi.erp.enums.Enums.EnumSituacaoImovel;
import com.acanuto.imobi.erp.model.interfaces.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "tb_imoveis")
public class Imovel extends Endereco {
	
	@Id
	private long id;

	private String titulo;
	
	private long proprietarioId;	
	
	private String referencia;
	
	private Date dataCaptacao;
	
	private Date dataExclusividade;
	
	private String obs;	
	
	private double valorLocacao;
	
	private double valorVenda;
	
	private double valorIPTU;
	
	private int quarto;
	
	private int suite;
	
	private int banheiro;
	
	private int sala;
	
	private int vagaCoberta;
	
	private int vagaDescoberta;
	
	private int varanda;
	
	private double areaTotal;
	
	private double areaConstruida;

	private int imovelTipoId;
	
	private EnumFinalidadeImovel finalidade;
	
	private EnumSituacaoImovel situacao;
	
	private EnumOcupacaoImovel ocupacao;
	
	private String registroPrefeitura;
	
	private String registroMatricula;
	
	private String registroEnergia;
	
	private String registroAgua;	
	
	private Date dataConstrucao;
		
	private Date dataCadastro;
	
}
