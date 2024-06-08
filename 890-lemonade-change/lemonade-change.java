class Solution {
    public boolean lemonadeChange(int[] bills) {
        // int[] notes = new int[2]; // each index denotes the number of 5, 10, 20 notes respectively.
        int five = 0;
        int tens = 0;
        int n = bills.length;
        for(int i = 0; i < n; i++){
            int note = bills[i];
            if(note == 20){
                if(tens > 0 && five > 0) {
                    tens --;
                    five --;
                }
                else if(five > 2) {
                    five -= 3;
                }
                else return false;
            }
            else if (note == 10){
                if(five == 0) return false;
                five --;
                tens ++;
            }
            else {
                five ++;
            }
        }
        return true;
    }
}