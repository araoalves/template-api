package br.com.template.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.ToString;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConsumerTemplateTest {

    @Autowired
    private Consumer consumer;

    @Test
    @Ignore
    public void get() throws Exception {
        Map<String, String> headers = new HashMap<>();
        headers.put("header1","value1");
        headers.put("header2", "value2");

        TestJson o = (TestJson) consumer.get("http://echo.jsontest.com/key/value/one/two", TestJson.class, MediaType.APPLICATION_JSON, headers);
        Assert.assertNotNull(o);
    }

    @Test
    @Ignore
    public void getList() throws Exception {
        Map<String, String> headers = new HashMap<>();
        headers.put("header1","value1");
        headers.put("header2", "value2");

        Comentario[] listComments = (Comentario[]) consumer.get("http://www.ceuma.br/ServicosOnline/servicosSextouNTI/searchComments?token=99678f8f11be783c5e33c11008ba6772&trilhaCodigo=1", Comentario[].class, MediaType.APPLICATION_JSON,headers);
        Assert.assertNotNull(listComments);
    }

}


@Data
@ToString
class TestJson{
    private String one;
    private String key;
}


@Data
@ToString
@JsonAutoDetect
class Comentario implements Serializable{

    private Integer codigo;
    private Trilha trilha;
    private Usuario usuario;
    private String descricao;
}

@Data
class Trilha{

    private Integer codigo;
    private String titulo;
    private String sobre;
}

@Data
class Usuario{

    private Integer codigo;
    private String matricula;
    private String nome;
    private String email;
    private String senha;
}