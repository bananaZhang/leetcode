package leetcode;

import java.util.*;

/**
 * 课程表
 * 拓扑排序
 * @author: ZJY
 * @date: 2022/5/28 10:46 上午
 */
public class Leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 记录每门课程的入度
        int[] dependencyArr = new int[numCourses];
        // 建立课程依赖关系图，key-需要先上的课程
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
            dependencyArr[prerequisite[0]]++;
        }
        // 入度为0的课程入队
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (dependencyArr[i] == 0) {
                queue.offer(i);
            }
        }
        // 已选课程数
        int count = 0;
        // 已选课程数组
        int[] visited = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            visited[course] = 1;
            List<Integer> canStudyList = map.get(course);
            if (canStudyList != null && canStudyList.size() > 0) {
                for (Integer canStudyCourse : canStudyList) {
                    dependencyArr[canStudyCourse]--;
                    // 入度为0的再次入队
                    if (visited[canStudyCourse] == 0 && dependencyArr[canStudyCourse] == 0) {
                        queue.offer(canStudyCourse);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,4}, {2,4}, {3,1}, {3,2}};
        System.out.println(new Leetcode207().canFinish(5, prerequisites));
    }
}
