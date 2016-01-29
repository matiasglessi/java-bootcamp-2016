package spring;

import static springfox.documentation.builders.PathSelectors.regex;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.TypeResolver;

import spring.ws.model.User;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

 @Bean
 public Docket newsApi() {
	 TypeResolver typeResolver = new TypeResolver();
     return new Docket(DocumentationType.SWAGGER_2)
             .groupName("api-users")
             .alternateTypeRules(AlternateTypeRules.newRule(
                     typeResolver.resolve(Collection.class, User.class),
                     typeResolver.resolve(List.class, User.class)))
             .apiInfo(apiInfo())
             .select()
             .paths(regex("/api.*"))
             .build();
 }
 
 

 private ApiInfo apiInfo() {
     return new ApiInfoBuilder()
             .title("Users REST API")
             .description("Topic 6: API to register users.")
             .contact("Matias Glessi")
             .license("Apache License Version 2.0")
             .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
             .version("2.0")
             .build();
 }
}
