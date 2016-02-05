package spring;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class is used for the Swagger Documentation configuration.
 * 
 * @author Matias Glessi
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * This method creates the Docket intended to be the primary interface into
	 * the swagger-springmvc framework.
	 * 
	 * @return the Docket created
	 */
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api-shoppingcart").apiInfo(apiInfo()).select().paths(regex("/api.*"))
				.build();
	}

	/**
	 * This method builds all the API information to be displayed.
	 * 
	 * @return The api information
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Shopping Cart REST API")
				.description("Globant's Java Bootcamp Final Proyect: API for a functional shopping cart.")
				.contact("Matias Glessi <matiasglessi@gmail.com>").license("Apache License Version 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("2.0").build();
	}
}
