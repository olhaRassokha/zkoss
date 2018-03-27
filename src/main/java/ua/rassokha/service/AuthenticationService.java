package ua.rassokha.service;

import ua.rassokha.DAO.UserNotFoundException;
import ua.rassokha.domain.User;

import java.sql.SQLException;

public interface AuthenticationService {

    /** login with account and password **/
    public boolean login(String account, String password) throws SQLException, UserNotFoundException;

    /** logout current user **/
    public void logout();

    /** get current user credential **/
    public User getUser();

    User register(String value, String value1) throws SQLException;
}