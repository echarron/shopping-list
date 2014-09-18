package fr.xebia.shoppinglist.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import javax.ws.rs.core.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsersResourceTest {

    @InjectMocks
    private UsersResource resource;

    @Mock
    private UserRepository userRepository;

    @Test
    public void should_persist_user_and_return_201() {
        User user = new User("test@test.fr", "test", "password");
        User expectedUser = new User(12345L, "test@test.fr", "test", "password");
        given(userRepository.create(user)).willReturn(expectedUser);

        Response response = resource.createUser(user);

        assertThat(response.getStatus()).isEqualTo(201);
        assertThat(response.getEntity()).isEqualTo(expectedUser);
    }

    @Test
    public void should_find_user_and_add_him_a_new_list() {
        long userId = 12345L;

        User expectedUser = new User(userId, "test@test.fr", "test", "password");
        given(userRepository.get(userId)).willReturn(expectedUser);

        Response response = resource.addNewList(userId, "Apéro tonight");

        assertThat(response.getStatus()).isEqualTo(201);
        ShoppingList list = (ShoppingList) response.getEntity();
        assertThat(list.id).isEqualTo(1L);
        assertThat(list.title).isEqualTo("Apéro tonight");
    }
}
