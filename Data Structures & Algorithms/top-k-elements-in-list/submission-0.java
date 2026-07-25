class Solution {

    // n logn
    // k logn

    // bucket sort - O(n)
    // i - count- 0,1,2,3,4 .. len(n) [coz any element can't occr more than length]
    // values.  -   4   5
    // if input - 1,2,3,4,5,6 then all in 1's place then also O(n) -> n+n

    //O(n), O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for(int i=0;i<freq.length ;i++){
            freq[i] = new ArrayList<>();
        }
        for(int num : nums){
            count.put(num, count.getOrDefault(num,0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = freq.length-1 ;i > 0 && index < k;i-- ){
            for(int n : freq[i]){
                res[index++] = n;
            }
            if(index == k){
                return res;
            }
        }
        return res;
    }
}
