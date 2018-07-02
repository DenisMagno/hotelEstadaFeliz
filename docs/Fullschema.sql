-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 02-Jul-2018 às 22:04
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
DROP DATABASE IF EXISTS `hotel_estada_feliz`;
CREATE DATABASE `hotel_estada_feliz` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `hotel_estada_feliz`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `idPessoa` int(11) NOT NULL,
  `dataCriacao` varchar(60) NOT NULL,
  PRIMARY KEY (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idPessoa`, `dataCriacao`) VALUES
(5, '2018/07/02 13:06:55');

-- --------------------------------------------------------

--
-- Estrutura da tabela `consumo`
--

CREATE TABLE IF NOT EXISTS `consumo` (
  `idHospedagem` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  KEY `id_produto` (`idProduto`),
  KEY `idHospedagem` (`idHospedagem`,`idProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `consumo`
--

INSERT INTO `consumo` (`idHospedagem`, `idProduto`, `quantidade`) VALUES
(1, 1, 500);

-- --------------------------------------------------------

--
-- Estrutura da tabela `hospedagem`
--

CREATE TABLE IF NOT EXISTS `hospedagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `checkIn` varchar(40) NOT NULL,
  `checkOut` varchar(40) NOT NULL,
  `dataHorarioInicio` varchar(40) NOT NULL,
  `dataHorarioFim` varchar(40) NOT NULL,
  `preco` float NOT NULL,
  `status` enum('1','2','3') NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idQuarto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`idCliente`,`idQuarto`),
  KEY `id_quarto` (`idQuarto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `hospedagem`
--

INSERT INTO `hospedagem` (`id`, `checkIn`, `checkOut`, `dataHorarioInicio`, `dataHorarioFim`, `preco`, `status`, `idCliente`, `idQuarto`) VALUES
(1, '2', '2', '1', '1', 300, '2', 5, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `hotel`
--

CREATE TABLE IF NOT EXISTS `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(120) NOT NULL,
  `endereco` varchar(180) NOT NULL,
  `cnpj` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `hotel`
--

INSERT INTO `hotel` (`id`, `nome`, `endereco`, `cnpj`) VALUES
(1, 'Maravilha', 'rua maravilhosa', '6666666');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `cpf`, `telefone`, `endereco`, `nome`, `email`) VALUES
(1, '443.815.068-04', '(11)1231-1232', 'Avenida', 'Mariana', 'mariana@email'),
(2, '423.918.918-09', '(11)2143-3872', 'Rua', 'Denis', 'denis@email'),
(5, '222222222', '11111111', 'rua', 'Denis', 'denis@denis');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `nome`, `preco`, `descricao`, `status`) VALUES
(1, 'cha', 1, '', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `proprietario`
--

CREATE TABLE IF NOT EXISTS `proprietario` (
  `idPessoa` int(11) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `salario` decimal(7,2) NOT NULL,
  PRIMARY KEY (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `proprietario`
--

INSERT INTO `proprietario` (`idPessoa`, `senha`, `salario`) VALUES
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
  `idHotel` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idHotel` (`idHotel`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `quarto`
--

INSERT INTO `quarto` (`id`, `tipo`, `numero`, `preco`, `descricao`, `idHotel`) VALUES
(2, '2', 3, 40, 'opa', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `recepcionista`
--

CREATE TABLE IF NOT EXISTS `recepcionista` (
  `idPessoa` int(11) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `salario` decimal(7,2) NOT NULL,
  PRIMARY KEY (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `recepcionista`
--

INSERT INTO `recepcionista` (`idPessoa`, `senha`, `salario`) VALUES
(2, '123', '1000.00');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `consumo`
--
ALTER TABLE `consumo`
  ADD CONSTRAINT `consumo_ibfk_1` FOREIGN KEY (`idHospedagem`) REFERENCES `hospedagem` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `consumo_ibfk_2` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `hospedagem`
--
ALTER TABLE `hospedagem`
  ADD CONSTRAINT `hospedagem_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idPessoa`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hospedagem_ibfk_2` FOREIGN KEY (`idQuarto`) REFERENCES `quarto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `proprietario`
--
ALTER TABLE `proprietario`
  ADD CONSTRAINT `proprietario_ibfk_1` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `quarto`
--
ALTER TABLE `quarto`
  ADD CONSTRAINT `quarto_ibfk_1` FOREIGN KEY (`idHotel`) REFERENCES `hotel` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `recepcionista`
--
ALTER TABLE `recepcionista`
  ADD CONSTRAINT `recepcionista_ibfk_1` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
