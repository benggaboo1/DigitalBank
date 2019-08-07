DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id IDENTITY AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS user_accounts;

CREATE TABLE user_accounts (
  id IDENTITY AUTO_INCREMENT  PRIMARY KEY,
  user_id INT NOT NULL,
  account_number BIGINT NOT NULL,
  balance DECIMAL DEFAULT 1000.00,
  foreign key (user_id) references users(id)
);