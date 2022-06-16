import java.util.*;
public class Solution {
    public void setZeroes(int[][] matrix) {
        // int zerodha[][]= new int [matrix.length][matrix[0].length];
        Queue<Integer> a= new LinkedList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    a.add(i);
                    a.add(j);

                
                }

                
            }
        }
        
        while(a.size()!=0){
            int i=a.poll();
            int j= a.poll();
            for (int k = 0;  k< matrix[0].length; k++) {
                matrix[i][k]=0;
                
            }
            for (int k = 0;  k< matrix.length; k++) {
                matrix[k][j]=0;
                
            }
        }
        for (int i=0;i<matrix.length;i++){
        System.out.println(Arrays.toString(matrix[i]));
        }
        
        
    }
}