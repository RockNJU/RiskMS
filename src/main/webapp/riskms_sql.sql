drop database if EXISTS riskms;
create database riskms;
use database riskms;

drop table if EXISTS user;

create table user(
user_id int(255) not null,
user_name varchar(255),
user_psd varchar(255),
role int(10),
primary key(user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `user` VALUES (1,'admin','admin',0);
INSERT INTO `user` VALUES (2,'manager','manager',1);
INSERT INTO `user` VALUES (3,'ghl','ghl',2);
INSERT INTO `user` VALUES (4,'cc','cc',2);
INSERT INTO `user` VALUES (5,'wzce','wzce',2);
INSERT INTO `user` VALUES (6,'nancy','nancy',2);
INSERT INTO `user` VALUES (7,'kate','kate',2);
INSERT INTO `user` VALUES (8,'why','why',2);


drop table if EXISTS riskitem;

create table riskitem(
riskItem_id int(255) not null,
content varchar(255),
probability int(10),
effects int(10),
threshold varchar(255),
submitter int(255),
sub_name varchar(255),
tracker_id varchar(255),
tracker_name varchar(255),
primary key(riskItem_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `riskitem` VALUES (1,'steak leak',1,2,'233',2,'manager','3;5','ghl;wzce');
INSERT INTO `riskitem` VALUES (2,'not fount condition',3,1,'200',2,'manager','4;6','cc;nancy');
INSERT INTO `riskitem` VALUES (3,'forget and ignore',2,2,'100',2,'manager','3;4;5;6;7;8','ghl;cc;wzce;nancy;kate;why');


drop table if EXISTS riskstatetrack;

create table riskstatetrack(
riskStateTrack_id int(255) not null,
riskItemId int(255) not null,
state int(10),
content varchar(255),
createTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
previousStateId int(255) default -1,
primary key(riskStateTrack_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `riskstatetrack` VALUES (1, 1, 0, 'risk1   -----balabala', '2016-11-10 10:57:04', -1);
INSERT INTO `riskstatetrack` VALUES (2, 1, 1, 'problem1-----balabala', '2016-11-18 10:57:49', 1);
INSERT INTO `riskstatetrack` VALUES (3, 1, 0, 'risk2   -----balabala', '2016-11-1 10:58:08', -1);
INSERT INTO `riskstatetrack` VALUES (4, 1, 0, 'risk3   -----balabala', '2016-11-14 10:58:26', -1);
INSERT INTO `riskstatetrack` VALUES (5, 1, 1, 'problem3-----balabala', '2016-11-18 10:58:50', 4);
INSERT INTO `riskstatetrack` VALUES (6, 2, 0, 'risk4   -----balabala', '2016-11-9 10:59:12', -1);
INSERT INTO `riskstatetrack` VALUES (7, 2, 1, 'problem4-----balabala', '2016-11-16 10:59:33', 6);
INSERT INTO `riskstatetrack` VALUES (8, 3, 0, 'risk5   -----balabala', '2016-11-8 11:00:06', -1);
INSERT INTO `riskstatetrack` VALUES (9, 3, 1, 'problem5-----balabala', '2016-11-17 11:00:22', 8);


drop table if EXISTS ralist;

create table ralist(
ra_id int(255),
ra_name varchar(255),
createTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
primary key(ra_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `ralist` VALUES(1,'RA1','2016-11-16 10:59:33');
INSERT INTO `ralist` VALUES(2,'RA2','2016-11-17 10:39:33');


drop table if EXISTS raitems;
create table raitems(
raItems_id int(255),
ra_id int(255),
riskItem_id int(255),
primary key(raItems_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `raitems` VALUES(1,1,1);
INSERT INTO `raitems` VALUES(2,1,2);
INSERT INTO `raitems` VALUES(3,2,2);
INSERT INTO `raitems` VALUES(4,2,3);