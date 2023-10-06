import java.util.*;

class Solution {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        map = maps;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        
        int ans = bfs(0, 0, 0);
        answer = ans;
        return answer;
    }
    
    public int bfs(int a, int b, int cnt) {
        Queue<int[]> q = new ArrayDeque<int[]>();
        q.add(new int[]{a, b, cnt});
        visited[a][b] = true;
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int c = temp[2];
            
            if (x == n - 1 && y == m - 1){
                System.out.println(x +" " + y + " " + c);  
                return c + 1;
            }
            
            for(int i= 0;i < 4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(check(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, c + 1});
                }
            }
        }
        return -1;
    }
    
    public boolean check(int x, int y) {
        if(x<n && x >= 0 && y < m && y >=0){
            return true;
        }else {
            return false;
        }
        
    }
}