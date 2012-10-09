-- drop index productCat;
-- drop index productName;
-- drop index itemProd;

-- drop table lineitem;
-- drop table orderstatus;
-- drop table orders;
-- drop table bannerdata;
-- drop table profile;
-- drop table signon;
-- drop table inventory;
-- drop table item;
-- drop table product;
-- drop table account;
-- drop table category;
-- drop table supplier;
-- drop table sequence;

create table supplier(
	suppid int not null,
	name varchar(80) null,
	status varchar(2) not null,
	addr1 varchar(80) null,
	addr2 varchar(80) null,
	city varchar(80) null,
	state varchar(80) null,
	zip varchar(5) null,
	phone varchar(80) null,
	constraint pk_supplier primary key (suppid)
);

create table signon(
	username varchar(25) not null,
	password varchar(25) not null,
	constraint pk_signon primary key(username)
);

create table account(
	userid varchar(80) not null,
	email varchar(80) not null,
	firstname varchar(80) not null,
	lastname varchar(80) not null,
	status varchar(2) null,
	addr1 varchar(80) not null,
	addr2 varchar(40) null,
	city varchar(80) not null,
	state varchar(80) not null,
	zip varchar(20) not null,
	country varchar(20) not null,
	phone varchar(80) not null,
	constraint pk_account primary key (userid)
);

create table profile(
	userid varchar(80) not null,
	langpref varchar(80) not null,
	favcategory varchar(30),
	mylistopt int,
	banneropt int,
	constraint pk_profile primary key (userid)
);

create table bannerdata(
	favcategory varchar(80) not null,
	bannername varchar(255) null,
	constraint pk_bannerdata primary key (favcategory)
);

create table orders(
	orderid int not null,
	userid varchar(80) not null,
	orderdate date not null,
	shipaddr1 varchar(80) not null,
	shipaddr2 varchar(80) null,
	shipcity varchar(80) not null,
	shipstate varchar(80) not null,
	shipzip varchar(20) not null,
	billcountry varchar(20) not null,
	courier varchar(80) not null,
	totalprice decimal(10,2) not null,
	billtofirstname varchar(80) not null,
	billtolastname varchar(80) not null,
	shiptofirstname varchar(80) not null,
	shiptolastname varchar(80) not null,
	creditcard varchar(80) not null,
	exprdate varchar(7) not null,
	cardtype varchar(80) not null,
	locale varchar(80) not null,
	constraint pk_orders primary key (orderid)
);

create table orderstatus(
	orderid int not null,
	linenum int not null,
	timestamp date not null,
	status varcahr(2) not null,
	constraint pk_orderstatus primary key (orderid, linenum )	
);

create table lineitem(
	orderid int not null,
	linenum int not null,
	itemid varchar(10) not null,
	quantity int not null,
	unitprice decimal(10,2) not null,
	constraint pk_lineitem primary key (orderid, lineitem)
);

create table category(
	catid varchar(10) not null,
	name varchar(80) null,
	descn varchar(255) null,
	constraint pk_category primary key(category)
);
 
create table product(
	productid varchar(10) not null,
	category varchar(10) not null,
	name varchar(80) null,
	descn varcahr()255) null,
	constraint pk_product primary key(productid),
	constraint fk_product_1 foreign key (category)
	references category(catid)
);

create index productCat on product(category);
create index productName on produt(name);

