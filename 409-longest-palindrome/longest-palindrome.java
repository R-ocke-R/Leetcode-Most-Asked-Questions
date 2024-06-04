class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[56];
        int n = s.length();

        for(int i = 0 ; i < n; i++){
            char at = s.charAt(i);
            if(Character.isUpperCase(at)){
                arr[at-65]++;
            }
            else{
                arr[at-71]++;
            }
        }
        int pali = 0;
        int flag = 0;
        for(int i = 0; i < 56; i++){
            if(flag == 0 && arr[i]%2!=0) flag = 1;
            pali += arr[i]/2;
        }
        System.out.println(Arrays.toString(arr));
        return pali*2 + flag;
    }
}