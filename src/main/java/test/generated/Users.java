/*
 * This file is generated by jOOQ.
*/
package test.generated;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import test.generated.tables.User;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Users extends SchemaImpl {

    private static final long serialVersionUID = -996577953;

    /**
     * The reference instance of <code>users</code>
     */
    public static final Users USERS = new Users();

    /**
     * The table <code>users.user</code>.
     */
    public final User USER = test.generated.tables.User.USER;

    /**
     * No further instances allowed
     */
    private Users() {
        super("users", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            User.USER);
    }
}
