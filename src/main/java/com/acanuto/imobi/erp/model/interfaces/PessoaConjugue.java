package com.acanuto.imobi.erp.model.interfaces;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class PessoaConjugue {

	@Id
	private long id;
			
	private String nome;
	
	private String cpf;
	
	private String cel;
	
	private String email;
	
}
