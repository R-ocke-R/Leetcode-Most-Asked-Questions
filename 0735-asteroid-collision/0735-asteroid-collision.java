class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){
            if(asteroid > 0) stack.push(asteroid);
            
            else{
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) < Math.abs(asteroid)){
                    stack.pop();
                }
                if(stack.isEmpty()|| stack.peek() <0) stack.push(asteroid);
                else if(stack.peek() == Math.abs(asteroid)) stack.pop();
            }
        }        
        int[] output = new int[stack.size()];
        for(int i = output.length-1; i>=0 ; i--){
            output[i]=stack.pop();
        }
        return output;
    }
}

/*
if two consequetive are positive, then skip them.

if one pos one neg then they will collide:      1. bigger survive  2.both die
index --;

// if the two elements are different directions, then that's 
// else case is that both lie in oppposite spectrums 
// but if first is negative and second is positive then also they will never 


*/