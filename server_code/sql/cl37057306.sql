-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: cl37057306
-- ------------------------------------------------------
-- Server version	5.7.31

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
-- Current Database: `cl37057306`
--

/*!40000 DROP DATABASE IF EXISTS `cl37057306`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `cl37057306` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `cl37057306`;

--
-- Table structure for table `baoyangjilu`
--

DROP TABLE IF EXISTS `baoyangjilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baoyangjilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheliangtupian` longtext COMMENT '车辆图片',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `cheliangyanse` varchar(200) DEFAULT NULL COMMENT '车辆颜色',
  `baoyangxiangmu` varchar(200) NOT NULL COMMENT '保养项目',
  `baoyangshijian` date NOT NULL COMMENT '保养时间',
  `zhizuoriqi` date DEFAULT NULL COMMENT '制作日期',
  `baoyangrenyuan` varchar(200) NOT NULL COMMENT '保养人员',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='保养记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baoyangjilu`
--

LOCK TABLES `baoyangjilu` WRITE;
/*!40000 ALTER TABLE `baoyangjilu` DISABLE KEYS */;
INSERT INTO `baoyangjilu` VALUES (71,'2024-05-08 15:20:19','file/baoyangjiluCheliangtupian1.jpg,file/baoyangjiluCheliangtupian2.jpg,file/baoyangjiluCheliangtupian3.jpg','车牌号1','车辆颜色1','保养项目1','2024-05-08','2024-05-08','保养人员1','用户名1'),(72,'2024-05-08 15:20:19','file/baoyangjiluCheliangtupian2.jpg,file/baoyangjiluCheliangtupian3.jpg,file/baoyangjiluCheliangtupian4.jpg','车牌号2','车辆颜色2','保养项目2','2024-05-08','2024-05-08','保养人员2','用户名2'),(73,'2024-05-08 15:20:19','file/baoyangjiluCheliangtupian3.jpg,file/baoyangjiluCheliangtupian4.jpg,file/baoyangjiluCheliangtupian5.jpg','车牌号3','车辆颜色3','保养项目3','2024-05-08','2024-05-08','保养人员3','用户名3'),(74,'2024-05-08 15:20:19','file/baoyangjiluCheliangtupian4.jpg,file/baoyangjiluCheliangtupian5.jpg,file/baoyangjiluCheliangtupian6.jpg','车牌号4','车辆颜色4','保养项目4','2024-05-08','2024-05-08','保养人员4','用户名4'),(75,'2024-05-08 15:20:19','file/baoyangjiluCheliangtupian5.jpg,file/baoyangjiluCheliangtupian6.jpg,file/baoyangjiluCheliangtupian7.jpg','车牌号5','车辆颜色5','保养项目5','2024-05-08','2024-05-08','保养人员5','用户名5'),(76,'2024-05-08 15:20:19','file/baoyangjiluCheliangtupian6.jpg,file/baoyangjiluCheliangtupian7.jpg,file/baoyangjiluCheliangtupian8.jpg','车牌号6','车辆颜色6','保养项目6','2024-05-08','2024-05-08','保养人员6','用户名6');
/*!40000 ALTER TABLE `baoyangjilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheliangbaoxian`
--

DROP TABLE IF EXISTS `cheliangbaoxian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheliangbaoxian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheliangtupian` longtext COMMENT '车辆图片',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `baoxianleixing` varchar(200) DEFAULT NULL COMMENT '保险类型',
  `baodanhao` varchar(200) DEFAULT NULL COMMENT '保单号',
  `beibaoxianren` varchar(200) DEFAULT NULL COMMENT '被保险人',
  `shenfenzheng` varchar(200) NOT NULL COMMENT '身份证',
  `baoxianshengxiaoriqi` date DEFAULT NULL COMMENT '保险生效日期',
  `baoxianjiezhiriqi` date DEFAULT NULL COMMENT '保险截止日期',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='车辆保险';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheliangbaoxian`
--

LOCK TABLES `cheliangbaoxian` WRITE;
/*!40000 ALTER TABLE `cheliangbaoxian` DISABLE KEYS */;
INSERT INTO `cheliangbaoxian` VALUES (41,'2024-05-08 15:20:19','file/cheliangbaoxianCheliangtupian1.jpg,file/cheliangbaoxianCheliangtupian2.jpg,file/cheliangbaoxianCheliangtupian3.jpg','车牌号1','交强险','保单号1','被保险人1','身份证1','2024-05-08','2024-05-08','用户名1'),(42,'2024-05-08 15:20:19','file/cheliangbaoxianCheliangtupian2.jpg,file/cheliangbaoxianCheliangtupian3.jpg,file/cheliangbaoxianCheliangtupian4.jpg','车牌号2','交强险','保单号2','被保险人2','身份证2','2024-05-08','2024-05-08','用户名2'),(43,'2024-05-08 15:20:19','file/cheliangbaoxianCheliangtupian3.jpg,file/cheliangbaoxianCheliangtupian4.jpg,file/cheliangbaoxianCheliangtupian5.jpg','车牌号3','交强险','保单号3','被保险人3','身份证3','2024-05-08','2024-05-08','用户名3'),(44,'2024-05-08 15:20:19','file/cheliangbaoxianCheliangtupian4.jpg,file/cheliangbaoxianCheliangtupian5.jpg,file/cheliangbaoxianCheliangtupian6.jpg','车牌号4','交强险','保单号4','被保险人4','身份证4','2024-05-08','2024-05-08','用户名4'),(45,'2024-05-08 15:20:19','file/cheliangbaoxianCheliangtupian5.jpg,file/cheliangbaoxianCheliangtupian6.jpg,file/cheliangbaoxianCheliangtupian7.jpg','车牌号5','交强险','保单号5','被保险人5','身份证5','2024-05-08','2024-05-08','用户名5'),(46,'2024-05-08 15:20:19','file/cheliangbaoxianCheliangtupian6.jpg,file/cheliangbaoxianCheliangtupian7.jpg,file/cheliangbaoxianCheliangtupian8.jpg','车牌号6','交强险','保单号6','被保险人6','身份证6','2024-05-08','2024-05-08','用户名6');
/*!40000 ALTER TABLE `cheliangbaoxian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheliangweixiu`
--

DROP TABLE IF EXISTS `cheliangweixiu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheliangweixiu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheliangtupian` longtext COMMENT '车辆图片',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `cheliangyanse` varchar(200) DEFAULT NULL COMMENT '车辆颜色',
  `weixiubuwei` varchar(200) NOT NULL COMMENT '维修部位',
  `weixiushijian` date NOT NULL COMMENT '维修时间',
  `zhizaoriqi` date DEFAULT NULL COMMENT '制造日期',
  `baoyangrenyuan` varchar(200) NOT NULL COMMENT '保养人员',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='车辆维修';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheliangweixiu`
--

LOCK TABLES `cheliangweixiu` WRITE;
/*!40000 ALTER TABLE `cheliangweixiu` DISABLE KEYS */;
INSERT INTO `cheliangweixiu` VALUES (61,'2024-05-08 15:20:19','file/cheliangweixiuCheliangtupian1.jpg,file/cheliangweixiuCheliangtupian2.jpg,file/cheliangweixiuCheliangtupian3.jpg','车牌号1','车辆颜色1','维修部位1','2024-05-08','2024-05-08','保养人员1','用户名1'),(62,'2024-05-08 15:20:19','file/cheliangweixiuCheliangtupian2.jpg,file/cheliangweixiuCheliangtupian3.jpg,file/cheliangweixiuCheliangtupian4.jpg','车牌号2','车辆颜色2','维修部位2','2024-05-08','2024-05-08','保养人员2','用户名2'),(63,'2024-05-08 15:20:19','file/cheliangweixiuCheliangtupian3.jpg,file/cheliangweixiuCheliangtupian4.jpg,file/cheliangweixiuCheliangtupian5.jpg','车牌号3','车辆颜色3','维修部位3','2024-05-08','2024-05-08','保养人员3','用户名3'),(64,'2024-05-08 15:20:19','file/cheliangweixiuCheliangtupian4.jpg,file/cheliangweixiuCheliangtupian5.jpg,file/cheliangweixiuCheliangtupian6.jpg','车牌号4','车辆颜色4','维修部位4','2024-05-08','2024-05-08','保养人员4','用户名4'),(65,'2024-05-08 15:20:19','file/cheliangweixiuCheliangtupian5.jpg,file/cheliangweixiuCheliangtupian6.jpg,file/cheliangweixiuCheliangtupian7.jpg','车牌号5','车辆颜色5','维修部位5','2024-05-08','2024-05-08','保养人员5','用户名5'),(66,'2024-05-08 15:20:19','file/cheliangweixiuCheliangtupian6.jpg,file/cheliangweixiuCheliangtupian7.jpg,file/cheliangweixiuCheliangtupian8.jpg','车牌号6','车辆颜色6','维修部位6','2024-05-08','2024-05-08','保养人员6','用户名6');
/*!40000 ALTER TABLE `cheliangweixiu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheliangxinxi`
--

DROP TABLE IF EXISTS `cheliangxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheliangxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheliangtupian` longtext NOT NULL COMMENT '车辆图片',
  `chepaihao` varchar(200) NOT NULL COMMENT '车牌号',
  `qicheleixing` varchar(200) DEFAULT NULL COMMENT '汽车类型',
  `qichepinpai` varchar(200) NOT NULL COMMENT '汽车品牌',
  `cheliangyanse` varchar(200) NOT NULL COMMENT '车辆颜色',
  `donglidianchipinpai` varchar(200) NOT NULL COMMENT '动力电池品牌',
  `zhizaoriqi` date NOT NULL COMMENT '制造日期',
  `suoyouren` varchar(200) NOT NULL COMMENT '所有人',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='车辆信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheliangxinxi`
--

LOCK TABLES `cheliangxinxi` WRITE;
/*!40000 ALTER TABLE `cheliangxinxi` DISABLE KEYS */;
INSERT INTO `cheliangxinxi` VALUES (51,'2024-05-08 15:20:19','file/cheliangxinxiCheliangtupian1.jpg,file/cheliangxinxiCheliangtupian2.jpg,file/cheliangxinxiCheliangtupian3.jpg','车牌号1','混动汽车(HEV)','汽车品牌1','车辆颜色1','动力电池品牌1','2024-05-08','所有人1','用户名1'),(52,'2024-05-08 15:20:19','file/cheliangxinxiCheliangtupian2.jpg,file/cheliangxinxiCheliangtupian3.jpg,file/cheliangxinxiCheliangtupian4.jpg','车牌号2','混动汽车(HEV)','汽车品牌2','车辆颜色2','动力电池品牌2','2024-05-08','所有人2','用户名2'),(53,'2024-05-08 15:20:19','file/cheliangxinxiCheliangtupian3.jpg,file/cheliangxinxiCheliangtupian4.jpg,file/cheliangxinxiCheliangtupian5.jpg','车牌号3','混动汽车(HEV)','汽车品牌3','车辆颜色3','动力电池品牌3','2024-05-08','所有人3','用户名3'),(54,'2024-05-08 15:20:19','file/cheliangxinxiCheliangtupian4.jpg,file/cheliangxinxiCheliangtupian5.jpg,file/cheliangxinxiCheliangtupian6.jpg','车牌号4','混动汽车(HEV)','汽车品牌4','车辆颜色4','动力电池品牌4','2024-05-08','所有人4','用户名4'),(55,'2024-05-08 15:20:19','file/cheliangxinxiCheliangtupian5.jpg,file/cheliangxinxiCheliangtupian6.jpg,file/cheliangxinxiCheliangtupian7.jpg','车牌号5','混动汽车(HEV)','汽车品牌5','车辆颜色5','动力电池品牌5','2024-05-08','所有人5','用户名5'),(56,'2024-05-08 15:20:19','file/cheliangxinxiCheliangtupian6.jpg,file/cheliangxinxiCheliangtupian7.jpg,file/cheliangxinxiCheliangtupian8.jpg','车牌号6','混动汽车(HEV)','汽车品牌6','车辆颜色6','动力电池品牌6','2024-05-08','所有人6','用户名6');
/*!40000 ALTER TABLE `cheliangxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'swiper1','file/swiperPicture1.jpg'),(2,'swiper2','file/swiperPicture2.jpg'),(3,'swiper3','file/swiperPicture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dasandianxitongzhuangtai`
--

DROP TABLE IF EXISTS `dasandianxitongzhuangtai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dasandianxitongzhuangtai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheliangtupian` longtext COMMENT '车辆图片',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `qudongdianji` varchar(200) DEFAULT NULL COMMENT '驱动电机',
  `donglidianchi` varchar(200) DEFAULT NULL COMMENT '动力电池',
  `diankongxitong` varchar(200) DEFAULT NULL COMMENT '电控系统',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='大三电系统状态';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dasandianxitongzhuangtai`
--

LOCK TABLES `dasandianxitongzhuangtai` WRITE;
/*!40000 ALTER TABLE `dasandianxitongzhuangtai` DISABLE KEYS */;
INSERT INTO `dasandianxitongzhuangtai` VALUES (91,'2024-05-08 15:20:19','file/dasandianxitongzhuangtaiCheliangtupian1.jpg,file/dasandianxitongzhuangtaiCheliangtupian2.jpg,file/dasandianxitongzhuangtaiCheliangtupian3.jpg','车牌号1','良好','良好','良好','用户名1'),(92,'2024-05-08 15:20:19','file/dasandianxitongzhuangtaiCheliangtupian2.jpg,file/dasandianxitongzhuangtaiCheliangtupian3.jpg,file/dasandianxitongzhuangtaiCheliangtupian4.jpg','车牌号2','良好','良好','良好','用户名2'),(93,'2024-05-08 15:20:19','file/dasandianxitongzhuangtaiCheliangtupian3.jpg,file/dasandianxitongzhuangtaiCheliangtupian4.jpg,file/dasandianxitongzhuangtaiCheliangtupian5.jpg','车牌号3','良好','良好','良好','用户名3'),(94,'2024-05-08 15:20:19','file/dasandianxitongzhuangtaiCheliangtupian4.jpg,file/dasandianxitongzhuangtaiCheliangtupian5.jpg,file/dasandianxitongzhuangtaiCheliangtupian6.jpg','车牌号4','良好','良好','良好','用户名4'),(95,'2024-05-08 15:20:19','file/dasandianxitongzhuangtaiCheliangtupian5.jpg,file/dasandianxitongzhuangtaiCheliangtupian6.jpg,file/dasandianxitongzhuangtaiCheliangtupian7.jpg','车牌号5','良好','良好','良好','用户名5'),(96,'2024-05-08 15:20:19','file/dasandianxitongzhuangtaiCheliangtupian6.jpg,file/dasandianxitongzhuangtaiCheliangtupian7.jpg,file/dasandianxitongzhuangtaiCheliangtupian8.jpg','车牌号6','良好','良好','良好','用户名6');
/*!40000 ALTER TABLE `dasandianxitongzhuangtai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donglidianchixinxi`
--

DROP TABLE IF EXISTS `donglidianchixinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donglidianchixinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheliangtupian` longtext COMMENT '车辆图片',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `dianchidianliang` varchar(200) NOT NULL COMMENT '电池电量',
  `shengyurongliang` varchar(200) NOT NULL COMMENT '剩余容量',
  `dianya` varchar(200) NOT NULL COMMENT '电压',
  `xunhuancishu` varchar(200) NOT NULL COMMENT '循环次数',
  `dianchiwendu` varchar(200) NOT NULL COMMENT '电池温度',
  `chongdiandianliu` varchar(200) NOT NULL COMMENT '充电电流',
  `zuidachongdiandianliu` varchar(200) NOT NULL COMMENT '最大充电电流',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='动力电池信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donglidianchixinxi`
--

LOCK TABLES `donglidianchixinxi` WRITE;
/*!40000 ALTER TABLE `donglidianchixinxi` DISABLE KEYS */;
INSERT INTO `donglidianchixinxi` VALUES (81,'2024-05-08 15:20:19','file/donglidianchixinxiCheliangtupian1.jpg,file/donglidianchixinxiCheliangtupian2.jpg,file/donglidianchixinxiCheliangtupian3.jpg','车牌号1','电池电量1','剩余容量1','电压1','循环次数1','电池温度1','充电电流1','最大充电电流1','用户名1'),(82,'2024-05-08 15:20:19','file/donglidianchixinxiCheliangtupian2.jpg,file/donglidianchixinxiCheliangtupian3.jpg,file/donglidianchixinxiCheliangtupian4.jpg','车牌号2','电池电量2','剩余容量2','电压2','循环次数2','电池温度2','充电电流2','最大充电电流2','用户名2'),(83,'2024-05-08 15:20:19','file/donglidianchixinxiCheliangtupian3.jpg,file/donglidianchixinxiCheliangtupian4.jpg,file/donglidianchixinxiCheliangtupian5.jpg','车牌号3','电池电量3','剩余容量3','电压3','循环次数3','电池温度3','充电电流3','最大充电电流3','用户名3'),(84,'2024-05-08 15:20:19','file/donglidianchixinxiCheliangtupian4.jpg,file/donglidianchixinxiCheliangtupian5.jpg,file/donglidianchixinxiCheliangtupian6.jpg','车牌号4','电池电量4','剩余容量4','电压4','循环次数4','电池温度4','充电电流4','最大充电电流4','用户名4'),(85,'2024-05-08 15:20:19','file/donglidianchixinxiCheliangtupian5.jpg,file/donglidianchixinxiCheliangtupian6.jpg,file/donglidianchixinxiCheliangtupian7.jpg','车牌号5','电池电量5','剩余容量5','电压5','循环次数5','电池温度5','充电电流5','最大充电电流5','用户名5'),(86,'2024-05-08 15:20:19','file/donglidianchixinxiCheliangtupian6.jpg,file/donglidianchixinxiCheliangtupian7.jpg,file/donglidianchixinxiCheliangtupian8.jpg','车牌号6','电池电量6','剩余容量6','电压6','循环次数6','电池温度6','充电电流6','最大充电电流6','用户名6');
/*!40000 ALTER TABLE `donglidianchixinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext COMMENT '菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2024-05-08 15:20:19','[{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"新闻资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"fontClass\":\"icon-common13\",\"menu\":\"新闻资讯管理\",\"unicode\":\"&#xedf7;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"小三电系统状态\",\"menuJump\":\"列表\",\"tableName\":\"xiaosandianxitongzhuangtai\"}],\"fontClass\":\"icon-common35\",\"menu\":\"小三电系统状态管理\",\"unicode\":\"&#xee8c;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"大三电系统状态\",\"menuJump\":\"列表\",\"tableName\":\"dasandianxitongzhuangtai\"}],\"fontClass\":\"icon-common4\",\"menu\":\"大三电系统状态管理\",\"unicode\":\"&#xedab;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"动力电池信息\",\"menuJump\":\"列表\",\"tableName\":\"donglidianchixinxi\"}],\"fontClass\":\"icon-common45\",\"menu\":\"动力电池信息管理\",\"unicode\":\"&#xef3b;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"保养记录\",\"menuJump\":\"列表\",\"tableName\":\"baoyangjilu\"}],\"fontClass\":\"icon-common37\",\"menu\":\"保养记录管理\",\"unicode\":\"&#xeea4;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"车辆维修\",\"menuJump\":\"列表\",\"tableName\":\"cheliangweixiu\"}],\"fontClass\":\"icon-common36\",\"menu\":\"车辆维修管理\",\"unicode\":\"&#xee9f;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"车辆保险\",\"menuJump\":\"列表\",\"tableName\":\"cheliangbaoxian\"}],\"fontClass\":\"icon-common48\",\"menu\":\"车辆保险管理\",\"unicode\":\"&#xef65;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-list\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"车辆信息\",\"menuJump\":\"列表\",\"tableName\":\"cheliangxinxi\"}],\"fontClass\":\"icon-common8\",\"menu\":\"车辆信息管理\",\"unicode\":\"&#xedb6;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-qrcode\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"用户\",\"menuJump\":\"列表\",\"tableName\":\"yonghu\"}],\"fontClass\":\"icon-common1\",\"menu\":\"用户管理\",\"unicode\":\"&#xeda3;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-full\",\"buttons\":[\"查看\",\"修改\"],\"menu\":\"轮播图\",\"menuJump\":\"列表\",\"tableName\":\"config\"}],\"fontClass\":\"icon-common45\",\"menu\":\"轮播图管理\",\"unicode\":\"&#xef3b;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"查看\"],\"menu\":\"新闻资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"新闻资讯管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"小三电系统状态\",\"menuJump\":\"列表\",\"tableName\":\"xiaosandianxitongzhuangtai\"}],\"fontClass\":\"icon-common35\",\"menu\":\"小三电系统状态管理\",\"unicode\":\"&#xee8c;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"大三电系统状态\",\"menuJump\":\"列表\",\"tableName\":\"dasandianxitongzhuangtai\"}],\"fontClass\":\"icon-common4\",\"menu\":\"大三电系统状态管理\",\"unicode\":\"&#xedab;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"动力电池信息\",\"menuJump\":\"列表\",\"tableName\":\"donglidianchixinxi\"}],\"fontClass\":\"icon-common45\",\"menu\":\"动力电池信息管理\",\"unicode\":\"&#xef3b;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"保养记录\",\"menuJump\":\"列表\",\"tableName\":\"baoyangjilu\"}],\"fontClass\":\"icon-common37\",\"menu\":\"保养记录管理\",\"unicode\":\"&#xeea4;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"车辆维修\",\"menuJump\":\"列表\",\"tableName\":\"cheliangweixiu\"}],\"fontClass\":\"icon-common36\",\"menu\":\"车辆维修管理\",\"unicode\":\"&#xee9f;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"车辆保险\",\"menuJump\":\"列表\",\"tableName\":\"cheliangbaoxian\"}],\"fontClass\":\"icon-common48\",\"menu\":\"车辆保险管理\",\"unicode\":\"&#xef65;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-list\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"车辆保险\",\"车辆维修\",\"保养记录\",\"动力电池信息\",\"大三电系统状态\",\"小三电系统状态\"],\"menu\":\"车辆信息\",\"menuJump\":\"列表\",\"tableName\":\"cheliangxinxi\"}],\"fontClass\":\"icon-common8\",\"menu\":\"车辆信息管理\",\"unicode\":\"&#xedb6;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"查看\"],\"menu\":\"新闻资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"新闻资讯管理\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"roleName\":\"用户\",\"tableName\":\"yonghu\"}]');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `introduction` longtext COMMENT '简介',
  `picture` longtext NOT NULL COMMENT '图片',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COMMENT='新闻资讯';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (111,'2024-05-08 15:20:19','青花瓷','素胚勾勒出青花笔锋浓转淡，瓶身描绘的牡丹一如你初妆，冉冉檀香透过窗心事我了然，宣上走笔至此搁一半，釉色渲染仕女图韵味被私藏，而你嫣然的一笑如含苞待放，你的美缕飘散，去到我去不了的地方，天青色等烟雨 而我在等你，炊烟袅袅升起','file/newsPicture1.jpg','素胚勾勒出青花笔锋浓转淡，瓶身描绘的牡丹一如你初妆，冉冉檀香透过窗心事我了然，宣上走笔至此搁一半，釉色渲染仕女图韵味被私藏，而你嫣然的一笑如含苞待放，你的美缕飘散，去到我去不了的地方，天青色等烟雨 而我在等你，炊烟袅袅升起， 隔江千万里，在瓶底书前朝的飘逸，就当我为遇见你伏笔，天青色等烟雨， 而我在等你，月色被打捞起， 晕开了局，如传世的青花瓷自顾自美丽，你眼带笑意，色白花青的锦鲤跃然于碗底，临摹宋体落款时却惦记着你，你隐藏在窑烧里千年的秘密，极细腻犹如绣花针落地，帘外芭蕉惹骤雨门环惹铜绿，而我路过那江南小镇惹了你，在泼墨山水画里，你从墨色深处被隐去，天青色等烟雨 ，而我在等你，炊烟袅袅升起 ，隔江千万里，在瓶底书汉隶仿前朝的飘逸，就当我为遇见你伏笔，天色等烟雨 ，而我在等你，月色被打捞起， 晕开了结局，如传世的青花瓷自顾自美丽，你眼带笑意，天青色等烟雨 ，而我在等你，炊烟袅袅升起 ，隔江千万里，在瓶底书汉隶仿前朝的飘逸，就当我为遇见你伏笔，天青色等烟雨， 而我在等你，月色被打捞起 ，晕开了结局，如传世的青花瓷自顾自美丽，你眼带笑意。'),(112,'2024-05-08 15:20:19','理想三旬','雨后有车驶来，驶过暮色苍白，旧铁皮往南开，恋人已不在，收听浓烟下的，诗歌电台，不动情的咳嗽，至少看起来，归途也还可爱，琴弦少了姿态，再不见那夜里，听歌的小孩，时光匆匆独白，将颠沛磨成卡带，已枯倦的情怀，踏碎成年代，就老去吧，孤独别醒来，你渴望的离开，只是无处停摆，就歌唱吧，眼睛眯起来，而热泪的崩坏，只是没抵达的存在','file/newsPicture2.jpg','雨后有车驶来，驶过暮色苍白，旧铁皮往南开，恋人已不在，收听浓烟下的，诗歌电台，不动情的咳嗽，至少看起来，归途也还可爱，琴弦少了姿态，再不见那夜里，听歌的小孩，时光匆匆独白，将颠沛磨成卡带，已枯倦的情怀，踏碎成年代，就老去吧，孤独别醒来，你渴望的离开，只是无处停摆，就歌唱吧，眼睛眯起来，而热泪的崩坏，只是没抵达的存在，青春又醉倒在，籍籍无名的怀，靠嬉笑来虚度，聚散得慷慨，辗转却去不到，对的站台，如果漂泊是成长，必经的路牌，你迷醒岁月中，那贫瘠的未来，像遗憾季节里，未结果的爱，弄脏了每一页诗，吻最疼痛的告白，而风声吹到这，已不需要释怀，就老去吧，孤独别醒来，渴望的离开只是无处停摆就歌唱吧，眼睛眯起来而热泪的崩坏，只是没抵达的存在，就甜蜜地忍耐，繁星润湿窗台，光影跳动着像在，困倦里说爱，再无谓的感慨，以为明白，梦倒塌的地方，今已爬满青苔。'),(113,'2024-05-08 15:20:19','七里香','窗外的麻雀在电线杆上多嘴，你说这一句很有夏天的感觉，手中的铅笔在纸上来来回回，我用几行字形容你是我的谁，秋刀鱼的滋味猫跟你都想了解，初恋的香味就这样被我们寻回，那温暖的阳光像刚摘的鲜艳草莓，你说你舍不得吃掉这一种感觉，雨下整夜我的爱溢出就像雨水，院子落叶跟我的思念厚厚一叠','file/newsPicture3.jpg','窗外的麻雀在电线杆上多嘴，你说这一句很有夏天的感觉，手中的铅笔在纸上来来回回，我用几行字形容你是我的谁，秋刀鱼的滋味猫跟你都想了解，初恋的香味就这样被我们寻回，那温暖的阳光像刚摘的鲜艳草莓，你说你舍不得吃掉这一种感觉，雨下整夜我的爱溢出就像雨水，院子落叶跟我的思念厚厚一叠，几句是非也无法将我的热情冷却，你出现在我诗的每一页，雨下整夜我的爱溢出就像雨水，窗台蝴蝶像诗里纷飞的美丽章节，我接着写，把永远爱你写进诗的结尾，你是我唯一想要的了解，雨下整夜我的爱溢出就像雨水，院子落叶跟我的思念厚厚一叠，几句是非也无法将我的热情冷却，你出现在我诗的每一页，那饱满的稻穗幸福了这个季节，而你的脸颊像田里熟透的番茄，你突然对我说七里香的名字很美，我此刻却只想亲吻你倔强的嘴，雨下整夜我的爱溢出就像雨水，院子落叶跟我的思念厚厚一叠，几句是非也无法将我的热情冷却，你出现在我诗的每一页，整夜我的爱溢出就像雨水，窗台蝴蝶像诗里纷飞的美丽章节，我接着写，把永远爱你写进诗的结尾，是我唯一想要的了解。'),(114,'2024-05-08 15:20:19','江南','风到这里就是粘，粘住过客的思念，雨到了这里缠成线，缠着我们流连人世间，你在身边就是缘，缘分写在三生石上面，爱有万分之一甜，宁愿我就葬在这一点，圈圈圆圆圈圈，天天年年天天的我，深深看你的脸，生气的温柔，埋怨的温柔的脸','file/newsPicture4.jpg','风到这里就是粘，粘住过客的思念，雨到了这里缠成线，缠着我们流连人世间，你在身边就是缘，缘分写在三生石上面，爱有万分之一甜，宁愿我就葬在这一点，圈圈圆圆圈圈，天天年年天天的我，深深看你的脸，生气的温柔，埋怨的温柔的脸，不懂爱恨情愁煎熬的我们，都以为相爱就像风云的善变，相信爱一天抵过永远，在这一刹那冻结了时间，不懂怎么表现温柔的我们，还以为殉情只是古老的传言，离愁能有多痛痛有多浓，当梦被埋在江南烟雨中，心碎了才懂，圈圈圆圆圈圈，天天年年天天的我，深深看你的脸，生气的温柔，埋怨的温柔的脸，不懂爱恨情愁煎熬的我们，都以为相爱就像风云的善变，相信爱一天 抵过永远，在这一刹那冻结了时间，不懂怎么表现温柔的我们，还以为殉情只是古老的传言，离愁能有多痛 痛有多浓，当梦被埋在江南烟雨中，心碎了才懂，相信爱一天抵过永远。在这一刹那冻结了时间，不懂怎么表现温柔的我们，还以为殉情只是古老的传言，离愁能有多痛 痛有多浓，当梦被埋在江南烟雨中，心碎了才懂。'),(115,'2024-05-08 15:20:19','那些你很冒险的梦','当两颗心开始震动，当你瞳孔学会闪躲，当爱慢慢被遮住只剩下黑，距离像影子被拉拖，当爱的故事剩听说，我找不到你单纯的面孔，当生命每分每秒都为你转动，心多执着就加倍心痛，那些你很冒险的梦， 我陪你去疯，折纸飞机碰到雨天终究会坠落','file/newsPicture5.jpg','当两颗心开始震动，当你瞳孔学会闪躲，当爱慢慢被遮住只剩下黑，距离像影子被拉拖，当爱的故事剩听说，我找不到你单纯的面孔，当生命每分每秒都为你转动，心多执着就加倍心痛，那些你很冒险的梦， 我陪你去疯，折纸飞机碰到雨天终究会坠落，太残忍的话我直说 因为爱很重，你却不想懂 只往反方向走，当爱的故事剩听说，我找不到你单纯的面孔，当生命每分每秒都为你转动，心有多执着就加倍心痛，那些你很冒险的梦 我陪你去疯，折纸飞机 碰到雨天 终究会坠落，太残忍的话我直说 因为爱很重，你却不想懂 只往反方向走，我不想放手 你松开的左手，你爱的放纵 我白不回天空，我输了 累了，但你再也 不回头，那些你很冒险的梦 我陪你去疯，折纸飞机 碰到雨天 终究会坠落，太残忍的话我直说 因为爱很重，你却不想懂 只往反方向走，你真的不懂 我的爱已降落。'),(116,'2024-05-08 15:20:19','孤勇者','都，是勇敢的，你额头的伤口 你的 不同 你犯的错，都 不必隐藏，你破旧的玩偶 你的 面具 你的自我，他们说 要带着光 驯服每一头怪兽，他们说 要缝好你的伤，没有人爱小丑 为何孤独 不可 光荣，人只有不完美 值得歌颂，谁说污泥满身的不算英雄，爱你孤身走暗巷，爱你不跪的模样，爱你对峙过绝望','file/newsPicture6.jpg','都，是勇敢的，你额头的伤口 你的 不同 你犯的错，都 不必隐藏，你破旧的玩偶 你的 面具 你的自我，他们说 要带着光 驯服每一头怪兽，他们说 要缝好你的伤，没有人爱小丑 为何孤独 不可 光荣，人只有不完美 值得歌颂，谁说污泥满身的不算英雄，爱你孤身走暗巷，爱你不跪的模样，爱你对峙过绝望，不肯哭一场，爱你破烂的衣裳，却敢堵命运的枪，爱你和我那么像，缺口都一样，去吗 配吗 这褴褛的披风，战吗 战啊 以最卑微的梦，致那黑夜中的呜咽与怒吼，谁说站在光里的才算英雄，他们说 要戒了你的狂，就像擦掉了污垢，他们说 要顺台阶而上，而代价是低头，那就让我 不可 乘风，你一样骄傲着 那种孤勇，谁说对弈平凡的不算英雄，爱你孤身走暗巷 爱你不跪的模样，爱你对峙过绝望 不肯哭一场，爱你破烂的衣裳 却敢堵命运的枪，爱你和我那么像 缺口都一样，去吗 配吗 这褴褛的披风，战吗 战啊 以最卑微的梦，致那黑夜中的呜咽与怒吼，谁说站在光里的才算英雄，你的斑驳 与众不同 与众不同，你的沉默 震耳欲聋 震耳欲聋，You Are The Hero，爱你孤身走暗巷 爱你不跪的模样，爱你对峙过绝望 不肯哭一场，爱你来自于蛮荒 一生不借谁的光，你将造你的城邦 在废墟之上，去吗 去啊 以最卑微的梦，战吗 战啊 以最孤高的梦，致那黑夜中的呜咽与怒吼，谁说站在光里的才算英雄。');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) NOT NULL COMMENT '用户名',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `role` varchar(200) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2024-05-08 15:20:19','admin','admin','管理员');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiaosandianxitongzhuangtai`
--

DROP TABLE IF EXISTS `xiaosandianxitongzhuangtai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xiaosandianxitongzhuangtai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheliangtupian` longtext COMMENT '车辆图片',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `zhuanxiangzhuli` varchar(200) DEFAULT NULL COMMENT '转向助力',
  `diandongkongdiao` varchar(200) DEFAULT NULL COMMENT '电动空调',
  `chachezhuli` varchar(200) DEFAULT NULL COMMENT '刹车助力',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 COMMENT='小三电系统状态';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiaosandianxitongzhuangtai`
--

LOCK TABLES `xiaosandianxitongzhuangtai` WRITE;
/*!40000 ALTER TABLE `xiaosandianxitongzhuangtai` DISABLE KEYS */;
INSERT INTO `xiaosandianxitongzhuangtai` VALUES (101,'2024-05-08 15:20:19','file/xiaosandianxitongzhuangtaiCheliangtupian1.jpg,file/xiaosandianxitongzhuangtaiCheliangtupian2.jpg,file/xiaosandianxitongzhuangtaiCheliangtupian3.jpg','车牌号1','良好','良好','良好','用户名1'),(102,'2024-05-08 15:20:19','file/xiaosandianxitongzhuangtaiCheliangtupian2.jpg,file/xiaosandianxitongzhuangtaiCheliangtupian3.jpg,file/xiaosandianxitongzhuangtaiCheliangtupian4.jpg','车牌号2','良好','良好','良好','用户名2'),(103,'2024-05-08 15:20:19','file/xiaosandianxitongzhuangtaiCheliangtupian3.jpg,file/xiaosandianxitongzhuangtaiCheliangtupian4.jpg,file/xiaosandianxitongzhuangtaiCheliangtupian5.jpg','车牌号3','良好','良好','良好','用户名3'),(104,'2024-05-08 15:20:19','file/xiaosandianxitongzhuangtaiCheliangtupian4.jpg,file/xiaosandianxitongzhuangtaiCheliangtupian5.jpg,file/xiaosandianxitongzhuangtaiCheliangtupian6.jpg','车牌号4','良好','良好','良好','用户名4'),(105,'2024-05-08 15:20:19','file/xiaosandianxitongzhuangtaiCheliangtupian5.jpg,file/xiaosandianxitongzhuangtaiCheliangtupian6.jpg,file/xiaosandianxitongzhuangtaiCheliangtupian7.jpg','车牌号5','良好','良好','良好','用户名5'),(106,'2024-05-08 15:20:19','file/xiaosandianxitongzhuangtaiCheliangtupian6.jpg,file/xiaosandianxitongzhuangtaiCheliangtupian7.jpg,file/xiaosandianxitongzhuangtaiCheliangtupian8.jpg','车牌号6','良好','良好','良好','用户名6');
/*!40000 ALTER TABLE `xiaosandianxitongzhuangtai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuming` varchar(200) NOT NULL COMMENT '用户名',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shengri` date NOT NULL COMMENT '生日',
  `shenfenzheng` varchar(200) NOT NULL COMMENT '身份证',
  `shouji` varchar(200) NOT NULL COMMENT '手机',
  `touxiang` longtext COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yonghuming` (`yonghuming`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (31,'2024-05-08 15:20:19','用户名1','123456','姓名1','男','2024-05-08','441622200101010001','19819881111','file/yonghuTouxiang1.jpg'),(32,'2024-05-08 15:20:19','用户名2','123456','姓名2','男','2024-05-08','441622200202020002','19819881112','file/yonghuTouxiang2.jpg'),(33,'2024-05-08 15:20:19','用户名3','123456','姓名3','男','2024-05-08','441622200303030003','19819881113','file/yonghuTouxiang3.jpg'),(34,'2024-05-08 15:20:19','用户名4','123456','姓名4','男','2024-05-08','441622200404040004','19819881114','file/yonghuTouxiang4.jpg'),(35,'2024-05-08 15:20:19','用户名5','123456','姓名5','男','2024-05-08','441622200505050005','19819881115','file/yonghuTouxiang5.jpg'),(36,'2024-05-08 15:20:19','用户名6','123456','姓名6','男','2024-05-08','441622200606060006','19819881116','file/yonghuTouxiang6.jpg');
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-12 15:51:56
