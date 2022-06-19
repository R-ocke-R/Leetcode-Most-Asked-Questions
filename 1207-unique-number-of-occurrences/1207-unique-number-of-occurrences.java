class Solution {
    public boolean uniqueOccurrences(int[] arr) {
//         most basic approach by storing the frequency of each element in HashMap
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], 1 + map.getOrDefault(arr[i], 0));
        }
        Set<Integer> set = new HashSet<Integer> (map.values());
        if(set.size()==map.size()){
            return true;
        }
        return false;
    
    }
    
}
// other approach:
// make array of 2000 size based on the constraints, now take frequency in the array, 
// now sort this array, 
// traverse the array and find out, if any adjacent element is the same.