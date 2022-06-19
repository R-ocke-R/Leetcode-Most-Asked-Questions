​Love Babber Lec 7 DSA Series
===


Approach 1:


Self -


Intuition to solve comes from analyzing numbers that are power of two. they are multiples of two, so dividing by 2 until you get a 1 should do?


1 2 4 8 16... so if a number is part of these, divide it and know. 

but this approach fails coz 17/2=8/2=4/2=2/2=1/2=1 thus true.


---


Approach 2:


Self-


Bitwise approach, understanding the binary equivalent of each power of two, gives another intuition that for a number to be binary only one of its bits would be set. Only one. Think about it to understand it. So take bits out and counter if bit is 1, while n!=0. Now if count==1 then number is power of two.


Have implemented this in solution


---


Approach 3: Love's 


if we look at the table, we begin to realize that there are only 2^31 power of two's in integers. So we can manually create them and compare them with our n. 
```
num=1;
num=num*2;
if num==n
  return true;
else
  return false;
  ```
  
 This is a O(1) approach for time complexity.
 Approach 2 was O(log(n)) coz there are log base 10 digits in a number.
  
