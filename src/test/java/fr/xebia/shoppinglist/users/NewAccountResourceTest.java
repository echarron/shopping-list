package fr.xebia.shoppinglist.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import javax.ws.rs.core.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class NewAccountResourceTest {

    @InjectMocks
    private NewAccountResource resource;

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

}
