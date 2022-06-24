class Solution {
    public static int bs(int[] arr, int s, int e, int t){
        int mid=s+((e-s)/2);
        while(s<=e){
            if (arr[mid]==t){
                return mid;
            }
            else if(arr[mid]<t){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
            mid=s+((e-s)/2);
            }
        return -1;
    }
    public int search(int[] nums, int target) {
        int p=pivot(nums);
        
        if(p==0) return bs(nums, 0, nums.length-1, target);
               
        if(target==nums[p]){
            return p;
        }
        // return nums[s];
        if(nums[0]>target){
            return bs(nums, p, nums.length-1, target);
        }
        
        return bs(nums, 0, p-1, target);
    }
    
    public static int pivot(int[] nums){
        if(nums[0]<nums[nums.length-1]) return 0;
        
        int s=0;
        int e=nums.length-1;
        int m= s+((e-s)/2);
        while(s<e){
            if(nums[m]>=nums[0]){
                s=m+1;
            }        
            else{
                e=m;
                
            }
            m=s+((e-s)/2);
        }
        return s;
    }
}