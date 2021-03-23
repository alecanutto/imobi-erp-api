package com.acanuto.imobi.erp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Function {

	private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	/**
	 * @param format
	 * @return dateTime formatted
	 */
	public static String getDateTime(String format) {
		String formattedDateTime = "";
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
			LocalDateTime dateTime = LocalDateTime.now();
			formattedDateTime = dateTime.format(formatter);
		} catch (Exception ex) {

		}
		return formattedDateTime;
	}

	public static String formatDateTime(Object datetime, String format) {
		try {
			if (datetime != null) {
				DateFormat df = new SimpleDateFormat(format);
				if (datetime.toString().contains("/")) {
					return datetime.toString();
				}
				return df.format(datetime);
			}

		} catch (Exception ex) {

		}
		return "";
	}

	// ================ CALCULA O DIGITO DO CPF OU CNPJ
	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	// ==================== VALIDA CPF
	public static boolean ValidCPF(String cpf) {
		cpf = cpf.replace(".", "").replace("-", "");

		if ((cpf == null) || (cpf.length() != 11)) {
			return false;
		}

		Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
		Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
		return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
	}

	// ====================== VALIDA CNPJ
	public static boolean ValidCNPJ(String cnpj) {
		cnpj = cnpj.replace(".", "").replace("-", "").replace("/", "");
		if ((cnpj == null) || (cnpj.length() != 14)) {
			return false;
		}

		Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
		Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
		return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
	}
}
