-- Create table
create table DB_SEQUENCE
(
  TABLENAME    VARCHAR2(100) not null,
  INCREMENTNO  NUMBER(10) not null,
  STARTNO      NUMBER(10) not null,
  CURRENTNEXT  NUMBER(10) not null,
  ISAUDITED    CHAR(1) default 'N',
  ISTABLEID    CHAR(1) default 'N',
  PREFIX       NVARCHAR2(10),
  SUFFIX       NVARCHAR2(10),
  STARTNEWYEAR CHAR(1) default 'N'
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table DB_SEQUENCE
  add primary key (TABLENAME)
  using index 
  tablespace ELINK11
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );