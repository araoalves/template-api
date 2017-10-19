package br.com.template.service;

import br.com.template.exception.ConsumerException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by markiing on 26/07/17.
 */
public interface Consumer {

    Object get(String url, Class typeReturnExpected, MediaType mediaType, Map<String, String> headers) throws ConsumerException;
    Object post(String url, Object objToSend, Class typeReturnExpected, MediaType mediaType, Map<String, String> headers) throws ConsumerException;
}
