-- MySQL Script generated by MySQL Workbench
-- Tue Jun 19 20:38:10 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema EasyInv
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema EasyInv
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `EasyInv` DEFAULT CHARACTER SET utf8 ;
USE `EasyInv` ;

-- -----------------------------------------------------
-- Table `EasyInv`.`nodeuser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EasyInv`.`nodeuser` (
  `idnodeuser` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `otchestvo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idnodeuser`),
  UNIQUE INDEX `idnodeUser_UNIQUE` (`idnodeuser` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyInv`.`hdd`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EasyInv`.`hdd` (
  `idhdd` INT NOT NULL,
  `model` VARCHAR(30) NULL,
  `capacity` INT NOT NULL,
  `rpm` INT NULL,
  `vendor` VARCHAR(30) NULL,
  PRIMARY KEY (`idhdd`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyInv`.`memory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EasyInv`.`memory` (
  `idmemory` INT NOT NULL,
  `model` VARCHAR(30) NULL,
  `memCapacity` INT NOT NULL,
  `frequency` INT NULL,
  `type` VARCHAR(10) NOT NULL,
  `vendor` VARCHAR(30) NULL,
  PRIMARY KEY (`idmemory`),
  UNIQUE INDEX `idcpu_UNIQUE` (`idmemory` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyInv`.`gpu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EasyInv`.`gpu` (
  `idgpu` INT NOT NULL,
  `model` VARCHAR(30) NULL,
  `frequency` INT NULL,
  `memCapacity` INT NOT NULL,
  `memType` VARCHAR(45) NOT NULL,
  `vendor` VARCHAR(30) NULL,
  PRIMARY KEY (`idgpu`),
  UNIQUE INDEX `idcpu_UNIQUE` (`idgpu` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyInv`.`soft`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EasyInv`.`soft` (
  `idhostsoft` INT NOT NULL AUTO_INCREMENT,
  `softname` VARCHAR(45) NOT NULL,
  `version` VARCHAR(45) NULL,
  `revision` VARCHAR(45) NULL,
  `lictype` VARCHAR(45) NULL,
  `licdateinst` VARCHAR(10) NULL,
  `licterm` VARCHAR(10) NULL,
  `idadmin` INT NULL,
  PRIMARY KEY (`idhostsoft`),
  UNIQUE INDEX `idhostsoft_UNIQUE` (`idhostsoft` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyInv`.`cpu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EasyInv`.`cpu` (
  `idcpu` INT NOT NULL,
  `model` VARCHAR(30) NULL,
  `frequency` INT NOT NULL,
  `coresNum` INT NOT NULL,
  `cashe3lvl` INT NULL,
  `vendor` VARCHAR(30) NULL,
  PRIMARY KEY (`idcpu`),
  UNIQUE INDEX `idcpu_UNIQUE` (`idcpu` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyInv`.`host`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EasyInv`.`host` (
  `idhost` INT NOT NULL,
  `regnum` INT NULL,
  `hostname` VARCHAR(45) NULL,
  `domainname` VARCHAR(45) NULL,
  `idmemory` INT NULL,
  `idHDD` INT NULL,
  `idGPU` INT NULL,
  `idhostsoft` INT NOT NULL,
  `screen` INT NULL,
  `idcpu` INT NULL,
  `sn` VARCHAR(25) NULL,
  `pn` VARCHAR(25) NULL,
  PRIMARY KEY (`idhost`),
  UNIQUE INDEX `hosttype_UNIQUE` (`idhost` ASC),
  INDEX `idHDD_idx` (`idHDD` ASC),
  INDEX `idmemory_idx` (`idmemory` ASC),
  INDEX `idGPU_idx` (`idGPU` ASC),
  UNIQUE INDEX `regnum_UNIQUE` (`regnum` ASC),
  INDEX `idhostsoft_idx` (`idhostsoft` ASC),
  INDEX `icpu_idx` (`idcpu` ASC),
  UNIQUE INDEX `sn_UNIQUE` (`sn` ASC),
  CONSTRAINT `idHDD`
    FOREIGN KEY (`idHDD`)
    REFERENCES `EasyInv`.`hdd` (`idhdd`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idmemory`
    FOREIGN KEY (`idmemory`)
    REFERENCES `EasyInv`.`memory` (`idmemory`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idGPU`
    FOREIGN KEY (`idGPU`)
    REFERENCES `EasyInv`.`gpu` (`idgpu`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `host_regnum`
    FOREIGN KEY (`regnum`)
    REFERENCES `EasyInv`.`devices` (`regnum`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idhostsoft`
    FOREIGN KEY (`idhostsoft`)
    REFERENCES `EasyInv`.`soft` (`idhostsoft`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `icpu`
    FOREIGN KEY (`idcpu`)
    REFERENCES `EasyInv`.`cpu` (`idcpu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyInv`.`node`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EasyInv`.`node` (
  `idnode` INT NOT NULL,
  `nodeName` VARCHAR(45) NOT NULL,
  `idnodeuser` INT NULL,
  `idhost` INT NULL,
  `SBE` VARCHAR(30) NULL,
  `location` VARCHAR(100) NULL,
  `department` VARCHAR(30) NULL,
  PRIMARY KEY (`idnode`),
  UNIQUE INDEX `nodeName_UNIQUE` (`nodeName` ASC),
  UNIQUE INDEX `idnode_UNIQUE` (`idnode` ASC),
  INDEX `nodeuser_idx` (`idnodeuser` ASC),
  UNIQUE INDEX `nodeuser_UNIQUE` (`idnodeuser` ASC),
  UNIQUE INDEX `nodehost_UNIQUE` (`idhost` ASC),
  CONSTRAINT `idnodeuser`
    FOREIGN KEY (`idnodeuser`)
    REFERENCES `EasyInv`.`nodeuser` (`idnodeuser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idhost`
    FOREIGN KEY (`idhost`)
    REFERENCES `EasyInv`.`host` (`idhost`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyInv`.`devices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EasyInv`.`devices` (
  `regnum` INT NOT NULL,
  `invnum` VARCHAR(10) NULL,
  `devicetype` VARCHAR(30) NULL,
  `idnode` INT NULL,
  `state` VARCHAR(45) NULL,
  `description` VARCHAR(100) NULL,
  `model` VARCHAR(25) NOT NULL,
  `vendor` VARCHAR(25) NULL,
  `sn` VARCHAR(25) NULL,
  `pn` VARCHAR(25) NULL,
  PRIMARY KEY (`regnum`),
  UNIQUE INDEX `idnode_UNIQUE` (`regnum` ASC),
  UNIQUE INDEX `idmodel_UNIQUE` (`model` ASC),
  UNIQUE INDEX `sn_UNIQUE` (`sn` ASC),
  CONSTRAINT `idnode`
    FOREIGN KEY (`idnode`)
    REFERENCES `EasyInv`.`node` (`idnode`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyInv`.`admins`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EasyInv`.`admins` (
  `idadmin` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `otchestvo` VARCHAR(45) NOT NULL,
  `isadmin` TINYINT(1) NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idadmin`),
  UNIQUE INDEX `idadmin_UNIQUE` (`idadmin` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EasyInv`.`transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EasyInv`.`transaction` (
  `idtransaction` INT NOT NULL AUTO_INCREMENT,
  `regnum` INT NOT NULL,
  `idnodefrom` INT NOT NULL,
  `idnodeto` INT NOT NULL,
  `idadmin` INT NOT NULL,
  `transactiondate` VARCHAR(10) NULL,
  `reason` VARCHAR(100) NULL,
  PRIMARY KEY (`idtransaction`),
  UNIQUE INDEX `idtransaction_UNIQUE` (`idtransaction` ASC),
  INDEX `regnum_idx` (`regnum` ASC),
  INDEX `idnodefrom_idx` (`idnodefrom` ASC),
  INDEX `idnodeto_idx` (`idnodeto` ASC),
  INDEX `idadmin_idx` (`idadmin` ASC),
  CONSTRAINT `trans_regnum`
    FOREIGN KEY (`regnum`)
    REFERENCES `EasyInv`.`devices` (`regnum`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `idnodefrom`
    FOREIGN KEY (`idnodefrom`)
    REFERENCES `EasyInv`.`node` (`idnode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idnodeto`
    FOREIGN KEY (`idnodeto`)
    REFERENCES `EasyInv`.`node` (`idnode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idadmin`
    FOREIGN KEY (`idadmin`)
    REFERENCES `EasyInv`.`admins` (`idadmin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
