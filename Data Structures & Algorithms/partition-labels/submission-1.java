class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> count = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        int i = 0, length = s.length();
        for(int j=0;j<length;j++){
            char c = s.charAt(j);
            count.put(c, j); // have last occ of every char
        }

        int curLen = 0;
        int goal = 0;
        while(i < length){
            char c = s.charAt(i);
            goal = Math.max(goal, count.get(c));
            curLen++;

            if(goal == i){ // 1 partition done
                res.add(curLen);
                curLen = 0; // reset len for next partition
                // end will be updated anyway
            }
            i++;
        }
        return res;
    }
}
