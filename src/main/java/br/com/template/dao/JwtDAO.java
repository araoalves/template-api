package br.com.template.dao;

import br.com.template.model.Key;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JwtDAO extends AbstractDAO<Key,Integer> implements IJwtDAO {

    @Override
    public Key getKey() throws Exception {
        Key o = (Key) createEntityCriteria().add(Restrictions.eq("description", "WEBTOKENAPI")).uniqueResult();
        Assert.assertNotNull("O Objeto KEY nao pode ser Null",o);
        return o;
    }
    
    @Override
	public Key getReferenciedBy(String token, boolean urlAuthenticationNeeded) throws Exception {
		Key o = (Key)createEntityCriteria().add(Restrictions.eq("token", token)).add(Restrictions.eq("descricao", "TEMPLATE_API")).uniqueResult();
		if(urlAuthenticationNeeded)
			Assert.assertNotNull("Chave Inválida",o);
		return o;
	}
}
