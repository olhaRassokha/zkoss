DROP SCHEMA IF EXISTS users CASCADE;
CREATE SCHEMA IF NOT EXISTS users;
DROP SEQUENCE IF EXISTS user_sequance CASCADE;
CREATE SEQUENCE user_sequance;
CREATE TABLE users."user"(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('user_sequance'),
  username VARCHAR(20),
  password VARCHAR(60)
);
