CREATE TABLE `t_user` (
                          `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                          `userName` varchar(100) NOT NULL COMMENT '名称',
                          `userPass` varchar(100) NOT NULL COMMENT '密码',
                          `userDate` datetime DEFAULT NULL,
                          PRIMARY KEY (`userId`),
                          FULLTEXT KEY `i_full_text` (`userName`) /*!50100 WITH PARSER `ngram` */
) ENGINE=InnoDB AUTO_INCREMENT=50001 DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT INTO `ssm`.`t_user` (`userId`, `userName`, `userPass`, `userDate`) VALUES ('21', '张三111111', '123213', '2021-11-03 19:00:01');
INSERT INTO `ssm`.`t_user` (`userId`, `userName`, `userPass`, `userDate`) VALUES ('22', '张三222222', '123213', '2021-11-03 19:00:01');
INSERT INTO `ssm`.`t_user` (`userId`, `userName`, `userPass`, `userDate`) VALUES ('23', '张三333333', '123213', '2021-11-03 19:00:01');
INSERT INTO `ssm`.`t_user` (`userId`, `userName`, `userPass`, `userDate`) VALUES ('24', '张三444444', '123213', '2021-11-03 19:00:01');
INSERT INTO `ssm`.`t_user` (`userId`, `userName`, `userPass`, `userDate`) VALUES ('25', '张三555555', '123213', '2021-11-03 19:00:01');
INSERT INTO `ssm`.`t_user` (`userId`, `userName`, `userPass`, `userDate`) VALUES ('26', '张三666666', '123213', '2021-11-03 19:00:01');
INSERT INTO `ssm`.`t_user` (`userId`, `userName`, `userPass`, `userDate`) VALUES ('27', '张三777777', '123213', '2021-11-03 19:00:01');
INSERT INTO `ssm`.`t_user` (`userId`, `userName`, `userPass`, `userDate`) VALUES ('28', '张三888888', '123213', '2021-11-03 19:00:01');
INSERT INTO `ssm`.`t_user` (`userId`, `userName`, `userPass`, `userDate`) VALUES ('29', '张三999999', '123213', '2021-11-03 19:00:01');
INSERT INTO `ssm`.`t_user` (`userId`, `userName`, `userPass`, `userDate`) VALUES ('30', '张三101010101010', '123213', '2021-11-03 19:00:01');
