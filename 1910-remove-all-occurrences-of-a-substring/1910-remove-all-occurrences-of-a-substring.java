class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb= new StringBuilder();
        int ps=part.length();
        for(int i=0; i<s.length(); i++){
            sb.append(s.charAt(i));
            
            if(sb.length()>=ps && sb.substring(sb.length()-ps).equals(part)){
                sb.setLength(sb.length()-ps);
            }
        }
         return sb.toString();      
            
        
        
    }
}