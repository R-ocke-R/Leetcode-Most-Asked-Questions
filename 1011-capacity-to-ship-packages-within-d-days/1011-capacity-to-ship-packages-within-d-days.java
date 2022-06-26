class Solution {
    public static boolean ship(int mid, int[] arr, int days){
        int weight=0;
        int boat=1;
        for(int i=0;i < arr.length;i++){
            if(weight+arr[i]<=mid){
                weight+=arr[i];
                
            }
            else{
                boat+=1;
                if(boat>days || arr[i]>mid){
                    return false;
                }
                weight=arr[i];
            }
                        
        }
        return true;
    }
    public int shipWithinDays(int[] arr, int days) {
        int s=0; int e=0;
        for( int i=0; i<arr.length;i++){
            e+=arr[i];
        }
        int mid=s+(e-s)/2;
        while(s<=e){
            if (ship(mid, arr, days)){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
            mid=s+((e-s)/2);
        }
        return s;
    }
}