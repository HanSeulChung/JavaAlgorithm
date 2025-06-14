import java.util.*;
import java.io.*;

/*
    [골렘 이동 방법]
    우선순위
    1. 남쪽방향으로 한칸 이동 => 아래 방향 (1, 0)
    2. 서쪽 방향으로 회전하면서 내려가기 
        => 왼쪽으로 이동 + 반시계 방향 회전 + 아래 방향 내려가기
    3. 동쪽 방향으로 회전하면서 내려가기 
        => 오른쪽으로 이동 + 시계방향 회전 + 아래 방향 내려가기

    [정령 이동 방법]
    자신이 타고 있던 골렘 출구로 다른 골렘으로 이동 가능, 다른 골렘의 출구 방향
         -> .. 반복 으로 이동가능
    [숲 초기화]
    골렘을 타고 온 정령의 body가 숲속 바깥에 있으면 (row = 0) 초기화 후 해당 골렘은 넘어간다.
*/
public class Main {
    static final int[][] DIRECTIONS =  {{-1 , 0}, {0, 1}, {1, 0}, {0, -1}};
    static final int DOWN_IDX = 1;

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int rowSize, colSize, fairyCount, golemMiddleCol, golemExitDirection;
    static int[][] board, fairies;
    static int[][] arriveLocation;
    static boolean[][] canExit;
    static int rowSum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initInput();
        br.close();

        exploreForest();

        bw.write(String.valueOf(rowSum));
        bw.flush();
        bw.close();
    }

    private static boolean isInForest(int row, int col) {
        return row >= 1 && row <= rowSize && col >= 1 && col <= colSize;
    }

    private static List<int[]> getGolemArea(int centerRow, int centerCol, int exitDirection) {
        List<int[]> area = new ArrayList<>();
        area.add(new int[]{centerRow, centerCol}); // 중심
        area.add(new int[]{centerRow - 1, centerCol}); // 위
        area.add(new int[]{centerRow + 1, centerCol}); // 아래
        area.add(new int[]{centerRow, centerCol + 1}); // 오른쪽
        area.add(new int[]{centerRow, centerCol - 1}); // 왼쪽

        return area;
    }

    private static boolean canPlaceGolem(int centerRow, int centerCol, int exitDirection) {
        if (!isInForest(centerRow, centerCol)) return false;
        if (!isInForest(centerRow - 1, centerCol)) return false;
        if (!isInForest(centerRow - 1, centerCol - 1)) return false;
        if (!isInForest(centerRow - 1, centerCol + 1)) return false;
        
        List<int[]> area = getGolemArea(centerRow, centerCol, exitDirection);
        for (int[] pos : area) {
            int row = pos[0], col = pos[1];
            if (!isInForest(row, col) || board[row][col] != 0)
                return false;
        }

        if (board[centerRow - 1][centerCol] != 0) return false;
        if (board[centerRow - 1][centerCol - 1] != 0) return false;
        if (board[centerRow - 1][centerCol + 1] != 0) return false;
        return true;
    }

    private static void placeGolem(int centerRow, int centerCol, int exitDirection, int golemId) {
        List<int[]> area = getGolemArea(centerRow, centerCol, exitDirection);
        for (int[] pos : area) {
            int row = pos[0], col = pos[1];
            board[row][col] = golemId; // 해당 골렘을 배치
        }
        int exitRow = centerRow + DIRECTIONS[exitDirection][0];
        int exitCol = centerCol + DIRECTIONS[exitDirection][1];
        canExit[exitRow][exitCol] = true;
    }

    private static boolean golemMove(int startCol, int startDir, int fairyIdx) {
        int row = 1;
        int col = startCol;
        int dir = startDir;
        int id = fairyIdx + 1;

        while (true) {
            // 아래로 이동 가능하면
            if (canPlaceGolem(row + 1, col, dir)) {
                row += 1;
                continue;
            }

            // 왼쪽 회전 + 내려가기 가능하면
            int leftDir = (dir + 3) % 4;
            if (canPlaceGolem(row + 1, col - 1, leftDir)) {
                row += 1;
                col -= 1;
                dir = leftDir;
                continue;
            }

            // 오른쪽 회전 + 내려가기 가능하면
            int rightDir = (dir + 1) % 4;
            if (canPlaceGolem(row + 1, col + 1, rightDir)) {
                row += 1;
                col += 1;
                dir = rightDir;
                continue;
            }

           // 현재 위치에 골렘을 놓을 수 있으면 바로 놓는다
            if (canPlaceGolem(row, col, dir)) {
                placeGolem(row, col, dir, id);
                arriveLocation[fairyIdx] = new int[]{row, col};
                return true;
            }

            return false;
        }
    }

    private static int[][] clearBoard() {
        return new int[rowSize + 1][colSize + 1];
    }

    private static void exploreForest() {
        arriveLocation = new int[fairyCount][2];
        canExit = new boolean[rowSize + 1][colSize + 1];
        for (int idx = 0; idx < fairyCount; idx++) {
            int[] curFairyStatus = fairies[idx];
            golemMiddleCol = curFairyStatus[0];
            golemExitDirection = curFairyStatus[1];
            if (golemMove(golemMiddleCol, golemExitDirection, idx)) {
                int arriveRow = moveFairy(idx);
                rowSum += arriveRow;
                // System.out.printf("fariy %d: arriveRow: %d\n", idx, arriveRow);
                // printBoard();
            } else {
                board = clearBoard(); // 숲 초기화
                canExit = new boolean[rowSize + 1][colSize + 1]; // 춮구 초기화
            }
        }
    }

    private static void printBoard() {
        for (int r = 1; r <= rowSize; r++) {
            System.out.println(Arrays.toString(board[r]));
        }
    }

    private static int moveFairy(int fairyIdx) {
        int[] start = arriveLocation[fairyIdx];
        int startRow = start[0], startCol = start[1];
        int startValue = board[startRow][startCol];

        boolean[][] visited = new boolean[rowSize + 1][colSize + 1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startRow, startCol, startValue});
        visited[startRow][startCol] = true;

        int maxRow = startRow;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], id = cur[2];

            maxRow = Math.max(maxRow, r);

            for (int d = 0; d < 4; d++) {
                int nr = r + DIRECTIONS[d][0];
                int nc = c + DIRECTIONS[d][1];
                if (!isInForest(nr, nc) || visited[nr][nc] || board[nr][nc] == 0) continue;

                int nextId = board[nr][nc];
                if (nextId == id) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, nextId});
                } else if (canExit[r][c]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, nextId});
                } 
            }
        }

        return maxRow;
    }

    private static void initInput() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        fairyCount = Integer.parseInt(st.nextToken());

        board = new int[rowSize + 1][colSize + 1]; // 1-base

        fairies = new int[fairyCount][2];
        for (int fairyIdx = 0; fairyIdx < fairyCount; fairyIdx++) {
            st = new StringTokenizer(br.readLine().trim());
            golemMiddleCol = Integer.parseInt(st.nextToken());
            golemExitDirection = Integer.parseInt(st.nextToken());
            fairies[fairyIdx] = new int[]{golemMiddleCol, golemExitDirection};
        }
    }
}