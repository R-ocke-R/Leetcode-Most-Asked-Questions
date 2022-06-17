import java.util.*;
public class Solution {
    public void setZeroes(int[][] matrix) {
        // int zerodha[][]= new int [matrix.length][matrix[0].length];
        // Queue<Integer> a= new LinkedList<>();
        // int[] m = new int[matrix.length];
        // int[] n= new int [matrix[0].length];
        boolean col= true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]==0){
                col=false;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }
        for (int i=matrix.length-1;i>=0;i--){
            for (int j= matrix[0].length-1;j>=1;j--){
                if (matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
                
            }
            if (col==false){
        matrix[i][0]=0;    
            }
        }
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         if(m[i]==1 || n[j]==1){
        //             matrix[i][j]=0;
        //         }
        //     }
        // }
        // System.out.println(matrix.length);
        
                    
                    // matrix[i][j]=-1;
                    // matrix[0][j]=-1;
//                     for (int k = 0;  k< matrix[i].length; k++) {
//                         if(matrix[i][k]!=0){
//                         matrix[i][k]=-1;}
                
//                     }
//                     for (int k = 0;  k< matrix.length; k++) {
//                         if(matrix[k][j]!=0){
//                         matrix[k][j]=-1;}
//                     } 
                                
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         if(matrix[i][j]==-1){
        //             matrix[i][j]=0;
        //         }
        //     }
        // }
    }
}