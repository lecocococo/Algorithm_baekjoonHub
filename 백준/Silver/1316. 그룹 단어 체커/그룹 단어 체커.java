import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map ;
        int ans = 0;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            flag = true;
            map = new HashMap<>();
            String[] temp = br.readLine().split("");
            String p = temp[0];
            map.put(temp[0], 1);
            for (int j = 0; j < temp.length; j++) {
                if (!p.equals(temp[j])) {
                    p = temp[j];

                    if (!map.containsKey(temp[j])) {
                        map.put(temp[j], 1);

                    } else {
                        flag = false;

                        break;
                    }
                }
            }

            if(flag) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}