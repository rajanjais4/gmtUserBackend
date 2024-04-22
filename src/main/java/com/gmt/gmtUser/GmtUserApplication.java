package com.gmt.gmtUser;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableOpenApi
@OpenAPIDefinition
public class GmtUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmtUserApplication.class, args);
	}

}
