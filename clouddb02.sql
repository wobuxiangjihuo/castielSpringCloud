Skip to content
Why GitHub?
Enterprise
Explore
Marketplace
Pricing

Search

Sign in
Sign up
Code  Issues 0  Pull requests 0  Projects 0  Security  Pulse
Join GitHub today
GitHub is home to over 40 million developers working together to host and review code, manage projects, and build software together.

microservicecloud/clouddb02.sql
@ZeroVV ZeroVV db sql!
acfe25e on 27 Jan
35 lines (29 sloc)  980 Bytes

/*
Navicat MySQL Data Transfer
Source Server         : mysql
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : clouddb02
Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001
Date: 2019-01-27 02:17:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` bigint(20) NOT NULL AUTO_INCREMENT,
  `dname` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '人事部', 'clouddb02');
INSERT INTO `dept` VALUES ('2', '财务部', 'clouddb02');
INSERT INTO `dept` VALUES ('3', '市场部', 'clouddb02');
INSERT INTO `dept` VALUES ('4', '运维部', 'clouddb02');

