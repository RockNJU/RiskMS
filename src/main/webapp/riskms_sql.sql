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


drop table if EXISTS riskstatetrack;

create table riskstatetrack(
riskStateTrack_id int(255) not null,
riskItemId int(255) not null,
state int(10),
content varchar(255),
createTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
previousStateId int(255),
primary key(riskStateTrack_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



drop table if EXISTS ralist;

create table ralist(
ra_id int(255),
ra_name varchar(255),
createTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
primary key(ra_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if EXISTS raitems;
create table raitems(
raItems_id int(255),
ra_id int(255),
riskItem_id int(255),
primary key(raItems_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;