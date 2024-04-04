class Solution {
    public int[] replaceElements(int[] arr) {
        int  n= arr.length;
        int maxE = -1;
        for(int i = n-1; i >= 0; i--){
            int val = arr[i];
            arr[i] = maxE;
            maxE = Math.max(maxE, val);
        }
        return arr;
    }
}