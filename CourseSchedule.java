public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int length = prerequisites.length;
        for(int i=0; i<length; i++) {
            List<Integer> nextCourses = map.get(prerequisites[i][1]);
            nextCourses = (nextCourses != null) ? nextCourses : new ArrayList<>();
            nextCourses.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], nextCourses);
        }
        
        int[] visited = new int[numCourses];
        Arrays.fill(visited, 0);
        for(int i=0; i<numCourses; i++) {
            if(!canFinish(map, i, visited)) return false;
        }
        return true;
    }
    private boolean canFinish(Map<Integer, List<Integer>> map, int course, int[] visited) {
        if(visited[course] == 1) return false;
        if(visited[course] == 2) return true;
        List<Integer> nextCourses = map.get(course);
        if(nextCourses == null || nextCourses.isEmpty()) {
            visited[course] = 2;
            return true;
        }
        visited[course] = 1;
        for(Integer nextCourse : nextCourses) {
            if(!canFinish(map, nextCourse, visited)) return false;
        }
        visited[course] = 2;
        return true;
    }
}