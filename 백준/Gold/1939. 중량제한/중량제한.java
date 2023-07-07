import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//mst문제
public class Main {
    static int N;
    static int M;
    static PriorityQueue<Edge> pq;
    static boolean[] visited;

    static int[] parent;
    static int[] rank;

    static int start;
    static int end;

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }


        @Override
        public int compareTo(Edge e) {
            return -Integer.compare(this.w, e.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(A > B) {
                int temp=A;
                A = B;
                B = temp;
            }
            pq.add(new Edge(A, B, C));

        }
        parent = new int[N + 1];
        rank = new int[N + 1];
        init();
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        if(start > end) {
            int temp=start;
            start = end;
            end = temp;
        }


        kruskal(start);

    }

    static void kruskal(int a) {
        int cnt = 0;
        while(!pq.isEmpty()) {
            if (cnt == N -1) {
                return;
            }
            Edge edge = pq.poll();
            int s = edge.s;
            int e= edge.e;
            int weight = edge.w;

//            System.out.println("start = " + s);
//            System.out.println("end = " + e);
//            System.out.println("weight = " + weight);
//            System.out.println();

            if (union(s, e)){
                
                if (find(start) == find(end)) {
                    System.out.println(weight);
                    return;
                }

                
                cnt++;
            }


        }
    }

    static void init() {
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if(x == y){
            return false;
        }

        if (rank[x] < rank[y]){
            rank[y] += rank[x];
            parent[x] = y;
        } else if (rank[x] > rank[y]){
            rank[x] += rank[y];
            parent[y] = x;
        } else {
            rank[x] += rank[y];
            parent[y] = x;
        }
        return true;
    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}