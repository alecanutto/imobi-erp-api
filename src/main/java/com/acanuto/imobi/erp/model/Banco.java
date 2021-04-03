package com.acanuto.imobi.erp.model;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.IBanco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "tb_bancos")
public class Banco extends IBanco {

	private String nomeAgencia;	

	private String gerente;
	
	private String fone;

}