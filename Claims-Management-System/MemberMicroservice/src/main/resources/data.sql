
/*Inserting data in member_policy table*/
insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(1,1,101,201,'2021-06-24',21,100000.00);
insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(2,1,101,201,'2020-03-07',21,100000.00);
insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(3,2,102,202,'2019-01-09',14,120000.00);

/* inserting in member_premium*/
insert into member_premium (member_id,policy_id,paid_date,due_date,premium,late_payment,late_payment_charges) values(1,1,'2021-06-25','2021-07-05',5000.0,false,0.0);
insert into member_premium (member_id,policy_id,paid_date,due_date,premium,late_payment,late_payment_charges) values(2,1,'2021-04-09','2021-05-13',8000.0,false,0.0);
insert into member_premium (member_id,policy_id,paid_date,due_date,premium,late_payment,late_payment_charges) values(3,2,'2021-04-20','2021-03-02',15000.0,true,100);

/* inserting in member_claim*/
insert into member_claim (policy_id,member_id,claim_id,provider_id,benefit_id,total_billed_amount,total_claimed_amount,claim_status,claim_description) values(1,2,1,1,201,100000.0,80000.0,'claimed','City hospital Free Monthly Health Checkup');
insert into member_claim (policy_id,member_id,claim_id,provider_id,benefit_id,total_billed_amount,total_claimed_amount,claim_status,claim_description) values(2,1,2,2,202,42000.0,42000.0,'claimed','LIC claim Cashless Medical Treatment');


/* inserting in member*/
insert into member(member_id,member_name,phone_number,salary,gender) values (1,'Nikit','8923767415',89000,'Male');
insert into member(member_id,member_name,phone_number,salary,gender) values (2,'Shailesh','8892641615',82900,'Male');
insert into member(member_id,member_name,phone_number,salary,gender) values (3,'Shivani','9923241415',79000,'Female');
insert into member(member_id,member_name,phone_number,salary,gender) values (4,'Rishabh','8973239088',99000,'Male');