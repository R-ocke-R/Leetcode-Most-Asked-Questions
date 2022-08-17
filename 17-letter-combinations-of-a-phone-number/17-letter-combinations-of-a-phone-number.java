class Solution {
    
    public static void hashmap(HashMap<Character, String> map){
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        return;
        
    }
    
    public static void answer(int count, String digits, String dum, HashMap<Character, String> map, ArrayList<String> combinations){
        //using count we have to take strings from map and add to dum.
        //final strings are created only when count==digits.length
        if(count==digits.length()){
            combinations.add(dum);
            return;
        }
        //for the given count, take all the elements of the given index.
        String valid=map.get(digits.charAt(count));;
        for (int i = 0; i < valid.length(); i++) {
            // for (String string : valid.toCharArray()) {
                dum+=valid.charAt(i);
                answer(count+1, digits, dum, map, combinations);
                dum=dum.substring(0, dum.length()-1);
    
            }
        
    
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        HashMap<Character, String> map=new HashMap<>();
        hashmap(map);
        ArrayList<String> combinations=new ArrayList<>();
        answer(0, digits, new String(), map, combinations);
        return combinations;
    }
}