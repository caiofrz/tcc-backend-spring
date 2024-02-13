package tcc.caioferraz.backendapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openAPI() {

    Contact contato = new Contact();
    contato.setName("Caio Ferraz");
    contato.setEmail("caioferrazalmeida.27@gmail.com");
    contato.setUrl("https://github.com/caiofrz");

    return new OpenAPI()
            .info(new Info()
                    .title("TCC API Backend")
                    .description("""
                            API REST Backend do meu Trabalho de Conclusão de Curso 
                            - Web App de gerenciamento para pousada
                            """)
                    .contact(contato)
            );
  };
}