class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer= new ArrayList<>();
        
        int row=matrix.length;
        int col=matrix[0].length;
        
        int count=0;
        int total=row*col;
        
        int firstRow=0;
        int lastRow=row-1;
        
        int firstCol=0;
        int lastCol=col-1;
        int j=0;
        
        while(count<total){
            
            // firstrow
            j=firstCol;
            while(count<total && j<=lastCol){
                answer.add(matrix[firstRow][j]);
                count++; j++;
            }
            firstRow++;
            
            // lastcol
            j=firstRow;
            while(count<total && j<=lastRow){
                answer.add(matrix[j][lastCol]);
                count++; j++;
            }
            lastCol--;     
            
            // last row (rev)
            j=lastCol;
            while(count<total && j>=firstCol){
                answer.add(matrix[lastRow][j]);
                count++; j--;
            }
            lastRow--;
            //first col (rev)
            j=lastRow;
            while(count<total && j>=firstRow){
                answer.add(matrix[j][firstCol]);
                count++;
                j--;
            }
            firstCol++;
            
        }
        return answer;
    }
}