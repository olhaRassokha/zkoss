package ua.rassokha.DAO;

import org.apache.commons.codec.digest.DigestUtils;
import ua.rassokha.domain.User;

import java.sql.SQLException;

public class Test {
    public static void main(String... args) throws SQLException, UserNotFoundException {
        UserRepository userRepository = new UserRepository();
        userRepository.save(new User("1234", "1234"));
    }
}
