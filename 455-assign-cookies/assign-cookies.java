class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gg = 0, sg = 0; 
        while(gg < g.length && sg < s.length){
            if(g[gg] <= s[sg]) {count ++; gg++; sg++;}
            else sg++;
        }
        return count;
    }
}