package leonardo.valter.vendas.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("estoque.controle.ms"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    @SuppressWarnings("rawtypes")
	private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "MicroService - Controle de Estoque",
                "API REST para controle de estoque de produtos, por empresa.",
                "1.0",
                "Terms of Service",
                new Contact("Valter L.M. Bortoletto", "","vlmb.leo@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
    
    public static Predicate<String> regex(final String pathRegex) {
        return new Predicate<String>() {
          @Override
          public boolean apply(String input) {
            return input.matches(pathRegex);
          }
        };
      }
}