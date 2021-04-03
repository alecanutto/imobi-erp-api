package com.acanuto.imobi.erp.dto.imovel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelCaracteristicasDTO {

	@ApiModelProperty(notes = "Código")
	private long id;
	
	@ApiModelProperty(notes = "Código do imóvel", required = true)
	private long imovelId;

	@ApiModelProperty(notes = "Código da característica", required = true)
	private long caracteristicaId;
	
}
