class Solution {
    public int peakIndexInMountainArray(int[] arr) {
//         ofcourse the O(n) solution is very simple and straight forward
        int i=0;
        while (true){
            if(arr[i++]>arr[i]){
                break;
            }
        }
        return --i;
    }
}