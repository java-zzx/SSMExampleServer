-- �����ֵ��
create table tc_area_db1
(
	provin_code	char(6)		not null,	-- ʡ�ݱ���				
	provin_name	varchar(32)	not null,	-- ʡ������				
	provin_pym	varchar(20)	null	,	-- ʡ_ƴ����				
	city_code	char(6)		not null,	-- ���б���				
	city_name	varchar(32)	not null,	-- �������� 				
	city_pym	varchar(20)	null	,	-- ��_ƴ���� 				
	county_code	char(6)		not null,	-- �������				
	county_name	varchar(32)	not null,	-- ��������				
	county_pym	varchar(20)	null	,	-- ��_ƴ����  				
	is_hotcity	char(1)		default 0,	-- �Ƿ��ȵ����				
	PRIMARY KEY (county_code)
)
;
-- �����ֵ��
create table tc_area_db2
(
	provin_code	char(6)		not null,	-- ʡ�ݱ���				
	provin_name	varchar(32)	not null,	-- ʡ������				
	provin_pym	varchar(20)	null	,	-- ʡ_ƴ����				
	city_code	char(6)		not null,	-- ���б���				
	city_name	varchar(32)	not null,	-- �������� 				
	city_pym	varchar(20)	null	,	-- ��_ƴ���� 				
	county_code	char(6)		not null,	-- �������				
	county_name	varchar(32)	not null,	-- ��������				
	county_pym	varchar(20)	null	,	-- ��_ƴ����  				
	is_hotcity	char(1)		default 0,	-- �Ƿ��ȵ����				
	PRIMARY KEY (county_code)
)
;