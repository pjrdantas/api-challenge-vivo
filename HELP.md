# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.8/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.8/maven-plugin/reference/html/#build-image)
* [Quartz Scheduler](https://docs.spring.io/spring-boot/docs/2.6.8/reference/htmlsingle/#io.quartz)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.8/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

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
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `database`.`tb_device` (`id` ASC);