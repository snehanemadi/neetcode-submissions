class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        List<Integer> output = new ArrayList<>();

        for(int[] pre : prerequisites){
            prereq.computeIfAbsent(pre[0], k-> new ArrayList<>()).add(pre[1]);
        }

        for(int c = 0; c < numCourses ; c++){
            if(!dfs(c, prereq, visit, output, cycle)){
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for(int i = 0 ;i < numCourses ;i++){
            result[i] = output.get(i);
        }
        return result;
    }

    public boolean dfs(int c, Map<Integer, List<Integer>> prereq, 
                Set<Integer> visit, List<Integer> output, Set<Integer> cycle){
                    if(cycle.contains(c)){
                        return false;
                    }
                    if(visit.contains(c)){
                        return true;
                    }
                    cycle.add(c);
                    for(int pre : prereq.getOrDefault(c, Collections.emptyList())){
                        if(!dfs(pre, prereq, visit, output, cycle)){
                            return false;
                        }
                    }
                    cycle.remove(c);
                    visit.add(c);
                    output.add(c);
                    return true;

                }
}
