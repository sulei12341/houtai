
-- ----------------------------
-- 会员表
-- ----------------------------
DROP TABLE IF EXISTS `u_member`;
CREATE TABLE `u_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `username` varchar(60) DEFAULT NULL COMMENT '账户',
  `nickname` varchar(60) DEFAULT NULL COMMENT '用户昵称',
  `usercode` varchar(60) DEFAULT NULL COMMENT '用户编码',
  `password` varchar(60) DEFAULT NULL COMMENT '用户密码',
  `phone` varchar(60) DEFAULT NULL COMMENT '用户手机号',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐值',

  `created_by` bigint(20) DEFAULT NULL  COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,

  `username` varchar(60) DEFAULT NULL COMMENT '账户',
  `usercode` varchar(60) DEFAULT NULL COMMENT '用户编码',
  `password` varchar(60) DEFAULT NULL COMMENT '用户密码',
  `phone` varchar(60) DEFAULT NULL COMMENT '用户手机号',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐值',

  `created_by` bigint(20) DEFAULT NULL  COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';


DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL COMMENT '权限名',
  `type` varchar(60) DEFAULT NULL COMMENT '权限类型',
  `url` varchar(100) DEFAULT NULL COMMENT '地址',
  `percode` varchar(60) DEFAULT NULL COMMENT '权限标签',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父权限ID',
  `parentids` varchar(60) DEFAULT NULL COMMENT '父权限层级',
  `sort` int(2) DEFAULT NULL COMMENT '排序',
  `valid` bit(1) DEFAULT b'1' COMMENT '是否有效',
  `created_by` bigint(20) DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL COMMENT '角色名',
  `valid` bit(1) DEFAULT b'1' COMMENT '是否有效',
  `created_by` bigint(20) DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(60) DEFAULT NULL COMMENT '角色ID',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '权限ID',
  `created_by` bigint(20) DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限中间表';


DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `created_by` bigint(20) DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色用户中间表';


ALTER TABLE `sys_user` ADD `nickname` VARCHAR(255) DEFAULT NULL COMMENT '昵称' AFTER `username`;
ALTER TABLE `sys_user` ADD `phone` VARCHAR(40) DEFAULT NULL COMMENT '手机号码' AFTER `password`;

DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '商品名称',
  `items_code` varchar(32) DEFAULT NULL COMMENT '商品编号',
  `price` decimal(10,1) NOT NULL COMMENT '商品定价',
  `detail` text COMMENT '商品描述',
  `pic` varchar(64) DEFAULT NULL COMMENT '商品图片',
  `created_by` bigint(20) DEFAULT NULL  COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品表';
