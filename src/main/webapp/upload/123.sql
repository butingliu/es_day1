/*==============================================================*/
/* Table: dd_address     地址表                                       */
/*==============================================================*/
create table dd_address  (
   id                   varchar2(36)                    not null,
   name                 varchar2(100),
   phone                varchar2(11),
   local                varchar2(300),
   zip_code             varchar2(6),
   user_id              varchar2(36),
   constraint PK_DD_ADDRESS primary key (id)
);
create sequence address_seq;

/*==============================================================*/
/* Table: dd_admin          管理员表                                    */
/*==============================================================*/
create table dd_admin  (
   id                   varchar2(36)                    not null,
   username             varchar2(100),
   password             varchar2(100),
   constraint PK_DD_ADMIN primary key (id)
);
create sequence admin_seq;
insert into dd_admin values(admin_seq.nextval,'admin','admin');
select * from dd_admin;
commit;
/*==============================================================*/
/* Table: dd_book           图书表                                    */
/*==============================================================*/
create table dd_book  (
   id                   varchar2(36)                    not null,
   name                 varchar2(100),
   price                number(10,2),
   dprice               number(10,2),
   sale                 number(10),
   author               varchar2(100),
   category_id          varchar2(36),
   publisher            varchar2(100),
   borndate             date,
   edition              varchar2(60),
   birthday             date,
   impression           varchar2(60),
   isbn                 varchar2(100),
   format               varchar2(60),
   paper                varchar2(60),
   pack                 varchar2(100),
   page                 varchar2(100),
   words                varchar2(100),
   cover                varchar2(100),
   edit                 varchar2(100),
   description          varchar2(300),
   intro                varchar2(300),
   basedir              varchar2(300),
   media                varchar2(300),
   sales                number(10),
   constraint PK_DD_BOOK primary key (id)
);

/*==============================================================*/
/* Table: dd_category         分类表                                  */
/*==============================================================*/
create table dd_category  (
   id                   varchar2(36)                    not null,
   name                 varchar2(100),
   parent_id            varchar2(36),
   levels               varchar2(10),
   constraint PK_DD_CATEGORY primary key (id)
);

/*==============================================================*/
/* Table: dd_item                                               */
/*==============================================================*/
create table dd_item  (
   id                   varchar2(36)                    not null,
   order_id             varchar2(36),
   book_id              varchar2(36),
   count                number(10),
   create_date          date,
   total                number(10,2),
   constraint PK_DD_ITEM primary key (id)
);

/*==============================================================*/
/* Table: dd_order       订单项表                                       */
/*==============================================================*/
create table dd_order  (
   id                   varchar2(36)                    not null,
   order_Num            varchar2(36),
   total                number(10,2),
   create_date          date,
   address_id           varchar2(36),
   user_id              varchar2(36),
   constraint PK_DD_ORDER primary key (id)
);

/*==============================================================*/
/* Table: dd_user          用户表                                     */
/*==============================================================*/
create table dd_user  (
   id                   varchar2(36)                    not null,
   email                varchar2(60),
   nickname             varchar2(100),
   password             varchar2(50),
   status               varchar2(10),
   code                 varchar2(10),
   salt                 varchar2(20),
   create_date          date,
   constraint PK_DD_USER primary key (id)
);
