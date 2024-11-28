-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: mysql
-- Generation Time: Nov 28, 2024 at 08:17 PM
-- Server version: 9.1.0
-- PHP Version: 8.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vuelosypasajeros`
--

-- --------------------------------------------------------

--
-- Table structure for table `PASAJEROS`
--

CREATE TABLE `PASAJEROS` (
  `NUM` int NOT NULL,
  `COD_VUELO` varchar(10) NOT NULL,
  `TIPO_PLAZA` varchar(2) DEFAULT NULL,
  `FUMADOR` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `PASAJEROS`
--

INSERT INTO `PASAJEROS` (`NUM`, `COD_VUELO`, `TIPO_PLAZA`, `FUMADOR`) VALUES
(123, 'IB-SP-4567', 'TU', 'SI'),
(124, 'IB-SP-4567', 'PR', 'SI'),
(125, 'IB-SP-4567', 'PR', 'NO'),
(126, 'FR-DC-4667', 'PR', 'SI'),
(126, 'IB-BA-46DC', 'TU', 'SI'),
(127, 'IB-BA-46DC', 'PR', 'SI'),
(128, 'FR-DC-4667', 'TU', 'NO'),
(129, 'FR-DC-4667', 'TU', 'SI'),
(130, 'AV-DC2-269', 'TU', 'SI'),
(130, 'AV-DC9-233', 'TU', 'SI'),
(131, 'AV-DC2-269', 'TU', 'NO'),
(131, 'AV-DC9-233', 'TU', 'NO'),
(132, 'AV-DC2-269', 'PR', 'SI'),
(132, 'AV-DC9-233', 'PR', 'SI'),
(133, 'AI-1289-9', 'PR', 'SI'),
(133, 'IB-D5-347', 'PR', 'SI'),
(134, 'AI-1289-9', 'PR', 'SI'),
(134, 'IB-D5-347', 'PR', 'SI'),
(135, 'AI-1289-9', 'TU', 'NO'),
(135, 'IB-D5-347', 'TU', 'NO'),
(136, 'AI-1289-9', 'TU', 'SI'),
(136, 'IB-D5-347', 'TU', 'SI'),
(137, 'FR-DC-4667', 'TU', 'SI'),
(137, 'SP-DC-438', 'TU', 'SI'),
(138, 'FR-DC-4667', 'TU', 'NO'),
(138, 'SP-DC-438', 'TU', 'NO'),
(139, 'FR-DC-4667', 'PR', 'SI'),
(139, 'SP-DC-438', 'PR', 'SI'),
(140, 'SP-DC-438', 'PR', 'SI'),
(141, 'FR-DC7-247', 'PR', 'SI'),
(142, 'FR-DC7-247', 'TU', 'NO'),
(143, 'FR-DC7-247', 'TU', 'SI');

-- --------------------------------------------------------

--
-- Table structure for table `VUELOS`
--

CREATE TABLE `VUELOS` (
  `COD_VUELO` varchar(10) NOT NULL,
  `HORA_SALIDA` varchar(15) DEFAULT NULL,
  `DESTINO` varchar(15) DEFAULT NULL,
  `PROCEDENCIA` varchar(15) DEFAULT NULL,
  `PLAZAS_FUMADOR` int DEFAULT NULL,
  `PLAZAS_NO_FUMADOR` int DEFAULT NULL,
  `PLAZAS_TURISTA` int DEFAULT NULL,
  `PLAZAS_PRIMERA` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `VUELOS`
--

INSERT INTO `VUELOS` (`COD_VUELO`, `HORA_SALIDA`, `DESTINO`, `PROCEDENCIA`, `PLAZAS_FUMADOR`, `PLAZAS_NO_FUMADOR`, `PLAZAS_TURISTA`, `PLAZAS_PRIMERA`) VALUES
('AI-1289-9', '02/04/99-14:30', 'BARCELONA', 'BONN', 150, 100, 180, 70),
('AI-D7-347', '30/03/99-13:35', 'BILBAO', 'MOSCÚ', 100, 200, 210, 90),
('AV-DC-347', '29/03/99-13:35', 'VALENCIA', 'ROMA', 100, 200, 210, 90),
('AV-DC2-269', '02/04/99-12:00', 'MADRID', 'LA HAYA', 100, 100, 180, 20),
('AV-DC9-233', '01/04/99-17:35', 'VALENCIA', 'SOFÍA', 100, 100, 100, 100),
('FR-DC-4667', '28/03/99-13:30', 'BRUSELAS', 'SEVILLA', 90, 100, 160, 30),
('FR-DC2-269', '01/04/99-19:00', 'CÓRDOBA', 'MANILA', 100, 100, 180, 20),
('FR-DC7-247', '01/04/99-15:35', 'CORDOBA', 'EL CAIRO', 100, 100, 100, 100),
('IB-98779', '02/04/99-08:00', 'MADRID', 'LIMA', 200, 100, 250, 50),
('IB-BA-46DC', '28/03/99-12:30', 'ROMA', 'MADRID', 90, 100, 160, 30),
('IB-D5-347', '01/04/99-13:35', 'ZARAGOZA', 'PARIS', 100, 200, 210, 90),
('IB-SP-4567', '27/03/99-10:30', 'PARIS', 'MADRID', 100, 100, 160, 40),
('SP-DC-438', '30/03/99-09:20', 'MOSCÚ', 'SEVILLA', 90, 100, 160, 30);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `PASAJEROS`
--
ALTER TABLE `PASAJEROS`
  ADD PRIMARY KEY (`NUM`,`COD_VUELO`),
  ADD KEY `COD_VUELO` (`COD_VUELO`);

--
-- Indexes for table `VUELOS`
--
ALTER TABLE `VUELOS`
  ADD PRIMARY KEY (`COD_VUELO`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `PASAJEROS`
--
ALTER TABLE `PASAJEROS`
  ADD CONSTRAINT `PASAJEROS_ibfk_1` FOREIGN KEY (`COD_VUELO`) REFERENCES `VUELOS` (`COD_VUELO`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
