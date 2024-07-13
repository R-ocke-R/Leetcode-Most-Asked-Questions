class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        // Integer[] mapping = new Integer[n];
        // for(int i = 0; i < n; i++){
        //     mapping[positions[i]]= i;
        //     // mapping index to corresponding
        // }
        // mapping poisitons[i] with i and then sorting i will not work here
        // becuase positions aren't from 0 to n so out of bounds. so either use hashmap or 
        // map indexes and sort them based on the positions as below - this is also  a cool method.

        Integer[] mapping = new Integer[n];
        for(int i = 0; i< n; i++){
            mapping[i] = i;
        }
        Arrays.sort(mapping, (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs]));


        for(int index : mapping){
            if(directions.charAt(index)=='R'){
                stack.push(index);
            }
            else{
                while(!stack.isEmpty() && healths[index] > 0){
                    int topIndex = stack.pop();

                    if (healths[topIndex] > healths[index]) {
                        healths[topIndex] -= 1;
                        healths[index] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[index]) {
                        // Current robot survives, top robot is destroyed
                        healths[index] -= 1;
                        healths[topIndex] = 0;
                        // here we don't add stuff on the stack 
                        // because the left moving robot will keep killing the existing or get killed
                        // we don't leave it hanging with the right moving robots in stack
                    } else {
                        // Both robots are destroyed
                        healths[index] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }
        for(int i = 0; i< n; i++){
            if(healths[i] > 0){
                result.add(healths[i]);
            }
        }
        return result;
    }
}

// updating health array gives us a great flexibility and also caters the case where robots are 
// moving left left until infinity -> so no collision there -> so no health update. nice