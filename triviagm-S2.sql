CREATE TABLE `follows` (
  `following_user_id` integer,
  `followed_user_id` integer,
  `created_at` timestamp
);

CREATE TABLE `users` (
  `id` integer PRIMARY KEY,
  `username` varchar(255),
  `role` varchar(255),
  `created_at` timestamp
);

CREATE TABLE `posts` (
  `id` integer PRIMARY KEY,
  `title` varchar(255),
  `body` text COMMENT 'Content of the post',
  `user_id` integer,
  `status` varchar(255),
  `created_at` timestamp
);

CREATE TABLE `appcoins` (
  `id_monedas` int(11) PRIMARY KEY NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `precio` decimal(10,2) NOT NULL
);

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombre_completo` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `dni` int(12) NOT NULL,
  `telefono` int(20) NOT NULL,
  `nickname` varchar(15) DEFAULT NULL
);

CREATE TABLE `compatibilidad` (
  `juego` int(11) DEFAULT NULL,
  `dispositivo` int(11) DEFAULT NULL
);

CREATE TABLE `dispositivos` (
  `id_dispositivos` int(11) NOT NULL,
  `pc` varchar(15) DEFAULT NULL,
  `version_celular` varchar(15) DEFAULT NULL,
  `nintendo_switch` varchar(10) DEFAULT NULL,
  `version_playstation` varchar(10) DEFAULT NULL,
  `version_xbox` varchar(10) DEFAULT NULL,
  `usuario` varchar(15) DEFAULT NULL
);

CREATE TABLE `galeria` (
  `id_galeria` int(11) NOT NULL,
  `nombre_foto` varchar(25) DEFAULT NULL,
  `foto` varchar(50) DEFAULT NULL,
  `jugador` varchar(15) DEFAULT NULL
);

CREATE TABLE `juegos` (
  `id_juego` int(11) PRIMARY KEY NOT NULL,
  `juego` varchar(30) NOT NULL,
  `imagen` varchar(100) NOT NULL
);

CREATE TABLE `jugar` (
  `nivel_jugador` varchar(15) NOT NULL,
  `usuario` varchar(15) DEFAULT NULL,
  `juego` int(11) DEFAULT NULL
);

CREATE TABLE `redes` (
  `id_redes` int(11) NOT NULL,
  `instagram` varchar(100) DEFAULT NULL,
  `youtube` varchar(100) DEFAULT NULL,
  `tik_tok` varchar(100) DEFAULT NULL,
  `twitter` varchar(100) DEFAULT NULL,
  `twitch` varchar(100) DEFAULT NULL,
  `discord` varchar(100) DEFAULT NULL,
  `usuario` varchar(15) DEFAULT NULL
);

CREATE TABLE `trivia` (
  `id_trivia` int(11) NOT NULL,
  `puntaje` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cantidad_monedas` int(11) NOT NULL,
  `puesto` int(11) NOT NULL,
  `usuario` varchar(15) DEFAULT NULL
);

CREATE TABLE `usuarios` (
  `nickname` varchar(15) PRIMARY KEY NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `fecha_nac` date NOT NULL,
  `provincia` varchar(15) NOT NULL,
  `disp_horaria` varchar(6) NOT NULL,
  `email` varchar(25) NOT NULL,
  `contraseña` varchar(10) NOT NULL,
  `imagen_perfil` varchar(50) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
);

CREATE TABLE `puntajes` (
  `nickname` varchar(15) PRIMARY KEY NOT NULL,
  `puntaje` int NOT NULL,
  `fecha` date NOT NULL,
  `id_usuario` varchar(255) NOT NULL
);

ALTER TABLE `posts` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `follows` ADD FOREIGN KEY (`following_user_id`) REFERENCES `users` (`id`);

ALTER TABLE `follows` ADD FOREIGN KEY (`followed_user_id`) REFERENCES `users` (`id`);

ALTER TABLE `usuarios` ADD FOREIGN KEY (`nickname`) REFERENCES `puntajes` (`nickname`);

ALTER TABLE `cliente` ADD FOREIGN KEY (`nickname`) REFERENCES `usuarios` (`nickname`);

ALTER TABLE `dispositivos` ADD FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`nickname`);

ALTER TABLE `redes` ADD FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`nickname`);

ALTER TABLE `trivia` ADD FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`nickname`);

ALTER TABLE `usuarios` ADD FOREIGN KEY (`nickname`) REFERENCES `appcoins` (`id_monedas`);

ALTER TABLE `users` ADD FOREIGN KEY (`role`) REFERENCES `cliente` (`id_cliente`);
