import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long x;
    static long y;

    static long[][] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        points = new long[N + 1][2];
        for(int i = 0; i < N;i++){
            String[] temp = br.readLine().split(" ");

            x = Long.parseLong(temp[0]);
            y = Long.parseLong(temp[1]);

            long[] p = {x, y};

            points[i] = p;
        }

        points[N] = points[0].clone();

        double answer = getSize();

        System.out.println(String.format("%.1f", answer));
    }

    public static double getSize(){
        long area = 0;
        long area2 = 0;
        for (int i = 0; i < N; i++) {
            area += points[i][0] * points[i + 1][1];
            area2 += points[i][1] * points[i + 1][0];
        }

        return Math.abs(area - area2)/2D;
    }

}
