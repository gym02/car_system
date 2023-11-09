/*
 Navicat Premium Data Transfer

 Source Server         : WoNiu
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : car_system

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 10/09/2023 07:30:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car_brand
-- ----------------------------
DROP TABLE IF EXISTS `car_brand`;
CREATE TABLE `car_brand`  (
  `id` int(11) NOT NULL,
  `brand_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `brand_name`(`brand_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of car_brand
-- ----------------------------
INSERT INTO `car_brand` VALUES (3, '大众');
INSERT INTO `car_brand` VALUES (2, '奔驰');
INSERT INTO `car_brand` VALUES (1, '比亚迪');
INSERT INTO `car_brand` VALUES (4, '法拉利');

-- ----------------------------
-- Table structure for cars
-- ----------------------------
DROP TABLE IF EXISTS `cars`;
CREATE TABLE `cars`  (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `brand` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `license_plate_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `regist_time` date NULL DEFAULT NULL,
  `start_mileage` decimal(10, 2) NULL DEFAULT NULL,
  `car_img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isdelete` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`car_id`) USING BTREE,
  INDEX `price`(`price`) USING BTREE,
  INDEX `start_mileage`(`start_mileage`) USING BTREE,
  INDEX `car_img`(`car_img`) USING BTREE,
  INDEX `brand`(`brand`) USING BTREE,
  CONSTRAINT `cars_ibfk_1` FOREIGN KEY (`brand`) REFERENCES `car_brand` (`brand_name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cars
-- ----------------------------
INSERT INTO `cars` VALUES (1, '待出租', '大众', 'DZ01', '迈腾', 100.00, '2023-08-28', 0.00, '1', 0);
INSERT INTO `cars` VALUES (2, '待出租', '大众', 'DZ02', '帕萨特', 150.00, '2023-08-04', 0.00, '2', 0);
INSERT INTO `cars` VALUES (3, '待出租', '奔驰', 'BC01', 'G级', 300.00, '2023-07-27', 10.00, '3', 0);
INSERT INTO `cars` VALUES (4, '待出租', '奔驰', 'BC02', 'S级', 500.00, '2023-09-01', 0.00, '4', 0);
INSERT INTO `cars` VALUES (5, '待出租', '比亚迪', 'BYD01', '秦PLUS', 200.00, '2023-08-30', 0.00, '5', 0);
INSERT INTO `cars` VALUES (6, '待出租', '比亚迪', 'BYD02', '汉', 300.00, '2023-07-12', 0.00, '6', 0);
INSERT INTO `cars` VALUES (7, '待出租', '法拉利', 'FLL01', '迈巴赫', 1000.00, '2022-08-31', 0.00, '7', 0);
INSERT INTO `cars` VALUES (8, '待出租', '大众', 'BC03', 'SS', 300.00, '2023-09-01', 0.00, '7', 1);

-- ----------------------------
-- Table structure for damage_information
-- ----------------------------
DROP TABLE IF EXISTS `damage_information`;
CREATE TABLE `damage_information`  (
  `damage_information_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NULL DEFAULT NULL,
  `contract_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `return_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `damage_state` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isdelete` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`damage_information_id`) USING BTREE,
  INDEX `car_img`(`car_img`) USING BTREE,
  INDEX `contract_number`(`contract_number`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `damage_information_ibfk_2` FOREIGN KEY (`car_img`) REFERENCES `cars` (`car_img`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `damage_information_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of damage_information
-- ----------------------------
INSERT INTO `damage_information` VALUES (1, 1, 'HT03', NULL, '9', '轻度刮擦', 'guaca', 1);

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`  (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isdelete` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES (1, 'admin', '11111111111', 'admin', 'e0f67b80a600e34cc355ff446f970127', 0);
INSERT INTO `employees` VALUES (2, '马云', '22222222222', 'mayun', 'b754d675733eda3f1bd2fd900081dfeb', 0);
INSERT INTO `employees` VALUES (3, '马化腾', '33333333333', 'mahuateng', '269512a2bbcd031bc77215b63c42bd88', 0);
INSERT INTO `employees` VALUES (4, '任正非', '44444444444', 'renzhengfei', '47621f7dd4b565351f9714071cca6857', 0);
INSERT INTO `employees` VALUES (5, '董明珠', '55555555555', 'dongmingzhu', 'c8454e34ce85d6ac9b8910102162ac46', 1);
INSERT INTO `employees` VALUES (6, '雷军', '66666666666', 'leijun', 'a2530796d1dd73e979f28c1364854258', 0);
INSERT INTO `employees` VALUES (7, '李彦宏', '77777777777', 'liyanhong', 'cd59ed7abaa95629aa8f5ae6614671c2', 0);
INSERT INTO `employees` VALUES (8, '小高', '2222222', '123', '91145c5c63a405eb2d3a7bd8c44e1b16', 0);

-- ----------------------------
-- Table structure for files
-- ----------------------------
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `md5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of files
-- ----------------------------
INSERT INTO `files` VALUES (1, 'd:/imgs/2023/9/5/1693896346275', '29cb4558b3f766f9980ff861fdbdc36e');
INSERT INTO `files` VALUES (2, 'd:/imgs/2023/9/5/1693896358771', 'db551a43789ffeb6c45b7ffd5e61ef48');
INSERT INTO `files` VALUES (3, 'd:/imgs/2023/9/5/1693896374145', 'b9cc0d104a58b184e4122cfb10c3b78e');
INSERT INTO `files` VALUES (4, 'd:/imgs/2023/9/5/1693896381728', 'cc026b20ab7de184e589f270fad03459');
INSERT INTO `files` VALUES (5, 'd:/imgs/2023/9/5/1693896389830', '93a43fb8d55aad0dc3f532fce10aa1d6');
INSERT INTO `files` VALUES (6, 'd:/imgs/2023/9/5/1693896401497', '0c4b7a9683cc43811f33d4835f5cab94');
INSERT INTO `files` VALUES (7, 'd:/imgs/2023/9/5/1693896409158', '4d27e59d65b1ef14471e5a09fbf80263');
INSERT INTO `files` VALUES (8, 'd:/imgs/2023/9/5/1693915859664', '6786d3b0ab3db816729888dca4883d06');
INSERT INTO `files` VALUES (9, 'd:/imgs/2023/9/5/1693922228546', '53c0b03f467f9cade7b81bca955f0f0c');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `car_id` int(11) NULL DEFAULT NULL,
  `order_state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `deposit` decimal(10, 2) NULL DEFAULT NULL,
  `total_price` decimal(10, 2) NULL DEFAULT NULL,
  `start_time` datetime NULL DEFAULT NULL,
  `end_time` datetime NULL DEFAULT NULL,
  `start_mileage` decimal(10, 2) NULL DEFAULT NULL,
  `end_mileage` decimal(10, 2) NULL DEFAULT NULL,
  `contract_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isdelete` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `car_id`(`car_id`) USING BTREE,
  INDEX `price`(`price`) USING BTREE,
  INDEX `start_mileage`(`start_mileage`) USING BTREE,
  INDEX `contract_number`(`contract_number`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`car_id`) REFERENCES `cars` (`car_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 1, 3, '已完成', 300.00, 300.00, 1800.00, '2023-09-01 00:00:00', '2023-09-06 00:00:00', 10.00, 10.00, 'HT03', 0);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(3) NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isdelete` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '菠萝吹雪', 18, '11111111111', '500x1', 0);
INSERT INTO `users` VALUES (2, '橙留香', 24, '22222222222', '500x2', 0);
INSERT INTO `users` VALUES (3, '陆小果', 22, '33333333333', '500x3', 0);
INSERT INTO `users` VALUES (4, '22', 22, '22', '22', 1);

-- ----------------------------
-- Table structure for violation_information
-- ----------------------------
DROP TABLE IF EXISTS `violation_information`;
CREATE TABLE `violation_information`  (
  `violation_information_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NULL DEFAULT NULL,
  `contract_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `violation_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `penalty` decimal(10, 2) NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `violation_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `violation_time` datetime NULL DEFAULT NULL,
  `isdelete` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`violation_information_id`) USING BTREE,
  INDEX `contract_number`(`contract_number`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `violation_information_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of violation_information
-- ----------------------------
INSERT INTO `violation_information` VALUES (1, 1, 'HT03', '待处理', 200.00, '11', '1', '2023-09-06 11:51:54', 0);

SET FOREIGN_KEY_CHECKS = 1;
