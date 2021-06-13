/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 8.0.16 : Database - teqtoms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `appuser` */

DROP TABLE IF EXISTS `appuser`;

CREATE TABLE `appuser` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `authtoken` varchar(1000) DEFAULT NULL,
  `usertype` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `appuser` */

insert  into `appuser`(`userid`,`username`,`password`,`name`,`authtoken`,`usertype`) values 
(1,'jaykrs@gmail.com','$2a$10$cimIT3g8QWDD8myqrKvUi.Gm4BLlKQyqEauJ7I3eDJsRDJkrAo0dS','Jayant Kumar','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXlrcnNAZ21haWwuY29tIiwiaXNzIjoiaHR0cDovL2p3dGRlbW8uY29tIiwiaWF0IjoxNjIyNzQ2NzMwLCJleHAiOjE2MjI3NDcwMzB9.Z7kRMyuygRuNXBJuaZMroMUckMhADg-jzsSdR0lo9ww','admin'),
(2,'jaykrs@hotmail.com','$2a$10$uflAb9xC2hb37UmMRJDbX.9vfeWPYoPBEAQRlGXeaLlMmYJK4hdY.','Jayant K','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXlrcnNAaG90bWFpbC5jb20iLCJpc3MiOiJodHRwOi8vand0ZGVtby5jb20iLCJpYXQiOjE2MjIxMzczNzMsImV4cCI6MTYyMjEzNzY3M30.kiIPjG3ZXwl8HIVxGB1uAMCo5grDQTy5NtzfUo3CE9Q',NULL);

/*Table structure for table `chapter` */

DROP TABLE IF EXISTS `chapter`;

