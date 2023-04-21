-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-04-2023 a las 13:36:52
-- Versión del servidor: 5.7.36
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `championsimulator`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arsenal`
--

DROP TABLE IF EXISTS `arsenal`;
CREATE TABLE IF NOT EXISTS `arsenal` (
  `ars_id` int(2) NOT NULL,
  `ars_jugador` varchar(20) NOT NULL,
  `ars_posicion` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `barcelona`
--

DROP TABLE IF EXISTS `barcelona`;
CREATE TABLE IF NOT EXISTS `barcelona` (
  `bar_id` int(2) NOT NULL,
  `bar_jugador` varchar(20) NOT NULL,
  `bar_posicion` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bayern`
--

DROP TABLE IF EXISTS `bayern`;
CREATE TABLE IF NOT EXISTS `bayern` (
  `bay_id` int(11) NOT NULL,
  `bay_jugador` varchar(20) NOT NULL,
  `bay_posicion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `betis`
--

DROP TABLE IF EXISTS `betis`;
CREATE TABLE IF NOT EXISTS `betis` (
  `bet_id` int(2) NOT NULL,
  `bet:jugador` varchar(20) NOT NULL,
  `bet_posicion` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

DROP TABLE IF EXISTS `equipos`;
CREATE TABLE IF NOT EXISTS `equipos` (
  `eq_id` int(2) NOT NULL,
  `eq_nombre` varchar(20) NOT NULL,
  `eq_victorias` int(2) NOT NULL,
  `eq_derrotas` int(2) NOT NULL,
  `eq_goles` int(3) NOT NULL,
  `eq_goles_contra` int(3) NOT NULL,
  `eq_goles_dif` int(3) NOT NULL,
  `eq_estrellas` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`eq_id`, `eq_nombre`, `eq_victorias`, `eq_derrotas`, `eq_goles`, `eq_goles_contra`, `eq_goles_dif`, `eq_estrellas`) VALUES
(1, 'Real Madrid', 0, 0, 0, 0, 0, 5),
(2, 'Barcelona', 0, 0, 0, 0, 0, 4),
(3, 'Real Betis', 0, 0, 0, 0, 0, 3),
(4, 'Arsenal', 0, 0, 0, 0, 0, 4),
(5, 'Lazio', 0, 0, 0, 0, 0, 4),
(6, 'Bayern Munich', 0, 0, 0, 0, 0, 5),
(7, 'Sporting de Gijon', 0, 0, 0, 0, 0, 3),
(8, 'Inter de Milan', 0, 0, 0, 0, 0, 4),
(9, 'Manchester City', 0, 0, 0, 0, 0, 5),
(10, 'PSG', 0, 0, 0, 0, 0, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inter`
--

DROP TABLE IF EXISTS `inter`;
CREATE TABLE IF NOT EXISTS `inter` (
  `int_id` int(11) NOT NULL,
  `int_jugador` varchar(20) NOT NULL,
  `int_posicion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lazio`
--

DROP TABLE IF EXISTS `lazio`;
CREATE TABLE IF NOT EXISTS `lazio` (
  `laz_id` int(11) NOT NULL,
  `laz_jugador` varchar(20) NOT NULL,
  `laz_posicion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `madrid`
--

DROP TABLE IF EXISTS `madrid`;
CREATE TABLE IF NOT EXISTS `madrid` (
  `mad_id` int(2) NOT NULL,
  `mad_jugador` varchar(20) NOT NULL,
  `mad_posicion` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `manchestercity`
--

DROP TABLE IF EXISTS `manchestercity`;
CREATE TABLE IF NOT EXISTS `manchestercity` (
  `manc_id` int(11) NOT NULL,
  `manc_jugador` int(11) NOT NULL,
  `manc_posicion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `psg`
--

DROP TABLE IF EXISTS `psg`;
CREATE TABLE IF NOT EXISTS `psg` (
  `psg_id` int(2) NOT NULL,
  `psg_jugador` varchar(20) NOT NULL,
  `psg_posición` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sporting`
--

DROP TABLE IF EXISTS `sporting`;
CREATE TABLE IF NOT EXISTS `sporting` (
  `spor_id` int(11) NOT NULL,
  `spor_jugador` varchar(20) NOT NULL,
  `spor_posicion` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
