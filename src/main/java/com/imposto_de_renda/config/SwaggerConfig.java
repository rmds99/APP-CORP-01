package com.imposto_de_renda.config;


import java.util.ArrayList; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig 
{
	@Bean
    public Docket impostoRendaApi() 
	{
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.imposto_de_renda"))
                .paths(PathSelectors.regex("/.*")) 
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() 
    {

    	 ApiInfo apiInfo = new ApiInfo(
                 "API REST Calculo Imposto",
                 "API REST para o CRUD de um mini sistema para calculo de imposto de renda",
                 "1.0",
                 "Terms of Service",
                 
                 new Contact("Grupo", "https://www.google.com/", ""),
                 
                 "Apache License Version 2.0",
                 "https://www.apache.org/licenses/LICENSE-2.0", 
                 new ArrayList<VendorExtension>()
         );
         return apiInfo;
    }
}

