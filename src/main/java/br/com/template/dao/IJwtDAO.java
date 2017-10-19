package br.com.template.dao;

import br.com.template.model.Key;

/**
 * Created by markiing on 08/08/17.
 */
public interface IJwtDAO {

    Key getKey() throws Exception;
    Key getReferenciedBy(String token, boolean urlAuthenticationNeeded) throws Exception;
}
