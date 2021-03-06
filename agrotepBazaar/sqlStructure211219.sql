-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: agrotep_bazaar
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `archiveauction`
--

DROP TABLE IF EXISTS `archiveauction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `archiveauction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auctionid` int(11) NOT NULL,
  `managerid` int(11) NOT NULL,
  `route` varchar(200) CHARACTER SET ucs2 NOT NULL,
  `truck` varchar(45) CHARACTER SET ucs2 NOT NULL,
  `direction` varchar(45) CHARACTER SET ucs2 NOT NULL,
  `readiness` varchar(200) CHARACTER SET ucs2 NOT NULL,
  `rate` int(11) DEFAULT NULL,
  `currency` varchar(10) CHARACTER SET ucs2 DEFAULT NULL,
  `importance` int(11) NOT NULL,
  `betcount` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `result` varchar(100) DEFAULT NULL,
  `trucks` int(11) DEFAULT '0',
  `trucksclosed` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `archivebet`
--

DROP TABLE IF EXISTS `archivebet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `archivebet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `betid` int(11) NOT NULL,
  `auctionid` int(11) DEFAULT NULL,
  `direction` varchar(45) DEFAULT NULL,
  `information` varchar(200) DEFAULT NULL,
  `client` varchar(100) DEFAULT NULL,
  `readiness` varchar(100) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `managerid` int(11) DEFAULT NULL,
  `currency` varchar(10) DEFAULT NULL,
  `differance` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `manager` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `auction`
--

DROP TABLE IF EXISTS `auction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `managerid` int(11) NOT NULL,
  `truck` varchar(45) NOT NULL,
  `direction` varchar(45) NOT NULL,
  `readiness` varchar(200) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `currency` varchar(10) NOT NULL,
  `importance` int(11) NOT NULL,
  `betcount` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `route` varchar(200) NOT NULL,
  `trucks` int(11) DEFAULT '0',
  `trucksclosed` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bet`
--

DROP TABLE IF EXISTS `bet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auctionid` int(11) NOT NULL,
  `direction` varchar(45) NOT NULL,
  `information` varchar(200) NOT NULL,
  `client` varchar(100) NOT NULL,
  `readiness` varchar(100) NOT NULL,
  `rate` int(11) NOT NULL,
  `managerid` int(11) NOT NULL,
  `currency` varchar(10) NOT NULL,
  `differance` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `status` varchar(100) NOT NULL,
  `manager` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(45) DEFAULT NULL,
  `managerid` int(11) DEFAULT NULL,
  `manager` varchar(45) DEFAULT NULL,
  `creating` datetime DEFAULT NULL,
  `lastday` datetime DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `deal`
--

DROP TABLE IF EXISTS `deal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `soldid` int(11) NOT NULL,
  `managerid` int(11) NOT NULL,
  `manager` varchar(100) NOT NULL,
  `route` varchar(200) NOT NULL,
  `information` varchar(200) NOT NULL,
  `direction` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `truck` varchar(45) NOT NULL,
  `truckdriver` varchar(100) NOT NULL,
  `date` datetime NOT NULL,
  `dateoftransportation` datetime NOT NULL,
  `chiefid` int(11) DEFAULT NULL,
  `chiefname` varchar(45) DEFAULT NULL,
  `betid` int(11) DEFAULT NULL,
  `otherinformation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `rank` varchar(45) NOT NULL,
  `code` varchar(10) NOT NULL,
  `phone` varchar(15) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(100) NOT NULL,
  `recipientid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proposition`
--

DROP TABLE IF EXISTS `proposition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proposition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `route` varchar(200) NOT NULL,
  `direction` varchar(45) NOT NULL,
  `rate` int(11) NOT NULL,
  `currency` varchar(10) NOT NULL,
  `status` varchar(100) NOT NULL,
  `managerid` int(11) NOT NULL,
  `manager` varchar(100) NOT NULL,
  `truck` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  `readiness` datetime NOT NULL,
  `information` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sold`
--

DROP TABLE IF EXISTS `sold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sold` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `route` varchar(200) NOT NULL,
  `managerid` int(11) NOT NULL,
  `information` varchar(200) NOT NULL,
  `direction` varchar(45) NOT NULL,
  `rate` int(11) NOT NULL,
  `currency` varchar(10) NOT NULL,
  `truck` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  `readiness` varchar(200) NOT NULL,
  `importance` int(11) DEFAULT NULL,
  `auctionid` int(11) DEFAULT NULL,
  `betid` int(11) DEFAULT NULL,
  `manager` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transport`
--

DROP TABLE IF EXISTS `transport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trucknumber` varchar(45) NOT NULL,
  `truck` varchar(45) DEFAULT NULL,
  `driver` varchar(45) DEFAULT NULL,
  `chiefname` varchar(45) DEFAULT NULL,
  `chiefid` int(11) DEFAULT NULL,
  `euro` varchar(45) DEFAULT NULL,
  `otherinformation` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'agrotep_bazaar'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-21 17:44:50
