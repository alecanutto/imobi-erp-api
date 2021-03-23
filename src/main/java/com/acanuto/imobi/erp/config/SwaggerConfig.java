package com.acanuto.imobi.erp.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acanuto.imobi.erp.exception.ExceptionResponse;
import com.acanuto.imobi.erp.util.ErrorMessage;
import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Autowired
	private TypeResolver typeResolver;

	@Bean
	public Docket api() {
		
		ParameterBuilder paramBuilder = new ParameterBuilder();
		List<Parameter> params = new ArrayList<Parameter>();
		paramBuilder.name("Authorization").modelRef(new ModelRef("string"))
		.parameterType("header")
		.required(false)
		.build();
				
		params.add(paramBuilder.build());

		return changeGlobalResponses(new Docket(DocumentationType.SWAGGER_2)
				.globalOperationParameters(params)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.acanuto.imobi.erp.controller"))
				.paths(PathSelectors.ant("/api/**")).build().additionalModels(typeResolver.resolve(ExceptionResponse.class))
				.additionalModels(typeResolver.resolve(ErrorMessage.class)).useDefaultResponseMessages(false)
//				.securitySchemes(
//						Arrays.asList(new ApiKey("Token Access", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
				.apiInfo(apiInfo()));

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Imobi ERP - API")
				.description("\"Sistema de Integração e Gestão Imobiliária\"").version("1.0.0")
				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.contact(this.contact()).build();
	}

	private Contact contact() {
		return new Contact("Alessandra Canuto", "", "ale.canutto@gmail.com");
	}

	private Docket changeGlobalResponses(Docket docket) {

		List<ResponseMessage> messages = Arrays.asList(
				new ResponseMessageBuilder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.message("Server error try again later").responseModel(new ModelRef("ExceptionResponse")).build(),
				new ResponseMessageBuilder().code(HttpStatus.BAD_REQUEST.value()).message("Bad Request")
						.responseModel(new ModelRef("ErrorMessage")).build());

		RequestMethod[] methodsToCustomize = { RequestMethod.POST, RequestMethod.PUT };

		for (RequestMethod methodToCustomize : methodsToCustomize) {
			docket = docket.globalResponseMessage(methodToCustomize, messages);
		}

		return docket;
	}

}