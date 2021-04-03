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
	
	@ApiModelProperty(notes = "C�digo")
	private long id;

	@ApiModelProperty(notes = "T�tulo", required = true)
	@NotBlank(message = "O campo t�tulo � obrigat�rio.")
	@Size(max = 100, message = "O campo t�tulo deve conter no m�ximo 100 caracteres.")
	private String titulo;
	
	@ApiModelProperty(notes = "C�digo do propriet�rio", required = true)
	private long proprietarioId;	
	
	@ApiModelProperty(notes = "Refer�ncia")
	@Size(max = 100, message = "O campo refer�ncia deve conter no m�ximo 100 caracteres.")
	private String referencia;
	
	@ApiModelProperty(notes = "Data de capta��o")
	private Date dataCaptacao;
	
	@ApiModelProperty(notes = "Data exclusividade")
	private Date dataExclusividade;
	
	@ApiModelProperty(notes = "Observa��o")
	@Size(max = 200, message = "O campo observa��o deve conter no m�ximo 200 caracteres.")
	private String obs;	
	
	@ApiModelProperty(notes = "Valor de loca��o")
	private double valorLocacao;
	
	@ApiModelProperty(notes = "Valor de venda")
	private double valorVenda;
	
	@ApiModelProperty(notes = "Valor IPTU")
	private double valorIPTU;
	
	@ApiModelProperty(notes = "Qtd. quarto(s)")
	private int quarto;
	
	@ApiModelProperty(notes = "Qtd. su�te(s)")
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
	
	@ApiModelProperty(notes = "Medida da �rea total")
	private double areaTotal;
	
	@ApiModelProperty(notes = "Medida da �rea constru�da")
	private double areaConstruida;

	@ApiModelProperty(notes = "C�digo do tipo de im�vel")
	private int imovelTipoId;
	
	private EnumFinalidadeImovel finalidade;
	
	private EnumSituacaoImovel situacao;
	
	private EnumOcupacaoImovel ocupacao;
	
	@ApiModelProperty(notes = "Refer�ncia")
	@Size(max = 15, message = "O campo registro da prefeitura deve conter no m�ximo 15 caracteres.")
	private String registroPrefeitura;
	
	@ApiModelProperty(notes = "Refer�ncia")
	@Size(max = 15, message = "O campo registro de matr�cula deve conter no m�ximo 15 caracteres.")
	private String registroMatricula;
	
	@ApiModelProperty(notes = "Refer�ncia")
	@Size(max = 15, message = "O campo registro de energia deve conter no m�ximo 15 caracteres.")
	private String registroEnergia;
	
	@ApiModelProperty(notes = "Refer�ncia")
	@Size(max = 15, message = "O campo registro de �gua/saneamento deve conter no m�ximo 15 caracteres.")
	private String registroAgua;	
	
	@ApiModelProperty(notes = "Data de constru��o")
	private Date dataConstrucao;
			
}
