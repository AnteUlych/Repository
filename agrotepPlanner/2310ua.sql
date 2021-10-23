-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: agrotepua
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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contactPerson` varchar(45) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `payment` varchar(100) NOT NULL,
  `transportVolume` varchar(100) NOT NULL,
  `season` varchar(45) NOT NULL,
  `cargo` varchar(45) NOT NULL,
  `otherInfo` varchar(150) NOT NULL,
  `warning` varchar(1000) NOT NULL,
  `creatingDate` datetime NOT NULL,
  `typetruck` varchar(45) NOT NULL,
  `blacklist` int(11) NOT NULL,
  `salesName` varchar(45) NOT NULL,
  `salesId` int(11) NOT NULL,
  `company` varchar(45) DEFAULT NULL,
  `code` varchar(11) NOT NULL,
  `driverInstruction` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `direction`
--

DROP TABLE IF EXISTS `direction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `oblastFrom` varchar(45) NOT NULL,
  `oblastTo` varchar(45) NOT NULL,
  `clientId` int(11) NOT NULL,
  `info` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=218 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `documents`
--

DROP TABLE IF EXISTS `documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `drnumber` int(11) NOT NULL,
  `truck` varchar(45) NOT NULL,
  `client` varchar(45) DEFAULT NULL,
  `weclient` varchar(45) NOT NULL,
  `aboutroute` varchar(500) DEFAULT NULL,
  `responsibleid` int(11) DEFAULT NULL,
  `responsiblename` varchar(45) DEFAULT NULL,
  `whoaskingid` int(11) DEFAULT NULL,
  `whoaskingname` varchar(45) DEFAULT NULL,
  `whatneed` varchar(500) DEFAULT NULL,
  `datecreating` datetime DEFAULT NULL,
  `datesolvving` datetime DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `logistcoment` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `garant`
--

DROP TABLE IF EXISTS `garant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `garant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client` varchar(100) DEFAULT NULL,
  `route` varchar(200) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `truckandmanager` varchar(100) DEFAULT NULL,
  `dayofweek` int(11) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `plandate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `managerid` int(11) NOT NULL,
  `action` int(11) NOT NULL,
  `manager` varchar(45) NOT NULL,
  `actionDate` datetime NOT NULL,
  `info` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2424 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `status` int(11) NOT NULL,
  `loginPass` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `maplink`
--

DROP TABLE IF EXISTS `maplink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maplink` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `truckid` int(11) NOT NULL,
  `fromCity` varchar(45) DEFAULT NULL,
  `toCity` varchar(45) DEFAULT NULL,
  `fromOblast` varchar(45) DEFAULT NULL,
  `toOblast` varchar(45) DEFAULT NULL,
  `fromLon` double NOT NULL,
  `fromLat` double NOT NULL,
  `toLon` double NOT NULL,
  `toLat` double NOT NULL,
  `fromDate` datetime NOT NULL,
  `toDate` datetime DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `kilometrs` int(11) DEFAULT NULL,
  `piceForKilometr` int(11) DEFAULT NULL,
  `info` varchar(700) DEFAULT NULL,
  `routeStatus` int(11) DEFAULT NULL,
  `addressFrom` varchar(100) DEFAULT NULL,
  `addressTo` varchar(100) DEFAULT NULL,
  `driverInstruction` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2142 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `truck`
--

DROP TABLE IF EXISTS `truck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `truck` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tracktor` varchar(20) NOT NULL,
  `trailer` varchar(20) DEFAULT NULL,
  `driver` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `managerName` varchar(45) DEFAULT NULL,
  `managerid` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `notReady` int(11) DEFAULT NULL,
  `statusTruck` varchar(45) DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `truckKey` varchar(100) DEFAULT NULL,
  `kmruptela0131` int(11) DEFAULT '0',
  `uahkmruptela0131` double DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'agrotepua'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-23 14:56:16
