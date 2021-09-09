package com.acanuto.imobi.erp.config;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acanuto.imobi.erp.util.ErrorMessage;
import com.acanuto.imobi.erp.util.ExceptionResponse;
import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//	@Value("${config.oauth2.accessTokenUri}")
    private String accessTokenUri;

    public static final String securitySchemaOAuth2 = "oauth2schema";
    public static final String authorizationScopeGlobal = "global";
    public static final String authorizationScopeGlobalDesc ="accessEverything";
	
	@Autowired
	private TypeResolver typeResolver;
	
//	private static final String AUTHORIZATION_HEADER = "Authorization";
//	
//	private ApiKey apiKey() {
//		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//	}

	@Bean
	public Docket api() {
		return changeGlobalResponses(new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
			    .securitySchemes(Arrays.asList(apiKey()))				
				.additionalModels(typeResolver.resolve(ExceptionResponse.class))
				.additionalModels(typeResolver.resolve(ErrorMessage.class))
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.acanuto.imobi.erp.controller"))
				.paths(PathSelectors.ant("/api/**"))				  
		        .build()
		        .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Arrays.asList(securitySchema(), apiKey(), apiCookieKey())));
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
						.message("Server error try again later").responseModel(new ModelRef("ExceptionResponse"))
						.build(),
				new ResponseMessageBuilder().code(HttpStatus.BAD_REQUEST.value()).message("Bad Request")
						.responseModel(new ModelRef("ErrorMessage")).build());

		RequestMethod[] methodsToCustomize = { RequestMethod.POST, RequestMethod.PUT };

		for (RequestMethod methodToCustomize : methodsToCustomize) {
			docket = docket.globalResponseMessage(methodToCustomize, messages);
		}

		return docket;
	}
	
	@Bean
	public SecurityScheme apiKey() {
		return new ApiKey(HttpHeaders.AUTHORIZATION, "apiKey", "header");
	}

	@Bean
	public SecurityScheme apiCookieKey() {
		return new ApiKey(HttpHeaders.COOKIE, "apiKey", "cookie");
	}

    private OAuth securitySchema() {
    	List<AuthorizationScope> authorizationScopeList = newArrayList();
	    authorizationScopeList.add(new AuthorizationScope("read", "read all"));
	    authorizationScopeList.add(new AuthorizationScope("write", "access all"));

        List<GrantType> grantTypes = newArrayList();
        GrantType passwordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(accessTokenUri);
        grantTypes.add(passwordCredentialsGrant);

        return new OAuth("oauth2", authorizationScopeList, grantTypes);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth())
                .build();
    }
	    
    private List<SecurityReference> defaultAuth() {

        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
        authorizationScopes[0] = new AuthorizationScope("read", "read all");
        authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
        authorizationScopes[2] = new AuthorizationScope("write", "write all");

        return Collections.singletonList(new SecurityReference("oauth2", authorizationScopes));
    }
	
}