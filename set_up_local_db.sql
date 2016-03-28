CREATE DATABASE IF NOT EXISTS prefvoting
  DEFAULT CHARACTER SET utf16;

CREATE USER 'prefvoting_dev'@'localhost' IDENTIFIED BY 'preference1';
GRANT ALL PRIVILEGES ON prefvoting.* TO 'prefvoting_dev'@'localhost';
FLUSH PRIVILEGES;

USE prefvoting;

CREATE TABLE IF NOT EXISTS elections (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS candidates (
  election_id BIGINT NOT NULL,
  candidate_id SMALLINT NOT NULL,
  name varchar(100) NOT NULL,
  description TEXT NOT NULL,
  PRIMARY KEY (election_id, candidate_id),
  FOREIGN KEY (election_id) REFERENCES elections (id)
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS votes (
  vote_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  election_id BIGINT NOT NULL,
  candidate_id SMALLINT NOT NULL,
  rank SMALLINT NOT NULL,
  FOREIGN KEY (election_id, candidate_id) REFERENCES candidates (election_id, candidate_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);
