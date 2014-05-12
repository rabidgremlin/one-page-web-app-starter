SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS onepagestarter;
CREATE DATABASE onepagestarter; 

GRANT ALL ON onepagestarter.* TO onepagestarter@'localhost' IDENTIFIED BY 'password123';

USE onepagestarter;

CREATE TABLE IF NOT EXISTS todo (
  id varchar(36) NOT NULL,
  description varchar(100) NOT NULL,
  completed tinyint(1) NOT NULL DEFAULT '0',
  lastDateTimeModified timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO todo (id, description, completed, lastDateTimeModified) VALUES
('555c4b0a-fab2-4e43-a3b3-da4232e530ea', 'Buy some milk', 0, '2014-05-09 02:43:59'),
('4541739f-f855-4508-971d-ca74e4e0bc7f', 'Pick up dry cleaning', 1, '2014-05-09 02:43:59'),
('a59ce106-fd73-4c99-ba1d-ae7bb70a64b6', 'Put out trash', 0, '2014-05-09 02:44:51');

