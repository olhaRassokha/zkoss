package ua.rassokha.service;

import ua.rassokha.DAO.exeption.UserNotFoundException;
import ua.rassokha.domain.User;

import java.io.IOException;
import java.sql.SQLException;

public interface AuthenticationService {

    public boolean login(String account, String password) throws SQLException, UserNotFoundException, IOException;

    public void logout();

    public User getUser();

    User register(String value, String value1) throws SQLException, IOException;

    boolean passwordMatches(String password, String passwordVerify);

    }