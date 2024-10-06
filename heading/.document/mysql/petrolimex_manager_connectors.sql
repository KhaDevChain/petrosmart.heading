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
-- Table structure for table `connectors`
--

DROP TABLE IF EXISTS `connectors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `connectors` (
  `unique_id` varchar(50) NOT NULL,
  `activated` tinyint(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `device_id` varchar(10) NOT NULL,
  `fuelpipe_id` varchar(50) NOT NULL,
  `fuelrectangular_id` varchar(50) NOT NULL,
  `secrect_key` varchar(30) NOT NULL,
  `status_name` varchar(50) NOT NULL,
  `chain_id` varchar(50) NOT NULL,
  `station_id` varchar(50) NOT NULL,
  `status_id` int NOT NULL,
  PRIMARY KEY (`unique_id`),
  UNIQUE KEY `UKkgyfhx1kgluh4ubxvu0kig20r` (`unique_id`,`chain_id`,`station_id`,`fuelrectangular_id`,`fuelpipe_id`),
  KEY `FKo1ldfwud2bgm1l999wxkc9k46` (`chain_id`),
  KEY `FKk1ko59wxdkcpi139lu1tvrya9` (`station_id`),
  KEY `FKswwatoau1e2rskg6gki6ecmmb` (`status_id`),
  CONSTRAINT `FKk1ko59wxdkcpi139lu1tvrya9` FOREIGN KEY (`station_id`) REFERENCES `stations` (`unique_id`),
  CONSTRAINT `FKo1ldfwud2bgm1l999wxkc9k46` FOREIGN KEY (`chain_id`) REFERENCES `chains` (`unique_id`),
  CONSTRAINT `FKswwatoau1e2rskg6gki6ecmmb` FOREIGN KEY (`status_id`) REFERENCES `status` (`unique_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connectors`
--

LOCK TABLES `connectors` WRITE;
/*!40000 ALTER TABLE `connectors` DISABLE KEYS */;
/*!40000 ALTER TABLE `connectors` ENABLE KEYS */;
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
