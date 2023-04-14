class Solution {
    public boolean check(int[] two, int[] one){
        if(one[0]<=two[0] && one[1] <= two[1] && one[2] <= two[2]) return true;
        return false;
    }
    public int tabulation(int[][] nums){
        // Step 1: create DP and fill in the base cases.
        int n=nums.length;
        int[] curr = new int[n+1];
        int[] next= new int[n+1];
        
        // base cases already 0
        
        // Step 2: bottom up!!
        for(int index=n-1; index>=0; index--){
            for(int prev=index-1; prev>=-1; prev--){
                int val = next[prev+1];
                if(prev==-1 || check(nums[index], nums[prev])) val= Math.max(val, nums[index][2] + next[index+1]);
                curr[prev+1]=val;
            }
            next=curr;
        }
        return next[0];
    }
    
    public int maxHeight(int[][] cuboids) {
        
        
        // Step 1 : Sort the individual subaarrays of each cuboid
        for(int[] cube : cuboids){
            Arrays.sort(cube);
        }
       // Step 2 : Sort the cuboids in an order of thier L or B.
        Arrays.sort(cuboids, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return a[0] - b[0];
                if (a[1] != b[1])
                    return a[1] - b[1];
                return a[2] - b[2];
            }
        });
        for(int[] cube : cuboids){
            System.out.println(Arrays.toString(cube));
        }
        // step 3 find LIS or maximum height LIS.
        return tabulation(cuboids);
        
    }
}