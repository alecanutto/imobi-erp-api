package com.acanuto.imobi.erp.model.interfaces;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class IBanco {
	
	@Id
	private long id;	
	
	private String pix;

	private String codigoBanco;

	private String nome;

	private String numeroConta;

	private String numeroAgencia;

	private String obs;

	private Date dataCadastro;
	
	private boolean ativo;

}
