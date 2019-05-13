
DROP database IF EXISTS `mybatis`;

create database springboot_master;

use springboot_master;

-- ----------------------------
-- 多对多 通过中间表建立联系
-- ----------------------------

DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
`classId` bigint(20) NOT NULL AUTO_INCREMENT,
`className` varchar(30) DEFAULT NULL,
PRIMARY KEY (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
`studentId` bigint(20) NOT NULL AUTO_INCREMENT,
`studentName` varchar(15) DEFAULT NULL,
PRIMARY KEY (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for student_class
-- ----------------------------

DROP TABLE IF EXISTS `student_class`;
CREATE TABLE `student_class` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`classId` bigint(20) DEFAULT NULL,
`studentId` bigint(20) DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `FK_Reference_3` (`classId`),
KEY `FK_Reference_4` (`studentId`),
CONSTRAINT `FK_Reference_3` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `FK_Reference_4` FOREIGN KEY (`classId`) REFERENCES `class` (`classId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;


-- ----------------------------
-- 一对多  在多的里面设置一的主键
-- ----------------------------

-- ----------------------------
-- Table structure for Company
-- ----------------------------
DROP TABLE IF EXISTS `Company`;
CREATE TABLE `Company` (
`companyId` bigint(20) NOT NULL AUTO_INCREMENT,
`companyName` varchar(15) DEFAULT NULL,
PRIMARY KEY (`companyId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of Company
-- ----------------------------


-- ----------------------------
-- Table structure for Department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
`departmentId` bigint(20) NOT NULL AUTO_INCREMENT,
`companyId` bigint(20) NOT NULL,
`companyName` varchar(15) DEFAULT NULL,
PRIMARY KEY (`departmentId`),
CONSTRAINT `FK_Reference` FOREIGN KEY (`companyId`) REFERENCES `Company` (`companyId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of Department
-- ----------------------------



