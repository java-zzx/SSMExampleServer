-- 区域字典表
create table tc_area_db1
(
	provin_code	char(6)		not null,	-- 省份编码				
	provin_name	varchar(32)	not null,	-- 省份名称				
	provin_pym	varchar(20)	null	,	-- 省_拼音码				
	city_code	char(6)		not null,	-- 城市编码				
	city_name	varchar(32)	not null,	-- 城市名称 				
	city_pym	varchar(20)	null	,	-- 市_拼音码 				
	county_code	char(6)		not null,	-- 区域编码				
	county_name	varchar(32)	not null,	-- 区县名称				
	county_pym	varchar(20)	null	,	-- 区_拼音码  				
	is_hotcity	char(1)		default 0,	-- 是否热点城市				
	PRIMARY KEY (county_code)
)
;
-- 区域字典表
create table tc_area_db2
(
	provin_code	char(6)		not null,	-- 省份编码				
	provin_name	varchar(32)	not null,	-- 省份名称				
	provin_pym	varchar(20)	null	,	-- 省_拼音码				
	city_code	char(6)		not null,	-- 城市编码				
	city_name	varchar(32)	not null,	-- 城市名称 				
	city_pym	varchar(20)	null	,	-- 市_拼音码 				
	county_code	char(6)		not null,	-- 区域编码				
	county_name	varchar(32)	not null,	-- 区县名称				
	county_pym	varchar(20)	null	,	-- 区_拼音码  				
	is_hotcity	char(1)		default 0,	-- 是否热点城市				
	PRIMARY KEY (county_code)
)
;