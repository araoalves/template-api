package br.com.template.exception;

/**
 * Created by markiing on 26/07/17.
 */
public class ConsumerException extends Exception {

    public ConsumerException(String message){super(message);}
    public ConsumerException(Throwable t, String message) {
        super(message,t);
    }


}
