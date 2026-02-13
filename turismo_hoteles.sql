-- MySQL dump 10.13  Distrib 8.0.43, for macos15 (x86_64)
--
-- Host: 127.0.0.1    Database: turismo
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `hoteles`
--

DROP TABLE IF EXISTS `hoteles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoteles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(255) DEFAULT NULL,
  `estrellas` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio_noche` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoteles`
--

LOCK TABLES `hoteles` WRITE;
/*!40000 ALTER TABLE `hoteles` DISABLE KEYS */;
INSERT INTO `hoteles` VALUES (1,'Madrid',5,'Hotel Alameda Madrid',180),(2,'Barcelona',5,'Hotel Marina Barcelona',195),(3,'Sevilla',4,'Hotel Giralda Sevilla',140),(4,'Valencia',4,'Hotel Turia Valencia',135),(5,'Bilbao',4,'Hotel Nervion Bilbao',145),(6,'Zaragoza',3,'Hotel Ebro Zaragoza',95),(7,'Granada',4,'Hotel Genil Granada',125),(8,'Córdoba',4,'Hotel Dehesa Cordoba',120),(9,'Málaga',4,'Hotel Atlantico Malaga',130),(10,'Palma',4,'Hotel Bahía Palma',150),(11,'A Coruña',4,'Hotel Orzan A Coruna',125),(12,'Valladolid',3,'Hotel Victoria Valladolid',90),(13,'Vigo',4,'Hotel Rubicon Vigo',120),(14,'Gijón',3,'Hotel Jardines Gijon',88),(15,'Santander',4,'Hotel Cantabrico Santander',135),(16,'Alicante',4,'Hotel Laurel Alicante',128),(17,'Murcia',3,'Hotel Salinas Murcia',85),(18,'Las Palmas de Gran Canaria',4,'Hotel Luz Las Palmas',132),(19,'Santa Cruz de Tenerife',4,'Hotel Teide Santa Cruz',130),(20,'Cádiz',4,'Hotel Maris Cadiz',140),(21,'Huelva',3,'Hotel Romero Huelva',82),(22,'Jaén',3,'Hotel Mezquita Jaen',80),(23,'Almería',4,'Hotel Dama Almeria',120),(24,'Salamanca',4,'Hotel Campana Salamanca',115),(25,'Toledo',4,'Hotel Zocodover Toledo',125),(26,'Burgos',3,'Hotel Mirador Burgos',92),(27,'San Sebastián',5,'Hotel Concha San Sebastian',210),(28,'Santiago de Compostela',4,'Hotel Catedral Santiago',130),(29,'Ciudad Real',3,'Hotel Calatrava Ciudad Real',78),(30,'Badajoz',3,'Hotel Alcazaba Badajoz',76),(31,'Cáceres',4,'Hotel Parque Caceres',110),(32,'Castellón de la Plana',3,'Hotel Playa Castellon',88),(33,'Tarragona',4,'Hotel Balcon Tarragona',120),(34,'Lleida',3,'Hotel Llevant Lleida',84),(35,'Girona',4,'Hotel Plaça Girona',118),(36,'Figueres',3,'Hotel Tramuntana Figueres',82),(37,'Reus',3,'Hotel Rambla Reus',80),(38,'Sitges',4,'Hotel Port Sitges',140),(39,'Benidorm',4,'Hotel Mediterrani Benidorm',150),(40,'Torremolinos',4,'Hotel Levante Torremolinos',135),(41,'Marbella',5,'Hotel Costa Marbella',220),(42,'Ronda',4,'Hotel Ronda Serrania',125),(43,'Antequera',3,'Hotel Alcazaba Antequera',79),(44,'Loja',3,'Hotel Sierra Loja',72),(45,'Motril',3,'Hotel Nazari Motril',78),(46,'Guadix',3,'Hotel Albayzin Guadix',70),(47,'Linares',3,'Hotel Vega Linares',74),(48,'Úbeda',4,'Hotel Olivo Ubeda',105),(49,'Baeza',4,'Hotel Renacimiento Baeza',108),(50,'Jerez de la Frontera',4,'Hotel Puente Jerez',120),(51,'Algeciras',3,'Hotel Azahar Algeciras',85),(52,'Tarifa',4,'Hotel Estrecho Tarifa',135),(53,'Estepona',4,'Hotel Alhambra Estepona',140),(54,'La Línea de la Concepción',3,'Hotel Penon Gibraltar La Linea',88),(55,'Priego de Córdoba',3,'Hotel Subbetica Priego',78),(56,'Lucena',3,'Hotel Sierra Lucena',76),(57,'Écija',3,'Hotel Campina Ecija',79),(58,'Sanlúcar de Barrameda',4,'Hotel Marismas Sanlucar',125),(59,'Utrera',3,'Hotel Arco Utrera',74),(60,'Dos Hermanas',3,'Hotel Triana Dos Hermanas',73),(61,'Mairena del Aljarafe',3,'Hotel Aljarafe Mairena',72),(62,'Alcalá de Guadaíra',3,'Hotel Hispalis Alcala',71),(63,'Minas de Riotinto',3,'Hotel Tinto Riotinto',70),(64,'Moguer',3,'Hotel Colombino Moguer',69),(65,'Aracena',4,'Hotel Zenit Aracena',110),(66,'Isla Cristina',4,'Hotel Costa Isla Cristina',120),(67,'Ayamonte',4,'Hotel Sal Marina Ayamonte',118),(68,'Mérida',4,'Hotel Guadiana Merida',115),(69,'Plasencia',3,'Hotel Tajo Plasencia',85),(70,'Navaconcejo',3,'Hotel Jerte Navaconcejo',75),(71,'Trujillo',4,'Hotel Trujillo Imperial',112),(72,'Segovia',4,'Hotel Serrallo Segovia',125),(73,'Ávila',4,'Hotel Muralla Avila',120),(74,'Zamora',3,'Hotel Duero Zamora',88),(75,'Lugo',3,'Hotel San Froilan Lugo',86),(76,'Ourense',3,'Hotel Silense Ourense',84),(77,'Pontevedra',3,'Hotel Miño Pontevedra',90),(78,'Ferrol',3,'Hotel Ferrolterra Ferrol',82),(79,'Viveiro',3,'Hotel Mariña Viveiro',80),(80,'Ribeira',3,'Hotel Ribeira Ribeira',78),(81,'Sanxenxo',4,'Hotel Rias Baixas Sanxenxo',135),(82,'Cangas',3,'Hotel Cies Cangas',88),(83,'Ribadesella',4,'Hotel Sella Ribadesella',130),(84,'Cangas de Onís',4,'Hotel Picos Cangas de Onis',125),(85,'Oviedo',4,'Hotel Naranco Oviedo',120),(86,'Avilés',3,'Hotel San Lorenzo Aviles',85),(87,'Ribadeo',3,'Hotel Eo Ribadeo',82),(88,'Reinosa',3,'Hotel Campoo Reinosa',78),(89,'Torrelavega',3,'Hotel Pasiegos Torrelavega',86),(90,'Laredo',4,'Hotel Costa Verde Laredo',128),(91,'Solares',3,'Hotel Peña Cabarga Solares',80),(92,'Gernika-Lumo',3,'Hotel Urdaibai Gernika',92),(93,'Vitoria-Gasteiz',4,'Hotel Gran Via Vitoria',130),(94,'Irún',3,'Hotel Bidasoa Irun',95),(95,'Eibar',3,'Hotel Easo Eibar',88),(96,'Barakaldo',3,'Hotel Nervion Barakaldo',90),(97,'Hondarribia',4,'Hotel Txingudi Hondarribia',145),(98,'Pamplona',4,'Hotel Iruña Pamplona',125),(99,'Estella-Lizarra',3,'Hotel Ega Estella',86),(100,'Tudela',3,'Hotel Ebro Tudela',84),(101,'Nájera',3,'Hotel Najerilla Najera',82),(102,'Logroño',4,'Hotel Laurel Logrono',115),(103,'Soria',3,'Hotel Moncayo Soria',78),(104,'Aranda de Duero',3,'Hotel Arlanza Aranda',88),(105,'Haro',4,'Hotel Rioja Haro',110),(106,'León',4,'Hotel Camino Leon',118),(107,'Benavente',3,'Hotel Tormes Benavente',76),(108,'Malaga',5,'Malaga Palacios',200),(110,'Malaga',3,'Hotel Don Curro Editado',110);
/*!40000 ALTER TABLE `hoteles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-13 14:09:08
