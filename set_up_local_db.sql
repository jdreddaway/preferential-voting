CREATE DATABASE IF NOT EXISTS prefvoting;

CREATE USER 'prefvoting_dev'@'localhost' IDENTIFIED BY 'preference1';
GRANT ALL PRIVILEGES ON prefvoting.* TO 'prefvoting_dev'@'localhost';
FLUSH PRIVILEGES;

USE prefvoting;

CREATE TABLE IF NOT EXISTS elections (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100)
);
