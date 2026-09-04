class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // Step 2: Create indegree array
        int[] indegree = new int[numCourses];
        // Step 3: Build graph
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
            indegree[course]++;
        }
        // Step 4: Add courses with indegree 0 to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // Step 5: Process courses
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completedCourses++;
            // Visit courses that depend on currentCourse
            for (int nextCourse : graph.get(currentCourse)) {
                indegree[nextCourse]--;
                // If all prerequisites are completed
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        // Step 6: If all courses are completed, no cycle exists
        return completedCourses == numCourses;
    }
}