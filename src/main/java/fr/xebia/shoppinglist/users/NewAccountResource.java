package fr.xebia.shoppinglist.users;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("users")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class NewAccountResource {

    private UserRepository userRepository;

    @Inject
    public NewAccountResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @POST
    public Response createUser(User user) {
        return Response.
                ok().
                status(CREATED).
                entity(userRepository.create(user)).
                build();
    }
}
