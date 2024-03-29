class Solution {
    
    public int rob1Recursive(int[] nums, int i, int n){
        
        //Recursion => Solve one case, rest recursion will handle
        
        //base
        if(i>=n) return 0;
        
        //for each element I have two cases
        int take=nums[i]+rob1Recursive(nums, i+2, n);
        int move=rob1Recursive(nums, i+1, n);
         
        return Math.max(take, move);
    }
    
    public int space(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        
        int a=nums[0];
        int b=Math.max(nums[0], nums[1]);
        int c=0;
        //or c=math.max(nums[i]+a, b);
        for(int i=2;i<n;i++){
            c=Math.max((nums[i]+a), b);
            a=b;
            b=c;
        }
        return c;
    }
    
    public int space2(int[] nums, int s, int e){
        // int n=nums.length;
        // int elements=n-1;
        // if(n==2) return nums[
        int a=nums[s];
        int b=Math.max(nums[s], nums[s+1]);
        int c=Math.max(a, b);
        for(int i=s+2;i<e;i++){
            c=Math.max((nums[i]+a), b);
            a=b;
            b=c;            
        }
        return c;        
    }
    
    
    public int rob(int[] nums) {
        
        // question same as house robber 1
        //taking the function from that question
        // first trying the recursive approach :- TLE given
        
//         int n=nums.length;
        
        
//         int first=rob1Recursive(nums, 0, n-1);
//         int last=rob1Recursive(nums, 1, n);
        
//         // System.out.println(first+" " + last);
        
//         return Math.max(space(first), last);
        
        
//         this approach creates two arrays and copies the elements into them. thus space O(n) 
//         where our DP was O(1) space.
//         int n = nums.length;
//         if(n==1) return nums[0];
        
//         int[] first=new int[n-1];
//         int[] last=new int[n-1];
        
//         for(int i=0;i<n-1;i++){
//             first[i]=nums[i];  
//         }
//         for(int i=1;i<n;i++){
//             last[i-1]=nums[i];
//         }
        
//         return Math.max(space(first), space(last));
        
        
        
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int first=space2(nums, 0, n-1);
        int last=space2(nums, 1, n);
        // System.out.println(first+" "+ last);
        return Math.max(first, last);
        
    }
}