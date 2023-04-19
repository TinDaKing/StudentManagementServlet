-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: studentmanagement
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `lecturer` varchar(50) NOT NULL,
  `year` year NOT NULL,
  `note` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Cau truc du lieu & giai thuat','Nghia',2022,NULL),(2,'Lap trinh huong doi tuong','Khiet',2022,NULL),(3,'Yeu cau phan mem','Vu',2023,NULL),(4,'Phan tich va quan ly yeu cau phan mem','Vu',2023,''),(5,'Chu nghia Mac Lenin','Thanh',2021,NULL),(6,'Toan cao cap','Hong',2023,NULL),(7,'Toan ung dung va thong ke','Hang',2023,'mon tu chon'),(8,'Lap trinh ung dung Java','Khiet',2023,''),(10,'Nhap mon lap trinh','Thinh',2020,''),(11,'Ky thuat lap trinh','Dung',2021,''),(12,'mon hoc moi','Tin',2023,'');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `grade` double unsigned NOT NULL,
  `birthday` date NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `student_id_UNIQUE` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Tran Hoang Tin dep trai',9.98,'2002-07-29','989 Quang Trung, Go Vap, HCM','very good'),(2,'Pham Tran Gia Phu',8.3,'2002-03-31','34 Ta Quang Buu, quan 8, HCM','nice'),(4,'Nguyen Minh Tri',8.2,'2002-04-29','20/3 Pham Van Bach, Go Vap, HCM','nice'),(5,'Tin dep trai',9,'2002-07-03','720 Nguyen Oanh, Go Vap, HCM','very good'),(6,'Dang Thien Loc',7.8,'2002-11-02','32/5/3 Nguyen Van Nghi, Go Vap, HCM','not very well'),(7,'Minh Quan',9.5,'2002-08-23','31/53 Nguyen Kiem, Phu Nhuan, HCM','great'),(8,'Uyen Linh',8.6,'2002-04-03','23 Nguyen Thai Son, Go Vap, HCM','nice'),(9,'Sang heo',8.1,'2002-05-30','18/14/3 Thong Nhat, Go Vap, HCM','nice'),(10,'Hoan de',8.75,'2002-01-01','243/12 Pham Van Chieu, Go Vap, HCM','nice'),(11,'Vinh vat vo',8.3,'2002-06-22','603/24 Quang Trung, Go Vap, HCM','nice'),(12,'Long Monash',9.85,'2002-03-22','220/25 Nguyen Van Khoi, Go Vap, HCM','great'),(15,'TinDaKing',8.56,'2002-07-01','Quang Trung, 1024','nice');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentcourse`
--

DROP TABLE IF EXISTS `studentcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentcourse` (
  `student_id` int NOT NULL,
  `class_id` int NOT NULL,
  PRIMARY KEY (`student_id`,`class_id`),
  KEY `Student_in_course_idx` (`class_id`),
  CONSTRAINT `Course_have_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `Student_in_course` FOREIGN KEY (`class_id`) REFERENCES `course` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentcourse`
--

LOCK TABLES `studentcourse` WRITE;
/*!40000 ALTER TABLE `studentcourse` DISABLE KEYS */;
INSERT INTO `studentcourse` VALUES (1,1),(5,2),(7,2),(5,3),(1,4),(4,4),(7,4),(9,4),(12,4),(15,4),(5,6),(6,6),(5,10),(9,10);
/*!40000 ALTER TABLE `studentcourse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-19 18:30:48
