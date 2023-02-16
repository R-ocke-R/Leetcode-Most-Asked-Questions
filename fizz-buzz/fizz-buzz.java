class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer= new ArrayList<>();
        int i=1;
        while(n+1!=i){
            if(i%5==0 && i%3==0) answer.add("FizzBuzz");
            else if(i%5==0) answer.add("Buzz");
            else if(i%3==0) answer.add("Fizz");
            else answer.add(Integer.toString(i));
            i++;
        }
        return answer;
    }
}