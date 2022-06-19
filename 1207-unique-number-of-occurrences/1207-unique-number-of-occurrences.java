class Solution {
    public boolean uniqueOccurrences(int[] arr) {
//         most basic approach
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int valu=map.remove(arr[i]);
                valu++;
                // System.out.println(valu);
                map.put(arr[i],(valu));
                // System.out.println(map.get(arr[i]));
            }
            else{
            map.put(arr[i], 1);
            }
        }
        // for (Map.Entry<Integer, Integer> e : map.entrySet()){
        Set<Integer> set = new HashSet<Integer> (map.values());
        if(set.size()==map.size()){
            return true;
        }
        return false;
    
    }
}