package br.com.template.exception;

/**
 * Created by markiing on 09/08/17.
 */
public class KeyNotFoundException extends Exception {

    public KeyNotFoundException(String message, Throwable t){
        super(message,t);
    }
}
