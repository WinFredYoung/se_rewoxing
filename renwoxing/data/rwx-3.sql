-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2018-06-03 14:41:02
-- 服务器版本： 10.1.10-MariaDB
-- PHP Version: 7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rwx`
--

-- --------------------------------------------------------

--
-- 表的结构 `entertainment`
--

CREATE TABLE `entertainment` (
  `id` int(11) NOT NULL,
  `spot_id` int(11) NOT NULL,
  `spot_distance` float NOT NULL,
  `entertainment_name` varchar(30) NOT NULL,
  `entertainment_price` float NOT NULL,
  `entertainment_address` varchar(30) NOT NULL,
  `entertainment_score` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `entertainment`
--

INSERT INTO `entertainment` (`id`, `spot_id`, `spot_distance`, `entertainment_name`, `entertainment_price`, `entertainment_address`, `entertainment_score`) VALUES
(1, 5, 75, '桃花岛总店（新华街）', 150, '丽江市古城区新华街双石段20-22号', 3.1),
(2, 5, 94, '贝尔斯（大水车店）', 150, '丽江市古城区四方街72号', 3.5),
(3, 7, 408, '正龙量贩KTV（花马店）', 137, '丽江市古城区花马街S5-1号', 4.5),
(4, 7, 482, '月牙泉水疗会所', 50, '丽江市古城区花马街S-8栋', 4.5);

-- --------------------------------------------------------

--
-- 表的结构 `food`
--

CREATE TABLE `food` (
  `id` int(11) NOT NULL,
  `foodName` varchar(30) NOT NULL,
  `foodCuisine` varchar(30) DEFAULT NULL,
  `foodDescribe` text,
  `restaurant_id` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `food`
--

INSERT INTO `food` (`id`, `foodName`, `foodCuisine`, `foodDescribe`, `restaurant_id`) VALUES
(1, '丽江腊排骨火锅', '火锅', '云南丽江传统特色美食之一；纳西名菜“三叠水”中的“热烈叠”中的主菜；\r\n选用土法腌制的排骨；', '2'),
(2, '丽江粑粑', '面食', '纳西族独家的特色风味事物，历史悠久；\r\n有甜咸之分；不易变质变味；不易消化，老人小孩不宜多食用', '1'),
(3, '黑山羊火锅', '火锅', '发源于云南丽江，是丽江特色美食；\r\n搭配特产菌类，其汤美味无比', '6'),
(4, '鸡豆冻粉', '小吃', '丽江特产的一种凉粉小吃', '1'),
(5, '酸汤猪脚', '火锅', '云贵地区特色火锅，猪肉非清真', '3'),
(6, '饵块', '小吃', '云南特有的名特小吃，大米加工制成', '2'),
(7, '猪脚米线', '小吃', '非清真食品，米线是云南特色食品', '5'),
(8, '烤乳猪', '烧烤', '烧烤是泸沽湖的特色之一', '14'),
(9, '苏里玛酒', '酒水', '到了圣洁无暇的泸沽湖畔，热情好客的主人都会敬你一碗苏里玛。苏里玛是摩梭人家用传统工艺酿造的美酒。这种酒色微橙，酒度低，味醇美，被称为“摩梭啤酒”。它是摩梭人家迎宾待客的佳品。', '15'),
(10, '猪膘肉', '云南菜', '猪膘肉是泸沽湖畔摩梭人家特有的一种佳肴，是将宰杀后的生猪风腌成完整的腊猪。猪膘肉色、香、味俱佳，是待客、馈赠的佳品。猪膘肉是摩梭人财富的象征，一般摩梭人家都有这道美味。', '14'),
(11, '干巴鱼', '云南菜', '烤鱼干的主料是泸沽湖特产的巴鱼，将巴鱼处理干净后，撒上盐、花椒和五香粉，放置在火塘上或铁锅内缓慢烤干制成。在品尝这种烤鱼干时，将其在炭火上烤熟或用清油炸酥，味道香脆可口，也可以用其煮汤至乳白色，汤汁浓郁，口感极佳而且营养丰富。', '16'),
(12, '苦荞粑粑', '云南特色', '到摩梭人家去做客时，还有一道美食不可错过，就是主人自己做的粑粑。苦荞粑粑是泸沽湖当地的风味食品，用火灰烧出的苦荞粑粑，摆上十天半月不会变质。苦荞粑粑蘸冬蜂蜜进餐，苦甜爽口，回味无穷。', '17'),
(13, '虎跳峡土鸡 ', '炒菜', ' 虎跳峡的土鸡，是来此徒步的旅行者都必尝的。土鸡味道鲜美，肉质嫩滑，遇到了千万不要错过', '19'),
(14, '牦牛火锅', '火锅', '牦牛火锅是指专用青藏高原牦牛肉为主料的一种具有非常鲜明青藏民族特色的火锅，牦牛火锅味道十足，嫩滑爽劲，有清汤原味，酱香味，还有麻辣味，特别香辣，老少介宜，营养丰富，在冬天是一道美味的佳肴。', '10'),
(15, '梅子酒', '酒水', '用杨梅泡制而成', '26'),
(16, '纳西烤鱼', '烧烤', '纳西特色菜，香嫩百吃不厌', '31'),
(17, '纳西烤肉', '烧烤', '纳西特色菜', '30');

-- --------------------------------------------------------

--
-- 表的结构 `goods`
--

CREATE TABLE `goods` (
  `id` int(11) NOT NULL,
  `goodsName` varchar(30) DEFAULT NULL,
  `goodsDescribe` text,
  `isSpecialty` varchar(30) DEFAULT NULL,
  `shop_id` int(11) NOT NULL,
  `goodsCategory` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `goods`
--

INSERT INTO `goods` (`id`, `goodsName`, `goodsDescribe`, `isSpecialty`, `shop_id`, `goodsCategory`) VALUES
(1, '三川火腿', '三川火腿产于云南省丽江市\r\n永胜县三川坝，凭借水土、气候条件\r\n以及民间流的独特工艺，\r\n经六十六道工序精心腌制而成', '是', 2, '火腿'),
(2, '诺邓火腿', '产自云南省云龙县，\r\n主要食材为猪肉，盐卤，非清真食品', '是', 2, '火腿'),
(3, '宣威火腿', '宣威火腿，云南省著名地方特产之一，\r\n因产于宣威而得名，历史悠久，始于明代', '是', 2, '火腿'),
(4, '鹤庆火腿', '鹤庆火腿是云南名特食品，\r\n因其腿部弯曲，外形圆整，\r\n故又名圆腿或盘腿', '是', 2, '火腿'),
(5, '鲜花饼', '鲜花饼是以云南特有的食用玫瑰花入料的酥饼，是具有云南特色的云南经典点心代表。', '是', 1, '甜点'),
(6, '普洱茶', '普洱茶主要产于云南省的西双版纳、临沧、普洱等地区。普洱茶讲究冲泡技巧和品饮艺术，其饮用方法丰富，既可清饮，也可混饮。普洱茶茶汤橙黄浓厚，香气高锐持久，香型独特，滋味浓醇，经久耐泡。', '是', 14, '茶'),
(7, '滇红茶', '云南红茶简称滇红，属红茶类。由汉族茶农创制于民国年间。产于云南省南部与西南部的临沧、保山、凤庆、西双版纳、德宏等地。以大叶种红碎茶拼配形成，定型产品有叶茶、碎茶、片茶、末茶4类11个花色。其外形各有特定规格，身骨重实，色泽调匀，冲泡后汤色红鲜明亮，金圈突出，香气鲜爽，滋味浓强，富有刺激性，叶底红匀鲜亮，加牛奶仍有较强茶味，呈棕色、粉红或姜黄鲜亮，以浓、强、鲜为其特色。', '是', 14, '茶'),
(8, '木刻', '木刻，指在木上刻图画的艺术或方法，主要是指在木料断面上刻制图画以供印刷机拓印', '是', 11, '木制品'),
(9, '文玩', '文玩，指的是文房四宝及其衍生出来的各种文房器玩。这些文具造型各异，雕琢精细，可用可赏，使之成为书房里、书案上陈设的工艺美术品。', '否', 3, '首饰'),
(10, '牦牛肉干', '牦牛是生长在地球之巅的高寒、无任何污染环境、独特的半野生半原始珍稀动物，与北极熊、南极企鹅共称为“世界三大高寒动物”。牦牛终身无劳役，逐水草而居的半野生放牧方式、原始自然的生长过程，一生中摄入大量的虫草、贝母等名贵中草药，使牦牛肉质细嫩，味道鲜美', '否', 0, '食品'),
(11, '玫瑰花酱', '玫瑰花酱有滋补健肝脾功能。对胃病、腰腿痛、风湿关节炎、支气管炎等10多种慢性疾病有辅助疗效。', '否', 1, '食品'),
(12, '玫瑰花酿', '长期饮用该酒具有美容、养颜、和血散瘀、清心健脑、滋阴补肾、健脾益胃之功效，是滋养保健之佳品。', '是', 1, '饮品'),
(13, '银饰品', '一般是千足银，云南有很多银饰，少数民族的流行的，比如苗族的衣饰，首饰，那里还保持着手工制银的传统习惯', '是', 7, '金银首饰'),
(14, '天麻', '其根茎入药用以治疗头晕目眩、肢体麻木、小儿惊风等症，是名贵中药，与琼珍灵芝合用治疗头痛失眠。', '否', 10, '药材'),
(15, '三七粉', '三七的功用，原来可用“止血、散瘀、定痛”六个字来概括，所以，历来都是以三七作为伤科金疮药，很少作为补品食用。三七最适宜与灵芝搭配服用，具有治疗糖尿病和心血管疾病的作用。', '否', 13, '药材');

-- --------------------------------------------------------

--
-- 表的结构 `hotel`
--

CREATE TABLE `hotel` (
  `id` int(11) NOT NULL,
  `hotelName` varchar(30) NOT NULL,
  `spot_id` int(11) NOT NULL,
  `hotelAddress` varchar(30) NOT NULL,
  `ave_price` float NOT NULL,
  `spot_distance` float NOT NULL,
  `shop_Id` int(11) NOT NULL,
  `shop_distance` float NOT NULL,
  `enter_distance` float NOT NULL,
  `hotelLevel` float NOT NULL,
  `hotelDescribe` text NOT NULL,
  `hotelScore` float NOT NULL,
  `entertainment_id` int(11) NOT NULL,
  `entertainment_distance` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `hotel`
--

INSERT INTO `hotel` (`id`, `hotelName`, `spot_id`, `hotelAddress`, `ave_price`, `spot_distance`, `shop_Id`, `shop_distance`, `enter_distance`, `hotelLevel`, `hotelDescribe`, `hotelScore`, `entertainment_id`, `entertainment_distance`) VALUES
(1, '丽江翡翠湾客栈', 3, '丽江市古城区光义街官院巷8号丽江古城博物馆', 250, 120, 1, 500, 0, 3, '三星酒店，可以遥望雪山，纳西风情', 4.7, 0, 0),
(2, '长兴客栈', 3, '丽江市古城区光义街忠义巷113', 150, 78, 1, 350, 0, 0, '舒适型，隔音好，无早餐', 4.8, 0, 0),
(3, '天龙客栈', 3, '丽江市古城区光义街官院巷56-59号', 250, 40, 1, 350, 0, 0, '高档型，可以遥望雪山，纳西风情', 4.9, 0, 0),
(4, '丽江一品天下文苑酒店', 3, '丽江市古城区大研镇光义街金星巷22号', 300, 159, 1, 274, 0, 4, '四星级就酒店，舒适环境，是丽江典型的纳西族院子。', 4.9, 0, 0),
(5, '丽江翡翠湾客栈', 3, '丽江市古城区光义街官院巷8号丽江古城博物馆', 250, 120, 15, 261, 0, 3, '三星酒店，可以遥望雪山，纳西风情', 4.7, 0, 0),
(6, '长兴客栈', 3, '丽江市古城区光义街忠义巷113', 150, 78, 15, 219, 0, 0, '舒适型，隔音好，无早餐', 4.8, 0, 0),
(7, '天龙客栈', 3, '丽江市古城区光义街官院巷56-59号', 250, 40, 15, 188, 0, 0, '高档型，可以遥望雪山，纳西风情', 4.9, 0, 0),
(8, '丽江一品天下文苑酒店', 3, '丽江市古城区大研镇光义街金星巷22号', 300, 159, 15, 282, 0, 4, '四星级就酒店，舒适环境，是丽江典型的纳西族院子。', 4.9, 0, 0),
(9, '丽江翡翠湾客栈', 3, '丽江市古城区光义街官院巷8号丽江古城博物馆', 250, 120, 16, 741, 0, 3, '三星酒店，可以遥望雪山，纳西风情', 4.7, 0, 0),
(10, '长兴客栈', 3, '丽江市古城区光义街忠义巷113', 150, 78, 16, 766, 0, 0, '舒适型，隔音好，无早餐', 4.8, 0, 0),
(11, '天龙客栈', 3, '丽江市古城区光义街官院巷56-59号', 250, 40, 16, 735, 0, 0, '高档型，可以遥望雪山，纳西风情', 4.9, 0, 0),
(12, '丽江一品天下文苑酒店', 3, '丽江市古城区大研镇光义街金星巷22号', 300, 159, 16, 613, 0, 4, '四星级就酒店，舒适环境，是丽江典型的纳西族院子。', 4.9, 0, 0),
(13, '四方驿栈', 1, '丽江市古城区光义街现文巷25号', 250, 76, 0, 0, 0, 0, '藏式风格，离四方街很近，地理位置十分优越，经济型，复式loft', 4.8, 0, 0),
(14, '天琴湾客栈（光义街店）', 1, '丽江市古城区光义街现文巷22号', 148, 80, 0, 0, 0, 0, '纳西风情，经济型，古色古香，安静', 4.5, 0, 0),
(15, '水涟漪精品客栈', 1, '丽江市古城区七一街崇仁巷75', 125, 290, 0, 0, 0, 0, '四星级酒店，吃住两不误，有家的感觉。', 4.8, 0, 0),
(16, '丽江雪悦精品酒店', 5, '丽江古城区玉河走廊澜花街C区2号院', 285, 181, 17, 196, 0, 0, '服务周到位置方便，交通便利，老板态度好', 4.9, 1, 214),
(18, '丽江格兰大酒店', 5, '丽江市古城区民主路300号新义街', 282, 41, 18, 119, 0, 3, '位置优越，性价比高，交通便利，设备有些陈旧', 3.7, 2, 98),
(19, '丽江雪悦精品酒店', 5, '丽江古城区玉河走廊澜花街C区2号院', 285, 181, 17, 196, 0, 0, '服务周到位置方便，交通便利，老板态度好', 4.9, 2, 144),
(20, '丽江雪悦精品酒店', 5, '丽江古城区玉河走廊澜花街C区2号院', 285, 181, 18, 243, 0, 0, '服务周到位置方便，交通便利，老板态度好', 4.9, 1, 214),
(21, '丽江雪悦精品酒店', 5, '丽江古城区玉河走廊澜花街C区2号院', 285, 181, 18, 243, 0, 0, '服务周到位置方便，交通便利，老板态度好', 4.9, 2, 144),
(22, '丽江格兰大酒店', 5, '丽江市古城区民主路300号新义街', 282, 41, 17, 75, 0, 3, '位置优越，性价比高，交通便利，设备有些陈旧', 3.7, 2, 98),
(23, '丽江格兰大酒店', 5, '丽江市古城区民主路300号新义街', 282, 41, 17, 75, 0, 3, '位置优越，性价比高，交通便利，设备有些陈旧', 3.7, 1, 132),
(24, '丽江格兰大酒店', 5, '丽江市古城区民主路300号新义街', 282, 41, 18, 119, 0, 3, '位置优越，性价比高，交通便利，设备有些陈旧', 3.7, 1, 132),
(25, '龙潭客栈', 7, '丽江市古城区古路坞下段52号', 65, 57, 0, 0, 0, 0, '老板幽默，服务周到，性价比高，卫生干净', 4.8, 0, 0),
(26, '龙潭湾假日酒店', 7, '丽江市古城区黑龙潭公园正门对面，教育路与民主路路口', 120, 99, 0, 0, 0, 0, '服务周到，干净卫生', 3.8, 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `restaurant`
--

CREATE TABLE `restaurant` (
  `id` int(11) NOT NULL,
  `spot_id` int(11) NOT NULL,
  `restaurantName` varchar(30) DEFAULT NULL,
  `restaurantAddress` varchar(30) DEFAULT NULL,
  `restaurantLevel` varchar(30) DEFAULT NULL,
  `restaurantType` varchar(30) DEFAULT NULL,
  `restaurantDescribe` text,
  `restaurantTime` varchar(30) DEFAULT NULL,
  `restaurantScore` float DEFAULT NULL,
  `agr_price` float NOT NULL,
  `spot_distance` int(11) NOT NULL,
  `hotel_id` int(11) NOT NULL,
  `hotel_distance` float NOT NULL,
  `shop_id` int(11) NOT NULL,
  `shop_distance` float NOT NULL,
  `entertainment_id` int(11) NOT NULL,
  `entertainment_distance` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `restaurant`
--

INSERT INTO `restaurant` (`id`, `spot_id`, `restaurantName`, `restaurantAddress`, `restaurantLevel`, `restaurantType`, `restaurantDescribe`, `restaurantTime`, `restaurantScore`, `agr_price`, `spot_distance`, `hotel_id`, `hotel_distance`, `shop_id`, `shop_distance`, `entertainment_id`, `entertainment_distance`) VALUES
(6, 1, '老蔡黑山羊火锅', '云南省丽江县古城区五一街文林巷24号', NULL, '火锅', '以黑山羊火锅为主', '9:00-21:00', 4.9, 52, 1000, 13, 1100, 0, 0, 0, 0),
(27, 1, '阿妈意纳西饮食院（小石桥店）', '丽江市古城区五一街', NULL, '中餐', '特色纳西风味和马帮菜系，推荐菜品：马帮烤鱼，鸡豆凉粉，竹筒饭', '9:00-23:00', 4.4, 57, 176, 13, 256, 0, 0, 0, 0),
(28, 3, '石锅渔（古城庙会店）', '丽江市古城区长水路72号四方庙会', NULL, '火锅', '超高人气火锅，推荐菜：野生菌，三文鱼，野生菌套餐，', '10:00-22:30', 4.6, 97, 286, 2, 309, 15, 565, 0, 0),
(29, 3, '云雪丽餐厅（阿顺店）', '丽江市古城区七一街兴文巷95号', NULL, '云贵菜', '经营云南贵州特色菜品，推荐菜：秘制雪山鱼，纳西烤肉，野生菌鸡汤', '9:00-22:00', 4.8, 91, 341, 1, 628, 15, 434, 0, 0),
(31, 3, '食全酒美', '丽江市古城区光义街忠义巷38', NULL, '中餐', '性价比较高，各式菜品均有销售，推荐菜：纳西烤鱼，爆炒腊排骨，腊排骨火锅', '10:00-22:00', 4.5, 40, 129, 0, 0, 0, 0, 0, 0),
(32, 3, '石锅渔（古城庙会店）', '丽江市古城区长水路72号四方庙会', NULL, '火锅', '超高人气火锅，推荐菜：野生菌，三文鱼，野生菌套餐，', '10:00-22:30', 4.6, 97, 286, 1, 450, 1, 792, 0, 0),
(33, 3, '石锅渔（古城庙会店）', '丽江市古城区长水路72号四方庙会', NULL, '火锅', '超高人气火锅，推荐菜：野生菌，三文鱼，野生菌套餐，', '10:00-22:30', 4.6, 97, 286, 3, 348, 16, 1100, 0, 0),
(34, 3, '石锅渔（古城庙会店）', '丽江市古城区长水路72号四方庙会', NULL, '火锅', '超高人气火锅，推荐菜：野生菌，三文鱼，野生菌套餐，', '10:00-22:30', 4.6, 97, 286, 4, 583, 0, 0, 0, 0),
(35, 3, '小锅巴纳西美食', '丽江市古城区饮玉巷中段19号', NULL, '中餐', '主营纳西特色美食，推荐菜品：招牌纳西烤肉，梅子酒，什锦山野菜', '9:00-22:00', 4.7, 67, 395, 1, 662, 1, 387, 0, 0),
(36, 3, '小锅巴纳西美食', '丽江市古城区饮玉巷中段19号', NULL, '中餐', '主营纳西特色美食，推荐菜品：招牌纳西烤肉，梅子酒，什锦山野菜', '9:00-22:00', 4.7, 67, 395, 2, 590, 15, 366, 0, 0),
(37, 3, '小锅巴纳西美食', '丽江市古城区饮玉巷中段19号', NULL, '中餐', '主营纳西特色美食，推荐菜品：招牌纳西烤肉，梅子酒，什锦山野菜', '9:00-22:00', 4.7, 67, 395, 3, 559, 16, 429, 0, 0),
(38, 3, '小锅巴纳西美食', '丽江市古城区饮玉巷中段19号', NULL, '中餐', '主营纳西特色美食，推荐菜品：招牌纳西烤肉，梅子酒，什锦山野菜', '9:00-22:00', 4.7, 67, 395, 4, 688, 0, 0, 0, 0),
(39, 3, '云雪丽餐厅（阿顺店）', '丽江市古城区七一街兴文巷95号', NULL, '云贵菜', '经营云南贵州特色菜品，推荐菜：秘制雪山鱼，纳西烤肉，野生菌鸡汤', '9:00-22:00', 4.8, 91, 341, 2, 405, 1, 627, 0, 0),
(40, 3, '云雪丽餐厅（阿顺店）', '丽江市古城区七一街兴文巷95号', NULL, '云贵菜', '经营云南贵州特色菜品，推荐菜：秘制雪山鱼，纳西烤肉，野生菌鸡汤', '9:00-22:00', 4.8, 91, 341, 3, 374, 16, 978, 0, 0),
(41, 3, '云雪丽餐厅（阿顺店）', '丽江市古城区七一街兴文巷95号', NULL, '云贵菜', '经营云南贵州特色菜品，推荐菜：秘制雪山鱼，纳西烤肉，野生菌鸡汤', '9:00-22:00', 4.8, 91, 341, 4, 707, 0, 0, 0, 0),
(42, 3, '食全酒美', '丽江市古城区光义街忠义巷38', NULL, '中餐', '性价比较高，各式菜品均有销售，推荐菜：纳西烤鱼，爆炒腊排骨，腊排骨火锅', '10:00-22:00', 4.5, 40, 129, 1, 286, 1, 588, 0, 0),
(43, 3, '食全酒美', '丽江市古城区光义街忠义巷38', NULL, '中餐', '性价比较高，各式菜品均有销售，推荐菜：纳西烤鱼，爆炒腊排骨，腊排骨火锅', '10:00-22:00', 4.5, 40, 129, 2, 161, 15, 391, 0, 0),
(44, 3, '食全酒美', '丽江市古城区光义街忠义巷38', NULL, '中餐', '性价比较高，各式菜品均有销售，推荐菜：纳西烤鱼，爆炒腊排骨，腊排骨火锅', '10:00-22:00', 4.5, 40, 129, 3, 184, 16, 939, 0, 0),
(45, 3, '食全酒美', '丽江市古城区光义街忠义巷38', NULL, '中餐', '性价比较高，各式菜品均有销售，推荐菜：纳西烤鱼，爆炒腊排骨，腊排骨火锅', '10:00-22:00', 4.5, 40, 129, 4, 351, 0, 0, 0, 0),
(46, 1, '88号小吃店', '云南省丽江市古城区兴仁上段88号', NULL, '小吃', '环境好，价格公道，口味好，人流量大，\r\n老字号，有Wi-Fi，有早点，可送餐；\r\n推荐火烤茄子凉拌、鲜肉炒饭、炒饵块', '8:00-21:00', 4.8, 0, 275, 13, 354, 0, 0, 0, 0),
(47, 1, '阿秋私房菜', '丽江市古城区五一节兴仁下段13-1号', NULL, '云贵菜', '演员王义钦曾光顾。当地特色美食，推荐菜品：啤酒雪山鱼、马帮豆腐，水性阳花', '10:00:22:00', 4.8, 64, 136, 13, 216, 0, 0, 0, 0),
(48, 1, '老蔡黑山羊火锅', '云南省丽江县古城区五一街文林巷24号', NULL, '火锅', '以黑山羊火锅为主', '9:00-21:00', 4.9, 52, 1000, 14, 26, 0, 0, 0, 0),
(49, 1, '老蔡黑山羊火锅', '云南省丽江县古城区五一街文林巷24号', NULL, '火锅', '以黑山羊火锅为主', '9:00-21:00', 4.9, 52, 1000, 15, 1000, 0, 0, 0, 0),
(50, 1, '阿妈意纳西饮食院（小石桥店）', '丽江市古城区五一街', NULL, '中餐', '特色纳西风味和马帮菜系，推荐菜品：马帮烤鱼，鸡豆凉粉，竹筒饭', '9:00-23:00', 4.4, 57, 176, 14, 323, 0, 0, 0, 0),
(51, 1, '阿妈意纳西饮食院（小石桥店）', '丽江市古城区五一街', NULL, '中餐', '特色纳西风味和马帮菜系，推荐菜品：马帮烤鱼，鸡豆凉粉，竹筒饭', '9:00-23:00', 4.4, 57, 176, 15, 402, 0, 0, 0, 0),
(52, 1, '88号小吃店', '云南省丽江市古城区兴仁上段88号', NULL, '小吃', '环境好，价格公道，口味好，人流量大，\r\n老字号，有Wi-Fi，有早点，可送餐；\r\n推荐火烤茄子凉拌、鲜肉炒饭、炒饵块', '8:00-21:00', 4.8, 0, 275, 14, 380, 0, 0, 0, 0),
(53, 1, '88号小吃店', '云南省丽江市古城区兴仁上段88号', NULL, '小吃', '环境好，价格公道，口味好，人流量大，\r\n老字号，有Wi-Fi，有早点，可送餐；\r\n推荐火烤茄子凉拌、鲜肉炒饭、炒饵块', '8:00-21:00', 4.8, 0, 275, 15, 248, 0, 0, 0, 0),
(54, 1, '阿秋私房菜', '丽江市古城区五一节兴仁下段13-1号', NULL, '云贵菜', '演员王义钦曾光顾。当地特色美食，推荐菜品：啤酒雪山鱼、马帮豆腐，水性阳花', '10:00:22:00', 4.8, 64, 136, 14, 283, 0, 0, 0, 0),
(55, 1, '阿秋私房菜', '丽江市古城区五一节兴仁下段13-1号', NULL, '云贵菜', '演员王义钦曾光顾。当地特色美食，推荐菜品：啤酒雪山鱼、马帮豆腐，水性阳花', '10:00:22:00', 4.8, 64, 136, 15, 342, 0, 0, 0, 0),
(56, 5, '大水车纳西餐厅', '丽江古城区玉河广场32号2层', NULL, '纳西菜', '性价比较高，服务较为热情，菜品不错，菜量一般', '7:00-24:00', 3.5, 28, 81, 16, 48, 18, 170, 2, 71),
(57, 5, '林之下私房菜', '丽江市古城区新华街双石段57号', NULL, '云贵菜', '菜式还可以，服务周到，环境一般', '10:00-23:00', 3.5, 71, 86, 16, 260, 18, 23, 2, 93),
(58, 5, '大水车纳西餐厅', '丽江古城区玉河广场32号2层', NULL, '纳西菜', '性价比较高，服务较为热情，菜品不错，菜量一般', '7:00-24:00', 3.5, 28, 81, 18, 90, 17, 125, 1, 151),
(59, 5, '林之下私房菜', '丽江市古城区新华街双石段57号', NULL, '云贵菜', '菜式还可以，服务周到，环境一般', '10:00-23:00', 3.5, 71, 86, 18, 124, 17, 67, 1, 15),
(60, 7, '金生丽水格调餐厅', '丽江市古城区教育路143号', NULL, '中餐', '菜品不错，环境舒服，有特色', '11:00-22:00', 3.5, 98, 568, 0, 0, 0, 0, 0, 0),
(61, 7, '文火砂锅羊', '丽江市古城区西安街道教育局路187好', NULL, '中餐', '服务周到，价格实惠环境好，量足，正宗', '11:00-22:00', 4.9, 36, 684, 0, 0, 0, 0, 0, 0),
(62, 7, '丽江有一锅黑山羊土鸡野生菌火锅', '丽江市古城区西安街道民族路1号', NULL, '云南菜', '服务非常周到，性价比超高，环境舒适，量足', '10:00-23:00', 5, 80, 73, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `scenic`
--

CREATE TABLE `scenic` (
  `id` int(11) NOT NULL,
  `scenicName` varchar(30) NOT NULL,
  `scenicLevel` varchar(30) DEFAULT NULL,
  `scenicAddress` varchar(30) DEFAULT NULL,
  `scenicPrice` varchar(30) DEFAULT NULL,
  `scenicOpenTime` varchar(30) DEFAULT NULL,
  `scenicDescribe` text,
  `scenicType_id` varchar(30) DEFAULT NULL,
  `scenicScore` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `scenic`
--

INSERT INTO `scenic` (`id`, `scenicName`, `scenicLevel`, `scenicAddress`, `scenicPrice`, `scenicOpenTime`, `scenicDescribe`, `scenicType_id`, `scenicScore`) VALUES
(1, '丽江古城', 'AAAAA级', '丽江市古城区', '80', '全天', '丽江为第二批被批准的中国历史文化名城之一，是中国以整座古城申报世界文化遗产获得成功的两座古城之一。丽江古城有着多彩的地方民族习俗和娱乐活动，纳西古乐、东巴仪式、占卜文化、古镇酒吧以及纳西族火把节等，别具一格。丽江古城体现了中国古代城市建设的成就，是中国民居中具有鲜明特色和风格的类型之一。', '2', 4.4),
(2, '玉龙雪山', 'AAAAA级', '丽江市玉龙纳西族自治县15公里处', '130', '09:30-16:00', '玉龙雪山在纳西语中被称为“欧鲁”，意为银色的山岩。其银装素裹，十三座雪峰连绵不绝，宛若一条“巨龙”腾越飞舞，故称为“玉龙”。它是中国最南的雪山，也是横断山脉的沙鲁里山南段的名山，北半球最南的大雪山。', '1', 4.5),
(3, '涑河古镇', 'AAAA级', '丽江市古城区束河路束河镇', '40', '全天', '束河古镇位于丽江古城西北部，是当年茶马古道上的重要驿站，是纳西先民在丽江坝子中最早的聚居地之一，是茶马古道上保存完好的重要集镇，也是纳西先民从农耕文明向商业文明过渡的活标本，是对外开放和马帮活动形成的集镇建设典范，世界文化遗产丽江古城的重要组成部分', '2', 4.3),
(4, '泸沽湖', 'AAAA级', '丽江市宁蒗彝族自治县永宁乡泸沽湖风景区', '0', '08:00-18:00', '是云南省最高的湖泊，风光旖旎，民风质朴，有“高原明珠”之称。云南一侧湖畔居住的摩梭人奉行“男不娶女不嫁”的走婚制度，所以泸沽湖又被称为“东方女儿国”。', '1', 4.6),
(5, '虎跳峡', 'AAAA级', '云南香格里拉市虎跳峡镇境内', '80', '09:00-18:00', '以“险”名天下，是中国最深的峡谷之一。', '1', 4.4),
(6, '玉水寨', 'AAAA级', '丽江市玉龙纳西族自治县白沙乡北部', '50', '08:00-17:00', '是古城水系的源头，是纳西文化的发源地之一。 寨内的神泉碧绿纯净、清潺透明，顺山势奔流而下，形成著名的“出龙瀑”戏龙瀑”、“送龙瀑”之“神龙三叠水”,是以纳西民族文化为核心，与自然景观完美融合的风景名胜', '1', 4.1),
(7, '观音峡', 'AAAA级', '丽江市古城区七河乡（丽江市东南17公里处）', '80', '07:00-18:00', '丽江坝子六大关隘之一的玉龙关的入口，是历史上茶马古道滇藏线从丽江入藏的唯一关口和军事要塞。', '2', 4.1),
(8, '老君山国家地质公园', 'AAAA级', '丽江市玉龙纳西族自治县黎明傈僳族自治乡', '80', '09:00-17:30', '以红色砂岩形成的丹霞地貌而名。', '1', 4.3);

-- --------------------------------------------------------

--
-- 表的结构 `scenicType`
--

CREATE TABLE `scenicType` (
  `id` int(11) NOT NULL,
  `sc_ty_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `scenicType`
