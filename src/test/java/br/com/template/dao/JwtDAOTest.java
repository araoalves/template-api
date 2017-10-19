package br.com.template.dao;

import br.com.template.model.Key;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JwtDAOTest {

    @Autowired
    private IJwtDAO jwtDAO;

    @Test
    @Ignore
    public void getKey() throws Exception {
        Key key = jwtDAO.getKey();
        Assert.assertNotNull("Key nao pode ser null",key);
    }
}