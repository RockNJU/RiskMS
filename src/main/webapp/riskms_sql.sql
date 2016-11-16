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


drop table if EXISTS riskItem;

create table riskItem(
riskItem_id int(255) not null,
content varchar(255),
probability int(10),
effects int(10),
triggers varchar(255),
recogtime int(255),
problemtime int(255),
submitter int(255),
tracker varchar(255),
primary key(riskItem_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if EXISTS riskStateTrack;

create table riskStateTrack(
riskStateTrack_id int(255) not null,
riskItemId int(255) not null,
state int(10),
content varchar(255),
createTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
previousStateId int(255),
primary key(riskStateTrack_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;