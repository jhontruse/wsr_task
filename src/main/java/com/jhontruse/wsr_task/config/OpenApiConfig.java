package com.jhontruse.wsr_task.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME_NAME = "bearerAuth";

    /**
     * TODO: Bean principal de configuración OpenAPI.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(buildInfo())
                .servers(buildServers())
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(buildComponents());
    }

    /**
     * TODO: Construye la metadata principal (title, version, contacto, licencia).
     */
    private Info buildInfo() {
        return new Info()
                .title("wsr_task")
                .version("1.0.0")
                .description("API REST para tareas")
                .contact(new Contact()
                        .name("Jhon Trujillo Serrano")
                        .email("jhontruse@gmail.com")
                        .url("https://github.com/jhontruse/"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0.html"));
    }

    /**
     * TODO: Lista de servidores disponibles. Ajustar URLs por entorno real.
     */
    private List<Server> buildServers() {
        return List.of(
                new Server().url("http://localhost:8080").description("Servidor de Desarrollo"),
                new Server().url("http://localhost:8080").description("Servidor de Integración"),
                new Server().url("http://localhost:8080").description("Servidor de Producción"));
    }

    /**
     * TODO: Define el esquema de seguridad Bearer JWT, reusable en cualquier {@code @SecurityRequirement}.
     */
    private Components buildComponents() {
        return new Components().addSecuritySchemes(SECURITY_SCHEME_NAME,
                new SecurityScheme()
                        .name(SECURITY_SCHEME_NAME)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                        .description("Token JWT obtenido en /login. Usar 'Bearer <token>' en el header Authorization."));
    }
}
