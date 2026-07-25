class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visit = new HashSet<>();

        for(int i=0; i <numCourses;i++ ){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            preMap.get(pair[0]).add(pair[1]);
        }

        for(int c = 0; c < numCourses ; c++){
            if(!dfs(c, preMap, visit)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int crs, HashMap<Integer, List<Integer>> preMap, 
    Set<Integer> visit){
        if(visit.contains(crs)){
            return false;
        }
        if(preMap.get(crs).isEmpty()){
            return true;
        }
        visit.add(crs);

        for(int c : preMap.get(crs)){
            if(!dfs(c, preMap, visit)){
                return false;
            }
        }
        visit.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}
