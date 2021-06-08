/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.24-log : Database - jx3_platform
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jx3_platform` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jx3_platform`;

/*Table structure for table `jx3_commodity` */

DROP TABLE IF EXISTS `jx3_commodity`;

CREATE TABLE `jx3_commodity` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `type_id` varchar(50) NOT NULL COMMENT '类型',
  `sort_num` bigint(20) DEFAULT '0' COMMENT '排序号',
  `name` varchar(256) NOT NULL COMMENT '名称',
  `alias` varchar(256) DEFAULT NULL COMMENT '别名',
  `publish_date` date DEFAULT NULL COMMENT '发行日期',
  `remarks` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `del_flag` varchar(4) NOT NULL DEFAULT '0' COMMENT '0-正常，1-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `type_id` (`type_id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

/*Data for the table `jx3_commodity` */

insert  into `jx3_commodity`(`id`,`type_id`,`sort_num`,`name`,`alias`,`publish_date`,`remarks`,`create_by`,`create_date`,`del_flag`) values
('022dab6585fe4da4aa74874a3caed290','923ad979e3f8441a9127355ac857a71c',222,'好多金币','买泡面','2018-01-01','....','admin','2018-10-29 21:40:46','0'),
('287aa366945846708ab65aaa8e992118','8c83002056a0436aa5e43d37230871f0',99,'7周年礼盒','一堆外观','2017-10-28','外观盒子','admin','2018-10-28 14:57:06','0');

/*Table structure for table `jx3_commodity_img` */

DROP TABLE IF EXISTS `jx3_commodity_img`;

CREATE TABLE `jx3_commodity_img` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `commodity_id` varchar(50) NOT NULL COMMENT '商品主键',
  `name` varchar(256) DEFAULT NULL COMMENT '名称',
  `remarks` varchar(255) DEFAULT NULL COMMENT '描述',
  `path` varchar(1280) NOT NULL COMMENT '图片',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片表';

/*Data for the table `jx3_commodity_img` */

insert  into `jx3_commodity_img`(`id`,`commodity_id`,`name`,`remarks`,`path`,`create_by`,`create_date`) values
('13b5ff461e5f43f095b3a94279fa2b22','022dab6585fe4da4aa74874a3caed290',NULL,NULL,'2wb4g5apvq8vphfcvvmw7i1gqhtvkaif.png','admin','2018-10-29 21:40:46'),
('491d512489f8485380c3ee29ce89d926','287aa366945846708ab65aaa8e992118',NULL,NULL,'igrq6avbdtyujj5dj469cgqldf1hkf4i.png','admin','2018-10-29 20:05:30'),
('5ef33d8dc4db45189304018c695e2424','287aa366945846708ab65aaa8e992118',NULL,NULL,'jtk6n4vxhcxhew65kk98ssooqzenl2jy.png','admin','2018-10-29 20:05:30'),
('6a8067f7f3e3422fa6a4fc19a302441b','022dab6585fe4da4aa74874a3caed290',NULL,NULL,'3d5urovpmsavgifghlbece7s3d8fxzb5.png','admin','2018-10-29 21:40:46'),
('ae6e39399e4541edb985fbc2b899c29a','022dab6585fe4da4aa74874a3caed290',NULL,NULL,'50mmrdrdwjpmgakeslzviocejf5lhfti.png','admin','2018-10-29 21:40:46'),
('c1ba60e3311245988c6bacbf2fe3de00','022dab6585fe4da4aa74874a3caed290',NULL,NULL,'lwf96pevmujufn8awxzxwg2aw2r83ra8.png','admin','2018-10-29 21:40:46'),
('f2f34a24ba184de9b7c6fcf141d64d0f','287aa366945846708ab65aaa8e992118',NULL,NULL,'jbjo6omvyl40tpugm3lgdqydenh8v7sv.png','admin','2018-10-29 20:05:30');

/*Table structure for table `jx3_commodity_trans` */

DROP TABLE IF EXISTS `jx3_commodity_trans`;

CREATE TABLE `jx3_commodity_trans` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `commodity_id` varchar(50) NOT NULL COMMENT '商品',
  `server_id` varchar(50) NOT NULL COMMENT '区服',
  `deal_price` decimal(20,2) NOT NULL COMMENT '成交价格',
  `quotation` varchar(255) NOT NULL DEFAULT '匿名' COMMENT '报价人',
  `transaction_date` date NOT NULL COMMENT '成交日期',
  `trd_platform` varchar(255) NOT NULL COMMENT '三方平台',
  `img` varchar(1280) DEFAULT NULL COMMENT '成交截图',
  `remarks` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `del_flag` varchar(2) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成交价格表';

