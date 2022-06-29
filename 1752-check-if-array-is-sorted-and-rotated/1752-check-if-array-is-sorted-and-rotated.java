class Solution {
    public void rotate(int[] arr, int k){
        k=k%arr.length;
        rr(arr, 0, arr.length-1);
        rr(arr, 0, k-1);
        rr(arr, k, arr.length-1);
            
    }
    public void rr(int[] arr, int s, int e){
        while(s<e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
            
        }
    }
    
    public boolean check(int[] nums) {
        int k=0;
        boolean ans=true;
        while(k<nums.length){
            rotate(nums, 1);
            k++;
            ans=true;
            // System.out.println(Arrays.toString(nums));
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]) {
                    // System.out.println(nums[i] +" "+ nums[i+1]);
                    ans=false;
                    break;
                }
            }
            // System.out.println(ans);
            if(ans==true){
                return true;
            }
            
        }
        return false;
    }
}