package Leetcode.Graph;
import java.util.*;

public class CourseScheduleII{
  public int[] findOrder(int numCourses, int[][] prerequisites) {
      Map<Integer, List<Integer>> adj = new HashMap<>();
      int[] indegree = new int[numCourses];
      int[] ans = new int[numCourses];
      for(int[] edge : prerequisites){
          int dst = edge[0];
          int src = edge[1];
          List<Integer> dsts = adj.getOrDefault(src, new ArrayList<>());
          dsts.add(dst);
          adj.put(src, dsts);
          indegree[dst]++;
      }

      Queue<Integer> q = new LinkedList<>();
      for(int i = 0; i < numCourses; i++){
          if(indegree[i] == 0){
              q.add(i);
          }
      }

      int i = 0;
      while(!q.isEmpty()){
          int node = q.remove();
          ans[i++] = node;
          if(adj.containsKey(node)){
              for(int neighbour : adj.get(node)){
                  indegree[neighbour]--;
                  if(indegree[neighbour] == 0){
                      q.add(neighbour);
                  }
              }
          }
      }
      if(i == numCourses){
          return ans;
      }
      return new int[0];
  }
}