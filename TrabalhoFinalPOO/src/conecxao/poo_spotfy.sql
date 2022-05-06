-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geraÃ§Ã£o: 05-Maio-2022 Ã s 14:54
-- VersÃ£o do servidor: 10.4.17-MariaDB
-- versÃ£o do PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `poo_spotify`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `albun`
--

CREATE TABLE `albun` (
  `idalbun` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `idartista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `artista`
--

CREATE TABLE `artista` (
  `idartista` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `generoprincipal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `musica`
--

CREATE TABLE `musica` (
  `idmusica` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `caminho` varchar(200) NOT NULL,
  `idartista` int(11) NOT NULL,
  `idalbun` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `playlist`
--

CREATE TABLE `playlist` (
  `idplaylist` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `idusuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `playlist_musica`
--

CREATE TABLE `playlist_musica` (
  `idplaylist` int(11) NOT NULL,
  `idmusica` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(200) NOT NULL,
  `permissao` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Ãndices para tabelas despejadas
--

--
-- Ãndices para tabela `albun`
--
ALTER TABLE `albun`
  ADD PRIMARY KEY (`idalbun`),
  ADD KEY `idartista` (`idartista`);

--
-- Ãndices para tabela `artista`
--
ALTER TABLE `artista`
  ADD PRIMARY KEY (`idartista`);

--
-- Ãndices para tabela `musica`
--
ALTER TABLE `musica`
  ADD PRIMARY KEY (`idmusica`),
  ADD KEY `fk_artista` (`idartista`),
  ADD KEY `fk_album` (`idalbun`);

--
-- Ãndices para tabela `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`idplaylist`),
  ADD KEY `fk_playlist_idusuario` (`idusuario`);

--
-- Ãndices para tabela `playlist_musica`
--
ALTER TABLE `playlist_musica`
  ADD KEY `fk_playlist` (`idplaylist`);

--
-- Ãndices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `albun`
--
ALTER TABLE `albun`
  MODIFY `idalbun` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `artista`
--
ALTER TABLE `artista`
  MODIFY `idartista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `musica`
--
ALTER TABLE `musica`
  MODIFY `idmusica` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `playlist`
--
ALTER TABLE `playlist`
  MODIFY `idplaylist` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- RestriÃ§Ãµes para despejos de tabelas
--

--
-- Limitadores para a tabela `albun`
--
ALTER TABLE `albun`
  ADD CONSTRAINT `idartista` FOREIGN KEY (`idartista`) REFERENCES `artista` (`idartista`);

--
-- Limitadores para a tabela `musica`
--
ALTER TABLE `musica`
  ADD CONSTRAINT `fk_album` FOREIGN KEY (`idalbun`) REFERENCES `albun` (`idalbun`),
  ADD CONSTRAINT `fk_artista` FOREIGN KEY (`idartista`) REFERENCES `artista` (`idartista`);

--
-- Limitadores para a tabela `playlist`
--
ALTER TABLE `playlist`
  ADD CONSTRAINT `fk_playlist_idusuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`);

--
-- Limitadores para a tabela `playlist_musica`
--
ALTER TABLE `playlist_musica`
  ADD CONSTRAINT `fk_musica` FOREIGN KEY (`idmusica`) REFERENCES `musica` (`idmusica`),
  ADD CONSTRAINT `fk_playlist` FOREIGN KEY (`idplaylist`) REFERENCES `playlist` (`idplaylist`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
