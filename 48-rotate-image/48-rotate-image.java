class Solution {
    
    public void transpose(int[][] arr, int n){
        //one mistake that I was making was running loop from 0 to length, the mistake was that the index was swapped 
        //based on i and j but later on it was getting swapped back to original position based on j and i.
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                // if(i==j) continue;
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }
    
    public void rotateColumn(int[][] arr, int n){
        for(int i=0;i<n;i++){
            for(int j=0; j<n/2;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[i][n-j-1];
                arr[i][n-1-j]=temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        
        int n=matrix.length;
        
        transpose(matrix, n);

        
        rotateColumn(matrix, n);
        // for(int i=0;i<n;i++){
        //     System.out.println(Arrays.toString(matrix[i]));
        // }
        
    }
}