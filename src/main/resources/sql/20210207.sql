-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	5.6.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bl_admin`
--

DROP TABLE IF EXISTS `bl_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bl_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='后台用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bl_admin`
--

LOCK TABLES `bl_admin` WRITE;
/*!40000 ALTER TABLE `bl_admin` DISABLE KEYS */;
INSERT INTO `bl_admin` VALUES (1,'zgwny','$2a$10$9zaUVOIqrMzbH6CvQ3A/5e8OBnNpViYJtsCeUOhzgh8HftltZU0M.',NULL,'1767827764@qq.com','张文岳',NULL,'2021-02-06 19:05:14',NULL,1);
/*!40000 ALTER TABLE `bl_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bl_admin_permission_relation`
--

DROP TABLE IF EXISTS `bl_admin_permission_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bl_admin_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `type` int(1) DEFAULT NULL COMMENT '是否排除角色中定义的权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='后台用户和权限关系表(除角色中定义的权限以外的加减权限)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bl_admin_permission_relation`
--

LOCK TABLES `bl_admin_permission_relation` WRITE;
/*!40000 ALTER TABLE `bl_admin_permission_relation` DISABLE KEYS */;
INSERT INTO `bl_admin_permission_relation` VALUES (1,1,1,1);
/*!40000 ALTER TABLE `bl_admin_permission_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bl_admin_role_relation`
--

DROP TABLE IF EXISTS `bl_admin_role_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bl_admin_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户和角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bl_admin_role_relation`
--

LOCK TABLES `bl_admin_role_relation` WRITE;
/*!40000 ALTER TABLE `bl_admin_role_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `bl_admin_role_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bl_blog`
--

DROP TABLE IF EXISTS `bl_blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bl_blog` (
  `id` bigint(20) NOT NULL COMMENT '帖子id',
  `title` varchar(63) NOT NULL COMMENT '标题',
  `image` varchar(255) DEFAULT NULL COMMENT '封面',
  `content` mediumtext NOT NULL COMMENT '帖子内容',
  `goods` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `read` int(11) NOT NULL DEFAULT '0' COMMENT '阅读数',
  `collection` int(11) NOT NULL DEFAULT '0' COMMENT '收藏数',
  `type` int(11) NOT NULL COMMENT '博客分类',
  `remark` varchar(127) DEFAULT NULL COMMENT '简介',
  `comment` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  `source` varchar(127) DEFAULT NULL COMMENT '文章来源（爬虫时使用）',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0否1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='博客表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bl_blog`
--

LOCK TABLES `bl_blog` WRITE;
/*!40000 ALTER TABLE `bl_blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `bl_blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bl_permission`
--

DROP TABLE IF EXISTS `bl_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bl_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `value` varchar(200) DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) CHARACTER SET latin1 DEFAULT NULL COMMENT '图标',
  `type` int(1) DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
  `uri` varchar(200) CHARACTER SET euckr DEFAULT NULL COMMENT '前端资源路径',
  `status` int(1) DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='后台用户权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bl_permission`
--

LOCK TABLES `bl_permission` WRITE;
/*!40000 ALTER TABLE `bl_permission` DISABLE KEYS */;
INSERT INTO `bl_permission` VALUES (1,1,'用户列表','pms:user:read',NULL,1,'/api/user/list',1,'2018-09-29 16:17:01',0);
/*!40000 ALTER TABLE `bl_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bl_role`
--

DROP TABLE IF EXISTS `bl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bl_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) DEFAULT NULL COMMENT '后台用户数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='后台用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bl_role`
--

LOCK TABLES `bl_role` WRITE;
/*!40000 ALTER TABLE `bl_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `bl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bl_role_permission_relation`
--

DROP TABLE IF EXISTS `bl_role_permission_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bl_role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户角色和权限关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bl_role_permission_relation`
--

LOCK TABLES `bl_role_permission_relation` WRITE;
/*!40000 ALTER TABLE `bl_role_permission_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `bl_role_permission_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bl_user`
--

DROP TABLE IF EXISTS `bl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(31) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `name` varchar(31) DEFAULT NULL COMMENT '姓名',
  `sex` int(1) DEFAULT NULL COMMENT '性别。1男2女',
  `header` varchar(255) DEFAULT NULL COMMENT '头像',
  `nickname` varchar(31) CHARACTER SET utf8mb4 NOT NULL DEFAULT '鲜肉' COMMENT '昵称',
  `user_email` varchar(31) DEFAULT NULL COMMENT '邮箱',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除。0否1是',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bl_user`
--

LOCK TABLES `bl_user` WRITE;
/*!40000 ALTER TABLE `bl_user` DISABLE KEYS */;
INSERT INTO `bl_user` VALUES (1,'zhangwenyue','47d49469538f034c153e492698166e24',NULL,1,NULL,'张文岳','1767827764@qq.com','2020-04-18 10:49:11','2020-04-18 10:49:11',1,0);
/*!40000 ALTER TABLE `bl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'blog'
--

--
-- Dumping routines for database 'blog'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-07 17:57:23
