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
  `company` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `person` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `category` varchar(45) NOT NULL,
  `manager` varchar(45) NOT NULL,
  `nextcall` datetime NOT NULL,
  `funnel` varchar(45) NOT NULL,
  `answer` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `company_UNIQUE` (`company`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Axe Chemicals','301','3852121','12121','qw@i.ua','A','Marina','2018-09-15 14:54:23','cold','договориться о встрече'),(3,'King Candee','201','5454545','Smith','iii@ua','B','Marina','2018-11-21 00:00:00','interest','hhh'),(4,'Queen Cookies','101','545454','Нельсон','satoru@i.ua','В','Anton','2018-08-14 14:54:23','cold','не интересно'),(5,'10th','405','545454','Смит','satoru@i.ua','В','Anton','2018-08-13 14:54:23','cold','позвонить позже'),(6,'fresco','212340','506473151','Mieszko Zlatnevski','anton.ulych@gmail.com','B','Marina','2018-11-08 00:00:00','interest','good');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'Anton','satoru@i.ua',1,1235),(2,'Marina','satoru@i.ua',2,1234),(3,'Julia','satoru@i.ua',2,1236);
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
  `rate` varchar(45) NOT NULL,
  `delivery` varchar(45) NOT NULL,
  `description` varchar(100) NOT NULL,
  `manager` varchar(45) NOT NULL,
  `result` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proposition`
--

LOCK TABLES `proposition` WRITE;
/*!40000 ALTER TABLE `proposition` DISABLE KEYS */;
INSERT INTO `proposition` VALUES (4,2,'2018-11-07 15:56:42','450','2 week','by wh','Pasha','not interesting'),(17,2,'2018-11-07 15:56:42','330','3 week','by wh','Pasha','not interesting'),(18,2,'2018-11-07 15:56:42','360','21/05','by wh','Lesha','not interesting'),(19,2,'2018-11-10 14:19:53','202','after tomorrow','direct','Marina','booking');
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
  `company` varchar(45) NOT NULL,
  `route` varchar(200) NOT NULL,
  `creating` datetime NOT NULL,
  `manager` varchar(45) NOT NULL,
  `size` varchar(200) NOT NULL,
  `weight` varchar(45) NOT NULL,
  `other` varchar(200) DEFAULT NULL,
  `readiness` varchar(45) NOT NULL,
  `result` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (1,'King Candee','Berlin, DE - Kyiv, UA, 2 pallets','2018-11-06 09:47:11','Anton','1000*500*600','230 kg','none','25 october','waiting','truck'),(2,'Axe Chemicals','Milano, It - Kyiv, UA, 20t','2018-11-06 09:46:11','Anton','FTL','20t','+5C','request','booking','truck'),(3,'Axe Chemicals','Ternopil, UA - Kyiv, UA','2018-11-07 09:46:11','Anton','120*25*45','45 kg',NULL,'26 october','waiting','truck'),(4,'King Candee','Ky - IF','2018-11-10 16:12:25','Marina','1200*800','300 kg','fast','23.06','waiting','truck'),(5,'Axe Chemicals','LV-IF','2018-11-10 16:23:31','Marina','1200*800','5t','fast','21/05','waiting','truck');
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
  `answer` varchar(300) NOT NULL,
  `funnel` varchar(45) NOT NULL,
  `lasttime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (9,1,'good prices','cold','2018-11-06 09:39:42'),(10,1,'call me later','cold','2018-11-06 09:40:57'),(11,3,'хорошая цена','cold','2018-11-06 09:40:57'),(12,1,'норм так','cold','2018-11-06 09:40:57'),(13,3,'hhh','calculation','2018-11-12 11:16:10'),(14,3,'asa','interest','2018-11-12 11:17:15'),(15,3,'asa','interest','2018-11-12 11:17:21'),(16,3,'hhh','cold','2018-11-12 11:17:56'),(17,3,'121','partner','2018-11-12 11:18:17'),(18,3,'','interest','2018-11-12 11:43:26'),(19,3,'hhh','interest','2018-11-12 11:43:40'),(20,6,'good','interest','2018-11-08 00:00:00');
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

-- Dump completed on 2018-11-12 22:02:16
