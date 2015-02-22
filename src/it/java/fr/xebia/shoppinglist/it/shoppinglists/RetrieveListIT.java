package fr.xebia.shoppinglist.it.shoppinglists;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;
import fr.xebia.shoppinglist.users.User;

public class RetrieveListIT {

    private static final String LIST_TITLE = "Romantic dinner";
    private static final int LIST_ID = 1;

    @Test public void
    should_add_one_product_to_a_list() {
        given().
                body(new User("test@test.fr", "norman", "password")).
                contentType(JSON).
        when().
                post("/api/users").
        then().
                statusCode(201)
        ;

        given().
                body(LIST_TITLE).
                contentType(JSON).
        when().
                post("/api/users/1/lists").
        then().
                statusCode(201)
        ;

        given().
                contentType(JSON).
        when().
                get("/api/users/1/lists/" + LIST_ID).
        then().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("schemas/list.json")).
                body("id", equalTo(LIST_ID)).
                body("title", equalTo(LIST_TITLE)).
                body("products", emptyIterable())
        ;

        given().
                contentType(JSON).
        when().
                delete("/api/users/1").
        then().
                statusCode(200)
        ;
    }
}
