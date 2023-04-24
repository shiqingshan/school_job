drop table if exists scj_user;
CREATE TABLE scj_user (
  id bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  user_name varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  user_pwd varchar(255) NOT NULL COMMENT '用户密码',
  nick_name varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  phone_number varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  email_addr varchar(100) DEFAULT NULL COMMENT '邮箱地址',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS scj_admin_menu;
CREATE TABLE scj_admin_menu (
  id bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  menu_name         varchar(50)     not null                   comment '菜单名称',
  parent_id         bigint     default 0                  comment '父菜单ID',
  order_num         int(4)          default 0                  comment '显示顺序',
  path              varchar(200)    default ''                 comment '路由地址',
  component         varchar(255)    default null               comment '组件路径',
  query             varchar(255)    default null               comment '路由参数',
  is_frame          int(1)          default 1                  comment '是否为外链（0是 1否）',
  is_cache          int(1)          default 0                  comment '是否缓存（0缓存 1不缓存）',
  menu_type         char(1)         default ''                 comment '菜单类型（M目录 C菜单 F按钮）',
  visible           char(1)         default 0                  comment '菜单状态（0显示 1隐藏）',
  status            char(1)         default 0                  comment '菜单状态（0正常 1停用）',
  perms             varchar(100)    default null               comment '权限标识',
  icon              varchar(100)    default '#'                comment '菜单图标',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='菜单';


drop table if exists scj_admin_role;
CREATE TABLE scj_admin_role (
  id bigint NOT NULL AUTO_INCREMENT COMMENT '角色主键',
  role_code varchar(100)  not NULL COMMENT '角色编码',
  role_name varchar(100) COLLATE utf8mb4_unicode_ci not NULL COMMENT '角色名称',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

drop table if exists scj_admin_permission;
CREATE TABLE scj_admin_permission (
  id bigint NOT NULL AUTO_INCREMENT COMMENT '权限主键',
  role_id bigint NOT NULL COMMENT '角色ID',
  menu_id bigint NOT NULL COMMENT '菜单项ID',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

drop table if exists scj_admin_role_account;
CREATE TABLE scj_admin_role_account (
  id bigint NOT NULL AUTO_INCREMENT COMMENT '权限主键',
  account_id bigint NOT NULL COMMENT '账号ID',
  role_id bigint NOT NULL COMMENT '角色ID',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

drop table if exists scj_account;
CREATE TABLE scj_account(
  id bigint NOT NULL AUTO_INCREMENT COMMENT '账号主键',
  user_id bigint NOT NULL COMMENT '用户ID',
  account_type TINYINT(1) NOT NULL DEFAULT 0  COMMENT '账户类型 0 普通用户 1企业用户 2管理员',
  profile_picture blob  COMMENT '头像',
  status TINYINT(1) NOT NULL COMMENT '账号状态 0 正常  1 冻结 2 待审核',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='账号表';


drop table if exists scj_company;
CREATE TABLE scj_company(
  id bigint NOT NULL AUTO_INCREMENT COMMENT '企业ID',
  name varchar(500) not null COMMENT '企业名称',
  address varchar(500)  COMMENT '企业地址',
  contact varchar(50)  COMMENT '企业联系人',
  contact_phone varchar(20)  COMMENT '企业联系人电话',
  business_license varchar(100) not null COMMENT '工商注册号',
  status TINYINT(1) NOT NULL COMMENT '公司状态 0 正常  1 冻结 2 待审核',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='企业表';

drop table if exists scj_company_user;
CREATE TABLE scj_company_user(
  id bigint NOT NULL AUTO_INCREMENT COMMENT '企业用户ID',
  co_id bigint NOT NULL COMMENT '企业ID',
  user_id bigint NOT NULL COMMENT '用户ID',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='企业用户表';


drop table if exists scj_job_position;
CREATE TABLE scj_job_position(
  id bigint NOT NULL AUTO_INCREMENT COMMENT '招聘岗位类别ID',
  parent_id bigint COMMENT '父级岗位类别ID',
  ancestors varchar(500) COMMENT '祖级岗位类别列表',
  position_name varchar(200) COMMENT '岗位类型名称',
  status    char(1)         default '0'                                   comment '岗位状态（0代表启用 1停用）',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='招聘岗位信息';

INSERT INTO scj_job_position
(id, parent_id, ancestors, position_name, status, deleted, creator, create_time, updater, update_time)
VALUES(1, 0, '0', '主岗位', '0', 0, 'sys', now(), 'sys', now());





drop table if exists scj_job_info;
CREATE TABLE scj_job_info(
  id bigint NOT NULL AUTO_INCREMENT COMMENT '招聘信息ID',
  co_id bigint NOT NULL COMMENT '发布企业ID',
  user_id bigint NOT NULL COMMENT '发布用户ID',
  position_id bigint NOT NULL COMMENT '发布岗位项名称',
  job_name varchar(200) NOT NULL COMMENT '岗位名称',
  job_status tinyint(2) NOT NULL COMMENT '职位状态',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='招聘信息表';


drop table if exists scj_job_detail;
CREATE TABLE scj_job_detail(
  id bigint NOT NULL AUTO_INCREMENT COMMENT '招聘信息详情ID',
  job_id bigint not null COMMENT '招聘信息ID',
  job_describe text not null COMMENT '职位描述',
  job_edu varchar(50) COMMENT '教育要求',
  job_qualification varchar(20) COMMENT '资格要求',
  job_addr varchar(200) COMMENT '工作地点',
  job_salary varchar(200)  COMMENT '薪資',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='招聘明细';


drop table if exists scj_user_resume;
CREATE TABLE scj_user_resume(
  id bigint NOT NULL AUTO_INCREMENT COMMENT '用户简历ID',
  user_id bigint NOT NULL COMMENT '用户ID',
  full_name varchar(200) not null COMMENT '姓名',
  contact_phone varchar(50) not null COMMENT '联系电话',
  contact_email varchar(100) not null COMMENT '电子邮箱地址',
  sex TINYINT(1) COMMENT '性别 0 男 1 女',
  birthday varchar(200) COMMENT '生日',
  job_status varchar(200) COMMENT '当前求职状态',
  advantage text COMMENT '个人优势',
  expect_salary varchar(100) COMMENT '期望薪资',
  expect_addr varchar(100) COMMENT '期望工作地点',
  job_type varchar(100) COMMENT '求职类型',
  expect_job varchar(100) COMMENT '期望工作',
  education  varchar(100) COMMENT '最高学历',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户简历表';



drop table if exists scj_user_resume_file;
CREATE TABLE scj_user_resume_file(
  id bigint NOT NULL AUTO_INCREMENT COMMENT '用户简历文件ID',
  user_id bigint NOT NULL COMMENT '用户ID',
  resume_file longblob COMMENT '简历文件',
  file_name varchar(100) COMMENT '文件名称',
  file_type varchar(10) COMMENT '文件类型',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户简历文件表';


drop table if exists scj_job_apply;
CREATE TABLE scj_job_apply(
  id bigint NOT NULL AUTO_INCREMENT COMMENT '应聘信息ID',
  user_id bigint not null COMMENT '应聘用户ID',
  job_id bigint not null COMMENT '招聘信息ID',
  apply_date datetime not null COMMENT '应聘日期',
  status tinyint(2) NOT NULL COMMENT '应聘状态（待处理、已查看、已邀约、已面试、已录用、未录用）',
  resume_id bigint NOT NULL COMMENT '简历ID',
  resume_file_id bigint NOT NULL COMMENT '简历文件ID',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='应聘信息表';

drop table if exists scj_interview_invitation;
CREATE TABLE scj_interview_invitation(
  id bigint NOT NULL AUTO_INCREMENT COMMENT '应聘信息ID',
  user_id bigint not null COMMENT '应聘用户ID',
  co_id bigint not null COMMENT '面试公司',
  apply_id bigint not null COMMENT '应聘信息Id',
  invitation_date datetime not null COMMENT '邀请日期',
  interview_date datetime COMMENT '面试日期',
  interview_location varchar(200) COMMENT '面试地点',
  status tinyint(2) NOT NULL COMMENT '邀请状态（待处理 、已接受、已拒绝）',
  creator varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updater varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  deleted bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='应聘邀请表';






DROP TABLE IF EXISTS common_login_log;
CREATE TABLE common_login_log (
  id bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  user_id bigint DEFAULT NULL COMMENT '登录人ID',
  ip varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '登录IP',
  client_id varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '登录人客户端ID',
  name varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '登录人姓名',
  principal varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '登录人账号',
  platform varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '平台',
  engine varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '引擎类型',
  engine_version varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '引擎版本',
  browser varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '浏览器名称',
  browser_version varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '浏览器版本',
  os varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '操作系统',
  location varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '登录地点',
  created_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (id) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='登录日志';





drop table if exists scj_sys_oper_log;
create table scj_sys_oper_log (
  oper_id           bigint     not null auto_increment    comment '日志主键',
  title             varchar(50)     default ''                 comment '模块标题',
  business_type     int(2)          default 0                  comment '业务类型（0其它 1新增 2修改 3删除）',
  method            varchar(100)    default ''                 comment '方法名称',
  request_method    varchar(10)     default ''                 comment '请求方式',
  operator_type     int(1)          default 0                  comment '操作类别（0其它 1后台用户 2手机端用户）',
  oper_name         varchar(50)     default ''                 comment '操作人员',
  oper_url          varchar(255)    default ''                 comment '请求URL',
  oper_ip           varchar(128)    default ''                 comment '主机地址',
  oper_location     varchar(255)    default ''                 comment '操作地点',
  oper_param        varchar(2000)   default ''                 comment '请求参数',
  json_result       varchar(2000)   default ''                 comment '返回参数',
  status            int(1)          default 0                  comment '操作状态（0正常 1异常）',
  error_msg         varchar(2000)   default ''                 comment '错误消息',
  oper_time         datetime                                   comment '操作时间',
  cost_time         bigint          default 0                  comment '消耗时间',
  primary key (oper_id),
  key idx_sys_oper_log_bt (business_type),
  key idx_sys_oper_log_s  (status),
  key idx_sys_oper_log_ot (oper_time)
) engine=innodb auto_increment=100 comment = '操作日志记录';

-- ----------------------------
-- 系统访问记录
-- ----------------------------
drop table if exists scj_sys_logininfor;
create table scj_sys_logininfor (
  info_id        bigint     not null auto_increment   comment '访问ID',
  user_name      varchar(50)    default ''                comment '用户账号',
  ipaddr         varchar(128)   default ''                comment '登录IP地址',
  login_location varchar(255)   default ''                comment '登录地点',
  browser        varchar(50)    default ''                comment '浏览器类型',
  os             varchar(50)    default ''                comment '操作系统',
  status         char(1)        default '0'               comment '登录状态（0成功 1失败）',
  msg            varchar(255)   default ''                comment '提示消息',
  login_time     datetime                                 comment '访问时间',
  primary key (info_id),
  key idx_sys_logininfor_s  (status),
  key idx_sys_logininfor_lt (login_time)
) engine=innodb auto_increment=100 comment = '系统访问记录';
