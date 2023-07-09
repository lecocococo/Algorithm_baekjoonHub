import java.io.*;
import java.util.*;


class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int N;
    static int M;
    static int max;
    
    static int[][] arr;
    static boolean[][] visited;
    
    public int[] solution(String[] maps) {
        int[] answer;
        
        N = maps.length;
        M = maps[0].length();
        
        arr = new int[maps.length][maps[0].length()];
        visited = new boolean[N][M];
        
        // max = Integer.MIN_VALUE;
        
        for(int i = 0; i< maps.length;i++){
            String [] t = maps[i].split("");
            
            for(int j = 0; j < t.length; j++){
                if(t[j].equals("X")){
                    arr[i][j] = 0;
                    visited[i][j] = true;
                } else {
                    arr[i][j] = Integer.parseInt(t[j]);
                }
            }
        }
        
        // for(int i = 0; i< maps.length;i++) {
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i< N;i++){
            for(int j = 0; j < M; j++){
                if (!visited[i][j]) {
                    // max = arr[i][j];
                    max = 0; 
                    // visited[i][j] = true;
                    dfs(i, j, 0);
                    list.add(max);
                }
            }
        }
        
        if (list.size() == 0) {
            list.add(-1);
        }
        
        Collections.sort(list);
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
           answer[i] = list.get(i); 
        }
        
        // System.out.println(list);
        
        return answer;
    }
    
    
    public void dfs(int x, int y, int sum) {
        // max = Math.max(max, sum);
        max += arr[x][y];
        
        visited[x][y] = true;
        for(int i = 0; i < 4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(check(nx, ny) && !visited[nx][ny]) {
                // visited[nx][ny] = true;
                dfs(nx, ny, sum + arr[nx][ny]);
            }
        }
    }
    
    
    public boolean check(int x, int y){
        return (x >= 0 && x < N) && (y >= 0 && y < M);
    }
    
}