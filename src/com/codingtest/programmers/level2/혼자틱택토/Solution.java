package com.codingtest.programmers.level2.혼자틱택토;

public class Solution {
    public static char[][] charboard;
    public static boolean checkTicTac(char c){
        for(int i =0; i<3; i++){ // 대각선이 아닌 위, 아래 방향으로 세 개 연속적일 경우
            if(charboard[i][0]==c && charboard[i][0]==charboard[i][1] && charboard[i][1] ==charboard[i][2]){
                return true;
            }
            if(charboard[0][i]==c && charboard[0][i]==charboard[1][i] && charboard[1][i] ==charboard[2][i]){
                return true;
            }
        }
        // 그 외 대각선방향으로 세 개가 연속적일 경우
        if(charboard[0][0] ==c & charboard[0][0]==charboard[1][1] && charboard[1][1]==charboard[2][2] ){
            return true;
        }
        if(charboard[2][0] ==c & charboard[2][0]==charboard[1][1] && charboard[1][1]==charboard[0][2] ){
            return true;
        }
        return false;
    }
    public static int solution(String[] board) {
        int answer = 1;
        int firstN = 0;
        int seconN = 0;
        charboard = new char[3][3];
        for(int i =0; i<3; i++){
            String row = board[i];
            for(int j =0; j<3; j++){
                char tmpc = row.charAt(j);
                charboard[i][j] = tmpc;
                if(tmpc=='O'){
                    firstN +=1;
                } else if (tmpc=='X'){
                    seconN +=1;
                }
            }
        }

        if(seconN > firstN || firstN - seconN>1){
            return 0;
        }


        boolean checkO = checkTicTac('O');
        boolean checkX = checkTicTac('X');

        if(checkO && seconN>=3){
            return 0;
        }

        if(checkX && firstN>3){
            return 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};
        System.out.println(solution(board));
    }
}
