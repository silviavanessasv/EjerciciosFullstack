package com.certidevs.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.ExternalDocumentation;

/*

Las clases de configuración se utilizan para crear objetos y pasárselos a Spring
para que los tenga en su contenedor de Beans y pueda inyectarlos en aquellos
sitios donde se realice inyección de dependencias.

Esto se hace para creación avanzada de beans, cuando queremos configurar objetos a nuestro
gusto y necesidad, en lugar de que lo cree spring directamente.

https://springdoc.org/

https://github.com/springdoc/springdoc-openapi-demos

 */
@Configuration
public class OpenApiConfig {

//    @Bean
//    public OpenAPI openApi() {
//
//    }


    @Bean
    public OpenAPI openApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Employees API")
                        .description("API REST para empleados de la empresa X")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("https://www.example.com/")))
                .externalDocs(new ExternalDocumentation()
                        .description("Wiki Docs")
                        .url("https://www.example.com/"));
    }
}
