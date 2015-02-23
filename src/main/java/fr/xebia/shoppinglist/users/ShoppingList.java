package fr.xebia.shoppinglist.users;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY // mandatory for serialization
)
public class ShoppingList {

    public final Long id;
    public final String title;

    @JsonCreator
    public ShoppingList(@JsonProperty(value = "title") String title) {
        this(null, title);
    }

    public ShoppingList(Long id, String title) {
        this.id = id;
        this.title = title;

}
