/*
 * This file is generated by jOOQ.
*/
package ua.rassokha.generated;


import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import ua.rassokha.generated.tables.User;
import ua.rassokha.generated.tables.records.UserRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>users</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<UserRecord> USER_PKEY = UniqueKeys0.USER_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<UserRecord> USER_PKEY = Internal.createUniqueKey(User.USER, "user_pkey", User.USER.ID);
    }
}
