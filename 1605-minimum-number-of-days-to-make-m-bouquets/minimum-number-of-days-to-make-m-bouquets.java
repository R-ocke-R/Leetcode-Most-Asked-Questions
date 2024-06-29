class Solution {
    public boolean bloom(int[] bloomDay, int m, int k, int Day){
        int bouquets= 0;
        for(int i = 0; i < bloomDay.length - k+1; i++){
            int flowers = 0;
            for(int j = i; j < i+k; j++){
                if(bloomDay[j] <= Day){
                    // I have a bloomed flower 
                    flowers ++;
                }
            }
            // check if flowers == k
            if(flowers==k) {
                bouquets ++;
                i += k-1; // skip the picked flowers. 
            }

            if(bouquets==m) return true;
        }
        return false;
    }
    public boolean boom(int[] bloomDay, int m, int k, int Day){
        int bouquets = 0;
        int count = 0;
        for(int i =0; i < bloomDay.length; i++){
            if(bloomDay[i] <= Day) count ++;
            else {
                count = 0;
            }
            if(count == k ) {
                bouquets ++;
                count = 0;
            }
            if(bouquets >=m) return true;
        }
        if(bouquets >=m ) return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;
        if(k*m > n) return -1;

        int start = 1;
        int end = Arrays.stream(bloomDay).max().getAsInt();
        int answer = -1; // return the minimum number of days
        while(start <= end) {
            int mid = start + (end - start)/2;
            //System.out.println(mid);
            if(boom(bloomDay, m, k, mid)){
                answer = mid;
                end = mid-1;
                
            }
            else {
                start = mid+1;
            }

        }

        return answer;

    }
}