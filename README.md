# Design Amazon Locker

What is amazon locker?  
When a customer orders items with amazon they may choose to deliver it to locker which customer can pick it up on the way to their home.
  
Customers can also return items to lockers which can be picked up pickup team than pickup form home geoLocation.  

Locker Sizes  
1. Small
2. Medium
3. Large
4. Extra Large
5. Double Extra Large

Customer while ordering item can pick up their nearest geoLocation of locker where items are shipped to.   
Items are kept for maximum of 3 days.  
User gets locker code using which they can open the locker.  
Once the locker is closed the code is expired and cannot be open again.  

1. Assign a closest locker to a person given current co-ordinates( where customer wants )
2. After order is delivered by courier service to customer specified amazon locker, a 6 digit code will be sent to customer .
3. Item will be placed in Amazon locker for 3 days
4. After 3 days, if Item is not picked up from the locker, refund process will be initiated
5. Amazon locker will be assigned to customer based on the size of the locker ( S,M,L,XL,XXL)
6. Only items that are eligible to be put in locker can be assigned to amazon locker .i.e Not all items can be placed inside locker (like furniture can't be put inside amazon locker)
7. Access to Amazon locker will depend on Store's opening and closing time.(Since Amazon locker are placed inside stores,malls etc)
8. Items can be returned to Amazon locker as well .
9. Items that are eligible Amazon locker item, can only be returned by customer
10. Once the Door is closed. User's code will be expired. (User will not be able to open the locker now)

https://www.amazon.com/primeinsider/tips/amazon-locker-qa.html  
Requirements Courtesy - Leetcode
