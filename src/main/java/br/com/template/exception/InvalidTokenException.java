package br.com.template.exception;

import org.omg.CORBA.DynAnyPackage.Invalid;

/**
 * Created by markiing on 04/08/17.
 */
public class InvalidTokenException extends Exception {

    public InvalidTokenException(String message){
        super(message);
    }
}
