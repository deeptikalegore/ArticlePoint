DROP TABLE IF EXISTS article;  
create table article(aid int NOT NULL AUTO_INCREMENT,uid int,title varchar(100),type varchar(100),
content longtext(2000),image text(500),date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,primary key(aid));