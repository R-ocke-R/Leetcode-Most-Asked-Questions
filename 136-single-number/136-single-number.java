// better approach o(n^2) complexity, constant extra space. 
class Solution {
    public int singleNumber(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(freq(arr, arr[i] )){
                return arr[i];
            }
        } return arr[0];
    }
    public static boolean freq(int[] arr, int n){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==n){
            count++;
            }
        }
        if (count==2){
            return false;
        }
        return true;
}
}