-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: agrotep_bazaar
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `archiveauction`
--

DROP TABLE IF EXISTS `archiveauction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archiveauction`
--

LOCK TABLES `archiveauction` WRITE;
/*!40000 ALTER TABLE `archiveauction` DISABLE KEYS */;
INSERT INTO `archiveauction` VALUES (20,24,10,'тест','рефрижератор','import','тест',1000,'EUR',2,0,'2019-11-15 14:50:19'),(21,28,14,'Аукцион удалмть','цільнометалевий','export','Проо',780,'USD',3,1,'2019-11-15 16:36:15'),(22,27,14,'Ярик3','2-режимний','export','23',4321,'USD',1,2,'2019-11-15 16:14:32'),(23,26,13,'Женя1','допельшток','import','Завтра',2100,'USD',2,2,'2019-11-15 16:13:30'),(24,25,14,'ярик1','рефрижератор','export','23.07',1200,'UAH',2,3,'2019-11-15 16:12:42');
/*!40000 ALTER TABLE `archiveauction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `archivebet`
--

DROP TABLE IF EXISTS `archivebet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archivebet`
--

LOCK TABLES `archivebet` WRITE;
/*!40000 ALTER TABLE `archivebet` DISABLE KEYS */;
INSERT INTO `archivebet` VALUES (25,49,28,'export','П','Клієнт','Рнр',52,14,'USD',0,'2019-11-15 16:36:35','bet_waiting','Ярослав Бєлих'),(26,46,27,'export','Илья1','Клієнт','Готов',5000,19,'USD',679,'2019-11-15 16:21:11','bet_win','Ілля Буковський'),(27,40,27,'export','лена1','Wiskas, LTD','й',4900,28,'USD',579,'2019-11-15 16:17:40','bet_lost','Олена Погрібна'),(28,45,26,'import','лена6','ФМ','так',2800,28,'USD',700,'2019-11-15 16:19:50','bet_canceled','Олена Погрібна'),(29,44,26,'import','лена5','Kiticat','да',2000,28,'USD',0,'2019-11-15 16:19:30','bet_lost','Олена Погрібна'),(30,47,25,'export','Илья2','Клієнт','Так',2000,19,'UAH',800,'2019-11-15 16:21:51','bet_lost','Ілля Буковський'),(31,43,25,'export','лена4','ФМ','готов',1700,28,'UAH',500,'2019-11-15 16:18:54','bet_win','Олена Погрібна'),(32,42,25,'export','лена3','Kiticat','в',1300,28,'UAH',100,'2019-11-15 16:18:31','bet_lost','Олена Погрібна');
/*!40000 ALTER TABLE `archivebet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auction`
--

DROP TABLE IF EXISTS `auction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auction`
--

LOCK TABLES `auction` WRITE;
/*!40000 ALTER TABLE `auction` DISABLE KEYS */;
/*!40000 ALTER TABLE `auction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bet`
--

DROP TABLE IF EXISTS `bet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bet`
--

LOCK TABLES `bet` WRITE;
/*!40000 ALTER TABLE `bet` DISABLE KEYS */;
/*!40000 ALTER TABLE `bet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deal`
--

DROP TABLE IF EXISTS `deal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deal`
--

LOCK TABLES `deal` WRITE;
/*!40000 ALTER TABLE `deal` DISABLE KEYS */;
INSERT INTO `deal` VALUES (14,27,19,'Ілля Буковський','Ярик3','Илья1','export','deal_ok','рефрижератор','Пп5454щг','2019-11-15 16:46:45','2019-01-20 00:00:00',0,'',46,''),(15,30,28,'Олена Погрібна','Женя1','лена6','import','deal_ok','допельшток','Ds3245sd','2019-11-15 16:47:36','2019-01-21 00:00:00',0,'',45,'Екмт'),(16,28,28,'Олена Погрібна','ярик1','лена4','export','deal_ok','тент','Па3465рр','2019-11-15 16:47:57','2019-01-19 00:00:00',0,'',43,'');
/*!40000 ALTER TABLE `deal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `rank` varchar(45) NOT NULL,
  `code` varchar(10) NOT NULL,
  `phone` varchar(15) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (10,'Siam','siamacat.kyiv@gmail.com','top','1001','80506473151'),(11,'Ігор Причина','i.prychyna@agrotep.kiev.ua','top','69993','11111111111'),(12,'Анастасія Причина','anastasiia.prychyna@agrotep.kiev.ua','top','36277','11111111111'),(13,'Євгеній Нікітченко','ievgenii.nikitchenko@agrotep.kiev.ua','coordinator','35001','11111111111'),(14,'Ярослав Бєлих','y.bielykh@agrotep.kiev.ua','coordinator','67309','11111111111'),(15,'Ольга Нечипоренко','logistik@agrotep.kiev.ua','coordinator','50656','11111111111'),(16,'Олена Гриневич','helene@agrotep.kiev.ua','manager','61721','11111111111'),(17,'Юрій Касян','kys.yura@agrotep.kiev.ua','manager','52562','11111111111'),(18,'Антон Улицький','ua@agrotep.kiev.ua','manager','21203','11111111111'),(19,'Ілля Буковський','bukovskiy@agrotep.kiev.ua','manager','34031','11111111111'),(20,'Людмила Розарьонова','luda@agrotep.kiev.ua','manager','47297','11111111111'),(21,'Наталія Хортюк','n.hortyuk@agrotep.kiev.ua','manager','99301','11111111111'),(22,'Оксана Бойко','boyko@agrotep.kiev.ua','manager','18590','11111111111'),(23,'Євгеній Кузуб','kuzub@agrotep.kiev.ua','manager','32227','11111111111'),(24,'Андрій Голуб','holuba@agrotep.kiev.ua','chief','25828','11111111111'),(25,'Вячеслав Качан','kachan@agrotep.kiev.ua','chief','82603','11111111111'),(26,'Сергій Майданник','mayd@agrotep.kiev.ua','chief','30097','11111111111'),(27,'Віталій Розуменко','rozumenkov@agrotep.kiev.ua','chief','42299','11111111111'),(28,'Олена Погрібна','e.smirnova@agrotep.kiev.ua','manager','35273','11111111111'),(31,'Maxim','satoru@i.ua','coordinator','94698','380806473151'),(32,'Сандро','satoru@i.ua','coordinator','61346','380506473151'),(33,'Наудаление','satoru@i.ua','fired','90664f','380506473151');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(100) NOT NULL,
  `recipientid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (18,'04:51 напрямок Илья1 підтверджено - Пп5454щг.',19);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proposition`
--

DROP TABLE IF EXISTS `proposition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proposition`
--

LOCK TABLES `proposition` WRITE;
/*!40000 ALTER TABLE `proposition` DISABLE KEYS */;
/*!40000 ALTER TABLE `proposition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sold`
--

DROP TABLE IF EXISTS `sold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sold`
--

LOCK TABLES `sold` WRITE;
/*!40000 ALTER TABLE `sold` DISABLE KEYS */;
/*!40000 ALTER TABLE `sold` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport`
--

DROP TABLE IF EXISTS `transport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
-- Dumping data for table `transport`
--

LOCK TABLES `transport` WRITE;
/*!40000 ALTER TABLE `transport` DISABLE KEYS */;
/*!40000 ALTER TABLE `transport` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-15 17:22:06
