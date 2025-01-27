CREATE DATABASE IF NOT EXISTS `spring_crud_timeleaf`;
USE `spring_crud_timeleaf`;

CREATE TABLE IF NOT EXISTS `alumno` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `apellidos` VARCHAR(255) NULL DEFAULT NULL,
  `clase` VARCHAR(255) NULL DEFAULT NULL,
  `curso` VARCHAR(255) NULL DEFAULT NULL,
  `edad` INT NOT NULL,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `notas` TEXT NULL DEFAULT NULL, 
  PRIMARY KEY (`id`)
);

INSERT INTO `alumno` (`apellidos`, `clase`, `curso`, `edad`, `nombre`) VALUES
('de la Torre Molina', 'DAW', 'segundo', 40, 'Francisco José'),
('de la Torre Molina', 'DAW', 'segundo', 39, 'Fran'),
('Molina', 'DAW', 'segundo', 39, 'Francisco José'),
('De la Torre', 'DAW', 'segundo', 39, 'José'),
('de Molina', 'DAW', 'segundo', 39, 'Francisco'),
('del Molina', 'DAW', 'segundo', 39, 'Javier');
