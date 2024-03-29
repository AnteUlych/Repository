-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: agrotepbase
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `calculates`
--

DROP TABLE IF EXISTS `calculates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calculates` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company` varchar(100) DEFAULT NULL,
  `companyid` int DEFAULT NULL,
  `manager` varchar(45) DEFAULT NULL,
  `managerid` int DEFAULT NULL,
  `comments` varchar(500) DEFAULT NULL,
  `weight` int DEFAULT NULL,
  `dateofcalculate` datetime DEFAULT NULL,
  `freight` varchar(45) DEFAULT NULL,
  `truck` varchar(45) DEFAULT NULL,
  `temperature` varchar(45) DEFAULT NULL,
  `dangerous` varchar(10) DEFAULT NULL,
  `countryfrom` varchar(45) DEFAULT NULL,
  `countryto` varchar(45) DEFAULT NULL,
  `calculateonadate` varchar(45) DEFAULT NULL,
  `budget` varchar(45) DEFAULT NULL,
  `rate` varchar(45) DEFAULT NULL,
  `exportimport` varchar(45) DEFAULT NULL,
  `cityfrom` varchar(200) DEFAULT NULL,
  `cityto` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company` varchar(100) NOT NULL,
  `managerid` int NOT NULL,
  `manager` varchar(45) NOT NULL,
  `lpr` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `othercontact` varchar(200) NOT NULL,
  `products` varchar(400) NOT NULL,
  `creation` datetime NOT NULL,
  `funel` int DEFAULT NULL,
  `nextcall` datetime NOT NULL,
  `lastrecord` varchar(200) NOT NULL,
  `freight` varchar(45) NOT NULL,
  `edrpo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=710 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `code` varchar(10) NOT NULL,
  `rank` int DEFAULT NULL,
  `mail` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product` varchar(45) NOT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `records`
--

DROP TABLE IF EXISTS `records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `records` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `record` varchar(500) NOT NULL,
  `clientid` int NOT NULL,
  `manager` varchar(45) NOT NULL,
  `recordstatus` int DEFAULT NULL,
  `managerid` int DEFAULT NULL,
  `funel` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10838 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `weeklyreminder`
--

DROP TABLE IF EXISTS `weeklyreminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weeklyreminder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `clientid` int NOT NULL,
  `clientname` varchar(100) NOT NULL,
  `textreminder` varchar(500) NOT NULL,
  `dayofweek` int NOT NULL,
  `color` varchar(45) DEFAULT NULL,
  `managerid` int NOT NULL,
  `isitnotchecked` int DEFAULT NULL,
  `bobdate` datetime DEFAULT NULL,
  `dayofweekname` varchar(45) DEFAULT NULL,
  `manager` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-23 16:59:23
