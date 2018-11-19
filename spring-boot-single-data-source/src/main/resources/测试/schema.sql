/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : xiaochangwei_summarize_01

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2018-11-19 17:25:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '510121198709239851', '肖昌伟', '31', '1987-09-23 14:40:11', '123456', '51');
INSERT INTO `t_user` VALUES ('2', '510121198709239852', 'xiaogege', '20', '2018-11-19 14:55:39', '123456', '51');
INSERT INTO `t_user` VALUES ('3', '510121198709239853', 'xgg923', '8', '2018-11-19 14:56:04', '123456', '52');
INSERT INTO `t_user` VALUES ('4', '510121198709239854', 'changw.xiao@qq.com', '15', '2018-11-19 14:57:03', '123456', '52');
