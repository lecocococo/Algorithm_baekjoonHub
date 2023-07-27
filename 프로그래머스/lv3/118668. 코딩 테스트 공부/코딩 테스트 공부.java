class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
	        int algoGoal = 0;
	        int codeGoal = 0;
	        
	        for (int i = 0; i< problems.length; i++) {
	            algoGoal = Math.max(problems[i][0], algoGoal);
	            codeGoal = Math.max(problems[i][1], codeGoal);
	        }
	        
	        if (alp >= algoGoal && cop >= codeGoal) {
	            return 0;    
	        }
	        
	        if (alp >= algoGoal) {
	            alp = algoGoal;
	        }
	        
	        if (cop >= codeGoal) {
	            cop = codeGoal;
	        }
	        
	        int[][] dp = new int[algoGoal + 2][codeGoal + 2];
        
	        for (int i = alp; i < algoGoal + 1; i++) {
	            for (int j = cop; j < codeGoal + 1; j++) {
	                dp[i][j] = Integer.MAX_VALUE;
	            }
	        }
	        
	        dp[alp][cop] = 0;
        
	        for (int i = alp; i < algoGoal + 1; i++) {
	            for (int j = cop; j < codeGoal + 1; j++) {
	            
	                // 공부
	                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
	                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
	                
	                for (int k = 0; k < problems.length; k++) {
						
	                    // 문제 풀수 있을 때
	                    if (i >= problems[k][0] && j >= problems[k][1]) {
							
	                        // 둘다
	                        if (i + problems[k][2] > algoGoal && j + problems[k][3] > codeGoal) {
	                            dp[algoGoal][codeGoal] = Math.min(dp[algoGoal][codeGoal], dp[i][j] + problems[k][4]);
	                        } else if (i + problems[k][2] > algoGoal) { // 알고
	                            dp[algoGoal][j+ problems[k][3]] = Math.min(dp[algoGoal][j + problems[k][3]], dp[i][j]+problems[k][4]);
	                        } else if (j + problems[k][3] > codeGoal) { // 코딩
	                            dp[i + problems[k][2]][codeGoal] = Math.min(dp[i+problems[k][2]][codeGoal],dp[i][j]+problems[k][4]);
	                        } else if (i+problems[k][2] <= algoGoal && j+problems[k][3] <= codeGoal){
	                            dp[i+problems[k][2]][j+problems[k][3]] = Math.min(dp[i + problems[k][2]][j + problems[k][3]],dp[i][j]+problems[k][4]); 
	                        }
	                    }
	                }
	            }
		    }
	        answer = dp[algoGoal][codeGoal];
	        return answer;
    }
}