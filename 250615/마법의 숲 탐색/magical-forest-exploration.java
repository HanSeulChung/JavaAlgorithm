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
    골렘을 타고 온 정령의 body가 숲속 바깥에 있으면 (row < 3) 초기화 후 해당 골렘은 넘어간다.
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

        // 배열을 R+3 높이로 다시 초기화
        board    = new int[rowSize + 3][colSize + 1];
        canExit  = new boolean[rowSize + 3][colSize + 1];
        exploreForest();

        bw.write(String.valueOf(rowSum));
        bw.flush();
        bw.close();
    }

    // 실제 숲은 board[3]..board[rowSize+2] 까지
    private static boolean isInForest(int row, int col) {
        return row >= 0 && row <= rowSize + 2 && col >= 1 && col <= colSize;
    }

    private static List<int[]> getGolemArea(int centerRow, int centerCol, int exitDirection) {
        List<int[]> area = new ArrayList<>();
        area.add(new int[]{centerRow, centerCol});     // 중심
        area.add(new int[]{centerRow - 1, centerCol});  // 위
        area.add(new int[]{centerRow + 1, centerCol});  // 아래
        area.add(new int[]{centerRow, centerCol + 1});  // 오른쪽
        area.add(new int[]{centerRow, centerCol - 1});  // 왼쪽
        return area;
    }

    private static boolean canPlaceGolem(int centerRow, int centerCol, int exitDirection) {
        // 위쪽 대각선 3칸까지 포함해서 검사
        if (!isInForest(centerRow - 1, centerCol - 1) || board[centerRow - 1][centerCol - 1] != 0) return false;
        if (!isInForest(centerRow - 1, centerCol    ) || board[centerRow - 1][centerCol    ] != 0) return false;
        if (!isInForest(centerRow - 1, centerCol + 1) || board[centerRow - 1][centerCol + 1] != 0) return false;
        // 십자 모양 5칸
        for (int[] pos : getGolemArea(centerRow, centerCol, exitDirection)) {
            int r = pos[0], c = pos[1];
            if (!isInForest(r, c) || board[r][c] != 0) return false;
        }
        return true;
    }

    private static void placeGolem(int centerRow, int centerCol, int exitDirection, int golemId) {
        for (int[] pos : getGolemArea(centerRow, centerCol, exitDirection)) {
            board[pos[0]][pos[1]] = golemId;
        }
        // 출구도 board 에 표시
        int exitRow = centerRow + DIRECTIONS[exitDirection][0];
        int exitCol = centerCol + DIRECTIONS[exitDirection][1];
        board[exitRow][exitCol] = golemId;
        canExit[exitRow][exitCol] = true;
    }

    private static boolean golemMove(int startCol, int startDir, int fairyIdx) {
        // 바뀐 초기 row: 2 (buffer 위 두 줄 후, 다음이 실제 i=3 첫 숲 행)
        int row = 2;
        int col = startCol;
        int dir = startDir;
        int id  = fairyIdx + 1;

        while (true) {
            if (canPlaceGolem(row + 1, col, dir)) {
                row += 1; continue;
            }
            int leftDir = (dir + 3) % 4;
            if (canPlaceGolem(row + 1, col - 1, leftDir)) {
                row += 1; col -= 1; dir = leftDir; continue;
            }
            int rightDir = (dir + 1) % 4;
            if (canPlaceGolem(row + 1, col + 1, rightDir)) {
                row += 1; col += 1; dir = rightDir; continue;
            }
            // 멈춰야 할 위치에 놓을 수 있으면 배치
            if (canPlaceGolem(row, col, dir)) {
                placeGolem(row, col, dir, id);
                // 출구 좌표로 저장
                int exitRow = row + DIRECTIONS[dir][0];
                int exitCol = col + DIRECTIONS[dir][1];
                arriveLocation[fairyIdx] = new int[]{exitRow, exitCol};
                return true;
            }
            return false;
        }
    }

    private static int[][] clearBoard() {
        return new int[rowSize + 3][colSize + 1];
    }

    private static void exploreForest() {
        arriveLocation = new int[fairyCount][2];
        for (int idx = 0; idx < fairyCount; idx++) {
            int[] cur = fairies[idx];
            golemMiddleCol     = cur[0];
            golemExitDirection = cur[1];
            if (golemMove(golemMiddleCol, golemExitDirection, idx)) {
                rowSum += moveFairy(idx);
            } else {
                board   = clearBoard();
                canExit = new boolean[rowSize + 3][colSize + 1];
            }
        }
    }

    private static int moveFairy(int fairyIdx) {
        int[] st = arriveLocation[fairyIdx];
        int sr = st[0], sc = st[1], sid = board[sr][sc];

        boolean[][] visited = new boolean[rowSize + 3][colSize + 1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc, sid});
        visited[sr][sc] = true;

        int maxR = sr;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], id = cur[2];
            maxR = Math.max(maxR, r);
            for (int d = 0; d < 4; d++) {
                int nr = r + DIRECTIONS[d][0], nc = c + DIRECTIONS[d][1];
                if (!isInForest(nr, nc) || visited[nr][nc] || board[nr][nc] == 0) continue;
                int nid = board[nr][nc];
                if (nid == id || canExit[r][c]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, nid});
                }
            }
        }
        // forest row 로 변환: 실제 행 = maxR-2
        return maxR - 2;
    }

    private static void initInput() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        rowSize    = Integer.parseInt(st.nextToken());
        colSize    = Integer.parseInt(st.nextToken());
        fairyCount = Integer.parseInt(st.nextToken());

        fairies = new int[fairyCount][2];
        for (int i = 0; i < fairyCount; i++) {
            st = new StringTokenizer(br.readLine().trim());
            fairies[i][0] = Integer.parseInt(st.nextToken());
            fairies[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
