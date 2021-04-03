package com.acanuto.imobi.erp.dto.imovel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelCaracteristicasDTO {

	@ApiModelProperty(notes = "C�digo")
	private long id;
	
	@ApiModelProperty(notes = "C�digo do im�vel", required = true)
	private long imovelId;

	@ApiModelProperty(notes = "C�digo da caracter�stica", required = true)
	private long caracteristicaId;
	
}
