/*
Navicat MySQL Data Transfer

Source Server         : localhost_33061
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : knowledege-quiz

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-04-19 19:41:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  `up_time` datetime DEFAULT NULL,
  `detail` text,
  `star` int(1) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `qid_ans_fk` (`question_id`),
  KEY `acc_ans_fk` (`account`),
  CONSTRAINT `acc_ans_fk` FOREIGN KEY (`account`) REFERENCES `user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `qid_ans_fk` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('33', '199', '201611105051', '2020-03-29 09:29:17', '<p>问题详情12</p>', '0');
INSERT INTO `answer` VALUES ('34', '199', '201611105051', '2020-03-29 09:29:19', '<p>123</p>', '0');
INSERT INTO `answer` VALUES ('35', '199', '201611105051', '2020-03-29 09:29:21', '<p>122312331</p>', '0');
INSERT INTO `answer` VALUES ('36', '199', '201611105051', '2020-03-29 09:29:23', '<p>12213121312</p>', '1');
INSERT INTO `answer` VALUES ('37', '400', '201611105051', '2020-03-29 09:34:09', '<p>问题详情回答问题</p>', '1');
INSERT INTO `answer` VALUES ('39', '198', '110002', '2020-03-29 09:37:29', '<p>问题详情123123</p>', '1');
INSERT INTO `answer` VALUES ('40', '400', '110002', '2020-04-06 07:01:47', '<p>问题详情123123123</p>', '0');
INSERT INTO `answer` VALUES ('41', '400', '110002', '2020-04-06 07:01:48', '<p>123123123</p>', '0');
INSERT INTO `answer` VALUES ('42', '400', '110002', '2020-04-06 07:01:49', '<p>123132123</p>', '0');
INSERT INTO `answer` VALUES ('43', '400', '110002', '2020-04-06 07:01:51', '<p>12313132</p>', '0');
INSERT INTO `answer` VALUES ('44', '400', '110002', '2020-04-06 07:03:00', '<p>1231321</p>', '0');
INSERT INTO `answer` VALUES ('45', '400', '110002', '2020-04-06 07:03:00', '<p>1231321</p>', '0');
INSERT INTO `answer` VALUES ('46', '400', '110002', '2020-04-06 07:03:01', '<p>1231321</p>', '0');
INSERT INTO `answer` VALUES ('47', '400', '110002', '2020-04-06 07:03:01', null, '0');
INSERT INTO `answer` VALUES ('48', '400', '110002', '2020-04-06 07:03:02', '<p>12313132</p>', '0');
INSERT INTO `answer` VALUES ('49', '400', '110002', '2020-04-06 07:03:04', '<p>123123145</p>', '0');
INSERT INTO `answer` VALUES ('50', '400', '110002', '2020-04-06 07:03:05', '<p>12313123</p>', '0');
INSERT INTO `answer` VALUES ('51', '400', '110002', '2020-04-06 07:03:06', null, '0');
INSERT INTO `answer` VALUES ('52', '400', '110002', '2020-04-06 07:03:06', null, '0');
INSERT INTO `answer` VALUES ('53', '400', '110002', '2020-04-06 07:03:06', null, '0');
INSERT INTO `answer` VALUES ('54', '400', '110002', '2020-04-06 07:03:06', null, '0');
INSERT INTO `answer` VALUES ('55', '400', '110002', '2020-04-06 07:03:08', '<p>12414123132</p>', '0');
INSERT INTO `answer` VALUES ('56', '400', '110002', '2020-04-06 07:03:10', '<p>412512341321251243</p>', '0');
INSERT INTO `answer` VALUES ('57', '400', '110002', '2020-04-06 07:03:13', '<p>5123122222222222123123</p>', '0');
INSERT INTO `answer` VALUES ('58', '202', '110002', '2020-04-06 07:06:31', '<p>问题详情123</p>', '1');
INSERT INTO `answer` VALUES ('59', '203', '110002', '2020-04-06 07:08:41', '<p>问题详情123</p>', '1');
INSERT INTO `answer` VALUES ('60', '204', '110002', '2020-04-06 07:09:00', '<p>问题详情123</p>', '0');
INSERT INTO `answer` VALUES ('61', '198', '110002', '2020-04-16 09:39:15', '<p>问题详情</p>', '0');
INSERT INTO `answer` VALUES ('62', '198', '110002', '2020-04-16 09:39:20', null, '0');
INSERT INTO `answer` VALUES ('63', '400', '110002', '2020-04-16 09:40:40', '<p>问题详情</p>', '0');
INSERT INTO `answer` VALUES ('64', '400', '110002', '2020-04-16 09:40:51', '<p>123</p>', '0');
INSERT INTO `answer` VALUES ('65', '308', '110002', '2020-04-16 11:50:30', null, '0');
INSERT INTO `answer` VALUES ('66', '308', '110002', '2020-04-16 11:55:57', null, '0');
INSERT INTO `answer` VALUES ('67', '307', '110002', '2020-04-16 11:56:45', null, '0');
INSERT INTO `answer` VALUES ('68', '308', '110002', '2020-04-16 11:57:50', null, '0');
INSERT INTO `answer` VALUES ('69', '308', '110002', '2020-04-16 11:58:31', null, '0');
INSERT INTO `answer` VALUES ('70', '308', '110002', '2020-04-16 12:02:00', null, '0');
INSERT INTO `answer` VALUES ('71', '308', '110002', '2020-04-16 12:02:52', '<p wx:nodeid=\"39\">1111</p>', '0');
INSERT INTO `answer` VALUES ('72', '308', '110002', '2020-04-16 12:03:09', null, '0');
INSERT INTO `answer` VALUES ('73', '308', '110002', '2020-04-16 12:06:10', null, '0');
INSERT INTO `answer` VALUES ('74', '308', '110002', '2020-04-16 12:06:20', '<p wx:nodeid=\"39\">1231</p>', '0');
INSERT INTO `answer` VALUES ('75', '308', '110002', '2020-04-16 12:06:49', '<p wx:nodeid=\"39\">1231</p>', '0');
INSERT INTO `answer` VALUES ('76', '308', '110002', '2020-04-16 12:06:50', '<p wx:nodeid=\"39\">1231</p>', '0');
INSERT INTO `answer` VALUES ('77', '308', '110002', '2020-04-16 12:06:51', '<p wx:nodeid=\"39\">1231</p>', '0');
INSERT INTO `answer` VALUES ('78', '308', '110002', '2020-04-16 12:06:52', '<p wx:nodeid=\"39\">1231</p>', '0');
INSERT INTO `answer` VALUES ('79', '308', '110002', '2020-04-16 12:06:53', '<p wx:nodeid=\"39\">1231</p>', '0');
INSERT INTO `answer` VALUES ('80', '400', '110002', '2020-04-16 12:07:47', null, '0');
INSERT INTO `answer` VALUES ('81', '400', '110002', '2020-04-16 12:07:57', '<p wx:nodeid=\"39\">12</p>', '0');
INSERT INTO `answer` VALUES ('82', '308', '110002', '2020-04-16 12:09:14', null, '0');
INSERT INTO `answer` VALUES ('83', '308', '110002', '2020-04-16 12:09:49', null, '0');
INSERT INTO `answer` VALUES ('84', '308', '110002', '2020-04-16 12:19:13', null, '0');
INSERT INTO `answer` VALUES ('85', '308', '110002', '2020-04-16 12:19:18', '<p wx:nodeid=\"39\">1231ac</p>', '0');
INSERT INTO `answer` VALUES ('86', '308', '110002', '2020-04-16 12:21:03', '<p wx:nodeid=\"39\">77u</p>', '0');
INSERT INTO `answer` VALUES ('87', '320', '110002', '2020-04-16 18:42:54', '<p>问题详情</p>', '0');
INSERT INTO `answer` VALUES ('88', '308', '201611105051', '2020-04-16 19:26:46', '<p wx:nodeid=\"39\">123123</p>', '0');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('35', '科目4', '12312300');
INSERT INTO `course` VALUES ('36', '科目3', '科目的信息');
INSERT INTO `course` VALUES ('37', '科目2', '科目的信息');
INSERT INTO `course` VALUES ('38', '科目1', '科目的信息');
INSERT INTO `course` VALUES ('40', '科目15', '156132.0');

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `detail` text,
  `account` varchar(100) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `up_time` datetime DEFAULT NULL,
  `next_time` datetime DEFAULT NULL,
  `down_time` datetime DEFAULT NULL,
  `status` int(1) unsigned zerofill DEFAULT NULL,
  `star` int(1) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `acc_fk` (`account`),
  KEY `cid_fk` (`course_id`),
  CONSTRAINT `acc_fk` FOREIGN KEY (`account`) REFERENCES `user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cid_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=401 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('198', '这是我的第三个问题', null, '110002', '35', '2020-03-29 09:20:23', null, null, '2', '2');
INSERT INTO `question` VALUES ('199', '这是我的第四个问题', null, '110002', '35', '2020-03-29 09:20:30', null, null, '2', '0');
INSERT INTO `question` VALUES ('201', '教师的问题', '<p>问题详情</p>', '110002', '35', '2020-03-29 09:33:48', null, null, '1', '0');
INSERT INTO `question` VALUES ('202', '123', '<p>问题详情</p>', '110002', '35', '2020-04-06 07:06:25', null, null, '2', '1');
INSERT INTO `question` VALUES ('203', '123', '<p>问题详情</p>', '110002', '35', '2020-04-06 07:08:35', null, null, '2', '1');
INSERT INTO `question` VALUES ('204', '23123', '<p>问题详情</p>', '110002', '35', '2020-04-06 07:08:54', null, null, '1', '1');
INSERT INTO `question` VALUES ('205', '110002 question 0', '<p>问题详情0</p>', '110002', '35', '2020-04-15 19:23:36', null, null, '1', '0');
INSERT INTO `question` VALUES ('206', '110002 question 1', '<p>问题详情1</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('207', '110002 question 2', '<p>问题详情2</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('208', '110002 question 3', '<p>问题详情3</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('209', '110002 question 4', '<p>问题详情4</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('210', '110002 question 5', '<p>问题详情5</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('211', '110002 question 6', '<p>问题详情6</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('212', '110002 question 7', '<p>问题详情7</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('213', '110002 question 8', '<p>问题详情8</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('214', '110002 question 9', '<p>问题详情9</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('215', '110002 question 10', '<p>问题详情10</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('216', '110002 question 11', '<p>问题详情11</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('217', '110002 question 12', '<p>问题详情12</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('218', '110002 question 13', '<p>问题详情13</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('219', '110002 question 14', '<p>问题详情14</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('220', '110002 question 15', '<p>问题详情15</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('221', '110002 question 16', '<p>问题详情16</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('222', '110002 question 17', '<p>问题详情17</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('223', '110002 question 18', '<p>问题详情18</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('224', '110002 question 19', '<p>问题详情19</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('225', '110002 question 20', '<p>问题详情20</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('226', '110002 question 21', '<p>问题详情21</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('227', '110002 question 22', '<p>问题详情22</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('228', '110002 question 23', '<p>问题详情23</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('229', '110002 question 24', '<p>问题详情24</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('230', '110002 question 25', '<p>问题详情25</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('231', '110002 question 26', '<p>问题详情26</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('232', '110002 question 27', '<p>问题详情27</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('233', '110002 question 28', '<p>问题详情28</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('234', '110002 question 29', '<p>问题详情29</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('235', '110002 question 30', '<p>问题详情30</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('236', '110002 question 31', '<p>问题详情31</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('237', '110002 question 32', '<p>问题详情32</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('238', '110002 question 33', '<p>问题详情33</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('239', '110002 question 34', '<p>问题详情34</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('240', '110002 question 35', '<p>问题详情35</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('241', '110002 question 36', '<p>问题详情36</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('242', '110002 question 37', '<p>问题详情37</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('243', '110002 question 38', '<p>问题详情38</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('244', '110002 question 39', '<p>问题详情39</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('245', '110002 question 40', '<p>问题详情40</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('246', '110002 question 41', '<p>问题详情41</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('247', '110002 question 42', '<p>问题详情42</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('248', '110002 question 43', '<p>问题详情43</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('249', '110002 question 44', '<p>问题详情44</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('250', '110002 question 45', '<p>问题详情45</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('251', '110002 question 46', '<p>问题详情46</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('252', '110002 question 47', '<p>问题详情47</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('253', '110002 question 48', '<p>问题详情48</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('254', '110002 question 49', '<p>问题详情49</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('255', '110002 question 50', '<p>问题详情50</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('256', '110002 question 51', '<p>问题详情51</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('257', '110002 question 52', '<p>问题详情52</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('258', '110002 question 53', '<p>问题详情53</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('259', '110002 question 54', '<p>问题详情54</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('260', '110002 question 55', '<p>问题详情55</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('261', '110002 question 56', '<p>问题详情56</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('262', '110002 question 57', '<p>问题详情57</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('263', '110002 question 58', '<p>问题详情58</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('264', '110002 question 59', '<p>问题详情59</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('265', '110002 question 60', '<p>问题详情60</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('266', '110002 question 61', '<p>问题详情61</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('267', '110002 question 62', '<p>问题详情62</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('268', '110002 question 63', '<p>问题详情63</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('269', '110002 question 64', '<p>问题详情64</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('270', '110002 question 65', '<p>问题详情65</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('271', '110002 question 66', '<p>问题详情66</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('272', '110002 question 67', '<p>问题详情67</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('273', '110002 question 68', '<p>问题详情68</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('274', '110002 question 69', '<p>问题详情69</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('275', '110002 question 70', '<p>问题详情70</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('276', '110002 question 71', '<p>问题详情71</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('277', '110002 question 72', '<p>问题详情72</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('278', '110002 question 73', '<p>问题详情73</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('279', '110002 question 74', '<p>问题详情74</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('280', '110002 question 75', '<p>问题详情75</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('281', '110002 question 76', '<p>问题详情76</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('282', '110002 question 77', '<p>问题详情77</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('283', '110002 question 78', '<p>问题详情78</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('284', '110002 question 79', '<p>问题详情79</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('285', '110002 question 80', '<p>问题详情80</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('286', '110002 question 81', '<p>问题详情81</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('287', '110002 question 82', '<p>问题详情82</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('288', '110002 question 83', '<p>问题详情83</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('289', '110002 question 84', '<p>问题详情84</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('290', '110002 question 85', '<p>问题详情85</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('291', '110002 question 86', '<p>问题详情86</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('292', '110002 question 87', '<p>问题详情87</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('293', '110002 question 88', '<p>问题详情88</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('294', '110002 question 89', '<p>问题详情89</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('295', '110002 question 90', '<p>问题详情90</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('296', '110002 question 91', '<p>问题详情91</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('297', '110002 question 92', '<p>问题详情92</p>', '110002', '35', '2020-04-15 19:23:37', null, null, '1', '0');
INSERT INTO `question` VALUES ('298', '110002 question 93', '<a>aaaa93</a><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p><p>问题详情93</p>', '110002', '35', '2020-04-15 19:23:38', null, null, '1', '0');
INSERT INTO `question` VALUES ('299', '110002 question 94', '<p>问题详情<img src=\"http://localhost:8080/images/741ecbafbc5e42218e78202aa36dd1eb.png\" width=\"400px\"></p>', '110002', '35', '2020-04-15 19:23:38', null, null, '1', '0');
INSERT INTO `question` VALUES ('300', '110002 question 95', '<p>问题详情95</p>', '110002', '35', '2020-04-15 19:23:38', null, null, '1', '0');
INSERT INTO `question` VALUES ('301', '110002 question 96', '<p>问题详情96</p>', '110002', '35', '2020-04-15 19:23:38', null, null, '1', '0');
INSERT INTO `question` VALUES ('302', '110002 question 97', '<p>问题详情97</p>', '110002', '35', '2020-04-15 19:23:38', null, null, '1', '0');
INSERT INTO `question` VALUES ('303', '110002 question 98', '<p>问题详情98</p>', '110002', '35', '2020-04-15 19:23:38', null, null, '1', '0');
INSERT INTO `question` VALUES ('304', '110002 question 99', '<p>问题详情99</p>', '110002', '35', '2020-04-15 19:23:38', null, null, '1', '0');
INSERT INTO `question` VALUES ('305', '这是我的一个带有图片的问题', '<p>问题详情<img src=\"http://localhost:8080/images/741ecbafbc5e42218e78202aa36dd1eb.png\" width=\"400px\"><img src=\"http://localhost:8080/images/741ecbafbc5e42218e78202aa36dd1eb.png\" width=\"400px\"></p>', '110002', '35', '2020-04-16 05:55:34', null, null, '1', '0');
INSERT INTO `question` VALUES ('306', '这个是测试问题图片', '<p>课本这里</p><p><img src=\"http://localhost:8080/images/ee336fa16b2a484fb74c6d6304e537cd.png\" width=\"400px\">123123</p><p>123123123</p><p>iii</p><p><img src=\"http://localhost:8080/images/50a3835f08ed4a2b97bd81e721659672.png\" width=\"400px\"></p>', '110002', '35', '2020-04-16 06:08:05', null, null, '1', '0');
INSERT INTO `question` VALUES ('307', '这是我的第三个图片测试', '<p>问题详情这是第一行</p><p><img src=\"http://localhost:8080/images/2f4f024df28349d8a09a7ac6cb883817.png\" width=\"400px\"></p><p>这是第二行</p><p><img src=\"http://localhost:8080/images/bb353fe3894b4f30bc0e628e90b426d9.png\" width=\"400px\"></p><p>这是第三行</p>', '110002', '35', '2020-04-16 06:10:43', null, null, '1', '1');
INSERT INTO `question` VALUES ('308', '这是第四次测试', '<p>问题详情<img src=\"http://localhost:8080/images/a065b1c3975c4ae9b437d9495405c282.png\" width=\"400px\"></p>', '110002', '35', '2020-04-16 06:17:42', null, null, '1', '20');
INSERT INTO `question` VALUES ('309', '123', '<p>123123</p>', '110002', '35', '2020-04-16 17:26:28', null, null, '1', '0');
INSERT INTO `question` VALUES ('310', '123', '<p>123123</p>', '110002', '35', '2020-04-16 17:27:28', null, null, '1', '0');
INSERT INTO `question` VALUES ('311', '123', '<p>123123123</p>', '110002', '35', '2020-04-16 17:27:42', null, null, '1', '0');
INSERT INTO `question` VALUES ('312', '1231', null, '110002', '35', '2020-04-16 17:30:18', null, null, '1', '0');
INSERT INTO `question` VALUES ('313', '1231', '<p>1123</p>', '110002', '35', '2020-04-16 17:30:21', null, null, '1', '0');
INSERT INTO `question` VALUES ('314', '123123', '<p>123</p>', '110002', '35', '2020-04-16 17:31:06', null, null, '1', '0');
INSERT INTO `question` VALUES ('315', '1123', null, '110002', '35', '2020-04-16 17:31:39', null, null, '1', '0');
INSERT INTO `question` VALUES ('316', '12', '<p>123</p>', '110002', '35', '2020-04-16 17:32:11', null, null, '1', '0');
INSERT INTO `question` VALUES ('317', '12', '<p>123321</p>', '110002', '35', '2020-04-16 17:32:21', null, null, '1', '0');
INSERT INTO `question` VALUES ('318', '123', '<p>31</p>', '110002', '37', '2020-04-16 17:34:15', null, null, '1', '0');
INSERT INTO `question` VALUES ('319', '123', '<p>123</p>', '110002', '35', '2020-04-16 17:34:42', null, null, '1', '0');
INSERT INTO `question` VALUES ('320', '123', '<p>123</p>', '110002', '35', '2020-04-16 17:35:46', null, null, '1', '1');
INSERT INTO `question` VALUES ('321', '312', '<p>321</p>', '110002', '35', '2020-04-16 17:36:02', null, null, '1', '0');
INSERT INTO `question` VALUES ('322', '123123啊啊', '<p wx:nodeid=\"49\">12312312</p>', '201611105051', '35', '2020-04-16 19:27:20', null, null, '0', '0');
INSERT INTO `question` VALUES ('323', '123123啊啊', '<p wx:nodeid=\"49\">12312312</p>', '201611105051', '35', '2020-04-16 19:29:17', null, null, '0', '0');
INSERT INTO `question` VALUES ('324', null, '<p><br></p>', '201611105051', '35', '2020-04-16 19:33:40', null, null, '0', '0');
INSERT INTO `question` VALUES ('325', '123', '<p><br></p>', '201611105051', '35', '2020-04-16 19:34:50', null, null, '0', '0');
INSERT INTO `question` VALUES ('326', '123', '<p><br></p>', '201611105051', '35', '2020-04-16 19:34:57', null, null, '0', '0');
INSERT INTO `question` VALUES ('327', '123', '<p wx:nodeid=\"49\">123</p>', '201611105051', '35', '2020-04-16 19:35:49', null, null, '0', '0');
INSERT INTO `question` VALUES ('328', '123', '<p wx:nodeid=\"49\">123</p>', '201611105051', '35', '2020-04-16 19:40:42', null, null, '0', '0');
INSERT INTO `question` VALUES ('329', '123', '<p wx:nodeid=\"49\">123</p>', '201611105051', '35', '2020-04-16 19:40:50', null, null, '0', '0');
INSERT INTO `question` VALUES ('330', '123', '<p wx:nodeid=\"49\">123</p>', '201611105051', '35', '2020-04-16 19:41:23', null, null, '0', '0');
INSERT INTO `question` VALUES ('331', '123', '<p wx:nodeid=\"49\">123</p>', '201611105051', '35', '2020-04-16 19:41:33', null, null, '0', '0');
INSERT INTO `question` VALUES ('332', '123', '<p wx:nodeid=\"49\">123</p>', '201611105051', '35', '2020-04-16 19:42:57', null, null, '0', '0');
INSERT INTO `question` VALUES ('333', '123', '<p wx:nodeid=\"49\">123</p>', '201611105051', '35', '2020-04-16 19:42:59', null, null, '0', '0');
INSERT INTO `question` VALUES ('334', '123', '<p wx:nodeid=\"49\">123</p>', '201611105051', '35', '2020-04-16 19:43:24', null, null, '0', '0');
INSERT INTO `question` VALUES ('335', '123', '<p wx:nodeid=\"49\">321</p>', '201611105051', '35', '2020-04-16 19:43:56', null, null, '0', '0');
INSERT INTO `question` VALUES ('336', '1123', '<p wx:nodeid=\"49\">31</p>', '201611105051', '35', '2020-04-16 19:44:22', null, null, '0', '0');
INSERT INTO `question` VALUES ('337', '123123', '<p wx:nodeid=\"49\">31231</p>', '201611105051', '35', '2020-04-16 19:45:53', null, null, '0', '0');
INSERT INTO `question` VALUES ('338', '312312', '<p wx:nodeid=\"49\">123123</p>', '201611105051', '35', '2020-04-16 19:46:22', null, null, '0', '0');
INSERT INTO `question` VALUES ('339', '312312', '<p wx:nodeid=\"49\">123123</p>', '201611105051', '35', '2020-04-16 19:46:29', null, null, '0', '0');
INSERT INTO `question` VALUES ('340', '321', '<p wx:nodeid=\"49\">123123</p>', '201611105051', '35', '2020-04-16 19:47:13', null, null, '0', '0');
INSERT INTO `question` VALUES ('341', '321', '<p wx:nodeid=\"49\">123123</p>', '110002', '35', '2020-04-16 19:47:54', null, null, '1', '0');
INSERT INTO `question` VALUES ('342', '123', '<p wx:nodeid=\"49\">123123</p>', '110002', '35', '2020-04-16 19:49:41', null, null, '1', '0');
INSERT INTO `question` VALUES ('343', '321', '<p wx:nodeid=\"49\">123123</p>', '110002', '35', '2020-04-16 19:50:54', null, null, '1', '0');
INSERT INTO `question` VALUES ('344', '321', '<p wx:nodeid=\"49\">123</p>', '110002', '35', '2020-04-16 19:51:23', null, null, '1', '0');
INSERT INTO `question` VALUES ('345', '123', '<p wx:nodeid=\"49\">123</p>', '110002', '35', '2020-04-16 19:54:03', null, null, '1', '0');
INSERT INTO `question` VALUES ('346', '123', '<p wx:nodeid=\"49\">12333</p>', '110002', '35', '2020-04-16 19:54:25', null, null, '1', '0');
INSERT INTO `question` VALUES ('347', '3123', '<p wx:nodeid=\"49\">123123</p>', '110002', '35', '2020-04-16 19:56:24', null, null, '1', '0');
INSERT INTO `question` VALUES ('348', '1231', '<p wx:nodeid=\"49\">123123</p>', '110002', '35', '2020-04-16 19:57:38', null, null, '1', '0');
INSERT INTO `question` VALUES ('349', '3123', '<p wx:nodeid=\"49\">123123</p>', '110002', '35', '2020-04-16 19:58:14', null, null, '1', '0');
INSERT INTO `question` VALUES ('350', '3123', '<p wx:nodeid=\"49\">123123</p>', '201611105051', '35', '2020-04-16 19:58:37', null, null, '0', '0');
INSERT INTO `question` VALUES ('400', '这是我的第一个问题112312311111111111111111111111111111111111111111111111111111111111111111111', '<p>问题详情</p>', '110002', '35', '2020-04-17 09:20:13', null, null, '2', '17');

-- ----------------------------
-- Table structure for `reword`
-- ----------------------------
DROP TABLE IF EXISTS `reword`;
CREATE TABLE `reword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detail` varchar(255) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `account` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ackfre` (`account`),
  KEY `cidfkre` (`course_id`),
  CONSTRAINT `ackfre` FOREIGN KEY (`account`) REFERENCES `user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cidfkre` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reword
-- ----------------------------
INSERT INTO `reword` VALUES ('8', '奖励1234', '35', '110002');
INSERT INTO `reword` VALUES ('9', '奖励12345', '35', '110002');
INSERT INTO `reword` VALUES ('10', '奖励123456', '36', '110002');
INSERT INTO `reword` VALUES ('11', '奖励1234567', '36', '110002');
INSERT INTO `reword` VALUES ('12', '奖励12345678', '36', '110002');
INSERT INTO `reword` VALUES ('13', '123123', '35', '110002');
INSERT INTO `reword` VALUES ('14', '123', '35', '110002');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) DEFAULT NULL,
  `pwd` varchar(100) DEFAULT NULL,
  `college` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `classes` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('123', '201611105051', '123', '计算机科学与技术', '同学A', '软测162');
INSERT INTO `student` VALUES ('124', '201611105052', '201611105052', '计算机科学与技术', '同学B', '软测167');
INSERT INTO `student` VALUES ('125', '201611105053', '201611105053', '计算机科学与技术', '同学C', '软测167');
INSERT INTO `student` VALUES ('126', '201611105054', '201611105054', '计算机科学与技术', '同学D', '软测167');
INSERT INTO `student` VALUES ('127', '201611105055', '201611105055', '计算机科学与技术', '同学E', '软测167');
INSERT INTO `student` VALUES ('128', '201611105056', '201611105056', '计算机科学与技术', '同学F', '软测167');
INSERT INTO `student` VALUES ('129', '201611105057', '201611105057', '计算机科学与技术', '同学F', '软测168');
INSERT INTO `student` VALUES ('130', '201611105058', '201611105058', '计算机科学与技术', '同学F', '软测169');

-- ----------------------------
-- Table structure for `student_course`
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `account` varchar(100) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`,`account`),
  KEY `s2s` (`account`),
  CONSTRAINT `c2c` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `s2s` FOREIGN KEY (`account`) REFERENCES `student` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('201611105051', '35');
INSERT INTO `student_course` VALUES ('201611105058', '35');
INSERT INTO `student_course` VALUES ('201611105051', '36');
INSERT INTO `student_course` VALUES ('201611105057', '36');
INSERT INTO `student_course` VALUES ('201611105051', '37');
INSERT INTO `student_course` VALUES ('201611105052', '37');
INSERT INTO `student_course` VALUES ('201611105053', '37');
INSERT INTO `student_course` VALUES ('201611105054', '37');
INSERT INTO `student_course` VALUES ('201611105055', '37');
INSERT INTO `student_course` VALUES ('201611105056', '37');
INSERT INTO `student_course` VALUES ('201611105051', '38');
INSERT INTO `student_course` VALUES ('201611105052', '38');
INSERT INTO `student_course` VALUES ('201611105053', '38');
INSERT INTO `student_course` VALUES ('201611105054', '38');
INSERT INTO `student_course` VALUES ('201611105055', '38');
INSERT INTO `student_course` VALUES ('201611105056', '38');
INSERT INTO `student_course` VALUES ('201611105057', '38');
INSERT INTO `student_course` VALUES ('201611105058', '38');
INSERT INTO `student_course` VALUES ('201611105051', '40');

-- ----------------------------
-- Table structure for `student_reword`
-- ----------------------------
DROP TABLE IF EXISTS `student_reword`;
CREATE TABLE `student_reword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reword_id` int(11) DEFAULT NULL,
  `answer_id` int(11) DEFAULT NULL,
  `tea_account` varchar(100) DEFAULT NULL,
  `stu_account` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `re_ke_id` (`reword_id`),
  KEY `re_ke_qid` (`answer_id`),
  CONSTRAINT `re_ke_id` FOREIGN KEY (`reword_id`) REFERENCES `reword` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `re_ke_qid` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_reword
-- ----------------------------
INSERT INTO `student_reword` VALUES ('1', '8', '36', '110002', '201611105051');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `research` varchar(50) DEFAULT NULL,
  `title` varchar(40) DEFAULT NULL,
  `aca_degree` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_index` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('118', '110002', '123', '崔老师', '软件工程教研室', '教授', '博士');
INSERT INTO `teacher` VALUES ('119', '110009', '110009', '郭老师', '软件工程教研室', '讲师', '硕士');
INSERT INTO `teacher` VALUES ('120', '110020', '110020', '李老师', '软件工程教研室', '副教授', '硕士');
INSERT INTO `teacher` VALUES ('121', '110031', '110031', '马老师', '软件工程教研室', '副教授', '硕士');
INSERT INTO `teacher` VALUES ('122', '110037', '110037', '宋老师', '软件工程教研室', '教授', '博士');

-- ----------------------------
-- Table structure for `teacher_course`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `course_id` int(11) NOT NULL,
  `account` varchar(100) NOT NULL,
  PRIMARY KEY (`account`,`course_id`),
  KEY `ctc` (`course_id`),
  CONSTRAINT `ctc` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t2t` FOREIGN KEY (`account`) REFERENCES `teacher` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_course
-- ----------------------------
INSERT INTO `teacher_course` VALUES ('35', '110002');
INSERT INTO `teacher_course` VALUES ('36', '110002');
INSERT INTO `teacher_course` VALUES ('37', '110002');
INSERT INTO `teacher_course` VALUES ('38', '110002');
INSERT INTO `teacher_course` VALUES ('40', '110002');
INSERT INTO `teacher_course` VALUES ('35', '110009');
INSERT INTO `teacher_course` VALUES ('36', '110009');
INSERT INTO `teacher_course` VALUES ('37', '110009');
INSERT INTO `teacher_course` VALUES ('38', '110009');
INSERT INTO `teacher_course` VALUES ('35', '110020');
INSERT INTO `teacher_course` VALUES ('36', '110020');
INSERT INTO `teacher_course` VALUES ('37', '110020');
INSERT INTO `teacher_course` VALUES ('38', '110020');
INSERT INTO `teacher_course` VALUES ('35', '110031');
INSERT INTO `teacher_course` VALUES ('36', '110031');
INSERT INTO `teacher_course` VALUES ('37', '110031');
INSERT INTO `teacher_course` VALUES ('38', '110031');
INSERT INTO `teacher_course` VALUES ('35', '110037');
INSERT INTO `teacher_course` VALUES ('36', '110037');
INSERT INTO `teacher_course` VALUES ('37', '110037');
INSERT INTO `teacher_course` VALUES ('38', '110037');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `user_type` int(1) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `pwd` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('19', 'admin', '2', '管理员', '123');
INSERT INTO `user` VALUES ('21', '110002', '1', '崔老师', '123');
INSERT INTO `user` VALUES ('22', '110009', '1', '郭老师', '110009');
INSERT INTO `user` VALUES ('23', '110020', '1', '李老师', '110020');
INSERT INTO `user` VALUES ('24', '110031', '1', '马老师', '110031');
INSERT INTO `user` VALUES ('25', '110037', '1', '宋老师', '110037');
INSERT INTO `user` VALUES ('26', '201611105051', '0', '同学A', '123');
INSERT INTO `user` VALUES ('27', '201611105052', '0', '同学B', '201611105052');
INSERT INTO `user` VALUES ('28', '201611105053', '0', '同学C', '201611105053');
INSERT INTO `user` VALUES ('29', '201611105054', '0', '同学D', '201611105054');
INSERT INTO `user` VALUES ('30', '201611105055', '0', '同学E', '201611105055');
INSERT INTO `user` VALUES ('31', '201611105056', '0', '同学F', '201611105056');
INSERT INTO `user` VALUES ('32', '201611105057', '0', '同学F', '201611105057');
INSERT INTO `user` VALUES ('33', '201611105058', '0', '同学F', '201611105058');
DROP TRIGGER IF EXISTS `Sto_user`;
DELIMITER ;;
CREATE TRIGGER `Sto_user` AFTER INSERT ON `student` FOR EACH ROW insert into user(account,user_type,name,pwd) values(new.account,0,new.name,new.pwd)
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Sup_user`;
DELIMITER ;;
CREATE TRIGGER `Sup_user` BEFORE UPDATE ON `student` FOR EACH ROW update user set name = new.name , pwd = new.pwd where user.account = new.account
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Sde_user`;
DELIMITER ;;
CREATE TRIGGER `Sde_user` BEFORE DELETE ON `student` FOR EACH ROW delete from user where account = old.account
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Tto_user`;
DELIMITER ;;
CREATE TRIGGER `Tto_user` AFTER INSERT ON `teacher` FOR EACH ROW insert into user(account,user_type,name,pwd) values(new.account,1,new.name,new.pwd)
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Tup_user`;
DELIMITER ;;
CREATE TRIGGER `Tup_user` BEFORE UPDATE ON `teacher` FOR EACH ROW update user set name = new.name ,pwd = new.pwd where user.account = new.account
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Tde_user`;
DELIMITER ;;
CREATE TRIGGER `Tde_user` BEFORE DELETE ON `teacher` FOR EACH ROW delete from user where account = old.account
;;
DELIMITER ;
