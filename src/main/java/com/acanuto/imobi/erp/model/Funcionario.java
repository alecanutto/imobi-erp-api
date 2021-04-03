package com.acanuto.imobi.erp.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.relational.core.mapping.Table;

import com.acanuto.imobi.erp.model.interfaces.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "tb_funcionarios")
public class Funcionario extends Pessoa {

	private String cargo;

	private BigDecimal remuneracao;

	private Date dataAdmissao;

	private Date dataDemissao;

}
