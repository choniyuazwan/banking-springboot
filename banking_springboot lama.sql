-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: banking_springboot
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
  `account_number` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(45) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `openDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `cif` int(11) DEFAULT NULL,
  PRIMARY KEY (`account_number`),
  KEY `FKp7wsluclqtd5h7y824nnibjl8` (`cif`),
  CONSTRAINT `FKp7wsluclqtd5h7y824nnibjl8` FOREIGN KEY (`cif`) REFERENCES `customer` (`cif`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'akun 1',99500,NULL,1),(2,'akun 2',99500,NULL,1),(3,'akun 3',100000,NULL,2),(4,'akun 4',100000,NULL,1),(5,'gusti akun',300000,NULL,1),(6,'Laras',300000,NULL,2),(7,'rek azwan 1',100000,NULL,4),(8,'rek azwan 2',50000,NULL,4),(9,'gopay',50000,NULL,4),(10,'ovo',0,NULL,4),(11,'dana',50000,NULL,4),(12,'rek azwan 3',100000,NULL,4),(13,'rekening 1',10000,NULL,7),(14,'gopay',50000,NULL,7),(15,'ovo',70000,NULL,7);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `cif` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `birthdate` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cif`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'l','l','l','l','l'),(2,'a','a','a','a','a'),(3,'b','b','b','b','b'),(4,'choniyu','azwan','14/09/97','azwan','azwan'),(5,'q','q','q','q','q'),(6,'w','w','w','w','a'),(7,'Budi','Handuk','12/12/1996','budi','budi'),(8,'andi','rif','12/11/1995','a sss','a'),(9,'aa','aa','aa','validasi','validasi'),(10,'99','99','99','99','99'),(11,'11','11','11','11','11'),(12,'12','12','12','12','12'),(13,'13','13','13','13','13'),(14,'14','14','14','14','14'),(15,'spring','spring','29-11-1954','spring','spring'),(16,'','','29-11-1954','',''),(17,'gusti first','gusti last','29-11-1954','gustiusername','gustipassword'),(18,'33','33','29-11-1954','33','33');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `account_debit` int(11) DEFAULT NULL,
  `account_credit` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `cif` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnp6o51c24kj5jytqjcvj4lsbr` (`account_debit`),
  KEY `FKfyulcnb5oy8f5ow8avihkwfkh` (`cif`),
  KEY `FK5sn54tdtl540nn1qwfvt7nhd5` (`type`),
  CONSTRAINT `FK5sn54tdtl540nn1qwfvt7nhd5` FOREIGN KEY (`type`) REFERENCES `transaction_type` (`code`),
  CONSTRAINT `FKa80kblc0ww9p9xjei8luheqlk` FOREIGN KEY (`account_debit`) REFERENCES `account` (`account_number`),
  CONSTRAINT `FKfyulcnb5oy8f5ow8avihkwfkh` FOREIGN KEY (`cif`) REFERENCES `customer` (`cif`),
  CONSTRAINT `FKnp6o51c24kj5jytqjcvj4lsbr` FOREIGN KEY (`account_debit`) REFERENCES `account` (`account_number`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,1,1,NULL,10000,NULL,1),(2,2,1,NULL,10000,NULL,1),(3,3,1,NULL,50000,NULL,2),(4,2,4,NULL,1000,NULL,1),(5,2,1,NULL,20,NULL,1),(6,3,1,NULL,50,NULL,1),(7,1,2,NULL,1000,NULL,1),(8,1,1,NULL,500,NULL,1),(9,1,1,NULL,500,NULL,1),(10,2,2,NULL,500,NULL,1),(11,3,1,NULL,500,NULL,1),(12,1,7,NULL,50000,NULL,4),(13,2,10,NULL,50000,NULL,4),(14,3,12,NULL,50000,NULL,4),(15,1,12,NULL,50000,NULL,4),(16,1,12,NULL,50000,NULL,4),(17,1,15,NULL,20000,NULL,7),(18,2,13,NULL,20000,NULL,7),(19,3,13,NULL,20000,NULL,7);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_type`
--

DROP TABLE IF EXISTS `transaction_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transaction_type` (
  `code` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `account_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_type`
--

LOCK TABLES `transaction_type` WRITE;
/*!40000 ALTER TABLE `transaction_type` DISABLE KEYS */;
INSERT INTO `transaction_type` VALUES (1,'Top Up','Credit'),(2,'Transfer','Debit'),(3,'Withdraw','Debit');
/*!40000 ALTER TABLE `transaction_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `wallet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `cif` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh8q6xmgn3mldr4mvkec2x7vyg` (`cif`),
  CONSTRAINT `FKh8q6xmgn3mldr4mvkec2x7vyg` FOREIGN KEY (`cif`) REFERENCES `customer` (`cif`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

LOCK TABLES `wallet` WRITE;
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
INSERT INTO `wallet` VALUES (1,'Rekening','2019-03-30 01:58:25',1),(2,'E-payment','2019-03-30 01:58:25',1),(3,'rekening',NULL,1),(4,'rekening',NULL,4),(5,'e-payment',NULL,4),(6,'rekening',NULL,7),(7,'e-payment',NULL,7);
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet_account`
--

DROP TABLE IF EXISTS `wallet_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `wallet_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wallet_id` int(11) DEFAULT NULL,
  `account_number` int(11) DEFAULT NULL,
  `cif` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKce5i8mdxu1854oro7ci3hmxrg` (`account_number`),
  KEY `FKtoj2dv183g456gh34n4puwlgj` (`cif`),
  KEY `FK7tij0hyn889rfnler4esuoxd3` (`wallet_id`),
  CONSTRAINT `FK7tij0hyn889rfnler4esuoxd3` FOREIGN KEY (`wallet_id`) REFERENCES `wallet` (`id`),
  CONSTRAINT `FKce5i8mdxu1854oro7ci3hmxrg` FOREIGN KEY (`account_number`) REFERENCES `account` (`account_number`),
  CONSTRAINT `FKtoj2dv183g456gh34n4puwlgj` FOREIGN KEY (`cif`) REFERENCES `customer` (`cif`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet_account`
--

LOCK TABLES `wallet_account` WRITE;
/*!40000 ALTER TABLE `wallet_account` DISABLE KEYS */;
INSERT INTO `wallet_account` VALUES (2,1,2,1),(3,2,1,1),(4,4,7,4),(5,5,10,4),(7,5,9,4),(8,4,12,4),(11,6,13,7),(14,7,14,7);
/*!40000 ALTER TABLE `wallet_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-13 10:42:14
