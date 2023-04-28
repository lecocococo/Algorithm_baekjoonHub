import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int N;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] t = br.readLine().toCharArray();
        map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i, 0);
        }
//        System.out.println(map);

        for (char c : t) {
            int num  = c - '0';
            map.put(num, map.get(num) + 1);
        }
//        System.out.println(map);

        // 6 과 9 미리처리
        int temp  = (int) Math.ceil((map.get(6) + map.get(9))/2d);

        int max  = temp;
        for (int i = 0; i < 10; i++) {
            if (i != 6 && i != 9) {
                max = Math.max(max, map.get(i));
            }
        }

        System.out.println(max);
    }
}