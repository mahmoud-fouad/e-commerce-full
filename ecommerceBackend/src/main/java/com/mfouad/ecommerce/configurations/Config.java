package com.mfouad.ecommerce.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Config  {
    
@Bean
public Docket productApi(){
return new Docket(DocumentationType.SWAGGER_2)
.apiInfo(getApiInfo())
.select().apis(RequestHandlerSelectors.any())
.paths(PathSelectors.any())
.build();
}



private ApiInfo getApiInfo(){
    Contact contact = new Contact("Mahmoud Fouad", "http://webtutsplus.com", "mahmoud.ah.fouad@gmail.com");
    return new ApiInfoBuilder().contact(contact)
    .title("e-commerce")
    .description("Documentation Ecommerce api")
    .version("1.0.0").license("Apache 2.0")
    .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
    .build();
}

}
