class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        //idea is to run a simulation
        int row=arr.length;
        int col=arr[0].length;
        List<Integer> ans= new ArrayList<>();
        
        //using the below two variables is pretty cool logic.
        //can be used with more questions.
        int count=0;
        int total=row*col;

        int firstRow=0;
        int firstCol=0;
        int lastRow=row-1;
        int lastCol=col-1;


        while(count < total){
            for (int index = firstCol; count<total && index <= lastCol; index++) {
                // System.out.print(arr[firstRow][index]+" ");
                ans.add(arr[firstRow][index]);
                count++;
            }
            firstRow++;

            for (int index = firstRow; count<total && index <= lastRow; index++) {
                // System.out.print(arr[index][lastCol]+" ");
                ans.add(arr[index][lastCol]);
                count++;
            }
            lastCol--;
            for (int index = lastCol; count<total && index >= firstCol; index--) {
                // System.out.print(arr[lastRow][index]+" ");
                ans.add(arr[lastRow][index]);
                count++;
            }
            lastRow--;
            for (int index = lastRow; count<total && index >= firstRow; index--) {
                System.out.print(arr[index][firstCol]+" ");
                ans.add(arr[index][firstCol]);
                count++;
            }
            firstCol++;
        }       
        
    return ans;
    }
}