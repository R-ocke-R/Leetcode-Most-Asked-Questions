​Love Babber DSA Series Lecture 10
===


// approach 1 storing frequency in map 
```TIME COMPLEXITY=O(n) SPACE O(N)```


// approach 1b storing element in list, removing when duplicate is found, in the end you have ele
```TIME COMPLEXITY=O(n) SPACE O(N)```

// Approach 2 removing duplicates & manipulating the array : Probably a Bad approach. worse time complexity


// Approach 3 for each element, count its freq in whole of array, until an element with 1 freq is found.
![image](https://user-images.githubusercontent.com/72220114/174468522-c84b87f7-a036-4f17-b9fb-5bb65de1c590.png)
![image](https://user-images.githubusercontent.com/72220114/174468691-de6692cd-17c6-41ff-a52a-34d646a36cca.png)


---


// Approach 4 Love's Approach explained in Lecture 

#### Using XOR Property
```
a^a=0
a^0=a
```

![image](https://user-images.githubusercontent.com/72220114/174468628-5a7ebcb0-a316-40df-9133-d122a2c45765.png)

![image](https://user-images.githubusercontent.com/72220114/174468684-16813d7e-1114-4436-83c0-f156e277e61e.png)

---

PS : METHOD 4: SUM OF ELEMENTS
All the unique elements , in the array have a frequency of 2 , except one element.

Store all the unique elements in set.
Add the elements of the set and multiply by 2 (SUM_1).
Add all the elements of the array(ARRAY_SUM).
Return (SUM_1 - ARRAY_SUM) .
Why does this work ??
ARRAY_SUM = 2*(a1+a2+a3...+ak) + a(k+1)
SUM_1 = 2*(a1+a2+a3+....+ak+ a(k+1))

a(x) represents the xth unique element in the array.
a(k+1) represents the element with frequency=1.
