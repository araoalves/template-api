package br.com.template.configuration.api;

import br.com.template.configuration.general.SpringConfiguration;
import br.com.template.configuration.hibernate.HibernateConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@Import({SpringConfiguration.class, HibernateConfiguration.class})
@ComponentScan(basePackages = {"br.com.template"})
@PropertySource(value = {"classpath:application-dev-api.yml"})
@Profile({"dev-api"})
public class ApiDevelopment {


}
