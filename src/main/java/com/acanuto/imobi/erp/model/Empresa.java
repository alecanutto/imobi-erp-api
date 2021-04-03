package com.acanuto.imobi.erp.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "tb_empresa")
public class Empresa extends Endereco {

	@Id
	private long id;

	private String nome;

	private String nomeFantasia;

	private String ie;

	private String im;

	private String cnpj;

	private Date dataExpedicao;

	private String fone;

	private String cel;

	private String email;

	private String site;

	private Date dataCadastro;

}
