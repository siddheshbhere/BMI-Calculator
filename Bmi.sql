drop database if exists BMI;
create database if not exists BMI;
use BMI;

drop table if exists BMI;
create table if not exists BMI (
id int primary key,
name varchar(40),
age int,
phone int unique,
gender varchar(10),
height double unsigned,
weight double unsigned,
bmi double unsigned
);

delimiter $$

drop procedure if exists BM $$

create procedure BM(in id int, in name varchar(40), in age int, in phone int, in gender varchar(10), in height double, in weight double, in bmi double)
begin

insert into BMI(id, name, age, phone, gender, height, weight, bmi) values(id, name, age, phone, gender, height, weight, bmi);

end $$

delimiter ;

create or replace view Fit as select * from BMI;

delimiter $$

drop trigger if exists t $$
create trigger t before insert on BMI for each row
begin
	if new.id is null or new.id < 1  then
		signal SQLSTATE '12345' set message_text = 'invalid ID';
	end if;

	if new.name is null or length(new.name) < 2  then
		signal SQLSTATE '23456' set message_text = 'invalid Name';
	end if;

	if new.age is null or new.age < 1 then
		signal SQLSTATE '12344' set message_text = 'invalid Age';
	end if;

	if new.phone is null or new.phone < 1 or length(new.phone) > 10  then
		signal SQLSTATE '12346' set message_text = 'invalid Phone Number';
	end if;

	if new.gender is null  then
		signal SQLSTATE '12347' set message_text = 'invalid Gender';
	end if;

	if new.height is null or new.height < 1 then
		signal SQLSTATE '12348' set message_text = 'invalid Height';
	end if;

	if new.weight is null or new.weight < 1 then
		signal SQLSTATE '12349' set message_text = 'invalid Weight';
	end if;

	if new.bmi is null or new.bmi < 1 then
		signal SQLSTATE '12355' set message_text = 'invalid BMI';
	end if;
end $$

delimiter ;

delimiter $$

drop function if exists f $$

create function f() returns int deterministic 
begin

declare co int default 0;
select count(*) into co from BMI;
return co;

end $$

delimiter ;

delimiter $$

drop function if exists f1 $$

create function f1() returns int deterministic 
begin

select *
into OUTFILE "F:\\SQL_DB_DEMO\\InternshipProject\\d.csv"
fields  terminated by ','
from BMI;
return 1;

end $$

delimiter ;


