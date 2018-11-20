/*
MySQL Backup
Source Server Version: 5.6.40
Source Database: xiaochangwei_summarize_01
Date: 2018/11/20 11:23:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idcard` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `born_date` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `province_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkh3p75uuyexsq7d6wb0gysukh` (`account`),
  UNIQUE KEY `UKem5ffiesyxpmytxdhebnr4kt0` (`idcard`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_user2`
-- ----------------------------
DROP TABLE IF EXISTS `t_user2`;
CREATE TABLE `t_user2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idcard` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `born_date` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `province_code` varchar(255) DEFAULT NULL,
  `test` varchar(255) DEFAULT NULL,
  `test_str` varchar(255) DEFAULT NULL,
  `test_str2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK2r3xsme7aoomxqed6wbtnljfs` (`account`),
  UNIQUE KEY `UKbfituaudq3kn2gkqdrgrso3a7` (`idcard`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_user_master`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_master`;
CREATE TABLE `t_user_master` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `IDCard` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `bornDate` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `provinceCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKod0s38e88timk0qmuxgwnbtfr` (`account`),
  UNIQUE KEY `UKqjlbqujdg570de7p6j00b3ijr` (`IDCard`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_user` VALUES ('1','510121198709239851','肖昌伟','31','1987-09-23 14:40:11','123456','51'), ('2','510121198709239852','xiaogege','20','2018-11-19 14:55:39','123456','51'), ('3','510121198709239853','xgg923','8','2018-11-19 14:56:04','123456','52'), ('4','510121198709239854','changw.xiao@qq.com','15','2018-11-19 14:57:03','123456','52'), ('15','510121198709239855','master','19','2018-11-20 09:54:58','123456','51');
INSERT INTO `t_user2` VALUES ('1',NULL,'trasactional','0','2018-11-19 07:16:33',NULL,NULL,NULL,NULL,NULL);
INSERT INTO `t_user_master` VALUES ('1','123456789','master_jpa','44','2018-11-20 11:12:13','456789','12');
