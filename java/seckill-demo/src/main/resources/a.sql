create table t_user(
                       `id`   bigint(20) not null comment '用户ID，手机号码',
                       `nickname`  varchar(255) not null,
                       `password`  varchar(32)   default '' comment 'md5(md5(pass明文+固定salt)+salt)',
                       `slat`    varchar(10) default null,
                       `head`  varchar(128) default null comment '头像',
                       `register_date` datetime default null comment '注册时间',
                       `last_login_date` datetime default null comment '最后一次登录时间',
                       `login_count` int(11) default '0' comment '登录次数',
                       primary key (`id`)
)