import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;

    static List<List<Integer>> g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] temp = br.readLine().split(" ");
        g = new ArrayList<>();


        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        for(int i = 0;i <= N;i++) {
            g.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for (int j = 1; j < num; j++) {
                int singer = Integer.parseInt(st.nextToken());
                g.get(before).add(singer);
                indegree[singer]++;

                before = singer;
            }
        }

        List<Integer> answer = topologicalSort(indegree);
        StringBuilder sb = new StringBuilder();

        if (answer.size() != N) {
            sb.append("0");
        } else {
            for (int i = 0; i < answer.size(); i++) {
                sb.append(answer.get(i)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static List<Integer> topologicalSort(int[] indegree){

        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 1;i < N + 1; i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int n = q.poll();

            res.add(n);

            List<Integer> list = g.get(n);

            for (int next : list) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

//        System.out.println(res);
        return res;
    }
}
