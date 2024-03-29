package com.ios.swagger;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootWithSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithSwaggerApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.ios"))
				.build()
				.apiInfo(apiInfo());
		
	}
	
	
	private ApiInfo apiInfo() {
	      return new ApiInfo(
	              "Address Book API",
	              "Sample Address Book API",
	              "1.0",
	              "Free to use",
	              new springfox.documentation.service.Contact("prathap", "http://partha.io", "partha@gmail.com"),
	              "API license",
	              "http://partha.io",
	              Collections.emptyList());
	  }
	

}
