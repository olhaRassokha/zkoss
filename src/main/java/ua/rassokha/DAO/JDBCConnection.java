package ua.rassokha.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static final String userName = "postgres";
    public static final String password = "0506909637gfgf";
    public static final String url = "jdbc:postgresql://localhost:5432/postgres";

    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url, userName, password);
    }
}
