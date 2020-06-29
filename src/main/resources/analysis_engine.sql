/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : analysis_engine

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 29/06/2020 21:16:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adapter
-- ----------------------------
DROP TABLE IF EXISTS `adapter`;
CREATE TABLE `adapter`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) NULL DEFAULT NULL COMMENT '网关ID',
  `sid` int(11) NULL DEFAULT NULL COMMENT '传感器ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '联系方式',
  `company` int(11) NULL DEFAULT NULL COMMENT '0 - 管理员\nid - 公司',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT ' 公司名称',
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '公司地址',
  `industry` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '所属行业',
  `intros` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (1, 'tc', 'ad', 'in', 'into');

-- ----------------------------
-- Table structure for component
-- ----------------------------
DROP TABLE IF EXISTS `component`;
CREATE TABLE `component`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '0-网关 1-传感器',
  `company` int(11) NULL DEFAULT NULL COMMENT '公司ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for componentproperties
-- ----------------------------
DROP TABLE IF EXISTS `componentproperties`;
CREATE TABLE `componentproperties`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NULL DEFAULT NULL COMMENT '组件ID',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '属性名',
  `value` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '属性值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gateway
-- ----------------------------
DROP TABLE IF EXISTS `gateway`;
CREATE TABLE `gateway`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `innerProtocols` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uploadProtocols` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `industrialGrade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chargeable` int(255) NULL DEFAULT NULL,
  `lowVoltage` double(255, 0) NULL DEFAULT NULL,
  `highVoltage` double(255, 0) NULL DEFAULT NULL,
  `lowTemperature` double(255, 0) NULL DEFAULT NULL,
  `highTemperature` double(255, 0) NULL DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `otherDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gateway
-- ----------------------------
INSERT INTO `gateway` VALUES (1, 'AnybusModbus到KNX网关', 'Modbus TCP 、Modbus RTU ', 'KNX', '工业普通级', 0, 9, 30, 0, 60, 'Anybus Modbus至KNX网关允许Modbus从设备在KNX网络上进行通信。 网关充当两个网络之间的转换器，允许从任何KNX TP1网络读取和控制Modbus RTU和Modbus TCP信号。 这样就可以从建筑物中的KNX系统集中控制和监视Modbus设备。', '尺寸：90 x 88 x 56 mm');
INSERT INTO `gateway` VALUES (2, 'AnybusModbus到KNX网关2', 'Modbus TCP 、Modbus RTU ', 'KNX', '工业普通级', 0, 9, 30, 0, 60, 'Anybus Modbus至KNX网关允许Modbus从设备在KNX网络上进行通信。 网关充当两个网络之间的转换器，允许从任何KNX TP1网络读取和控制Modbus RTU和Modbus TCP信号。 这样就可以从建筑物中的KNX系统集中控制和监视Modbus设备。', '尺寸：90 x 88 x 56 mm');
INSERT INTO `gateway` VALUES (3, 'xumu', 'TCP', 'KNX', 'gongye', 0, 8, 66, 0, 60, 'xxxxxx', 'xxxxxxxxx');
INSERT INTO `gateway` VALUES (4, 'xumu', 'TCP', 'KNX', 'gongye', 0, 8, 66, 0, 60, 'xxxxxx', 'xxxxxxxxx');
INSERT INTO `gateway` VALUES (5, 'xumu', 'TCP', 'KNX', 'gongye', 0, 8, 66, 0, 60, 'xxxxxx', 'xxxxxxxxx');

-- ----------------------------
-- Table structure for program
-- ----------------------------
DROP TABLE IF EXISTS `program`;
CREATE TABLE `program`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL COMMENT '企业ID',
  `public` tinyint(4) NULL DEFAULT NULL COMMENT '是否公开0/1',
  `intros` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for program-componet
-- ----------------------------
DROP TABLE IF EXISTS `program-componet`;
CREATE TABLE `program-componet`  (
  `id` int(11) NOT NULL,
  `pid` int(11) NULL DEFAULT NULL COMMENT '项目ID',
  `cid` int(11) NULL DEFAULT NULL COMMENT '组件ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '联系方式',
  `company` int(11) NULL DEFAULT NULL COMMENT '公司ID',
  `role` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '932', '123456', 'root', '131', 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
