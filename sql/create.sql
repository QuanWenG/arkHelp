DROP TABLE IF EXISTS user_table;
CREATE TABLE user_table(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '逻辑id',
  username VARCHAR(255) NOT NULL COMMENT '账号',
  password VARCHAR(255) NOT NULL COMMENT '密码',
  status TINYINT NOT NULL DEFAULT 1 COMMENT '账号状态',
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  -- 索引
  UNIQUE INDEX idx_username(username) COMMENT '账号唯一索引',
  INDEX idx_status(status) COMMENT '状态索引',
  INDEX idx_create_time(create_time) COMMENT '时间索引',
  -- 联合索引
  INDEX idx_status_username(status,username) COMMENT '状态+账号联合索引'
) ENGINE = InnoDB;

DROP TABLE IF EXISTS user_info_table;
CREATE TABLE user_info_table(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '逻辑id',
  username VARCHAR(255) NOT NULL COMMENT '账号',
  name VARCHAR(255) NULL COMMENT '昵称',
  email VARCHAR(255) NULL COMMENT '邮箱',
  user_img VARCHAR(255) NULL COMMENT '用户头像',
  user_md VARCHAR(255) NULL COMMENT '用户简介',
  status TINYINT NOT NULL DEFAULT 1 COMMENT '账号状态',
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  -- 索引
  UNIQUE INDEX idx_username(username) COMMENT '账号唯一索引',
  INDEX idx_email(email) COMMENT '邮箱索引',
  INDEX idx_status(status) COMMENT '状态索引',
  INDEX idx_name(name) COMMENT '昵称索引',
  INDEX idx_create_time(create_time) COMMENT '创建时间索引',
  -- 联合索引
  INDEX idx_username_status(username,status) COMMENT '账号+状态联合索引'
) ENGINE = InnoDB;

DROP TABLE IF EXISTS operator_table;
CREATE TABLE operator_table(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '逻辑id',
  operator_name VARCHAR(255) NOT NULL COMMENT '干员名称',
  operator_star INT NOT NULL COMMENT '干员星级',
  operator_level INT NOT NULL COMMENT '干员等级',
  operator_elite INT NOT NULL COMMENT '干员精英等级',
  operator_class VARCHAR(255) NOT NULL COMMENT '干员职业',
  operator_subclass VARCHAR(255) NOT NULL COMMENT '干员子职业',
  operator_potential INT NOT NULL COMMENT '干员潜能',
  operator_trust_rate INT NOT NULL COMMENT '干员信赖度',
  first_skill VARCHAR(255) NULL COMMENT '一技能等级',
  second_skill VARCHAR(255) NULL COMMENT '二技能等级',
  third_skill VARCHAR(255) NULL COMMENT '三技能等级',
  x_mod INT NULL COMMENT 'x模组等级',
  y_mod INT NULL COMMENT 'y模组等级',
  delta_mod INT NULL COMMENT 'delta模组等级',
  alpha_mod INT NULL COMMENT 'alpha模组等级',
  beta_mod INT NULL COMMENT 'beta模组等级',
  gamma_mod INT NULL COMMENT 'gamma模组等级',
  other VARCHAR(1024) NULL COMMENT '其他备注信息',
  master_id BIGINT NOT NULL COMMENT '干员的主人id',
  master_link VARCHAR(1024) NOT NULL COMMENT '联系方式',
  help_table BIGINT NOT NULL COMMENT '从属助战表id',
  status TINYINT NOT NULL DEFAULT 1 COMMENT '干员状态',
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  -- 索引
  INDEX idx_master_id(master_id) COMMENT '主人id索引',
  INDEX idx_help_table(help_table) COMMENT '助战表id索引',
  INDEX idx_status(status) COMMENT '状态索引',
  INDEX idx_operator_star(operator_star) COMMENT '星级索引',
  INDEX idx_operator_class(operator_class) COMMENT '职业索引',
  INDEX idx_create_time(create_time) COMMENT '创建时间索引',
  INDEX idx_update_time(update_time) COMMENT '更新时间索引',
  INDEX idx_operator_name_full(operator_name) COMMENT '干员名全字段索引',
  INDEX idx_subclass(operator_subclass) COMMENT '子职业索引',
  INDEX idx_potential(operator_potential) COMMENT '潜能索引',
  -- 联合索引
  INDEX idx_master_help(master_id,help_table) COMMENT '主人+助战表联合索引',
  INDEX idx_status_master(status,master_id) COMMENT '状态+主人联合索引',
  INDEX idx_star_class(operator_star,operator_class) COMMENT '星级+职业联合索引',
  INDEX idx_master_status_star(master_id, status,operator_star) COMMENT '主人+状态+星级联合索引',
  INDEX idx_master_time(master_id,create_time DESC) COMMENT '主人+时间组合索引',
  -- 模糊查询优化
  INDEX idx_operator_name_prefix(operator_name(4)) COMMENT '干员名前缀索引',
  -- 覆盖索引
  INDEX idx_operator_basic(operator_name,operator_star,operator_class,status) COMMENT '基础信息覆盖索引'
) ENGINE = InnoDB;

DROP TABLE IF EXISTS help_table;
CREATE TABLE help_table(
  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '逻辑id',
  master_id BIGINT NOT NULL COMMENT '创建者id',
  table_from INT NULL COMMENT '渠道(0:官服 1:B服 2:国际服 3:台服)',
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  -- 索引
  INDEX idx_master_id(master_id) COMMENT '主人ID索引',
  INDEX idx_table_from(table_from) COMMENT '渠道索引',
  INDEX idx_create_time(create_time) COMMENT '创建时间索引',
  -- 组合索引
  INDEX idx_master_time(master_id,create_time DESC) COMMENT '主人+创建时间联合索引',
  INDEX idx_from_time(table_from,create_time DESC) COMMENT '渠道+创建时间联合索引',
  -- 覆盖索引
  INDEX idx_help_quick(id,master_id,table_from,create_time) COMMENT '查询覆盖索引'
) ENGINE = InnoDB;