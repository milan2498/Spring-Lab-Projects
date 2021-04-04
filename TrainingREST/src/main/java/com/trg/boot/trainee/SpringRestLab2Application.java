package com.trg.boot.trainee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringRestLab2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestLab2Application.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
		//		.apis(RequestHandlerSelectors.basePackage("com.jpa"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaInfo());

	}
	private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
        		"SpingBoot Trainee Test",
        		"Lab Project",
        		"1.0",
        		"",
        		"Milan Nayak",
        		"Licence 2.1.0",
        		"https://www.google.com"
        );

        return apiInfo;
    }

}
