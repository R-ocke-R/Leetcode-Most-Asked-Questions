class Solution {
    public int minOperations(String[] logs) {
        //Stack<Integer> stack = new Stack<>();
        int levels = 0;
        int n = logs.length;

        for(int i = 0; i< n; i++){
            String action = logs[i];
            if(action.equals("../")){
                if(levels == 0) continue;
                levels --;
            }
            else if(action.equals("./")){
                continue;
            }
            else{
                levels++;
            }
        }

        return levels;
    }
}