​Approach 1 brute : using (M X N) space complexity for storing all positions of zeros, now in second traversal update the rows and columns of positions. time complexity O ((M * N) + (M + N)) for traversal + for updation in row (M) and column(N). 

---

Approach 1a: tried to inplace replace all 0, without storing anything wrong answer, thus updation + checking cannot occur in one iteration. think about it why ? answer: becoz once manipulated/ updates (say in first row ) now there is no way of figuring out which  zero is old which is new/updated ( say in second row).

---

Approach 2: O(1) space: using -1, ( so now the above issue doesn't exist ( issue of confusion btw new and old zero) ) but its rejected in this case as assumption wasn't true on leetcode. STRIVER's approach. otherwise this is nice approach and uses o(1) space, but same time complexity of 1st approach:


![image](https://user-images.githubusercontent.com/72220114/174291392-6750a289-f967-4165-9449-0a4c669bb14e.png)



So can't rely on -1 assumption but If assumption hold true, we can use it even on the optmized approach and maybe even remove boolean variable use.

---

Approach 3: Auxiliary space of M + N worked. By talking two new arrays


![image](https://user-images.githubusercontent.com/72220114/174291488-d9bab721-b7cb-44ec-a819-a523c3a39233.png)

---

Approach 4: Dummy row & column. Using first row and column as flags arrays. O(1) space,  O(M X N ) + O( M + N) time complexity for two traversals. 


![image](https://user-images.githubusercontent.com/72220114/174291516-66e5089a-8191-4aff-adce-f6453774deb2.png)
