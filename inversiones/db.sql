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
  `id` int(11) DEFAULT NULL,
  `deuda` int(11) DEFAULT NULL,
  `capitalPropio` int(11) DEFAULT NULL,
  `ebitda` int(11) DEFAULT NULL,
  `fds` int(11) DEFAULT NULL,
  `fCashFlow` int(11) DEFAULT NULL,
  `ingNetoOpCont` int(11) DEFAULT NULL,
  `ingNetoOpDiscont` int(11) DEFAULT NULL,
  `periodo` int(11) DEFAULT NULL,
  `idEmpresa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.balance: ~71 rows (aproximadamente)
/*!40000 ALTER TABLE `balance` DISABLE KEYS */;
INSERT INTO `balance` (`id`, `deuda`, `capitalPropio`, `ebitda`, `fds`, `fCashFlow`, `ingNetoOpCont`, `ingNetoOpDiscont`, `periodo`, `idEmpresa`) VALUES
	(1, 15, 50000, 44591, 0, 955, 2221, 1051, 2006, 1),
	(2, 12, 30000, 77691, 0, 1096, 3221, 1221, 2007, 1),
	(3, 14, 70000, 85291, 1, 1198, 4568, 2112, 2008, 1),
	(4, 13, 80000, 79463, 2, 1234, 2789, 987, 2009, 1),
	(5, 12, 40000, 74961, 3, 1078, 2034, 1001, 2010, 1),
	(6, 11, 90000, 86431, 4, 2468, 3214, 859, 2011, 1),
	(7, 10, 150000, 86431, 4, 3468, 3214, 859, 2012, 1),
	(8, 9, 250000, 88888, 5, 4468, 3214, 1859, 2013, 1),
	(9, 8, 550000, 89765, 6, 2468, 3214, 859, 2014, 1),
	(10, 11, 5450000, 86431, 5, 2468, 3214, 859, 2015, 1),
	(11, 11, 850000, 91234, 5, 2468, 3214, 859, 2016, 1),
	(12, 7, 50000, 12345, 1, 789, 2345, 1234, 2006, 2),
	(13, 6, 50000, 23456, 3, 978, 3456, 2123, 2007, 2),
	(14, 4, 150000, 34567, 5, 1012, 3232, 1331, 2008, 2),
	(15, 7, 250000, 29291, 7, 999, 2929, 778, 2009, 2),
	(16, 5, 52000, 54961, 9, 3078, 4034, 1001, 2010, 2),
	(17, 8, 750000, 66431, 9, 5468, 4114, 1859, 2011, 2),
	(18, 8, 90000, 66531, 9, 5368, 4444, 1759, 2012, 2),
	(19, 6, 60000, 67431, 11, 6468, 4224, 2859, 2013, 2),
	(20, 5, 30000, 66866, 10, 5468, 4114, 1859, 2014, 2),
	(21, 5, 57000, 66866, 12, 5658, 4114, 1859, 2015, 2),
	(22, 4, 70000, 71866, 13, 7468, 5114, 2159, 2016, 2),
	(23, 15, 50000, 44591, 2, 955, 2221, 1051, 2006, 3),
	(24, 12, 50000, 77691, 4, 1096, 3221, 1221, 2007, 3),
	(25, 14, 50000, 85291, 6, 1198, 4568, 2112, 2008, 3),
	(26, 13, 50000, 79463, 5, 1234, 2789, 987, 2009, 3),
	(27, 12, 50000, 74961, 6, 1078, 2034, 1001, 2010, 3),
	(28, 14, 50000, 85291, 7, 2298, 4568, 2112, 2011, 3),
	(29, 11, 50000, 79463, 8, 2934, 2789, 987, 2012, 3),
	(30, 12, 50000, 74961, 6, 2078, 2034, 1001, 2013, 3),
	(31, 10, 250000, 86444, 7, 3468, 2299, 859, 2014, 3),
	(32, 9, 150000, 79555, 8, 2934, 2789, 987, 2015, 3),
	(33, 7, 850000, 74961, 9, 3078, 2034, 1001, 2016, 3),
	(34, 18, 50000, 33333, 6, 1234, 979, 435, 2006, 4),
	(35, 15, 20000, 44444, 7, 2222, 1728, 924, 2007, 4),
	(36, 11, 850000, 55555, 8, 1198, 4568, 2112, 2008, 4),
	(37, 9, 750000, 66666, 8, 3333, 2345, 1234, 2009, 4),
	(38, 8, 10000, 69696, 10, 3939, 2929, 1231, 2010, 4),
	(39, 4, 650000, 77777, 14, 6545, 3434, 1234, 2011, 4),
	(40, 5, 750000, 64444, 12, 5222, 4728, 1984, 2012, 4),
	(41, 7, 850000, 55555, 10, 3198, 4568, 2112, 2013, 4),
	(42, 8, 780000, 46666, 9, 3333, 2345, 1234, 2014, 4),
	(43, 6, 50007, 79696, 10, 4939, 3929, 1231, 2015, 4),
	(44, 4, 80000, 79977, 11, 6545, 5454, 1234, 2016, 4),
	(45, 2, 70000, 55555, 11, 1000, 1500, 500, 2006, 5),
	(46, 1, 50000, 66766, 12, 2000, 1800, 700, 2007, 5),
	(47, 2, 505000, 77677, 13, 4000, 2568, 2112, 2008, 5),
	(48, 3, 570000, 79463, 12, 3333, 2222, 999, 2009, 5),
	(49, 2, 40000, 74961, 9, 1111, 2024, 1221, 2010, 5),
	(50, 2, 7750000, 72723, 10, 3453, 1212, 859, 2011, 5),
	(51, 3, 7850000, 77877, 14, 4478, 3214, 1359, 2012, 5),
	(52, 3, 150000, 88888, 12, 4949, 2999, 1798, 2013, 5),
	(53, 2, 70000, 89777, 13, 5468, 3214, 1478, 2014, 5),
	(54, 1, 50007, 90431, 13, 5566, 4334, 1150, 2015, 5),
	(55, 1, 5008, 91234, 14, 5968, 5959, 1010, 2016, 5),
	(56, 2, 50000, 55555, 11, 1000, 1500, 500, 2006, 6),
	(57, 1, 50000, 66766, 12, 2000, 1800, 700, 2007, 6),
	(58, 2, 50000, 77677, 13, 4000, 2568, 2112, 2008, 6),
	(59, 3, 50000, 79463, 12, 3333, 2222, 999, 2009, 6),
	(60, 2, 50000, 74961, 9, 1111, 2024, 1221, 2010, 6),
	(61, 2, 50000, 72723, 10, 3453, 1212, 859, 2011, 6),
	(62, 3, 50000, 77877, 14, 4478, 3214, 1359, 2012, 6),
	(63, 3, 50000, 88888, 12, 4949, 2999, 1798, 2013, 6),
	(64, 2, 50000, 89777, 13, 5468, 3214, 1478, 2014, 6),
	(65, 1, 50000, 90431, 13, 5566, 4334, 1150, 2015, 6),
	(66, 1, 50000, 91234, 14, 5968, 5959, 1010, 2016, 6),
	(67, 18, 60000, 986, 0, 78, 158, 25, 2012, 7),
	(68, 15, 60000, 2113, 0, 135, 200, 46, 2013, 7),
	(69, 15, 60000, 3729, 0, 1597, 456, 89, 2014, 7),
	(70, 11, 60000, 10463, 0, 3456, 1346, 498, 2015, 7),
	(71, 9, 60000, 24961, 0, 6543, 4321, 1643, 2016, 7);
/*!40000 ALTER TABLE `balance` ENABLE KEYS */;

-- Volcando estructura para tabla db.condicionesfiltro
CREATE TABLE IF NOT EXISTS `condicionesfiltro` (
  `idMetodologia` bigint(20) NOT NULL,
  `condicionFiltro` varchar(255) DEFAULT NULL
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
  `condicionOrden` varchar(255) DEFAULT NULL
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
  `finalIntervalo` int(11) NOT NULL,
  `idMetodologia` bigint(20) NOT NULL,
  `inicioIntervalo` int(11) NOT NULL,
  `nombreCondicion` varchar(255) DEFAULT NULL,
  `nombreIndicador` varchar(255) DEFAULT NULL,
  `periodo` int(11) NOT NULL,
  `comparador` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.condicion_filtro: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `condicion_filtro` DISABLE KEYS */;
INSERT INTO `condicion_filtro` (`tipo`, `id`, `finalIntervalo`, `idMetodologia`, `inicioIntervalo`, `nombreCondicion`, `nombreIndicador`, `periodo`, `comparador`) VALUES
	('ConsistenciaCreciente', 1, 2016, 0, 2007, 'Consistencia Creciente', 'ROE', 0, 0),
	('ConsistenciaCreciente', 2, 2016, 0, 2007, 'Margenes crecientes', 'Margen', 0, 0),
	('FiltroMayor', 3, 0, 0, 0, 'Longevidad', 'Longevidad', 2014, 10),
	('ConsistenciaCreciente', 4, 2016, 0, 2007, 'Consistencia Creciente', 'ROE', 0, 0),
	('ConsistenciaCreciente', 5, 2016, 0, 2007, 'Margenes crecientes', 'Margen', 0, 0),
	('FiltroMayor', 6, 0, 0, 0, 'Longevidad', 'Longevidad', 2014, 10);
/*!40000 ALTER TABLE `condicion_filtro` ENABLE KEYS */;

-- Volcando estructura para tabla db.condicion_orden
CREATE TABLE IF NOT EXISTS `condicion_orden` (
  `tipo` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `finalIntervalo` int(11) NOT NULL,
  `idMetodologia` bigint(20) NOT NULL,
  `inicioIntervalo` int(11) NOT NULL,
  `nombreCondicion` varchar(255) DEFAULT NULL,
  `nombreIndicador` varchar(255) DEFAULT NULL,
  `periodo` int(11) NOT NULL,
  `importancia` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.condicion_orden: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `condicion_orden` DISABLE KEYS */;
INSERT INTO `condicion_orden` (`tipo`, `id`, `finalIntervalo`, `idMetodologia`, `inicioIntervalo`, `nombreCondicion`, `nombreIndicador`, `periodo`, `importancia`) VALUES
	('Maximizar', 1, 2016, 0, 2007, 'Maximizar ROE', 'ROE', 0, 1),
	('Minimizar', 2, 2016, 0, 2007, 'Minimizar proporcion de deuda', 'proporcionDeuda', 0, 1),
	('OrdenMayor', 3, 0, 0, 0, 'Longevidad', 'Longevidad', 2007, 1),
	('Maximizar', 4, 2016, 0, 2007, 'Maximizar ROE', 'ROE', 0, 1),
	('Minimizar', 5, 2016, 0, 2007, 'Minimizar proporcion de deuda', 'proporcionDeuda', 0, 1),
	('OrdenMayor', 6, 0, 0, 0, 'Longevidad', 'Longevidad', 2007, 1);
/*!40000 ALTER TABLE `condicion_orden` ENABLE KEYS */;

-- Volcando estructura para tabla db.empresa
CREATE TABLE IF NOT EXISTS `empresa` (
  `id` int(11) DEFAULT NULL,
  `inicioActividad` int(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `rentabilidad` int(11) DEFAULT NULL
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
  `id` bigint(20) DEFAULT NULL,
  `idIndicador` varchar(50) DEFAULT NULL,
  `formula` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.indicador: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `indicador` DISABLE KEYS */;
INSERT INTO `indicador` (`id`, `idIndicador`, `formula`) VALUES
	(1, 'ingresoNeto', 'ingNetoOpCont + ingNetoOpDiscont'),
	(2, 'ROE', 'ingresoNeto / capitalPropio'),
	(3, 'proporcionDeuda', 'deuda/capitalPropio'),
	(4, 'Margen', 'ingresoNeto'),
	(5, 'Longevidad', '2017-inicioActividad'),
	(6, 'ROE', '4+4+4'),
	(7, 'ROE', '4+4+4');
/*!40000 ALTER TABLE `indicador` ENABLE KEYS */;

-- Volcando estructura para tabla db.metodologia
CREATE TABLE IF NOT EXISTS `metodologia` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla db.metodologia: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `metodologia` DISABLE KEYS */;
INSERT INTO `metodologia` (`id`, `nombre`) VALUES
	(1, 'Warren Buffett');
/*!40000 ALTER TABLE `metodologia` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
