-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.19-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5174
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para db
CREATE DATABASE IF NOT EXISTS `db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db`;

-- Volcando estructura para tabla db.balance
CREATE TABLE IF NOT EXISTS `balance` (
  `id` bigint(20) NOT NULL,
  `capitalPropio` int(11) NOT NULL,
  `deuda` int(11) NOT NULL,
  `ebitda` int(11) NOT NULL,
  `fCashFlow` int(11) NOT NULL,
  `fds` int(11) NOT NULL,
  `idEmpresa` bigint(20) NOT NULL,
  `ingNetoOpCont` int(11) NOT NULL,
  `ingNetoOpDiscont` int(11) NOT NULL,
  `periodo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlwhw5lnpgqsu469rm61xnpeu7` (`idEmpresa`),
  CONSTRAINT `FKlwhw5lnpgqsu469rm61xnpeu7` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.balance: ~71 rows (aproximadamente)
/*!40000 ALTER TABLE `balance` DISABLE KEYS */;
INSERT INTO `balance` (`id`, `capitalPropio`, `deuda`, `ebitda`, `fCashFlow`, `fds`, `idEmpresa`, `ingNetoOpCont`, `ingNetoOpDiscont`, `periodo`) VALUES
	(1, 50000, 15, 44591, 955, 0, 1, 2221, 1051, 2006),
	(2, 30000, 12, 77691, 1096, 0, 1, 3221, 1221, 2007),
	(3, 70000, 14, 85291, 1198, 1, 1, 4568, 2112, 2008),
	(4, 80000, 13, 79463, 1234, 2, 1, 2789, 987, 2009),
	(5, 40000, 12, 74961, 1078, 3, 1, 2034, 1001, 2010),
	(6, 90000, 11, 86431, 2468, 4, 1, 3214, 859, 2011),
	(7, 150000, 10, 86431, 3468, 4, 1, 3214, 859, 2012),
	(8, 250000, 9, 88888, 4468, 5, 1, 3214, 1859, 2013),
	(9, 550000, 8, 89765, 2468, 6, 1, 3214, 859, 2014),
	(10, 5450000, 11, 86431, 2468, 5, 1, 3214, 859, 2015),
	(11, 850000, 11, 91234, 2468, 5, 1, 3214, 859, 2016),
	(12, 50000, 7, 12345, 789, 1, 2, 2345, 1234, 2006),
	(13, 50000, 6, 23456, 978, 3, 2, 3456, 2123, 2007),
	(14, 150000, 4, 34567, 1012, 5, 2, 3232, 1331, 2008),
	(15, 250000, 7, 29291, 999, 7, 2, 2929, 778, 2009),
	(16, 52000, 5, 54961, 3078, 9, 2, 4034, 1001, 2010),
	(17, 750000, 8, 66431, 5468, 9, 2, 4114, 1859, 2011),
	(18, 90000, 8, 66531, 5368, 9, 2, 4444, 1759, 2012),
	(19, 60000, 6, 67431, 6468, 11, 2, 4224, 2859, 2013),
	(20, 30000, 5, 66866, 5468, 10, 2, 4114, 1859, 2014),
	(21, 57000, 5, 66866, 5658, 12, 2, 4114, 1859, 2015),
	(22, 70000, 4, 71866, 7468, 13, 2, 5114, 2159, 2016),
	(23, 50000, 15, 44591, 955, 2, 3, 2221, 1051, 2006),
	(24, 50000, 12, 77691, 1096, 4, 3, 3221, 1221, 2007),
	(25, 50000, 14, 85291, 1198, 6, 3, 4568, 2112, 2008),
	(26, 50000, 13, 79463, 1234, 5, 3, 2789, 987, 2009),
	(27, 50000, 12, 74961, 1078, 6, 3, 2034, 1001, 2010),
	(28, 50000, 14, 85291, 2298, 7, 3, 4568, 2112, 2011),
	(29, 50000, 11, 79463, 2934, 8, 3, 2789, 987, 2012),
	(30, 50000, 12, 74961, 2078, 6, 3, 2034, 1001, 2013),
	(31, 250000, 10, 86444, 3468, 7, 3, 2299, 859, 2014),
	(32, 150000, 9, 79555, 2934, 8, 3, 2789, 987, 2015),
	(33, 850000, 7, 74961, 3078, 9, 3, 2034, 1001, 2016),
	(34, 50000, 18, 33333, 1234, 6, 4, 979, 435, 2006),
	(35, 20000, 15, 44444, 2222, 7, 4, 1728, 924, 2007),
	(36, 850000, 11, 55555, 1198, 8, 4, 4568, 2112, 2008),
	(37, 750000, 9, 66666, 3333, 8, 4, 2345, 1234, 2009),
	(38, 10000, 8, 69696, 3939, 10, 4, 2929, 1231, 2010),
	(39, 650000, 4, 77777, 6545, 14, 4, 3434, 1234, 2011),
	(40, 750000, 5, 64444, 5222, 12, 4, 4728, 1984, 2012),
	(41, 850000, 7, 55555, 3198, 10, 4, 4568, 2112, 2013),
	(42, 780000, 8, 46666, 3333, 9, 4, 2345, 1234, 2014),
	(43, 50007, 6, 79696, 4939, 10, 4, 3929, 1231, 2015),
	(44, 80000, 4, 79977, 6545, 11, 4, 5454, 1234, 2016),
	(45, 70000, 2, 55555, 1000, 11, 5, 1500, 500, 2006),
	(46, 50000, 1, 66766, 2000, 12, 5, 1800, 700, 2007),
	(47, 505000, 2, 77677, 4000, 13, 5, 2568, 2112, 2008),
	(48, 570000, 3, 79463, 3333, 12, 5, 2222, 999, 2009),
	(49, 40000, 2, 74961, 1111, 9, 5, 2024, 1221, 2010),
	(50, 7750000, 2, 72723, 3453, 10, 5, 1212, 859, 2011),
	(51, 7850000, 3, 77877, 4478, 14, 5, 3214, 1359, 2012),
	(52, 150000, 3, 88888, 4949, 12, 5, 2999, 1798, 2013),
	(53, 70000, 2, 89777, 5468, 13, 5, 3214, 1478, 2014),
	(54, 50007, 1, 90431, 5566, 13, 5, 4334, 1150, 2015),
	(55, 5008, 1, 91234, 5968, 14, 5, 5959, 1010, 2016),
	(56, 50000, 2, 55555, 1000, 11, 6, 1500, 500, 2006),
	(57, 50000, 1, 66766, 2000, 12, 6, 1800, 700, 2007),
	(58, 50000, 2, 77677, 4000, 13, 6, 2568, 2112, 2008),
	(59, 50000, 3, 79463, 3333, 12, 6, 2222, 999, 2009),
	(60, 50000, 2, 74961, 1111, 9, 6, 2024, 1221, 2010),
	(61, 50000, 2, 72723, 3453, 10, 6, 1212, 859, 2011),
	(62, 50000, 3, 77877, 4478, 14, 6, 3214, 1359, 2012),
	(63, 50000, 3, 88888, 4949, 12, 6, 2999, 1798, 2013),
	(64, 50000, 2, 89777, 5468, 13, 6, 3214, 1478, 2014),
	(65, 50000, 1, 90431, 5566, 13, 6, 4334, 1150, 2015),
	(66, 50000, 1, 91234, 5968, 14, 6, 5959, 1010, 2016),
	(67, 60000, 18, 986, 78, 0, 7, 158, 25, 2012),
	(68, 60000, 15, 2113, 135, 0, 7, 200, 46, 2013),
	(69, 60000, 15, 3729, 1597, 0, 7, 456, 89, 2014),
	(70, 60000, 11, 10463, 3456, 0, 7, 1346, 498, 2015),
	(71, 60000, 9, 24961, 6543, 0, 7, 4321, 1643, 2016);
/*!40000 ALTER TABLE `balance` ENABLE KEYS */;

-- Volcando estructura para tabla db.condicionesfiltro
CREATE TABLE IF NOT EXISTS `condicionesfiltro` (
  `idMetodologia` bigint(20) NOT NULL,
  `condicionFiltro` varchar(255) DEFAULT NULL,
  KEY `FKh9ajqd761ahmc1pxnd70unfk8` (`idMetodologia`),
  CONSTRAINT `FKh9ajqd761ahmc1pxnd70unfk8` FOREIGN KEY (`idMetodologia`) REFERENCES `metodologia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.condicionesfiltro: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `condicionesfiltro` DISABLE KEYS */;
INSERT INTO `condicionesfiltro` (`idMetodologia`, `condicionFiltro`) VALUES
	(1, 'Consistencia Creciente'),
	(1, 'Margenes crecientes'),
	(1, 'Longevidad');
/*!40000 ALTER TABLE `condicionesfiltro` ENABLE KEYS */;

-- Volcando estructura para tabla db.condicionesorden
CREATE TABLE IF NOT EXISTS `condicionesorden` (
  `idMetodologia` bigint(20) NOT NULL,
  `condicionOrden` varchar(255) DEFAULT NULL,
  KEY `FK9g0h32top0cbrd9xmsh827qan` (`idMetodologia`),
  CONSTRAINT `FK9g0h32top0cbrd9xmsh827qan` FOREIGN KEY (`idMetodologia`) REFERENCES `metodologia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.condicionesorden: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `condicionesorden` DISABLE KEYS */;
INSERT INTO `condicionesorden` (`idMetodologia`, `condicionOrden`) VALUES
	(1, 'Maximizar ROE'),
	(1, 'Minimizar proporcion de deuda'),
	(1, 'Longevidad');
/*!40000 ALTER TABLE `condicionesorden` ENABLE KEYS */;

-- Volcando estructura para tabla db.condicion_filtro
CREATE TABLE IF NOT EXISTS `condicion_filtro` (
  `tipo` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `duenio` bigint(20) NOT NULL,
  `finalIntervalo` int(11) NOT NULL,
  `inicioIntervalo` int(11) NOT NULL,
  `nombreCondicion` varchar(255) DEFAULT NULL,
  `nombreIndicador` varchar(255) DEFAULT NULL,
  `periodo` int(11) NOT NULL,
  `comparador` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.condicion_filtro: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `condicion_filtro` DISABLE KEYS */;
INSERT INTO `condicion_filtro` (`tipo`, `id`, `duenio`, `finalIntervalo`, `inicioIntervalo`, `nombreCondicion`, `nombreIndicador`, `periodo`, `comparador`) VALUES
	('ConsistenciaCreciente', 1, 0, 2016, 2007, 'Consistencia Creciente', 'ROE', 0, 0),
	('ConsistenciaCreciente', 2, 0, 2016, 2007, 'Margenes crecientes', 'Margen', 0, 0),
	('FiltroMayor', 3, 0, 0, 0, 'Longevidad', 'Longevidad', 2014, 10),
	('ConsistenciaCreciente', 4, 0, 2016, 2007, 'Consistencia Creciente', 'ROE', 0, 0),
	('ConsistenciaCreciente', 5, 0, 2016, 2007, 'Margenes crecientes', 'Margen', 0, 0),
	('FiltroMayor', 6, 0, 0, 0, 'Longevidad', 'Longevidad', 2014, 10);
/*!40000 ALTER TABLE `condicion_filtro` ENABLE KEYS */;

-- Volcando estructura para tabla db.condicion_orden
CREATE TABLE IF NOT EXISTS `condicion_orden` (
  `tipo` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `duenio` bigint(20) NOT NULL,
  `finalIntervalo` int(11) NOT NULL,
  `inicioIntervalo` int(11) NOT NULL,
  `nombreCondicion` varchar(255) DEFAULT NULL,
  `nombreIndicador` varchar(255) DEFAULT NULL,
  `periodo` int(11) NOT NULL,
  `importancia` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.condicion_orden: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `condicion_orden` DISABLE KEYS */;
INSERT INTO `condicion_orden` (`tipo`, `id`, `duenio`, `finalIntervalo`, `inicioIntervalo`, `nombreCondicion`, `nombreIndicador`, `periodo`, `importancia`) VALUES
	('Maximizar', 1, 0, 2016, 2007, 'Maximizar ROE', 'ROE', 0, 1),
	('Minimizar', 2, 0, 2016, 2007, 'Minimizar proporcion de deuda', 'proporcionDeuda', 0, 1),
	('OrdenMayor', 3, 0, 0, 0, 'Longevidad', 'Longevidad', 2007, 1),
	('Maximizar', 4, 0, 2016, 2007, 'Maximizar ROE', 'ROE', 0, 1),
	('Minimizar', 5, 0, 2016, 2007, 'Minimizar proporcion de deuda', 'proporcionDeuda', 0, 1),
	('OrdenMayor', 6, 0, 0, 0, 'Longevidad', 'Longevidad', 2007, 1);
/*!40000 ALTER TABLE `condicion_orden` ENABLE KEYS */;

-- Volcando estructura para tabla db.empresa
CREATE TABLE IF NOT EXISTS `empresa` (
  `id` bigint(20) NOT NULL,
  `inicioActividad` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `rentabilidad` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.empresa: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` (`id`, `inicioActividad`, `nombre`, `rentabilidad`) VALUES
	(1, 2000, 'Am�rica M�vil', 0),
	(2, 1955, 'Berkshire Hathaway', 0),
	(3, 1892, 'General Electric', 0),
	(4, 1939, 'Hewlett-Packard', 0),
	(5, 1911, 'IBM', 0),
	(6, 1997, 'Netflix', 0),
	(7, 2012, 'LATAM Airlines Group', 0);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;

-- Volcando estructura para tabla db.indicador
CREATE TABLE IF NOT EXISTS `indicador` (
  `id` bigint(20) NOT NULL,
  `duenio` bigint(20) NOT NULL,
  `formula` varchar(255) DEFAULT NULL,
  `idIndicador` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.indicador: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `indicador` DISABLE KEYS */;
INSERT INTO `indicador` (`id`, `duenio`, `formula`, `idIndicador`) VALUES
	(1, 0, 'ingNetoOpCont + ingNetoOpDiscont', 'ingresoNeto'),
	(2, 0, 'ingresoNeto / capitalPropio', 'ROE'),
	(3, 0, 'deuda/capitalPropio', 'proporcionDeuda'),
	(4, 0, 'ingresoNeto', 'Margen'),
	(5, 0, '2017-inicioActividad', 'Longevidad'),
	(6, 0, '4+4+4', 'ROE');
/*!40000 ALTER TABLE `indicador` ENABLE KEYS */;

-- Volcando estructura para tabla db.metodologia
CREATE TABLE IF NOT EXISTS `metodologia` (
  `id` bigint(20) NOT NULL,
  `duenio` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.metodologia: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `metodologia` DISABLE KEYS */;
INSERT INTO `metodologia` (`id`, `duenio`, `nombre`) VALUES
	(1, 0, 'Warren Buffett');
/*!40000 ALTER TABLE `metodologia` ENABLE KEYS */;

-- Volcando estructura para tabla db.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `email`, `nombre`, `password`) VALUES
	(0, 'benjamenriquez@gmail.com', 'benja', 'Norberto10');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
