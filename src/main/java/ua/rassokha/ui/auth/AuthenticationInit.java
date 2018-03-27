package ua.rassokha.ui.auth;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;
import ua.rassokha.domain.User;
import ua.rassokha.service.AuthenticationService;
import ua.rassokha.service.DefautImpl.AuthenticationServiceImpl;

import java.util.Map;

public class AuthenticationInit implements Initiator {


    // services
    private AuthenticationService authService = new AuthenticationServiceImpl();

    public void doInit(Page page, Map<String, Object> args) throws Exception {
        User user = authService.getUser();
        if (user == null) {
            Executions.sendRedirect("/index.zul");
            return;
        }
    }

}