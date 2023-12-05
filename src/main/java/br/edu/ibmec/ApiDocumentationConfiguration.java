package br.edu.ibmec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ApiDocumentationConfiguration {

    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("AP2 - Guilherme Goulart Maia - Cloud Computing")
                        .description("Utilização do Spring Boot")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Guilherme Goulart Maia")
                                .email("gui-maia@outlook.com")));
    }
}