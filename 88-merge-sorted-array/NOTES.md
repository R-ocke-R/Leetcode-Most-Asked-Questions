​Love Babber DSA Series Lecture 22


Merge Sorted Array: 

Approach 1:

Basic extended merge sort logic.


```
public static void merge(int[] arr1, int[] arr2, int n, int m){
        int[] marr=new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m){
            if (arr1[i]<arr2[j]){
                marr[k++]=arr1[i++];
            }
            else{
                marr[k++]=arr2[j++];
            }
        }
        while(i<n){
            marr[k++]=arr1[i++];
        }
        while(j<m){
            marr[k++]=arr2[j++];
        }
        System.out.println(Arrays.toString(marr));
    }
public static void main(String[] args) {
        int[] arr1=new int[]{10, 20, 30};
        int[] arr2= new int[] {15, 25, 35, 45};
        merge(arr1, arr2, arr1.length, arr2.length);


```



This is Merging two array's code by using an extra space of O(n+m) for new array.
![image](https://user-images.githubusercontent.com/72220114/176890493-2204b472-02f3-430d-a645-51f70b28bb87.png)




For the given question, we have n empty places in the first array, so we have to utilise that, Trick=Start filling nums2 from the end

![image](https://user-images.githubusercontent.com/72220114/176890580-55156c57-7351-4130-90c2-403848f66213.png)
