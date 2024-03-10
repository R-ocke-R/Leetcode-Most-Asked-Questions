class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Approach 1 : Sort and Two Pointer O(nlogn+mlogm)TC
        // Approach 2 : Use Set Intersection -> retainAll() function java set1.retainAll(set2);
        // Approach 3 : Use Set and iterate to check with contains funtions.
        // 2,3 are simliar in TC and SC. both talking an average case TC of o(n+m) but can go to O(n*m) when load is high
        // note that this descrepancy is because lookup and retainall operation have an average case TC of O(1) but worst can increase
        // Appraoch 4: Use one Dictionary.
        Map<Integer, Boolean> seen = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        // put key, value pairs from nums1.
        for( int x : nums1){
            seen.put(x, true);
        }

        // check if x is in seen and also that its not a duplicate
        for(int x: nums2){
            if(seen.containsKey(x) && seen.get(x)){
                result.add(x);
                seen.put(x, false);
            }
        }
        // convert back to array.
        return result.stream().mapToInt(i->i).toArray();



    }
}