/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : software_release_system

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-03-11 12:16:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `software_id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_icon` varchar(255) NOT NULL,
  `comment` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for sg_soft_group
-- ----------------------------
DROP TABLE IF EXISTS `sg_soft_group`;
CREATE TABLE `sg_soft_group` (
  `sg_id` int(11) NOT NULL AUTO_INCREMENT,
  `sg_soft_id` int(11) NOT NULL,
  `sg_group_id` int(11) NOT NULL,
  PRIMARY KEY (`sg_id`),
  UNIQUE KEY `sg_soft_id` (`sg_soft_id`,`sg_group_id`),
  KEY `sg_group_id` (`sg_group_id`),
  CONSTRAINT `sg_soft_group_ibfk_1` FOREIGN KEY (`sg_soft_id`) REFERENCES `software` (`soft_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sg_soft_group_ibfk_2` FOREIGN KEY (`sg_group_id`) REFERENCES `soft_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of sg_soft_group
-- ----------------------------
INSERT INTO `sg_soft_group` VALUES ('1', '13', '3');
INSERT INTO `sg_soft_group` VALUES ('2', '15', '3');
INSERT INTO `sg_soft_group` VALUES ('3', '16', '3');
INSERT INTO `sg_soft_group` VALUES ('5', '17', '3');
INSERT INTO `sg_soft_group` VALUES ('7', '18', '3');
INSERT INTO `sg_soft_group` VALUES ('8', '19', '3');
INSERT INTO `sg_soft_group` VALUES ('9', '20', '3');
INSERT INTO `sg_soft_group` VALUES ('10', '21', '3');
INSERT INTO `sg_soft_group` VALUES ('11', '22', '3');
INSERT INTO `sg_soft_group` VALUES ('12', '23', '3');

-- ----------------------------
-- Table structure for software
-- ----------------------------
DROP TABLE IF EXISTS `software`;
CREATE TABLE `software` (
  `soft_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '软件ID',
  `soft_user_id` int(11) DEFAULT NULL COMMENT '开发者ID',
  `soft_group_id` int(11) DEFAULT NULL,
  `soft_name` varchar(255) NOT NULL COMMENT '软件名',
  `soft_abstract` varchar(255) NOT NULL COMMENT '软件摘要',
  `soft_details` text NOT NULL COMMENT '软件详细',
  `soft_size` bigint(20) NOT NULL DEFAULT '0' COMMENT '软件大小  单位KB',
  `soft_version` varchar(255) DEFAULT NULL COMMENT '版本号',
  `soft_date` date NOT NULL COMMENT '更新日期',
  `soft_os` varchar(255) NOT NULL COMMENT '操作系统',
  `soft_download_volume` int(11) NOT NULL DEFAULT '0' COMMENT '下载量',
  `soft_file_link` varchar(255) DEFAULT NULL COMMENT '文件链接',
  `soft_icon_link` varchar(255) DEFAULT NULL COMMENT '图标链接',
  `soft_create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `soft_create_ip` varchar(255) DEFAULT NULL,
  `pre_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `pre_update_ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`soft_id`),
  UNIQUE KEY `name` (`soft_name`),
  KEY `user_id` (`soft_user_id`),
  KEY `soft_group_id` (`soft_group_id`),
  CONSTRAINT `software_ibfk_1` FOREIGN KEY (`soft_group_id`) REFERENCES `soft_group` (`group_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`soft_user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of software
-- ----------------------------
INSERT INTO `software` VALUES ('13', '79', '3', 'Microsoft Office 2010简体中文版', 'Microsoft Office 2010是微软Office官方推出的Office Professional Plus 2010，包括Word、Excel、PowerPoint、OneNote、InofPath、Access、Outlook、Publisher、Communicator、SharePoint Workspace等几乎所有组件。', '', '5000000', '', '2017-01-24', '', '0', '', null, '2017-01-14 10:30:21', null, '2017-01-14 10:30:24', null);
INSERT INTO `software` VALUES ('15', '80', '3', '网易一元购', '网易1元购，是中国技术领先的互联网公司网易推出的全新服务，旨在倡导全新的电商购物和娱乐体验。您可花费1元，获得时下诸多热门商品，玩法创新，每时每刻，欢乐无限。', '', '1000000', '', '2017-01-25', '', '0', '', null, '2016-12-05 13:31:35', null, '2016-12-05 13:31:35', null);
INSERT INTO `software` VALUES ('16', '81', '3', 'PPTV网络电视', 'PPTV网络电视是PPLive旗下媒体，一款全球安装量最大的网络电视，支持对海量影视内容的“直播+点播”功能。可在线观看“电影、电视剧、动漫、综艺、体育直播、游戏竞技、财经资讯”等丰富视频娱乐节目并且完全免费，是广受网友推崇的装机必备软件。', '', '40000000', '', '2017-01-03', '', '0', '', null, '2017-01-13 16:03:48', null, '2017-01-13 16:03:48', null);
INSERT INTO `software` VALUES ('17', '79', '3', '风行视频3.0.6.60', '风行是一款集在线点播和下载影视（电影、电视）节目的视频播放软件，具有风行首 创的“边下边看”特点。', '', '500000000', '', '2017-01-26', '', '0', '', null, '2017-01-14 10:28:38', null, '2017-01-14 10:28:38', null);
INSERT INTO `software` VALUES ('18', '79', '3', '腾讯QQ8.3.18038', '腾讯QQ是深圳市腾讯计算机系统有限公司开发的一款基于Internet的即时通信（IM）软件。', '', '400303030', '', '2017-01-03', '', '0', '', null, '2017-01-14 10:29:00', null, '2017-01-14 10:29:00', null);
INSERT INTO `software` VALUES ('19', '79', '3', '\r\n阿里旺旺(买家版) 9.07.02C 官方版', '阿里旺旺不仅具有及时沟通软件所需要的功能，而且结合了淘宝网购物的沟通需求，将很多网购功能加入其中，打造出了中国最大的电子商务第一IM。\r\n使用阿里旺旺，您能享受到购物搜索，逛淘宝，支付宝支付等所有流程的便利。', '', '32222222', '', '2017-01-03', '', '0', '', null, '2017-01-14 10:29:33', null, '2017-01-14 10:29:33', null);
INSERT INTO `software` VALUES ('20', '79', '3', '9158多人视频聊天 6.9.7.0官方版', '9158多人视频聊天室是一款具有超清晰视频和立体声宽频语音特效的多人聊天软件，用户可在“房间”内在线K歌，是聚会交友的好工具。', '', '333232323', '', '2017-01-02', '', '0', '', null, '2017-01-14 10:30:09', null, '2017-01-14 10:30:09', null);
INSERT INTO `software` VALUES ('21', '79', '3', '英雄联盟', '《英雄联盟》（简称lol）是由美国Riot Games开发，腾讯运营的英雄对战网游。', '', '244233333', '', '2017-01-03', '', '0', '', null, '2017-01-14 10:30:15', null, '2017-01-14 10:30:15', null);
INSERT INTO `software` VALUES ('22', '81', '3', '穿越火线', '《穿越火线》（简称CF）是由腾讯游戏代理运营的一款第一人称射击网游。', '', '4422232323', '', '2017-01-10', '', '0', '', null, '2017-01-14 10:31:49', null, '2017-01-14 10:31:49', null);
INSERT INTO `software` VALUES ('23', '81', '3', '逆战', '《逆战》作为腾讯首款自研多人在线射击网游，采用虚幻3引擎打造，取得多项技术突破，画面华丽精美，上手简单。', '', '444424242442', '', '2017-01-10', '', '0', '', null, '2017-01-14 10:32:23', null, '2017-01-14 10:32:23', null);
INSERT INTO `software` VALUES ('92', '88', null, '测试软件aa', 'aaaa', 'aaaa', '21975', null, '2017-03-09', 'volvo', '0', '2017/03/09/24a402e2-5982-4ade-b0d4-41fd6a96d252.JPG', '2017/03/09/61049fa4-5d94-4bf2-95c2-767d78ce1b2d.png', '2017-03-09 20:35:13', '0:0:0:0:0:0:0:1', '2017-03-09 20:35:13', '0:0:0:0:0:0:0:1');
INSERT INTO `software` VALUES ('93', '88', '4', 'aaaa', 'aaaa', 'aaaa', '21975', null, '2017-03-09', 'Windows', '0', '2017/03/09/631335a8-3fdc-470a-8a69-22207cc7233a.JPG', '2017/03/09/30bc70bf-90f4-4142-a067-5445bf6aa8c0.png', '2017-03-09 20:39:09', '0:0:0:0:0:0:0:1', '2017-03-09 20:39:09', '0:0:0:0:0:0:0:1');
INSERT INTO `software` VALUES ('94', '97', '3', '百度网盘', '这是一款非常好用的软件。', '<p>\r\n	这是一个绿色版的百度网盘，下载解压即能使用。\r\n</p>\r\n<p>\r\n	<span style=\"font-size:24px;\">我是</span><span style=\"font-size:24px;\">24号字体</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:12px;\">下面看一下截图</span>\r\n</p>\r\n<p style=\"text-align:center;\">\r\n	<span style=\"font-size:12px;\"><img src=\"/soft/image/2017/03/10/1d21260e-c7f0-4afe-baaa-04d65791a9f7.jpg\" alt=\"\" width=\"600\" height=\"380\" title=\"\" align=\"\" /><br />\r\n</span>\r\n</p>\r\n<p style=\"text-align:center;\">\r\n	<span style=\"font-size:12px;\"><img src=\"/soft/image/2017/03/10/7584adfd-2648-4210-a5de-fb35093bbc47.png\" alt=\"\" width=\"300\" height=\"200\" title=\"\" align=\"\" /><br />\r\n</span>\r\n</p>', '882688', null, '2017-03-10', 'Windows', '0', '2017/03/10/16bd957b-72cb-414e-809c-51b890d4b945.exe', '2017/03/10/b00e857a-cd69-4dc1-bab5-a9fb3b951bda.png', '2017-03-10 17:36:04', '0:0:0:0:0:0:0:1', '2017-03-10 17:36:04', '0:0:0:0:0:0:0:1');
INSERT INTO `software` VALUES ('95', '98', '4', 'errrrr', 'fdssssssssssss', '<p>\r\n	raefgggggggggggggggggggggggggggggggggggg\r\n</p>\r\n<p>\r\n	<img src=\"/soft/image/2017/03/10/f80f66a6-177f-405e-9bf6-9c09459a4089.png\" alt=\"\" />\r\n</p>', '14603', null, '2017-03-10', 'Windows', '0', '2017/03/10/7436794c-6b3c-4c1a-a891-7efdb37c1192.png', '2017/03/10/2d077f15-88cc-4839-87ea-672c7eeab295.png', '2017-03-10 20:07:30', '172.28.2.113', '2017-03-10 20:07:30', '172.28.2.113');

-- ----------------------------
-- Table structure for soft_group
-- ----------------------------
DROP TABLE IF EXISTS `soft_group`;
CREATE TABLE `soft_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) NOT NULL,
  PRIMARY KEY (`group_id`),
  UNIQUE KEY `name` (`group_name`),
  KEY `id` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of soft_group
-- ----------------------------
INSERT INTO `soft_group` VALUES ('3', '计算机系');
INSERT INTO `soft_group` VALUES ('4', '数学系');
INSERT INTO `soft_group` VALUES ('5', '物理系');

-- ----------------------------
-- Table structure for soft_pic
-- ----------------------------
DROP TABLE IF EXISTS `soft_pic`;
CREATE TABLE `soft_pic` (
  `pic_id` int(11) NOT NULL AUTO_INCREMENT,
  `pic_soft_id` int(11) NOT NULL,
  `pic_user_id` int(11) NOT NULL,
  `pic_link` varchar(255) NOT NULL,
  `pic_size` bigint(11) NOT NULL,
  `pic_type` varchar(255) NOT NULL,
  `pic_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pic_id`),
  KEY `soft_pic_ibfk_1` (`pic_soft_id`),
  KEY `pic_user_id` (`pic_user_id`),
  CONSTRAINT `soft_pic_ibfk_1` FOREIGN KEY (`pic_soft_id`) REFERENCES `software` (`soft_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `soft_pic_ibfk_2` FOREIGN KEY (`pic_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of soft_pic
-- ----------------------------
INSERT INTO `soft_pic` VALUES ('1', '94', '97', '2017/03/10/1d21260e-c7f0-4afe-baaa-04d65791a9f7.jpg', '17750', 'jpg', '2017-03-10 17:36:04');
INSERT INTO `soft_pic` VALUES ('2', '94', '97', '2017/03/10/7584adfd-2648-4210-a5de-fb35093bbc47.png', '52568', 'png', '2017-03-10 17:36:04');
INSERT INTO `soft_pic` VALUES ('3', '95', '98', '2017/03/10/f80f66a6-177f-405e-9bf6-9c09459a4089.png', '15629', 'png', '2017-03-10 20:07:31');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(14) NOT NULL COMMENT '用户名',
  `password` varchar(16) NOT NULL DEFAULT '123456' COMMENT '密码',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `pic_link` varchar(255) DEFAULT NULL COMMENT '头像',
  `software_count` int(11) NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '0 普通用户 \r\n1 开发者  \r\n2 管理员  \r\n3 超级管理员  ',
  `reg_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `reg_ip` varchar(255) DEFAULT NULL COMMENT '注册ip',
  `pre_login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次登录时间',
  `pre_login_ip` varchar(255) DEFAULT NULL COMMENT '上次登录ip',
  `pre_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次更新时间',
  `pre_update_ip` varchar(255) DEFAULT NULL COMMENT '上次更新ip',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `email` (`email`) USING BTREE,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('79', 'test1', 'test', 'test1@qq.com', null, '0', '0', '2017-01-03 14:24:31', '0:0:0:0:0:0:0:1', '2017-01-22 14:05:38', '0:0:0:0:0:0:0:1', '2017-01-07 17:32:54', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('80', 'test2', 'test', 'test2@qq.com', null, '0', '1', '2017-01-14 10:26:11', '0:0:0:0:0:0:0:1', '2017-01-14 10:26:11', null, '2017-01-20 18:24:45', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('81', 'test3', 'test', 'test3@qq.com', null, '0', '2', '2017-01-14 10:26:28', '0:0:0:0:0:0:0:1', '2017-03-05 18:14:35', '0:0:0:0:0:0:0:1', '2017-01-14 10:26:28', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('88', 'testtest', 'pwdpwd', 'testtest@test.com', null, '0', '0', '2017-03-06 09:07:26', '0:0:0:0:0:0:0:1', '2017-03-10 16:19:24', '0:0:0:0:0:0:0:1', '2017-03-06 09:07:26', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('91', 'test3test3', 'testtest', 'st@qq.com', null, '0', '0', '2017-03-06 11:38:56', '0:0:0:0:0:0:0:1', '2017-03-06 11:38:56', null, '2017-03-06 11:38:56', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('92', 'testtest1', 'aaaaaa', 'aaa@qq.com', null, '0', '0', '2017-03-06 11:42:40', '0:0:0:0:0:0:0:1', '2017-03-06 11:42:40', null, '2017-03-06 11:42:40', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('93', 'zczczc', 'zcyoung', 'zc@zcyoung.cn', null, '0', '0', '2017-03-06 13:23:53', '172.28.132.225', '2017-03-10 18:29:37', '172.28.132.225', '2017-03-06 13:23:53', '172.28.132.225');
INSERT INTO `user` VALUES ('94', 'testtest11', 'aaaaaa', 'aaa@qqq.com', null, '0', '0', '2017-03-06 18:41:31', '172.28.138.191', '2017-03-06 18:41:31', null, '2017-03-06 18:41:31', '172.28.138.191');
INSERT INTO `user` VALUES ('95', '啊啊啊啊啊啊啊啊啊啊啊啊啊', '123456', '123456@qq.com', null, '0', '0', '2017-03-10 16:17:24', '0:0:0:0:0:0:0:1', '2017-03-10 16:17:24', null, '2017-03-10 16:17:24', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('96', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '123456', '1234567@qq.com', null, '0', '0', '2017-03-10 16:17:37', '0:0:0:0:0:0:0:1', '2017-03-10 16:17:37', null, '2017-03-10 16:17:37', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('97', 'ss ss ss', '123456', '123456728@qq.com', null, '0', '0', '2017-03-10 16:18:41', '0:0:0:0:0:0:0:1', '2017-03-10 20:06:57', '0:0:0:0:0:0:0:1', '2017-03-10 16:18:41', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('98', 'wwwwww', '123123', '123@123.com', null, '0', '0', '2017-03-10 20:05:01', '172.28.2.113', '2017-03-10 20:05:16', '172.28.2.113', '2017-03-10 20:05:01', '172.28.2.113');
