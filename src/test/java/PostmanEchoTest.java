import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldPostLatin() {
        // Given - When - Then
        // Предусловия
        given()
            .baseUri("https://postman-echo.com")
            .body("War is Peace") // отправляемые данные
        // Выполняемые действия
        .when()
            .post("/post")
        // Проверки
        .then()
            .statusCode(200)
                .body("data", equalTo("War is Peace"))
        ;
    }

    @Test
    void shouldPostCyrillic() {
        // Given - When - Then
        // Предусловия
        given()
            .baseUri("https://postman-echo.com")
            .contentType("text/plain; charset=UTF-8")
            .body("Война — это мир") // отправляемые данные
        // Выполняемые действия
        .when()
            .post("/post")
        // Проверки
        .then()
            .statusCode(200)
            .body("data", equalTo("Война — это мир"))
        ;
    }
}
