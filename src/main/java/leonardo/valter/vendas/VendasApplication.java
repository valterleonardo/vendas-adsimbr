package leonardo.valter.vendas;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication(scanBasePackages = "leonardo.valter.vendas")
@EnableJpaRepositories("leonardo.valter.vendas.entity.repository")
@EntityScan("leonardo.valter.vendas.entity")
public class VendasApplication {

	private static final List<String> TODOS = Collections.singletonList("*");
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Bean
    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        CorsConfiguration config = new CorsConfiguration();  
        config.setAllowCredentials(true);
        config.setAllowedOrigins(TODOS); 
        config.setAllowedMethods(TODOS);  
        config.setAllowedHeaders(TODOS);  
        source.registerCorsConfiguration("/**", config);  
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
        return bean;  
    }   
}
