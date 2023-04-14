class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length < 2) return envelopes.length;
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] e1, int[] e2) {
                return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        int size = 0;
        for(int[] envelope : envelopes){
            int left=0, right=size, middle=0;

            while(left<right){
                middle=left+(right-left)/2;
                if(dp[middle]<envelope[1]) left = middle + 1;
                else right = middle;
            }
            dp[left]= envelope[1];
            if(left==size) size++;
            
        }
        return size;
    }
} 
        
        
//         for(int[] envelope: envelopes) {
//             // binary search
//             int left = 0, right = size, middle = 0;     // right = size
//             while(left < right) {
//                 middle = left + (right - left) / 2;
//                 if(dp[middle] < envelope[1]) left = middle + 1;
//                 else right = middle;
//             }
            
//             // left is the right position to 'replace' in dp array
//             dp[left] = envelope[1];
//             if(left == size) size++;
//         }
//         return size;
//     }
    
//     class EnvelopeComparator implements Comparator<int[]> {
//         public int compare(int[] e1, int[] e2) {
//             return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
//         }
//     }
// }
// public int maxEnvelopes(int[][] envelopes) {
//     if(envelopes == null || envelopes.length == 0 
//        || envelopes[0] == null || envelopes[0].length != 2)
//         return 0;
//     Arrays.sort(envelopes, new Comparator<int[]>(){
//         public int compare(int[] arr1, int[] arr2){
//             if(arr1[0] == arr2[0])
//                 return arr2[1] - arr1[1];
//             else
//                 return arr1[0] - arr2[0];
//        } 
//     });
//     int dp[] = new int[envelopes.length];
//     int len = 0;
//     for(int[] envelope : envelopes){
//         int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
//         if(index < 0)
//             index = -(index + 1);
//         dp[index] = envelope[1];
//         if(index == len)
//             len++;
//     }
//     return len;
// }