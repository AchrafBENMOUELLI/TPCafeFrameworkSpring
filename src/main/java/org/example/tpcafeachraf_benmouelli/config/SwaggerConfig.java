package org.example.tpcafeachraf_benmouelli.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("☕ Cafe Achraf Ben Mouelli API")
                        .version("1.0.0")
                        .description("API documentation for the Cafe Achraf project. Manage clients, commandes, promotions, and more efficiently.")
                        .contact(new Contact()
                                .name("Achraf Ben Mouelli")
                                .email("benmouelliachraf@gmail.com")
                        )
                )
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Profile")
                        .url("https://github.com/AchrafBENMOUELLI")
                );
    }

    @Bean
    public GroupedOpenApi adresseApi() {
        return GroupedOpenApi.builder()
                .group("Adresse")
                .pathsToMatch("/adresse/**")
                .build();
    }

    @Bean
    public GroupedOpenApi articleApi() {
        return GroupedOpenApi.builder()
                .group("Article")
                .pathsToMatch("/article/**")
                .build();
    }

    @Bean
    public GroupedOpenApi carteFideliteApi() {
        return GroupedOpenApi.builder()
                .group("CarteFidelite")
                .pathsToMatch("/carte-fidelite/**")
                .build();
    }

    @Bean
    public GroupedOpenApi clientApi() {
        return GroupedOpenApi.builder()
                .group("Client")
                .pathsToMatch("/client/**")
                .build();
    }

    @Bean
    public GroupedOpenApi commandeApi() {
        return GroupedOpenApi.builder()
                .group("Commande")
                .pathsToMatch("/commande/**")
                .build();
    }

    @Bean
    public GroupedOpenApi detailCommandeApi() {
        return GroupedOpenApi.builder()
                .group("Detail_Commande")
                .pathsToMatch("/detail-commande/**")
                .build();
    }

    @Bean
    public GroupedOpenApi promotionApi() {
        return GroupedOpenApi.builder()
                .group("Promotion")
                .pathsToMatch("/promotion/**")
                .build();
    }
}
