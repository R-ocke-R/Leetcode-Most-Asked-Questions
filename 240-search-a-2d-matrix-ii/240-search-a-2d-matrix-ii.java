class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        
        int rindex=0;
        int cindex=col-1;
        //takes us to 15 or the top-rightmost element to start with
        
        while(rindex<row && cindex>=0){
            int element=matrix[rindex][cindex];
            if(element==target) return true;
            else if(element<target) rindex++;
            else cindex--;
        }
        return false;
    }
}