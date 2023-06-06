import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        char[] arr = st.toCharArray();

        flag = true;
        int cnt = 0;
        int Acnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!Character.isAlphabetic(arr[i]) && arr[i] != '_') {
                flag = false;
            }
            if (Character.isUpperCase(arr[i])) {
                Acnt++;
            }
            if(arr[i] == '_') {
                cnt++;
            }
        }

//        System.out.println(cnt);

        StringBuilder sb = new StringBuilder();

        if (cnt > 0 && Acnt > 0) {
            flag = false;
        }

        // 자바
        if(flag) {
            if (cnt == 0) {
                // 대문자 확인
                for (int i = 0; i < arr.length; i++) {
                    if(Character.isUpperCase(arr[i])){
                        if(i == 0) {
                            flag = false;
                            print(sb);
                            return;
                        }
                        sb.append("_");
                        sb.append(Character.toLowerCase(arr[i]));
                    }else {
                        sb.append(arr[i]);
                    }

                }
            } else if (cnt > 0) { // C++
                String[] a = st.split("_");
//                System.out.println(Arrays.toString(a));
                for (int i = 0; i < a.length; i++) {
//                    System.out.println(a[i]);
                    if (a[i].equals("")) {
                        flag = false;
                        print(sb);
                        return;
                    }
                }
                if (a.length == 0||a.length == 1) {
//                    System.out.println(a);
                    flag =false;
                    print(sb);
                    return;
                }
                else if(a.length > 1 && a[0].equals("")) {
//                    System.out.println(a);
                    flag = false;
                    print(sb);
                    return;
                } else {
                    sb.append(a[0]);
                }

                for (int i = 1; i < a.length; i++) {
//                    System.out.println(Arrays.toString(a));

                    String temp = a[i].substring(0 ,1).toUpperCase() + a[i].substring(1);

                    sb.append(temp);
                }
            }
        }

        print(sb);


    }

    static void print(StringBuilder sb) {
        if(!flag) {
            System.out.println("Error!");
            return;
        }
        System.out.println(sb);
    }
}
