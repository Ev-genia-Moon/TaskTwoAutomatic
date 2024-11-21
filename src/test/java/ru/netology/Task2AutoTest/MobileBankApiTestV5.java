package ru.netology.Task2AutoTest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

//import static com.google.common.base.CharMatcher.is;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
//import static sun.nio.cs.Surrogate.is;

public class MobileBankApiTestV5 {
    @Test
    void shouldReturnDemoAccounts() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("every{ it.balance >= 0 }", is(true))
        ;
    }
}
