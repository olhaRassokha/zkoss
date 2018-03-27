package ua.rassokha.service.DefautImpl;

import org.apache.commons.codec.digest.DigestUtils;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import ua.rassokha.DAO.exeption.UserNotFoundException;
import ua.rassokha.DAO.UserRepository;
import ua.rassokha.domain.User;
import ua.rassokha.service.AuthenticationService;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

public class AuthenticationServiceImpl implements AuthenticationService, Serializable {
    UserRepository userRepository = new UserRepository();

    public boolean login(String username, String password) throws SQLException, IOException {
        if (username == null || password ==null) {
            return false;
        }
        try {
            User user = userRepository.getByUsername(username);
            if (user.getPassword().equals(DigestUtils.md5Hex(password))) {
                Session sess = Sessions.getCurrent();
                sess.setAttribute("user", user);
            }
            else {
                return false;
            }
        }
        catch (UserNotFoundException ex){
            return false;
        }
        return true;
    }

    public void logout() {
        Session sess = Sessions.getCurrent();
        sess.removeAttribute("user");
    }

    public User getUser() {
        Session sess = Sessions.getCurrent();
        User cre = (User) sess.getAttribute("user");
        return cre;
    }

    public User register(String username, String passsword) throws SQLException, IOException {
        return userRepository.save(new User(username,DigestUtils.md5Hex(passsword)));
    }
    public boolean passwordMatches(String password, String passwordVerify){
        if(password.equals(passwordVerify)){
            return true;
        }
        return false;
    }
}