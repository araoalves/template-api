package br.com.template.configuration.general;

import br.com.template.facade.Facade;
import br.com.template.facade.IFacade;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SpringConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public IFacade facade(){
        return new Facade();
    }

    @Bean
    public RestTemplate restTemplate(){
        final Boolean useProxy = new Boolean(environment.getProperty("rest.configuration.useProxy"));

        //PROXY CONFIGURATION IN CASE useProxy = true
        if(useProxy){

            final String username = environment.getProperty("rest.configuration.credentials.username");
            final String password = environment.getProperty("rest.configuration.credentials.password");
            final String host = environment.getRequiredProperty("rest.configuration.proxyHost");
            final Integer port = Integer.valueOf(environment.getRequiredProperty("rest.configuration.port"));


            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(new AuthScope(host,port), new UsernamePasswordCredentials(username,password));

            HttpHost myProxy = new HttpHost(host,port);
            HttpClientBuilder clientBuilder = HttpClientBuilder.create();
            clientBuilder.setProxy(myProxy).setDefaultCredentialsProvider(credentialsProvider);

            HttpClient httpClient = clientBuilder.build();
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setHttpClient(httpClient);

            return new RestTemplate(factory);
        }

        return new RestTemplate();
    }

    @Bean(name = "HEADER_AUTHORIZATION")
    public String authorizationHeader(){
        return new String("Authorization");
    }

}



