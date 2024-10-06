-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: petrolimex_manager
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `stations`
--

DROP TABLE IF EXISTS `stations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stations` (
  `unique_id` varchar(50) NOT NULL,
  `activated` tinyint(1) DEFAULT NULL,
  `address` varchar(120) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `hotline` varchar(13) DEFAULT NULL,
  `sku` varchar(15) NOT NULL,
  `station_name` varchar(30) NOT NULL,
  `tax` varchar(10) DEFAULT NULL,
  `chain_id` varchar(50) NOT NULL,
  PRIMARY KEY (`unique_id`),
  UNIQUE KEY `UK55cgm9egvkwu71psdhcblub9o` (`sku`),
  UNIQUE KEY `UKg2b6qhq31rj7r1lk2mq5r2d48` (`station_name`),
  UNIQUE KEY `UK9yqpuxp6jyd7ts78hq9sjgw6g` (`station_name`,`tax`),
  UNIQUE KEY `UK8yfxqpcxxag0xk51ojr9r6f1e` (`station_name`,`tax`,`sku`),
  UNIQUE KEY `UK8dkk0bjusja92pjpg6hobj8be` (`station_name`,`tax`,`chain_id`),
  KEY `FK4twbr121ffx1qcg1dbw5xpfea` (`chain_id`),
  CONSTRAINT `FK4twbr121ffx1qcg1dbw5xpfea` FOREIGN KEY (`chain_id`) REFERENCES `chains` (`unique_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stations`
--

LOCK TABLES `stations` WRITE;
/*!40000 ALTER TABLE `stations` DISABLE KEYS */;
/*!40000 ALTER TABLE `stations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-06 22:56:32
