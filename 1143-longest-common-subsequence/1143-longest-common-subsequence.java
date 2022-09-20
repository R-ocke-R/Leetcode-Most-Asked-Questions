class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] temp=new int[text1.length()+1][text2.length()+1];
        
        //convert string to char array
        char[] str1=text1.toCharArray();
        char[] str2=text2.toCharArray();
        
        for(int i=1;i<temp.length;i++){
            for(int j=1;j<temp[i].length;j++){
                if(str1[i-1]==str2[j-1]){
                    temp[i][j]= temp[i-1][j-1]+1;
                }
                else{
                    temp[i][j]=Math.max(temp[i][j-1], temp[i-1][j]);
                }
                
            }
        }
        return temp[text1.length()][text2.length()];
    }
}


//knapsack dp solution is somthing like this.