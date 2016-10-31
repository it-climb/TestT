DROP TABLE 'testT'.'users';
CREATE TABLE `testT`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(20) CHARACTER SET 'utf8' NOT NULL,
  `password` VARCHAR(60) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC));

DROP TABLE 'testT'.'roles';
CREATE TABLE `testT`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(15) CHARACTER SET 'utf8' NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `testT`.`users` (`login`, `password`)
VALUES ('admin', '$2a$08$gfKJLDxbYkl8KgWtec7Lw.Ayh/QFj3cDKOCMXpSsPD0FQD0fk/DNu');

INSERT INTO `testT`.`roles` (`role`, `user_id`)
VALUES ('ROLE_ADMIN', 1);

CREATE TABLE `testT`.`userDetails` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `birthdayDate` DATE NULL,
  `registrationDate` DATE NULL,
  `sex` VARCHAR(45) NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`));