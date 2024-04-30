-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 30-04-2024 a las 08:35:05
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cuentas`
--

CREATE TABLE `Cuentas` (
  `num_cuenta` varchar(100) NOT NULL,
  `saldo` double NOT NULL,
  `tipo_cuenta` int NOT NULL,
  `nombre_y_apellidos` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dni` varchar(100) NOT NULL,
  `tipo_interes_anual` double DEFAULT '0',
  `com_mantenimiento` double DEFAULT '0',
  `comision_fija_descubierto` double DEFAULT '0',
  `tipo_interes_descubierto` double DEFAULT '0',
  `max_descubierto_permitido` double DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Cuentas`
--

INSERT INTO `Cuentas` (`num_cuenta`, `saldo`, `tipo_cuenta`, `nombre_y_apellidos`, `dni`, `tipo_interes_anual`, `com_mantenimiento`, `comision_fija_descubierto`, `tipo_interes_descubierto`, `max_descubierto_permitido`) VALUES
('ES987654321', 15000, 2, 'Kevin Zamora Amela', '20911904M', 0, 30, 0, 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Cuentas`
--
ALTER TABLE `Cuentas`
  ADD UNIQUE KEY `Cuentas_UNIQUE` (`num_cuenta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
