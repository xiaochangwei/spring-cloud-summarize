/*
MySQL Backup
Source Server Version: 5.6.40
Source Database: xiaochangwei_summarize_02
Date: 2018/11/20 11:23:31
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
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_user_slave`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_slave`;
CREATE TABLE `t_user_slave` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `IDCard` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `bornDate` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `provinceCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK3gnw8ked1njfkfihwxn6yjq85` (`account`),
  UNIQUE KEY `UKmnswnjnsacu79gu05frljli01` (`IDCard`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_user` VALUES ('99','123456789012345678','slave','999','2018-11-20 09:57:24','123456','51');
INSERT INTO `t_user_slave` VALUES ('1','987456123','slave_jpa','99','2018-11-20 11:12:42','95623','52');
