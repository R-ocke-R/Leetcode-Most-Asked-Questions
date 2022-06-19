class Solution {
//     public boolean uniqueOccurrences(int[] arr) {
// //         most basic approach by storing the frequency of each element in HashMap
//         HashMap<Integer, Integer> map= new HashMap<>();
//         for(int i=0;i<arr.length;i++){
//             map.put(arr[i], 1 + map.getOrDefault(arr[0], 0));
//         }
//         Set<Integer> set = new HashSet<Integer> (map.values());
//         if(set.size()==map.size()){
//             return true;
//         }
//         return false;
    
//     }
    public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int a : arr)
        count.put(a, 1 + count.getOrDefault(a, 0));
    return count.size() == new HashSet<>(count.values()).size();
}
}
// other approach:
// make array of 2000 size based on the constraints, now take frequency in the array, 
// now sort this array, 
// traverse the array and find out, if any adjacent element is the same.