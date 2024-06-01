class Solution {
    public int countTripletsBruteBetter(int[] arr) {
        int count  = 0 ;
        int n = arr.length;


        for(int i = 0; i < n; i++){
            int a = 0;
            for(int j = i+1; j < n ; j++){
                a ^= arr[j-1];
                int b =0;
                for(int k = j; k < n; k++){
                    // all triplets will be created here
                    b^=arr[k];
                    if(a==b) count++;
                }
            }
        }
        return count;
    }
    public int countTriplets(int[] arr) {
        int count  = 0 ;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int a = arr[i];
            for(int j = i+1; j < n ; j++){
                a ^= arr[j];
                if(a==0) count += j-i;
            }
        }
        return count;
    }
}

/**
Brute would be to create all triplets and  */