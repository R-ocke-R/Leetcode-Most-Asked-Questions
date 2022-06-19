​Love Babber Lec 7 DSA Series
===

Approach 1:
Used direct method, brute, first converting to binary-> compliment -> back to decimal. It somehow crashed at many levels and took more than 2 hours to code and debug.
Left this approach for later.

---

Approach 2: Love's approach

Intuition 

5 = 000.. 0101
~5= 111.. 1010 

This ~5, ignoring the 11111 in the forward, 010 is the binary eq of 101
so our task is to remove the occupied digits from the compliment of n





Now creating a mask of 0000.. 111111 where number of ones comes from 5 (number of occupied digits)

Then ~n & mask= result.

![image](https://user-images.githubusercontent.com/72220114/174462377-67b5cc4a-89b7-445b-86ca-1da6cad0dd7a.png)

Mask:



Count occupied digits until n=0, {  count++  }
Then count is the occupied digits

Now  take 0, left shit then bitwise or with 1. 
(count times).


Good Approach can be reproduced and improved.


There are many more bitwise tricks to solve this queston, he point is to initiate a thought in this direction, not about learning all bitwise tricks.

