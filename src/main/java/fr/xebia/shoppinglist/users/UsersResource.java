package fr.xebia.shoppinglist.users;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("users")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class UsersResource {

    private UserRepository userRepository;

    @Inject
    public UsersResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @POST
    public Response createUser(User user) {
        return Response.
                ok().
                status(CREATED).
                entity(userRepository.create(user)).
                build()
        ;
    }

    @Path("{id}/lists")
    @POST
    public Response addNewList(@PathParam("id") Long userId, String shoppingListTitle) {
        User user = userRepository.get(userId);
        ShoppingList shoppingList = new ShoppingList(user.lists.size() + 1L, shoppingListTitle);
        user.lists.add(shoppingList);
        return Response.
                ok().
                status(CREATED).
                entity(shoppingList).
                build()
        ;
    }
}
