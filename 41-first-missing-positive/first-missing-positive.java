class Solution {
    public int firstMissingPositive(int[] nums){
        return firstMissingPositiveBest(nums);
    }
    public int firstMissingPositiveBrute(int[] nums) {
        // brute solution implementation
        int limit = Integer.MIN_VALUE;

        for(Integer i : nums) limit = Math.max(limit, i);
        if(limit <= 0) return 1;
        // check for all values from 1 to limit; the first not to exist is first positive
        for(int value = 1; value <= limit; value ++){
            // check if value exists
            boolean flag = false;
            for(Integer i : nums) {
                if (i == value) flag = true;
            }
            if (flag == false) return value;

        }
        // value doesn't exist so the first positive is limit+1
        return limit+1;
        /** This approach gave TLE: 
        TC -> O(limit*n) where limit can go till 2^31
        SC -> O(1)

        OBVIOUSLY I CAN MAKE A TRADEOFF BETWEEN SPACE AND TIME AND IMPLEMENT A HASHMAP SOLUTION
        WHERE I WILL CHECK MAP.CONTAINS(VALUE) 
        GETTING THE SOLUTION A TC OF o(n) 
         */
    }
    public int firstMissingPositiveBetter(int[] nums){
        int answer = 1;
        Arrays.sort(nums);

        
        for(Integer i : nums){
            // negative continue
            if(i < 1) continue;
            // answer is in nums, so next positive could be missing
            if(i==answer) answer ++;

            else continue;

        }
        return answer;
        /** This solution is simple and passes our testcases, without any TLE
        as the worst case time is nlogn  */
    }
    public int firstMissingPositiveBest(int[] nums){
        /** now the only way to get this in linear time and cosntant space is 
        to use the input array as our memory. 
        */
        // read notes for more explanation.

        // remove -ve number
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < 0) nums[i] = 0;
        }

        // now we use negative flags and use array values are indexes.
        for(int i = 0; i < n ; i++){
            
            // case 1: do nothing if value is 0
            // case 2: if value is larger than our possible answer. 
            // example: [7, 8, 9] in this case all values when used as index go outofBounds
            // yet the answer is 1 so we don't need values who are out of bounds.

            int value = Math.abs(nums[i]);
            if ( value >= 1 && value <= n){
                if(nums[value-1] < 0) continue;
                else if(nums[value-1]==0) nums[value-1]= - (n+1);
                else nums[value-1] = -(nums[value-1]);
            }
            
        }
        // here we will have marked all the index values that are present as -ve. 
        // so now the first value in array which is positive is the index 
        // that is not present
        //System.out.println(n);
        //System.out.println(Arrays.toString(nums));
        for(int i = 0; i < n; i++ ){
            //System.out.println(n);
            if(nums[i] >= 0 ) return i+1;
        }
        
        return n+1 ;
        
    }
}