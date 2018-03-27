package ua.rassokha;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import ua.rassokha.DAO.UserNotFoundException;
import ua.rassokha.domain.User;
import ua.rassokha.service.AuthenticationService;
import ua.rassokha.service.DefautImpl.AuthenticationServiceImpl;
 import org.zkoss.zk.ui.Component;

import java.awt.*;
import java.sql.SQLException;

public class MenuComposer extends SelectorComposer {
    private AuthenticationService authService = new AuthenticationServiceImpl();
    @Wire
    MenuItem logout;
    @Wire
    Menu login;

    @Listen("onClick = #register")
    public void register() throws SQLException, UserNotFoundException {
        Executions.sendRedirect("/registration.zul");
    }
    @Listen("onClick = #login")
    public void login() throws SQLException, UserNotFoundException {
        Executions.sendRedirect("/index.zul");
    }
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        User current = authService.getUser();
        if(current.getUsername()!=null){
            login.removeAll();
            login.add(logout);
        }
    }
}
