import java.util.*;
import java.io.*;

/*
    N: row 
    M: col
    포탑의 개수 = row * col
    포탑의 공격력은 0 ~ 5000
    공격력 0은 없어진다.

    [공격]
    포탑들 중 가장 적은 공격력을 갖고 있는 포탑이 공격수가 된다.
    가장 적은 공격력을 갖고있기 때문에 핸디캡으로 row + col 값 만큼 공격력을 더해준다.
    공격 방법
    1. 레이저 공격: BFS 경로로 레이저 공격, 단 경로에 있는 모든 포탑은 1/2배 공격 당한다.
    2. 포탄 공격: 해당 공격을 받는 8방향의 모든 포탑들은 1/2배 공격 당한다.
    [공격 대상(수비)]
    포탑들 중 가장 높은 공격력을 갖고있는 포탑이 수비수가 된다.
    [포탑 재정비]
    공격수, 공격받은 탑 제외한 모든 탑의 공격력을 +1한다.

    => K번 반복 

    [출력]
    K번의 턴이 종료된 후 남아있는 포탑 중 가장 강한 포탑의 공격력 출력
*/
public class Main {
    static final int[][] DIRECTIONS = 
        {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}}; // 우, 하, 좌, 상 우선순위대로 배치

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    
    static int rowSize;
    static int colSize;
    static int repeatCount;

    static int[][] board;
    static int[][] timeBoard;
    static PriorityQueue<Tower> toTower;
    static PriorityQueue<Tower> fromTower;

    static int maxAttackScore = Integer.MIN_VALUE;

    static class Tower {
        int row;
        int col;
        int sumRowCol;
        int attackScore;
        int attackTime;

        public Tower(int row, int col, int attackScore, int attackTime) {
            this.row= row;
            this.col= col;
            this.sumRowCol = row + col;
            this.attackScore = attackScore;
            this.attackTime = attackTime;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initInput();

        br.close();

        gameStart();

        bw.write(String.valueOf(maxAttackScore));
        bw.flush();
        bw.close();
    }

    private static void gameStart() {
        timeBoard = new int[rowSize][colSize]; // 공격한 시간 기록 
        int time = 1;

        fromTower = new PriorityQueue<>((t1, t2) -> {
            if (t1.attackScore != t2.attackScore) return t1.attackScore - t2.attackScore;
            if (timeBoard[t1.row][t1.col] != timeBoard[t2.row][t2.col])
                return timeBoard[t2.row][t2.col] - timeBoard[t1.row][t1.col];
            if (t1.sumRowCol != t2.sumRowCol) return t2.sumRowCol - t1.sumRowCol;
            return t2.col
            if (timeBoard[t1.row][t1.col] != timeBoard[t2.row][t2.col]) return timeBoard[t1.row][t1.col] - timeBoard[t2.row][t2.col];
            if (t1.sumRowCol != t2.sumRowCol) return t1.sumRowCol - t2.sumRowCol;
            return t1.col - t2.col;
        \});

        while (repeatCount-- > 0) {
            int[][] scanPair = scan(time++);

            board[scanPair[0][0]][scanPair[0][1]] += rowSize + colSize;
            boolean[][] isConnected = 

27778183public class Main {    private static void gameStart() {        fromTower = new PriorityQueue<>((t1, t2) -> {            if (timeBoard[t1.row][t1.col] != timeBoard[t2.row][t2.col])

$0 - t1.col;
        });

        toTower = new PriorityQueue<>((t1, t2) -> {
            if (t1.attackScore != t2.attackScore) return t2.attackScore - t1.attackScore;
            if (timeBoard[t1.row][t1.col] != timeBoard[t2.row][t2.col]) return timeBoard[t1.row][t1.col] - timeBoard[t2.row][t2.col];
            if (t1.sumRowCol != t2.sumRowCol) return t1.sumRowCol - t2.sumRowCol;
            return t1.col - t2.col;
        });

        while (repeatCount-- > 0) {
            int[][] scanPair = scan(time++);

            board[scanPair[0][0]][scanPair[0][1]] += rowSize + colSize;
            boolean[][] isConnected = 
                attack(scanPair[0][0], scanPair[0][1], scanPair[1][0], scanPair[1][1]
                    , board[scanPair[0][0]][scanPair[0][1]]);

            repair(isConnected);
        }

        // 반복이 끝나고 가장 공격력이 높은 값 찾기
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (board[row][col] == 0) continue;
                maxAttackScore = Math.max(maxAttackScore, board[row][col]);
            }
        }
    }

    // 포탑 재정비
    private static void repair(boolean[][] isConnected) {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (isConnected[row][col]) continue;
                board[row][col]++;
            }
        }
    }

    private static boolean[][] attack(int startRow, int startCol, int endRow, int endCol, int curAttackScore) {
        Queue<int[]> attackQueue = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[rowSize][colSize];
        attackQueue.add(new int[]{startRow, startCol});

        boolean isLaserAttack = false;
        while (!attackQueue.isEmpty()) {
            int[] curStatus = attackQueue.poll();
            int curRow = curStatus[0];
            int curCol = curStatus[1];

            isVisited[curRow][curCol] = true;

            // 맞춰야하는 포탑에 도착했다면 끝내고 attackScore만큼 공격
            if (curRow == endRow && curCol == endCol) {
                isLaserAttack = true;
                board[endRow][endCol] -= curAttackScore;
                board[endRow][endCol] = Math.max(0, board[endRow][endCol]);
                break;
            }
            // 맞춰야하는 포탑이 아닌 주변 포탑이라면 attackScore의 반만큼 공격
            board[curRow][curCol] -= (curAttackScore /2);

            for (int direction = 0; direction < 4; direction++) {
                int[] nextStatus = move4Direction(curRow, curCol, direction);
                int nextRow = nextStatus[0];
                int nextCol = nextStatus[1];

                if (board[nextRow][nextCol] == 0) continue; // 이미 무너진 포탑이 있다면 넘어가지 못함
                if (isVisited[nextRow][nextCol]) continue;

                attackQueue.add(new int[]{nextRow, nextCol});
            }
        }
        // 레이저 공격으로 성공했다면 return
        if (isLaserAttack) return isVisited;

        // 아니라면 포탄 공격
        // 다시 visited 배열 갱신 
        isVisited = new boolean[rowSize][colSize];
        isVisited[startRow][startCol] = true;
        isVisited[endRow][endCol] = true;
        board[endRow][endCol] -= curAttackScore;
        board[endRow][endCol] = Math.max(0, board[endRow][endCol]);

        int[][] nextStatuses= move8Direction(endRow, endCol);

        for (int[] nextStatus : nextStatuses) {
            int nextRow = nextStatus[0];
            int nextCol = nextStatus[1];
            if (nextRow == -1 && nextCol == -1) continue;
            isVisited[nextRow][nextCol] = true;
            board[nextRow][nextCol] -= (curAttackScore /2);
        }

        return isVisited;
    }

    private static int[] move4Direction(int curRow, int curCol, int curDirection) {
        int nextRow = curRow + DIRECTIONS[curDirection][0];
        int nextCol = curCol + DIRECTIONS[curDirection][1];

        if (nextRow < 0) nextRow += rowSize;
        if (nextRow == rowSize) nextRow = 0;
        if (nextCol < 0) nextCol += colSize;
        if (nextCol == colSize) nextCol = 0;
        
        return new int[]{nextRow, nextCol};
    }

    private static int[][] move8Direction(int middleRow, int middleCol) {
        int[][] results = new int[8][2];
        for (int[] result : results ) Arrays.fill(result, -1);

        for (int direction = 0; direction < 8; direction++) {
            int nextRow = middleRow + DIRECTIONS[direction][0];
            int nextCol = middleCol + DIRECTIONS[direction][1];

            if (nextRow < 0) nextRow += rowSize;
            if (nextRow == rowSize) nextRow = 0;
            if (nextCol < 0) nextCol += colSize;
            if (nextCol == colSize) nextCol = 0;

            if (board[nextRow][nextCol] != 0) {
                results[direction][0] = nextRow;
                results[direction][1] = nextCol;
            }
        }
        return results;
    }

    private static int[][] scan(int time) {
        int[][] scanPair = new int[2][2];
    

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (board[row][col] == 0) continue;
                fromTower.add(new Tower(row, col, board[row][col], timeBoard[row][col]));
                toTower.add(new Tower(row, col, board[row][col], timeBoard[row][col]));
            }
        }

        Tower attackTower = fromTower.poll();
        Tower defenseTower = toTower.poll();
        scanPair[0] = new int[]{attackTower.row, attackTower.col};
        timeBoard[attackTower.row][attackTower.col] = time; // 공격한 시간 갱신
        scanPair[1] = new int[]{defenseTower.row, defenseTower.col};

        fromTower.clear();
        toTower.clear();

        return scanPair;
    }

    private static void initInput() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        repeatCount = Integer.parseInt(st.nextToken());

        board = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int col = 0; col < colSize; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }
    }
}