package users.userTests;

import common.BaseTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import users.domain.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class CadastroDeUsuariosTest extends BaseTest {
    @Test
    void testeCriarUsuarioComSucesso(){
        User user = new User("Bruna", "brunaa4@email.com", "123", "true");
        given().
            contentType(ContentType.JSON).
                body(user).
                when().
                    post("usuarios").
                then().
                    statusCode(201).
                    body("message", is("Cadastro realizado com sucesso"));
    }

}
