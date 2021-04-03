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
public abstract class PessoaTrabalho extends Endereco {
	
	@Id
	private long id;
	
	private String cargo;
	
	private double renda;
	
	private double outraRenda;
			
	private String empresa;
	
	private String cnpj;
	
	private Date dataAdmissao;
	
	private String telefone;
	
	private String email;

}