CREATE TABLE `chapter` (
  `ID` bigint(10) NOT NULL AUTO_INCREMENT,
  `CHAPTER_TITLE` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `CHAPTER_BRIEF` text CHARACTER SET latin1 COLLATE latin1_swedish_ci,
  `UNIT_ID` int(10) NOT NULL,
  `CHAPTER_DURATION` int(10) NOT NULL,
  `CHAPTER_CONTENT` text CHARACTER SET latin1 COLLATE latin1_swedish_ci,
  `CHAPTER_TYPE` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `CHAPTER_RESOURCE` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `METADATA` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `CHAPTER_ORDER` int(5) DEFAULT NULL,
  `COURSE_ID` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `chapter` */

insert  into `chapter`(`ID`,`CHAPTER_TITLE`,`CHAPTER_BRIEF`,`UNIT_ID`,`CHAPTER_DURATION`,`CHAPTER_CONTENT`,`CHAPTER_TYPE`,`CHAPTER_RESOURCE`,`METADATA`,`CHAPTER_ORDER`,`COURSE_ID`) values 
(1,'Service Evaluation',NULL,1,12,NULL,'VIDEO','https://chap.ter/video?abc','History',0,0),
(2,'SOAP vs REST',NULL,1,5,NULL,'VIDEO','https://soap.eval','SOAP',1,0);

/*Table structure for table `consumer` */

DROP TABLE IF EXISTS `consumer`;

CREATE TABLE `consumer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `consumer` */

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `TITLE` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `KEYWORD` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION` text CHARACTER SET utf8 COLLATE utf8_bin,
  `CREATED_DATE` date DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` date DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `COURSE_TYPE` int(11) NOT NULL,
  `COURSE_MODERATOR` int(11) NOT NULL,
  `COURSE_FEE` int(11) NOT NULL,
  `COURSE_CURRENCY` int(11) NOT NULL,
  `COURSE_BASE_LANGUAGE` int(11) DEFAULT NULL,
  `COURSE_SECONDARY_LANGUAGE` int(11) DEFAULT NULL,
  `SUBSCRIPTION_COUNT` int(11) DEFAULT NULL,
  `SHARE_URL` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `COURSE_CATAGORY` int(11) DEFAULT NULL,
  `LIKE_USER_ID` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `COURSE_LOGO_PATH_SMALL` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `COURSE_LOGO_PATH_BIG` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `COURSE_INTRO_PATH` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `LIKE_COUNT` int(10) unsigned zerofill DEFAULT NULL,
  `COURSE_DISCOUNT_PC` int(11) DEFAULT NULL,
  `PUBLISH_STATUS` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0',
  `PUBLISH_DATE` date DEFAULT NULL,
  `ARTICLE_ID` int(20) unsigned zerofill DEFAULT NULL,
  `METAKEYWORDDESC` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `REQUIREMENT` text CHARACTER SET utf8 COLLATE utf8_bin,
  `AUDIANCE` tinyint(4) DEFAULT NULL,
  `COURSE_MODERATOR_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `APPROVAL_STATUS` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `course` */

insert  into `course`(`ID`,`NAME`,`TITLE`,`KEYWORD`,`DESCRIPTION`,`CREATED_DATE`,`CREATED_BY`,`MODIFIED_DATE`,`MODIFIED_BY`,`COURSE_TYPE`,`COURSE_MODERATOR`,`COURSE_FEE`,`COURSE_CURRENCY`,`COURSE_BASE_LANGUAGE`,`COURSE_SECONDARY_LANGUAGE`,`SUBSCRIPTION_COUNT`,`SHARE_URL`,`COURSE_CATAGORY`,`LIKE_USER_ID`,`COURSE_LOGO_PATH_SMALL`,`COURSE_LOGO_PATH_BIG`,`COURSE_INTRO_PATH`,`LIKE_COUNT`,`COURSE_DISCOUNT_PC`,`PUBLISH_STATUS`,`PUBLISH_DATE`,`ARTICLE_ID`,`METAKEYWORDDESC`,`REQUIREMENT`,`AUDIANCE`,`COURSE_MODERATOR_NAME`,`APPROVAL_STATUS`) values 
(1,'css','Learn CSS Fundamentals ...','','CSS is what makes the web beautiful. It describes how HTML should be displayed and how to layout elements. Take this class and get familiar with CSS!.',NULL,1,NULL,0,66,1,34,0,0,0,0,NULL,64,NULL,NULL,NULL,NULL,0000000000,5,0,NULL,00000000000000000000,'tsts','',86,'Jayant,Kumar',0),
(2,'Alfresco','Learn Alfresco Fundamentals ...','','Alfresco is what makes the CMS beautiful. It describes how HTML should be displayed and how to layout elements. Take this class and get familiar with CMS!.',NULL,1,NULL,0,66,1,52,0,0,0,0,NULL,64,NULL,NULL,NULL,NULL,0000000000,5,0,NULL,00000000000000000000,'alfresco','alfresco cms , dms',86,'Jayant,Kumar',0),
(3,'AEM Developer','Adobe Experience Manager','','AEM is a CMS/DAM tool for managing web content',NULL,1,NULL,0,66,1,6500,0,46,46,0,NULL,64,NULL,'https://j2s.net/wp-content/uploads/2017/09/Logo-AEM-1.jpg','https://j2s.net/wp-content/uploads/2017/09/Logo-AEM-1.jpg','https://www.youtube.com/watch?v=zA53zv0l-9I&list=PL2rn7ZBYpBjtPyy5-pEBxwwIowcIoVv40',0000000000,5,0,NULL,00000000000000000000,'AEM is cms tool','ANY CMS tool knowledge with Java background',86,'Jayant,Kumar',0),
(4,'Liferay','Learn Liferay','','CSS is what makes the web beautiful. It describes how HTML should be displayed and how to layout elements. Take this class and get familiar with CSS!.',NULL,1,NULL,0,67,1,7600,0,46,48,0,NULL,64,NULL,'https://j2s.net/wp-content/uploads/2017/09/Logo-AEM-1.jpg','https://j2s.net/wp-content/uploads/2017/09/Logo-AEM-1.jpg','https://www.youtube.com/watch?v=zA53zv0l-9I&list=PL2rn7ZBYpBjtPyy5-pEBxwwIowcIoVv40',0000000000,10,0,NULL,00000000000000000000,'Lifearay portal','Java',86,'Jayant,Kumar',0),
(5,'Java Micro Service','Micro service using java and spring boot','','CSS is what makes the web beautiful. It describes how HTML should be displayed and how to layout elements. Take this class and get familiar with CSS!.',NULL,1,NULL,0,68,1,7500,0,46,48,0,NULL,7,NULL,'https://j2s.net/wp-content/uploads/2017/09/Logo-AEM-1.jpg','https://j2s.net/wp-content/uploads/2017/09/Logo-AEM-1.jpg','https://www.youtube.com/watch?v=zA53zv0l-9I&list=PL2rn7ZBYpBjtPyy5-pEBxwwIowcIoVv40',0000000000,10,0,NULL,00000000000000000000,'Rest service using Java and spring boot with netflix eureka','Java Knowledge with Service concept',86,'Jayant,Kumar',0),
(6,'SHM','Simple Harmonic Motion','SHM','SHM Physics',NULL,1,NULL,0,68,1,1200,0,46,46,0,NULL,7,NULL,'https://j2s.net/wp-content/uploads/2017/09/Logo-AEM-1.jpg','https://j2s.net/wp-content/uploads/2017/09/Logo-AEM-1.jpg','https://www.youtube.com/watch?v=zA53zv0l-9I&list=PL2rn7ZBYpBjtPyy5-pEBxwwIowcIoVv40',0000000000,2,0,NULL,00000000000000000000,'Simple Harmonic Motion','Basic Physics ',83,'Jayant,Kumar',0),
(7,'OpentextWEM','OpenText Web Experience Management','Opentext WEM Vignette','Opentext WEM is Content management system for web experience from Opentext corp.',NULL,1,NULL,0,66,1,2300,0,46,48,0,NULL,7,NULL,'https://d1yjjnpx0p53s8.cloudfront.net/styles/logo-thumbnail/s3/0023/4621/brand.gif','https://d1yjjnpx0p53s8.cloudfront.net/styles/logo-thumbnail/s3/0023/4621/brand.gif','https://www.youtube.com/watch?v=iyDkLYlPKDk',0000000000,12,0,NULL,00000000000000000000,'Web exp management','IT background with CMS and programming exp',87,'Jayant,Kumar',0),
(8,'Apache-Streaming-with-Python-and-PySpark','Apache Streaming with Python and PySpark',NULL,'The office assistant wasthe boss’s man,spineless, and with no understanding. What about if he reported sick? But that would be extremely strained and suspicious as in fifteen years of service Gregor had never once yet been ill\r\n\r\nHis boss would certainly come round with the doctor from the medical insurance company, accuse his parents of having a lazy son, and accept the doctor’s recommendation not to make any claim as the doctor believed that no-one was ever ill but that many were workshy. And what’s more, would he have been entirely wrong in this case? Gregor did in fact, apart from excessive sleepiness after sleeping for so long, feel completely well and even felt much hungrier than usual.\r\n\r\nHe was still hurriedly thinking all this through, unable to decide to get out of the bed, when the clock struck quarter to seven. There was a cautious knock at the door near his head. Gregor, somebody called – it was his mother – it’s quarter to seven. Didn’t you want to go somewhere? That gentle voice, Gregor was shocked when he heard his own voice answering, it could hardly be recognised as the voice he had had before','2021-05-09',1,NULL,0,66,1,500,7,46,48,0,NULL,62,NULL,'https://bl3301files.storage.live.com/y4mYpdEDLGoj1nglkOVB7a1mTXEL1I_D-AJB0OA6AIFwH4ZpLDHXHEAop8Ga_5Uo8tRtwCcJGKSfN8lm98ByduYx0t-ce4cB4dTzEbSSeJImTNJILm21MZTNcRltjp709QTKnxe7HE1w35oO9tag6afum0co505dqWo','https://bl3301files.storage.live.com/y4mYpdEDLGoj1nglkOVB7a1mTXEL1I_D-AJB0OA6AIFwH4ZpLDHXHEAop8Ga_5Uo8tRtwCcJGKSfN8lm98ByduYx0t-ce4cB4dTzEbSSeJImTNJILm21MZTNcRltjp709QTKnxe7HE1w35oO9tag6afum0co505dqWo','https://www.youtube.com/watch?v=iyDkLYlPKDk',0000000000,199,70,NULL,00000000000000000000,NULL,'The office assistant wasthe boss’s man,spineless, and with no understanding. What about if he reported sick? But that would be extremely strained and suspicious as in fifteen years of service Gregor had never once yet been ill',87,'Jayant,Kumar',0),
(9,'Photoshop-for-Web-Design-Beginners','Photoshop for Web Design Beginners',NULL,'The office assistant wasthe boss’s man,spineless, and with no understanding. What about if he reported sick? But that would be extremely strained and suspicious as in fifteen years of service Gregor had never once yet been ill\r\n\r\nHis boss would certainly come round with the doctor from the medical insurance company, accuse his parents of having a lazy son, and accept the doctor’s recommendation not to make any claim as the doctor believed that no-one was ever ill but that many were workshy. And what’s more, would he have been entirely wrong in this case? Gregor did in fact, apart from excessive sleepiness after sleeping for so long, feel completely well and even felt much hungrier than usual.\r\n\r\nHe was still hurriedly thinking all this through, unable to decide to get out of the bed, when the clock struck quarter to seven. There was a cautious knock at the door near his head. Gregor, somebody called – it was his mother – it’s quarter to seven. Didn’t you want to go somewhere? That gentle voice, Gregor was shocked when he heard his own voice answering, it could hardly be recognised as the voice he had had before','2021-05-10',1,NULL,0,66,1,200,7,46,48,0,NULL,65,NULL,'https://j2s.net/wp-content/uploads/2017/09/Logo-AEM-1.jpg','https://d1yjjnpx0p53s8.cloudfront.net/styles/logo-thumbnail/s3/0023/4621/brand.gif','https://www.youtube.com/watch?v=iyDkLYlPKDk',0000000000,100,70,NULL,00000000000000000000,NULL,'His boss would certainly come round with the doctor from the medical insurance company, accuse his parents of having a lazy son, and accept the doctor’s recommendation not to make any claim as the doctor believed that no-one was ever ill but that many were workshy. And what’s more, would he have been entirely wrong in this case? Gregor did in fact, apart from excessive sleepiness after sleeping for so long, feel completely well and even felt much hungrier than usual.',86,'Jayant,Kumar',0),
(10,'python-web-programming','Python web programming',NULL,'We will cover the basic fundamentals of programming and you will learn how to do exciting things in Python, like reading and writing on files, like Excel sheets or TXT files, working with JSON and sending HTTP requests to web servers and APIs.\r\n\r\nWe will also cover a little bit of Data Visualization, Statistics and Machine Learning in Python.\r\n\r\nThis course does not require previous experience in IT or programming, it was designed to help any person learn to code. By the end of the course you will be writing you own programs and thinking like a programmer. Your professional life will get a huge upgrade.\r\n\r\nThis course offers life time access, a certificate of conclusion and a 30-day money back guarantee. Don\'t miss this opportunity! Enroll now and start learning Python!','2021-05-11',1,NULL,0,66,1,200,7,46,46,0,NULL,64,NULL,'https://j2s.net/wp-content/uploads/2017/09/Logo-AEM-1.jpg','https://d1yjjnpx0p53s8.cloudfront.net/styles/logo-thumbnail/s3/0023/4621/brand.gif','https://www.udemy.com/course/learn-python-programming-a-step-by-step-course-to-beginners/learn/lecture/12741079#overview',0000000000,1,70,NULL,00000000000000000000,NULL,'Python3 programming made easy with exercises, challenges and lots of real life examples. Learn to code today!',86,'Jayant,Kumar',0);

/*Table structure for table `unit` */

DROP TABLE IF EXISTS `unit`;

CREATE TABLE `unit` (
  `ID` bigint(10) NOT NULL AUTO_INCREMENT,
  `UNIT_TITLE` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `UNIT_BRIEF` text CHARACTER SET latin1 COLLATE latin1_swedish_ci,
  `COURSE_ID` bigint(10) NOT NULL,
  `METADATA` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `UNIT_DURATION` int(5) DEFAULT NULL,
  `INTRODUCTORY_VIDEO` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `CREATED_ON` date DEFAULT NULL,
  `ORDER_COUNT` int(5) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `unit` */

insert  into `unit`(`ID`,`UNIT_TITLE`,`UNIT_BRIEF`,`COURSE_ID`,`METADATA`,`UNIT_DURATION`,`INTRODUCTORY_VIDEO`,`CREATED_ON`,`ORDER_COUNT`) values 
(1,'Micro Service Fundamental','Basic Fundamental for Microservice and Introduction',5,'MicroService, API',45,NULL,'2021-06-02',0),
(2,'Micro Service Architecture','Architecture of Microservice and Framework',5,'Architecture of Service',43,NULL,'2021-06-02',1),
(3,'First Service API','Lets strat writing first API service',5,'API',25,NULL,'2021-06-02',2);

/*Table structure for table `vendor` */

DROP TABLE IF EXISTS `vendor`;

CREATE TABLE `vendor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `vendor` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
