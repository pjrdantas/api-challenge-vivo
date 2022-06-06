# api-challenge-vivo
api da vivo

# api-challenge-vivo
API to de controle de um ar condicionado

#Endpoint#
GET - http://localhost:8090/service/getStatusInformation/1 - Endereço de Consulta do Status do Aparelho.

PUT - http://localhost:8090/service//updateDeviceInformation/1 - Endereço para usuario poder LIGAR/DESLIGAR, AGENDAR LIGAR e DESLIGAR e MUDAR TEMPERATURA.

Authorization -> Basic Auth

USUARIO: admin

SENHA: admin

#Swagger#

http://localhost:8090/swagger-ui.html#

USUARIO: admin

SENHA: admin


#SCRIPIT DO BANCO DE DADOS#

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
