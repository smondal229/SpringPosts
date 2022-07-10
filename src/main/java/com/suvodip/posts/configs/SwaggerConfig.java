package com.suvodip.posts.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	   @Bean
	   public Docket productApiV1() {
	      return new Docket(DocumentationType.SWAGGER_2)
	    		  .groupName("posts-api-v1")
	    		  .select()
	         .apis(RequestHandlerSelectors.basePackage("com.suvodip.posts.controllers.v1"))
	         .build()
	         .apiInfo(apiInfoV1());
	   }

	   private ApiInfo apiInfoV1() {
		   return new ApiInfoBuilder().version("v1").title("Posts API").description("Documentation Posts API v1").build();
	   }
}
