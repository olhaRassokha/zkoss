package ua.rassokha.ui;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Textbox;
import ua.rassokha.DAO.exeption.UserNotFoundException;
import ua.rassokha.service.AuthenticationService;
import ua.rassokha.service.DefautImpl.AuthenticationServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class LoginComposer extends SelectorComposer {

	private int count;
	@Wire
	private Textbox usernameText;

	@Wire
	private Textbox passwordText;

	@Wire
	private Button loginButton;
	@Wire
	private Div invalidPasswordOrUsername;
	@Wire
	private Div someServerError;

	private AuthenticationService authService = new AuthenticationServiceImpl();

	@Listen("onClick = #loginButton")
	public void login() {
		try {


			if (authService.login(usernameText.getValue(), passwordText.getValue())) {
                Executions.sendRedirect("/home.zul");
            }
            else {
				invalidPasswordOrUsername.setVisible(true);
			}
		} catch (SQLException | IOException ex) {
			someServerError.setVisible(true);
		} catch (UserNotFoundException e) {
			invalidPasswordOrUsername.setVisible(true);
		}
	}
}
