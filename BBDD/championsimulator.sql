-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-05-2023 a las 00:17:10
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

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

CREATE TABLE `arsenal` (
  `ars_id` int(2) NOT NULL,
  `ars_jugador` varchar(20) NOT NULL,
  `ars_posicion` varchar(20) NOT NULL,
  `Titular` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `arsenal`
--

INSERT INTO `arsenal` (`ars_id`, `ars_jugador`, `ars_posicion`, `Titular`) VALUES
(1, 'Aaron Ramsdale', 'Portero', 0),
(2, 'Gabriel Magalhaes', 'Defensa', 0),
(3, 'Ben White', 'Defensa', 0),
(4, 'Thomas Partey', 'Centro', 0),
(5, 'Kieran Tierney', 'Lateral Izquierdo', 0),
(6, 'Takehiro Tomiyasu', 'Lateral Derecho', 0),
(7, 'Granit Xhaka', 'Centro', 0),
(8, 'Martin Odegaard', 'Centro', 0),
(9, 'Gabriel Martinelli', 'Extremo Izquierdo', 0),
(10, 'Bukayo Saka', 'Extremo Izquierdo', 0),
(11, 'Gabriel Jesus', 'Delantero', 0),
(12, 'Matt Turner', 'Portero', 0),
(13, 'Jakub Kiwior', 'Defensa', 0),
(14, 'Emilie Smith Rowe', 'Centro', 0),
(15, 'Eddie Nketiah', 'Delantero', 0),
(16, 'Cédric', 'Lateral Derecho', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `barcelona`
--

CREATE TABLE `barcelona` (
  `bar_id` int(2) NOT NULL,
  `bar_jugador` varchar(20) NOT NULL,
  `bar_posicion` varchar(20) NOT NULL,
  `Titular` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `barcelona`
--

INSERT INTO `barcelona` (`bar_id`, `bar_jugador`, `bar_posicion`, `Titular`) VALUES
(1, 'Ter Stegen', 'Portero', 0),
(2, 'Eric Garcia', 'Defensa', 0),
(3, 'Araujo', 'Defensa', 0),
(4, 'Jordi Alba', 'Lateral Izquierdo', 0),
(5, 'Kounde', 'Lateral Derecho', 0),
(6, 'Busquets', 'Centro', 0),
(7, 'Pedri', 'Centro', 0),
(8, 'Gavi', 'Centro', 0),
(9, 'Dembele', 'Extremo Derecho', 0),
(10, 'Ansu Fati', 'Extremo Izquierdo', 0),
(11, 'Lewandoski', 'Delantero', 0),
(12, 'Iñaki Peña', 'Portero', 0),
(13, 'Kounde', 'Defensa', 0),
(14, 'Nico', 'Centro', 0),
(15, 'Raphinha', 'Extremo Derecho', 0),
(16, 'Balde', 'Lateral Izquierdo', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bayern`
--

CREATE TABLE `bayern` (
  `bay_id` int(11) NOT NULL,
  `bay_jugador` varchar(20) NOT NULL,
  `bay_posicion` varchar(20) NOT NULL,
  `Titular` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bayern`
--

INSERT INTO `bayern` (`bay_id`, `bay_jugador`, `bay_posicion`, `Titular`) VALUES
(1, 'Neuer', 'Portero', 0),
(2, 'Sule', 'Defensa', 0),
(3, 'Lucas H', 'Defensa', 0),
(4, 'Emerson', 'Extremo Izquierdo', 0),
(5, 'Alaba', 'Extremo Derecho', 0),
(6, 'Kimmich', 'Centro', 0),
(7, 'Thiago', 'Centro', 0),
(8, 'Muller', 'Centro', 0),
(9, 'Sane', 'Lateral Derecho', 0),
(10, 'Gnabry', 'Lateral Izquierdo', 0),
(11, 'Lewandowski', 'Delantero', 0),
(12, 'Nubel', 'Portero', 0),
(13, 'Martinez', 'Defensa', 0),
(14, 'Tolisso', 'Centro', 0),
(15, 'Davies', 'Extremo Derecho', 0),
(16, 'Singh', 'Lateral Izquierdo', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `betis`
--

CREATE TABLE `betis` (
  `bet_id` int(2) NOT NULL,
  `bet_jugador` varchar(20) NOT NULL,
  `bet_posicion` varchar(20) NOT NULL,
  `Titular` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `betis`
--

INSERT INTO `betis` (`bet_id`, `bet_jugador`, `bet_posicion`, `Titular`) VALUES
(1, 'Bravo', 'Portero', 0),
(2, 'Bartra', 'Defensa', 0),
(3, 'Mandi', 'Defensa', 0),
(4, 'Alex Moreno', 'Extremo Izquierdo', 0),
(5, 'Emerson', 'Extremo Derecho', 0),
(6, 'Guido Rodriguez', 'Centro', 0),
(7, 'Carvalho', 'Centro', 0),
(8, 'Canales', 'Centro', 0),
(9, 'Joaquín', 'Lateral Derecho', 0),
(10, 'Fekir', 'Lateral Izquierdo', 0),
(11, 'Borja Iglesias', 'Delantero', 0),
(12, 'Joel Robles', 'Portero', 0),
(13, 'Victor Ruiz', 'Defensa', 0),
(14, 'Paul', 'Centro', 0),
(15, 'Montoya', 'Extremo Derecho', 0),
(16, 'Juanmmi', 'Lateral Izquierdo', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfrentamientos`
--

CREATE TABLE `enfrentamientos` (
  `Local` varchar(50) NOT NULL,
  `Visitante` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `enfrentamientos`
--

INSERT INTO `enfrentamientos` (`Local`, `Visitante`) VALUES
('madrid', 'barcelona'),
('lazio', 'betis'),
('bayern', 'manchestercity'),
('sporting', 'barcelona'),
('sporting', 'inter'),
('psg', 'arsenal'),
('madrid', 'betis'),
('barcelona', 'manchestercity'),
('lazio', 'inter'),
('bayern', 'arsenal'),
('sporting', 'psg'),
('madrid', 'manchestercity'),
('betis', 'inter'),
('barcelona', 'arsenal'),
('lazio', 'psg'),
('bayern', 'sporting'),
('madrid', 'inter'),
('manchestercity', 'arsenal'),
('betis', 'psg'),
('barcelona', 'sporting'),
('lazio', 'bayern'),
('madrid', 'arsenal'),
('inter', 'arsenal'),
('manchestercity', 'sporting'),
('betis', 'bayern'),
('barcelona', 'lazio'),
('madrid', 'psg'),
('arsenal', 'sporting'),
('inter', 'bayern'),
('manchestercity', 'lazio'),
('betis', 'barcelona'),
('madrid', 'sporting'),
('psg', 'bayern'),
('arsenal', 'lazio'),
('inter', 'barcelona'),
('manchestercity', 'betis'),
('madrid', 'bayern'),
('sporting', 'lazio'),
('psg', 'barcelona'),
('arsenal', 'betis'),
('inter', 'manchestercity'),
('madrid', 'lazio'),
('bayern', 'barcelona'),
('sporting', 'betis'),
('psg', 'manchestercity'),
('arsenal', 'inter');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `eq_id` int(2) NOT NULL,
  `eq_nombre` varchar(20) NOT NULL,
  `eq_victorias` int(2) NOT NULL,
  `eq_derrotas` int(2) NOT NULL,
  `eq_goles` int(3) NOT NULL,
  `eq_goles_contra` int(3) NOT NULL,
  `eq_goles_dif` int(3) NOT NULL,
  `eq_estrellas` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

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

CREATE TABLE `inter` (
  `int_id` int(11) NOT NULL,
  `int_jugador` varchar(20) NOT NULL,
  `int_posicion` varchar(20) NOT NULL,
  `Titular` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inter`
--

INSERT INTO `inter` (`int_id`, `int_jugador`, `int_posicion`, `Titular`) VALUES
(1, 'Handanovic', 'Portero', 0),
(2, 'De Vrij', 'Defensa', 0),
(3, 'Bastoni', 'Defensa', 0),
(4, 'Skriniar', 'Lateral Izquierdo', 0),
(5, 'Gosens', 'Lateral Derecho', 0),
(6, 'Brozovic', 'Centro', 0),
(7, 'Barella', 'Centro', 0),
(8, 'Calhanoglu', 'Centro', 0),
(9, 'Dumfries', 'Extremo Derecho', 0),
(10, 'Lukaku', 'Extremo Izquierdo', 0),
(11, 'Lautaro', 'Delantero', 0),
(12, 'Radu', 'Portero', 0),
(13, 'Pirola', 'Defensa', 0),
(14, 'Sensi', 'Centro', 0),
(15, 'Candreva', 'Extremo Derecho', 0),
(16, 'Young', 'Lateral Izquierdo', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lazio`
--

CREATE TABLE `lazio` (
  `laz_id` int(11) NOT NULL,
  `laz_jugador` varchar(20) NOT NULL,
  `laz_posicion` varchar(20) NOT NULL,
  `Titular` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lazio`
--

INSERT INTO `lazio` (`laz_id`, `laz_jugador`, `laz_posicion`, `Titular`) VALUES
(1, 'Gian Marco', 'Portero', 0),
(2, 'Alex Sandro', 'Defensa', 0),
(3, 'Tommaso Barberi', 'Defensa', 0),
(4, 'Enzo Barrenchea', 'Lateral Izquierdo', 0),
(5, 'Samuel Iling', 'Lateral Derecho', 0),
(6, 'Flip Kostic', 'Centro', 0),
(7, 'Leandro Paredes', 'Centro', 0),
(8, 'Paul Pogba', 'Centro', 0),
(9, 'Bremer', 'Extremo Derecho', 0),
(10, 'Danillo', 'Extremo Izquierdo', 0),
(11, 'Federico Chiesia', 'Delantero', 0),
(12, 'Giovanni Garofani', 'Portero', 0),
(13, 'Federico Gatti', 'Defensa', 0),
(14, 'Adrien Rabiot', 'Centro', 0),
(15, 'Daniele Rugani', 'Extremo Derecho', 0),
(16, 'Nikola Sekulov', 'Lateral Izquierdo', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `madrid`
--

CREATE TABLE `madrid` (
  `mad_id` int(2) NOT NULL,
  `mad_jugador` varchar(20) NOT NULL,
  `mad_posicion` varchar(20) NOT NULL,
  `Titular` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `madrid`
--

INSERT INTO `madrid` (`mad_id`, `mad_jugador`, `mad_posicion`, `Titular`) VALUES
(1, 'Courtois', 'Portero', 0),
(2, 'Rudiger', 'Defensa', 0),
(3, 'Militao', 'Defensa', 0),
(4, 'Alaba', 'Lateral Izquierdo', 0),
(5, 'Alaba', 'Extremo Izquierdo', 0),
(6, 'Carvajal', 'Extremo Derecho', 0),
(7, 'Kroos', 'Centro', 0),
(7, 'Modric', 'Lateral Izquierdo', 0),
(8, 'Casemiro', 'Lateral Derecho', 0),
(9, 'Vinicius', 'Lateral Izquierdo', 0),
(10, 'Vinicius', 'Lateral Derecho', 0),
(11, 'Benzema', 'Delantero', 0),
(12, 'Lunin', 'Portero', 0),
(13, 'Nacho', 'Defensa', 0),
(14, 'Camavinga', 'Lateral Izquierdo', 0),
(15, 'Valverde', 'Lateral Derecha', 0),
(16, 'Mayoral', 'Delantero', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `manchestercity`
--

CREATE TABLE `manchestercity` (
  `manc_id` int(11) NOT NULL,
  `manc_jugador` varchar(20) NOT NULL,
  `manc_posicion` varchar(20) NOT NULL,
  `Titular` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `manchestercity`
--

INSERT INTO `manchestercity` (`manc_id`, `manc_jugador`, `manc_posicion`, `Titular`) VALUES
(1, 'Ederson', 'Portero', 0),
(2, 'Dias', 'Defensa', 0),
(3, 'Laporte', 'Defensa', 0),
(4, 'Cancelo', 'Extremo Izquierdo', 0),
(5, 'Cucurella', 'Extremo Derecho', 0),
(6, 'Rodri', 'Centro', 0),
(7, 'Mahrez', 'Centro', 0),
(8, 'Foden', 'Centro', 0),
(9, 'Silva', 'Lateral Derecho', 0),
(10, 'De Bruyne', 'Lateral Izquierdo', 0),
(11, 'Haaland', 'Delantero', 0),
(12, 'Steffen', 'Portero', 0),
(13, 'Gundogan', 'Lateral Izquierdo', 0),
(14, 'Haaland', 'Delantero', 0),
(15, 'Walker', 'Lateral Izquierdo', 0),
(16, 'Haaland', 'Delantero', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidos`
--

CREATE TABLE `partidos` (
  `p_eq1` varchar(100) NOT NULL,
  `p_eq2` varchar(100) NOT NULL,
  `p_jornada` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `partidos`
--

INSERT INTO `partidos` (`p_eq1`, `p_eq2`, `p_jornada`) VALUES
('Real Madrid', 'Barcelona', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `psg`
--

CREATE TABLE `psg` (
  `psg_id` int(2) NOT NULL,
  `psg_jugador` varchar(20) NOT NULL,
  `psg_posicion` varchar(20) NOT NULL,
  `Titular` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `psg`
--

INSERT INTO `psg` (`psg_id`, `psg_jugador`, `psg_posicion`, `Titular`) VALUES
(1, 'Donnaruma', 'Portero', 0),
(2, 'Marquinhos', 'Defensa', 0),
(3, 'Sergio Ramos', 'Lateral Derecho', 0),
(4, 'Kimpembe', 'Lateral Izquierdo', 0),
(5, 'Marco Verratti', 'Centro', 0),
(6, 'Vitinha', 'Centro', 0),
(7, 'Nuno Mendes', 'Extremo Izquierdo', 0),
(8, 'Achraf Hakimi', 'Extremo Derecho', 0),
(9, 'Messi', 'Centro', 0),
(10, 'Neymar', 'Centro', 0),
(11, 'Mbappe', 'Delantero', 0),
(12, 'Keylor Navas', 'Portero', 0),
(13, 'Abdou Diallo', 'Defensa', 0),
(14, 'Biyshiabu', 'Lateral Izquierdo', 0),
(15, 'Carlos Soler', 'Centro', 0),
(16, 'Pablo Sarabia', 'Centro', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sporting`
--

CREATE TABLE `sporting` (
  `spor_id` int(11) NOT NULL,
  `spor_jugador` varchar(20) NOT NULL,
  `spor_posicion` varchar(20) NOT NULL,
  `Titular` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `sporting`
--

INSERT INTO `sporting` (`spor_id`, `spor_jugador`, `spor_posicion`, `Titular`) VALUES
(1, 'Mariño', 'Portero', 0),
(2, 'Insua', 'Defensa', 0),
(3, 'Izquierdoz', 'Defensa', 0),
(4, 'Cote', 'Lateral Izquierdo', 0),
(5, 'Guille Rodas', 'Lateral Derercho', 0),
(6, 'Gragera', 'Centro', 0),
(7, 'Pedro Diaz', 'Centro', 0),
(8, 'Zarfino', 'Centro', 0),
(9, 'Jony', 'Extremo Izquierda', 0),
(10, 'Juan Otero', 'Extremo Derecha', 0),
(11, 'Djuka', 'Delantero', 0),
(12, 'Cuellas', 'Portero', 0),
(13, 'Jordi Pola', 'Defensa', 0),
(14, 'Arguelles', 'Lateral Izquierdo', 0),
(15, 'Fran Villalba', 'Centro', 0),
(16, 'Cristo', 'Delantero', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
