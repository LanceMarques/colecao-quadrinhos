-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: colecao-quadrinhos
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `amigo`
--

DROP TABLE IF EXISTS `amigo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amigo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) DEFAULT NULL,
  `APELIDO` varchar(45) DEFAULT NULL,
  `NUMERO_CELULAR` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `editora`
--

DROP TABLE IF EXISTS `editora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editora` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `emprestimo`
--

DROP TABLE IF EXISTS `emprestimo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emprestimo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATA_REALIZACAO` date NOT NULL,
  `DATA_DEVOLUCAO` date DEFAULT NULL,
  `STATUS` varchar(45) NOT NULL,
  `EMPRESTIMOcol` varchar(45) DEFAULT NULL,
  `AMIGO_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`,`AMIGO_ID`),
  KEY `fk_EMPRESTIMO_AMIGO1_idx` (`AMIGO_ID`),
  CONSTRAINT `fk_EMPRESTIMO_AMIGO1` FOREIGN KEY (`AMIGO_ID`) REFERENCES `amigo` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `emprestimo_has_quadrinho`
--

DROP TABLE IF EXISTS `emprestimo_has_quadrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emprestimo_has_quadrinho` (
  `EMPRESTIMO_ID` int(11) NOT NULL,
  `QUADRINHO_ID` int(11) NOT NULL,
  PRIMARY KEY (`EMPRESTIMO_ID`,`QUADRINHO_ID`),
  KEY `fk_EMPRESTIMO_has_QUADRINHO_QUADRINHO1_idx` (`QUADRINHO_ID`),
  KEY `fk_EMPRESTIMO_has_QUADRINHO_EMPRESTIMO1_idx` (`EMPRESTIMO_ID`),
  CONSTRAINT `fk_EMPRESTIMO_has_QUADRINHO_EMPRESTIMO1` FOREIGN KEY (`EMPRESTIMO_ID`) REFERENCES `emprestimo` (`ID`),
  CONSTRAINT `fk_EMPRESTIMO_has_QUADRINHO_QUADRINHO1` FOREIGN KEY (`QUADRINHO_ID`) REFERENCES `quadrinho` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `quadrinho`
--

DROP TABLE IF EXISTS `quadrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quadrinho` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITULO_ID` int(11) NOT NULL,
  `QUANTIDADE` int(10) DEFAULT NULL,
  `VOLUME` int(10) DEFAULT NULL,
  `ESTADO_CONSERVACAO` varchar(45) DEFAULT NULL,
  `VALOR` double DEFAULT NULL,
  PRIMARY KEY (`ID`,`TITULO_ID`),
  KEY `fk_QUADRINHO_TITULO1_idx` (`TITULO_ID`),
  CONSTRAINT `fk_QUADRINHO_TITULO1` FOREIGN KEY (`TITULO_ID`) REFERENCES `titulo` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `titulo`
--

DROP TABLE IF EXISTS `titulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `titulo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) DEFAULT NULL,
  `ESTADO_COLECAO` varchar(45) DEFAULT NULL,
  `URL_IMAGEM` varchar(45) DEFAULT NULL,
  `AVALIACAO` int(11) DEFAULT NULL,
  `TIPO` varchar(45) DEFAULT NULL,
  `EDITORA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-29 23:58:47
