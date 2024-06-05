class Solution {
    public List<String> commonChars(String[] words) {
        int[] mainArr = null;
        int[] smallArr = new int[26];

        int n = words.length;

        for(String str : words){
            smallArr = new int[26];
            for(int i = 0; i < str.length(); i++){
                smallArr[str.charAt(i)-97] ++;
            }
            if(mainArr == null) mainArr = smallArr;
            else{
                for(int i = 0; i < 26; i++){
                    mainArr[i] = Math.min(mainArr[i], smallArr[i]);
                }
            }
            
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(mainArr[i]!=0){
                int freq = mainArr[i];
                String ch = Character.toString((char) ('a'+i));
                while(freq != 0){
                    ans.add(ch); freq --;
                }
            }
        }
        return ans;
    }
}



/** Would have been a piece of cake without the duplicates thing.  */