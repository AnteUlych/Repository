-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: lotosdata
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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(90) NOT NULL,
  `code` varchar(20) NOT NULL,
  `manager` varchar(90) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `webaddress` varchar(90) DEFAULT NULL,
  `youcontrol` varchar(90) DEFAULT NULL,
  `registration` varchar(20) NOT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `deal`
--

DROP TABLE IF EXISTS `deal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenderid` int(11) NOT NULL,
  `companytenderid` int(11) NOT NULL,
  `companypropositionid` int(11) NOT NULL,
  `propositionid` int(11) NOT NULL,
  `tenderstart` varchar(45) NOT NULL,
  `tenderdeal` varchar(45) NOT NULL,
  `weight` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `ready` varchar(45) NOT NULL,
  `countryfrom` varchar(45) NOT NULL,
  `countryto` varchar(45) NOT NULL,
  `payterms` varchar(45) NOT NULL,
  `dayspay` int(11) NOT NULL,
  `freightinfo` varchar(200) NOT NULL,
  `companytender` varchar(90) NOT NULL,
  `companyproposition` varchar(90) NOT NULL,
  `addresstopickup` varchar(100) NOT NULL,
  `addresstodelivery` varchar(100) NOT NULL,
  `deliverydate` varchar(90) NOT NULL,
  `price` int(11) NOT NULL,
  `currency` varchar(10) NOT NULL,
  `freightinformationandconditions` varchar(200) NOT NULL,
  `transport` varchar(45) NOT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proposition`
--

DROP TABLE IF EXISTS `proposition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proposition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenderid` int(11) NOT NULL,
  `companyid` int(11) NOT NULL,
  `company` varchar(90) NOT NULL,
  `dateproposition` varchar(45) NOT NULL,
  `transport` varchar(45) NOT NULL,
  `pickup` varchar(90) NOT NULL,
  `deliverydate` varchar(90) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `currency` varchar(45) NOT NULL,
  `otherinformation` varchar(200) NOT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `recomendation`
--

DROP TABLE IF EXISTS `recomendation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recomendation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dealid` int(11) NOT NULL,
  `companytenderid` int(11) NOT NULL,
  `companytransportationid` int(11) NOT NULL,
  `companytender` varchar(90) NOT NULL,
  `companyproposition` varchar(90) NOT NULL,
  `dealdate` varchar(20) NOT NULL,
  `recomendationdate` varchar(20) NOT NULL,
  `incoterms` varchar(10) NOT NULL,
  `countryfrom` varchar(45) NOT NULL,
  `countryto` varchar(45) NOT NULL,
  `weight` int(11) NOT NULL,
  `transport` varchar(20) NOT NULL,
  `whyinfo` varchar(500) NOT NULL,
  `rate` varchar(10) NOT NULL,
  `companyid` int(11) NOT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(90) NOT NULL,
  `code` varchar(20) NOT NULL,
  `manager` varchar(90) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `registration` varchar(45) NOT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `statistic`
--

DROP TABLE IF EXISTS `statistic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statistic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) NOT NULL,
  `company` varchar(90) NOT NULL,
  `code` varchar(20) NOT NULL,
  `tenderscount` int(11) NOT NULL,
  `propositionscount` int(11) NOT NULL,
  `confirmpropositionscount` int(11) NOT NULL,
  `badrecomendationscount` int(11) NOT NULL,
  `goodrecomendationscount` int(11) NOT NULL,
  `confirmtenderscount` int(11) NOT NULL,
  `lastvisit` varchar(45) NOT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `companyid_UNIQUE` (`companyid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tender`
--

DROP TABLE IF EXISTS `tender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tender` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) NOT NULL,
  `company` varchar(90) NOT NULL,
  `datetimecreation` datetime NOT NULL,
  `dateofopening` varchar(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `readytopickup` varchar(45) NOT NULL,
  `appdelivery` varchar(45) NOT NULL,
  `timetoendtender` datetime NOT NULL,
  `countryfrom` varchar(45) NOT NULL,
  `countryto` varchar(45) NOT NULL,
  `possibletransport` varchar(45) NOT NULL,
  `payconditions` varchar(100) NOT NULL,
  `dayspay` int(11) NOT NULL,
  `freightinformationandconditions` varchar(200) NOT NULL,
  `visiability` varchar(45) NOT NULL,
  `addresstopickup` varchar(100) NOT NULL,
  `addresstodelivery` varchar(100) NOT NULL,
  `incoterms` varchar(10) NOT NULL,
  `isopen` varchar(10) NOT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'lotosdata'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-09 15:46:26
