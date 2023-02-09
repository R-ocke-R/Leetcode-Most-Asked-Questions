class Solution {
    public static int[] convertIntegers(List<Integer> integers)
    {
    int[] ret = new int[integers.size()];
    for (int i=0; i < ret.length; i++)
    {
        ret[i] = integers.get(i).intValue();
    }
    return ret;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        //approach 1 using hashmap to store frequency of the smaller array
        HashMap<Integer, Integer> map= new HashMap<>();
        //taking the smaller array in nums1;
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2){
            int[] temp=nums2;
            nums2=nums1;
            nums1=temp;
            int t=n1;
            n1=n2;
            n2=t;
        }
        //storing frequency
        for(int i=0;i<n1;i++){
            map.put(nums1[i], 1);
        }
        // iterate through the values in nums2; while maintaining ans array
        ArrayList<Integer> ans=new ArrayList<>();
        // System.out.println(Arrays.toString(nums1));
        for(int i=0;i<n2;i++){
            int values=map.getOrDefault(nums2[i], 0);
            if(values !=0){
                ans.add(nums2[i]);
                map.put(nums2[i], 0);
            }
        }
        
        return convertIntegers(ans);
    }
}