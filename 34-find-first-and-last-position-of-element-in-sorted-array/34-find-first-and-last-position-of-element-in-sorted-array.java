class Solution {
//     public int[] BinarySearch(int s, int e, int[] nums, int target){
//         int mid=s+((e-s)/2);
        
//         while(s<=e){
//             if(nums[mid]==target){
//                 return new int[]{mid, s, e};
//             }
//             else if(nums[mid]>target){
//                 e=mid-1;
//             }
//             else{
//                 s=mid+1;
                
//             }
//             mid=s+((e-s)/2);
    
//         }return new int[]{-1, -1, -1}; 
//     }
//     public int[] searchRange(int[] nums, int target) {
//         if (nums.length==0){
//             return new int[]{-1, -1};
//         }
        
//         int s=0;
//         int e=nums.length-1;
//         int [] dummy=BinarySearch(0 ,e, nums, target);
//         if(dummy[0]==-1){
//             return new int[]{-1, -1};
//         }
//         int first=dummy[0];
//         int last=dummy[0];
//         int end=dummy[2];
// //         for first
//         while(true){
//             dummy=BinarySearch(dummy[1], first-1, nums, target);
//             if(dummy[0]==-1){
//                 break;
//             }
//             first=dummy[0];            
//         }
//         // System.out.println(first);
//         // return new int[]{-2, -1};
//         dummy[2]=end;
//         while(true){
//             dummy=BinarySearch(last+1, dummy[2], nums, target);
//             if(dummy[0]==-1){
//                 break;
//             }
//             // first=dummy[0];
//             last=dummy[0];
//         }
//         // System.out.println(last);
//         return new int[]{first, last};
        // return new int[]{-2, -1};
    public int[] modifiedBS(int[] arr, int s, int e, int ele){
        int mid=s+(e-s)/2;
        while(s<=e){
            if(arr[mid]==ele){
                return new int[]{s,mid,e};
            }
            else if (arr[mid]>ele){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
            mid=s+(e-s)/2;
        }
        return new int[]{-1, -1, -1};
    }
    public int[] searchRange(int[] nums, int target){
        // return modifiedBS(nums, 0, nums.length-1, target);
        int[] caller=modifiedBS(nums, 0, nums.length-1, target);
        int first=caller[1];
        int last=caller[1];
        int end=caller[2];
        
        
        //for front value, caller goes from start to mid until element not found, if it wasn't there loop not called
        while(caller[1]!=-1){
            first=caller[1];
            caller=modifiedBS(nums, caller[0], caller[1]-1, target);
        }
        
        //set value back to caller from saved variables.
        caller[1]=last;
        caller[2]=end;
        while(caller[1]!=-1){
            last=caller[1];
            caller=modifiedBS(nums, caller[1]+1, caller[2], target);
        }
        
        caller= new int[] {first, last};
        return caller;
        
    }
    



























}