class Solution {
    public List<List<Integer>> generate(int numRows) {
        /** There are a bunch of variation to this question, some asking to print x row only some to return only 
        the element at x row y col, and one is this one.  
        
        the other two approaches are discussed in pascal triangle question 2 : 119 .
        */
        return Approach1(numRows);
    }
    public List<List<Integer>> Approach1(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> first = new ArrayList<>();

        first.add(1);
        triangle.add(first);

        for(int i =1; i< numRows; i++){
            List<Integer> current = new ArrayList<>();
            List<Integer> previous = triangle.get(i-1);
            current.add(1);
            for(int j=1; j < i; j++){
                current.add(previous.get(j-1)+previous.get(j));
            }
            current.add(1);
            triangle.add(current);
        }
        return triangle;
    }
}

