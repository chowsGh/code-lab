CREATE TABLE userinfo
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	gender INT(11) NULL DEFAULT NULL ,
	createtime DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (id)
);


-- 修改时区
--show variables like '%time_zone%';
--set global time_zone = '+1:00';
--
--flush privileges;
--
--1
--然后在mysqld下边的配置中添加一行：
--
--default-time_zone = '+8:00'
--1
--然后重启mysql
--
--service mysql restart
--1

-- 时区问题，mybatis 已经处理了，将本地的时间转换成服务器的时间
-- com.mysql.cj.ClientPreparedQueryBindings.setTimestamp(int, java.sql.Timestamp, java.util.Calendar, int)
-- this.tsdf = TimeUtil.getSimpleDateFormat(this.tsdf, "''yyyy-MM-dd HH:mm:ss", this.session.getServerSession().getServerTimeZone());