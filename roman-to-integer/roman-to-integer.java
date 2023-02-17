// class Solution {
//     public int romanToInt(String s) {
//         int answer=0;
//         int n=s.length();
//         Map<Character, Integer> map= new HashMap<>();
//         // map.add(Character.valueOf('I'), Integer.valueOf(1));
//         map.add('V', 5);
//         map.add('X', 10);
//         map.add('L', 50);
//         map.add('C', 100);
//         map.add('D', 500);
//         map.add('M', 1000);
//         for(int i=0;i<n;i++){
//             // char ch=s.charAt(i);
//             int val=map.get(s.charAt(i));
//             // if(i+1 != n) char next=s.charAt(i+1);
//             // char next=s.charAt(i+1);
//             if(i!=n-1){
//                 int val2=map.get(s.charAt(i+1));
//                 if(val2>val) {
//                     answer+=val2-val;
//                     i++;
//                 }
//                 else answer+=val;
//             }
//         }
//         return answer;
//     }
// }
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result=0;
        for (int i=0;i<s.length();i++) {
            int first=map.get(s.charAt(i));
            if (i==s.length()-1) 
                result=result+first;
            else{
                int second=map.get(s.charAt(i+1));
                if(first>=second) 
                    result=result+first; 
                else {
                    result=result+(second-first);
                    i++;
                }
            }
        }
        return result;
    }
}