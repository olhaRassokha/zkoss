package ua.rassokha.ui;

import lombok.Data;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import ua.rassokha.domain.User;
import ua.rassokha.service.AuthenticationService;
import ua.rassokha.service.DefautImpl.AuthenticationServiceImpl;

@Data
public class HomeViewModel {
    private String username;
    private AuthenticationService authService = new AuthenticationServiceImpl();
    @Init
    public void init() {
        User current = authService.getUser();
        username = current.getUsername();
    }
    @Command
    public void logout(){
        authService.logout();
        Executions.sendRedirect("/index.zul");
    }
}
