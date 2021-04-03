package com.acanuto.imobi.erp.dto.imovel;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.acanuto.imobi.erp.enums.Enums.EnumFinalidadeImovel;
import com.acanuto.imobi.erp.enums.Enums.EnumOcupacaoImovel;
import com.acanuto.imobi.erp.enums.Enums.EnumSituacaoImovel;
import com.acanuto.imobi.erp.model.interfaces.Endereco;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelDTO extends Endereco {
	
	@ApiModelProperty(notes = "Código")
	private long id;

	@ApiModelProperty(notes = "Título", required = true)
	@NotBlank(message = "O campo título é obrigatório.")
	@Size(max = 100, message = "O campo título deve conter no máximo 100 caracteres.")
	private String titulo;
	
	@ApiModelProperty(notes = "Código do proprietário", required = true)
	private long proprietarioId;	
	
	@ApiModelProperty(notes = "Referência")
	@Size(max = 100, message = "O campo referência deve conter no máximo 100 caracteres.")
	private String referencia;
	
	@ApiModelProperty(notes = "Data de captação")
	private Date dataCaptacao;
	
	@ApiModelProperty(notes = "Data exclusividade")
	private Date dataExclusividade;
	
	@ApiModelProperty(notes = "Observação")
	@Size(max = 200, message = "O campo observação deve conter no máximo 200 caracteres.")
	private String obs;	
	
	@ApiModelProperty(notes = "Valor de locação")
	private double valorLocacao;
	
	@ApiModelProperty(notes = "Valor de venda")
	private double valorVenda;
	
	@ApiModelProperty(notes = "Valor IPTU")
	private double valorIPTU;
	
	@ApiModelProperty(notes = "Qtd. quarto(s)")
	private int quarto;
	
	@ApiModelProperty(notes = "Qtd. suíte(s)")
	private int suite;
	
	@ApiModelProperty(notes = "Qtd. banheiro(s)")
	private int banheiro;
	
	@ApiModelProperty(notes = "Qtd. sala(s)")
	private int sala;
	
	@ApiModelProperty(notes = "Qtd. vaga(s) coberta(s)")
	private int vagaCoberta;
	
	@ApiModelProperty(notes = "Qtd. vaga(s) descoberta(s)")
	private int vagaDescoberta;
	
	@ApiModelProperty(notes = "Qtd. varanda(s)")
	private int varanda;
	
	@ApiModelProperty(notes = "Medida da área total")
	private double areaTotal;
	
	@ApiModelProperty(notes = "Medida da área construída")
	private double areaConstruida;

	@ApiModelProperty(notes = "Código do tipo de imóvel")
	private int imovelTipoId;
	
	private EnumFinalidadeImovel finalidade;
	
	private EnumSituacaoImovel situacao;
	
	private EnumOcupacaoImovel ocupacao;
	
	@ApiModelProperty(notes = "Referência")
	@Size(max = 15, message = "O campo registro da prefeitura deve conter no máximo 15 caracteres.")
	private String registroPrefeitura;
	
	@ApiModelProperty(notes = "Referência")
	@Size(max = 15, message = "O campo registro de matrícula deve conter no máximo 15 caracteres.")
	private String registroMatricula;
	
	@ApiModelProperty(notes = "Referência")
	@Size(max = 15, message = "O campo registro de energia deve conter no máximo 15 caracteres.")
	private String registroEnergia;
	
	@ApiModelProperty(notes = "Referência")
	@Size(max = 15, message = "O campo registro de água/saneamento deve conter no máximo 15 caracteres.")
	private String registroAgua;	
	
	@ApiModelProperty(notes = "Data de construção")
	private Date dataConstrucao;
			
}
