Love Babber Lec 7 DSA Series
=====
As specified the question had two cases to be handled:

1. Normal Integer Within Integer Range 

> return the reverse of the number

> ![image](https://user-images.githubusercontent.com/72220114/174429238-d98c9ba1-d632-42e4-a25b-264766437bfa.png)


2. Out of range Integer 
---
![image](https://user-images.githubusercontent.com/72220114/174429198-4937619a-d3c6-41ef-8121-0b7eb1bf7153.png)

> return 0


---

Case 2:
What is the cause of number which was integer in the start to go beyond its range when reversing.
num X 10 can make the num increase more than what can be stored as a integer.
solution: Integer.MAX_VALUE and Integer.MIN_VALUE for both higher than range and lower than range.

So will this work
---
![image](https://user-images.githubusercontent.com/72220114/174429406-dbf44af1-8557-400a-9e91-5dcf27ef99c3.png)

NO! If you think about it, multipling and checking defeats the whole purpose.

So, our alternate will  be
---
![image](https://user-images.githubusercontent.com/72220114/174429431-444df90a-5f64-4b33-b9d9-7525244dc5b3.png)

Thus Solution Condition
---
![image](https://user-images.githubusercontent.com/72220114/174429436-20073d6f-66ad-41dc-909c-8aaaa50690c9.png)





--- 
### Other approaches
1. Convert to String, reverse it and get the reverse converted to integer.
