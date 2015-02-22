package fr.xebia.shoppinglist.it.shoppinglists;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.http.ContentType.JSON;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;
import fr.xebia.shoppinglist.users.User;

public class NewListsIT {

    @Test
    public void should_add_one_new_list_to_an_existing_user() {
        given().
                body(new User("test@test.fr", "norman", "password")).
                contentType(JSON).
        when().
                post("/api/users").
        then().
                statusCode(201)
        ;

        given().
                body("Apero tonight").
                contentType(JSON).
        when().
                post("/api/users/1/lists").
        then().
                statusCode(201).
                body(matchesJsonSchemaInClasspath("schemas/list.json")).
                body("id", equalTo(1)).
                body("title", equalTo("Apero tonight"))
        ;

        when().
                delete("/api/users/1").
        then().
                statusCode(200)
        ;
    }
}
