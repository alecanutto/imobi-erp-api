package com.acanuto.imobi.erp.model.interfaces;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class IBanco {
	
	@Id
	private long id;	
	
	private String pix;

	private String nomeBanco;

	private String numeroConta;

	private String numeroAgencia;

	private String obs;

	private Date dataCadastro;
	
	private boolean ativo;

}
