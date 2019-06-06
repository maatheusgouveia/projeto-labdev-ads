-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 06-Jun-2019 às 05:30
-- Versão do servidor: 10.1.40-MariaDB
-- versão do PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `labdev`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `anuncios`
--

CREATE TABLE `anuncios` (
  `idAnuncio` int(10) UNSIGNED NOT NULL,
  `ValidoDe` datetime NOT NULL,
  `ValidoAte` datetime NOT NULL,
  `DescricaoAnuncio` varchar(45) DEFAULT NULL,
  `idProduto` int(10) UNSIGNED NOT NULL,
  `idUsuario` int(10) UNSIGNED NOT NULL,
  `Preco` float UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `categorias`
--

CREATE TABLE `categorias` (
  `idCategoria` int(10) UNSIGNED NOT NULL,
  `NomeCategoria` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `categorias`
--

INSERT INTO `categorias` (`idCategoria`, `NomeCategoria`) VALUES
(3, 'categoria'),
(2, 'Eletrônicos'),
(1, 'Jogos');

-- --------------------------------------------------------

--
-- Estrutura da tabela `logs`
--

CREATE TABLE `logs` (
  `idLog` int(10) UNSIGNED NOT NULL,
  `Acao` varchar(45) NOT NULL,
  `DataHora` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `NomeUsuario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `logs`
--

INSERT INTO `logs` (`idLog`, `Acao`, `DataHora`, `NomeUsuario`) VALUES
(4, 'Se cadastrou', '2019-06-02 16:14:30', 'TEste logs'),
(5, 'Excluiu a conta', '2019-06-02 16:18:58', 'TEste logs'),
(6, 'Alterou dados', '2019-06-02 16:26:39', 'TEste logsaaaaa'),
(7, 'Se cadastrou', '2019-06-03 22:18:01', 'testando'),
(8, 'Entrou', '2019-06-03 23:32:32', 'matheusgouveia'),
(9, 'Se cadastrou', '2019-06-05 21:46:37', '123'),
(10, 'Entrou', '2019-06-05 22:11:52', 'matheusgouveia'),
(11, 'Saiu', '2019-06-05 22:11:56', 'matheusgouveia'),
(12, 'Se cadastrou', '2019-06-05 22:12:19', '123123'),
(13, 'Entrou', '2019-06-05 22:12:28', '123123'),
(14, 'Entrou', '2019-06-05 22:26:46', 'matheusgouveia'),
(15, 'Entrou', '2019-06-05 22:40:35', 'matheusgouveia'),
(16, 'Entrou', '2019-06-05 22:52:06', 'matheusgouveia'),
(17, 'Entrou', '2019-06-05 23:10:42', 'matheusgouveia'),
(18, 'Uma marca foi cadastrada', '2019-06-05 23:10:50', 'matheusgouveia'),
(19, 'Uma categoria foi cadastrada', '2019-06-05 23:11:15', 'matheusgouveia'),
(20, 'Entrou', '2019-06-05 23:50:14', 'matheusgouveia'),
(21, 'Entrou', '2019-06-05 23:50:56', 'matheusgouveia'),
(22, 'Entrou', '2019-06-05 23:53:36', 'matheusgouveia'),
(23, 'Uma subcategoria foi cadastrada', '2019-06-05 23:53:42', 'matheusgouveia'),
(24, 'Entrou', '2019-06-06 00:29:37', 'matheusgouveia'),
(25, 'Um produto foi cadastrado', '2019-06-06 00:29:45', 'matheusgouveia');

-- --------------------------------------------------------

--
-- Estrutura da tabela `marcas`
--

CREATE TABLE `marcas` (
  `idMarca` int(10) UNSIGNED NOT NULL,
  `NomeMarca` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `marcas`
--

INSERT INTO `marcas` (`idMarca`, `NomeMarca`) VALUES
(1, 'marca');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `idProduto` int(10) UNSIGNED NOT NULL,
  `NomeProduto` varchar(45) NOT NULL,
  `idSubcategoria` int(10) UNSIGNED NOT NULL,
  `idMarca` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`idProduto`, `NomeProduto`, `idSubcategoria`, `idMarca`) VALUES
(1, 'asdadsadsa', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `subcategorias`
--

CREATE TABLE `subcategorias` (
  `idSubcategoria` int(10) UNSIGNED NOT NULL,
  `NomeSubcategoria` varchar(45) NOT NULL,
  `idCategoria` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `subcategorias`
--

INSERT INTO `subcategorias` (`idSubcategoria`, `NomeSubcategoria`, `idCategoria`) VALUES
(1, 'adasdasdas', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tiposusuario`
--

CREATE TABLE `tiposusuario` (
  `idTipoUsuario` int(10) UNSIGNED NOT NULL,
  `NomeTipoUsuario` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tiposusuario`
--

INSERT INTO `tiposusuario` (`idTipoUsuario`, `NomeTipoUsuario`) VALUES
(1, 'Administrador'),
(2, 'Usuário');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(10) UNSIGNED NOT NULL,
  `NomeUsuario` varchar(45) NOT NULL,
  `DataCadastro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Email` varchar(100) NOT NULL,
  `Senha` varchar(45) NOT NULL,
  `idTipoUsuario` int(10) UNSIGNED NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `NomeUsuario`, `DataCadastro`, `Email`, `Senha`, `idTipoUsuario`) VALUES
(1, 'matheusgouveia', '2019-05-26 15:26:21', 'matheus_guitarplayer@hotmail.com', 'e10adc3949ba59abbe56e057f20f883e', 2),
(2, 'TEste logsaaaaa', '2019-06-02 16:06:44', 'adasdadasdsa', '123123', 2),
(3, 'testando', '2019-06-03 22:18:01', 'testando', '4297f44b13955235245b2497399d7a93', 2),
(4, '123', '2019-06-05 21:46:37', 'matheus', '202cb962ac59075b964b07152d234b70', 2),
(5, '123123', '2019-06-05 22:12:19', 'matheus@123', '4297f44b13955235245b2497399d7a93', 2);

--
-- Acionadores `usuarios`
--
DELIMITER $$
CREATE TRIGGER `trg_altera_cadastro` AFTER UPDATE ON `usuarios` FOR EACH ROW BEGIN
    INSERT INTO Logs (Acao, DataHora, NomeUsuario) VALUES ("Alterou dados", CURRENT_TIMESTAMP, NEW.NomeUsuario);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_cadastro` AFTER INSERT ON `usuarios` FOR EACH ROW BEGIN
    INSERT INTO Logs (Acao, DataHora, NomeUsuario) VALUES ("Se cadastrou", CURRENT_TIMESTAMP, NEW.NomeUsuario);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_excluir` AFTER DELETE ON `usuarios` FOR EACH ROW BEGIN
    INSERT INTO Logs (Acao, DataHora, NomeUsuario) VALUES ("Excluiu a conta", CURRENT_TIMESTAMP, OLD.NomeUsuario);
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anuncios`
--
ALTER TABLE `anuncios`
  ADD PRIMARY KEY (`idAnuncio`),
  ADD UNIQUE KEY `idAnuncio_UNIQUE` (`idAnuncio`),
  ADD KEY `fk_Anuncios_Produtos_idx` (`idProduto`),
  ADD KEY `fk_Anuncios_Usuarios1_idx` (`idUsuario`);

--
-- Indexes for table `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idCategoria`),
  ADD UNIQUE KEY `NomeCategoria_UNIQUE` (`NomeCategoria`),
  ADD UNIQUE KEY `idCategoria_UNIQUE` (`idCategoria`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`idLog`),
  ADD UNIQUE KEY `idLog_UNIQUE` (`idLog`);

--
-- Indexes for table `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`idMarca`),
  ADD UNIQUE KEY `idMarca_UNIQUE` (`idMarca`),
  ADD UNIQUE KEY `NomeMarca_UNIQUE` (`NomeMarca`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`idProduto`),
  ADD UNIQUE KEY `idProduto_UNIQUE` (`idProduto`),
  ADD KEY `fk_Produtos_Subcategorias1_idx` (`idSubcategoria`),
  ADD KEY `fk_Produtos_Marcas1_idx` (`idMarca`);

--
-- Indexes for table `subcategorias`
--
ALTER TABLE `subcategorias`
  ADD PRIMARY KEY (`idSubcategoria`),
  ADD UNIQUE KEY `NomeSubcategoria_UNIQUE` (`NomeSubcategoria`),
  ADD UNIQUE KEY `idSubcategoria_UNIQUE` (`idSubcategoria`),
  ADD KEY `fk_Subcategorias_Categorias1_idx` (`idCategoria`);

--
-- Indexes for table `tiposusuario`
--
ALTER TABLE `tiposusuario`
  ADD PRIMARY KEY (`idTipoUsuario`),
  ADD UNIQUE KEY `idTipoUsuario_UNIQUE` (`idTipoUsuario`),
  ADD UNIQUE KEY `NomeTipoUsuario_UNIQUE` (`NomeTipoUsuario`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `idUsuarios_UNIQUE` (`idUsuario`),
  ADD UNIQUE KEY `Email_UNIQUE` (`Email`),
  ADD KEY `fk_Usuarios_TiposUsuario1_idx` (`idTipoUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anuncios`
--
ALTER TABLE `anuncios`
  MODIFY `idAnuncio` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `categorias`
--
ALTER TABLE `categorias`
  MODIFY `idCategoria` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `idLog` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `marcas`
--
ALTER TABLE `marcas`
  MODIFY `idMarca` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
  MODIFY `idProduto` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `subcategorias`
--
ALTER TABLE `subcategorias`
  MODIFY `idSubcategoria` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tiposusuario`
--
ALTER TABLE `tiposusuario`
  MODIFY `idTipoUsuario` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `anuncios`
--
ALTER TABLE `anuncios`
  ADD CONSTRAINT `fk_Anuncios_Produtos` FOREIGN KEY (`idProduto`) REFERENCES `produtos` (`idProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Anuncios_Usuarios1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `fk_Produtos_Marcas1` FOREIGN KEY (`idMarca`) REFERENCES `marcas` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Produtos_Subcategorias1` FOREIGN KEY (`idSubcategoria`) REFERENCES `subcategorias` (`idSubcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `subcategorias`
--
ALTER TABLE `subcategorias`
  ADD CONSTRAINT `fk_Subcategorias_Categorias1` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_Usuarios_TiposUsuario1` FOREIGN KEY (`idTipoUsuario`) REFERENCES `tiposusuario` (`idTipoUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
