
/* Member-Policy Table*/
create table member_policy(member_id int,policy_id int,policy_number int,benefit_id int,subscription_date date,tenure int,cap_amount_benefits double);

/* member_premium table */
create table member_premium(member_id int,policy_id int,paid_date date,due_date date,premium double,late_payment boolean,late_payment_charges double);

/* member_claim table */
create table member_claim(policy_id int,member_id int,claim_id int,provider_id int,benefit_id int,total_billed_amount double,total_claimed_amount double,claim_status varchar(20),claim_description varchar(50));

/*member table*/
create table member (member_id int,member_name varchar(20),phone_number varchar(11),salary double,gender varchar(6),primary key(member_id));