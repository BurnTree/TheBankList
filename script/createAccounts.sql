insert into account(account, userid) values (10,1);
insert into account(account, userid) values (5,1);
insert into account(account, userid) values (15,2);
insert into account(account, userid) values (16,4);
insert into account(account, userid) values (18,5);
insert into account(account, userid) values (220,6);
insert into account(account, userid) values (12020,7);
insert into account(account, userid) values (1212,8);
insert into account(account, userid) values (10000,9);
insert into account(account, userid) values (9080,9);
insert into account(account, userid) values (1023,10);
select * from account join user u on account.userid = u.userid;