-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-10-2023 a las 18:22:26
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `triviagm`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `appcoins`
--

CREATE TABLE `appcoins` (
  `id_monedas` int(11) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `precio` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombre_completo` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `dni` int(12) NOT NULL,
  `telefono` int(20) NOT NULL,
  `nickname` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compatibilidad`
--

CREATE TABLE `compatibilidad` (
  `juego` int(11) DEFAULT NULL,
  `dispositivo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprar`
--

CREATE TABLE `comprar` (
  `id_comprar` int(11) NOT NULL,
  `monto_total` decimal(10,2) DEFAULT NULL,
  `cantidad_pedido` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `monedas` int(11) NOT NULL,
  `id_trivia` int(11) NOT NULL,
  `numero_factura` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dispositivos`
--

CREATE TABLE `dispositivos` (
  `id_dispositivos` int(11) NOT NULL,
  `pc` varchar(15) DEFAULT NULL,
  `version_celular` varchar(15) DEFAULT NULL,
  `nintendo_switch` varchar(10) DEFAULT NULL,
  `version_playstation` varchar(10) DEFAULT NULL,
  `version_xbox` varchar(10) DEFAULT NULL,
  `usuario` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturacion`
--

CREATE TABLE `facturacion` (
  `numero_factura` int(11) NOT NULL,
  `metodo_pago` varchar(20) NOT NULL,
  `fecha_factura` date NOT NULL,
  `fecha_pago` date NOT NULL,
  `monto_total` decimal(6,2) NOT NULL,
  `estado_pago` varchar(20) DEFAULT NULL,
  `id_comprar` int(11) NOT NULL,
  `usuario` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `galeria`
--

CREATE TABLE `galeria` (
  `id_galeria` int(11) NOT NULL,
  `nombre_foto` varchar(25) DEFAULT NULL,
  `foto` varchar(50) DEFAULT NULL,
  `jugador` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegos`
--

CREATE TABLE `juegos` (
  `id_juego` int(11) NOT NULL,
  `juego` varchar(30) NOT NULL,
  `imagen` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugar`
--

CREATE TABLE `jugar` (
  `nivel_jugador` varchar(15) NOT NULL,
  `usuario` varchar(15) DEFAULT NULL,
  `juego` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `redes`
--

CREATE TABLE `redes` (
  `id_redes` int(11) NOT NULL,
  `instagram` varchar(100) DEFAULT NULL,
  `youtube` varchar(100) DEFAULT NULL,
  `tik_tok` varchar(100) DEFAULT NULL,
  `twitter` varchar(100) DEFAULT NULL,
  `twitch` varchar(100) DEFAULT NULL,
  `discord` varchar(100) DEFAULT NULL,
  `usuario` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trivia`
--

CREATE TABLE `trivia` (
  `id_trivia` int(11) NOT NULL,
  `puntaje` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cantidad_monedas` int(11) NOT NULL,
  `puesto` int(11) NOT NULL,
  `usuario` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nickname` varchar(15) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `fecha_nac` date NOT NULL,
  `provincia` varchar(15) NOT NULL,
  `disp_horaria` varchar(6) NOT NULL,
  `email` varchar(25) NOT NULL,
  `contraseña` varchar(10) NOT NULL,
  `imagen_perfil` varchar(50) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `appcoins`
--
ALTER TABLE `appcoins`
  ADD PRIMARY KEY (`id_monedas`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD KEY `fk_cliente_usuario` (`nickname`);

--
-- Indices de la tabla `compatibilidad`
--
ALTER TABLE `compatibilidad`
  ADD KEY `fk_compatibilidad_juego` (`juego`),
  ADD KEY `fk_compatibilidad_dispositivo` (`dispositivo`);

--
-- Indices de la tabla `comprar`
--
ALTER TABLE `comprar`
  ADD PRIMARY KEY (`id_comprar`),
  ADD KEY `monedas` (`monedas`),
  ADD KEY `id_trivia` (`id_trivia`),
  ADD KEY `numero_factura` (`numero_factura`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `dispositivos`
--
ALTER TABLE `dispositivos`
  ADD PRIMARY KEY (`id_dispositivos`),
  ADD KEY `fk_dispositivos_usuario` (`usuario`);

--
-- Indices de la tabla `facturacion`
--
ALTER TABLE `facturacion`
  ADD PRIMARY KEY (`numero_factura`),
  ADD KEY `fk_facturacion_usuario` (`usuario`),
  ADD KEY `fk_facturacion_comprar` (`id_comprar`);

--
-- Indices de la tabla `galeria`
--
ALTER TABLE `galeria`
  ADD PRIMARY KEY (`id_galeria`),
  ADD KEY `fk_galeria_usuario` (`jugador`);

--
-- Indices de la tabla `juegos`
--
ALTER TABLE `juegos`
  ADD PRIMARY KEY (`id_juego`);

--
-- Indices de la tabla `jugar`
--
ALTER TABLE `jugar`
  ADD KEY `fk_jugar_juego` (`juego`),
  ADD KEY `fk_jugar_usuario` (`usuario`);

--
-- Indices de la tabla `redes`
--
ALTER TABLE `redes`
  ADD PRIMARY KEY (`id_redes`),
  ADD KEY `fk_redes_usuario` (`usuario`);

--
-- Indices de la tabla `trivia`
--
ALTER TABLE `trivia`
  ADD PRIMARY KEY (`id_trivia`),
  ADD KEY `usuario` (`usuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`nickname`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_usuario` FOREIGN KEY (`nickname`) REFERENCES `usuarios` (`nickname`);

--
-- Filtros para la tabla `compatibilidad`
--
ALTER TABLE `compatibilidad`
  ADD CONSTRAINT `fk_compatibilidad_dispositivo` FOREIGN KEY (`dispositivo`) REFERENCES `dispositivos` (`id_dispositivos`),
  ADD CONSTRAINT `fk_compatibilidad_juego` FOREIGN KEY (`juego`) REFERENCES `juegos` (`id_juego`);

--
-- Filtros para la tabla `comprar`
--
ALTER TABLE `comprar`
  ADD CONSTRAINT `comprar_ibfk_1` FOREIGN KEY (`monedas`) REFERENCES `appcoins` (`id_monedas`),
  ADD CONSTRAINT `comprar_ibfk_2` FOREIGN KEY (`id_trivia`) REFERENCES `trivia` (`id_trivia`),
  ADD CONSTRAINT `comprar_ibfk_3` FOREIGN KEY (`numero_factura`) REFERENCES `facturacion` (`numero_factura`),
  ADD CONSTRAINT `comprar_ibfk_4` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Filtros para la tabla `dispositivos`
--
ALTER TABLE `dispositivos`
  ADD CONSTRAINT `fk_dispositivos_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`nickname`);

--
-- Filtros para la tabla `facturacion`
--
ALTER TABLE `facturacion`
  ADD CONSTRAINT `fk_facturacion_comprar` FOREIGN KEY (`id_comprar`) REFERENCES `comprar` (`id_comprar`),
  ADD CONSTRAINT `fk_facturacion_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`nickname`);

--
-- Filtros para la tabla `galeria`
--
ALTER TABLE `galeria`
  ADD CONSTRAINT `fk_galeria_jugador` FOREIGN KEY (`jugador`) REFERENCES `usuarios` (`nickname`),
  ADD CONSTRAINT `fk_galeria_usuario` FOREIGN KEY (`jugador`) REFERENCES `usuarios` (`nickname`);

--
-- Filtros para la tabla `jugar`
--
ALTER TABLE `jugar`
  ADD CONSTRAINT `fk_jugar_juego` FOREIGN KEY (`juego`) REFERENCES `juegos` (`id_juego`),
  ADD CONSTRAINT `fk_jugar_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`nickname`);

--
-- Filtros para la tabla `redes`
--
ALTER TABLE `redes`
  ADD CONSTRAINT `fk_redes_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`nickname`);

--
-- Filtros para la tabla `trivia`
--
ALTER TABLE `trivia`
  ADD CONSTRAINT `trivia_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`nickname`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
