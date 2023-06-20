import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<Integer> list;
    static int[] temp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int num = minimum(a, b, c, d);

        list = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        int temp = minimum(i, j, k, l);
                        list.add(temp);
                    }
                }
            }
        }
        
        List<Integer> t = new ArrayList<>(list);
        Collections.sort(t);
        
        int cnt = 0;
        for (int i : t) {
            cnt++;
            if (i == num) {
                break;
            }
        }

        System.out.println(cnt);
    }

    static int minimum(int a, int b, int c, int d) {
        int min = Integer.MAX_VALUE;

        min = Math.min(min, a * 1000 + b * 100 + c * 10 + d);
        min = Math.min(min, b * 1000 + c * 100 + d * 10 + a);
        min = Math.min(min, c * 1000 + d * 100 + a * 10 + b);
        min = Math.min(min, d * 1000 + a * 100 + b * 10 + c);

        return min;
    }
}
