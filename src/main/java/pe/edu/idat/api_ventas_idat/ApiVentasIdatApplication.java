package pe.edu.idat.api_ventas_idat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiVentasIdatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiVentasIdatApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer(){
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/**")
						.allowedMethods("GET", "POST", "PUT", "PATCH")
						//.allowedOrigins("http://front-admin.idat.pe");
						.allowedOrigins("*");
			}
		};
	}

}