/*Data for the table `jx3_commodity_trans` */

insert  into `jx3_commodity_trans`(`id`,`commodity_id`,`server_id`,`deal_price`,`quotation`,`transaction_date`,`trd_platform`,`img`,`remarks`,`create_by`,`create_date`,`del_flag`) values
('547ea8e4241d4b2caeaf2d7579705e28','287aa366945846708ab65aaa8e992118','09f02aeb901747fa9e37a1aeed848373',22.21,'李忘生','2018-10-01','5173','@qw4wcvio7iwuvv3hd2lwsnws0cepp82u.png@dvsoim96boeogjwevhnids7box5nuqtv.png',NULL,'admin','2018-10-29 19:58:33','1'),
('97e1633451a247aab212d9e43e61765b','022dab6585fe4da4aa74874a3caed290','09f02aeb901747fa9e37a1aeed848373',1.00,'李忘生22','2018-10-03','game','@fp7bsokstnxvcmkozau30tl0aabojnly.png','333','admin','2018-10-29 21:41:16','0');

/*Table structure for table `jx3_commodity_trans_img` */

DROP TABLE IF EXISTS `jx3_commodity_trans_img`;

CREATE TABLE `jx3_commodity_trans_img` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `commodity_trans_id` varchar(50) NOT NULL COMMENT '报价主键',
  `path` varchar(1280) NOT NULL COMMENT '图片',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报价成交图片表';

/*Data for the table `jx3_commodity_trans_img` */

/*Table structure for table `jx3_commodity_type` */

DROP TABLE IF EXISTS `jx3_commodity_type`;

CREATE TABLE `jx3_commodity_type` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `name` varchar(256) NOT NULL,
  `sort_num` bigint(20) NOT NULL DEFAULT '0' COMMENT '排序（倒序排列）',
  `del_flag` varchar(4) DEFAULT '0' COMMENT '0-正常，1-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类别表';

/*Data for the table `jx3_commodity_type` */

insert  into `jx3_commodity_type`(`id`,`name`,`sort_num`,`del_flag`) values
('1558171f85354518b412afb23ea916ec','短发',2,'1'),
('79f6571d4ff445c89e363691949cf326','白发',98,'0'),
('8c83002056a0436aa5e43d37230871f0','金发',99,'0'),
('923ad979e3f8441a9127355ac857a71c','金币',91,'0'),
('971a58df14614e69b76f101594ee4852','礼盒',96,'0');

/*Table structure for table `jx3_hot_search` */

DROP TABLE IF EXISTS `jx3_hot_search`;

CREATE TABLE `jx3_hot_search` (
  `id` varchar(50) NOT NULL,
  `search_text` varchar(255) NOT NULL,
  `search_count` bigint(20) NOT NULL DEFAULT '0',
  `status` varchar(4) DEFAULT NULL COMMENT '0指定，1系统',
  `view_flag` varchar(4) DEFAULT NULL COMMENT '0显示，1隐藏',
  `last_search_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='热搜关键字管理';

/*Data for the table `jx3_hot_search` */

/*Table structure for table `jx3_server_info` */

DROP TABLE IF EXISTS `jx3_server_info`;

CREATE TABLE `jx3_server_info` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `network` varchar(8) NOT NULL COMMENT '网络类型',
  `serial` varchar(12) NOT NULL COMMENT '区服序号',
  `name` varchar(128) NOT NULL COMMENT '服务器名',
  `remarks` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort_num` bigint(20) DEFAULT '0' COMMENT '排序',
  `del_flag` varchar(4) DEFAULT '0' COMMENT '0-正常，1-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_server_info` (`network`,`serial`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区服表';

/*Data for the table `jx3_server_info` */

insert  into `jx3_server_info`(`id`,`network`,`serial`,`name`,`remarks`,`sort_num`,`del_flag`) values
('09f02aeb901747fa9e37a1aeed848373','telecom','六区','红尘寻梦——大圣归来','数据互通',99,'0'),
('538d7983c971430d9dd3ac95583639f3','网通','一/二区','李忘生——天长地久','数据互通',1,'0'),
('9bfd2827684142fa8a6af5398dbdcb0e','telecom','一区','月月花钱','',12,'0'),
('fe010b08f2ec49478e05c9c104ded27c','double','一区','月下花钱','11111',0,'1');

/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `deptName` varchar(100) NOT NULL COMMENT '部门名称',
  `deptDesc` varchar(300) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`id`,`deptName`,`deptDesc`) values
