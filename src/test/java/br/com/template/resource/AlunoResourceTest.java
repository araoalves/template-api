package br.com.template.resource;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItem;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlunoResourceTest {

    @Test
    @Ignore
    public void buscarAlunosNoAno() throws Exception {

       when()
                .get("spring-boot-template/alunoController/buscarAlunosNoAno/{ano}/{qtdResult}", 2017, 1)
                .then()
                .statusCode(200)
                .body("cpd", hasItem("77068"), "matricula", hasItem("ME17001I2C1"));
    }



}