package com.acanuto.imobi.erp.dto.imovel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelDocumentosDTO {

	@ApiModelProperty(notes = "C�digo do im�vel")
	private long id;
	
	@ApiModelProperty(notes = "C�digo do im�vel", required = true)
	@NotNull(message = "O campo c�digo do im�vel � obrigat�rio.")
	private long imovelId;

	@ApiModelProperty(notes = "Categoria")
	@NotBlank(message = "O campo categoria � obrigat�rio.")
	private String categoria;
	
	@ApiModelProperty(notes = "T�tulo")
	@NotBlank(message = "O campo t�tulo � obrigat�rio.")
	private String titulo;
	
	@ApiModelProperty(notes = "Conte�do do documento")
	private Byte documento; 
 			
}
