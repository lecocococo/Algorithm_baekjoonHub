import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String, Integer> map;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            if (map.getOrDefault(temp, -1) == 1) {
                list.add(temp);
                // map.put(temp, map.get(temp)+1);
            }
        }

        list.sort(Comparator.naturalOrder());
        System.out.println(list.size());

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
