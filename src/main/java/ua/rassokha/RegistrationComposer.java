package ua.rassokha;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import ua.rassokha.service.AuthenticationService;
import ua.rassokha.service.DefautImpl.AuthenticationServiceImpl;

import java.sql.SQLException;

public class RegistrationComposer extends SelectorComposer {
    @Wire
    private Textbox usernameText;

    @Wire
    private Textbox passwordText;

    @Wire
    private Textbox passwordVerification;

    @Wire
    private Button registerButton;

    private AuthenticationService authService = new AuthenticationServiceImpl();

    @Listen("onClick = #register")
    public void setRegisterButton() throws SQLException {
        if (authService.register(usernameText.getValue(), passwordText.getValue())!=null) {
            Executions.sendRedirect("/index.zul");
        }
    }


}
