class Solution {
    public int[] searchRange(int[] nums, int target) {

        int [] buffer=BSearch(nums, target, 0, nums.length-1);
        if(buffer[0]==-1){
            return new int[]{-1, -1};
        }
        int first=buffer[0];
        int last=buffer[0];
        int end=buffer[2];

        
        while (true){
            buffer=BSearch(nums, target, buffer[1], first-1);

            if(buffer[0]==-1){
                break;
            }
            first=buffer[0];
            // buffer[0]=buffer[1];           
        }
        
        buffer[2]=end;
        
        while(true){
            buffer=BSearch(nums, target, last+1, buffer[2]);
            if(buffer[2]==-1){
                break;
            }
            last=buffer[0];
        }
        return new int[]{first, last};
    }
    
    public static int[] BSearch(int[] arr, int ele, int start, int end){        
        while(start<=end){
            int mid=start+((end-start)/2); 
            if (arr[mid]==ele){
                return (new int[]{mid, start, end});
            }
            else if(arr[mid]>ele){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return new int[]{-1, -1, -1};
    }
}