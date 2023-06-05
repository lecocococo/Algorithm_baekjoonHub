import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Map<String, Integer> ans = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] temp= br.readLine().split("\\.");
            if (ans.containsKey(temp[1])) {
                ans.put(temp[1], ans.get(temp[1]) + 1);
            } else {
                ans.put(temp[1], 1);
            }
        }

        List<String> ks = new ArrayList<>(ans.keySet());

        Collections.sort(ks, (s1, s2) -> {
            return s1.compareTo(s2);
        });

        StringBuilder sb = new StringBuilder();
        for (String e : ks) {
            sb.append(e).append(" ").append(ans.get(e)).append("\n");
        }
        System.out.println(sb);

    }
}