('9a329b597d754c4180c6b40cdfb0f565','大唐市场监督管理局','dataCenter');

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `userName` varchar(50) NOT NULL COMMENT '用户',
  `title` varchar(300) DEFAULT NULL COMMENT '日志',
  `url` varchar(300) DEFAULT NULL COMMENT '地址',
  `params` text COMMENT '参数',
  `createTime` datetime DEFAULT NULL COMMENT '日志时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

/*Data for the table `sys_log` */


/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `menuName` varchar(50) NOT NULL COMMENT '菜单名称',
  `pid` varchar(50) NOT NULL COMMENT '父级菜单ID',
  `url` varchar(255) DEFAULT NULL COMMENT '连接地址',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `deep` int(11) DEFAULT NULL COMMENT '深度',
  `code` varchar(50) DEFAULT NULL COMMENT '编码',
  `resource` varchar(50) DEFAULT NULL COMMENT '资源名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`menuName`,`pid`,`url`,`icon`,`sort`,`deep`,`code`,`resource`) values
('040a3d8d02fc4a6584e3521bd05ce759','删除','f8db3e5b12d04a46b07026e2828791fc',NULL,NULL,3,3,'020103','deleteServer'),
('05b0d6ac3d354dc58b0462ce21af7897','删除商品类型','5bb55dd90ba44db39d6e3d7f3f316af0',NULL,NULL,3,3,'020203','deleteCommodityType'),
('0818e1c76bbd44eba3a698547ec4e637','查询系统设置','10',NULL,NULL,0,3,'010600','listSetting'),
('0c9b5fc8b44b41d1871a8fc8300247ec','删除菜单','4',NULL,NULL,4,3,'010303','deleteMenu'),
('0f57e022f642406997f4b469533ed3ad','修改','5bb55dd90ba44db39d6e3d7f3f316af0',NULL,NULL,4,3,'020204','updateCommodityType'),
('1','系统管理','0',NULL,'fa fa-cogs',1,1,'01',NULL),
('10','系统配置','1','/system/setting/page',' fa-cog',6,2,'0106','setting'),
('1db9105008404a3485b6fac30dba3c0e','查看角色列表','3',NULL,NULL,0,3,'010200','listRole'),
('2','用户管理','1','/system/user/list/1','fa-user-circle-o',1,2,'0101','user'),
('22c9d12fb3e94969818553eff3b44acf','列表','d5bfbbf27a65455aba6063773533afee',NULL,NULL,1,3,'020401','listCommodityTrans'),
('22e38e885f9b40b9aae6a36deb78e89c','部门管理','1','/system/dept/list/1','fa-graduation-cap',4,2,'0104','dept'),
('2e827fa3927e4fb68de3ca6a8a0eb416','列表','f8db3e5b12d04a46b07026e2828791fc',NULL,NULL,2,3,'020102','listServer'),
('3','角色管理','1','/system/role/list/1','fa-users',2,2,'0102','role'),
('363a778e78a346a68210b2590163a943','编辑部门','22e38e885f9b40b9aae6a36deb78e89c',NULL,NULL,2,3,'010402','editDept'),
('3cf40690f3f0475da4307c8588d2f45e','新增区服','f8db3e5b12d04a46b07026e2828791fc',NULL,NULL,1,3,'020101','addServer'),
('3f26102ef0e04c3c9328cb97067cc5fa','创建菜单','4',NULL,NULL,1,3,'010301','addMenu'),
('3fb6a7a5935b4efabf3de82e7e1baeb6','新增部门','22e38e885f9b40b9aae6a36deb78e89c',NULL,NULL,1,3,'010401','addDept'),
('4','菜单管理','1','/system/menu/list/1','fa-list',3,2,'0103','menu'),
('4253190001c1480fb0d631d64d150535','编辑用户','2',NULL,NULL,2,3,'010102','editUser'),
('42dd5ae31e3a43b3a197440e8ec19a94','监控列表','f5a20c82110b4a3ea9e30ca01a038680',NULL,NULL,1,3,'010701','monitorList'),
('47905f6346cd470ea2a9810363f70bbb','列表','5bb55dd90ba44db39d6e3d7f3f316af0',NULL,NULL,1,3,'020201','listCommodityType'),
('488ef1eff57b4827acade7c0744278ce','查看菜单列表','4',NULL,NULL,0,3,'010300','listMenu'),
('4b443464de7e4be19bb2c5da309e5de4','新增','e31295ffc3b64788894b2dff7814d5cc',NULL,NULL,2,3,'020302','addCommodity'),
('4e816a9854714d24b0413d929d637a2b','查看部门列表','22e38e885f9b40b9aae6a36deb78e89c',NULL,NULL,0,3,'010400','listDept'),
('5','业务日志','1','/system/log/list/1','fa-info-circle',5,2,'0105','log'),
('522a5c58827c479c94704f7ffc774837','新增','d5bfbbf27a65455aba6063773533afee',NULL,NULL,2,3,'020402','addCommodityTrans'),
('5570376f5c564396a02522dddc681974','修改','f8db3e5b12d04a46b07026e2828791fc',NULL,NULL,4,3,'020104','updateServer'),
('5bb55dd90ba44db39d6e3d7f3f316af0','商品类型','661a1f4a6ec94fa89ec6f90ce77a8eb3','/jx3/commodityType/list',' fa-futbol-o',2,2,'0202',NULL),
('5d3dd56c16ff4e32aecae1b3228159c7','查看日志列表','5',NULL,NULL,0,3,'010500','listLog'),
('60dda993d87647f5989c15f14f866df9','新增角色','3',NULL,NULL,1,3,'010201','addRole'),
('649b484b58414d91aefa5a26143e6557','删除用户','2',NULL,NULL,3,3,'010103','deleteUser'),
('661a1f4a6ec94fa89ec6f90ce77a8eb3','剑网三数据管理','0',NULL,'fa-database',1,1,'02',NULL),
('686630c7cb624cc786dcdc9958971a6b','编辑角色','3',NULL,NULL,2,3,'010202','editRole'),
('79d78b8357174cac8f44abd275dec597','删除部门','22e38e885f9b40b9aae6a36deb78e89c',NULL,NULL,3,3,'010403','deleteDept'),
('85834e88f1f842338f3394d47b3b6180','列表','e31295ffc3b64788894b2dff7814d5cc',NULL,NULL,1,3,'020301','listCommodity'),
('915c309ebe5047b68645b3eb777dd8c9','操作系统设置','10',NULL,NULL,1,3,'010601','doSetting'),
('9f421351e51b4b888e5d8fb3e2901867','删除','d5bfbbf27a65455aba6063773533afee',NULL,NULL,4,3,'020404','deleteCommodityTrans'),
('a5ebf29168234406939856bc6890c86b','角色授权','3',NULL,NULL,4,3,'010204','authRole'),
('a73802e513cc4465883530ec8074abbb','新增用户','2',NULL,NULL,1,3,'010101','addUser'),
('b4e7232189b14cf3ba160cf7b0d3bf37','删除角色','3',NULL,NULL,3,3,'010203','deleteRole'),
('b92efe8371c94863a8e0e932e24fe9fa','新增商品','5bb55dd90ba44db39d6e3d7f3f316af0',NULL,NULL,2,3,'020202','addCommodityType'),
('d2bc30feb5474a1bb7e02d48d39a3f8a','查看用户列表','2',NULL,NULL,0,3,'010100','listUser'),
('d5bfbbf27a65455aba6063773533afee','成交列表','661a1f4a6ec94fa89ec6f90ce77a8eb3','/jx3/commodityTrans/list',' fa-rmb',4,2,'0204',NULL),
('da4a99044b954a968152d599ffe2a2a2','删除','e31295ffc3b64788894b2dff7814d5cc',NULL,NULL,4,3,'020304','deleteCommodity'),
('dc5f478d98ed4297a8ae638fe90df050','编辑菜单','4',NULL,NULL,3,3,'010302','editMenu'),
('e13f14dbc1f54e04b742487717184e86','修改','d5bfbbf27a65455aba6063773533afee',NULL,NULL,3,3,'020403','updateCommodityTrans'),
('e31295ffc3b64788894b2dff7814d5cc','商品管理','661a1f4a6ec94fa89ec6f90ce77a8eb3','/jx3/commodity/list','fa-cubes',3,2,'0203',NULL),
('e4b0f82842204e059daa0846c7ddeb2a','修改','e31295ffc3b64788894b2dff7814d5cc',NULL,NULL,3,3,'020303','updateCommodity'),
('f5a20c82110b4a3ea9e30ca01a038680','系统监控','1','/system/monitor/list','fa-eye',7,2,'0107',NULL),
('f899f3d3baec4571b1c786717f9906fd','批量删除角色','3',NULL,NULL,5,3,'010205','deleteBatchRole'),
('f8db3e5b12d04a46b07026e2828791fc','区服管理','661a1f4a6ec94fa89ec6f90ce77a8eb3','/jx3/serverInfo/list','fa-list-ol',1,2,'0201',NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `roleName` varchar(50) NOT NULL COMMENT '角色名称',
  `roleDesc` varchar(300) DEFAULT NULL COMMENT '角色描述',
  `roleState` int(2) DEFAULT '1' COMMENT '状态,1-启用,-1禁用',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`roleName`,`roleDesc`,`roleState`,`createTime`) values
