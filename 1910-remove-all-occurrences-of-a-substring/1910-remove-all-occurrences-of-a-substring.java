class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb= new StringBuilder();
        int ps=part.length();
        int pl=0;
        for(int i=0; i<s.length(); i++){
            sb.append(s.charAt(i));
            pl++;
            
            if(pl>=ps && sb.substring(pl-ps).equals(part)){
                sb.setLength(pl-ps);pl-=ps;
            }
        }
         return sb.toString();      
            
        
        
    }
}