package users.userTests;

import common.BaseTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

class ListaDeUsuariosTest extends BaseTest {
    @Test
    void testeListaUsuario(){
        RestAssured.when()
                    .get("usuarios")
                .then()
                    .statusCode(200);
    }
}
