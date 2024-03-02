// class Solution {
//     public String maximumOddBinaryNumber(String s) {
//         int n = Integer.valueOf(s);
//         int ones = -1;
//         int digits =0;
//         while(n!=0){
//             if(n%10==1) ones ++;
//             digits++;
//             n/=10;
//         }
//         // Now that you have the number of ones in the string. 
//         // create the maximum possible odd number.
//         if(ones+1==digits){
//             return s;
//         }
//         if(ones!=0){
//             int finaldigit = 0;
//             for(int i=0;i<ones;i++){
//                 finaldigit=(finaldigit+1)*10;
//             }
//             for(int i=ones; i<digits;i++){
//                 finaldigit*=10;
//             }
//             finaldigit++;
//             // System.out.println("helllo");
//             return Integer.toString(finaldigit);
//             }

//         else{
//             s = s.replace("1", "0");
//             s= s.substring(0, s.length()-1)+"1";
//             return s;
//             }
//     }
// }
class Solution {
    public String maximumOddBinaryNumberSorting(String s) {
        char[] arr = s.toCharArray();
        int N = arr.length;

        Arrays.sort(arr);

        // reverse the order till n-2 index
        int twoLast = N - 2;
        for (int i = 0; i < N / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[twoLast];
            arr[twoLast] = temp;
            twoLast--;
        }
        return new String(arr);

    }
    public String maximumOddBinaryNumber(String s){
        char[] arr = s.toCharArray();
        int n = arr.length;

        int left =0;
        int right = n-1;
        while(left <= right){
            while(left <= right && arr[left]!='0'){
                left ++;
            }
            while(left<= right && arr[right]!='1' ){
                right --;
            }
            //swap
            if(left<=right && arr[left]=='0' && arr[right] == '1'){
                arr[left]='1';
                arr[right]='0';
            }
        }
        arr[left - 1] = '0';
        arr[n - 1] = '1';
        return new String(arr);
    }
}
