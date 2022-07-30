class Solution {
    public static void merge(int[] arr, int s, int mid, int e){
        //this function's job is to simply take the arr (which has two sorted arrays) and merge them in order
        
        int s1=mid-s+1;
        int s2=e-mid;

        int left[]=new int[s1];
        int right[]= new int[s2];

        int k=s;
        for (int i = 0; i < left.length; i++) {
            left[i]=arr[k++];
        }

        for (int i = 0; i < right.length; i++) {
            right[i]=arr[k++];
        }

        int index1=0;
        int index2=0;
        k=s;
        while(index1<s1 && index2<s2){
            if(left[index1]<right[index2])  arr[k++]=left[index1++];
            else arr[k++]=right[index2++];
        }
        while(index1<s1){
            arr[k++]=left[index1++];
        }
        while(index2<s2){
            arr[k++]=right[index2++];
        }
    }

    public static void mergeSort(int[] arr, int s, int e){
        
        if(s>=e) return;

        //Use Recursion and solve smaller arrays
        int mid=s+(e-s)/2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid+1, e);
        //mergeSort function job is to sort the array, so now s to mid and mid+1 to e are sorted,
        //now our job is to merge both of them together.

        merge(arr, s, mid, e);
        return;
    }
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}