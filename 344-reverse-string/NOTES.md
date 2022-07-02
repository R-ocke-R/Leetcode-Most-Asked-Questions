​Love Babber DSA SERIES Lecture 22
==

Simple Question:
```
int st=0;
        int e=s.length-1;
        while(st<e){
            char temp=s[st];
            s[st++]=s[e];
            s[e--]=temp;
        }
```
O(n) time , O(1) space.



other approaches: Stack, Recursion, or in-built stack builder functions.



note:Worst Case Complexity doesn't change.
