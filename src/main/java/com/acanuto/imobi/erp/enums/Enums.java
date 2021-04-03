package com.acanuto.imobi.erp.enums;

public class Enums {

	public enum EnumTipoContaBancaria {
		CORRENTE("C"), POUPANCA("P");

		private final String valor;

		EnumTipoContaBancaria(String valorOpcao) {
			valor = valorOpcao;
		}

		public String getValor() {
			return valor;
		}
	}

	public enum EnumTipoCadastroPessoa {
		PROPRIETARIO(1), INQUILINO(2), COMPRADOR(3), FIADOR(4), AVALISTA(5);

		private final int valor;

		EnumTipoCadastroPessoa(int valorOpcao) {
			valor = valorOpcao;
		}

		public int getValor() {
			return valor;
		}
	}
	
	public enum EnumTipoPlanoContas {
		GRUPO(1), CREDITO(2), DEBITO(3);

		private final int valor;

		EnumTipoPlanoContas(int valorOpcao) {
			valor = valorOpcao;
		}

		public int getValor() {
			return valor;
		}
	}

	public enum EnumSexo {
		FEMININO("F"), MASCULINO("M"), OUTROS("X");

		private final String valor;

		EnumSexo(String string) {
			valor = string;
		}

		public String getValor() {
			return valor;
		}
	}
	
	public enum EnumFinalidadeImovel {
		TODOS(0), LOCACAO(1), VENDA(2);

		private final int valor;

		EnumFinalidadeImovel(int valorOpcao) {
			valor = valorOpcao;
		}

		public int getValor() {
			return valor;
		}
	}

	public enum EnumSituacaoImovel {
		INATIVO(0), ATIVO(1), LOCADO(2), VENDIDO(3), REFORMA(4), NEGOCIACAO(5), AVALIACAO(6), RESERVADO(7);

		private final int valor;

		EnumSituacaoImovel(int valorOpcao) {
			valor = valorOpcao;
		}

		public int getValor() {
			return valor;
		}
	}
	
	public enum EnumOcupacaoImovel {
		DESOCUPADO(0), OCUPADO_INQUILINO(1), OCUPADO_PROPRIETARIO(2);

		private final int valor;

		EnumOcupacaoImovel(int valorOpcao) {
			valor = valorOpcao;
		}

		public int getValor() {
			return valor;
		}
	}
	
}
