# springboot-redis
# This project describe how caching work using redis and spring boot
## HOW TO IMPLEMENT CACHING USING REDIS IN SPRING BOOT APPLICATION
## Prerequisite
1. Your machine already installed redis or your machine run redis inside docker container(if not installed, you can see my previous tutorial = https://youtu.be/6-n3XTpoEMA)
2. Your redis already run
3. you understand the concept of caching
4. You are familiar create spring boot from scratch
5. Your laptop already installed database mysql


WHEN WE NEED CACHING?
- when the app receipt many request and the data requested doesn't change much
- when the frequently accessed data need serve to the client quickly

WHAT THE BENEFIT USING CACHING?
- reduce calls to the database.
- serve data to the client quickly

IN THIS TUTORIAL I WILL USE THIS SCENARIO
1. imagine you have an online store app, customers can pay for products using many payment methods(paypal, union pay etc)
2. get list of payment from database, when customer needed. This behaviour not good in application performance(because the app calls to database when need list of payment)
Break the problem using redis
1. When first customer get list of payment, the app keep the list of payment inside redis cache
2. and then every customer need, list of payment. The app get the list from cache redis



LETS JUMP RIGHT IN
1. this is my pom.xml
2. This is my package structure
3. add @EnableCaching in main class
4. add Redis config and mysql config in application.properties
5. Create Class PaymentType entity
6. Create interface PaymentTypeRepository
7. Create PaymentTypeController
8. add annotation @Cacheable in getAllPaymentType method
9. run the app
10. run this command, to save row into table
INSERT INTO `dns-multi-pro`.payment_type
(id, create_date, description, name_of_payment, status, update_date)
VALUES(1, '2023-01-03 00:00:00', 'Payment Using Paypal', 'Paypal', 'Active', '2023-01-03 00:00:00');
INSERT INTO `dns-multi-pro`.payment_type
(id, create_date, description, name_of_payment, status, update_date)
VALUES(2, '2023-01-03 00:00:00', 'Payment Using Union Pay', 'Union Pay', 'Active', '2023-01-03 00:00:00');

11.try to test app
   ## expected result of test
     ### when first request call api get list of payment type the response will delay 3 second
     ### when second request call api get list of payment type the response will more faster


SUCCESS, Happy learning and happy sharing !!!
