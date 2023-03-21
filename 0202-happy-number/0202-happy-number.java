class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set= new HashSet<>();
        
        
        while(n!=1){
            int copy=n;
            int two=0;
            while(copy!=0){
                two+=(copy%10)*(copy%10);
                copy=copy/10;
            }
            if(set.contains(two)) return false;
            else set.add(two);
            
            n=two;
        }
        // System.out.println(set);
        return true;
    }
}