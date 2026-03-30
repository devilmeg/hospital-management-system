package com.hms.hospital_management.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Hospital Management System API",
                version = "1.0",
                description = "Production-grade APIs for managing patients, physicians, appointments, procedures, and hospital operations.",
                contact = @Contact(
                        name = "HMS Support Team",
                        email = "support@hms.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        servers = {
                @Server(
                        description = "Local Development Server",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Production Server",
                        url = "https://api.hms.com"
                )
        }
)
public class OpenApiConfig {
}