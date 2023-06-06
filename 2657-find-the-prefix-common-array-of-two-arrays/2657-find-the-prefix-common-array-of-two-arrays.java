class Solution {
    public int[] findThePrefixCommonArray2(int[] A, int[] B) {
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
    public int[] findThePrefixCommonArray(int[] A, int[] B){
        int n= A.length;
        int[] C = new int[n+1];
        int[] D = new int[n];
        
        int count=0;
        
        for(int i=0;i<n;i++){
            
            if(++C[A[i]] == 2) count++;
            if(++C[B[i]] == 2) count++;
            
            D[i]=count;
        }
        return D;
    }
}
/* Brute force : O(n^2) solution*/

