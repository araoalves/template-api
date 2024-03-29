package br.com.template.configuration.general;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicates;

@Configuration
@EnableSwagger2
public class Swagger extends WebMvcConfigurerAdapter {

    @Value("${app.name}")               private String name;
    @Value("${app.description}")        private String description;
    @Value("${app.version}")            private String version;
    @Value("${app.terms}")              private String terms;
    @Value("${app.contact.name}")       private String contactName;
    @Value("${app.contact.url}")        private String contactUrl;
    @Value("${app.contact.email}")      private String contactEmail;
    @Value("${app.license}")            private String license;
    @Value("${app.licenseUrl}")         private String licenseURL;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:META-INF/resources/webjars/");
        registry.addResourceHandler("/documentation/**").addResourceLocations("classpath:/META-INF/resources/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/documentation/api-docs","/v2/api-docs");
        registry.addRedirectViewController("/documentation","/swagger-ui.html");
        registry.addRedirectViewController("/documentation/","/swagger-ui.html");
    }

    @Bean
    public Docket api(){
    	
    	List<ApiKey> listApiKey = new ArrayList<ApiKey>();
    	ApiKey apiKey = new ApiKey("Authorization", "api_key", "header");
    	listApiKey.add(apiKey);
    	
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(listApiKey)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(name,description,version,terms,new Contact(contactName,contactUrl,contactEmail),license,licenseURL);
    }
}
