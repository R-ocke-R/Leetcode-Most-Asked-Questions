class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans= new ArrayList<>();
        int ss=0;
        List<Integer> temp= new ArrayList<>();
        ans.add(new ArrayList<Integer>(){
            {add(1);}
        });
        ss++;
        if (numRows==1){
            return ans;
        }
        ans.add(new ArrayList<>(){
            {add(1);add(1);}
        });
        ss++;
        if(numRows==2){
            return ans;
        }
        
        
        while(ss!=numRows){
            temp=ans.get(ss-1);
            ss++;
            int i=0;
            int j=1;
            List<Integer> tt=new ArrayList<>(){
                {add(1);}
            };
            while(j!=ss-1){
                int summ=temp.get(i)+temp.get(j);
                j++;
                i++;
                tt.add(summ);
            }
            tt.add(1);
        ans.add(tt);
        }
        
        return ans;
    }
}