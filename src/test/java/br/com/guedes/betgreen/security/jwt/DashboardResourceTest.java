package br.com.guedes.betgreen.security.jwt;

import br.com.guedes.betgreen.security.util.TokenUtils;
import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class DashboardResourceTest {

    public String token;

    @BeforeEach
    public void gerarToken() throws Exception {
        token = TokenUtils.generateTokenString("/JWTClaims.json", null);
    }

    @Test
    public void testMethodName() {
        given()
                .header("Authorization", "Bearer "+token)
                .when().get("/dashboard")
                .then()
                .statusCode(200)
                .body(is("dashboard acess"));

    }

}