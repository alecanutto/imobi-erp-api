package com.acanuto.imobi.erp.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLoginDTO {

	private String token;
	private String validadeToken;
	private long id;
	private String usuario;
	private List<String> permissoes;
	
}