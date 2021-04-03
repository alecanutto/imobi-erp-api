package com.acanuto.imobi.erp.dto.imovel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelDocumentosDTO {

	@ApiModelProperty(notes = "Código do imóvel")
	private long id;
	
	@ApiModelProperty(notes = "Código do imóvel", required = true)
	@NotNull(message = "O campo código do imóvel é obrigatório.")
	private long imovelId;

	@ApiModelProperty(notes = "Categoria")
	@NotBlank(message = "O campo categoria é obrigatório.")
	private String categoria;
	
	@ApiModelProperty(notes = "Título")
	@NotBlank(message = "O campo título é obrigatório.")
	private String titulo;
	
	@ApiModelProperty(notes = "Conteúdo do documento")
	private Byte documento; 
 			
}
