/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.99
Source Server Version : 50628
Source Host           : 192.168.0.99:3306
Source Database       : bityet

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2017-02-14 17:22:30
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(15) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL DEFAULT '''''',
  `mobile` varchar(11) NOT NULL DEFAULT '''''',
  `password` varchar(20) NOT NULL,
  `salt` varchar(20) NOT NULL,
  `status` tinyint(1) NOT NULL COMMENT '状态1可用2不可用',
  `gmt_modified` datetime NOT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
