-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 19-Out-2017 às 20:11
-- Versão do servidor: 10.1.24-MariaDB
-- PHP Version: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `template-api`
--
CREATE DATABASE IF NOT EXISTS `template-api` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `template-api`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `key_api`
--

CREATE TABLE `key_api` (
  `CODIGO` int(11) NOT NULL,
  `DESCRICAO` varchar(100) DEFAULT NULL,
  `TOKEN` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `key_api`
--

INSERT INTO `key_api` (`CODIGO`, `DESCRICAO`, `TOKEN`) VALUES
(1, 'TEMPLATE_API', '21d141b5941d4b5ad7d7b67ea41f9e16');

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`ID`, `NOME`) VALUES
(2, 'Fátima Rayane Coêlho de Farias'),
(3, 'Arão Alves de Farias');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `key_api`
--
ALTER TABLE `key_api`
  ADD PRIMARY KEY (`CODIGO`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `key_api`
--
ALTER TABLE `key_api`
  MODIFY `CODIGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
