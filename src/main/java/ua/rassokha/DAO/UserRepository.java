package ua.rassokha.DAO;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import test.generated.tables.records.UserRecord;
import ua.rassokha.domain.User;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static test.generated.tables.User.USER;

public class UserRepository {
    public User save(User user) throws SQLException {
        Connection conn = JDBCConnection.getConnection();
        DSLContext create = DSL.using(conn, SQLDialect.POSTGRES_9_5);
        create.insertInto(USER, USER.USERNAME, USER.PASSWORD)
                .values(user.getUsername(), user.getPassword()).execute();
        return user;
    }

    public User getByUsername(String username) throws SQLException, UserNotFoundException {
            Connection conn = JDBCConnection.getConnection();
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES_9_5);
            List<User> users = create.selectDistinct().from(USER)
                    .where(USER.USERNAME.eq(username)).fetchInto(User.class);
            if(users.size()==0){
                throw new UserNotFoundException();
            }
        return users.get(0);
    }

}