('2bb56bc13810440dbdf0e7090f6138d9','管理员','系统管理员',1,'2018-10-26 23:51:44'),
('b1f9ce5543a049be9f169a3f5e6b72a8','超级管理员','超级管理员',1,'2017-09-14 15:02:16');

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `roleId` varchar(50) NOT NULL COMMENT '角色主键',
  `menuId` varchar(50) NOT NULL COMMENT '菜单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`roleId`,`menuId`) values
('0189e04466654f41a2ad20c5e11f385a','b1f9ce5543a049be9f169a3f5e6b72a8','2'),
('05ef6a4b2a9046b3b58c01868468c563','2bb56bc13810440dbdf0e7090f6138d9','4b443464de7e4be19bb2c5da309e5de4'),
('073521c305d04267b8393eb59e00fb9b','2bb56bc13810440dbdf0e7090f6138d9','b92efe8371c94863a8e0e932e24fe9fa'),
('098bcb37df0d42dc83c2cc78c769f063','2bb56bc13810440dbdf0e7090f6138d9','e13f14dbc1f54e04b742487717184e86'),
('0fe0151203d545dcac0a26b7f3291307','b1f9ce5543a049be9f169a3f5e6b72a8','649b484b58414d91aefa5a26143e6557'),
('1089fae0a4eb475aaf3f9f5035bb3e71','b1f9ce5543a049be9f169a3f5e6b72a8','5d3dd56c16ff4e32aecae1b3228159c7'),
('1a1afd326acd4a8a89a95312e64de2e2','2bb56bc13810440dbdf0e7090f6138d9','040a3d8d02fc4a6584e3521bd05ce759'),
('1a6b67648b9243e4bae877eb229c5f20','b1f9ce5543a049be9f169a3f5e6b72a8','3cf40690f3f0475da4307c8588d2f45e'),
('1c9c94ba85b44895a9dfabe85d1fd8b7','b1f9ce5543a049be9f169a3f5e6b72a8','85834e88f1f842338f3394d47b3b6180'),
('23ac73c2b7a840209e7f30df9d5692c1','b1f9ce5543a049be9f169a3f5e6b72a8','4b443464de7e4be19bb2c5da309e5de4'),
('2b5ef43c4bcb49478baf44df89385205','2bb56bc13810440dbdf0e7090f6138d9','5570376f5c564396a02522dddc681974'),
('30fb822ad57d4de28cfa97efaa5bbf98','b1f9ce5543a049be9f169a3f5e6b72a8','3fb6a7a5935b4efabf3de82e7e1baeb6'),
('338ad3e50e414104b23476ea2259d168','2bb56bc13810440dbdf0e7090f6138d9','a73802e513cc4465883530ec8074abbb'),
('37ef31bee36a44a28b727d8992fa0739','b1f9ce5543a049be9f169a3f5e6b72a8','488ef1eff57b4827acade7c0744278ce'),
('3b25e8cc1dd044e2b348e5d82950575c','b1f9ce5543a049be9f169a3f5e6b72a8','a73802e513cc4465883530ec8074abbb'),
('3e221cbaf25c42b5bee181e91925908d','b1f9ce5543a049be9f169a3f5e6b72a8','e4b0f82842204e059daa0846c7ddeb2a'),
('3f06c9bb22c64816ae304ecdc34d18a2','b1f9ce5543a049be9f169a3f5e6b72a8','22e38e885f9b40b9aae6a36deb78e89c'),
('42fa098dfa60441db4d0b7d4b191a19f','2bb56bc13810440dbdf0e7090f6138d9','e4b0f82842204e059daa0846c7ddeb2a'),
('4363b3e69b9946f39d392dd22ebddcae','2bb56bc13810440dbdf0e7090f6138d9','5bb55dd90ba44db39d6e3d7f3f316af0'),
('44117bd3712e4eedbef4de2327a7f3bc','2bb56bc13810440dbdf0e7090f6138d9','2'),
('452453758c494ac298b554f8af6424c7','b1f9ce5543a049be9f169a3f5e6b72a8','5bb55dd90ba44db39d6e3d7f3f316af0'),
('4714bf43fee54357a8b35847e912795d','2bb56bc13810440dbdf0e7090f6138d9','da4a99044b954a968152d599ffe2a2a2'),
('4b579829b0a348668b031f16ab94b346','b1f9ce5543a049be9f169a3f5e6b72a8','915c309ebe5047b68645b3eb777dd8c9'),
('4d10487a814a4ffda6e9a5ca122b11df','b1f9ce5543a049be9f169a3f5e6b72a8','040a3d8d02fc4a6584e3521bd05ce759'),
('4f5391411bfb42e18d1b60a210f61b57','2bb56bc13810440dbdf0e7090f6138d9','d2bc30feb5474a1bb7e02d48d39a3f8a'),
('517d0dd5207642a8a5a923215c881f9b','b1f9ce5543a049be9f169a3f5e6b72a8','f899f3d3baec4571b1c786717f9906fd'),
('52504f13e26347aca5a8ea20b23228ab','b1f9ce5543a049be9f169a3f5e6b72a8','dc5f478d98ed4297a8ae638fe90df050'),
('548fe990f1874654a0b483041c4a1c57','b1f9ce5543a049be9f169a3f5e6b72a8','b4e7232189b14cf3ba160cf7b0d3bf37'),
('5502f9aa3cce48b589c732ef39a19a72','b1f9ce5543a049be9f169a3f5e6b72a8','10'),
('629238add94d4812837d45d134f0fa31','b1f9ce5543a049be9f169a3f5e6b72a8','363a778e78a346a68210b2590163a943'),
('64a6aede1bff4f9f86b2fcda87eedb1a','b1f9ce5543a049be9f169a3f5e6b72a8','60dda993d87647f5989c15f14f866df9'),
('6719724e552b45b29b928b239c3646bb','b1f9ce5543a049be9f169a3f5e6b72a8','e31295ffc3b64788894b2dff7814d5cc'),
('72bd2f4def8e4d6ab0b435db41a00a2e','b1f9ce5543a049be9f169a3f5e6b72a8','5'),
('74a6e53da0dc4518b1faa747bdace5ed','b1f9ce5543a049be9f169a3f5e6b72a8','661a1f4a6ec94fa89ec6f90ce77a8eb3'),
('76b578128aea4c89aa0b2d17dd965d52','b1f9ce5543a049be9f169a3f5e6b72a8','f8db3e5b12d04a46b07026e2828791fc'),
('78a190b835c343edae8959a27c6cdf9c','2bb56bc13810440dbdf0e7090f6138d9','0f57e022f642406997f4b469533ed3ad'),
('9105feee0756479a83014c5d9bf8fbcf','2bb56bc13810440dbdf0e7090f6138d9','e31295ffc3b64788894b2dff7814d5cc'),
('987b05348caf47c4ad9d6ee933208feb','2bb56bc13810440dbdf0e7090f6138d9','85834e88f1f842338f3394d47b3b6180'),
('98cca4fa95c04ac8a42610134603bf92','2bb56bc13810440dbdf0e7090f6138d9','2e827fa3927e4fb68de3ca6a8a0eb416'),
('a9fa8f5af1404d54a2ec1c605065f3dc','b1f9ce5543a049be9f169a3f5e6b72a8','522a5c58827c479c94704f7ffc774837'),
('ac3cca67bb8c43dbad63b00eb5a3c914','b1f9ce5543a049be9f169a3f5e6b72a8','42dd5ae31e3a43b3a197440e8ec19a94'),
('ac7b1d7e302e477383ec73ae0be90102','b1f9ce5543a049be9f169a3f5e6b72a8','05b0d6ac3d354dc58b0462ce21af7897'),
('ae2b24b487f54a5fa21d2c0b6a15c336','b1f9ce5543a049be9f169a3f5e6b72a8','0f57e022f642406997f4b469533ed3ad'),
('b714ee2c9d334285833c181e57dc8d3b','b1f9ce5543a049be9f169a3f5e6b72a8','d2bc30feb5474a1bb7e02d48d39a3f8a'),
('b8c7bb20ce7845d69752e96d26084fa0','b1f9ce5543a049be9f169a3f5e6b72a8','4'),
('bd1266b2b8f644c78f50c67cff48c52b','b1f9ce5543a049be9f169a3f5e6b72a8','9f421351e51b4b888e5d8fb3e2901867'),
('bd7b7380bd8f49e1b99eecd53a9debd4','b1f9ce5543a049be9f169a3f5e6b72a8','5570376f5c564396a02522dddc681974'),
('c0eec4f8d59e4baf9c998c66b3d5cce3','b1f9ce5543a049be9f169a3f5e6b72a8','79d78b8357174cac8f44abd275dec597'),
('c55479dd9ae14a73b39dd7e5d894c94e','2bb56bc13810440dbdf0e7090f6138d9','22c9d12fb3e94969818553eff3b44acf'),
('c70ac616ee41465fb008415eb5907cab','2bb56bc13810440dbdf0e7090f6138d9','05b0d6ac3d354dc58b0462ce21af7897'),
('c9c6c7b3e14e436a9733f892697fc6dd','2bb56bc13810440dbdf0e7090f6138d9','661a1f4a6ec94fa89ec6f90ce77a8eb3'),
('ca176a1d7eef4cbd92f5297f2844a1d4','2bb56bc13810440dbdf0e7090f6138d9','f8db3e5b12d04a46b07026e2828791fc'),
('ca70d6be723047229edac6d9309904f5','b1f9ce5543a049be9f169a3f5e6b72a8','1db9105008404a3485b6fac30dba3c0e'),
('cc0b1481f86a46569aa8f7a900b319b0','b1f9ce5543a049be9f169a3f5e6b72a8','f5a20c82110b4a3ea9e30ca01a038680'),
('cc1d99b93f0e48f7934a1ebe579faa39','b1f9ce5543a049be9f169a3f5e6b72a8','47905f6346cd470ea2a9810363f70bbb'),
('d4bedb3446374a7ea883b8642aa6fd26','2bb56bc13810440dbdf0e7090f6138d9','522a5c58827c479c94704f7ffc774837'),
('d50d1ef1106e4f36a62ce0b13b1125cb','2bb56bc13810440dbdf0e7090f6138d9','4253190001c1480fb0d631d64d150535'),
('d5ac0da495e44e45b3859c99b2c8c0b6','b1f9ce5543a049be9f169a3f5e6b72a8','2e827fa3927e4fb68de3ca6a8a0eb416'),
('d5bbe7416fd34264966eaf2146ead88e','2bb56bc13810440dbdf0e7090f6138d9','9f421351e51b4b888e5d8fb3e2901867'),
('db44e60d51ab487a8e5d26d35e093404','b1f9ce5543a049be9f169a3f5e6b72a8','3'),
('e181c7770b8e4e40bdcd0fa504d415fc','b1f9ce5543a049be9f169a3f5e6b72a8','e13f14dbc1f54e04b742487717184e86'),
('e1c1d45e43e04f40a4cd50920b2ece42','2bb56bc13810440dbdf0e7090f6138d9','d5bfbbf27a65455aba6063773533afee'),
('e2da09fb5111499f81335c804a44fdb5','b1f9ce5543a049be9f169a3f5e6b72a8','da4a99044b954a968152d599ffe2a2a2'),
('e480ffd5d78d4742b9b27052631380ce','b1f9ce5543a049be9f169a3f5e6b72a8','686630c7cb624cc786dcdc9958971a6b'),
('e4df70ab46b2459d9639f6006e016a7b','b1f9ce5543a049be9f169a3f5e6b72a8','3f26102ef0e04c3c9328cb97067cc5fa'),
('e6f8d62765c145e481e181f53ff1040f','b1f9ce5543a049be9f169a3f5e6b72a8','22c9d12fb3e94969818553eff3b44acf'),
('e781749c470e4f21a927cd2f6108a2b8','b1f9ce5543a049be9f169a3f5e6b72a8','1'),
('e987f86f258d4f6fbcd9998fcb770de5','2bb56bc13810440dbdf0e7090f6138d9','1'),
('ea7b94df619d4f019b8430cb7ef0d502','b1f9ce5543a049be9f169a3f5e6b72a8','d5bfbbf27a65455aba6063773533afee'),
('edc9e759617c4c779bf205271e639aeb','b1f9ce5543a049be9f169a3f5e6b72a8','0c9b5fc8b44b41d1871a8fc8300247ec'),
('f3c3a44fa1b94f238860a39a30b7ec19','b1f9ce5543a049be9f169a3f5e6b72a8','a5ebf29168234406939856bc6890c86b'),
('f66c335f80f44b26b2aaa5f73f85d7c0','b1f9ce5543a049be9f169a3f5e6b72a8','0818e1c76bbd44eba3a698547ec4e637'),
('fa03fa4bf7804e3faccf200f64a38e5a','b1f9ce5543a049be9f169a3f5e6b72a8','b92efe8371c94863a8e0e932e24fe9fa'),
('fab781d4d644433ea0bd8e1d79ecfdcd','b1f9ce5543a049be9f169a3f5e6b72a8','4e816a9854714d24b0413d929d637a2b'),
('fbb164ac96d84bddb851c58ae9ab158e','b1f9ce5543a049be9f169a3f5e6b72a8','4253190001c1480fb0d631d64d150535'),
('ff51a319589f450ea04b5dc7fba7c39c','2bb56bc13810440dbdf0e7090f6138d9','3cf40690f3f0475da4307c8588d2f45e'),
('ffe292d921be403abb2ecea31d0b0d8f','2bb56bc13810440dbdf0e7090f6138d9','47905f6346cd470ea2a9810363f70bbb');

