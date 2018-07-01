-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 02-Jul-2018 às 00:43
-- Versão do servidor: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel_estada_feliz`
--
CREATE DATABASE IF NOT EXISTS `hotel_estada_feliz` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `hotel_estada_feliz`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `dataCriacao` varchar(60) NOT NULL,
  PRIMARY KEY (`id_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `consumo`
--

CREATE TABLE IF NOT EXISTS `consumo` (
  `id_hospedagem` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`id_hospedagem`,`id_produto`),
  KEY `id_produto` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `hospedagem`
--

CREATE TABLE IF NOT EXISTS `hospedagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `checkIn` datetime NOT NULL,
  `checkOut` datetime NOT NULL,
  `dataHorarioInicio` datetime NOT NULL,
  `dataHorarioFim` datetime NOT NULL,
  `preco` float NOT NULL,
  `status` enum('1','2','3') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `hotel`
--

CREATE TABLE IF NOT EXISTS `hotel` (
  `id` int(11) DEFAULT NULL,
  `nome` varchar(120) NOT NULL,
  `endereco` int(180) NOT NULL,
  `cnpj` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(20) NOT NULL,
  `telefone` varchar(120) NOT NULL,
  `endereco` varchar(120) NOT NULL,
  `nome` varchar(180) NOT NULL,
  `email` varchar(120) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `cpf`, `telefone`, `endereco`, `nome`, `email`) VALUES
(1, '443.815.068.04', '989878778', 'avenida', 'Mariana', 'mariana@mariana'),
(2, '123123', '2345678910', 'rua', 'Denis', 'denis@denis');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(120) NOT NULL,
  `preco` float NOT NULL,
  `descricao` varchar(180) NOT NULL,
  `status` enum('1','2','3') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `proprietario`
--

CREATE TABLE IF NOT EXISTS `proprietario` (
  `id_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `senha` varchar(20) NOT NULL,
  `salario` decimal(7,2) NOT NULL,
  PRIMARY KEY (`id_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `proprietario`
--

INSERT INTO `proprietario` (`id_pessoa`, `senha`, `salario`) VALUES
(1, '123', '1000.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `quarto`
--

CREATE TABLE IF NOT EXISTS `quarto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` enum('1','2') NOT NULL,
  `numero` int(11) NOT NULL,
  `preco` int(11) NOT NULL,
  `descricao` varchar(180) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `recepcionista`
--

CREATE TABLE IF NOT EXISTS `recepcionista` (
  `id_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `senha` varchar(20) NOT NULL,
  `salario` decimal(7,2) NOT NULL,
  PRIMARY KEY (`id_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `recepcionista`
--

INSERT INTO `recepcionista` (`id_pessoa`, `senha`, `salario`) VALUES
(2, '123', '1000.00');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `consumo`
--
ALTER TABLE `consumo`
  ADD CONSTRAINT `consumo_ibfk_1` FOREIGN KEY (`id_hospedagem`) REFERENCES `hospedagem` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `consumo_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `proprietario`
--
ALTER TABLE `proprietario`
  ADD CONSTRAINT `proprietario_ibfk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `recepcionista`
--
ALTER TABLE `recepcionista`
  ADD CONSTRAINT `recepcionista_ibfk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
