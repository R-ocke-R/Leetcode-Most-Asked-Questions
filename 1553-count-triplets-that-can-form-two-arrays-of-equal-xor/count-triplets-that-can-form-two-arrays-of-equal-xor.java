class Solution {
    public int countTriplets(int[] arr) {
        int count  = 0 ;
        int n = arr.length;


        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n ; j++){
                for(int k = j; k < n; k++){
                    // all triplets will be created here
                    int a=0, b=0;
                    for(int l = i; l < j; l++){
                        a ^= arr[l];
                    }
                    for(int l = j; l < k+1; l++){
                        b^= arr[l];
                    }
                    if(a==b) count++;
                }
            }
        }
        return count;
    }
}

/**
Brute would be to create all triplets and  */