/*Table structure for table `sys_setting` */

DROP TABLE IF EXISTS `sys_setting`;

CREATE TABLE `sys_setting` (
  `Id` varchar(50) NOT NULL COMMENT '主键',
  `sysKey` varchar(50) NOT NULL COMMENT 'KEY',
  `sysName` varchar(50) NOT NULL COMMENT '名称',
  `sysValue` varchar(300) DEFAULT NULL COMMENT '值',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `sysDesc` varchar(300) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统设置表';

/*Data for the table `sys_setting` */

insert  into `sys_setting`(`Id`,`sysKey`,`sysName`,`sysValue`,`sort`,`sysDesc`) values
('1','systemName','系统名称','大唐市场监督管理局',0,NULL),
('2','systemSubName','系统简称','jx3',1,NULL),
('3','bottomCopyright','许可说明','zhaox',2,NULL);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `userName` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `userState` int(2) NOT NULL DEFAULT '1' COMMENT '用户状态,1-启用,-1禁用',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `userDesc` varchar(300) DEFAULT NULL COMMENT '描述',
  `userImg` varchar(300) DEFAULT 'http://news.mydrivers.com/Img/20110518/04481549.png' COMMENT '头像',
  `deptId` varchar(50) DEFAULT NULL COMMENT '部门主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`userName`,`password`,`userState`,`createTime`,`userDesc`,`userImg`,`deptId`) values
('30747fc7528146fea1b156e9f6e20064','cll','49e65c2e97e586c9c55203dcaa09f96c',1,'2018-10-26 23:54:16','','http://news.mydrivers.com/Img/20110518/04481549.png','9a329b597d754c4180c6b40cdfb0f565'),
('c79ba431f9f74dfbae585b87b0cde933','admin','038bdaf98f2037b31f1e75b5b4c9b26e',1,'2017-09-14 15:02:17','','fgieyewfu720ipx5rbkyl3yoezaozscu.png','9a329b597d754c4180c6b40cdfb0f565');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `Id` varchar(50) NOT NULL COMMENT '主键',
  `userId` varchar(50) NOT NULL COMMENT '用户主键',
  `roleId` varchar(50) NOT NULL COMMENT '角色主键',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`Id`,`userId`,`roleId`) values
('7d32e28ee3d1452d952f29764e989bab','c79ba431f9f74dfbae585b87b0cde933','b1f9ce5543a049be9f169a3f5e6b72a8'),
('df6a678ae0a84ca8add168a71977af90','30747fc7528146fea1b156e9f6e20064','2bb56bc13810440dbdf0e7090f6138d9');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
