package ua.rassokha.ui;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import ua.rassokha.service.AuthenticationService;
import ua.rassokha.service.DefautImpl.AuthenticationServiceImpl;

public class MenuComposer extends SelectorComposer {
    private AuthenticationService authService = new AuthenticationServiceImpl();

    @Listen("onClick = #register")
    public void register(){
        Executions.sendRedirect("/registration.zul");
    }
    @Listen("onClick = #login")
    public void login(){
        Executions.sendRedirect("/index.zul");
    }
    @Listen("onClick = #logout")
    public void logout(){
        authService.logout();
        Executions.sendRedirect("/index.zul");
    }
}
