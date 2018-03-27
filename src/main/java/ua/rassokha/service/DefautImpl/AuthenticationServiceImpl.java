package ua.rassokha.service.DefautImpl;

import org.apache.commons.codec.digest.DigestUtils;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import ua.rassokha.DAO.UserNotFoundException;
import ua.rassokha.DAO.UserRepository;
import ua.rassokha.domain.User;
import ua.rassokha.service.AuthenticationService;

import java.io.Serializable;
import java.sql.SQLException;

public class AuthenticationServiceImpl implements AuthenticationService, Serializable {
    UserRepository userRepository = new UserRepository();

    public boolean login(String username, String password) throws SQLException {
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
        if (cre == null) {
            cre = new User();// new a anonymous user and set to
            // session
            sess.setAttribute("user", cre);
        }
        return cre;
    }

    public User register(String username, String passsword) throws SQLException {
        return userRepository.save(new User(username,DigestUtils.md5Hex(passsword)));
    }

}