class Solution {
    //O(node + prereq)
    // how to detect cycle
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visit = new HashSet<>();

        for(int i=0; i < numCourses ;i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            preMap.get(pair[0]).add(pair[1]);
        }

        for(int c = 0 ; c < numCourses ; c++){ // call for every single course
            if(!dfs(c, preMap, visit)){ // if any 1 of DFS on any node returns false return false
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int c, HashMap<Integer, List<Integer>> preMap, 
                        Set<Integer>visit){
        if(visit.contains(c)){
            return false;
        }
        if(preMap.get(c).isEmpty()){
            return true;
        }

        visit.add(c);
        for(int pre : preMap.get(c)){
            if(!dfs(pre, preMap, visit)){
                return false;
            }
        }
        //course can be taken
        visit.remove(c); // remove already visited
        preMap.put(c, new ArrayList<>()); // set to empty //if run DFS again then 2nd condition will execute

        return true;
    }
}
