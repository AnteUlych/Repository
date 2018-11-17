-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: upbase
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
  `company` varchar(350) NOT NULL,
  `code` varchar(100) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `person` varchar(210) DEFAULT NULL,
  `mail` varchar(75) DEFAULT NULL,
  `category` varchar(45) NOT NULL,
  `manager` varchar(45) NOT NULL,
  `nextcall` datetime NOT NULL,
  `funnel` varchar(45) NOT NULL,
  `answer` varchar(1500) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `company_UNIQUE` (`company`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (11,'&#1050;&#1083;&#1080;&#1077;&#1085;&#1090; &#1090;&#1077;&#1089;&#1090;&#1086;&#1074;&#1099;&#1081;','101','506473151','Bob','anton.ulych@gmail.com','B','Anton','2018-11-19 00:00:00','calculation','&#1089;&#1095;&#1080;&#1090;&#1072;&#1077;&#1084; &#1079;&#1072;&#1087;&#1088;&#1086;&#1089;'),(12,'&#1050;&#1083;&#1080;&#1077;&#1085;&#1090; &#1058;&#1077;&#1089;&#1090;2','121','506473151','&#1052;&#1072;&#1088;&#1080;&#1085;&#1072;','anton.ulych@gmail.com','B','Anton','2018-11-29 00:00:00','partner','&#1074;&#1079;&#1103;&#1090;&#1100; &#1079;&#1072;&#1087;&#1088;&#1086;&#1089;'),(13,'&#1058;&#1077;&#1089;&#1090;&#1086;&#1074;&#1099;&#1081; &#1082;&#1083;&#1080;&#1077;&#1085;&#1090; &#1048;&#1085;&#1085;&#1099;','00','506473151','Mieszko Zlatnevski','anton.ulych@gmail.com','C','Inna','2018-11-20 00:00:00','partner','&#1089;&#1095;&#1080;&#1090;&#1072;&#1077;&#1084; &#1079;&#1072;&#1087;&#1088;&#1086;&#1089;');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `rank` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'Anton','ua@uplg.com.ua',1,1001),(2,'Inna','inna@uplg.com.ua',2,5469),(3,'Natasha','nb@uplg.com.ua',2,7432),(5,'Vlad','vs@uplg.com.ua',1,8525),(6,'Alexei','a.golovan@uplg.com.ua',2,3785),(7,'Pasha','wp@uplg.com.ua',2,6312),(8,'Anna','anna@uplg.com.ua',2,3755);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proposition`
--

DROP TABLE IF EXISTS `proposition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proposition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `requestId` int(11) NOT NULL,
  `answer` datetime NOT NULL,
  `rate` varchar(140) NOT NULL,
  `delivery` varchar(210) NOT NULL,
  `description` varchar(1500) NOT NULL,
  `manager` varchar(45) NOT NULL,
  `result` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proposition`
--

LOCK TABLES `proposition` WRITE;
/*!40000 ALTER TABLE `proposition` DISABLE KEYS */;
INSERT INTO `proposition` VALUES (30,9,'2018-11-17 23:19:49','350 EUR','7 &#1076;&#1085;&#1077;&#1081;','&#1089; &#1087;&#1077;&#1088;&#1077;&#1075;&#1088;&#1091;&#1079;&#1086;&#1084;','Inna','waiting'),(31,9,'2018-11-17 23:21:23','400','5 &#1076;&#1085;&#1077;&#1081;','&#1076;&#1086;&#1079;&#1072;&#1075;&#1088;&#1091;&#1079;','Alexei','waiting'),(36,9,'2018-11-18 00:20:31','1000','1.12.2018','&#1086;&#1082;&#1088;&#1077;&#1084;&#1072;','Pasha','waiting');
/*!40000 ALTER TABLE `proposition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(350) NOT NULL,
  `route` varchar(1000) NOT NULL,
  `creating` datetime NOT NULL,
  `manager` varchar(45) NOT NULL,
  `size` varchar(210) NOT NULL,
  `weight` varchar(100) NOT NULL,
  `other` varchar(1500) DEFAULT NULL,
  `readiness` varchar(45) NOT NULL,
  `result` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (9,'&#1050;&#1083;&#1080;&#1077;&#1085;&#1090; &#1090;&#1077;&#1089;&#1090;&#1086;&#1074;&#1099;&#1081;','&#1052;&#1072;&#1076;&#1088;&#1080;&#1076;, &#1048;&#1089;&#1087;&#1072;&#1085;&#1080;&#1103; - &#1050;&#1080;&#1077;&#1074;, &#1059;&#1082;&#1088;&#1072;&#1080;&#1085;&#1072;','2018-11-17 23:14:42','Anton','2 &#1087;&#1072;&#1083;&#1083;&#1077;&#1090;&#1099; - 1200*800','500 &#1082;&#1075;','&#1096;&#1090;&#1072;&#1073;&#1077;&#1083;&#1080;&#1088;&#1091;&#1102;&#1090;&#1089;&#1103;','&#1075;&#1086;&#1090;&#1086;&#1074;','waiting','truck'),(10,'&#1058;&#1077;&#1089;&#1090;&#1086;&#1074;&#1099;&#1081; &#1082;&#1083;&#1080;&#1077;&#1085;&#1090; &#1048;&#1085;&#1085;&#1099;','Ternopil - Kyiv','2018-11-17 23:19:05','Inna','FTL','22t','&#1091;&#1075;&#1086;&#1083;&#1100;','28.11','waiting','truck');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clientId` int(11) NOT NULL,
  `answer` varchar(1500) NOT NULL,
  `funnel` varchar(45) NOT NULL,
  `lasttime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (37,11,'&#1089;&#1082;&#1080;&#1085;&#1091;&#1090;&#1100; &#1087;&#1088;&#1077;&#1079;&#1077;&#1085;&#1090;&#1072;&#1094;&#1080;&#1102;','cold','2018-11-22 00:00:00'),(38,12,'&#1074;&#1079;&#1103;&#1090;&#1100; &#1079;&#1072;&#1087;&#1088;&#1086;&#1089;','partner','2018-11-29 00:00:00'),(39,11,'&#1089;&#1095;&#1080;&#1090;&#1072;&#1077;&#1084; &#1079;&#1072;&#1087;&#1088;&#1086;&#1089;','calculation','2018-11-17 23:12:44'),(40,13,'&#1089;&#1095;&#1080;&#1090;&#1072;&#1077;&#1084; &#1079;&#1072;&#1087;&#1088;&#1086;&#1089;','partner','2018-11-20 00:00:00');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'upbase'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-18  0:36:26
