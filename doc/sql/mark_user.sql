/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50724
Source Host           : 127.0.0.1:3306
Source Database       : mark

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-11-09 21:07:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mark_user
-- ----------------------------
DROP TABLE IF EXISTS `mark_user`;
CREATE TABLE `mark_user` (
  `id` bigint(21) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_code` varchar(32) NOT NULL COMMENT '用户编号',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `age` tinyint(3) unsigned NOT NULL COMMENT '年龄',
  `gender` tinyint(2) unsigned NOT NULL COMMENT '性别  0 女  1 男',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `valid` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '逻辑删除字段 0  无效  1  有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
