package com.service.items.itemsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class ItemsServiceApplication {

	@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Items").select()
                .apis(RequestHandlerSelectors.basePackage("com.service.items.itemsservice"))
                .paths(regex("/items*")).build().apiInfo(new ApiInfo("Items Service",
                        "A set of services to provide details on order items", "1.0.0", null,
                        new Contact(null,null,null), null, null));
    }

	public static void main(String[] args) {
		SpringApplication.run(ItemsServiceApplication.class, args);
	}
}
