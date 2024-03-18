class Solution {
    public void swapt(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    public void transpose(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for(int j = i+1; j< matrix.length; j++){
                swapt(matrix, i, j);
            }
        }
    }
    public void swap(int[][] matrix, int i , int j)
    {
        int n = matrix.length;
        // to mirror the elements we swpa i, j with i, n-j-1
        int temp = matrix[i][j];
        matrix[i][j]= matrix[i][n-1-j];
        matrix[i][n-1-j]= temp;
    }
    public void mirror(int[][] matrix){
        for(int i = 0 ;i < matrix.length ; i++){
            for(int j = 0; j < matrix.length/2; j++){
                swap(matrix, i , j);
                }
            }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        mirror(matrix);
    }
}