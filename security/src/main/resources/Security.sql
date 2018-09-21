



CREATE DATABASE security;

USE security;

CREATE TABLE sys_user(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

CREATE TABLE sys_role(
   `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;



CREATE TABLE sys_role_user(
 `sys_user_id` int(11) NOT NULL ,
 `roles_id` int(11) NOT NULL ,
 CONSTRAINT `user_id_key` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `roles_id_key` FOREIGN KEY (`roles_id`) REFERENCES `sys_role` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;





CREATE TABLE sys_permission_role(
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `permission_id` int(11) NOT NULL ,
 `roles_id` int(11) NOT NULL ,
 PRIMARY KEY (`id`),
 CONSTRAINT `idx_permission_id_key` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`),
  CONSTRAINT `idx_roles_id_key` FOREIGN KEY (`roles_id`) REFERENCES `sys_role` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;