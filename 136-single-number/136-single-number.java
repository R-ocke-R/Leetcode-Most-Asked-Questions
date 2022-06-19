// better approach o(n^2) complexity, constant extra space. 
class Solution {
    public int singleNumber(int[] arr) {
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans^=arr[i];
            }
        return ans;
    }

}