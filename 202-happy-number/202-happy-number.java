class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> map=new HashMap<>();
        
        while(n!=1){
            int copy=n;
            int rev=0;
            while(copy!=0){
                rev+=Math.pow(copy%10, 2);
                copy/=10;
            }
            if(rev==1) return true;
            if(map.containsKey(rev)) return false;
            else map.put(rev, 1);
            n=rev;
        }
        return true;
    }
}