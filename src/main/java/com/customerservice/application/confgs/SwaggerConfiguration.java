package com.customerservice.application.confgs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(
	     
	     servers = {
	           
	            @Server( 
	 	               url="http://localhost:8080/customer",
	 	               description="local"
	 	            ),
	           
	     }
	)
public class SwaggerConfiguration {
	@Bean
    public OpenAPI customerServiceOpenAPI() {
        return new OpenAPI()          
                .components(new Components().addSecuritySchemes("apiKeyScheme",  new SecurityScheme()
                        .type(SecurityScheme.Type.APIKEY)
                        .in(SecurityScheme.In.HEADER)
                        .name("Authorization")
                        ))
                .addSecurityItem(new SecurityRequirement().addList("apiKeyScheme"));
    }
}
