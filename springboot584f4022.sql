-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springboot584f4022
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `springboot584f4022`
--

/*!40000 DROP DATABASE IF EXISTS `springboot584f4022`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `springboot584f4022` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springboot584f4022`;

--
-- Table structure for table `baofeishenqing`
--

DROP TABLE IF EXISTS `baofeishenqing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baofeishenqing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `shenqingshijian` date DEFAULT NULL COMMENT '申请时间',
  `baofeiyuanyin` longtext COLLATE utf8mb4_unicode_ci COMMENT '报废原因',
  `nonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  `jishuyuanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员账号',
  `jishuyuanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员姓名',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='报废申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baofeishenqing`
--

LOCK TABLES `baofeishenqing` WRITE;
/*!40000 ALTER TABLE `baofeishenqing` DISABLE KEYS */;
INSERT INTO `baofeishenqing` VALUES (1,'2026-01-05 02:46:19','春芽一号棚','苗床架','育苗设备','upload/baofeishenqing_苗床架1.jpg,upload/baofeishenqing_苗床架2.jpg,upload/baofeishenqing_苗床架3.jpg','2023-07-11','此处文本编辑框是内容详细的操作提示，您可以对现有文字进行修改，包括删除多余文字、替换不合适的表述等；插入图片时，既可以从本地选择图片上传，图片插入后会直接展示在编辑框中，完成操作后点击空白区域即可保存。','108','王静','3003','张鹏','是',''),(2,'2026-01-05 02:46:19','汇农八号棚','喷雾器','植保设备','upload/baofeishenqing_喷雾器1.jpg,upload/baofeishenqing_喷雾器2.jpg,upload/baofeishenqing_喷雾器3.jpg','2025-08-20','此编辑框内的默认内容为可编辑状态，您可对文字进行修改，比如调整语句顺序、更换文字内容等；插入图片时，支持上传图片，上传后图片会直接在编辑框中展示，也能一键删除不需要的图片。','106','李静','3005','谢伟','是',''),(3,'2026-01-05 02:46:19','冬韵四号棚','温控器','环境控制设备','upload/baofeishenqing_温控器1.jpg,upload/baofeishenqing_温控器2.jpg,upload/baofeishenqing_温控器3.jpg','2023-04-27','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','102','刘洋','3006','郑涛','是',''),(4,'2026-01-05 02:46:19','玉润十九号棚','臭氧发生器','消毒设备','upload/baofeishenqing_臭氧发生器1.jpg,upload/baofeishenqing_臭氧发生器2.jpg,upload/baofeishenqing_臭氧发生器3.jpg','2025-08-03','编辑框中展示的默认内容仅为示例，您可任意修改其中的文字表述，比如更换词语、调整语句顺序等；当需要插入图片时，点击编辑框上方的 “插入图片” 按钮，上传图片后即可直接在编辑框中展示。','103','李军','3007','梁杰','是',''),(5,'2026-01-05 02:46:19','碧影十五号棚','气象站','环境监测设备','upload/baofeishenqing_气象站1.jpg,upload/baofeishenqing_气象站2.jpg,upload/baofeishenqing_气象站3.jpg','2023-02-25','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','104','赵刚','3002','刘强','是',''),(6,'2026-01-05 02:46:19','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/baofeishenqing_二氧化碳发生器1.jpg,upload/baofeishenqing_二氧化碳发生器2.jpg,upload/baofeishenqing_二氧化碳发生器3.jpg','2025-05-15','您看到的编辑框内默认提示可作为创作起点，支持对现有内容进行全面修改，包括删除冗余文字、替换表述方式等；插入图片时，既可以从本地上传，也能粘贴网络图片地址，图片插入后会直接在文本中展示，完成后点击空白处即可保存设置。​','101','李娜','3008','胡伟','是',''),(7,'2026-01-05 02:46:19','翠玉十三号棚','除雾器','环境调节设备','upload/baofeishenqing_除雾器1.jpg,upload/baofeishenqing_除雾器2.jpg,upload/baofeishenqing_除雾器3.jpg','2023-04-10','此处文本编辑框是内容详细的操作提示，您能轻松对框内文字进行修改，像更正错误文字、调整文字内容等都能实现；插入图片的话，点击工具栏上的图片按钮，选择要插入的图片，图片就会在编辑框中展示，支持随时再次编辑。','105','赵伟','3004','吴敏','是',''),(8,'2026-01-05 02:46:19','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/baofeishenqing_水肥一体机1.jpg,upload/baofeishenqing_水肥一体机2.jpg,upload/baofeishenqing_水肥一体机3.jpg','2024-06-30','此编辑框内已详情的内容，您可以直接对现有文字进行修改，无论是调整文字内容、更正表述还是增减文字数量都能实现；若需插入图片，只需点击上方工具栏的图片图标，选择本地文件或输入图片链接即可插入展示，所有操作完成后提交后系统会保存您的修改。​','107','王明','3001','罗琳','是',''),(9,'2026-01-05 03:19:08','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','2026-01-05','<p>设备报废</p>','11','李思思','22','张毅','是','好');
/*!40000 ALTER TABLE `baofeishenqing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chanliangxinxi`
--

DROP TABLE IF EXISTS `chanliangxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chanliangxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `zuowumingcheng` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作物名称',
  `zuowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作物类型',
  `zhouqi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '周期',
  `zuowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '作物图片',
  `zhongzhimianji` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '种植面积㎡',
  `shouhuoshijian` date DEFAULT NULL COMMENT '收获时间',
  `shouhuoshuliang` int(11) DEFAULT NULL COMMENT '收获数量(吨/㎡)',
  `nonghuzhanghao` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产量信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chanliangxinxi`
--

LOCK TABLES `chanliangxinxi` WRITE;
/*!40000 ALTER TABLE `chanliangxinxi` DISABLE KEYS */;
INSERT INTO `chanliangxinxi` VALUES (1,'2026-01-05 02:46:18','春芽一号棚','油菜','十字花科','35天','upload/chanliangxinxi_油菜1.jpg,upload/chanliangxinxi_油菜2.jpg,upload/chanliangxinxi_油菜3.jpg','2.0亩','2026-01-05',39000,'108','王静'),(2,'2026-01-05 02:46:18','汇农八号棚','番茄','茄果类','90天','upload/chanliangxinxi_番茄1.jpg,upload/chanliangxinxi_番茄2.jpg,upload/chanliangxinxi_番茄3.jpg','0.8亩','2026-01-05',45000,'106','李静'),(3,'2026-01-05 02:46:18','冬韵四号棚','豆角','豆类','85天','upload/chanliangxinxi_豆角1.jpg,upload/chanliangxinxi_豆角2.jpg,upload/chanliangxinxi_豆角3.jpg','1.1亩','2026-01-05',10000,'102','刘洋'),(4,'2026-01-05 02:46:18','玉润十九号棚','大葱','百合科','120天','upload/chanliangxinxi_大葱1.jpg,upload/chanliangxinxi_大葱2.jpg,upload/chanliangxinxi_大葱3.jpg','1.5亩','2026-01-05',49500,'103','李军'),(5,'2026-01-05 02:46:18','碧影十五号棚','白萝卜','根茎类','60天','upload/chanliangxinxi_白萝卜1.jpg,upload/chanliangxinxi_白萝卜2.jpg,upload/chanliangxinxi_白萝卜3.jpg','1.8亩','2026-01-05',36800,'104','赵刚'),(6,'2026-01-05 02:46:18','晨光十七号棚','菠菜','叶菜类','30天','upload/chanliangxinxi_菠菜1.jpg,upload/chanliangxinxi_菠菜2.jpg,upload/chanliangxinxi_菠菜3.jpg','1.5亩','2026-01-05',47800,'101','李娜'),(7,'2026-01-05 02:46:18','翠玉十三号棚','苦瓜','瓜类','100天','upload/chanliangxinxi_苦瓜1.jpg,upload/chanliangxinxi_苦瓜2.jpg,upload/chanliangxinxi_苦瓜3.jpg','0.7亩','2026-01-05',33000,'105','赵伟'),(8,'2026-01-05 02:46:18','晶彩七号棚','青椒','茄果类','100天','upload/chanliangxinxi_青椒1.jpg,upload/chanliangxinxi_青椒2.jpg,upload/chanliangxinxi_青椒3.jpg','0.6亩','2026-01-05',12800,'107','王明'),(9,'2026-01-05 03:17:50','夏荷二号棚','草莓','浆果类','120天','upload/1767582613705_30.jpg','0.5','2026-01-05',20,'11','李思思');
/*!40000 ALTER TABLE `chanliangxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `adminid` bigint(20) DEFAULT NULL COMMENT '管理员id',
  `ask` longtext COLLATE utf8mb4_unicode_ci COMMENT '提问',
  `reply` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复',
  `isreply` int(11) DEFAULT NULL COMMENT '是否回复',
  `isread` int(11) DEFAULT '0' COMMENT '已读/未读(1:已读,0:未读)',
  `uname` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `uimage` longtext COLLATE utf8mb4_unicode_ci COMMENT '用户头像',
  `type` int(11) DEFAULT '1' COMMENT '内容类型(1:文本,2:图片,3:视频,4:文件,5:表情)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='AI种植助手';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (1,'2026-01-05 02:46:19',1,1,'提问1','回复1',1,1,'用户名1','upload/chat_uimage1.jpg,upload/chat_uimage2.jpg,upload/chat_uimage3.jpg',1),(2,'2026-01-05 02:46:19',2,2,'提问2','回复2',2,2,'用户名2','upload/chat_uimage2.jpg,upload/chat_uimage3.jpg,upload/chat_uimage4.jpg',2),(3,'2026-01-05 02:46:19',3,3,'提问3','回复3',3,3,'用户名3','upload/chat_uimage3.jpg,upload/chat_uimage4.jpg,upload/chat_uimage5.jpg',3),(4,'2026-01-05 02:46:19',4,4,'提问4','回复4',4,4,'用户名4','upload/chat_uimage4.jpg,upload/chat_uimage5.jpg,upload/chat_uimage6.jpg',4),(5,'2026-01-05 02:46:19',5,5,'提问5','回复5',5,5,'用户名5','upload/chat_uimage5.jpg,upload/chat_uimage6.jpg,upload/chat_uimage7.jpg',5),(6,'2026-01-05 02:46:19',6,6,'提问6','回复6',6,6,'用户名6','upload/chat_uimage6.jpg,upload/chat_uimage7.jpg,upload/chat_uimage8.jpg',6),(7,'2026-01-05 02:46:19',7,7,'提问7','回复7',7,7,'用户名7','upload/chat_uimage7.jpg,upload/chat_uimage8.jpg,upload/chat_uimage1.jpg',7),(8,'2026-01-05 02:46:19',8,8,'提问8','回复8',8,8,'用户名8','upload/chat_uimage8.jpg,upload/chat_uimage1.jpg,upload/chat_uimage2.jpg',8),(9,'2026-01-05 02:54:50',1767581670729,1767581670729,NULL,'您好，有什么可以帮您？',0,0,NULL,NULL,1),(10,'2026-01-05 02:55:06',1767581670729,NULL,'如何提高草莓产量',NULL,0,0,'11','upload/1767581667146_792.jpg',1),(11,'2026-01-05 02:55:50',1767581670729,1767581670729,NULL,'提高草莓产量需要从品种选择、种植环境优化、水肥管理、植株养护、病虫害防治以及辅助技术等多个方面综合施策。以下是具体措施：\n\n### 一、选择优质品种\n- **抗病性强**：选择抗病性好的品种，如“红颜”“章姬”等，可减少因病害导致的减产。\n- **适应性强**：根据当地气候和土壤条件，选择适应性强的品种，确保草莓能在当地环境中良好生长。\n- **高产优质**：选择高产且果实品质好的品种，如“甜查理”“丰香”等，提高单位面积产量和经济效益。\n\n### 二、优化种植环境\n- **土壤管理**：\n  - **土壤改良**：草莓适宜生长在疏松、肥沃、排水良好的土壤中。种植前可进行土壤改良，如添加腐熟有机肥、珍珠岩等，提高土壤肥力和透气性。\n  - **土壤消毒**：定期对土壤进行消毒处理，如使用太阳能消毒法或化学消毒剂，减少土壤中的病菌和虫卵，降低病虫害发生率。\n- **光照管理**：\n  - **合理密植**：根据品种特性和土壤肥力，合理安排种植密度，避免过密导致通风透光不良，影响光合作用和果实发育。\n  - **清洁棚膜**：对于设施栽培的草莓，定期清洁棚膜，增加透光率，确保草莓植株获得充足的光照。\n- **温度管理**：\n  - **控制温差**：草莓生长适宜温度为15-25℃，开花结果期温度控制在20-25℃为宜。通过调节通风口大小、使用遮阳网等方式，控制棚内温度，避免高温或低温对草莓生长造成不利影响。\n  - **冬季保温**：在冬季寒冷地区，采取保温措施，如覆盖地膜、使用保温被等，提高土壤温度，促进草莓根系生长和养分吸收。\n\n### 三、科学水肥管理\n- **水分管理**：\n  - **合理灌溉**：草莓根系浅，对水分敏感。应根据土壤湿度和草莓生长阶段，合理灌溉，保持土壤湿润但不过湿。避免大水漫灌导致土壤积水，影响根系呼吸和养分吸收。\n  - **滴灌技术**：采用滴灌技术进行灌溉，可精确控制水量和水分分布，提高水分利用效率，减少水分浪费和病害发生。\n- **肥料管理**：\n  - **基肥施足**：种植前施足基肥，以有机肥为主，配合适量化肥，为草莓生长提供充足的养分基础。\n  - **追肥适时**：根据草莓生长阶段和养分需求，适时追肥。如开花前追施磷钾肥，促进花芽分化和开花结果；果实膨大期追施氮磷钾复合肥，促进果实发育和品质提升。\n  - **叶面喷肥**：在草莓生长过程中，可定期喷施叶面肥，如磷酸二氢钾、硼肥等，补充植株所需微量元素，提高光合作用效率和果实品质。\n\n### 四、加强植株养护\n- **植株整理**：\n  - **摘除老叶**：及时摘除草莓植株上的老叶、病叶和残叶，减少养分消耗和病害传播。\n  - **疏花疏果**：根据植株生长情况和果实品质要求，合理疏花疏果。去除弱花、弱果和畸形果，保留健壮的花果，提高果实品质和产量。\n- **辅助授粉**：\n  - **蜜蜂授粉**：在草莓开花期，引入蜜蜂进行授粉，可提高授粉效率和果实坐果率。\n  - **人工授粉**：在无蜜蜂或蜜蜂授粉效果不佳的情况下，可采用人工授粉方式，如用毛笔或棉签蘸取花粉涂抹在雌蕊上，促进授粉受精。\n\n### 五、病虫害防治\n- **预防为主**：坚持“预防为主，综合治理”的原则，通过改善种植环境、增强植株抗病性等方式，减少病虫害发生。\n- **生物防治**：利用天敌、微生物等生物制剂进行病虫害防治，如释放捕食螨防治红蜘蛛、使用枯草芽孢杆菌防治白粉病等。\n- **化学防治**：在病虫害发生严重时，可选用高效、低毒、低残留的化学农药进行防治。但应注意轮换用药和合理混用，避免产生抗药性和药害。\n\n### 六、应用辅助技术\n- **使用植物生长调节剂**：在草莓生长过程中，可合理使用植物生长调节剂，如赤霉素、细胞分裂素等，促进植株生长和果实发育。但应注意使用浓度和次数，避免过量使用导致植株徒长或果实畸形。\n- **采用无土栽培技术**：无土栽培技术可避免土壤连作障碍和病虫害问题，提高草莓产量和品质。如采用基质栽培、水培等方式进行草莓种植。\n- **应用智能农业技术**：利用智能农业技术，如物联网、大数据等，对草莓生长环境进行实时监测和调控，实现精准灌溉、精准施肥和精准病虫害防治，提高草莓产量和品质。',NULL,0,NULL,NULL,1);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chatmessage`
--

DROP TABLE IF EXISTS `chatmessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chatmessage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `fid` bigint(20) NOT NULL COMMENT '好友用户ID',
  `content` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容',
  `format` int(11) DEFAULT NULL COMMENT '格式(1:文字，2:图片)',
  `isread` int(11) DEFAULT '0' COMMENT '消息已读(0:未读，1:已读)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='消息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatmessage`
--

LOCK TABLES `chatmessage` WRITE;
/*!40000 ALTER TABLE `chatmessage` DISABLE KEYS */;
INSERT INTO `chatmessage` VALUES (1,'2026-01-05 03:08:26',1767581670729,28,'在线咨询',1,0),(2,'2026-01-05 03:20:22',1767581670729,1767581811405,'在线咨询',1,1),(3,'2026-01-05 03:20:37',1767581811405,1767581670729,'好',1,1);
/*!40000 ALTER TABLE `chatmessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(200) DEFAULT NULL COMMENT '配置参数值',
  `url` varchar(500) DEFAULT NULL COMMENT 'url',
  `type` int(11) DEFAULT NULL COMMENT '参数类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg',NULL,1),(2,'picture2','upload/picture2.jpg',NULL,1),(3,'picture3','upload/1767582460467_359.jpg',NULL,1),(11,'baidu','{\"appId\":\"49214550\",\"apiKey\":\"7Otjpv2kn0ljQk45qXOXh5MO\",\"secretKey\":\"BMfbXRbTIVaB4C3SbRTtGqDv1wHDvyXS\"}',NULL,2),(12,'qianfan','{\"accessKey\":\"9dd9b2ea56b042c6a468bfeada1209a3\",\"accessSecretKey\":\"45a0aa98b86b4c54b9dc8ede3cc67274\"}',NULL,2),(21,'bLoginBackgroundImg','',NULL,3),(22,'bRegisterBackgroundImg','',NULL,3),(23,'bIndexBackgroundImg','',NULL,3),(24,'bTopLogo','',NULL,3),(25,'bHomeLogo','',NULL,3),(26,'fLoginBackgroundImg','',NULL,3),(27,'fRegisterBackgroudImg','',NULL,3),(28,'fTopLogo','',NULL,3);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dapengshenqing`
--

DROP TABLE IF EXISTS `dapengshenqing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dapengshenqing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengbianhao` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '大棚编号',
  `dapengmingcheng` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '大棚名称',
  `dapengtupian` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '大棚图片',
  `dapengleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚类型',
  `wendu` int(11) DEFAULT NULL COMMENT '温度',
  `shidu` int(11) DEFAULT NULL COMMENT '湿度',
  `guangzhao` int(11) DEFAULT NULL COMMENT '光照',
  `shenqingshijian` date DEFAULT NULL COMMENT '申请时间',
  `xinyongdaima` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '信用代码',
  `hezuoshemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '合作社名称',
  `zhongzhiguihua` longtext COLLATE utf8mb4_unicode_ci COMMENT '种植规划',
  `nonghuzhanghao` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dapengbianhao` (`dapengbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='大棚申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dapengshenqing`
--

LOCK TABLES `dapengshenqing` WRITE;
/*!40000 ALTER TABLE `dapengshenqing` DISABLE KEYS */;
INSERT INTO `dapengshenqing` VALUES (1,'2026-01-05 02:46:18','GS001','春芽一号棚','upload/dapengshenqing_春芽一号棚1.jpg,upload/dapengshenqing_春芽一号棚2.jpg,upload/dapengshenqing_春芽一号棚3.jpg','日光温室',18,65,18,'2023-07-11','93500105MA2345T8U0','福临门果蔬专业合作社','此处文本编辑框是内容详细的操作提示，您可以对现有文字进行修改，包括删除多余文字、替换不合适的表述等；插入图片时，既可以从本地选择图片上传，图片插入后会直接展示在编辑框中，完成操作后点击空白区域即可保存。','108','王静',1,1,'是',''),(2,'2026-01-05 02:46:18','GS008','汇农八号棚','upload/dapengshenqing_汇农八号棚1.jpg,upload/dapengshenqing_汇农八号棚2.jpg,upload/dapengshenqing_汇农八号棚3.jpg','连栋温室',21,66,28,'2025-08-20','93340104MA5678X0Y2','绿宝果蔬专业合作社','此编辑框内的默认内容为可编辑状态，您可对文字进行修改，比如调整语句顺序、更换文字内容等；插入图片时，支持上传图片，上传后图片会直接在编辑框中展示，也能一键删除不需要的图片。','106','李静',2,2,'是',''),(3,'2026-01-05 02:46:18','GS004','冬韵四号棚','upload/dapengshenqing_冬韵四号棚1.jpg,upload/dapengshenqing_冬韵四号棚2.jpg,upload/dapengshenqing_冬韵四号棚3.jpg','连栋温室',20,68,11,'2023-04-27','93350203MA4321N5O7','绿洲果蔬专业合作社','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','102','刘洋',3,3,'是',''),(4,'2026-01-05 02:46:18','GS019','玉润十九号棚','upload/dapengshenqing_玉润十九号棚1.jpg,upload/dapengshenqing_玉润十九号棚2.jpg,upload/dapengshenqing_玉润十九号棚3.jpg','玻璃温室',22,58,16,'2025-08-03','93330109MA5432H1I4','绿禾果蔬专业合作社','编辑框中展示的默认内容仅为示例，您可任意修改其中的文字表述，比如更换词语、调整语句顺序等；当需要插入图片时，点击编辑框上方的 “插入图片” 按钮，上传图片后即可直接在编辑框中展示。','103','李军',4,4,'是',''),(5,'2026-01-05 02:46:18','GS015','碧影十五号棚','upload/dapengshenqing_碧影十五号棚1.jpg,upload/dapengshenqing_碧影十五号棚2.jpg,upload/dapengshenqing_碧影十五号棚3.jpg','玻璃温室',23,57,2,'2023-02-25','93380102MA1098H5I8','乐农果蔬专业合作社','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','104','赵刚',5,5,'是',''),(6,'2026-01-05 02:46:18','GS017','晨光十七号棚','upload/dapengshenqing_晨光十七号棚1.jpg,upload/dapengshenqing_晨光十七号棚2.jpg,upload/dapengshenqing_晨光十七号棚3.jpg','日光温室',17,64,1,'2025-05-15','93310115MA7654R7S9','绿满园果蔬专业合作社','您看到的编辑框内默认提示可作为创作起点，支持对现有内容进行全面修改，包括删除冗余文字、替换表述方式等；插入图片时，既可以从本地上传，也能粘贴网络图片地址，图片插入后会直接在文本中展示，完成后点击空白处即可保存设置。​','101','李娜',6,6,'是',''),(7,'2026-01-05 02:46:18','GS013','翠玉十三号棚','upload/dapengshenqing_翠玉十三号棚1.jpg,upload/dapengshenqing_翠玉十三号棚2.jpg,upload/dapengshenqing_翠玉十三号棚3.jpg','日光温室',18,63,7,'2023-04-10','93410108MA44K1L9P2','惠民果蔬专业合作社','此处文本编辑框是内容详细的操作提示，您能轻松对框内文字进行修改，像更正错误文字、调整文字内容等都能实现；插入图片的话，点击工具栏上的图片按钮，选择要插入的图片，图片就会在编辑框中展示，支持随时再次编辑。','105','赵伟',7,7,'是',''),(8,'2026-01-05 02:46:18','GS007','晶彩七号棚','upload/dapengshenqing_晶彩七号棚1.jpg,upload/dapengshenqing_晶彩七号棚2.jpg,upload/dapengshenqing_晶彩七号棚3.jpg','玻璃温室',23,58,24,'2024-06-30','93360102MA6789B2C5','祥和果蔬专业合作社','此编辑框内已详情的内容，您可以直接对现有文字进行修改，无论是调整文字内容、更正表述还是增减文字数量都能实现；若需插入图片，只需点击上方工具栏的图片图标，选择本地文件或输入图片链接即可插入展示，所有操作完成后提交后系统会保存您的修改。​','107','王明',8,8,'是',''),(9,'2026-01-05 03:08:07','GS002','夏荷二号棚','upload/1767582133402_907.jpg','塑料大棚',25,70,8,'2026-01-05','33','绿田野果蔬专业合作社','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>','11','李思思',1767581670729,9,'是','好');
/*!40000 ALTER TABLE `dapengshenqing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dapengxunjian`
--

DROP TABLE IF EXISTS `dapengxunjian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dapengxunjian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `shebeixinghao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备型号',
  `jilushijian` date DEFAULT NULL COMMENT '记录时间',
  `xunjianjieguo` longtext COLLATE utf8mb4_unicode_ci COMMENT '巡检结果',
  `jishuyuanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员账号',
  `jishuyuanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员姓名',
  `nonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='大棚巡检';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dapengxunjian`
--

LOCK TABLES `dapengxunjian` WRITE;
/*!40000 ALTER TABLE `dapengxunjian` DISABLE KEYS */;
INSERT INTO `dapengxunjian` VALUES (1,'2026-01-05 02:46:19','春芽一号棚','苗床架','育苗设备','upload/dapengxunjian_苗床架1.jpg,upload/dapengxunjian_苗床架2.jpg,upload/dapengxunjian_苗床架3.jpg','MC200','2026-01-05','结构稳固无变形','3003','张鹏','108','王静'),(2,'2026-01-05 02:46:19','汇农八号棚','喷雾器','植保设备','upload/dapengxunjian_喷雾器1.jpg,upload/dapengxunjian_喷雾器2.jpg,upload/dapengxunjian_喷雾器3.jpg','PW100','2026-01-05','喷雾均匀喷头无堵塞','3005','谢伟','106','李静'),(3,'2026-01-05 02:46:19','冬韵四号棚','温控器','环境控制设备','upload/dapengxunjian_温控器1.jpg,upload/dapengxunjian_温控器2.jpg,upload/dapengxunjian_温控器3.jpg','WK300','2026-01-05','温度传感器响应正常温控精准','3006','郑涛','102','刘洋'),(4,'2026-01-05 02:46:19','玉润十九号棚','臭氧发生器','消毒设备','upload/dapengxunjian_臭氧发生器1.jpg,upload/dapengxunjian_臭氧发生器2.jpg,upload/dapengxunjian_臭氧发生器3.jpg','CY200','2026-01-05','消毒效果达标无故障','3007','梁杰','103','李军'),(5,'2026-01-05 02:46:19','碧影十五号棚','气象站','环境监测设备','upload/dapengxunjian_气象站1.jpg,upload/dapengxunjian_气象站2.jpg,upload/dapengxunjian_气象站3.jpg','QX500','2026-01-05','数据精准传输稳定','3002','刘强','104','赵刚'),(6,'2026-01-05 02:46:19','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/dapengxunjian_二氧化碳发生器1.jpg,upload/dapengxunjian_二氧化碳发生器2.jpg,upload/dapengxunjian_二氧化碳发生器3.jpg','CR300','2026-01-05','产气稳定安全可靠','3008','胡伟','101','李娜'),(7,'2026-01-05 02:46:19','翠玉十三号棚','除雾器','环境调节设备','upload/dapengxunjian_除雾器1.jpg,upload/dapengxunjian_除雾器2.jpg,upload/dapengxunjian_除雾器3.jpg','CW200','2026-01-05','除雾效果良好运行稳定','3004','吴敏','105','赵伟'),(8,'2026-01-05 02:46:19','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/dapengxunjian_水肥一体机1.jpg,upload/dapengxunjian_水肥一体机2.jpg,upload/dapengxunjian_水肥一体机3.jpg','SF600','2026-01-05','配比精准灌溉均匀','3001','罗琳','107','王明'),(9,'2026-01-05 03:11:26','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','CO2500','2026-01-05','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>','22','张毅','11','李思思');
/*!40000 ALTER TABLE `dapengxunjian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '帖子标题',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父节点id',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `avatarurl` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `isdone` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态',
  `istop` int(11) DEFAULT '0' COMMENT '是否置顶',
  `toptime` datetime DEFAULT NULL COMMENT '置顶时间',
  `cover` longtext COLLATE utf8mb4_unicode_ci COMMENT '封面',
  `isanon` int(11) DEFAULT '0' COMMENT '是否匿名(1:是,0:否)',
  `delflag` int(11) DEFAULT '0' COMMENT '是否删除(1:是,0:否)',
  `userid` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='互动交流';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (1,'2026-01-05 02:46:19','帖子标题1','帖子内容1',0,'用户名1','upload/forum_avatarurl1.jpg,upload/forum_avatarurl2.jpg,upload/forum_avatarurl3.jpg','开放',0,'2026-01-05 10:46:19','upload/forum_cover1.jpg,upload/forum_cover2.jpg,upload/forum_cover3.jpg',1,0,1),(2,'2026-01-05 02:46:19','帖子标题2','帖子内容2',0,'用户名2','upload/forum_avatarurl2.jpg,upload/forum_avatarurl3.jpg,upload/forum_avatarurl4.jpg','开放',0,'2026-01-05 10:46:19','upload/forum_cover2.jpg,upload/forum_cover3.jpg,upload/forum_cover4.jpg',2,0,2),(3,'2026-01-05 02:46:19','帖子标题3','帖子内容3',0,'用户名3','upload/forum_avatarurl3.jpg,upload/forum_avatarurl4.jpg,upload/forum_avatarurl5.jpg','开放',0,'2026-01-05 10:46:19','upload/forum_cover3.jpg,upload/forum_cover4.jpg,upload/forum_cover5.jpg',3,0,3),(4,'2026-01-05 02:46:19','帖子标题4','帖子内容4',0,'用户名4','upload/forum_avatarurl4.jpg,upload/forum_avatarurl5.jpg,upload/forum_avatarurl6.jpg','开放',0,'2026-01-05 10:46:19','upload/forum_cover4.jpg,upload/forum_cover5.jpg,upload/forum_cover6.jpg',4,0,4),(5,'2026-01-05 02:46:19','帖子标题5','帖子内容5',0,'用户名5','upload/forum_avatarurl5.jpg,upload/forum_avatarurl6.jpg,upload/forum_avatarurl7.jpg','开放',0,'2026-01-05 10:46:19','upload/forum_cover5.jpg,upload/forum_cover6.jpg,upload/forum_cover7.jpg',5,0,5),(6,'2026-01-05 02:46:19','帖子标题6','帖子内容6',0,'用户名6','upload/forum_avatarurl6.jpg,upload/forum_avatarurl7.jpg,upload/forum_avatarurl8.jpg','开放',0,'2026-01-05 10:46:19','upload/forum_cover6.jpg,upload/forum_cover7.jpg,upload/forum_cover8.jpg',6,0,6),(7,'2026-01-05 02:46:19','帖子标题7','帖子内容7',0,'用户名7','upload/forum_avatarurl7.jpg,upload/forum_avatarurl8.jpg,upload/forum_avatarurl1.jpg','开放',0,'2026-01-05 10:46:19','upload/forum_cover7.jpg,upload/forum_cover8.jpg,upload/forum_cover1.jpg',7,0,7),(8,'2026-01-05 02:46:19','帖子标题8','帖子内容8',0,'用户名8','upload/forum_avatarurl8.jpg,upload/forum_avatarurl1.jpg,upload/forum_avatarurl2.jpg','开放',0,'2026-01-05 10:46:19','upload/forum_cover8.jpg,upload/forum_cover1.jpg,upload/forum_cover2.jpg',8,0,8),(9,'2026-01-05 03:08:44',NULL,'<p>在这可以交流评论</p>',1,'11','upload/1767581667146_792.jpg',NULL,0,NULL,NULL,0,0,1767581670729),(10,'2026-01-05 03:09:05','种植经验','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>',0,'11',NULL,'开放',1,'2026-01-05 11:21:37','upload/1767582543035_612.jpg',0,0,1767581670729);
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `fid` bigint(20) NOT NULL COMMENT '好友用户ID',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `picture` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `role` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色',
  `tablename` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表名',
  `alias` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '别名',
  `type` int(11) DEFAULT '0' COMMENT '类型(0:好友申请，1:好友，2:消息)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='好友表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
INSERT INTO `friend` VALUES (1,'2026-01-05 03:08:26',1767581670729,28,'3001','upload/jishurenyuan_touxiang8.jpg',NULL,'jishurenyuan',NULL,2),(2,'2026-01-05 03:08:26',28,1767581670729,'11','upload/1767581667146_792.jpg',NULL,'nonghu',NULL,2),(3,'2026-01-05 03:20:22',1767581670729,1767581811405,'22','upload/1767581771491_486.jpg',NULL,'jishurenyuan',NULL,2),(4,'2026-01-05 03:20:22',1767581811405,1767581670729,'11','upload/1767581667146_792.jpg',NULL,'nonghu',NULL,2);
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genghuanjilu`
--

DROP TABLE IF EXISTS `genghuanjilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genghuanjilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `genghuanshijian` date DEFAULT NULL COMMENT '更换时间',
  `genghuanbeizhu` longtext COLLATE utf8mb4_unicode_ci COMMENT '更换备注',
  `nonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  `jishuyuanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员账号',
  `jishuyuanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员姓名',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='更换记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genghuanjilu`
--

LOCK TABLES `genghuanjilu` WRITE;
/*!40000 ALTER TABLE `genghuanjilu` DISABLE KEYS */;
INSERT INTO `genghuanjilu` VALUES (1,'2026-01-05 02:46:19','春芽一号棚','苗床架','育苗设备','upload/genghuanjilu_苗床架1.jpg,upload/genghuanjilu_苗床架2.jpg,upload/genghuanjilu_苗床架3.jpg','2026-01-05','此处文本编辑框是内容详细的操作提示，您可以对现有文字进行修改，包括删除多余文字、替换不合适的表述等；插入图片时，既可以从本地选择图片上传，图片插入后会直接展示在编辑框中，完成操作后点击空白区域即可保存。','108','王静','3003','张鹏',1,1),(2,'2026-01-05 02:46:19','汇农八号棚','喷雾器','植保设备','upload/genghuanjilu_喷雾器1.jpg,upload/genghuanjilu_喷雾器2.jpg,upload/genghuanjilu_喷雾器3.jpg','2026-01-05','此编辑框内的默认内容为可编辑状态，您可对文字进行修改，比如调整语句顺序、更换文字内容等；插入图片时，支持上传图片，上传后图片会直接在编辑框中展示，也能一键删除不需要的图片。','106','李静','3005','谢伟',2,2),(3,'2026-01-05 02:46:19','冬韵四号棚','温控器','环境控制设备','upload/genghuanjilu_温控器1.jpg,upload/genghuanjilu_温控器2.jpg,upload/genghuanjilu_温控器3.jpg','2026-01-05','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','102','刘洋','3006','郑涛',3,3),(4,'2026-01-05 02:46:19','玉润十九号棚','臭氧发生器','消毒设备','upload/genghuanjilu_臭氧发生器1.jpg,upload/genghuanjilu_臭氧发生器2.jpg,upload/genghuanjilu_臭氧发生器3.jpg','2026-01-05','编辑框中展示的默认内容仅为示例，您可任意修改其中的文字表述，比如更换词语、调整语句顺序等；当需要插入图片时，点击编辑框上方的 “插入图片” 按钮，上传图片后即可直接在编辑框中展示。','103','李军','3007','梁杰',4,4),(5,'2026-01-05 02:46:19','碧影十五号棚','气象站','环境监测设备','upload/genghuanjilu_气象站1.jpg,upload/genghuanjilu_气象站2.jpg,upload/genghuanjilu_气象站3.jpg','2026-01-05','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','104','赵刚','3002','刘强',5,5),(6,'2026-01-05 02:46:19','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/genghuanjilu_二氧化碳发生器1.jpg,upload/genghuanjilu_二氧化碳发生器2.jpg,upload/genghuanjilu_二氧化碳发生器3.jpg','2026-01-05','您看到的编辑框内默认提示可作为创作起点，支持对现有内容进行全面修改，包括删除冗余文字、替换表述方式等；插入图片时，既可以从本地上传，也能粘贴网络图片地址，图片插入后会直接在文本中展示，完成后点击空白处即可保存设置。​','101','李娜','3008','胡伟',6,6),(7,'2026-01-05 02:46:19','翠玉十三号棚','除雾器','环境调节设备','upload/genghuanjilu_除雾器1.jpg,upload/genghuanjilu_除雾器2.jpg,upload/genghuanjilu_除雾器3.jpg','2026-01-05','此处文本编辑框是内容详细的操作提示，您能轻松对框内文字进行修改，像更正错误文字、调整文字内容等都能实现；插入图片的话，点击工具栏上的图片按钮，选择要插入的图片，图片就会在编辑框中展示，支持随时再次编辑。','105','赵伟','3004','吴敏',7,7),(8,'2026-01-05 02:46:19','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/genghuanjilu_水肥一体机1.jpg,upload/genghuanjilu_水肥一体机2.jpg,upload/genghuanjilu_水肥一体机3.jpg','2026-01-05','此编辑框内已详情的内容，您可以直接对现有文字进行修改，无论是调整文字内容、更正表述还是增减文字数量都能实现；若需插入图片，只需点击上方工具栏的图片图标，选择本地文件或输入图片链接即可插入展示，所有操作完成后提交后系统会保存您的修改。​','107','王明','3001','罗琳',8,8),(9,'2026-01-05 03:18:57','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','2026-01-05','<p>设备更换</p>','11','李思思','22','张毅',1767581811405,9);
/*!40000 ALTER TABLE `genghuanjilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guangaijilu`
--

DROP TABLE IF EXISTS `guangaijilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guangaijilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `zuowumingcheng` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作物名称',
  `zuowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作物类型',
  `zhouqi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '周期',
  `zuowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '作物图片',
  `zhongzhimianji` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '种植面积㎡',
  `guangaishuliang` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '灌溉数量',
  `guangaishijian` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '灌溉时间',
  `guangaizhouqi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '灌溉周期',
  `guangaifangan` longtext COLLATE utf8mb4_unicode_ci COMMENT '灌溉方案',
  `nonghuzhanghao` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='灌溉记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guangaijilu`
--

LOCK TABLES `guangaijilu` WRITE;
/*!40000 ALTER TABLE `guangaijilu` DISABLE KEYS */;
INSERT INTO `guangaijilu` VALUES (1,'2026-01-05 02:46:18','春芽一号棚','油菜','十字花科','35天','upload/guangaijilu_油菜1.jpg,upload/guangaijilu_油菜2.jpg,upload/guangaijilu_油菜3.jpg','2.0亩','180升','清晨7点','7天','喷灌保持土壤湿润','108','王静'),(2,'2026-01-05 02:46:18','汇农八号棚','番茄','茄果类','90天','upload/guangaijilu_番茄1.jpg,upload/guangaijilu_番茄2.jpg,upload/guangaijilu_番茄3.jpg','0.8亩','200升','清晨6点','7天','滴灌湿润土壤表层','106','李静'),(3,'2026-01-05 02:46:18','冬韵四号棚','豆角','豆类','85天','upload/guangaijilu_豆角1.jpg,upload/guangaijilu_豆角2.jpg,upload/guangaijilu_豆角3.jpg','1.1亩','220升','傍晚6点','7天','滴灌直达根部','102','刘洋'),(4,'2026-01-05 02:46:18','玉润十九号棚','大葱','百合科','120天','upload/guangaijilu_大葱1.jpg,upload/guangaijilu_大葱2.jpg,upload/guangaijilu_大葱3.jpg','1.5亩','200升','傍晚7点','10天','沟灌浸润根部土壤','103','李军'),(5,'2026-01-05 02:46:18','碧影十五号棚','白萝卜','根茎类','60天','upload/guangaijilu_白萝卜1.jpg,upload/guangaijilu_白萝卜2.jpg,upload/guangaijilu_白萝卜3.jpg','1.8亩','350升','傍晚6点','7天','沟灌浸润土壤','104','赵刚'),(6,'2026-01-05 02:46:18','晨光十七号棚','菠菜','叶菜类','30天','upload/guangaijilu_菠菜1.jpg,upload/guangaijilu_菠菜2.jpg,upload/guangaijilu_菠菜3.jpg','1.5亩','250升','清晨8点','10天','漫灌湿润土壤','101','李娜'),(7,'2026-01-05 02:46:18','翠玉十三号棚','苦瓜','瓜类','100天','upload/guangaijilu_苦瓜1.jpg,upload/guangaijilu_苦瓜2.jpg,upload/guangaijilu_苦瓜3.jpg','0.7亩','250升','傍晚5点','8天','沟灌浸润土壤','105','赵伟'),(8,'2026-01-05 02:46:18','晶彩七号棚','青椒','茄果类','100天','upload/guangaijilu_青椒1.jpg,upload/guangaijilu_青椒2.jpg,upload/guangaijilu_青椒3.jpg','0.6亩','150升','清晨7点','10天','滴灌直达根部','107','王明'),(9,'2026-01-05 03:16:09','夏荷二号棚','草莓','浆果类','120天','upload/1767582613705_30.jpg','0.5','100升','上午9点','5天','草莓浆果类，0.5㎡，每5天灌溉100升，全周期120天。','11','李思思');
/*!40000 ALTER TABLE `guangaijilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guoshudapeng`
--

DROP TABLE IF EXISTS `guoshudapeng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guoshudapeng` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengbianhao` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '大棚编号',
  `dapengmingcheng` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '大棚名称',
  `dapengtupian` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '大棚图片',
  `dapengleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚类型',
  `guige` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '规格',
  `tedian` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '特点',
  `mianji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '面积',
  `wendu` int(11) DEFAULT NULL COMMENT '温度',
  `shidu` int(11) DEFAULT NULL COMMENT '湿度',
  `guangzhao` int(11) DEFAULT NULL COMMENT '光照',
  `chuangjianshijian` date DEFAULT NULL COMMENT '创建时间',
  `shebeisheshi` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备设施',
  `xinyongdaima` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '信用代码',
  `hezuoshemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '合作社名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dapengbianhao` (`dapengbianhao`),
  UNIQUE KEY `dapengmingcheng` (`dapengmingcheng`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='果蔬大棚';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guoshudapeng`
--

LOCK TABLES `guoshudapeng` WRITE;
/*!40000 ALTER TABLE `guoshudapeng` DISABLE KEYS */;
INSERT INTO `guoshudapeng` VALUES (1,'2026-01-05 02:46:18','GS001','春芽一号棚','upload/guoshudapeng_春芽一号棚1.jpg,upload/guoshudapeng_春芽一号棚2.jpg,upload/guoshudapeng_春芽一号棚3.jpg','日光温室','长60m宽10m高35m','保温性好冬季无需额外供暖','600',18,65,18,'2023-07-11','卷帘机滴灌系统通风口','93500105MA2345T8U0','福临门果蔬专业合作社'),(2,'2026-01-05 02:46:18','GS008','汇农八号棚','upload/guoshudapeng_汇农八号棚1.jpg,upload/guoshudapeng_汇农八号棚2.jpg,upload/guoshudapeng_汇农八号棚3.jpg','连栋温室','长90m宽14m高42m','土地利用率高适合多品种种植','1260',21,66,28,'2025-08-20','水肥一体化系统遮阳网风机','93340104MA5678X0Y2','绿宝果蔬专业合作社'),(3,'2026-01-05 02:46:18','GS004','冬韵四号棚','upload/guoshudapeng_冬韵四号棚1.jpg,upload/guoshudapeng_冬韵四号棚2.jpg,upload/guoshudapeng_冬韵四号棚3.jpg','连栋温室','长100m宽15m高45m','空间大适合规模化种植','1500',20,68,11,'2023-04-27','自动放风机水肥一体机防虫网','93350203MA4321N5O7','绿洲果蔬专业合作社'),(4,'2026-01-05 02:46:18','GS019','玉润十九号棚','upload/guoshudapeng_玉润十九号棚1.jpg,upload/guoshudapeng_玉润十九号棚2.jpg,upload/guoshudapeng_玉润十九号棚3.jpg','玻璃温室','长50m宽8m高51m','透光均匀作物生长一致性好','400',22,58,16,'2025-08-03','智能灌溉系统温控仪光照传感器','93330109MA5432H1I4','绿禾果蔬专业合作社'),(5,'2026-01-05 02:46:18','GS015','碧影十五号棚','upload/guoshudapeng_碧影十五号棚1.jpg,upload/guoshudapeng_碧影十五号棚2.jpg,upload/guoshudapeng_碧影十五号棚3.jpg','玻璃温室','长48m宽7m高49m','抗风抗压使用寿命长','336',23,57,2,'2023-02-25','智能温控系统通风口加湿器','93380102MA1098H5I8','乐农果蔬专业合作社'),(6,'2026-01-05 02:46:18','GS017','晨光十七号棚','upload/guoshudapeng_晨光十七号棚1.jpg,upload/guoshudapeng_晨光十七号棚2.jpg,upload/guoshudapeng_晨光十七号棚3.jpg','日光温室','长62m宽10m高34m','清晨采光充足升温迅速','620',17,64,1,'2025-05-15','卷帘机滴灌带通风扇','93310115MA7654R7S9','绿满园果蔬专业合作社'),(7,'2026-01-05 02:46:18','GS013','翠玉十三号棚','upload/guoshudapeng_翠玉十三号棚1.jpg,upload/guoshudapeng_翠玉十三号棚2.jpg,upload/guoshudapeng_翠玉十三号棚3.jpg','日光温室','长58m宽9m高33m','保温层厚热量散失慢','522',18,63,7,'2023-04-10','电动卷帘机喷雾器','93410108MA44K1L9P2','惠民果蔬专业合作社'),(8,'2026-01-05 02:46:18','GS007','晶彩七号棚','upload/guoshudapeng_晶彩七号棚1.jpg,upload/guoshudapeng_晶彩七号棚2.jpg,upload/guoshudapeng_晶彩七号棚3.jpg','玻璃温室','长45m宽7m高48m','美观耐用透光性稳定','315',23,58,24,'2024-06-30','智能通风系统温控仪加湿器','93360102MA6789B2C5','祥和果蔬专业合作社'),(9,'2026-01-05 03:03:05','GS002','夏荷二号棚','upload/1767582133402_907.jpg','塑料大棚','长80m宽12m高40m','成本低搭建快透光性佳','960',25,70,8,'2026-01-05','<p>手动卷膜器喷雾器</p>','33','绿田野果蔬专业合作社');
/*!40000 ALTER TABLE `guoshudapeng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guoshushengzhang`
--

DROP TABLE IF EXISTS `guoshushengzhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guoshushengzhang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `zuowumingcheng` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作物名称',
  `zuowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作物类型',
  `zhouqi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '周期',
  `zuowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '作物图片',
  `zhongzhimianji` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '种植面积㎡',
  `jilushijian` date DEFAULT NULL COMMENT '记录时间',
  `shengzhangjieduan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生长阶段',
  `yepianshuliang` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '叶片数量',
  `zuowugaodu` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作物高度',
  `nonghuzhanghao` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='果蔬生长';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guoshushengzhang`
--

LOCK TABLES `guoshushengzhang` WRITE;
/*!40000 ALTER TABLE `guoshushengzhang` DISABLE KEYS */;
INSERT INTO `guoshushengzhang` VALUES (1,'2026-01-05 02:46:18','春芽一号棚','油菜','十字花科','35天','upload/guoshushengzhang_油菜1.jpg,upload/guoshushengzhang_油菜2.jpg,upload/guoshushengzhang_油菜3.jpg','2.0亩','2026-01-05','苗期','1015片','1015cm','108','王静'),(2,'2026-01-05 02:46:18','汇农八号棚','番茄','茄果类','90天','upload/guoshushengzhang_番茄1.jpg,upload/guoshushengzhang_番茄2.jpg,upload/guoshushengzhang_番茄3.jpg','0.8亩','2026-01-05','苗期','812片','3050cm','106','李静'),(3,'2026-01-05 02:46:18','冬韵四号棚','豆角','豆类','85天','upload/guoshushengzhang_豆角1.jpg,upload/guoshushengzhang_豆角2.jpg,upload/guoshushengzhang_豆角3.jpg','1.1亩','2026-01-05','苗期','58片','3050cm','102','刘洋'),(4,'2026-01-05 02:46:18','玉润十九号棚','大葱','百合科','120天','upload/guoshushengzhang_大葱1.jpg,upload/guoshushengzhang_大葱2.jpg,upload/guoshushengzhang_大葱3.jpg','1.5亩','2026-01-05','苗期','35片','3060cm','103','李军'),(5,'2026-01-05 02:46:18','碧影十五号棚','白萝卜','根茎类','60天','upload/guoshushengzhang_白萝卜1.jpg,upload/guoshushengzhang_白萝卜2.jpg,upload/guoshushengzhang_白萝卜3.jpg','1.8亩','2026-01-05','苗期','812片','2030cm','104','赵刚'),(6,'2026-01-05 02:46:18','晨光十七号棚','菠菜','叶菜类','30天','upload/guoshushengzhang_菠菜1.jpg,upload/guoshushengzhang_菠菜2.jpg,upload/guoshushengzhang_菠菜3.jpg','1.5亩','2026-01-05','苗期','1015片','1020cm','101','李娜'),(7,'2026-01-05 02:46:18','翠玉十三号棚','苦瓜','瓜类','100天','upload/guoshushengzhang_苦瓜1.jpg,upload/guoshushengzhang_苦瓜2.jpg,upload/guoshushengzhang_苦瓜3.jpg','0.7亩','2026-01-05','苗期','69片','4070cm','105','赵伟'),(8,'2026-01-05 02:46:18','晶彩七号棚','青椒','茄果类','100天','upload/guoshushengzhang_青椒1.jpg,upload/guoshushengzhang_青椒2.jpg,upload/guoshushengzhang_青椒3.jpg','0.6亩','2026-01-05','苗期','610片','2540cm','107','王明'),(9,'2026-01-05 03:17:17','夏荷二号棚','草莓','浆果类','120天','upload/1767582613705_30.jpg','0.5','2026-01-05','结果期','20','30cm','11','李思思');
/*!40000 ALTER TABLE `guoshushengzhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guoshuzhongzhi`
--

DROP TABLE IF EXISTS `guoshuzhongzhi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guoshuzhongzhi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `zuowumingcheng` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作物名称',
  `zuowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作物类型',
  `zhouqi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '周期',
  `zuowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '作物图片',
  `zhongzhimianji` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '种植面积㎡',
  `shiyiwendu` int(11) DEFAULT NULL COMMENT '适宜温度',
  `shiyishidu` int(11) DEFAULT NULL COMMENT '适宜湿度',
  `guangzhao` int(11) DEFAULT NULL COMMENT '光照',
  `zhongzhishijian` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '种植时间',
  `zhongzhixiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '种植详情',
  `nonghuzhanghao` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='果蔬种植';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guoshuzhongzhi`
--

LOCK TABLES `guoshuzhongzhi` WRITE;
/*!40000 ALTER TABLE `guoshuzhongzhi` DISABLE KEYS */;
INSERT INTO `guoshuzhongzhi` VALUES (1,'2026-01-05 02:46:18','春芽一号棚','油菜','十字花科','35天','upload/guoshuzhongzhi_油菜1.jpg,upload/guoshuzhongzhi_油菜2.jpg,upload/guoshuzhongzhi_油菜3.jpg','2.0亩',14,65,18,'冬季12月','撒播行距15cm株距5cm','108','王静'),(2,'2026-01-05 02:46:18','汇农八号棚','番茄','茄果类','90天','upload/guoshuzhongzhi_番茄1.jpg,upload/guoshuzhongzhi_番茄2.jpg,upload/guoshuzhongzhi_番茄3.jpg','0.8亩',24,65,28,'春季3月','育苗移栽行距50cm株距30cm','106','李静'),(3,'2026-01-05 02:46:18','冬韵四号棚','豆角','豆类','85天','upload/guoshuzhongzhi_豆角1.jpg,upload/guoshuzhongzhi_豆角2.jpg,upload/guoshuzhongzhi_豆角3.jpg','1.1亩',24,65,11,'春季4月','直播行距50cm株距20cm','102','刘洋'),(4,'2026-01-05 02:46:18','玉润十九号棚','大葱','百合科','120天','upload/guoshuzhongzhi_大葱1.jpg,upload/guoshuzhongzhi_大葱2.jpg,upload/guoshuzhongzhi_大葱3.jpg','1.5亩',20,65,16,'秋季9月','条播行距20cm株距5cm','103','李军'),(5,'2026-01-05 02:46:18','碧影十五号棚','白萝卜','根茎类','60天','upload/guoshuzhongzhi_白萝卜1.jpg,upload/guoshuzhongzhi_白萝卜2.jpg,upload/guoshuzhongzhi_白萝卜3.jpg','1.8亩',14,70,2,'秋季9月','条播行距25cm株距8cm','104','赵刚'),(6,'2026-01-05 02:46:18','晨光十七号棚','菠菜','叶菜类','30天','upload/guoshuzhongzhi_菠菜1.jpg,upload/guoshuzhongzhi_菠菜2.jpg,upload/guoshuzhongzhi_菠菜3.jpg','1.5亩',12,65,1,'冬季11月','撒播覆土1cm行距20cm','101','李娜'),(7,'2026-01-05 02:46:18','翠玉十三号棚','苦瓜','瓜类','100天','upload/guoshuzhongzhi_苦瓜1.jpg,upload/guoshuzhongzhi_苦瓜2.jpg,upload/guoshuzhongzhi_苦瓜3.jpg','0.7亩',27,70,7,'夏季5月','直播行距80cm株距40cm','105','赵伟'),(8,'2026-01-05 02:46:18','晶彩七号棚','青椒','茄果类','100天','upload/guoshuzhongzhi_青椒1.jpg,upload/guoshuzhongzhi_青椒2.jpg,upload/guoshuzhongzhi_青椒3.jpg','0.6亩',21,70,24,'秋季8月','育苗移栽行距40cm株距25cm','107','王明'),(9,'2026-01-05 03:10:44','夏荷二号棚','草莓','浆果类','120天','upload/1767582613705_30.jpg','0.5',17,75,8,'秋季10月','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>','11','李思思');
/*!40000 ALTER TABLE `guoshuzhongzhi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guzhangbaoxiu`
--

DROP TABLE IF EXISTS `guzhangbaoxiu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guzhangbaoxiu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `shebeixinghao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备型号',
  `baoxiushijian` date DEFAULT NULL COMMENT '报修时间',
  `weixiujindu` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '维修进度',
  `baoxiuxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '报修详情',
  `jishuyuanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员账号',
  `jishuyuanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员姓名',
  `nonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='故障报修';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guzhangbaoxiu`
--

LOCK TABLES `guzhangbaoxiu` WRITE;
/*!40000 ALTER TABLE `guzhangbaoxiu` DISABLE KEYS */;
INSERT INTO `guzhangbaoxiu` VALUES (1,'2026-01-05 02:46:19','春芽一号棚','苗床架','育苗设备','upload/guzhangbaoxiu_苗床架1.jpg,upload/guzhangbaoxiu_苗床架2.jpg,upload/guzhangbaoxiu_苗床架3.jpg','MC200','2026-01-05','已维修','此处文本编辑框是内容详细的操作提示，您可以对现有文字进行修改，包括删除多余文字、替换不合适的表述等；插入图片时，既可以从本地选择图片上传，图片插入后会直接展示在编辑框中，完成操作后点击空白区域即可保存。','3003','张鹏','108','王静',1,1),(2,'2026-01-05 02:46:19','汇农八号棚','喷雾器','植保设备','upload/guzhangbaoxiu_喷雾器1.jpg,upload/guzhangbaoxiu_喷雾器2.jpg,upload/guzhangbaoxiu_喷雾器3.jpg','PW100','2026-01-05','已维修','此编辑框内的默认内容为可编辑状态，您可对文字进行修改，比如调整语句顺序、更换文字内容等；插入图片时，支持上传图片，上传后图片会直接在编辑框中展示，也能一键删除不需要的图片。','3005','谢伟','106','李静',2,2),(3,'2026-01-05 02:46:19','冬韵四号棚','温控器','环境控制设备','upload/guzhangbaoxiu_温控器1.jpg,upload/guzhangbaoxiu_温控器2.jpg,upload/guzhangbaoxiu_温控器3.jpg','WK300','2026-01-05','已维修','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','3006','郑涛','102','刘洋',3,3),(4,'2026-01-05 02:46:19','玉润十九号棚','臭氧发生器','消毒设备','upload/guzhangbaoxiu_臭氧发生器1.jpg,upload/guzhangbaoxiu_臭氧发生器2.jpg,upload/guzhangbaoxiu_臭氧发生器3.jpg','CY200','2026-01-05','已维修','编辑框中展示的默认内容仅为示例，您可任意修改其中的文字表述，比如更换词语、调整语句顺序等；当需要插入图片时，点击编辑框上方的 “插入图片” 按钮，上传图片后即可直接在编辑框中展示。','3007','梁杰','103','李军',4,4),(5,'2026-01-05 02:46:19','碧影十五号棚','气象站','环境监测设备','upload/guzhangbaoxiu_气象站1.jpg,upload/guzhangbaoxiu_气象站2.jpg,upload/guzhangbaoxiu_气象站3.jpg','QX500','2026-01-05','已维修','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','3002','刘强','104','赵刚',5,5),(6,'2026-01-05 02:46:19','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/guzhangbaoxiu_二氧化碳发生器1.jpg,upload/guzhangbaoxiu_二氧化碳发生器2.jpg,upload/guzhangbaoxiu_二氧化碳发生器3.jpg','CR300','2026-01-05','已维修','您看到的编辑框内默认提示可作为创作起点，支持对现有内容进行全面修改，包括删除冗余文字、替换表述方式等；插入图片时，既可以从本地上传，也能粘贴网络图片地址，图片插入后会直接在文本中展示，完成后点击空白处即可保存设置。​','3008','胡伟','101','李娜',6,6),(7,'2026-01-05 02:46:19','翠玉十三号棚','除雾器','环境调节设备','upload/guzhangbaoxiu_除雾器1.jpg,upload/guzhangbaoxiu_除雾器2.jpg,upload/guzhangbaoxiu_除雾器3.jpg','CW200','2026-01-05','已维修','此处文本编辑框是内容详细的操作提示，您能轻松对框内文字进行修改，像更正错误文字、调整文字内容等都能实现；插入图片的话，点击工具栏上的图片按钮，选择要插入的图片，图片就会在编辑框中展示，支持随时再次编辑。','3004','吴敏','105','赵伟',7,7),(8,'2026-01-05 02:46:19','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/guzhangbaoxiu_水肥一体机1.jpg,upload/guzhangbaoxiu_水肥一体机2.jpg,upload/guzhangbaoxiu_水肥一体机3.jpg','SF600','2026-01-05','已维修','此编辑框内已详情的内容，您可以直接对现有文字进行修改，无论是调整文字内容、更正表述还是增减文字数量都能实现；若需插入图片，只需点击上方工具栏的图片图标，选择本地文件或输入图片链接即可插入展示，所有操作完成后提交后系统会保存您的修改。​','3001','罗琳','107','王明',8,8),(9,'2026-01-05 03:18:21','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','CO2500','2026-01-05','已维修','<p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p>','22','张毅','11','李思思',1767581670729,9);
/*!40000 ALTER TABLE `guzhangbaoxiu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hezuoshe`
--

DROP TABLE IF EXISTS `hezuoshe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hezuoshe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xinyongdaima` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '信用代码',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `hezuoshemingcheng` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '合作社名称',
  `fengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT '封面',
  `chengliriqi` date NOT NULL COMMENT '成立日期',
  `lianxiren` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系人',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `zhuyingxiangmu` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主营项目',
  `suozaidi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所在地',
  `hezuoshexiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '合作社详情',
  `pquestion` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保问题',
  `panswer` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保答案',
  `status` int(11) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `xinyongdaima` (`xinyongdaima`)
) ENGINE=InnoDB AUTO_INCREMENT=1767581902820 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='合作社';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hezuoshe`
--

LOCK TABLES `hezuoshe` WRITE;
/*!40000 ALTER TABLE `hezuoshe` DISABLE KEYS */;
INSERT INTO `hezuoshe` VALUES (31,'2026-01-05 02:46:18','93500105MA2345T8U0','e10adc3949ba59abbe56e057f20f883e','福临门果蔬专业合作社','upload/hezuoshe_福临门果蔬专业合作社1.jpg,upload/hezuoshe_福临门果蔬专业合作社2.jpg,upload/hezuoshe_福临门果蔬专业合作社3.jpg','2021-01-15','朱建军','朱建军','甜椒彩椒尖椒种植','重庆市江北区','彩色辣椒大棚种植颜值高营养丰富','密保问题1','密保答案1',0),(32,'2026-01-05 02:46:18','93340104MA5678X0Y2','e10adc3949ba59abbe56e057f20f883e','绿宝果蔬专业合作社','upload/hezuoshe_绿宝果蔬专业合作社1.jpg,upload/hezuoshe_绿宝果蔬专业合作社2.jpg,upload/hezuoshe_绿宝果蔬专业合作社3.jpg','2020-07-25','黄志强','黄志强','生菜娃娃菜茼蒿种植','安徽省合肥市蜀山区','速生叶菜大棚种植周期短收益快','密保问题2','密保答案2',0),(33,'2026-01-05 02:46:18','93350203MA4321N5O7','e10adc3949ba59abbe56e057f20f883e','绿洲果蔬专业合作社','upload/hezuoshe_绿洲果蔬专业合作社1.jpg,upload/hezuoshe_绿洲果蔬专业合作社2.jpg,upload/hezuoshe_绿洲果蔬专业合作社3.jpg','2020-05-18','吴春燕','吴春燕','韭菜香菜香葱种植','福建省厦门市湖里区','小香葱大棚密植产量高品质优常年供应','密保问题3','密保答案3',0),(34,'2026-01-05 02:46:18','93330109MA5432H1I4','e10adc3949ba59abbe56e057f20f883e','绿禾果蔬专业合作社','upload/hezuoshe_绿禾果蔬专业合作社1.jpg,upload/hezuoshe_绿禾果蔬专业合作社2.jpg,upload/hezuoshe_绿禾果蔬专业合作社3.jpg','2019-12-25','赵天明','赵天明','芹菜生菜油麦菜种植','浙江省杭州市萧山区','现代化智能大棚温控精准蔬菜长势均匀','密保问题4','密保答案4',0),(35,'2026-01-05 02:46:18','93380102MA1098H5I8','e10adc3949ba59abbe56e057f20f883e','乐农果蔬专业合作社','upload/hezuoshe_乐农果蔬专业合作社1.jpg,upload/hezuoshe_乐农果蔬专业合作社2.jpg,upload/hezuoshe_乐农果蔬专业合作社3.jpg','2019-11-10','崔桂花','崔桂花','圣女果小黄瓜彩椒种植','山东省潍坊市奎文区','精品果蔬大棚种植专供高端商超和餐厅','密保问题5','密保答案5',0),(36,'2026-01-05 02:46:18','93310115MA7654R7S9','e10adc3949ba59abbe56e057f20f883e','绿满园果蔬专业合作社','upload/hezuoshe_绿满园果蔬专业合作社1.jpg,upload/hezuoshe_绿满园果蔬专业合作社2.jpg,upload/hezuoshe_绿满园果蔬专业合作社3.jpg','2019-08-20','马晓华','马晓华','草莓蓝莓樱桃种植','上海市浦东新区','采摘加销售一体化大棚果蔬园游客众多','密保问题6','密保答案6',0),(37,'2026-01-05 02:46:18','93410108MA44K1L9P2','e10adc3949ba59abbe56e057f20f883e','惠民果蔬专业合作社','upload/hezuoshe_惠民果蔬专业合作社1.jpg,upload/hezuoshe_惠民果蔬专业合作社2.jpg,upload/hezuoshe_惠民果蔬专业合作社3.jpg','2019-05-22','李红梅','李红梅','茄子辣椒西葫芦种植','河南省郑州市金水区','采用无公害种植技术产品供应本地商超','密保问题7','密保答案7',0),(38,'2026-01-05 02:46:18','93360102MA6789B2C5','e10adc3949ba59abbe56e057f20f883e','祥和果蔬专业合作社','upload/hezuoshe_祥和果蔬专业合作社1.jpg,upload/hezuoshe_祥和果蔬专业合作社2.jpg,upload/hezuoshe_祥和果蔬专业合作社3.jpg','2017-06-18','罗建国','罗建国','土豆红薯山药种植','江西省南昌市东湖区','地下根茎类蔬菜大棚种植土壤肥沃产量高','密保问题8','密保答案8',0),(1767581902819,'2026-01-05 02:58:22','33','182be0c5cdcd5072bb1864cdee4d3d6e','绿田野果蔬专业合作社','upload/1767581863522_796.jpg','2026-01-05','钱穆','13813520120','西兰花菜花甘蓝种植','云南','<p>十字花科蔬菜大棚种植病虫害少品质佳</p>','333','333',0);
/*!40000 ALTER TABLE `hezuoshe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jishurenyuan`
--

DROP TABLE IF EXISTS `jishurenyuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jishurenyuan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jishuyuanzhanghao` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '技术员账号',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `jishuyuanxingming` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '技术员姓名',
  `xingbie` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `lianxidianhua` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `zizhizhengshu` longtext COLLATE utf8mb4_unicode_ci COMMENT '资质证书',
  `shanzhanglingyu` longtext COLLATE utf8mb4_unicode_ci COMMENT '擅长领域',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  `pquestion` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保问题',
  `panswer` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保答案',
  `status` int(11) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `jishuyuanzhanghao` (`jishuyuanzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1767581811406 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='技术人员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jishurenyuan`
--

LOCK TABLES `jishurenyuan` WRITE;
/*!40000 ALTER TABLE `jishurenyuan` DISABLE KEYS */;
INSERT INTO `jishurenyuan` VALUES (21,'2026-01-05 02:46:18','3003','e10adc3949ba59abbe56e057f20f883e','张鹏','女','upload/jishurenyuan_touxiang1.jpg','13456789012','','大棚温控调控|热泵供暖|通风降温|智能温控算法','是','','密保问题1','密保答案1',0),(22,'2026-01-05 02:46:18','3005','e10adc3949ba59abbe56e057f20f883e','谢伟','男','upload/jishurenyuan_touxiang2.jpg','13534567890','','智能大棚运维|物联网平台搭建|远程控制|设备故障诊断','是','','密保问题2','密保答案2',0),(23,'2026-01-05 02:46:18','3006','e10adc3949ba59abbe56e057f20f883e','郑涛','女','upload/jishurenyuan_touxiang3.jpg','13578901234','','果蔬种植标准化|种植规程制定|标准化管理|产量品质提升','是','','密保问题3','密保答案3',0),(24,'2026-01-05 02:46:18','3007','e10adc3949ba59abbe56e057f20f883e','梁杰','女','upload/jishurenyuan_touxiang4.jpg','13423456789','','果蔬产后处理|清洗分级|包装设计|品牌打造','是','','密保问题4','密保答案4',0),(25,'2026-01-05 02:46:18','3002','e10adc3949ba59abbe56e057f20f883e','刘强','男','upload/jishurenyuan_touxiang5.jpg','13401234567','','大棚病虫害预警|AI图像识别|病虫害模型|预警系统开发','是','','密保问题5','密保答案5',0),(26,'2026-01-05 02:46:18','3008','e10adc3949ba59abbe56e057f20f883e','胡伟','女','upload/jishurenyuan_touxiang6.jpg','13490123456','','果蔬品种选育|耐低温品种|高产品种|抗病性筛选','是','','密保问题6','密保答案6',0),(27,'2026-01-05 02:46:18','3004','e10adc3949ba59abbe56e057f20f883e','吴敏','男','upload/jishurenyuan_touxiang7.jpg','13523456789','','大棚环境监测|温湿度传感器|CO₂监测|数据采集分析','是','','密保问题7','密保答案7',0),(28,'2026-01-05 02:46:18','3001','e10adc3949ba59abbe56e057f20f883e','罗琳','男','upload/jishurenyuan_touxiang8.jpg','13501234567','','果蔬水肥管理|营养需求分析|精准施肥|肥料利用率提升','是','','密保问题8','密保答案8',0),(1767581811405,'2026-01-05 02:56:51','22','b6d767d2f8ed5d21a44b0e5886680cb9','张毅','男','upload/1767581771491_486.jpg','13813985485','upload/1767581777761_199.docx','<p><span style=\"background-color: rgb(245, 247, 250); color: rgb(96, 98, 102);\">大棚环境监测|温湿度传感器|CO₂监测|数据采集分析</span></p>','是','好','222','222',0);
/*!40000 ALTER TABLE `jishurenyuan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `introduction` longtext COLLATE utf8mb4_unicode_ci COMMENT '简介',
  `picture` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布人',
  `headportrait` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `typename` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`),
  KEY `typename` (`typename`),
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`typename`) REFERENCES `newstype` (`typename`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='公告信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'2026-01-05 02:46:19','趁着年轻，输得起，看得开，去经历','我在大学一年级那一年，毫无悬念地把自己吃成了一个胖子。不是那种巨大的胖子，而是介于正规的肥胖和臃肿之间的尴尬体型，比标准体型重了15斤。于是，我的整个大学生活变成了电影《蝴蝶效应》系列，那只蝴蝶重达15斤','upload/news_picture1.jpg','<p>我在大学一年级那一年，毫无悬念地把自己吃成了一个胖子。不是那种巨大的胖子，而是介于正规的肥胖和臃肿之间的尴尬体型，比标准体型重了15斤。于是，我的整个大学生活变成了电影《蝴蝶效应》系列，那只蝴蝶重达15斤。</p><p>  首先，我皈依了减肥。我可以整整一天滴水不进，然后第二天中午，一个小时之内连续去三个食堂吃午饭，每次都是两荤一素、一两米饭加一瓶大可乐，像是一个人孢子分裂出了三个暴食症患者。其次，因为要么饿得百爪挠心，要么撑得寝食难安，我变成了一个昼夜颠倒的人，再加上觉得自己邋遢难看，不愿见人，便逃掉了很多课。其三，逃课的空虚让我花了大量时间网购，击败了全国90%以上的电商消费者，和快递员结下了深厚的友谊。我买的大多数是衣服，衣服又穿不进，羞愤难当，继续皈依减肥。总之，那是我非常不快乐的几年。因为难以接受自己，所以蜷缩着，拒绝他人。</p><p>    我很久之后才知道，人用来自憎的大脑边缘系统，在童年时就已经形成。可是，用来开导自己、原谅自己、使自己变得强大的智慧，却往往在我们本该成熟的年纪依然不具备。每一世代的年轻人都是脆弱的、敏感的、容易受他人影响的。而对于正年轻的一代来说，这个挑战异乎寻常的艰难。</p><p> 电影《楚门的世界》中提出了一个假设以及相应的解答:当一个人活在所有人的窥探之下，他应该怎么办?答案是:他逃走，获得自由。然而，如果所有人活在所有人的窥探之下，那又该如何逃避?这不是假设，而是正在悄然发生的现实。我们无时无刻不在朋友圈、微博、贴吧、个人主页上展现自己的生活，同时，也在同样的平台上窥探他人的生活。我们无时无刻不在评估他人，同时，也在接受他人的评估。“个性张扬”只是狐假虎威的外衣，为的是掩饰自卑与自恋此起彼伏、相爱相杀的脆弱。我们羡慕嫉妒他人，也努力把自己的生活修饰得让他人羡慕嫉妒。我们对他人的意见过于敏感，无法忍受不被“点赞”的人生。</p><p>  社交网络的核心在于“社交”，社交的动力，是出于人们无法忍受孤独;人们之所以无法忍受孤独，是因为人们无法拷问自己。可是，总有一天，我们要站在镜子前，发现我们并不是自己创造出来的那个有趣、可爱、有吸引力、有能力的人。那么，你还喜欢镜子里的自己吗?或者，镜子里的你还喜欢自己吗?这个世界是否称赞你、羡慕你、爱你，在某种程度上是个不断膨胀的谎言。关键的问题在于，你是否对自己足够诚实，并且接受诚实之后的不完美。</p><p>   失去的痛苦、被拒绝的痛苦、被伤害的痛苦、分别的痛苦，它们如此显眼地横在前行的路上，让人想逃遁到那个充满着“赞”的虚幻世界里。然而，我们是人，走在一条从摇篮到坟墓的路上，年轻在途中，衰老在途中。必须和真实的世界发生联系，而不是兀自为尚未发生的事情恐惧;必须和真实的人发生各种关系，而不是如一座座只能遥远眺望的孤岛。</p><p>那些杀不死我们的，它们有时并不会让我们更加强大，而只是成为一段诗意或自嘲的记忆。趁着年轻，输得起，看得开，去经历。那些杀不死我们的，它们在混沌而无序的未来里，并不能成为我们手中的武器，却为我们的存活，增加了反抗脆弱与敏感的韧性。</p>','发布人1','upload/news_headportrait1.jpg','分类名称1'),(2,'2026-01-05 02:46:19','大学就该抓住青春，用汗水实现梦想','大学之青春，人生之春，人生之王，人生之华也，宝贵的时光我们理当去珍惜。然而，当我们在青春布满藤墓的围墙上缓慢的攀行时;依旧游离在青春摇摆不定的尾巴上时;奋力想抓却抓不住，用力一扯，却又是散落一地的音符时;我们是否该回头思考了。零零碎碎的记忆，偶尔会闪过寂寞的长空，飘然在无际的苍穹，仅仅留下几颗闪烁的残星让我们自己深思，青春易逝，好比东逝的水—去不复还','upload/news_picture2.jpg','<p>  大学之青春，人生之春，人生之王，人生之华也，宝贵的时光我们理当去珍惜。然而，当我们在青春布满藤墓的围墙上缓慢的攀行时;依旧游离在青春摇摆不定的尾巴上时;奋力想抓却抓不住，用力一扯，却又是散落一地的音符时;我们是否该回头思考了。零零碎碎的记忆，偶尔会闪过寂寞的长空，飘然在无际的苍穹，仅仅留下几颗闪烁的残星让我们自己深思，青春易逝，好比东逝的水—去不复还。</p><p>  青春是属于我们的，是人生最最美好的时光。我们应该好好把握住现在象牙塔的点点滴滴。大学对于我们来说很重要，这里充满了好奇、机遇和挑战。当我懵懵懂懂的走过了两年才突然发现原来大学是这样的，每个人有不同的选择，有不同的理想，也有不同的人生。但是无论怎样都是一个博学的过程，学做人，学知识，学生活..…...春是疯狂的，是充满激情的，是奋斗的，最重要的是我们要坚定我们的梦想，为了梦想付出一切，为了梦想坚持到底，这才是真正的青春。青春的梦想就是黑夜里的灯塔在我们迷茫时给予我们方向，就是力量的源泉在我们身陷逆境时给予我们最大的动力，就是爱的港湾在我们屡次失败时给予我们受伤的心灵以安慰。因此无论何时何地，都不能忘却心里坚守的那份沉甸甸的梦想。</p><p>   青春的梦想很简单，可能是梦想成为学习的佼佼者让GPA无限趋于4.0，可能是梦想成为学生工作的杰出者当上主席为自己的从政事业奠定基础，也可能是梦想成为运动场上的超级明星拥有大量的球迷粉丝，也可能是梦想成为职场达人，面试无压力，就业有保障...….或许你觉得这些都算不上梦想，其实梦想并不分大小和轻重，不能说只有中国梦才算是梦想，梦想就是这样每个人有不同的定位，但都是值得去追逐的，去为之奋斗的。()拥有了梦想，就有了坚定的信念，海风再大海浪再大，也无法扼杀我们追逐胜利的信念。信念给我们坚持的勇气，勇气赐我们昂扬的斗志，斗志带我们摆脱厄运;拥有了梦想，就能化压力为动力，梦想会时刻在鞭策我们，鼓励我们，让我们审视自己，发现不足，奋力补救，让自己保持不懈的前进动力;拥有了梦想，我们就不会在迷茫的路上更加迷茫，我们就能在青春之歌复杂的五线谱中听到动人的旋律。</p><p>   我们是大学生，是祖国的未来，是民族复兴的脊梁，面对如此重任，怎么能不胸怀大志，坚定梦想，在青春的道路上奋斗。“恰同学少年，风华正茂，书生意气，挥斥方道。”青春是黄金时段，我们要以梦想为方向，扬帆起航，努力拼搏，给我们即将失去的青春以最好的结局。人因梦想而伟大，让我们一起奏响青春的梦想之歌，为各自的梦想努力进发吧!</p>','发布人2','upload/news_headportrait2.jpg','分类名称2'),(3,'2026-01-05 02:46:19','留退路就没有出路','公元前一世纪，凯撒大帝率领他的军队抵达了英格兰，他决心要赢得这场战争，不管遇到什么情况都不会退却。为了让士兵们明白自己必胜的决心和信心，也为了断绝士兵们逃跑退缩的念头，凯撒命令士兵将运载他们的所有船只都烧毁。这使得军队的士气受到了莫大的鼓舞。后来他们获胜了','upload/news_picture3.jpg','<p>  公元前一世纪，凯撒大帝率领他的军队抵达了英格兰，他决心要赢得这场战争，不管遇到什么情况都不会退却。为了让士兵们明白自己必胜的决心和信心，也为了断绝士兵们逃跑退缩的念头，凯撒命令士兵将运载他们的所有船只都烧毁。这使得军队的士气受到了莫大的鼓舞。后来他们获胜了。</p><p>  很多人在处理重要问题的时候，总是喜欢把这些问题暂且搁置在一边，等以后再做。他们没有决定的勇气和魄力，总是在着手做事的时候想给自己留一条后路，以免没有出路。对于他们来说，退路就是出路。但是，事实证明，这样是不会有任何成就的。</p><p>背水一战、破釜沉舟的军队往往能获得胜利。同样，一个做事不留退路、一心向前的人，不管遇到什么困难和障碍，他都不会后退，因为他没有路可以退。而那些人在为自己准备退路的同时就是在后退，他们立志不坚，把精力和时间投入到退缩的准备上，这种人绝不会获得成功。</p><p>  一个人能否成功，关键在于他意志力的强弱。意志坚强的人不管遇到什么困难和障碍，都会百折不挠，想方设法地克服;意志薄弱的人一遇到麻烦，甚至在挫折还没有到来之前，他们就开始庸人自扰，彷徨失措，把精力都放在如何规避问题上，放在为自己铺设后路上。当困难一个接一个来时，他们就一步接一步后退，最后他们终将无路可退。</p><p>现实生活中，到处都充斥着这样的青年，他们富有上进心，希望有一番成就和作为，但是他们意志薄弱，没有必胜的决心，不敢破釜沉舟;他们始终左摇右摆，没有坚定的信念，一遇到挫折和困难，马上就缩回了进取的手和脚。这样的人，这样的心态，最后遭受失败也不足为奇。</p><p>   不给自己留后路，让自己没有回旋的余地，方能竭尽全力，锐意进取，就算遇到千万困难，也不会退缩，因为回头也没有路了，不如不顾一切地前进，还能找到一线希望。有了这样一种“拼命”和“豁出去”了的信念，才能彻彻底底地消除心中的恐惧、犹豫、胆怯。当一个人不给自己任何退路的时候，他就什么都不怕了，勇气、信心、热忱等从心底油然而生，到最后自然能“置之死地而后生”。</p><p>    面对严峻的问题和重要环节，周全而细致地考虑问题的各个方面也是应该的，但是过多地权衡，前怕狼后怕虎，一会儿这样一会儿那样，最终却还是原样，可以肯定地说，你不会有任何进展，甚至还会变得—塌糊涂。</p><p>出路和退路不是同义词，而是反义词，留退路就没有出路，因此，你应该只找出路，不留退路。大学生励志青春文章:培养积极的思维模式。</p>','发布人3','upload/news_headportrait3.jpg','分类名称3'),(4,'2026-01-05 02:46:19','在大学给自己定个目标','最近和几名大一的学生聊天，几名同学认为身边的人普遍都很迷茫，不知道该干什么，业余时间要么是对着电脑、要么是抱着手机刷微博。我问道:“为什么不找点事情做做，制定一个计划，哪怕是锻炼身体也好?4年也可以把身体锻炼得结实些。”当然，我也清楚，我的这些建议对他们来说，未必能有多大用。许多学生因为意志不坚定，没有老师的监督、逼迫，根本就无法做到','upload/news_picture4.jpg','<p>  最近和几名大一的学生聊天，几名同学认为身边的人普遍都很迷茫，不知道该干什么，业余时间要么是对着电脑、要么是抱着手机刷微博。我问道:“为什么不找点事情做做，制定一个计划，哪怕是锻炼身体也好?4年也可以把身体锻炼得结实些。”当然，我也清楚，我的这些建议对他们来说，未必能有多大用。许多学生因为意志不坚定，没有老师的监督、逼迫，根本就无法做到。</p><p>   这让我想到前段时间蹿红网络的“悔过励志帖”——《同学，我大四了》，作者回首自己的大学4年，他感叹投入精力“充其量不过40%”︰每天上网时间少则4个小时，多则10个小时;考试永远是画画重点，在高呼“60分万岁”中与奖学金无缘。作者借自己求职受挫，写帖子以警醒后来人，不要等毕业时再后悔，就业难不仅仅是大学、社会的问题，也是自身的问题。</p><p>  也许，这样的大学生不是一个两个，而是一个群体。然而，我总是怀疑这样的励志帖，甚至教师在课堂上苦口婆心地劝说，能对现实中的大学和大学生起到多大的影响和作用，很多时候恐怕只有“三分钟热度”的效应。毕竟，现实的窘境不是一天积累起来的，从小学到高中，学生们的学习都是被动地接受应试，隐藏着功利性的目的，也许从没有为主动学习感到过快乐，而在高中时代，有的教师甚至打出这样的励志宣言:等你考上大学，你就可以想干什么干什么了..…..乎，高中时代的目标是很清晰的，就是为了考上大学，而在一些高中生的眼里，大学甚至就好比是天堂，进了大学的门就可以放轻松了。</p><p> 此前，有很多声音都认为大学越来越像培训机构，功利性学习正在整个大学蔓延，考证热、过早地职业化都是大学功利性学习最好的表现形式。在这种批判的声音中，“培训机构”总有被贬低的意味，难与大学之学术思想殿堂的高雅相媲美。但是，在这种批判的背后，还有一个现实问题被遮蔽，那就是很多大学生对自己的学习、对大学生活没有任何目标。</p><p>暨南大学舆情研究中心曾就“当代广州大学生生活与思想现状”作过详细的问卷调查，其中，接受调查的广州高校在读本科生共有191份有效样本，就“读大学的原因”、“大学第一印象”、“专业选择首要因素”等问题制作问卷调查并进行分析。结果显示，在未来规划方面，73.3%的同学表示只有粗略的想法，并无非常明确的目标。</p><p>  如果说功利化的学习毕竟还有一个前进的目标，至少能体现出一种为了目标而奋斗的精神和奔头，而没有任何目标，漫无目的地混日子则更可怕，它体现的是一种虚无、意义的缺失。说实话，没有引导学生树立明确的奋斗目标、进而指引学生为之努力的大学，学生很难找到努力的方向，也找不到努力的意义，这还不如“培训机构”来得实在、来得有效用，至少，培训机构的目标很清晰，它能够给学生们一个实实在在看得见的效果，而没有任何目标、浑浑噩噩的大学生活，也许只会给很多学生带来悔过。</p><p>无论如何，混日子的大学生活是不可取的。一方面，高校应该在新生入学的时候，作好目标和方向的引导，甚至贯穿大学4年的学习过程;另一方面，还在迷途的大学生，应尽早为自己找个前进的方向，作好自我规划，对自己的未来和前途负责。</p>','发布人4','upload/news_headportrait4.jpg','分类名称4'),(5,'2026-01-05 02:46:19','做个真正的学生','最坚强的人，是以宽容的态度面对自己缺点的人，而懦弱的人，则不敢面对自己的缺点，最终自暴自弃，葬送自己。只要有进取心，我们都能从失败的领域中，发现到达成功的途径;只要有自信心，我们身上的每一个缺陷，也都可以成为与众不同的优点','upload/news_picture5.jpg','<p>  最坚强的人，是以宽容的态度面对自己缺点的人，而懦弱的人，则不敢面对自己的缺点，最终自暴自弃，葬送自己。只要有进取心，我们都能从失败的领域中，发现到达成功的途径;只要有自信心，我们身上的每一个缺陷，也都可以成为与众不同的优点。</p><p>曾经有人特地赶赴日本，向三宅一生服装设计大师请教如何设计出独具一格的服装款式。三宅一生大师提出两个很有意思的观点:一是，设计的衣服，其实都是没有全部完成的，其余的创作空间，则是留给穿衣服的人去完成的;二是，选择布料时，会请厂商提供纺织、印染失败的布料，从这些“残次”的作品中寻找泉涌般的创作灵感，设计出最具独创性的作品。</p><p>这样一来，顾客才能穿出自己的风格，并使得同一件衣服，在不同的人身上，能有不同的效果。而且，以这样的概念设计出来的衣服，也不容易失败。正是因为这两个观点，三宅一生所设计的服装总是独一无二地能够引领世界潮流。</p><p>  在艺术家的眼中，任何事物都是创作的最好材料，不管是枯木还是残破的布料，对他们而言，都是最具生命力的事物，在他们手中都能画腐朽为神奇。</p><p>朽木也能精雕，更何况我们自己。那些看起来弯曲、盘旋、似乎毫无用处的木料，往往最终能成为艺术品的原材料，因为这种不同，才特别珍贵。花点心思，身上的缺点也能变成独特的优点，就像艺术家们一般，顺着曲折的木头，创造出与众不同、完美无缺的惊世杰作。</p><p>励志文章3:一生学习，成就一生无知的人并不是没有学问的人，而是不明了自己的人。当一个有学问的人信赖书本、知识和权威，借着它们而了解自己，那么他便是愚蠢的。了解是由自我认识而来，而自我认识乃是一个人明白他自己的整个心理过程。因此，教育的真正意义是自我了解，因为整个生活是汇聚于我们每个人的身心的最高“机密”。</p><p>   目前我们所谓的教育，只是由书本聚集见闻、知识，这是任何懂得阅读的人都办得到的。这种教育提供了一条巧妙的逃避自我之途，如同其他所有的逃避方式一样，它无可避免地制造出有增无减的苦难。冲突和混乱是由于我们和他人、事物、概念之间差错的关系而产生，除非我们了解此项关系而改变它，否则，知识的学习和堆砌，各种技能的获取，都只会将我们导向更深的混乱和毁灭。</p><p> 我们将子女送入学校，学习一些技能，并希望借此来带动整个家庭的长久繁荣，至少在家长们年老的时候有养老保险，有稳定的照顾。我们对孩子最急切的渴望，就是将他塑造成一个能在一个领域中出类拔萃之人，希望给予他一个安全的经济地位。物质的获得有时候并不难，然而，技术的训练能使我们了解自己吗?</p><p>虽然，懂得念书写字、学习土木工程或其他某种职业，是必需的，然而技术能给予我们了解生活的能力吗?技术，无疑是次要的;如果技术是我们惟一奋力以求的东西，那么我们就摒弃了生活中最主要的东西了。</p><p>    生活，是痛苦、喜悦、美、丑、爱等多种感受的综合，一旦我们将它整体地加以了解，那么这项了解在各方面都会创出它应有的技术。不过，相反的说法就不是真的了∶技术永远无法产生创造性的了解。</p><p>如果过分强调技术，我们便毁灭了人。磨练技能和效率，然而对生活却不了解，对思想、欲望的行踪不能领悟，只会使我们变得日益残暴无情，以致于触发战争，危害了我们肉体上的安全。由于我们的教育过重于单单培养技术，已经制造出许多科学家、数学家、造桥工程师、征服太空的人，但这些人了解生活的整体过程吗?一个专家能把生活本身完整地体验感受表达出来吗?或者他真的体验到生活了吗?有时候，当他不是专家时，反而更能直指生活的本质。一颗能够给予人辉煌一生的企图心，首先应当是一颗敏感的善良的热情的心，让我们对周围的一切保持孩童一样旺盛的好奇心。我们应当渴望了解新奇的事物，渴望探索未知的领域。只有在这种理念的支配下，我们才能不断地、孜孜以求地、乐此不疲地提升自己的认知和理解能力，改善自我，从而更接近成功的巅峰。</p>','发布人5','upload/news_headportrait5.jpg','分类名称5'),(6,'2026-01-05 02:46:19','远大的目标是成功的磁石','上天对每个老实人都是公平的，每个人每一天都是二十四个小时，每个人的所有时间都是一生;同时上天对每个老实人又是不公平的，给每一个人的时间不都是二十四个小时，给每一个人的所有时间不都是一生。这之间的区别就在于有无远大目标','upload/news_picture6.jpg','<p>  上天对每个老实人都是公平的，每个人每一天都是二十四个小时，每个人的所有时间都是一生;同时上天对每个老实人又是不公平的，给每一个人的时间不都是二十四个小时，给每一个人的所有时间不都是一生。这之间的区别就在于有无远大目标。</p><p>    有大目标的人，生活永远是积极的，他们会朝着自己的目标不断前进;没有大目标的老实人浑浑噩噩，不思进取，最后被生活淘汰。</p><p> 从前有个叫阿巴格的人生活在内蒙古草原上。有一次，年少的阿巴格和爸爸在草原上迷了路，阿巴格又累又怕，到最后快走不动了。爸爸就从兜里掏出五枚硬币，把一枚硬币埋在草地里，把其余四枚放在阿巴格的手上，说:“人生有五枚金币，童年、少年、青年、中年、老年各有一枚，你现在才用了一枚，就是埋在草地里的那一枚，你不能把五枚都扔在草原里，你要一点点地用，每一次都用出不同来，这样才不枉人生一世。今天我们一定要走出草原，你将来也一定要走出草原。世界很大，人活着，就要多走些地方，多看看，不要让你的金币没有用就扔掉。”在父亲的鼓励下，阿巴格走出了草原。长大后，阿巴格离开了家乡，成了一名十分优秀的船长。</p><p>  目标是与一个人的愿望相联系的，是对未来的一种设想，它往往和目前的行动不直接联系。但目标又不能脱离现实的生活，现实生活中的某些现象如果符合了个人的需要，与个人的世界观一致，这些现实的因素就会以个人目标的形式表现出来。目标总是对现实生活的重新加工，舍弃其中某些成分，又对某些因素给予强调的过程，但它必须以对客观规律的认识为基础，符合客观规律。</p><p> 能实现自己目标的老实人，对他个人而言，他是一个成功者，也是个幸福者。目标是成功的必要条件，虽然仅仅拥有目标，你不一定能取得成功;但是如果没有目标，成功对你而言就无从谈起。</p><p>远大的美好目标能吸引人努力为实现它而奋斗不止。</p>','发布人6','upload/news_headportrait6.jpg','分类名称6'),(7,'2026-01-05 02:46:19','做一个最好的自己','自信是成功的前提，你拥有自信，就拥有成功的一半机会。相信自己是最棒的就一定会成就一定的事业。拥有自信的人之所以会心想事成、走向成功，是因为他们都有着巨大无比的潜能等着去开发;消极失败的心态之所以会使人怯弱无能、走向失败，是因为它使人放弃潜能的开发，让潜能在那里沉睡、白白浪费','upload/news_picture7.jpg','<p>自信是成功的前提，你拥有自信，就拥有成功的一半机会。相信自己是最棒的就一定会成就一定的事业。拥有自信的人之所以会心想事成、走向成功，是因为他们都有着巨大无比的潜能等着去开发;消极失败的心态之所以会使人怯弱无能、走向失败，是因为它使人放弃潜能的开发，让潜能在那里沉睡、白白浪费。</p><p>我们大家都知道的人大脑拥有140亿个脑细胞，但我们思维意识只利用了脑细胞的很少部分，如能将更多的脑细胞从睡眠中激活出来，人的思维意识将更加强大。如果我们都能充满自信，就能创造人间奇迹，亦能创造一个最好的自己。</p><p> 一个人相信自己是什么，就会是什么。一个人心里怎样想，就会成为怎样的人。这从心里学上讲是有一定的道理的。我们每一个人心里都有一幅心里蓝图，或是一幅自画像，有人称它为运作结果。如果你想象的是做最好的你，那么你就会在你内心的荧光屏上看到一个踌躇满志、不断进取、勇于开拓创新的自我。同时还会经常收到我做的很好，我以后还会做的更好之类的信息，这样你注定会成为一个最好的你。美国哲学家爱默生说:“人的一生正如他一天中所想的那样，你怎么想，怎么期待，就有怎样的人生。”美国有名的钢铁大王安德鲁·卡耐基就是一个充分发挥自己创造机会的楷模。他12岁时由英格兰移居美国，先是在一家纺织厂做工人，当时他的目标是“做全厂最出色的工人。”因为他经常这样想，以这样做，最终他实现了他的目标。后来命运有安排他当邮递员，他想的是怎样成为“全美最杰出的邮递员。”结果他的这一目标也实现了。他的一生总是根据自己所处的环境和地位塑造最佳的自己，他的座右铭就是“相信自己是最棒的。“</p><p>做一个最好的自己，不一定非要当什么“家”，也不一定非要出什么“名”，更不要与别人比高低、比大小。就像人的手指，有大有小，有长有短，他们各有所长，各有所短，你能说拇指比食指好吗?决定最好的你，既不是你拥有的物质财富的多少，也不是你身份的贵贱，关键是看你是否拥有实现自己理想的强烈愿望的程度，看你身上的潜力能否充分发挥。人们熟知的一些英雄模范，就是在平凡的工作岗位上充分发挥人的创新能力，做好自己身边的每一件小事，创造了做好的自己。</p><p>“塑造一个最好的自己”，这个目标人人都可以实现。你只意识到自己是大自然的一分子，坚信自己拥有“无限的能力”与“无限的可能”，这种坚定的信心能帮助你创造和谐的心理、生理韵律，建立起自己理想的自我形象，体现自己人格行为应该具有的魅力。</p>','发布人7','upload/news_headportrait7.jpg','种植技术'),(8,'2026-01-05 02:46:19','有了梦想就不会感到疲惫','一段时间以前，一位在港的大陆学生，因为学业的压力、前途的渺茫等诸多原因，选择了自杀。在讨论和反思的潮流中，有一位毕业生在校内网匿名发表了自己的故事。他说，自己当年在学校也曾经面临绝境，一文不名。他选择了做“乞丐学生”，坚持着念完了课程。回忆的一些情节让我印象深刻，比如，平时偷偷住电梯间，蓬头垢面如乞丐;实在很饿，学校举办餐会的时候默默进场埋头大吃','upload/news_picture8.jpg','<p>  一段时间以前，一位在港的大陆学生，因为学业的压力、前途的渺茫等诸多原因，选择了自杀。在讨论和反思的潮流中，有一位毕业生在校内网匿名发表了自己的故事。他说，自己当年在学校也曾经面临绝境，一文不名。他选择了做“乞丐学生”，坚持着念完了课程。回忆的一些情节让我印象深刻，比如，平时偷偷住电梯间，蓬头垢面如乞丐;实在很饿，学校举办餐会的时候默默进场埋头大吃。</p><p>“峣峣者易折，皎皎者易污。”能够从内地高校到香港读书的学子，都是一些很优秀的年轻人。不知道曾经高居象牙塔的书生，怎样狠下心，咬牙面对那一个天渊般的落差，以及旁人的目光和议论。</p><p>  说到这里，很像一个《读者》式的励志故事。但是这种励志故事从来就不缺乏感动人的力量，因为虽然光明的尾巴不是人人都能够拥有，但是人人都有梦想，面对实现过程中的困难，其奋斗或者说挣扎，却常常和平凡如你我的人们相遇。</p><p>    《当幸福来敲门/The Pursuit of Happyness》就是这样偶然被看到，又感动了我的电影。黑人克里斯是一名普普通通的医疗器械推销员，妻子忍受不了经济上的压力离开了他，留下5岁的儿子克里斯托夫和他相依为命。克里斯银行账户里只剩下21块钱，因为没钱付房租，他和儿子被撵出了公寓。费尽周折，克里斯赢得了在一家着名股票投资公司实习的机会，但是实习期间没有薪水，而且最终只有一人可以成功进入公司。</p><p>    学妹曾经告诉我一个故事，让我每次想到都觉得莫名恐怖。她说，她硕士毕业去广东求职，一个中学要招几个老师，结果南来北往的硕士博士挤了快有一个礼堂。可想而知，竞争有多么残酷。看来，中外求职者都面临着同样的挑战。但是克里斯和许多“80后”的大学毕业生不同，他更加坚韧:为了节省时间，上班时候不喝水，以避免上厕所。以疯狂的速度给客户打电话，打完一个，直接按挂机键就拨下一个电话。白天，克里斯忍受着一次又一次被拒绝的失望，带着微笑在公司和客户之间穿梭。回家，则要带着儿子穿过污秽的街道，忍受房东的咆哮。</p><p>    终于，交不起房租的父子俩流落街头。克里斯和儿子在午夜地铁里相对无言，儿子不能理解为什么不能回家住，爸爸却开始玩游戏:“我们通过时光机，到达古代了!”儿子立刻兴奋地配合起来，环顾左右。父子俩在“恐龙”的追杀下，逃到了一个“山洞”里，“山洞”是什么呢，其实是一间男厕所。克里斯搂着熟睡的儿子，坐靠在厕所的墙面。午夜的灯光很惨白，这个消瘦的、营养不良的父亲，默默地流下了泪水。</p><p>    父子俩依旧为了幸福到来而努力。他们开始住收容所，面对有限的床位，这个奔跑起来像猎豹一样的人，有时候得把草原上的爆发力运用到打架上面来。儿子在简陋的收容所床上睡着了，父亲还在埋头修理推销的医疗器械，或者翻那本厚厚的笔试全书。</p><p>   钱包磨损得厉害，而且，太瘪了，每张钱都很熟悉。老板要借5块钱，犹豫再三，摩挚着纸币，最终还是把钱送了出去。卖血。鲜血在塑料袋里面渗开，那是一个男人所能奉献的最后。拿着卖血的钱，克里斯仍然去买电子元件。一点点的希望，都要去坚持。</p><p>对于父母，最心酸的事儿是什么呢?就是子女的一点可怜的愿望得不到满足。克里斯托夫的惟一的玩偶“美国英雄”，在一次挤车的过程中掉到了地上。5岁的男孩悲伤欲绝，克里斯坚硬的表情下，读出的是面对困难的凶狠和惨痛。但是，无论多么深切的无望，都没有摧毁父子间的亲情与他们的信念，他们相信幸福总会落到自己的身上。“你是个好爸爸”，克里斯托夫跟着爸爸四处流浪，可是孩子的心灵，衡量的砝码和天使是—样的。</p><p>  克里斯最终成为了投资公司的员工，看似冷漠的白人老板们，此时显出他们的些微温情。他忍住了泪水，颤抖着拿起自己的物品，走入了茫茫人海。在熙熙攘攘的人群中间，克里斯举起手，为自己鼓掌，那无声的，一下下重重的掌声，是在为自己喝彩。其实，克里斯托夫的“美国英雄”并没有失落。</p><p>  这是一个非常典型的“美国梦”:一个人通过自己的努力，可以实现自己的梦想，幸福，会来敲门。很多人往往会关注对于梦想的树立，而往往忽略过程的艰辛。特别是，当面对一个看似无望的现实的时候，有多少人会坚持，多少人会放弃呢?生活总是在不断地修正，并且提醒我们，顺应大潮的人总是较有可能抵达成功的彼岸。可是，确实是有些人，愿意逆流而上。我相信，这是导演对于逆行者的一点鼓励。</p><p>那个香港的匿名毕业生后来博士毕业，找到了一份不错的工作，有了漂亮的妻子和可爱的孩子。这个强人在帖子里说，有什么坚持不下来的呢?只要有梦想</p>','发布人8','upload/news_headportrait8.jpg','病虫害防治知识'),(9,'2026-01-05 03:07:01','技术培训通知','内容可自行编辑\n内容可自行编辑','upload/1767582406570_1.jpg','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>','小计','','技术资讯'),(10,'2026-01-05 03:07:29','政策公告','内容可自行编辑\n内容可自行编辑','upload/1767582437676_20.jpg','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>','陈莉','','种植技术');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newstype`
--

DROP TABLE IF EXISTS `newstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `newstype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `typename` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`),
  KEY `newstype_98l3` (`typename`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资讯分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newstype`
--

LOCK TABLES `newstype` WRITE;
/*!40000 ALTER TABLE `newstype` DISABLE KEYS */;
INSERT INTO `newstype` VALUES (1,'2026-01-05 02:46:19','分类名称1'),(2,'2026-01-05 02:46:19','分类名称2'),(3,'2026-01-05 02:46:19','分类名称3'),(4,'2026-01-05 02:46:19','分类名称4'),(5,'2026-01-05 02:46:19','分类名称5'),(6,'2026-01-05 02:46:19','分类名称6'),(7,'2026-01-05 02:46:19','种植技术'),(8,'2026-01-05 02:46:19','病虫害防治知识'),(9,'2026-01-05 03:06:40','技术资讯');
/*!40000 ALTER TABLE `newstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nonghu`
--

DROP TABLE IF EXISTS `nonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `nonghuzhanghao` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '农户账号',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `nonghuxingming` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '农户姓名',
  `xingbie` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `lianxidianhua` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `pquestion` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保问题',
  `panswer` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保答案',
  `status` int(11) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nonghuzhanghao` (`nonghuzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1767581670730 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='农户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nonghu`
--

LOCK TABLES `nonghu` WRITE;
/*!40000 ALTER TABLE `nonghu` DISABLE KEYS */;
INSERT INTO `nonghu` VALUES (11,'2026-01-05 02:46:18','108','e10adc3949ba59abbe56e057f20f883e','王静','女','upload/nonghu_touxiang1.jpg','13987654321','密保问题1','密保答案1',0),(12,'2026-01-05 02:46:18','106','e10adc3949ba59abbe56e057f20f883e','李静','男','upload/nonghu_touxiang2.jpg','13765432109','密保问题2','密保答案2',0),(13,'2026-01-05 02:46:18','102','e10adc3949ba59abbe56e057f20f883e','刘洋','女','upload/nonghu_touxiang3.jpg','15267890123','密保问题3','密保答案3',0),(14,'2026-01-05 02:46:18','103','e10adc3949ba59abbe56e057f20f883e','李军','女','upload/nonghu_touxiang4.jpg','13567890123','密保问题4','密保答案4',0),(15,'2026-01-05 02:46:18','104','e10adc3949ba59abbe56e057f20f883e','赵刚','男','upload/nonghu_touxiang5.jpg','13290123456','密保问题5','密保答案5',0),(16,'2026-01-05 02:46:18','101','e10adc3949ba59abbe56e057f20f883e','李娜','女','upload/nonghu_touxiang6.jpg','13890123456','密保问题6','密保答案6',0),(17,'2026-01-05 02:46:18','105','e10adc3949ba59abbe56e057f20f883e','赵伟','男','upload/nonghu_touxiang7.jpg','13187654321','密保问题7','密保答案7',0),(18,'2026-01-05 02:46:18','107','e10adc3949ba59abbe56e057f20f883e','王明','男','upload/nonghu_touxiang8.jpg','13812345678','密保问题8','密保答案8',0),(1767581670729,'2026-01-05 02:54:30','11','6512bd43d9caa6e02c990b0a82652dca','李思思','女','upload/1767581667146_792.jpg','13515225145','111','11',0);
/*!40000 ALTER TABLE `nonghu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shebeianzhuang`
--

DROP TABLE IF EXISTS `shebeianzhuang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shebeianzhuang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `shebeixinghao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备型号',
  `yunxingzhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运行状态',
  `anzhuangshijian` date DEFAULT NULL COMMENT '安装时间',
  `anzhuangxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '安装详情',
  `jishuyuanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员账号',
  `jishuyuanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员姓名',
  `nonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='设备安装';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shebeianzhuang`
--

LOCK TABLES `shebeianzhuang` WRITE;
/*!40000 ALTER TABLE `shebeianzhuang` DISABLE KEYS */;
INSERT INTO `shebeianzhuang` VALUES (1,'2026-01-05 02:46:19','春芽一号棚','苗床架','育苗设备','upload/shebeianzhuang_苗床架1.jpg,upload/shebeianzhuang_苗床架2.jpg,upload/shebeianzhuang_苗床架3.jpg','MC200','正常','2026-01-05','此处文本编辑框是内容详细的操作提示，您可以对现有文字进行修改，包括删除多余文字、替换不合适的表述等；插入图片时，既可以从本地选择图片上传，图片插入后会直接展示在编辑框中，完成操作后点击空白区域即可保存。','3003','张鹏','108','王静',1,1),(2,'2026-01-05 02:46:19','汇农八号棚','喷雾器','植保设备','upload/shebeianzhuang_喷雾器1.jpg,upload/shebeianzhuang_喷雾器2.jpg,upload/shebeianzhuang_喷雾器3.jpg','PW100','正常','2026-01-05','此编辑框内的默认内容为可编辑状态，您可对文字进行修改，比如调整语句顺序、更换文字内容等；插入图片时，支持上传图片，上传后图片会直接在编辑框中展示，也能一键删除不需要的图片。','3005','谢伟','106','李静',2,2),(3,'2026-01-05 02:46:19','冬韵四号棚','温控器','环境控制设备','upload/shebeianzhuang_温控器1.jpg,upload/shebeianzhuang_温控器2.jpg,upload/shebeianzhuang_温控器3.jpg','WK300','正常','2026-01-05','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','3006','郑涛','102','刘洋',3,3),(4,'2026-01-05 02:46:19','玉润十九号棚','臭氧发生器','消毒设备','upload/shebeianzhuang_臭氧发生器1.jpg,upload/shebeianzhuang_臭氧发生器2.jpg,upload/shebeianzhuang_臭氧发生器3.jpg','CY200','正常','2026-01-05','编辑框中展示的默认内容仅为示例，您可任意修改其中的文字表述，比如更换词语、调整语句顺序等；当需要插入图片时，点击编辑框上方的 “插入图片” 按钮，上传图片后即可直接在编辑框中展示。','3007','梁杰','103','李军',4,4),(5,'2026-01-05 02:46:19','碧影十五号棚','气象站','环境监测设备','upload/shebeianzhuang_气象站1.jpg,upload/shebeianzhuang_气象站2.jpg,upload/shebeianzhuang_气象站3.jpg','QX500','正常','2026-01-05','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','3002','刘强','104','赵刚',5,5),(6,'2026-01-05 02:46:19','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/shebeianzhuang_二氧化碳发生器1.jpg,upload/shebeianzhuang_二氧化碳发生器2.jpg,upload/shebeianzhuang_二氧化碳发生器3.jpg','CR300','正常','2026-01-05','您看到的编辑框内默认提示可作为创作起点，支持对现有内容进行全面修改，包括删除冗余文字、替换表述方式等；插入图片时，既可以从本地上传，也能粘贴网络图片地址，图片插入后会直接在文本中展示，完成后点击空白处即可保存设置。​','3008','胡伟','101','李娜',6,6),(7,'2026-01-05 02:46:19','翠玉十三号棚','除雾器','环境调节设备','upload/shebeianzhuang_除雾器1.jpg,upload/shebeianzhuang_除雾器2.jpg,upload/shebeianzhuang_除雾器3.jpg','CW200','正常','2026-01-05','此处文本编辑框是内容详细的操作提示，您能轻松对框内文字进行修改，像更正错误文字、调整文字内容等都能实现；插入图片的话，点击工具栏上的图片按钮，选择要插入的图片，图片就会在编辑框中展示，支持随时再次编辑。','3004','吴敏','105','赵伟',7,7),(8,'2026-01-05 02:46:19','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/shebeianzhuang_水肥一体机1.jpg,upload/shebeianzhuang_水肥一体机2.jpg,upload/shebeianzhuang_水肥一体机3.jpg','SF600','正常','2026-01-05','此编辑框内已详情的内容，您可以直接对现有文字进行修改，无论是调整文字内容、更正表述还是增减文字数量都能实现；若需插入图片，只需点击上方工具栏的图片图标，选择本地文件或输入图片链接即可插入展示，所有操作完成后提交后系统会保存您的修改。​','3001','罗琳','107','王明',8,8),(9,'2026-01-05 03:11:18','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','CO2500','正常','2026-01-05','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>','22','张毅','11','李思思',1767581811405,9);
/*!40000 ALTER TABLE `shebeianzhuang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shebeicaigou`
--

DROP TABLE IF EXISTS `shebeicaigou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shebeicaigou` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `shebeixinghao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备型号',
  `caigoushijian` date DEFAULT NULL COMMENT '采购时间',
  `caigoujiage` double DEFAULT NULL COMMENT '采购价格',
  `shuliang` int(11) DEFAULT NULL COMMENT '采购数量',
  `zongjine` double DEFAULT NULL COMMENT '总金额',
  `caigoubeizhu` longtext COLLATE utf8mb4_unicode_ci COMMENT '采购备注',
  `xinyongdaima` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '信用代码',
  `hezuoshemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '合作社名称',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='设备采购';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shebeicaigou`
--

LOCK TABLES `shebeicaigou` WRITE;
/*!40000 ALTER TABLE `shebeicaigou` DISABLE KEYS */;
INSERT INTO `shebeicaigou` VALUES (1,'2026-01-05 02:46:18','春芽一号棚','苗床架','育苗设备','upload/shebeicaigou_苗床架1.jpg,upload/shebeicaigou_苗床架2.jpg,upload/shebeicaigou_苗床架3.jpg','MC200','2026-01-05',53,18,189,'此处文本编辑框是内容详细的操作提示，您可以对现有文字进行修改，包括删除多余文字、替换不合适的表述等；插入图片时，既可以从本地选择图片上传，图片插入后会直接展示在编辑框中，完成操作后点击空白区域即可保存。','93500105MA2345T8U0','福临门果蔬专业合作社',1,1),(2,'2026-01-05 02:46:18','汇农八号棚','喷雾器','植保设备','upload/shebeicaigou_喷雾器1.jpg,upload/shebeicaigou_喷雾器2.jpg,upload/shebeicaigou_喷雾器3.jpg','PW100','2026-01-05',64,28,178,'此编辑框内的默认内容为可编辑状态，您可对文字进行修改，比如调整语句顺序、更换文字内容等；插入图片时，支持上传图片，上传后图片会直接在编辑框中展示，也能一键删除不需要的图片。','93340104MA5678X0Y2','绿宝果蔬专业合作社',2,2),(3,'2026-01-05 02:46:18','冬韵四号棚','温控器','环境控制设备','upload/shebeicaigou_温控器1.jpg,upload/shebeicaigou_温控器2.jpg,upload/shebeicaigou_温控器3.jpg','WK300','2026-01-05',45,11,88,'此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','93350203MA4321N5O7','绿洲果蔬专业合作社',3,3),(4,'2026-01-05 02:46:18','玉润十九号棚','臭氧发生器','消毒设备','upload/shebeicaigou_臭氧发生器1.jpg,upload/shebeicaigou_臭氧发生器2.jpg,upload/shebeicaigou_臭氧发生器3.jpg','CY200','2026-01-05',78,16,111,'编辑框中展示的默认内容仅为示例，您可任意修改其中的文字表述，比如更换词语、调整语句顺序等；当需要插入图片时，点击编辑框上方的 “插入图片” 按钮，上传图片后即可直接在编辑框中展示。','93330109MA5432H1I4','绿禾果蔬专业合作社',4,4),(5,'2026-01-05 02:46:18','碧影十五号棚','气象站','环境监测设备','upload/shebeicaigou_气象站1.jpg,upload/shebeicaigou_气象站2.jpg,upload/shebeicaigou_气象站3.jpg','QX500','2026-01-05',46,2,191,'此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','93380102MA1098H5I8','乐农果蔬专业合作社',5,5),(6,'2026-01-05 02:46:18','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/shebeicaigou_二氧化碳发生器1.jpg,upload/shebeicaigou_二氧化碳发生器2.jpg,upload/shebeicaigou_二氧化碳发生器3.jpg','CR300','2026-01-05',32,1,170,'您看到的编辑框内默认提示可作为创作起点，支持对现有内容进行全面修改，包括删除冗余文字、替换表述方式等；插入图片时，既可以从本地上传，也能粘贴网络图片地址，图片插入后会直接在文本中展示，完成后点击空白处即可保存设置。​','93310115MA7654R7S9','绿满园果蔬专业合作社',6,6),(7,'2026-01-05 02:46:18','翠玉十三号棚','除雾器','环境调节设备','upload/shebeicaigou_除雾器1.jpg,upload/shebeicaigou_除雾器2.jpg,upload/shebeicaigou_除雾器3.jpg','CW200','2026-01-05',23,7,195,'此处文本编辑框是内容详细的操作提示，您能轻松对框内文字进行修改，像更正错误文字、调整文字内容等都能实现；插入图片的话，点击工具栏上的图片按钮，选择要插入的图片，图片就会在编辑框中展示，支持随时再次编辑。','93410108MA44K1L9P2','惠民果蔬专业合作社',7,7),(8,'2026-01-05 02:46:18','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/shebeicaigou_水肥一体机1.jpg,upload/shebeicaigou_水肥一体机2.jpg,upload/shebeicaigou_水肥一体机3.jpg','SF600','2026-01-05',68,24,83,'此编辑框内已详情的内容，您可以直接对现有文字进行修改，无论是调整文字内容、更正表述还是增减文字数量都能实现；若需插入图片，只需点击上方工具栏的图片图标，选择本地文件或输入图片链接即可插入展示，所有操作完成后提交后系统会保存您的修改。​','93360102MA6789B2C5','祥和果蔬专业合作社',8,8),(9,'2026-01-05 03:24:57','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','CO2500','2026-01-05',150,50,7500,'<p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p>','33','绿田野果蔬专业合作社',1767581902819,9);
/*!40000 ALTER TABLE `shebeicaigou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shebeigoumai`
--

DROP TABLE IF EXISTS `shebeigoumai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shebeigoumai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `shebeixinghao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备型号',
  `goumaishijian` date DEFAULT NULL COMMENT '购买时间',
  `shuliang` int(11) DEFAULT NULL COMMENT '购买数量',
  `jiage` double DEFAULT NULL COMMENT '价格',
  `goumaijine` double DEFAULT NULL COMMENT '购买金额',
  `nonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='设备购买';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shebeigoumai`
--

LOCK TABLES `shebeigoumai` WRITE;
/*!40000 ALTER TABLE `shebeigoumai` DISABLE KEYS */;
INSERT INTO `shebeigoumai` VALUES (1,'2026-01-05 02:46:18','春芽一号棚','苗床架','育苗设备','upload/shebeigoumai_苗床架1.jpg,upload/shebeigoumai_苗床架2.jpg,upload/shebeigoumai_苗床架3.jpg','MC200','2026-01-05',18,53,189,'108','王静'),(2,'2026-01-05 02:46:18','汇农八号棚','喷雾器','植保设备','upload/shebeigoumai_喷雾器1.jpg,upload/shebeigoumai_喷雾器2.jpg,upload/shebeigoumai_喷雾器3.jpg','PW100','2026-01-05',28,64,178,'106','李静'),(3,'2026-01-05 02:46:19','冬韵四号棚','温控器','环境控制设备','upload/shebeigoumai_温控器1.jpg,upload/shebeigoumai_温控器2.jpg,upload/shebeigoumai_温控器3.jpg','WK300','2026-01-05',11,45,88,'102','刘洋'),(4,'2026-01-05 02:46:19','玉润十九号棚','臭氧发生器','消毒设备','upload/shebeigoumai_臭氧发生器1.jpg,upload/shebeigoumai_臭氧发生器2.jpg,upload/shebeigoumai_臭氧发生器3.jpg','CY200','2026-01-05',16,78,111,'103','李军'),(5,'2026-01-05 02:46:19','碧影十五号棚','气象站','环境监测设备','upload/shebeigoumai_气象站1.jpg,upload/shebeigoumai_气象站2.jpg,upload/shebeigoumai_气象站3.jpg','QX500','2026-01-05',2,46,191,'104','赵刚'),(6,'2026-01-05 02:46:19','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/shebeigoumai_二氧化碳发生器1.jpg,upload/shebeigoumai_二氧化碳发生器2.jpg,upload/shebeigoumai_二氧化碳发生器3.jpg','CR300','2026-01-05',1,32,170,'101','李娜'),(7,'2026-01-05 02:46:19','翠玉十三号棚','除雾器','环境调节设备','upload/shebeigoumai_除雾器1.jpg,upload/shebeigoumai_除雾器2.jpg,upload/shebeigoumai_除雾器3.jpg','CW200','2026-01-05',7,23,195,'105','赵伟'),(8,'2026-01-05 02:46:19','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/shebeigoumai_水肥一体机1.jpg,upload/shebeigoumai_水肥一体机2.jpg,upload/shebeigoumai_水肥一体机3.jpg','SF600','2026-01-05',24,68,83,'107','王明'),(9,'2026-01-05 03:08:16','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','CO2500','2026-01-05',5,200,1000,'11','李思思');
/*!40000 ALTER TABLE `shebeigoumai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shebeileixing`
--

DROP TABLE IF EXISTS `shebeileixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shebeileixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '设备类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shebeileixing` (`shebeileixing`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='设备类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shebeileixing`
--

LOCK TABLES `shebeileixing` WRITE;
/*!40000 ALTER TABLE `shebeileixing` DISABLE KEYS */;
INSERT INTO `shebeileixing` VALUES (1,'2026-01-05 02:46:18','育苗设备'),(2,'2026-01-05 02:46:18','植保设备'),(3,'2026-01-05 02:46:18','环境控制设备'),(4,'2026-01-05 02:46:18','消毒设备'),(5,'2026-01-05 02:46:18','环境监测设备'),(6,'2026-01-05 02:46:18','气体补充设备'),(7,'2026-01-05 02:46:18','环境调节设备'),(8,'2026-01-05 02:46:18','灌溉施肥设备'),(9,'2026-01-05 03:01:11','气体监测设备');
/*!40000 ALTER TABLE `shebeileixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shebeiweixiu`
--

DROP TABLE IF EXISTS `shebeiweixiu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shebeiweixiu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `weixiushijian` date DEFAULT NULL COMMENT '维修时间',
  `weihujilu` longtext COLLATE utf8mb4_unicode_ci COMMENT '维护记录',
  `nonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  `jishuyuanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员账号',
  `jishuyuanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='设备维修';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shebeiweixiu`
--

LOCK TABLES `shebeiweixiu` WRITE;
/*!40000 ALTER TABLE `shebeiweixiu` DISABLE KEYS */;
INSERT INTO `shebeiweixiu` VALUES (1,'2026-01-05 02:46:19','春芽一号棚','苗床架','育苗设备','upload/shebeiweixiu_苗床架1.jpg,upload/shebeiweixiu_苗床架2.jpg,upload/shebeiweixiu_苗床架3.jpg','2026-01-05','每月检查结构稳定性','108','王静','3003','张鹏'),(2,'2026-01-05 02:46:19','汇农八号棚','喷雾器','植保设备','upload/shebeiweixiu_喷雾器1.jpg,upload/shebeiweixiu_喷雾器2.jpg,upload/shebeiweixiu_喷雾器3.jpg','2026-01-05','每次使用后清洁保养','106','李静','3005','谢伟'),(3,'2026-01-05 02:46:19','冬韵四号棚','温控器','环境控制设备','upload/shebeiweixiu_温控器1.jpg,upload/shebeiweixiu_温控器2.jpg,upload/shebeiweixiu_温控器3.jpg','2026-01-05','每月清洁传感器探头','102','刘洋','3006','郑涛'),(4,'2026-01-05 02:46:19','玉润十九号棚','臭氧发生器','消毒设备','upload/shebeiweixiu_臭氧发生器1.jpg,upload/shebeiweixiu_臭氧发生器2.jpg,upload/shebeiweixiu_臭氧发生器3.jpg','2026-01-05','每季度维护一次','103','李军','3007','梁杰'),(5,'2026-01-05 02:46:19','碧影十五号棚','气象站','环境监测设备','upload/shebeiweixiu_气象站1.jpg,upload/shebeiweixiu_气象站2.jpg,upload/shebeiweixiu_气象站3.jpg','2026-01-05','每季度校准一次','104','赵刚','3002','刘强'),(6,'2026-01-05 02:46:19','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/shebeiweixiu_二氧化碳发生器1.jpg,upload/shebeiweixiu_二氧化碳发生器2.jpg,upload/shebeiweixiu_二氧化碳发生器3.jpg','2026-01-05','每月检查设备密封性','101','李娜','3008','胡伟'),(7,'2026-01-05 02:46:19','翠玉十三号棚','除雾器','环境调节设备','upload/shebeiweixiu_除雾器1.jpg,upload/shebeiweixiu_除雾器2.jpg,upload/shebeiweixiu_除雾器3.jpg','2026-01-05','每周清洁一次滤网','105','赵伟','3004','吴敏'),(8,'2026-01-05 02:46:19','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/shebeiweixiu_水肥一体机1.jpg,upload/shebeiweixiu_水肥一体机2.jpg,upload/shebeiweixiu_水肥一体机3.jpg','2026-01-05','每月清洁过滤系统','107','王明','3001','罗琳'),(9,'2026-01-05 03:18:42','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','2026-01-05','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>','11','李思思','22','张毅');
/*!40000 ALTER TABLE `shebeiweixiu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shebeixinxi`
--

DROP TABLE IF EXISTS `shebeixinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shebeixinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `shebeixinghao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备型号',
  `shebeipinpai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备品牌',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  `jiage` double DEFAULT NULL COMMENT '价格',
  `shengchanchangjia` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生产厂家',
  `dengjishijian` date DEFAULT NULL COMMENT '登记时间',
  `zhuyishixiang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '注意事项',
  `shebeixiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='设备信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shebeixinxi`
--

LOCK TABLES `shebeixinxi` WRITE;
/*!40000 ALTER TABLE `shebeixinxi` DISABLE KEYS */;
INSERT INTO `shebeixinxi` VALUES (1,'2026-01-05 02:46:18','春芽一号棚','苗床架','育苗设备','upload/shebeixinxi_苗床架1.jpg,upload/shebeixinxi_苗床架2.jpg,upload/shebeixinxi_苗床架3.jpg','MC200','育苗',1,1,'育苗设备制造厂','2026-01-05','避免超载堆放种苗','镀锌钢管材质承重50kg㎡'),(2,'2026-01-05 02:46:18','汇农八号棚','喷雾器','植保设备','upload/shebeixinxi_喷雾器1.jpg,upload/shebeixinxi_喷雾器2.jpg,upload/shebeixinxi_喷雾器3.jpg','PW100','农友',2,2,'农友植保工具厂','2026-01-05','使用后清洗药箱残留','手动加压喷雾射程8米'),(3,'2026-01-05 02:46:18','冬韵四号棚','温控器','环境控制设备','upload/shebeixinxi_温控器1.jpg,upload/shebeixinxi_温控器2.jpg,upload/shebeixinxi_温控器3.jpg','WK300','绿能',3,3,'绿能农业设备厂','2026-01-05','避免潮湿环境','智能数显温度控制范围535℃'),(4,'2026-01-05 02:46:18','玉润十九号棚','臭氧发生器','消毒设备','upload/shebeixinxi_臭氧发生器1.jpg,upload/shebeixinxi_臭氧发生器2.jpg,upload/shebeixinxi_臭氧发生器3.jpg','CY200','净安',4,4,'净安环保科技公司','2026-01-05','运行时禁止人员入内','臭氧产量10gh消毒面积100㎡'),(5,'2026-01-05 02:46:18','碧影十五号棚','气象站','环境监测设备','upload/shebeixinxi_气象站1.jpg,upload/shebeixinxi_气象站2.jpg,upload/shebeixinxi_气象站3.jpg','QX500','气象通',5,5,'气象通仪器公司','2026-01-05','安装于大棚顶部开阔处','监测风速风向温度湿度雨量'),(6,'2026-01-05 02:46:18','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/shebeixinxi_二氧化碳发生器1.jpg,upload/shebeixinxi_二氧化碳发生器2.jpg,upload/shebeixinxi_二氧化碳发生器3.jpg','CR300','气丰',6,6,'气丰设备制造公司','2026-01-05','使用时保持通风','产气速率500ppmh'),(7,'2026-01-05 02:46:18','翠玉十三号棚','除雾器','环境调节设备','upload/shebeixinxi_除雾器1.jpg,upload/shebeixinxi_除雾器2.jpg,upload/shebeixinxi_除雾器3.jpg','CW200','清雾',7,7,'清雾设备制造厂','2026-01-05','避免潮湿环境短路','功率500W除雾面积50㎡'),(8,'2026-01-05 02:46:18','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/shebeixinxi_水肥一体机1.jpg,upload/shebeixinxi_水肥一体机2.jpg,upload/shebeixinxi_水肥一体机3.jpg','SF600','智慧农',8,8,'智慧农业科技公司','2026-01-05','避免强酸强碱腐蚀','智能配比水肥浓度范围010%'),(9,'2026-01-05 03:04:51','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','CO2500','科创',65,200,'科创环保设备厂','2026-01-05','远离明火高温源','<p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p>');
/*!40000 ALTER TABLE `shebeixinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shifeijilu`
--

DROP TABLE IF EXISTS `shifeijilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shifeijilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `zuowumingcheng` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作物名称',
  `zuowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作物类型',
  `zhouqi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '周期',
  `zuowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '作物图片',
  `zhongzhimianji` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '种植面积㎡',
  `shifeishuliang` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '施肥数量',
  `shifeishijian` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '施肥时间',
  `shifeizhouqi` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '施肥周期',
  `shifeifangan` longtext COLLATE utf8mb4_unicode_ci COMMENT '施肥方案',
  `nonghuzhanghao` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='施肥记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shifeijilu`
--

LOCK TABLES `shifeijilu` WRITE;
/*!40000 ALTER TABLE `shifeijilu` DISABLE KEYS */;
INSERT INTO `shifeijilu` VALUES (1,'2026-01-05 02:46:18','春芽一号棚','油菜','十字花科','35天','upload/shifeijilu_油菜1.jpg,upload/shifeijilu_油菜2.jpg,upload/shifeijilu_油菜3.jpg','2.0亩','3kg','播种后5天','10天','速效氮肥促进叶片生长','108','王静'),(2,'2026-01-05 02:46:18','汇农八号棚','番茄','茄果类','90天','upload/shifeijilu_番茄1.jpg,upload/shifeijilu_番茄2.jpg,upload/shifeijilu_番茄3.jpg','0.8亩','10kg','定植后10天','15天','腐熟有机肥配合氮磷钾复合肥','106','李静'),(3,'2026-01-05 02:46:18','冬韵四号棚','豆角','豆类','85天','upload/shifeijilu_豆角1.jpg,upload/shifeijilu_豆角2.jpg,upload/shifeijilu_豆角3.jpg','1.1亩','11kg','播种后15天','18天','有机肥配合磷钾肥促进结荚','102','刘洋'),(4,'2026-01-05 02:46:18','玉润十九号棚','大葱','百合科','120天','upload/shifeijilu_大葱1.jpg,upload/shifeijilu_大葱2.jpg,upload/shifeijilu_大葱3.jpg','1.5亩','9kg','播种后25天','25天','有机肥为主少量复合肥追肥','103','李军'),(5,'2026-01-05 02:46:18','碧影十五号棚','白萝卜','根茎类','60天','upload/shifeijilu_白萝卜1.jpg,upload/shifeijilu_白萝卜2.jpg,upload/shifeijilu_白萝卜3.jpg','1.8亩','5kg','播种后10天','20天','速效氮肥为主后期增施钾肥','104','赵刚'),(6,'2026-01-05 02:46:18','晨光十七号棚','菠菜','叶菜类','30天','upload/shifeijilu_菠菜1.jpg,upload/shifeijilu_菠菜2.jpg,upload/shifeijilu_菠菜3.jpg','1.5亩','6kg','播种后7天','10天','速效氮肥为主促进叶片生长','101','李娜'),(7,'2026-01-05 02:46:18','翠玉十三号棚','苦瓜','瓜类','100天','upload/shifeijilu_苦瓜1.jpg,upload/shifeijilu_苦瓜2.jpg,upload/shifeijilu_苦瓜3.jpg','0.7亩','13kg','播种后20天','22天','氮磷钾复合肥配合腐熟饼肥','105','赵伟'),(8,'2026-01-05 02:46:18','晶彩七号棚','青椒','茄果类','100天','upload/shifeijilu_青椒1.jpg,upload/shifeijilu_青椒2.jpg,upload/shifeijilu_青椒3.jpg','0.6亩','8kg','定植后15天','25天','有机肥为主少量复合肥追肥','107','王明'),(9,'2026-01-05 03:17:03','夏荷二号棚','草莓','浆果类','120天','upload/1767582613705_30.jpg','0.5','5kg','移栽后10天','15天','草莓浆果类，周期120天，0.5㎡面积。每15天施5kg肥，均衡营养促生长。','11','李思思');
/*!40000 ALTER TABLE `shifeijilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shujuchakan`
--

DROP TABLE IF EXISTS `shujuchakan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shujuchakan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengbianhao` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '大棚编号',
  `dapengmingcheng` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '大棚名称',
  `dapengtupian` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '大棚图片',
  `dapengleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚类型',
  `wendu` int(11) DEFAULT NULL COMMENT '温度',
  `shidu` int(11) DEFAULT NULL COMMENT '湿度',
  `guangzhao` int(11) DEFAULT NULL COMMENT '光照',
  `fenxishijian` date DEFAULT NULL COMMENT '分析时间',
  `xinyongdaima` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '信用代码',
  `hezuoshemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '合作社名称',
  `yichangyuanyin` longtext COLLATE utf8mb4_unicode_ci COMMENT '异常原因',
  `nonghuzhanghao` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  `jishuyuanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员账号',
  `jishuyuanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dapengbianhao` (`dapengbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='数据查看';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shujuchakan`
--

LOCK TABLES `shujuchakan` WRITE;
/*!40000 ALTER TABLE `shujuchakan` DISABLE KEYS */;
INSERT INTO `shujuchakan` VALUES (1,'2026-01-05 02:46:18','GS001','春芽一号棚','upload/shujuchakan_春芽一号棚1.jpg,upload/shujuchakan_春芽一号棚2.jpg,upload/shujuchakan_春芽一号棚3.jpg','日光温室',18,65,18,'2023-07-11','93500105MA2345T8U0','福临门果蔬专业合作社','无异常','108','王静','3003','张鹏'),(2,'2026-01-05 02:46:18','GS008','汇农八号棚','upload/shujuchakan_汇农八号棚1.jpg,upload/shujuchakan_汇农八号棚2.jpg,upload/shujuchakan_汇农八号棚3.jpg','连栋温室',21,66,28,'2025-08-20','93340104MA5678X0Y2','绿宝果蔬专业合作社','土壤板结','106','李静','3005','谢伟'),(3,'2026-01-05 02:46:18','GS004','冬韵四号棚','upload/shujuchakan_冬韵四号棚1.jpg,upload/shujuchakan_冬韵四号棚2.jpg,upload/shujuchakan_冬韵四号棚3.jpg','连栋温室',20,68,11,'2023-04-27','93350203MA4321N5O7','绿洲果蔬专业合作社','通风不畅','102','刘洋','3006','郑涛'),(4,'2026-01-05 02:46:18','GS019','玉润十九号棚','upload/shujuchakan_玉润十九号棚1.jpg,upload/shujuchakan_玉润十九号棚2.jpg,upload/shujuchakan_玉润十九号棚3.jpg','玻璃温室',22,58,16,'2025-08-03','93330109MA5432H1I4','绿禾果蔬专业合作社','传感器失灵','103','李军','3007','梁杰'),(5,'2026-01-05 02:46:18','GS015','碧影十五号棚','upload/shujuchakan_碧影十五号棚1.jpg,upload/shujuchakan_碧影十五号棚2.jpg,upload/shujuchakan_碧影十五号棚3.jpg','玻璃温室',23,57,2,'2023-02-25','93380102MA1098H5I8','乐农果蔬专业合作社','湿度偏低','104','赵刚','3002','刘强'),(6,'2026-01-05 02:46:18','GS017','晨光十七号棚','upload/shujuchakan_晨光十七号棚1.jpg,upload/shujuchakan_晨光十七号棚2.jpg,upload/shujuchakan_晨光十七号棚3.jpg','日光温室',17,64,1,'2025-05-15','93310115MA7654R7S9','绿满园果蔬专业合作社','通风不良','101','李娜','3008','胡伟'),(7,'2026-01-05 02:46:18','GS013','翠玉十三号棚','upload/shujuchakan_翠玉十三号棚1.jpg,upload/shujuchakan_翠玉十三号棚2.jpg,upload/shujuchakan_翠玉十三号棚3.jpg','日光温室',18,63,7,'2023-04-10','93410108MA44K1L9P2','惠民果蔬专业合作社','温度波动大','105','赵伟','3004','吴敏'),(8,'2026-01-05 02:46:18','GS007','晶彩七号棚','upload/shujuchakan_晶彩七号棚1.jpg,upload/shujuchakan_晶彩七号棚2.jpg,upload/shujuchakan_晶彩七号棚3.jpg','玻璃温室',23,58,24,'2024-06-30','93360102MA6789B2C5','祥和果蔬专业合作社','设备供电中断','107','王明','3001','罗琳'),(9,'2026-01-05 03:11:07','GS002','夏荷二号棚','upload/1767582133402_907.jpg','塑料大棚',25,70,8,'2026-01-05','33','绿田野果蔬专业合作社','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>','11','李思思','22','张毅');
/*!40000 ALTER TABLE `shujuchakan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syslog`
--

DROP TABLE IF EXISTS `syslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syslog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `operation` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户操作',
  `method` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '请求方法',
  `params` longtext COLLATE utf8mb4_unicode_ci COMMENT '请求参数',
  `time` bigint(20) DEFAULT NULL COMMENT '请求时长(毫秒)',
  `ip` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'IP地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syslog`
--

LOCK TABLES `syslog` WRITE;
/*!40000 ALTER TABLE `syslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `syslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tixingjianxiu`
--

DROP TABLE IF EXISTS `tixingjianxiu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tixingjianxiu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `shebeixinghao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备型号',
  `tixingshijian` date DEFAULT NULL COMMENT '提醒时间',
  `jianxiuxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '检修详情',
  `jishuyuanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员账号',
  `jishuyuanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员姓名',
  `nonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='提醒检修';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tixingjianxiu`
--

LOCK TABLES `tixingjianxiu` WRITE;
/*!40000 ALTER TABLE `tixingjianxiu` DISABLE KEYS */;
INSERT INTO `tixingjianxiu` VALUES (1,'2026-01-05 02:46:19','春芽一号棚','苗床架','育苗设备','upload/tixingjianxiu_苗床架1.jpg,upload/tixingjianxiu_苗床架2.jpg,upload/tixingjianxiu_苗床架3.jpg','MC200','2026-01-05','此处文本编辑框是内容详细的操作提示，您可以对现有文字进行修改，包括删除多余文字、替换不合适的表述等；插入图片时，既可以从本地选择图片上传，图片插入后会直接展示在编辑框中，完成操作后点击空白区域即可保存。','3003','张鹏','108','王静'),(2,'2026-01-05 02:46:19','汇农八号棚','喷雾器','植保设备','upload/tixingjianxiu_喷雾器1.jpg,upload/tixingjianxiu_喷雾器2.jpg,upload/tixingjianxiu_喷雾器3.jpg','PW100','2026-01-05','此编辑框内的默认内容为可编辑状态，您可对文字进行修改，比如调整语句顺序、更换文字内容等；插入图片时，支持上传图片，上传后图片会直接在编辑框中展示，也能一键删除不需要的图片。','3005','谢伟','106','李静'),(3,'2026-01-05 02:46:19','冬韵四号棚','温控器','环境控制设备','upload/tixingjianxiu_温控器1.jpg,upload/tixingjianxiu_温控器2.jpg,upload/tixingjianxiu_温控器3.jpg','WK300','2026-01-05','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','3006','郑涛','102','刘洋'),(4,'2026-01-05 02:46:19','玉润十九号棚','臭氧发生器','消毒设备','upload/tixingjianxiu_臭氧发生器1.jpg,upload/tixingjianxiu_臭氧发生器2.jpg,upload/tixingjianxiu_臭氧发生器3.jpg','CY200','2026-01-05','编辑框中展示的默认内容仅为示例，您可任意修改其中的文字表述，比如更换词语、调整语句顺序等；当需要插入图片时，点击编辑框上方的 “插入图片” 按钮，上传图片后即可直接在编辑框中展示。','3007','梁杰','103','李军'),(5,'2026-01-05 02:46:19','碧影十五号棚','气象站','环境监测设备','upload/tixingjianxiu_气象站1.jpg,upload/tixingjianxiu_气象站2.jpg,upload/tixingjianxiu_气象站3.jpg','QX500','2026-01-05','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','3002','刘强','104','赵刚'),(6,'2026-01-05 02:46:19','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/tixingjianxiu_二氧化碳发生器1.jpg,upload/tixingjianxiu_二氧化碳发生器2.jpg,upload/tixingjianxiu_二氧化碳发生器3.jpg','CR300','2026-01-05','您看到的编辑框内默认提示可作为创作起点，支持对现有内容进行全面修改，包括删除冗余文字、替换表述方式等；插入图片时，既可以从本地上传，也能粘贴网络图片地址，图片插入后会直接在文本中展示，完成后点击空白处即可保存设置。​','3008','胡伟','101','李娜'),(7,'2026-01-05 02:46:19','翠玉十三号棚','除雾器','环境调节设备','upload/tixingjianxiu_除雾器1.jpg,upload/tixingjianxiu_除雾器2.jpg,upload/tixingjianxiu_除雾器3.jpg','CW200','2026-01-05','此处文本编辑框是内容详细的操作提示，您能轻松对框内文字进行修改，像更正错误文字、调整文字内容等都能实现；插入图片的话，点击工具栏上的图片按钮，选择要插入的图片，图片就会在编辑框中展示，支持随时再次编辑。','3004','吴敏','105','赵伟'),(8,'2026-01-05 02:46:19','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/tixingjianxiu_水肥一体机1.jpg,upload/tixingjianxiu_水肥一体机2.jpg,upload/tixingjianxiu_水肥一体机3.jpg','SF600','2026-01-05','此编辑框内已详情的内容，您可以直接对现有文字进行修改，无论是调整文字内容、更正表述还是增减文字数量都能实现；若需插入图片，只需点击上方工具栏的图片图标，选择本地文件或输入图片链接即可插入展示，所有操作完成后提交后系统会保存您的修改。​','3001','罗琳','107','王明'),(9,'2026-01-05 03:12:13','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','CO2500','2026-01-05','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>','22','张毅','11','李思思');
/*!40000 ALTER TABLE `tixingjianxiu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(255) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1767581670729,'11','nonghu','农户','inad0gynjk2p5re7waf7ewrezp9c3zav','2026-01-05 02:54:44','2026-01-05 04:31:38'),(2,1767581902819,'33','hezuoshe','合作社','f76n374t1cfgop4ebwg5ms8667iif3vw','2026-01-05 02:58:29','2026-01-05 04:24:24'),(3,1,'admin','users','管理员','m7rkbkz4ju82y9llkhstat0rfialfmvi','2026-01-05 02:58:57','2026-01-05 04:22:16'),(4,1767581811405,'22','jishurenyuan','技术人员','lor1jkexa65lufrcxpr95ddkpwug5bah','2026-01-05 03:10:59','2026-01-05 04:20:31');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tousujilu`
--

DROP TABLE IF EXISTS `tousujilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tousujilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `tousushijian` date DEFAULT NULL COMMENT '投诉时间',
  `tousubeizhu` longtext COLLATE utf8mb4_unicode_ci COMMENT '投诉备注',
  `nonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  `jishuyuanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员账号',
  `jishuyuanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员姓名',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='投诉记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tousujilu`
--

LOCK TABLES `tousujilu` WRITE;
/*!40000 ALTER TABLE `tousujilu` DISABLE KEYS */;
INSERT INTO `tousujilu` VALUES (1,'2026-01-05 02:46:19','春芽一号棚','苗床架','育苗设备','upload/tousujilu_苗床架1.jpg,upload/tousujilu_苗床架2.jpg,upload/tousujilu_苗床架3.jpg','2026-01-05','此处文本编辑框是内容详细的操作提示，您可以对现有文字进行修改，包括删除多余文字、替换不合适的表述等；插入图片时，既可以从本地选择图片上传，图片插入后会直接展示在编辑框中，完成操作后点击空白区域即可保存。','108','王静','3003','张鹏',1,1,''),(2,'2026-01-05 02:46:19','汇农八号棚','喷雾器','植保设备','upload/tousujilu_喷雾器1.jpg,upload/tousujilu_喷雾器2.jpg,upload/tousujilu_喷雾器3.jpg','2026-01-05','此编辑框内的默认内容为可编辑状态，您可对文字进行修改，比如调整语句顺序、更换文字内容等；插入图片时，支持上传图片，上传后图片会直接在编辑框中展示，也能一键删除不需要的图片。','106','李静','3005','谢伟',2,2,''),(3,'2026-01-05 02:46:19','冬韵四号棚','温控器','环境控制设备','upload/tousujilu_温控器1.jpg,upload/tousujilu_温控器2.jpg,upload/tousujilu_温控器3.jpg','2026-01-05','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','102','刘洋','3006','郑涛',3,3,''),(4,'2026-01-05 02:46:19','玉润十九号棚','臭氧发生器','消毒设备','upload/tousujilu_臭氧发生器1.jpg,upload/tousujilu_臭氧发生器2.jpg,upload/tousujilu_臭氧发生器3.jpg','2026-01-05','编辑框中展示的默认内容仅为示例，您可任意修改其中的文字表述，比如更换词语、调整语句顺序等；当需要插入图片时，点击编辑框上方的 “插入图片” 按钮，上传图片后即可直接在编辑框中展示。','103','李军','3007','梁杰',4,4,''),(5,'2026-01-05 02:46:19','碧影十五号棚','气象站','环境监测设备','upload/tousujilu_气象站1.jpg,upload/tousujilu_气象站2.jpg,upload/tousujilu_气象站3.jpg','2026-01-05','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','104','赵刚','3002','刘强',5,5,''),(6,'2026-01-05 02:46:19','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/tousujilu_二氧化碳发生器1.jpg,upload/tousujilu_二氧化碳发生器2.jpg,upload/tousujilu_二氧化碳发生器3.jpg','2026-01-05','您看到的编辑框内默认提示可作为创作起点，支持对现有内容进行全面修改，包括删除冗余文字、替换表述方式等；插入图片时，既可以从本地上传，也能粘贴网络图片地址，图片插入后会直接在文本中展示，完成后点击空白处即可保存设置。​','101','李娜','3008','胡伟',6,6,''),(7,'2026-01-05 02:46:19','翠玉十三号棚','除雾器','环境调节设备','upload/tousujilu_除雾器1.jpg,upload/tousujilu_除雾器2.jpg,upload/tousujilu_除雾器3.jpg','2026-01-05','此处文本编辑框是内容详细的操作提示，您能轻松对框内文字进行修改，像更正错误文字、调整文字内容等都能实现；插入图片的话，点击工具栏上的图片按钮，选择要插入的图片，图片就会在编辑框中展示，支持随时再次编辑。','105','赵伟','3004','吴敏',7,7,''),(8,'2026-01-05 02:46:19','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/tousujilu_水肥一体机1.jpg,upload/tousujilu_水肥一体机2.jpg,upload/tousujilu_水肥一体机3.jpg','2026-01-05','此编辑框内已详情的内容，您可以直接对现有文字进行修改，无论是调整文字内容、更正表述还是增减文字数量都能实现；若需插入图片，只需点击上方工具栏的图片图标，选择本地文件或输入图片链接即可插入展示，所有操作完成后提交后系统会保存您的修改。​','107','王明','3001','罗琳',8,8,''),(9,'2026-01-05 03:19:54','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','2026-01-05','<p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p><p>操作者可以在输入框输入&nbsp;&nbsp;详情信息&nbsp;&nbsp;等内容</p>','11','李思思','22','张毅',1767581670729,9,'好');
/*!40000 ALTER TABLE `tousujilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `role` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '管理员' COMMENT '角色',
  `image` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2026-01-05 02:46:19','admin','admin','管理员','upload/image1.jpg');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yujingxiezhu`
--

DROP TABLE IF EXISTS `yujingxiezhu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yujingxiezhu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `shebeixinghao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备型号',
  `xiezhushijian` date DEFAULT NULL COMMENT '协助时间',
  `xiezhuxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '协助详情',
  `jishuyuanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员账号',
  `jishuyuanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员姓名',
  `nonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='预警协助';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yujingxiezhu`
--

LOCK TABLES `yujingxiezhu` WRITE;
/*!40000 ALTER TABLE `yujingxiezhu` DISABLE KEYS */;
INSERT INTO `yujingxiezhu` VALUES (1,'2026-01-05 02:46:19','春芽一号棚','苗床架','育苗设备','upload/yujingxiezhu_苗床架1.jpg,upload/yujingxiezhu_苗床架2.jpg,upload/yujingxiezhu_苗床架3.jpg','MC200','2026-01-05','此处文本编辑框是内容详细的操作提示，您可以对现有文字进行修改，包括删除多余文字、替换不合适的表述等；插入图片时，既可以从本地选择图片上传，图片插入后会直接展示在编辑框中，完成操作后点击空白区域即可保存。','3003','张鹏','108','王静'),(2,'2026-01-05 02:46:19','汇农八号棚','喷雾器','植保设备','upload/yujingxiezhu_喷雾器1.jpg,upload/yujingxiezhu_喷雾器2.jpg,upload/yujingxiezhu_喷雾器3.jpg','PW100','2026-01-05','此编辑框内的默认内容为可编辑状态，您可对文字进行修改，比如调整语句顺序、更换文字内容等；插入图片时，支持上传图片，上传后图片会直接在编辑框中展示，也能一键删除不需要的图片。','3005','谢伟','106','李静'),(3,'2026-01-05 02:46:19','冬韵四号棚','温控器','环境控制设备','upload/yujingxiezhu_温控器1.jpg,upload/yujingxiezhu_温控器2.jpg,upload/yujingxiezhu_温控器3.jpg','WK300','2026-01-05','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','3006','郑涛','102','刘洋'),(4,'2026-01-05 02:46:19','玉润十九号棚','臭氧发生器','消毒设备','upload/yujingxiezhu_臭氧发生器1.jpg,upload/yujingxiezhu_臭氧发生器2.jpg,upload/yujingxiezhu_臭氧发生器3.jpg','CY200','2026-01-05','编辑框中展示的默认内容仅为示例，您可任意修改其中的文字表述，比如更换词语、调整语句顺序等；当需要插入图片时，点击编辑框上方的 “插入图片” 按钮，上传图片后即可直接在编辑框中展示。','3007','梁杰','103','李军'),(5,'2026-01-05 02:46:19','碧影十五号棚','气象站','环境监测设备','upload/yujingxiezhu_气象站1.jpg,upload/yujingxiezhu_气象站2.jpg,upload/yujingxiezhu_气象站3.jpg','QX500','2026-01-05','此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题；若要插入图片，点击上方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。​','3002','刘强','104','赵刚'),(6,'2026-01-05 02:46:19','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/yujingxiezhu_二氧化碳发生器1.jpg,upload/yujingxiezhu_二氧化碳发生器2.jpg,upload/yujingxiezhu_二氧化碳发生器3.jpg','CR300','2026-01-05','您看到的编辑框内默认提示可作为创作起点，支持对现有内容进行全面修改，包括删除冗余文字、替换表述方式等；插入图片时，既可以从本地上传，也能粘贴网络图片地址，图片插入后会直接在文本中展示，完成后点击空白处即可保存设置。​','3008','胡伟','101','李娜'),(7,'2026-01-05 02:46:19','翠玉十三号棚','除雾器','环境调节设备','upload/yujingxiezhu_除雾器1.jpg,upload/yujingxiezhu_除雾器2.jpg,upload/yujingxiezhu_除雾器3.jpg','CW200','2026-01-05','此处文本编辑框是内容详细的操作提示，您能轻松对框内文字进行修改，像更正错误文字、调整文字内容等都能实现；插入图片的话，点击工具栏上的图片按钮，选择要插入的图片，图片就会在编辑框中展示，支持随时再次编辑。','3004','吴敏','105','赵伟'),(8,'2026-01-05 02:46:19','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/yujingxiezhu_水肥一体机1.jpg,upload/yujingxiezhu_水肥一体机2.jpg,upload/yujingxiezhu_水肥一体机3.jpg','SF600','2026-01-05','此编辑框内已详情的内容，您可以直接对现有文字进行修改，无论是调整文字内容、更正表述还是增减文字数量都能实现；若需插入图片，只需点击上方工具栏的图片图标，选择本地文件或输入图片链接即可插入展示，所有操作完成后提交后系统会保存您的修改。​','3001','罗琳','107','王明'),(9,'2026-01-05 03:12:04','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','CO2500','2026-01-05','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>','22','张毅','11','李思思');
/*!40000 ALTER TABLE `yujingxiezhu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yujingxinxi`
--

DROP TABLE IF EXISTS `yujingxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yujingxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dapengmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大棚名称',
  `shebeimingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `shebeileixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `shebeitupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '设备图片',
  `shebeixinghao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备型号',
  `yujingshijian` date DEFAULT NULL COMMENT '预警时间',
  `yujingxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '预警详情',
  `jishuyuanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员账号',
  `jishuyuanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员姓名',
  `nonghuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户账号',
  `nonghuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '农户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='预警信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yujingxinxi`
--

LOCK TABLES `yujingxinxi` WRITE;
/*!40000 ALTER TABLE `yujingxinxi` DISABLE KEYS */;
INSERT INTO `yujingxinxi` VALUES (1,'2026-01-05 02:46:19','春芽一号棚','苗床架','育苗设备','upload/yujingxinxi_苗床架1.jpg,upload/yujingxinxi_苗床架2.jpg,upload/yujingxinxi_苗床架3.jpg','MC200','2026-01-05','无预警记录','3003','张鹏','108','王静'),(2,'2026-01-05 02:46:19','汇农八号棚','喷雾器','植保设备','upload/yujingxinxi_喷雾器1.jpg,upload/yujingxinxi_喷雾器2.jpg,upload/yujingxinxi_喷雾器3.jpg','PW100','2026-01-05','无预警记录','3005','谢伟','106','李静'),(3,'2026-01-05 02:46:19','冬韵四号棚','温控器','环境控制设备','upload/yujingxinxi_温控器1.jpg,upload/yujingxinxi_温控器2.jpg,upload/yujingxinxi_温控器3.jpg','WK300','2026-01-05','高温预警2次均及时处理','3006','郑涛','102','刘洋'),(4,'2026-01-05 02:46:19','玉润十九号棚','臭氧发生器','消毒设备','upload/yujingxinxi_臭氧发生器1.jpg,upload/yujingxinxi_臭氧发生器2.jpg,upload/yujingxinxi_臭氧发生器3.jpg','CY200','2026-01-05','无预警记录','3007','梁杰','103','李军'),(5,'2026-01-05 02:46:19','碧影十五号棚','气象站','环境监测设备','upload/yujingxinxi_气象站1.jpg,upload/yujingxinxi_气象站2.jpg,upload/yujingxinxi_气象站3.jpg','QX500','2026-01-05','大风预警2次','3002','刘强','104','赵刚'),(6,'2026-01-05 02:46:19','晨光十七号棚','二氧化碳发生器','气体补充设备','upload/yujingxinxi_二氧化碳发生器1.jpg,upload/yujingxinxi_二氧化碳发生器2.jpg,upload/yujingxinxi_二氧化碳发生器3.jpg','CR300','2026-01-05','无预警记录','3008','胡伟','101','李娜'),(7,'2026-01-05 02:46:19','翠玉十三号棚','除雾器','环境调节设备','upload/yujingxinxi_除雾器1.jpg,upload/yujingxinxi_除雾器2.jpg,upload/yujingxinxi_除雾器3.jpg','CW200','2026-01-05','无预警记录','3004','吴敏','105','赵伟'),(8,'2026-01-05 02:46:19','晶彩七号棚','水肥一体机','灌溉施肥设备','upload/yujingxinxi_水肥一体机1.jpg,upload/yujingxinxi_水肥一体机2.jpg,upload/yujingxinxi_水肥一体机3.jpg','SF600','2026-01-05','无预警记录','3001','罗琳','107','王明'),(9,'2026-01-05 03:11:45','夏荷二号棚','二氧化碳检测仪','气体监测设备','upload/1767582243169_956.jpg','CO2500','2026-01-05','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>','22','张毅','11','李思思');
/*!40000 ALTER TABLE `yujingxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zixunleixing`
--

DROP TABLE IF EXISTS `zixunleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zixunleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zixunleixing` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '资讯类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zixunleixing` (`zixunleixing`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资讯类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zixunleixing`
--

LOCK TABLES `zixunleixing` WRITE;
/*!40000 ALTER TABLE `zixunleixing` DISABLE KEYS */;
INSERT INTO `zixunleixing` VALUES (1,'2026-01-05 02:46:19','设备维护指南'),(2,'2026-01-05 02:46:19','果蔬种植技术文章'),(3,'2026-01-05 02:46:19','资讯类型3'),(4,'2026-01-05 02:46:19','资讯类型4'),(5,'2026-01-05 02:46:19','资讯类型5'),(6,'2026-01-05 02:46:19','资讯类型6'),(7,'2026-01-05 02:46:19','资讯类型7'),(8,'2026-01-05 02:46:19','资讯类型8'),(9,'2026-01-05 03:05:19','果蔬种植技术');
/*!40000 ALTER TABLE `zixunleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zixunneirong`
--

DROP TABLE IF EXISTS `zixunneirong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zixunneirong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zixunmingcheng` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '资讯名称',
  `zixunleixing` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '资讯类型',
  `zixuntupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '资讯图片',
  `shiyongchangjing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '适用场景',
  `nandudengji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '难度等级',
  `hexindian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '核心点',
  `buzhouliucheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '步骤流程',
  `zhuyishixiang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '注意事项',
  `shiyongrenqun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '适用人群',
  `fabushijian` date DEFAULT NULL COMMENT '发布时间',
  `zixunxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '资讯详情',
  `jishuyuanzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员账号',
  `jishuyuanxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术员姓名',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资讯内容';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zixunneirong`
--

LOCK TABLES `zixunneirong` WRITE;
/*!40000 ALTER TABLE `zixunneirong` DISABLE KEYS */;
INSERT INTO `zixunneirong` VALUES (1,'2026-01-05 02:46:19','大棚湿度计校准使用指南','设备维护指南','upload/zixunneirong_大棚湿度计校准使用指南1.jpg,upload/zixunneirong_大棚湿度计校准使用指南2.jpg,upload/zixunneirong_大棚湿度计校准使用指南3.jpg','各类大棚环境监测','简单','校准方法使用技巧','准备标准湿度源对比校准调整参数日常使用','避免湿度计靠近水源定期校准保证数据准确','大棚种植户农技人员','2026-01-05','介绍大棚湿度计的校准步骤及不同作物生长的湿度监测要点','3003','张鹏','是',''),(2,'2026-01-05 02:46:19','大棚西瓜吊蔓栽培技术','果蔬种植技术文章','upload/zixunneirong_大棚西瓜吊蔓栽培技术1.jpg,upload/zixunneirong_大棚西瓜吊蔓栽培技术2.jpg,upload/zixunneirong_大棚西瓜吊蔓栽培技术3.jpg','早春大棚种植','较高','吊蔓整枝人工授粉','整地搭架定植吊蔓整枝授粉疏果','控制棚内光照合理密植及时吊蔓防止倒伏','西瓜种植户设施农业从业者','2026-01-05','介绍大棚西瓜吊蔓栽培的架材选择定植密度整枝方法及坐果后的管理要点','3005','谢伟','是',''),(3,'2026-01-05 02:46:19','大棚温控器校准调试手册','设备维护指南','upload/zixunneirong_大棚温控器校准调试手册1.jpg,upload/zixunneirong_大棚温控器校准调试手册2.jpg,upload/zixunneirong_大棚温控器校准调试手册3.jpg','智能大棚使用','中等','校准参数调试运行','断电检查传感器校准参数设置通电测试','定期校准保证温控精度避免传感器受潮','农业技术员设备维护员','2026-01-05','讲解大棚温控器的传感器校准方法及不同作物的温度参数设置技巧','3006','郑涛','是',''),(4,'2026-01-05 02:46:19','大棚杀虫灯安装维护手册','设备维护指南','upload/zixunneirong_大棚杀虫灯安装维护手册1.jpg,upload/zixunneirong_大棚杀虫灯安装维护手册2.jpg,upload/zixunneirong_大棚杀虫灯安装维护手册3.jpg','各类大棚防虫','简单','安装位置清洁维护','选址安装接线调试清洁灯体更换诱虫板','定期清理虫尸避免灯体短路选择合适安装高度','大棚种植户植保人员','2026-01-05','介绍大棚杀虫灯的安装位置选择调试方法及日常维护技巧','3007','梁杰','是',''),(5,'2026-01-05 02:46:19','大棚滴灌系统堵塞处理方案','设备维护指南','upload/zixunneirong_大棚滴灌系统堵塞处理方案1.jpg,upload/zixunneirong_大棚滴灌系统堵塞处理方案2.jpg,upload/zixunneirong_大棚滴灌系统堵塞处理方案3.jpg','各类大棚灌溉','中等','管道疏通滤芯更换','排查堵塞位置拆卸清洗滤芯冲洗管道调试运行','定期清洗过滤器避免杂质进入管道','大棚种植户灌溉设备维护员','2026-01-05','介绍大棚滴灌系统堵塞原因及物理化学疏通方法','3002','刘强','是',''),(6,'2026-01-05 02:46:19','大棚水肥一体机故障排查手册','设备维护指南','upload/zixunneirong_大棚水肥一体机故障排查手册1.jpg,upload/zixunneirong_大棚水肥一体机故障排查手册2.jpg,upload/zixunneirong_大棚水肥一体机故障排查手册3.jpg','智能大棚灌溉施肥','较高','故障识别排查修复','电源检查管路检查参数检查故障修复调试运行','定期维护设备记录故障情况及时更换损坏部件','农业技术员设备维修员','2026-01-05','讲解大棚水肥一体机常见故障如管路堵塞电机不转等的排查与修复方法','3008','胡伟','是',''),(7,'2026-01-05 02:46:19','大棚菠菜越冬种植技术','果蔬种植技术文章','upload/zixunneirong_大棚菠菜越冬种植技术1.jpg,upload/zixunneirong_大棚菠菜越冬种植技术2.jpg,upload/zixunneirong_大棚菠菜越冬种植技术3.jpg','冬季大棚种植','简单','防寒保温水肥管理','选种整地播种覆膜防寒水肥管理采收','搭建防风障覆盖草苫增强抗寒能力','菠菜种植户散户种植者','2026-01-05','讲解大棚菠菜越冬品种选择播种时间及冬季防寒保温的具体方法','3004','吴敏','是',''),(8,'2026-01-05 02:46:19','大棚甜瓜坐果期管理指南','果蔬种植技术文章','upload/zixunneirong_大棚甜瓜坐果期管理指南1.jpg,upload/zixunneirong_大棚甜瓜坐果期管理指南2.jpg,upload/zixunneirong_大棚甜瓜坐果期管理指南3.jpg','春秋大棚种植','中等','授粉疏果温度调控','花期管理人工授粉疏果定果水肥管理','避免花期低温影响授粉合理疏果保证果实大小均匀','甜瓜种植户农技人员','2026-01-05','详述大棚甜瓜坐果期的温度湿度光照管理及提高坐果率的关键措施','3001','罗琳','是',''),(9,'2026-01-05 03:14:39','大棚草莓高产种植技术','果蔬种植技术','upload/1767582801633_866.jpg','冬春大棚种植','中等','温控授粉疏果','温控授粉疏果','控制棚内温湿度防治白粉病灰霉病','大棚种植户农业技术员','2026-01-05','<p>此处文本编辑框是内容详细的操作，您可以对框内现有的文字进行任意修改，无论是修改具体内容、调整语句逻辑还是增删文字都没问题;若要插入图片，点击上換方工具栏的图片标识，选择本地图片文件，就能将图片插入并展示出来，所有操作都进行保存。</p>','22','张毅','是','好');
/*!40000 ALTER TABLE `zixunneirong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zuowuleixing`
--

DROP TABLE IF EXISTS `zuowuleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zuowuleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zuowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '作物类型',
  `zhouqi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '周期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zuowuleixing` (`zuowuleixing`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='作物类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zuowuleixing`
--

LOCK TABLES `zuowuleixing` WRITE;
/*!40000 ALTER TABLE `zuowuleixing` DISABLE KEYS */;
INSERT INTO `zuowuleixing` VALUES (1,'2026-01-05 02:46:18','十字花科','35天'),(2,'2026-01-05 02:46:18','茄果类','90天'),(3,'2026-01-05 02:46:18','豆类','85天'),(4,'2026-01-05 02:46:18','百合科','120天'),(5,'2026-01-05 02:46:18','根茎类','60天'),(6,'2026-01-05 02:46:18','叶菜类','30天'),(7,'2026-01-05 02:46:18','瓜类','100天'),(8,'2026-01-05 02:46:18','作物类型8','100天'),(9,'2026-01-05 03:00:13','浆果类','120天');
/*!40000 ALTER TABLE `zuowuleixing` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-07 14:18:43
