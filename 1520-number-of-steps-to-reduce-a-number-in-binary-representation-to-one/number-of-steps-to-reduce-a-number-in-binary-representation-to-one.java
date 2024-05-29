class Solution {
    public int numSteps(String s) {
        int carry = 0;

        int n = s.length();
        int operations = 0;

        for(int i = n - 1 ; i > 0; i--){
            int digit = Character.getNumericValue(s.charAt(i)) + carry;
            if(digit % 2 == 1){
                carry = 1;
                operations += 2;
            }
            else {
                operations ++;
            }
        }

        return operations + carry;
    }
}

