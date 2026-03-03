//207. Course Schedule (Medium)

class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0; i<numCourses; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            graph.get(pre[0]).add(pre[1]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }

        return true; 
    }

    public boolean dfs(int course){
        //cycle detection
        if(visited.contains(course)){ 
            return false;
        }
        //no prereq found, return true
        if(graph.get(course).isEmpty()){
            return true;
        }

        //mark the current course as visited
        visited.add(course);
        //check the prereqs recursively
        for(int i: graph.get(course)){
            if(!dfs(i)){
                return false;
            }
        }
        //remove from visited 
        visited.remove(course);
        //set as the course as no prereq (bcus they've been processed)
        graph.put(course, new ArrayList<>());
        return true; 
    }
}