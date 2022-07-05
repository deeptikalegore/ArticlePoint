DROP TABLE IF EXISTS article;  
create table article(aid int NOT NULL AUTO_INCREMENT,uid int,title varchar(100),type varchar(100),
content longtext(2000),image text(500),date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,likes int,primary key(aid));

DROP TABLE IF EXISTS comment;  
create table comment(cid int NOT NULL AUTO_INCREMENT,aid int,uid int,comment varchar(100),date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,primary key(cid));