-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema geekzPOS
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema geekzPOS
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `geekzPOS` DEFAULT CHARACTER SET utf8 ;
USE `geekzPOS` ;

-- -----------------------------------------------------
-- Table `geekzPOS`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geekzPOS`.`Client` (
  `idClient` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `address` TEXT NULL,
  `teleNo` VARCHAR(45) NULL,
  `regDate` VARCHAR(45) NULL,
  PRIMARY KEY (`idClient`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `geekzPOS`.`Teller`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geekzPOS`.`Teller` (
  `idTeller` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `teleNo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTeller`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `geekzPOS`.`ItemRepo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geekzPOS`.`ItemRepo` (
  `idItemRepo` INT NOT NULL AUTO_INCREMENT,
  `inUnitType` VARCHAR(45) NOT NULL,
  `outUnitType` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  `date` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idItemRepo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `geekzPOS`.`ClientOrder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geekzPOS`.`ClientOrder` (
  `idClientOrder` INT NOT NULL AUTO_INCREMENT,
  `orderDate` VARCHAR(45) NOT NULL,
  `returnDate` VARCHAR(45) NULL,
  `orderStatus` VARCHAR(45) NOT NULL,
  `Teller_idTeller` INT NOT NULL,
  `Client_idClient` INT NOT NULL,
  PRIMARY KEY (`idClientOrder`, `Teller_idTeller`, `Client_idClient`),
  CONSTRAINT `fk_ClientOrder_Teller1`
    FOREIGN KEY (`Teller_idTeller`)
    REFERENCES `geekzPOS`.`Teller` (`idTeller`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ClientOrder_Client1`
    FOREIGN KEY (`Client_idClient`)
    REFERENCES `geekzPOS`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_ClientOrder_Teller1_idx` ON `geekzPOS`.`ClientOrder` (`Teller_idTeller` ASC);

CREATE INDEX `fk_ClientOrder_Client1_idx` ON `geekzPOS`.`ClientOrder` (`Client_idClient` ASC);


-- -----------------------------------------------------
-- Table `geekzPOS`.`ItemOrder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geekzPOS`.`ItemOrder` (
  `idItemOrder` INT NOT NULL AUTO_INCREMENT,
  `inAmount` VARCHAR(45) NOT NULL,
  `outAmount` VARCHAR(45) NULL,
  `ClientOrder_idClientOrder` INT NOT NULL,
  `ItemRepo_idItemRepo` INT NOT NULL,
  PRIMARY KEY (`idItemOrder`, `ClientOrder_idClientOrder`, `ItemRepo_idItemRepo`),
  CONSTRAINT `fk_ItemOrder_ClientOrder`
    FOREIGN KEY (`ClientOrder_idClientOrder`)
    REFERENCES `geekzPOS`.`ClientOrder` (`idClientOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemOrder_ItemRepo1`
    FOREIGN KEY (`ItemRepo_idItemRepo`)
    REFERENCES `geekzPOS`.`ItemRepo` (`idItemRepo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_ItemOrder_ClientOrder_idx` ON `geekzPOS`.`ItemOrder` (`ClientOrder_idClientOrder` ASC);

CREATE INDEX `fk_ItemOrder_ItemRepo1_idx` ON `geekzPOS`.`ItemOrder` (`ItemRepo_idItemRepo` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
