package fr.xebia.shoppinglist.users;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class UserRepositoryTest {

    private UserRepository repository = new UserRepository();

    @Test
    public void should_generate_user_id_and_add_user_in_repo() {
        User user = new User("test@test.fr", "username", "password");
        User expectedUser = new User(1L, "test@test.fr", "username", "password");

        User createdUser = repository.create(user);

        assertThat(createdUser).isEqualTo(expectedUser);
    }

}
