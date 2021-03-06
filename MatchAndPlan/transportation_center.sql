INSERT INTO `transportation_center`(`id`, `name`, `city`, `max_cargo_count`, `address`, `longitude`, `latitude`) VALUES (1, '迈皋桥分公司', '南京', 1000, '铺岗街419号附近', 118.821565, 32.114319);
INSERT INTO `transportation_center`(`id`, `name`, `city`, `max_cargo_count`, `address`, `longitude`, `latitude`) VALUES (2, '江心洲分公司', '南京', 2000, '上海市青浦区徐泾镇明珠路1168号圆通速递', 118.716898, 32.048265);
INSERT INTO `transportation_center`(`id`, `name`, `city`, `max_cargo_count`, `address`, `longitude`, `latitude`) VALUES (3, '广东路分公司', '南京', 1700, '靖江镇保税大道', 118.771426, 32.088295);
INSERT INTO `transportation_center`(`id`, `name`, `city`, `max_cargo_count`, `address`, `longitude`, `latitude`) VALUES (4, '浦口二部分公司', '南京', 1000, '江苏省无锡市新吴区薛典北路128号', 118.680943, 32.11551);
INSERT INTO `transportation_center`(`id`, `name`, `city`, `max_cargo_count`, `address`, `longitude`, `latitude`) VALUES (5, '紫竹林分公司', '南京', 38888, '江苏省', 118.780865, 32.090088);
INSERT INTO `transportation_center`(`id`, `name`, `city`, `max_cargo_count`, `address`, `longitude`, `latitude`) VALUES (6, '石头城分公司', '南京', 34512, '江苏省', 118.757481, 32.074374);
INSERT INTO `transportation_center`(`id`, `name`, `city`, `max_cargo_count`, `address`, `longitude`, `latitude`) VALUES (7, '虹桥中心分公司', '南京', 2321, '江苏省', 118.76091, 32.085629);
INSERT INTO `transportation_center`(`id`, `name`, `city`, `max_cargo_count`, `address`, `longitude`, `latitude`) VALUES (8, '新河西分公司', '南京', 60000, '江苏省', 118.739278, 32.030876);
INSERT INTO `transportation_center`(`id`, `name`, `city`, `max_cargo_count`, `address`, `longitude`, `latitude`) VALUES (9, '中山万豪分公司', '南京', 50000, '江苏省', 118.773292, 32.078233);
INSERT INTO `transportation_center`(`id`, `name`, `city`, `max_cargo_count`, `address`, `longitude`, `latitude`) VALUES (10, '共青团路分公司', '南京', 70000, '江苏省', 118.774808, 31.992572);
INSERT INTO `transportation_center`(`id`, `name`, `city`, `max_cargo_count`, `address`, `longitude`, `latitude`) VALUES (11, '南京转运中心', '南京', 1000000, '江苏省南京市江宁区', 118.81611, 31.777821);

id	int(11)	NO	PRI		auto_increment
name	varchar(45)	NO			
city	varchar(45)	NO			
max_cargo_count	int(11)	NO			
address	varchar(255)	YES			
longitude	double	YES			
latitude	double	YES			