package com.acanuto.imobi.erp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {
	
	private String dateTime;
	private String message;
	private String details;
	
}
