​​Love babber DSA Series Lecture 22
==


https://github.com/R-ocke-R/DSA_2022/blob/master/Love_Babber_Course/Phase_One/Lecture22/Palindrone.java

see all approaches.


For Given Question.


Approach 1 brute : 
![image](https://user-images.githubusercontent.com/72220114/177559531-1e101f8d-0ab9-4e4e-a0da-04520fcca4e9.png)


Approach 1 A:
```
publicboolean isPalindrome(Strings) {
        s = s.toLowerCase();
         
        int left= 0, right= s.length() - 1;
        while(left< right){
            
            while(left< right&& !Character.isLetterOrDigit(s.charAt(right))) right--;
            while(left< right&& !Character.isLetterOrDigit(s.charAt(left))) left++;
            
            if(s.charAt(left++) != s.charAt(right--)) returnfalse;
        }
        returntrue;
    }
```
