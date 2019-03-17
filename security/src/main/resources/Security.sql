



DROP TABLE IF EXISTS `Sys_User`;
CREATE TABLE `Sys_User`(
  `user_id` BIGINT  NOT NULL AUTO_INCREMENT,
  `cnname` VARCHAR(200) DEFAULT NULL,
    `username` VARCHAR(200) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
   `rePassword` VARCHAR(200) DEFAULT NULL,
     `historyPassword` VARCHAR(200) DEFAULT NULL,
      `email` VARCHAR(200) DEFAULT NULL,
        `telephone` VARCHAR(200) DEFAULT NULL,
   `mobilePhone` VARCHAR(200) DEFAULT NULL,

  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Sys_Role`;
CREATE TABLE `Sys_Role`(
`role_id` BIGINT  NOT NULL AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`roleLevel` VARCHAR(200) DEFAULT NULL,
 `description` VARCHAR(200) DEFAULT NULL,
  `menuItems` VARCHAR(200) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Sys_permission`;
CREATE TABLE `Sys_permission`(
  `permission_id` BIGINT  NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
   `permissionUrl` VARCHAR(200) DEFAULT NULL,
     `method` VARCHAR(200) NOT NULL,
  `description` VARCHAR(200) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Sys_role_user`;
CREATE TABLE `Sys_role_user`(
  `id` BIGINT  NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT  NOT NULL,
  `role_id` BIGINT  NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `Sys_User` (`user_id`),
CONSTRAINT `FK_Reference_2` FOREIGN KEY (`role_id`) REFERENCES `Sys_Role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Sys_permission_role`;
CREATE TABLE `Sys_permission_role`(
  `id` BIGINT  NOT NULL AUTO_INCREMENT,
  `role_id` BIGINT  NOT NULL,
  `permission_id` BIGINT  NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `Sys_Role` (`role_id`),
CONSTRAINT `FK_Reference_4` FOREIGN KEY (`permission_id`) REFERENCES `Sys_permission` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

