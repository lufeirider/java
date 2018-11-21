/*
Navicat Oracle Data Transfer
Oracle Client Version : 12.1.0.1.0

Source Server         : 192.168.100.105
Source Server Version : 120200
Source Host           : 192.168.100.105:1521
Source Schema         : SYSTEM

Target Server Type    : ORACLE
Target Server Version : 120200
File Encoding         : 65001

Date: 2018-11-21 17:07:30
*/


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE "SYSTEM"."user";
CREATE TABLE "SYSTEM"."user" (
"id" NUMBER NULL ,
"username" VARCHAR2(255 BYTE) NULL ,
"password" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "SYSTEM"."user" VALUES ('1', 'lufei', 'qq123456');
INSERT INTO "SYSTEM"."user" VALUES ('2', 'test', '222222222');
INSERT INTO "SYSTEM"."user" VALUES ('3', 'test3', '33333333');
