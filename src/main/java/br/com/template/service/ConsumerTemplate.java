package br.com.template.service;

import br.com.template.exception.ConsumerException;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Service
public class ConsumerTemplate implements Consumer {


    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public Object get(String url, Class typeReturnExpected, MediaType mediaType, Map<String, String> map) throws ConsumerException {
        String forObject = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(getHeaders(map)), String.class).getBody();
        logger.info("Consumindo -> "+url+"("+mediaType+") - REST TEMPLATE ");
        if(mediaType.equals(MediaType.APPLICATION_JSON))
            return new Gson().fromJson(forObject,typeReturnExpected);

        if(mediaType.equals(MediaType.APPLICATION_XML))
            return new XStream().fromXML(forObject);

       throw new ConsumerException("Eer... Problemas ao identificar o MediaType");
    }


    @Override
    public Object post(String url, Object objToSend, Class typeReturnExpected, MediaType mediaType, Map<String,String> headers) throws ConsumerException {
        ResponseEntity responseEntity = restTemplate.postForEntity(url,new HttpEntity(objToSend,getPostHeaders(headers)), typeReturnExpected);
        logger.info("Consumindo -> "+url+"("+mediaType+") - REST TEMPLATE ");

        if(mediaType.equals(MediaType.APPLICATION_JSON))
            return new Gson().fromJson(responseEntity.getBody().toString(),typeReturnExpected);

        if(mediaType.equals(MediaType.APPLICATION_XML))
            return new XStream().fromXML(responseEntity.getBody().toString());

        throw new ConsumerException("Eer... Problemas ao identificar o MediaType");
    }

    private MultiValueMap<String, String> getPostHeaders(Map<String,String> header){
        MultiValueMap mMap = new LinkedMultiValueMap();
        for(Map.Entry<String, String> s: header.entrySet()){
            mMap.put(s.getKey(),s.getValue());
        }
        return mMap;
    }

    private HttpHeaders getHeaders(Map<String,String> headers){
        HttpHeaders restHeaders = new HttpHeaders();

        for(Map.Entry<String, String> s: headers.entrySet()){
            restHeaders.set(s.getKey(),s.getValue());
        }
        return restHeaders;
    }


}
