import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        LinkedList<Character> list = new LinkedList<Character>();
        for(int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        // 참고: https://m.blog.naver.com/highkrs/220447031653
        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String temp = br.readLine();

            char command = temp.charAt(0);

            if(command == 'L'){
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (command == 'D') {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (command == 'B') {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if (command == 'P') {
                char c = temp.charAt(2);
                iter.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }

        System.out.println(sb);
    }
}
