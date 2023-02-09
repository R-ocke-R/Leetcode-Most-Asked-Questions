class Solution {
    public void transwap(int[][] matrix, int i, int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    
    public void mirrorswap(int[][] matrix, int i, int j){
        int n=matrix.length;
        int temp=matrix[i][j];
        matrix[i][j]=matrix[i][n-1-j];
        matrix[i][n-1-j]=temp;
    }
    
    public void transpose(int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                transwap(matrix, i, j);
            }
        }
        return;
    }
    
    public void print(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    
    public void mirror(int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                mirrorswap(matrix, i, j);
            }
        }
    }
    
    public void rotate(int[][] matrix) {
        transpose(matrix);
        mirror(matrix);
        return;
    }
}