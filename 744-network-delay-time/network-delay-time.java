import java.util.*;
  
class Solution {
    static class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] arr : times) {
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];
            adj.get(u).add(new Pair(v, w)); 
        }

        int[] dist = new int[n + 1];
       	Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time)); 
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int node = curr.node;
            int d = curr.time;

            if (d > dist[node]) continue;

            for (Pair adjPair : adj.get(node)) {
                int newDist = d + adjPair.time;

                if (newDist < dist[adjPair.node]) {
                    dist[adjPair.node] = newDist;
                    pq.offer(new Pair(adjPair.node, newDist)); 
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}
