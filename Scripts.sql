--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `database`.`tb_device` DROP PRIMARY KEY;

ALTER TABLE `database`.`tb_device` DROP INDEX `database`.`id_UNIQUE`;

DROP TABLE `database`.`tb_device`;

CREATE TABLE `database`.`tb_device` (
	`id` INT NOT NULL,
	`tb_device_temperature` DOUBLE NOT NULL,
	`tb_device_power_on_off` TINYINT NOT NULL,
	`tb_device_scheduler_power_on` VARCHAR(45) NOT NULL,
	`tb_device_scheduler_power_off` VARCHAR(45) NOT NULL,
	`tb_device_local_temperature` DOUBLE NOT NULL,
	`tb_device_power_on_active` TINYINT NOT NULL,
	`tb_device_power_off_active` TINYINT NOT NULL,
	`tb_device_message` VARCHAR(200) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `database`.`tb_device` (`id` ASC);

