SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE SCHEMA IF NOT EXISTS `EasyInv` DEFAULT CHARACTER SET utf8 ;
USE `EasyInv` ;
CREATE TABLE IF NOT EXISTS `EasyInv`.`nodeuser` ( `idnodeuser` INT NOT NULL AUTO_INCREMENT,`surname` VARCHAR(45) NULL, `name` VARCHAR(45) NULL, `otchestvo` VARCHAR(45) NULL, PRIMARY KEY (`idnodeuser`), UNIQUE INDEX `idnodeUser_UNIQUE` (`idnodeuser` ASC)) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`sbe` ( `idSBE` INT NOT NULL AUTO_INCREMENT, `SBEname` VARCHAR(45) NOT NULL, PRIMARY KEY (`idSBE`), UNIQUE INDEX `idSBE_UNIQUE` (`idSBE` ASC)) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`departments` ( `iddepartment` INT NOT NULL AUTO_INCREMENT, `department` VARCHAR(50) NOT NULL, PRIMARY KEY (`iddepartment`), UNIQUE INDEX `iddepartment_UNIQUE` (`iddepartment` ASC)) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`models` ( `idmodel` INT NOT NULL, `model` VARCHAR(45) NOT NULL, `vendor` VARCHAR(45) NOT NULL, PRIMARY KEY (`idmodel`), UNIQUE INDEX `idModel_UNIQUE` (`idmodel` ASC)) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`hdd` ( `idhdd` INT NOT NULL, `idmodel` INT NULL, `capacity` INT NULL, `rpm` INT NULL, PRIMARY KEY (`idhdd`), INDEX `model_idx` (`idmodel` ASC), CONSTRAINT `hdd_model`   FOREIGN KEY (`idmodel`) REFERENCES `EasyInv`.`models` (`idmodel`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`cpu` ( `idcpu` INT NOT NULL, `idmodel` INT NOT NULL, `frequency` INT NOT NULL, `coresNum` INT NOT NULL, `cashe3lvl` INT NULL, PRIMARY KEY (`idcpu`), UNIQUE INDEX `idcpu_UNIQUE` (`idcpu` ASC), INDEX `model_idx` (`idmodel` ASC), CONSTRAINT `cpu_model`  FOREIGN KEY (`idmodel`)  REFERENCES `EasyInv`.`models` (`idmodel`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`memory` ( `idmemory` INT NOT NULL, `model` INT NOT NULL, `memCapacity` INT NOT NULL, `frequency` INT NOT NULL, `type` VARCHAR(10) NOT NULL, PRIMARY KEY (`idmemory`), UNIQUE INDEX `idcpu_UNIQUE` (`idmemory` ASC), INDEX `model_idx` (`model` ASC), CONSTRAINT `mem_model` FOREIGN KEY (`model`) REFERENCES `EasyInv`.`models` (`idmodel`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`gpu` ( `idgpu` INT NOT NULL, `idmodel` INT NOT NULL, `frequency` INT NULL, `memCapacity` INT NULL, `memType` VARCHAR(45) NULL, PRIMARY KEY (`idgpu`), UNIQUE INDEX `idcpu_UNIQUE` (`idgpu` ASC), CONSTRAINT `gpu_model` FOREIGN KEY (`idmodel`) REFERENCES `EasyInv`.`models` (`idmodel`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`soft` ( `idhostsoft` INT NOT NULL AUTO_INCREMENT, `softname` VARCHAR(45) NOT NULL, `version` VARCHAR(45) NOT NULL, `revision` VARCHAR(45) NULL, `lictype` VARCHAR(45) NOT NULL, `licdateinst` DATE NULL, `licterm` DATE NULL, `idadmin` INT NULL, PRIMARY KEY (`idhostsoft`), UNIQUE INDEX `idhostsoft_UNIQUE` (`idhostsoft` ASC)) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`host` ( `idhost` INT NOT NULL, `regnum` INT NOT NULL, `hostname` VARCHAR(45) NOT NULL, `domainname` VARCHAR(45) NULL, `iddomain` INT NOT NULL, `idmemory` INT NOT NULL, `idHDD` INT NOT NULL, `idGPU` INT NOT NULL, `idhostsoft` INT NOT NULL, `screen` INT NULL, PRIMARY KEY (`idhost`), UNIQUE INDEX `hosttype_UNIQUE` (`idhost` ASC), INDEX `idHDD_idx` (`idHDD` ASC), INDEX `idCPU_idx` (`iddomain` ASC), INDEX `idmemory_idx` (`idmemory` ASC), INDEX `idGPU_idx` (`idGPU` ASC), UNIQUE INDEX `regnum_UNIQUE` (`regnum` ASC), INDEX `idhostsoft_idx` (`idhostsoft` ASC), CONSTRAINT `idHDD` FOREIGN KEY (`idHDD`) REFERENCES `EasyInv`.`hdd` (`idhdd`) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT `idCPU` FOREIGN KEY (`iddomain`)  REFERENCES `EasyInv`.`cpu` (`idcpu`) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT `idmemory`  FOREIGN KEY (`idmemory`)  REFERENCES `EasyInv`.`memory` (`idmemory`) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT `idGPU` FOREIGN KEY (`idGPU`) REFERENCES `EasyInv`.`gpu` (`idgpu`) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT `host_regnum` FOREIGN KEY (`regnum`) REFERENCES `EasyInv`.`devices` (`regnum`) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT `idhostsoft`  FOREIGN KEY (`idhostsoft`) REFERENCES `EasyInv`.`soft` (`idhostsoft`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`node` ( `idnode` INT NOT NULL, `nodeName` VARCHAR(45) NOT NULL, `idnodeuser` INT NULL, `idhost` INT NULL, `idSBE` INT NOT NULL, `location` VARCHAR(100) NULL, `iddepartment` INT NOT NULL, PRIMARY KEY (`idnode`), UNIQUE INDEX `nodeName_UNIQUE` (`nodeName` ASC), UNIQUE INDEX `idnode_UNIQUE` (`idnode` ASC), INDEX `nodeuser_idx` (`idnodeuser` ASC), UNIQUE INDEX `nodeuser_UNIQUE` (`idnodeuser` ASC), UNIQUE INDEX `nodehost_UNIQUE` (`idhost` ASC), INDEX `idSBE_idx` (`idSBE` ASC), INDEX `iddepartment_idx` (`iddepartment` ASC), CONSTRAINT `idnodeuser` FOREIGN KEY (`idnodeuser`) REFERENCES `EasyInv`.`nodeuser` (`idnodeuser`) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT `idSBE` FOREIGN KEY (`idSBE`) REFERENCES `EasyInv`.`sbe` (`idSBE`) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT `iddepartment` FOREIGN KEY (`iddepartment`) REFERENCES `EasyInv`.`departments` (`iddepartment`) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT `idhost` FOREIGN KEY (`idhost`) REFERENCES `EasyInv`.`host` (`idhost`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`devicetypes` ( `iddevicetype` INT NOT NULL AUTO_INCREMENT, `devicetype` INT NOT NULL, `idmodel` INT NOT NULL, PRIMARY KEY (`iddevicetype`), UNIQUE INDEX `iddevicetype_UNIQUE` (`iddevicetype` ASC), UNIQUE INDEX `regnum_UNIQUE` (`devicetype` ASC), INDEX `idmodel_idx` (`idmodel` ASC), CONSTRAINT `idmodel` FOREIGN KEY (`idmodel`) REFERENCES `EasyInv`.`models` (`idmodel`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`devices` ( `regnum` INT NOT NULL, `invnum` VARCHAR(10) NULL, `devicetype` INT NOT NULL, `idnode` INT NOT NULL, `state` VARCHAR(45) NOT NULL, `description` VARCHAR(100) NULL, PRIMARY KEY (`regnum`), UNIQUE INDEX `idnode_UNIQUE` (`regnum` ASC), INDEX `devicetype_idx` (`devicetype` ASC), CONSTRAINT `idnode` FOREIGN KEY (`idnode`) REFERENCES `EasyInv`.`node` (`idnode`) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT `devicetype` FOREIGN KEY (`devicetype`) REFERENCES `EasyInv`.`devicetypes` (`iddevicetype`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`admins` ( `idadmin` INT NOT NULL AUTO_INCREMENT, `login` VARCHAR(45) NULL, `password` VARCHAR(45) NULL, `surname` VARCHAR(45) NOT NULL, `name` VARCHAR(45) NOT NULL, `otchestvo` VARCHAR(45) NOT NULL, PRIMARY KEY (`idadmin`), UNIQUE INDEX `idadmin_UNIQUE` (`idadmin` ASC)) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`reasons` ( `idreason` INT NOT NULL AUTO_INCREMENT, `reason` VARCHAR(100) NOT NULL, PRIMARY KEY (`idreason`), UNIQUE INDEX `idreason_UNIQUE` (`idreason` ASC)) ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `EasyInv`.`transaction` ( `idtransaction` INT NOT NULL AUTO_INCREMENT, `regnum` INT NOT NULL, `idnodefrom` INT NOT NULL, `idnodeto` INT NOT NULL, `idadmin` INT NOT NULL, `transactiondate` DATE NOT NULL, `idreason` INT NOT NULL, PRIMARY KEY (`idtransaction`), UNIQUE INDEX `idtransaction_UNIQUE` (`idtransaction` ASC), INDEX `idadmin_idx` (`idadmin` ASC), INDEX `idreason_idx` (`idreason` ASC), INDEX `regnum_idx` (`regnum` ASC), CONSTRAINT `idadmin` FOREIGN KEY (`idadmin`) REFERENCES `EasyInv`.`admins` (`idadmin`) ON DELETE NO ACTION ON UPDATE NO ACTION, CONSTRAINT `idreason` FOREIGN KEY (`idreason`) REFERENCES `EasyInv`.`reasons` (`idreason`) ON DELETE NO ACTION ON UPDATE NO ACTION, CONSTRAINT `trans_regnum` FOREIGN KEY (`regnum`) REFERENCES `EasyInv`.`devices` (`regnum`) ON DELETE RESTRICT ON UPDATE CASCADE) ENGINE = InnoDB;
USE `EasyInv` ;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
