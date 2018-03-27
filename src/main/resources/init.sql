CREATE SCHEMA IF NOT EXISTS users;
DROP SEQUENCE IF EXISTS user_sequance CASCADE;
CREATE SEQUENCE user_sequance;
CREATE TABLE users."user"(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('category_sequance'),
  username VARCHAR(20),
  password VARCHAR(60)
);