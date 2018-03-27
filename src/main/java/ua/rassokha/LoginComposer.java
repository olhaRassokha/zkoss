package ua.rassokha;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Textbox;
import ua.rassokha.DAO.UserNotFoundException;
import ua.rassokha.service.AuthenticationService;
import ua.rassokha.service.DefautImpl.AuthenticationServiceImpl;

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

	private AuthenticationService authService = new AuthenticationServiceImpl();

	@Listen("onClick = #loginButton")
	public void login() throws SQLException, UserNotFoundException {
		if (authService.login(usernameText.getValue(), passwordText.getValue())) {
			Executions.sendRedirect("/home.zul");
		}
		else {
		    invalidPasswordOrUsername.setVisible(true);
		}
	}
}
