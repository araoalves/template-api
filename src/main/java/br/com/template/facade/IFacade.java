package br.com.template.facade;

public interface IFacade {

    <T> T get(Class<T> clazz) throws Exception;
}
