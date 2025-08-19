package com.unear.userservice.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .name("Authorization");

        Server server = new Server()
                .url("https://port-0-unear-user-backend-mee0ukig2daa6b7c.sel5.cloudtype.app")
                .description("Cloudtype 배포");

        return new OpenAPI()
                .info(new Info().title("API Test Document")
                        .description("Application API Documentation")
                        .version("v1.0"))
                .components(new Components()
                        .addSecuritySchemes("BearerAuth", securityScheme))
                .servers(List.of(server));
    }
}
