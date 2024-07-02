class Solution {
    public int[] intersectHashMap(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) return intersect(nums2, nums1);
        int n = nums1.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            // update frequency of nums1.
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }

        // int[] common = new int[] can't directly create a arry since we don't know the size
        ArrayList<Integer> common = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++){
            if(map.getOrDefault(nums2[i], 0) > 0 ){
                map.put(nums2[i], map.get(nums2[i])-1);
                common.add(nums2[i]);
                
            }
        }
        
        return common.stream().mapToInt(i -> i).toArray();
    }
    public int[] intersect(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]) ++i;
            else if (nums1[i] > nums2[j]) ++j;
            else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        // int[] smallerArray = Arrays.copyOfRange(originalArray, start, end);
        return Arrays.copyOfRange(nums1, 0, k);

    }
}
/**
set intersection
Hashmap O(n) space
2 Pointer  TC O(n+m) SP O(1) but sorting then O(nlogn + mlogm)
 */