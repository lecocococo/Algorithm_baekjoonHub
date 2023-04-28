import java.io.*;
import java.util.*;

class Solution {
    static char[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    static char[] temp;
    static List<String> list;
    public int solution(String word) {
        int answer = 0;
        arr = new char[] {'A','E','I','O','U'};
        visited = new boolean[5];
        temp = new char[5];
        list = new ArrayList<>();
        
        for(int i = 1 ; i < 6; i++) {
            temp = new char[i];
            got(0, i);
        }
        
        // System.out.println(list.size());
        // System.out.println(list);
        list.sort(new Comparator<>(){
            @Override
            public int compare(String o1, String o2){
                return o1.compareTo(o2);
            }
        });
        // System.out.println(list);
        
        for(int i = 0 ;i < list.size();i++){
            if (list.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
    
    public void got(int cnt, int m ) {
        if (cnt == m) {
            sb = new StringBuilder();
            for(int i = 0 ; i < m; i++){
                sb.append(temp[i]);
            }
            // System.out.println(sb);
            list.add(sb.toString());
            // System.out.println(Arrays.toString(temp));
            return;
        }
        
        
        for(int i = 0 ; i < 5; i++) {
            // if(!visited[i]){
                // visited[i] = true;
                temp[cnt] = arr[i];
                got(cnt + 1, m);
                temp[cnt] = 0;
                // visited[i] = false;
            // }
            
        }
        
        
    }
}