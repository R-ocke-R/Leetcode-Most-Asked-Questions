class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n= A.length;
        int[] C = new int [n];
        
        for(int i=0;i<n; i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(A[i]==B[j]){
                    count=j;
                    break;
                }
            }
            count= Math.max(i, count);
            for(int j=count; j<n;j++){
                C[j]+=1;
            }
        }
        return C;
    }
}
/* Brute force : O(n^2) solution*/

