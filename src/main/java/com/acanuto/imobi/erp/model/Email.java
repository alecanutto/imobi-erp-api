package com.acanuto.imobi.erp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "tb_email")
public class Email {

	@Id
	private long id;

	private String email;

	private String smtp;
	
	private int porta;
	
	private String usuario;
	
	private String senha;

	private boolean tls;
	
	private String copia;	
	
}