--

INSERT INTO `scenicType` (`id`, `sc_ty_name`) VALUES
(1, '自然景观'),
(2, '人文景观'),
(3, '人造景观'),
(4, '闲暇度假区'),
(5, '节事庆典');

-- --------------------------------------------------------

--
-- 表的结构 `shop`
--

CREATE TABLE `shop` (
  `id` int(11) NOT NULL,
  `shopName` varchar(30) DEFAULT NULL,
  `shopType` varchar(30) DEFAULT NULL,
  `shopTime` varchar(30) DEFAULT NULL,
  `spot_id` int(11) NOT NULL,
  `shopDescribe` text,
  `shopScore` float DEFAULT NULL,
  `entertainment_id` int(11) NOT NULL,
  `entertainment_distance` float NOT NULL,
  `spot_distance` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `shop`
--

INSERT INTO `shop` (`id`, `shopName`, `shopType`, `shopTime`, `spot_id`, `shopDescribe`, `shopScore`, `entertainment_id`, `entertainment_distance`, `spot_distance`) VALUES
(1, '东巴韵堂专卖店', '服装', '9:00-22:00', 3, '售卖特色民族服饰，质量上乘，价格适中，做工精细', 4, 0, 0, 312),
(2, '丽江国际购物广场', '百货', '9:00-21:00', 1, '主营黄金珠宝、餐饮、服饰收拾、特色产品、成活家居、娱乐，地址云南省丽江市福慧路618号', 4, 0, 0, 0),
(3, '民族木制品工艺', '工艺品店', '9:00-21:00', 7, '七河乡观音峡-木家别院附近，主营纳西木质工艺品', 4.4, 0, 0, 0),
(4, '麻梵布衣店', '衣服', '9:00-22:00', 3, '玻璃房子很漂亮，服装大部分都是亚麻的，价格适中，质地和款式都很棒，老板以前是做媒体主编的，很有欣赏眼光，款式都很有设计感，值得推荐。', 4, 0, 0, 0),
(5, '东巴纸坊', '工艺品', '9:00-22:00', 3, '这是一种特别材料的纸，感觉有点像再生可是它原来是用来抄写经文，千年不烂', 4, 0, 0, 0),
(6, '膳花坊', '食品', '9:00-22:00', 3, '束河古镇康普巷39号，经营乔麦的玫瑰花饼，生态玫瑰花，玫瑰花酿', 4.5, 0, 0, 0),
(7, '百岁坊银器', '首饰', '9:00-22:00', 3, '村头小道与中和路交汇处，丽江的雪花银非常著名，百岁坊又是丽江的老字号', 4.7, 0, 0, 0),
(8, '民族色彩', '服装', '9:00-22:00', 3, '民族色彩是家服饰零售店，位于丽江市束河古镇烟柳路203号，主要经营民族服饰的小店，衣服陈列不是很密集', 4.4, 0, 0, 0),
(9, '梵木文玩', '饰品', '9:00-22:00', 3, '各种木质玩物，首饰用品', 4.7, 0, 0, 0),
(10, '东巴拉高原药材', '药材', '9:00-22:00', 2, '高原药材，药材品质都还不错', 4.1, 0, 0, 0),
(11, '瓦岗寨滇茶马古道民俗旧物集市', '市场', '9:00—18:00', 2, '五一街兴仁下段，主营原创物件，实木较多', 3.8, 0, 0, 0),
(12, '墨研书屋', '书籍', '9:00-20:00', 2, '环境不错，书的种类齐全', 4, 0, 0, 0),
(13, '滇西本草', '药材', '9:00-21:00', 2, '主要经营药材', 4, 0, 0, 0),
(14, '国茶龙润', '茶叶', '9:00-22:00', 2, '南口路与玉兴东路交叉口南100米，主营滇红，普洱等云南特色茶叶', 4, 0, 0, 0),
(15, '阿厦丽驼铃店', '手工艺品', '9:00-22:00', 3, '手工艺品店，店内有数百种驼铃以及其他手工商品，手绘T恤，纳西土布，中药香包', 4.4, 0, 0, 340),
(16, '云南小粒咖啡', '茶饮', '9:00-18:00', 3, '主营各色咖啡，以云南特色小粒咖啡为主打商品', 4, 0, 0, 418),
(17, '纳西十元店（新华街）', '礼品店', '9:00-23:00', 5, '售卖纳西族传统小饰品，价格实惠', 4, 0, 0, 18),
(18, '云南小粒咖啡（总店）', '咖啡', '10:30-23:30', 5, '专卖愿你小粒咖啡，咖啡非常棒', 4, 0, 0, 62),
(19, '凤凰饼屋', '糕点店', '8:00-22:00', 7, '口感不错，价格一般', 3.8, 0, 0, 48),
(20, '云南辣木丽江供货中心', '超市', '8:00-23:00', 7, NULL, NULL, 0, 0, 10);

-- --------------------------------------------------------

--
-- 表的结构 `spot`
--

CREATE TABLE `spot` (
  `id` int(11) NOT NULL,
  `scenic_id` int(11) NOT NULL,
  `spotName` varchar(30) NOT NULL,
  `spotDescribe` text,
  `spotTime` varchar(30) DEFAULT NULL,
  `spotSuggestTime` varchar(30) DEFAULT NULL,
  `spotScore` float DEFAULT NULL,
  `spot_price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `spot`
--

INSERT INTO `spot` (`id`, `scenic_id`, `spotName`, `spotDescribe`, `spotTime`, `spotSuggestTime`, `spotScore`, `spot_price`) VALUES
(1, 1, '四方街', '休闲娱乐。丽江四方街街面宽广，有四条主街，向四周辐射，每条街道又分出许多小街小巷，街巷相连，四通八达。每条巷道，均由五彩花石铺成，是丽江最热闹喧哗的地方，这里常年旅客云集。特别是在逢年过节，这里歌舞升平，热门非凡。中外各地的游客云集在此，在当地人的带领下手拉手地围成一圈，随着音乐节奏起舞，形成一片欢乐的海洋。吃喝玩乐的好去处。同时四方街有具有很多的文物古迹，是丽江古城的心脏，经济文化交流的中心。', '全天', '2', 4.5, 0),
(2, 1, '五凤楼', '名胜古迹。丽江五凤楼原址位于丽江古城区西北11公里的芝山福国寺内，旧名解脱林。1979年迁至玉泉公园黑龙潭内。五凤楼为三重檐多角攒尖顶木结构建筑，从四面看都象5只展翅欲飞的凤凰，故称为五凤楼。始建于明代万历二十九年(公元1601年)，楼高20米。五凤楼融合了汉、藏、纳西等民族的建筑艺术风格，是中国古代建筑中的稀世珍宝和典型范例。', '全天', NULL, 4.3, 0),
(3, 1, '木府', '历史名胜古迹。丽江木氏土司衙门的俗称，位于丽江古城狮子山下，是丽江古城文化之“大观园”。 整个建筑群坐西向东，是一座辉煌的建筑艺术之苑。纳西族传统文化。木府是丽江历史的见证，古城文化的象征。位于丽江古城西南隅，整个建筑群坐西朝东，左有青龙（玉龙雪山），右有白虎（虎山），背靠玄武（狮子山），东南方向有龟山，蛇山对峙而把守关隘，木府怀抱于古城，既有枕狮山而升阳刚之气，又有环玉水而具太极之脉。丽江旅游有一句话：“不到木府，等于不到丽江”。特别是那留于世的明、清木府古建筑，建筑之宏伟、宫殿之辉煌、雕刻之精致、构件之玲珑、绘画之璀璨，真可谓美轮美奂，无与伦比。', '全天', '3', 4.6, 60),
(5, 1, '大水车', '人文景观。丽江古城大水车是丽江古城的标志性建筑，水车有两座。在丽江，两座水车有“子母水车”和“情人水车”之说。是丽江旅游游客一定要去拍照留念的地方。往右是写有江泽民主席题词的照壁，古城里有三房一照壁的民居，那民居就像这个样子。在古城入口的右边是水龙柱。龙是管水的，古城里的土木建筑最怕火，但水能克火，所以立了这个水龙柱，以表达古城人民免除火灾的愿望。千百年来，古城人民像爱护自己的眼睛一样爱护古城。', '全天', '0.5', 4.5, 0),
(6, 1, '大石桥', '历史古迹。沿着东大街的水流一直往南，就会到达四方街，再转向五一街就可以看到古城最古老的大石桥。大石桥为古城众桥之首，建于明代，有五六百年的历史。是古城东西两个部分的交通要道。是四方街集市的延伸，桥长10.6米，高2.2米，宽3.84米。桥面用传统的五花石铺砌，坡度平缓，便于两岸往来', '全天', NULL, 4.6, 0),
(7, 1, '黑龙潭', '从古城四方街沿经纬纵横的玉河溯流而上，约行一公里有一处晶莹清澈的泉潭，即为中外闻名的黑龙潭。黑龙潭又名玉泉公园，俗称龙王庙，位于丽江古城北端象山之麓，黑龙潭内随势错落的古建筑有龙神祠、得月楼、锁翠桥、玉皇阁、福国寺解脱林门楼、五凤楼、光碧楼、清代听鹂榭、一文亭、文明坊等建筑。黑龙潭内堤岸柳如丝，湖旁建亭宇，林中藏古刹，奇花遍地芳。公园东岸有龙神祠，园内植花卉 500余种，艳丽多姿，有“玉泉四季花如锦”之誉。', '8:00-19:00', '3', 4.6, 60),
(8, 1, '狮子山', '自然景观。狮子山公园坐落于安庆城西，是市区唯一的一座依山而建的森林公园。由狮子山、脚踏岭、大营盘、螺丝山、周山、乌龟山、锅铁山等十二座小山丘和岗地组成。园内建有重翠亭、天池等景点，还辟有“三八林”、“劳模林”南面滨江，建有仿古门楼，犄角檐。依山门有台阶三十级，分置两侧的一对石狮，栩栩如生。登上“江天一览亭”，可饱览水乡泽国的绚丽丽风光，可将丽江古城的全景尽收眼底。 ', '全天', '3', 4.5, 0),
(9, 2, '甘海子', '自然景观。甘海子是玉龙雪山东面的一个开阔草甸，甘海子全长4公里左右，宽1.5公里，海拔约3100米，来到甘海子给人一种开阔空旷的感觉，在高耸入云的玉龙雪山东坡面前，有这样一个大草甸，为游人提供了一个观赏玉龙雪山的好场地，在这里横看玉龙雪山、扇子陡等山峰历历在目。从甘海子草甸到4500米的雪线，可以看到各种各样的花草树木，兰花、野生牡丹、雪莲，品种繁多；高大乔木有云南松、雪松、冷杉、刺栗、麻栗等等。甘海子大草甸是一个天然大牧场，每年春暖花开，百草萌发，住在甘海子附近山涧的藏、彝、纳西族牧民们都要带上毡篷，骑着高头大马，驱赶着牦牛、羊群、黄牛，到草甸放牧。', '9：30-16：00', NULL, 4.8, 0),
(10, 2, '云杉坪', '又名“殉情第三国”，海拔3240米，是纳西族人心中的圣洁之地。又名“殉情第三国”，海拔3240米，是纳西族人心中的圣洁之地', '9：30-16：00', NULL, 4.8, 0),
(11, 2, '冰塔林', '玉龙雪山分布着欧亚大陆离赤道最近的现代海洋性温冰川和雪海，冰川类型齐全，发育有19条现代冰川，总面积达11.61平方公里，其中“白水一号”现代冰川是目前最具游览条件的冰川。“白水一号”现代冰川长达2.7公里，位于在玉龙雪山主峰扇子陡的正下方。从山脚望去，如同一条瀑布悬挂天际，令人震撼不已。冰舌部分的冰塔林，像一把把刀戟直刺苍穹，在阳光的照射下，不白而绿、绿雪万仞，仿佛一块块巨大的翡翠碧玉镶嵌在怪石嶙峋之间，此景即为已故的原台湾故宫博物院副院长李霖灿先生笔下的“绿雪奇峰”。靠近冰川，只听见有“哗啦啦”的流水声，那是冰川融化后形成的冰河。前方的扇子陡发出阵阵巨响，那是雪崩时发出的响声，就像在“滚雪球”。千万年来，扇子陡始终如一、源源不断的为冰川补给着新雪。变幻莫测的雪山，不时漫天雪花，令人举步维艰；不时风起云涌，令人略感寒意；不时光芒万丈，恍若隔世，不禁感慨万千。', '9：30-16：00', NULL, 4.5, 0),
(12, 2, '玉柱擎天', '玉柱擎天风景区位于玉龙雪山主峰南麓，也是人称玉龙山下第一村的地方--巫鲁肯（白沙玉湖村），距离古城十余里。玉柱擎天海拔2800米左右， 主要景点有巨石壁字、太子洞、观音岩、 雪松庵、千年古树、上下深潭瀑布、美籍奥地利学者洛克旧居（是他居住和生活27年之久的地方）及高山蚂蝗坝、仙迹崖、杜鹃山、木天王牧场、万花园、岩碰岩、三思水、风光旖、秀甲一方。', '9：30-16：00', NULL, 4.3, 0),
(13, 2, '巨古壁字', '在登高约30米的世石峭壁上，竖刻着“玉柱擎天”四字，这是清朝雍正年间（1724年）丽江第一任流官知府杨题写；其左下横刻“玉壁金川”四字，则是丽江郡丞聂瑞于1725年所题，八字奇书苍劲有力，虽经百年风雨剥蚀，仍依稀可认，徒岩和古字交相辉映，天工和人文溶为一体。古人高超的石刻书艺及智慧，今人惊叹不已。这两幅石刻不但写尽了丽江雪山这壮丽，也成为与“改土归流”这一重要历史事件有直接联系的文物古迹。登高俯视，玉龙雪山俨然一擎天之玉柱，撑起头上一片蓝天，转身了望，一马平川、广阔坦荡的田园风光尽收眼底。', '9：30-16：00', NULL, 4.6, 0),
(14, 2, '白水河（蓝月谷）', '从甘海子到云杉坪之间，有一条幽深的山谷，谷内林木森森，清溪长流，谷底这个清泉长流的河，就叫白水河。因河床、台地都由白色大理石、石炭石碎块组成，呈一片灰白色；清泉从石上流过，亦呈白色，因色得名“白水河”。白水河之水来源于四五千米高处的冰川雪原融水，清冽凉爽，从无污染，是天然的冰镇饮料。白水河的河水还会因为天气变化而变颜色，晴天的时候白水河的水是乳白色的，每当阴雨天时白水河的水又变成天蓝色，而且山谷呈月牙形，故又称蓝月谷。蓝月谷,其前身为早前人们所熟知的“白水河”蓝月谷又名白水河，在晴天时，水的颜色是乳白色的，阴雨天是天蓝色，而且山谷呈月牙形，远看就像一轮蓝色的月亮镶嵌在玉龙雪山脚下，所以名叫蓝月谷。 玉龙雪山冰雪融化成河水从雪山东麓的一条山谷而过，因月亮在蓝天的映衬下倒影在蓝色的湖水中，又因英国作家瞻姆斯希尔顿笔下的《消失的地平线》中的蓝月亮山谷近似于此。故名“蓝月谷”。　蓝月谷中的河水在流淌过程中因受山体阻挡，形成了四个较大的水面，人称“玉液”湖、“镜潭”湖、“蓝月”湖和“听涛”湖。湖岸四 周植被繁茂，远处雪峰背衬。湖水是透明的蓝，近乎凝固的湛蓝中，些许的绿意点缀其间。于湖心四顾，白云连横，浮于山际，倒影在湖面，如梦幻影，疑是仙境。', '9：30-16：00', NULL, 4.7, 0),
(15, 2, '动植物园', '玉龙雪山是动植物的宝库，主要经济动物有60多种，属国家重点保护的珍衡动物有滇金丝猴、云豹、金猫、雪豹、藏马鸡、绿尾梢虹雉、穿山甲、小熊猫、大小灵猫、白腹锦鸡，血雉白鹇等。有藻类植物31科196种，地衣植物17科20多种，苔藓植物有苔类45种、藓类130种，蕨类植物220种，种子植物145科3200余种；是云南省著名的园艺类观赏植物的主要产地，有报春花60多种、杜鹃花50多种、兰花70多种。是中国植物标本的集中产地，有天然高山动植物园和现代冰川博物馆之称。', '9：30-16：00', NULL, 4.5, 0),
(16, 3, '青龙桥', '青龙桥建于明朝万历年间，距今已有400多年历史，它的西面就是聚宝山，青龙桥的中轴线正对着聚宝山，这是木氏土司的设计，也是木氏土司鼎盛时期的标志性建筑。长25米、宽4.5米、高4米，全部由石块垒砌，列为丽江古石桥之最，可见束河在丽江历史上的经济文化格局中所占的重要地位。青龙桥的桥面经过数百年风雨的洗刷使它变得斑驳苍老，却不失它的英雄气势和庄严厚重感，站在这里，你也许会听见马蹄的声音在回响。', '全天', NULL, 4.6, 0),
(17, 3, '四方街', '束河古城的四方街长宽不过30几米，有四条道路通向四面八方，水流环绕、日中为市，为丽江坝子最古老的集市之一。古时候，束河的四方街上设有夜市，人们像今天的都市人一样自在漫步在四方街上，随心所欲走走停停，看看稀奇，吃点儿自己想吃的东西参与一下喜欢的游戏，逛夜市的人手里举着火把，穿行在青龙河畔，如夏夜流萤，成了一道风景，叫做“夜市萤火”，列入束河八景之一。', '全天', NULL, 4.6, 0),
(18, 3, '龙潭', '龙泉山下古树参天，一道好水积成九鼎龙潭，潭水清澈晶莹，水草曼舞，游鱼逍遥，玉龙雪山倒映其中，清姿傲岸，意境无穷，成为束河八景之又一景：雪山倒映。潭边有一截断碑，年代已不可考，用石头敲击，会发出清脆的声音，是束河八景之中的“断碑敲音”。不过，为了保护这一景观，大家还是不敲的好。龙潭上端有一座寺庙，名叫“三圣宫”，西殿供奉观音，北楼供奉龙王，南楼供奉皮匠祖师孙膑。东楼楼基直接入水，三面都有回廊，供游人凭栏远眺。在这里，远近风光尽收眼底，田畴润绿，炊烟袅袅，鸡犬争鸣，生机勃勃，一派田园牧歌，无限诗情画意，令人流连忘返。尤其是月明之夜，登楼赏月最有风味，文人墨客每每对月吟诗作画，传为佳话。此景在束河八景中叫“龙门望月”。', '全天', NULL, 4.5, 0),
(19, 3, '西山红叶', '束河西山上有很多漆树。每到秋天，树叶鲜红，秋光灿烂，令人赏心悦目。在束河八景中，这叫“西山红叶”，最为动人。', '全天', NULL, 4.8, 0),
(21, 4, '格姆女神索道	', '格姆山的成因，当地民间流传着一个动人的神话故事。传说泸沽湖一带早先没有山，而格姆女仙经常和众男山神夜里从北方飞来湖里洗澡，谈情说爱，雄鸡报晓时又飞回北方。某夜，众男山神等候了很久，格姆女仙姗姗来迟，他们正要嬉戏，可是雄鸡报晓，东方发白，他们飞不回去了，于是格姆便流落在泸沽湖畔，变成了现在的格姆女山，众男仙则簇拥在她的周围，分别变成了哈瓦男山、则支男山、阿沙男山等。		', '8：00-18：00', NULL, 4.54, 0),
(22, 4, '泸沽湖摩梭民俗博物馆', '摩梭民俗博物馆有摩梭女儿国风格的花楼、祖母屋、经堂、文物馆、图片资料、世界非物质文化遗产为主题的大小型展馆，拥有深受千千万万游客喜爱的“走婚爬花楼”民俗表演。馆内参观场所温馨、舒适，活动场地宽敞、透亮，展馆设施卫生、安全，是一所集绿化、体验、民俗化、教育化于一体的博物馆。		', '8：00-18：00', NULL, 4.3, 0),
(23, 4, '洛洼码头', '码头的所属地洛洼半岛是一个非常重要的分界线，半岛的这边是著名的草海，半岛的那边是亮海（所谓亮海就是没有看到草的水面都叫亮海）。洛洼码头也是看夕阳西下，日出东方的最佳地点了。		', '8：00-18：00	', NULL, 4.6, 0),
(24, 4, '小草海', '小草海位于后龙山下，摩梭阿洼部落村寨间的湿地，约1000亩，是平坝区水鸟的栖宿地。			', '8：00-18：00', NULL, 4.7, 0),
(25, 4, '花楼恋歌', '“花楼恋歌”演出通过纪实性、原真性的表现手法，让观众对摩梭人的独特神秘文化遗存、奇风异俗有一个直观真切的了解。演员均为泸沽湖畔的原住摩梭人，采自摩梭人日常生活中使用的服装、农具、乐器作为演出道具。演出剧场为一个放大了的祖母屋，让观众置身一个真实的祖母屋，表演区和观众席融合。中心表演区周围围绕剧场做出两组花楼，充分体现摩梭建筑的特点以及摩梭人的浪漫色彩。 剧场朝向泸沽湖一侧的墙面可完全开启，剧场与真实的泸沽湖衔接在一起，通过摩梭人原生态的音乐舞蹈，表现摩梭人出生、成长、婚姻、劳动、祭祀等生老病死的整个过程。			', '8：00-18：00', NULL, 4.5, 0),
(26, 4, '博凹岛', '博凹岛又叫王妃岛，是末代左所土司修建的一座豪华别宫，专门为安置末代王妃肖淑明所用。王妃肖淑明远嫁到泸沽湖的时候只有16岁，这位年轻的王妃在这孤岛上消磨了自己的青春年华。	', '8：00-18：00', NULL, 4.6, 0),
(27, 4, '泸源崖', '泸源崖是泸沽湖地下水的出水口所在地。此处石崖如削，景观独特。坐在崖下的石礁上，遐想天工造物的神奇与和谐，定会涌起许多关于天地人和的感怀。泸沽湖总容积在19.53亿立方米，超过云南滇池。湖水补给除雨量和四川泉水外，主要在于泸沽湖自身的地下水。	8：00-18：00		4.6', '8：00-18：00', NULL, 4.6, 0),
(28, 4, '里务比寺', '里务比寺属黄教喇嘛寺，始建于公元1634年。20世纪60年代初因众所周知的原因，作为封建迷信的产物被毁坏。1989年在罗桑益世活佛的倡导下，政府出资，群众投工投劳，由县旅游局具体负责实施重建，于1999年12月竣工。寺里供奉的佛像、法器都是当地信教群众自愿集资供奉的。在寺里供有佛祖释迦牟尼、观音、千手千眼佛、藏传佛教格鲁派宗师宗喀巴及其二弟子佛像、护法神等诸佛塑像，不家在落水村藏传佛教格鲁派高僧、阿克格西的倡议下塑供的罗桑益世活佛塑像。正门上面有罗桑活佛亲笔书写藏文、著名书法家尚文先生译书汉文的题匾“玉池琼楼”。	8：00-18：00		4.5', '8：00-18：00', NULL, 4.5, 0),
(29, 4, '喇嘛寺', '喇嘛寺坐落在泸沽湖草海旁，是藏传佛教最古老的“本波教派”（黑教）的宗教场所。泸沽湖摩梭人民除了信奉自己的原始宗教达巴教，还信仰喇嘛教。从喇嘛教传入泸沽湖地区以后，当地便相继兴修了黑黄两教派的寺庙。而喇嘛寺是泸沽湖唯一的黑教寺庙。寺庙按律举行的法事活动，成为摩梭人盛大的节日。 每年寺庙里都会举行盛大喇嘛大会活动，寺庙的喇嘛按照传统进行仪式和表演等活动。在每年冬月十五举行的晒佛、祭太阳神法事活动，是摩梭人较为盛大的节日。	8：00-18：00		4.8', '8：00-18：00', NULL, 4.8, 0),
(41, 4, '泸沽三岛', '泸沽三岛指的是尼喜岛、里务比岛和奈终普岛。早在200多年前的《永北府志》就将其列为胜景之一。 泸沽三岛即尼喜岛、里务比岛和奈终普岛。尼喜岛是三岛中最小的岛，似一块长方形的岩石，靠湖北岸，位于狮山下，上面布满青苔和灌木。里务比岛在半岛西南顶点之外，有一水峡把两岛分开。里务比岛上曾建喇嘛寺，如今寺庙已毁。奈终普岛又称永宁海堡，位于西北半湖中央，西岸近直线，东岸略呈半圆形，东西窄而南北宽，为狭长形。			4.3\r\n', '8：00-18：00', NULL, 4.3, 0),
(42, 4, '里格半岛', '里格半岛是位于泸沽湖的北侧一个小岛。 岛上除了有当地居民几百年的古老住所，另外还分布着几家景色很棒的临湖客栈，一个村民自用的小码头就在这2米多宽的接壤道路旁边。			4.6\r\n', '8：00-18：00', NULL, 4.6, 0),
(43, 4, '走婚桥', '走婚桥位于泸沽湖东南水域的草海区域，是泸沽湖上唯一的座桥。桥下由于长年泥沙淤积，导致水深变浅，长有茂密的芦苇，远远望去，像一片草的海洋，故当地人称其为“草海”。走婚桥是摩梭男女约会的地方， 泸沽湖畔的摩梭人奉行“男不娶，女不嫁”的“走婚”习俗。			', '8：00-18：00', NULL, 4.7, 0),
(48, 4, '泸沽湖观景台', '沽湖素有“高原明珠”之称。泸沽湖古称鲁窟海子，又名左所海，俗称亮海。泸沽湖四周崇山峻岭，一年有三个月以上的积雪期。森林资源丰富，山清水秀，空气清新，景色迷人，泸沽湖被当地摩梭人奉为“母亲湖”，也被人们誉为“蓬莱仙境”。观景台位于泸沽湖湖域东岸，植被密布，在此可一览泸沽湖全景。		\r\n', '8：00-18：00', NULL, 4.8, 0),
(49, 4, '尼塞村', '离里格村三公里左右的尼塞村因为情人树而闻名。应着女儿国的浪漫景，一面是山，一面是湛蓝湖水呈现眼前，十分动人。 很多游客都会选择徒步前往尼塞村，尼塞是个只有十几户人家的摩梭村子。	8：00-18：00		\r\n', '8：00-18：00', NULL, 4.8, 0),
(50, 4, '里格岛', '50	4		里格岛，位于东北部格姆女神山山麓，是泸沽湖七个珍珠宝石般岛屿中的一个。它是泸沽湖北缘海湾内一个美丽的海堤连岛，海岛三面环水，是个内港。			', '8：00-18：00', NULL, 4.5, 0),
(57, 5, '虎跳峡交通', '可以从丽江或香格里拉坐班车到虎跳峡镇（桥头）或大具，从虎跳峡镇（桥头）或大具两个方向都可进入虎跳峡。常走的路线是从丽江到虎跳峡镇（桥头）或大具，进入虎跳峡。如果从丽江出发，最好是到虎跳峡镇（桥头），进入虎跳峡。这样能省下80元的雪山门票和丽江古城保护费。如果是走穿越线的话，在穿越虎跳峡到大具后，在回丽江的路上可顺道去玉龙雪山的耗牛坪或云杉坪。那可是不用门票的！（我就是顺道去了牦牛坪，看到美丽的玉龙雪景。			\r\n', '9：00-18：00', NULL, 4.5, 0),
(58, 5, '头场滩', '是虎跳的入口，奇石满堆，千姿百态，人只能在乱石中走，恍若置身于怪禽异兽群中。从这里至“虎口”嵯岩峭壁绵延，这里两岸峭壁耸立、中间湍水淙流。江左有仙人桥，是仿效四川栈道凿石开成的行人道，路面崎岖而窄，上为突出的岩石遮盖，下临深渊，这是锻炼人的胆量的好去处。昔日，新嫁娘乘轿返夫家，惯例是途中不能下轿的；但到了这里，也得破例下轿步行，过了这险道再乘轿，故又名新人桥。桥下是深潭，旧名大岩，据说渔人也莫测其深度，肥美大鱼捉不完，石崖上有一个石洞，叫大王洞，又名“翼王宫”，曾为当地瑶民首领肉翼大王所居。明万历四年（1576年）罗旁战役中，他在这里抗击两广总督凌云翼所派遣的高州参将陈璘的征讨，英勇牺牲。瑶民在虎跳口建一座庙纪念他，现庙己废。虎跳境地还有金锁、石狮、谷仓、盐仓、石象、插剑台等名胜，江岸有仙人床、闸门等古迹。附近有“五马归槽”名山，吸引着无数游客，留下不少优美的诗篇。清代进士刘汝新游经写了一首七绝：杜鹃啼血染花丛，临水争妍石峡中。我欲寻春春寂寂，问花开处为谁红。	9：00-18：00		\r\n', '9：00-18：00', NULL, 4.8, 0),
(59, 6, '神龙三叠水', '若大的一股泉水顺着山坡而下，折成三叠。纳西人对神龙三叠水的崇拜，融入了生活中，他们把自己生活用水修成三叠神泉的样子；他们把“三叠水”摆上家宴，将餐具以高低盘子、碗、火锅分成三叠；把“三叠水”建成纳西人的庭院，纳西妇女还把“三叠水”穿在身上。			\r\n', '8：00-17：00', NULL, 4.6, 0),
(60, 6, '东巴村', '完全按纳西族的传统生活方式建成，从院落布局到建筑设施，到使用的工具，到生活的细节，都能感受到传统的民族文化氛围。这里是东巴文化的传承基地，有三位最负盛名的东巴大师，他们有着渊源的东巴文化学识。			', '8：00-17：00', NULL, 4.7, 0),
(61, 6, '东巴祭祀', '是东巴文化的重要组成部分，东巴文化各元素在祭祀活动中展现。东巴祭祀活动有三大仪典：祭天、祭署、祭风，玉水寨有丽江最古老、典范的祭祀场，1999年10月，首届中国丽江国际东巴文化艺术节期间，玉水寨是祭祀展示东巴文化的指定场所。			\r\n', '8：00-17：00', NULL, 4.5, 0),
(62, 6, '东巴壁画', '也是纳西族东巴文化的重要组成部分。玉水寨东巴壁画画廊，用东巴画的手法，形象、全景地展现纳西族的思想和智慧，诸如世界观、价值观、理想、信念、生产、生活等。			\r\n\r\n  \r\n\r\n\r\n\r\n', '8：00-17：00', NULL, 4.6, 0),
(63, 6, '东巴什罗庙	', '是纳西族传统的东巴祭祀中最大的活动———东巴会的重要场所。期间主要祭品有五谷、酥油、香油、家畜，但不能供野生动物。正阁前，是烧大香的香炉。			', '8：00-17：00', NULL, 4.6, 0),
(64, 6, '神泉', '顺着瀑布而上，来到神泉，只见大股水是从石缝里喷涌而出，清纯透亮、鲜活至极。当年，美国学者洛克在丽江留居了28年之久，白沙是他活动的重要地方。他对玉水寨流出的神泉水赞叹不已，每次外出考察，总是带上这里的泉水饮用。甚至在他离开丽江时也是如此。神泉其实是玉龙雪山顶上的雪融水，经过2400米的岩石渗透后泉涌而出，据化验它是极其难得的矿泉水。	8：00-17：00	', '8：00-17：00', NULL, 4.5, 0),
(65, 8, '老子文化苑', '老子文化苑是传承和弘扬老子思想的圣地，采用汉代建筑风格，主题思想是“大道行天下，和谐兴中华”。园区内的老子铜像于2014年被大世界吉尼斯收录为“大世界基尼斯之最―最高的老子铜像。”			', '9：00-17：30', NULL, 4.8, 0),
(66, 8, '顶道观群', '老君山金顶道教建筑群依托山顶建筑，老君山金顶道教建筑群依托山顶建筑，			', '9：00-17：30', NULL, 4.8, 0),
(67, 8, '太清观', '山顶太清观始建于北魏，历代重修，唐代尉迟敬德曾监工重修，明朝最为鼎盛，铁椽、铁瓦、金碧辉煌，千 百年来，一直是豫、陕、皖、鄂等地众香客朝拜的中原道教圣地。东南沿海香客也慕名前来，仅台湾高雄九龙八风进香团每批朝山者就多达百人。			', '9：00-17：30', NULL, 4.5, 0),
(71, 8, '舍身崖', '舍身崖是山顶游览过程中的第一个漂亮的自然风光景点。翘首而望，看那古松摩云，危崖欲倾，确实雄伟壮观。这就是老君山一处胜景“舍身崖”，每当日落之时，此处“余辉返照千山色，满峪参差人画中”，瑰丽的晚霞映着诡奇万状的险峰怪石，奇光异景，色彩缤纷，令人赞叹不已。			\r\n', '9：00-17：30', NULL, 4.5, 0),
(72, 8, '峰林烟岚', '在近千亩的范围内有大小石峰三千多座，形态各异。在这些奇石奇峰中，最著名的就是老君悟道峰，在天然石壁的夹缝中仍生长着百年苍松。		\r\n', '9：00-17：30', NULL, 4.6, 0),
(73, 8, '十里画屏	', '洛阳老君山峰林景观，如刀劈斧削，犬牙交错，披绿挂红，雄伟壮观，多姿多彩。由于老君山花岗岩体与其它花岗岩的不同。老君山的岩体是由“斑状黑云母二长花岗岩”组成。它是在距今1.4—0.8亿年间秦岭造山带抬升造山过程中形成的相对年轻的岩体，被国内地质学家命名为“老君山岩体”，峰林之间内一步一景，步移景换，景景如画，故称之为“十里画屏”。		\r\n', '9：00-17：30', NULL, 4.6, 0),
(74, 8, '紫荆花海', '每年3-4月间，老君山追梦谷中紫荆花竞相开放，美艳夺目，是绽放较早的“报春花”，当树枝上叶子还未长出时，枝条上花已盛开，又名“满条红”。老君山紫荆为北方巨紫荆，又名乌桑、兄弟树、友谊树。花色紫红，形如蝴蝶，艳丽可爱，是分布于老君山海拔800—2000米阴坡处的特有植物。老君山紫荆具有：花期早、 花期长、色泽艳、花朵密、树形大、花质优等六大特点。品种主要有丛生紫荆（灌木）、垂丝紫荆和总状花序紫荆（乔木）；适应能力很强，性喜光，耐寒耐旱，也耐水渍。紫荆的根、皮均可入药，有活血行气、消肿止痛、解诸毒物的功效。	\r\n', '9：00-17：30', NULL, 4.6, 0),
(75, 8, '幽谷蛙鸣', '老子李耳在此大彻大悟，一步登天跨上了伏牛之巅。悟道桥下河谷涧奇石好像都有生命，老子行至此地，坐下歇息，刚眨蒙眼与众天神相会，声声蛙鸣此起彼伏，搅得人心烦，老子用手一指，以静制动，点化为石。			', '9：00-17：30', NULL, 4.7, 0),
(76, 2, '玉龙雪山', '自然景观。玉龙雪山在纳西语中被称为“欧鲁”，意为银色的山岩。其银装素裹，十三座雪峰连绵不绝，宛若一条“巨龙”腾越飞舞，故称为“玉龙”。它是中国最南的雪山，也是横断山脉的沙鲁里山南段的名山，北半球最南的大雪山。', '9:30-16:00', '6', 4.9, 130),
(77, 1, '文昌宫', '古城内的一所道观', '13:00-22:00', '0.5', 4.2, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `entertainment`
--
ALTER TABLE `entertainment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `goods`
--
ALTER TABLE `goods`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `scenic`
--
ALTER TABLE `scenic`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `scenicType`
--
ALTER TABLE `scenicType`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shop`
--
ALTER TABLE `shop`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `spot`
--
ALTER TABLE `spot`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `entertainment`
--
ALTER TABLE `entertainment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- 使用表AUTO_INCREMENT `food`
--
ALTER TABLE `food`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- 使用表AUTO_INCREMENT `goods`
--
ALTER TABLE `goods`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- 使用表AUTO_INCREMENT `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- 使用表AUTO_INCREMENT `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;
--
-- 使用表AUTO_INCREMENT `scenic`
--
ALTER TABLE `scenic`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- 使用表AUTO_INCREMENT `scenicType`
--
ALTER TABLE `scenicType`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- 使用表AUTO_INCREMENT `shop`
--
ALTER TABLE `shop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- 使用表AUTO_INCREMENT `spot`
--
ALTER TABLE `spot`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;