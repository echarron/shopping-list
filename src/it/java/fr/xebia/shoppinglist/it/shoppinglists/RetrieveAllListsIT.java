package fr.xebia.shoppinglist.it.shoppinglists;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;
import fr.xebia.shoppinglist.users.User;

public class RetrieveAllListsIT {

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
                statusCode(201)
        ;

        when().
                get("/api/users/1/lists").
        then().
                statusCode(200).
                body(equalTo("[{\"title\":\"Apero tonight\",\"id\":1,\"products\":[]}]"))
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
