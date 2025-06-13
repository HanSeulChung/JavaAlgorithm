import java.io.*;
import java.util.*;

/*
    P: 토끼 마리수 -> rabbitCount;
    N: rowSize, M: colSize 
    Q: 명령어 개수 -> commandCount;
    K: 반복 횟수 -> repeatCount
    S: 반복이 끝난 후 가장 높은 우선순위가 높은 토끼에게 더할 점수 plusScore;
    L -> multiplyValue; 기존 배수 할 값

    [첫 명령어] => 100
    100 rowSize colSize rabbitCount [rabbit1_pId, rabbit1_distance, ... ]

    [경주 진행] => 200
    200 repeatCount plusScore
    반복마다 우선순위가 높은 토끼를 구하고 해당 토끼의 distance 만큼 상하좌우 이동을 시킨다.
    만일 격자 밖으로 벗어나게 된다면 방향을 반대로 바꿔 한칸 이동하게 된다.

    [이동거리 변경] => 300
    300 rabbit_pId multiplyValue

    [최고의 토끼 선정] -> 400
    가장 점수가 높은 토끼 선정
*/
public class Main {
    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static class Rabbit implements Comparable<Rabbit> {
        int pId, row, col, distance, score, jumpCount;

        public Rabbit(int pId, int distance) {
            this.row = 0;
            this.col = 0;
            this.pId = pId;
            this.distance = distance;
            this.score = 0;
            this.jumpCount = 0;
        }
        
        public void jump() {
            this.jumpCount++;
        }

        public void changeLocation(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void addScore(int plusScore){
            this.score += plusScore;
        }

        public int compareTo(Rabbit r) {
            if (this.jumpCount != r.jumpCount) return this.jumpCount - r.jumpCount;
            if ((this.row + this.col) != (r.row + r.col)) return (this.row + this.col) - (r.row + r.col);
            if (this.row != r.row) return this.row - r.row;
            if (this.col != r.col) return this.col - r.col;
            return this.pId - r.pId;
        }
    }

    static class Location implements Comparable<Location> {
        int row, col, sumRowCol;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
            this.sumRowCol = row + col;
        }

        public int compareTo(Location l) {
            if (this.sumRowCol != l.sumRowCol) return l.sumRowCol - this.sumRowCol;
            if (this.row != l.row) return l.row - this.row;
            return l.col - this.col;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int rabbitCount, rowSize, colSize, commandCount;
    static int repeatCount, plusScore, multiplyValue;
    static int bestRabbit = Integer.MIN_VALUE;
    static int[][] commands;
    static Map<Integer, Integer> rabbitDistanceForPId;
    static List<Rabbit> rabbitList = new ArrayList<>();
    static Set<Integer> selectedRabbit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initInput();
        br.close();

        raceStart();
        bw.write(String.valueOf(selectBestRabbitScore()));
        bw.flush();
        bw.close();
    }

    private static int selectBestRabbitScore() {
        int maxScore = 0;
        for (Rabbit rabbit : rabbitList) {
            maxScore = Math.max(maxScore, rabbit.score);
        }
        return maxScore;
    }

    private static void raceStart() {
        for (int[] command : commands) {
            if (command[0] == 200) {
                repeatCount = command[1];
                plusScore = command[2];

                selectedRabbit = new HashSet<>();
                for (int repeatIdx = 0; repeatIdx < repeatCount; repeatIdx++) {
                    Collections.sort(rabbitList);
                    Rabbit prioirtyRabbit = rabbitList.get(0);
                    selectedRabbit.add(prioirtyRabbit.pId);
                    
                    int[] location = move(prioirtyRabbit);
                    int row = location[0];
                    int col = location[1];
                    prioirtyRabbit.changeLocation(row, col);
                    rabbitList.set(0, prioirtyRabbit);

                    for (int rabbitIdx = 1; rabbitIdx < rabbitList.size(); rabbitIdx++) {
                        rabbitList.get(rabbitIdx).addScore(row+col+2); // 0base -> 1base 변환
                    }
                }

                addScoreAfterRace(plusScore);
            }
            else if (command[0] == 300) {
                int changeRabbitPId = command[1];
                multiplyValue = command[2];
                rabbitDistanceForPId.put(changeRabbitPId,
                        rabbitDistanceForPId.get(changeRabbitPId) *multiplyValue);
            }
        }
    }

    private static void addScoreAfterRace(int plusScoreValue) {
        PriorityQueue<int[]> forScore = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1[0] != o2[0]) return o2[0] - o1[0];
                    if (o1[1] != o2[1]) return o2[1] - o1[1];
                    if (o1[2] != o2[2]) return o2[2] - o1[2];
                    return o2[3] - o1[3];
        });

        for (int idx = 0; idx < rabbitList.size(); idx++) {
            Rabbit rabbit = rabbitList.get(idx);
            if (!selectedRabbit.contains(rabbit.pId)) continue;
            forScore.add(new int[]{rabbit.row + rabbit.col, rabbit.row, rabbit.col
                                    , rabbit.pId, idx});
        }

        int[] selectedRabbitForAddScore = forScore.poll();
        int curRabbitIdx = selectedRabbitForAddScore[4];

        Rabbit rabbit = rabbitList.get(curRabbitIdx);
        rabbit.addScore(plusScoreValue);
        rabbitList.set(curRabbitIdx, rabbit);
    }

    private static int[] move(Rabbit selectedRabbit) {
        List<Location> locations = new ArrayList<>();

        int curPId = selectedRabbit.pId;
        if (selectedRabbit.distance != rabbitDistanceForPId.get(curPId)) {
            selectedRabbit.distance = rabbitDistanceForPId.get(curPId);
        }
        int curDistance = selectedRabbit.distance;
        int curRow = selectedRabbit.row;
        int curCol = selectedRabbit.col;

        for (int direction = 0; direction < 4; direction++) {
            int moveRowLen = DIRECTIONS[direction][0] * curDistance;
            int moveColLen = DIRECTIONS[direction][1] * curDistance;

            int nextRow = curRow + DIRECTIONS[direction][0] * curDistance;
            int nextCol = curCol + DIRECTIONS[direction][1] * curDistance;

            if (nextRow < 0 || nextRow >= rowSize) {
                nextRow = reflect(nextRow, rowSize);
            }
            if (nextCol < 0 || nextCol >= colSize){
                nextCol = reflect(nextCol, colSize);
            }

            locations.add(new Location(nextRow, nextCol));
        }
        Collections.sort(locations);
        selectedRabbit.jump();
        return new int[]{locations.get(0).row, locations.get(0).col};
    }

    public static int reflect(int moveLen, int boardLen) {
        int period = 2 * (boardLen - 1);
        int realMove = moveLen % period;
        if (realMove < 0) {
            realMove += period;
            // System.out.println("@@");
            // System.out.println(realMove);
        }
        return realMove <= boardLen - 1 ? realMove : period - realMove;
    }

    private static void initInput() throws IOException {
        commandCount = Integer.parseInt(br.readLine().trim());
        // 첫번째 명령 
        st = new StringTokenizer(br.readLine().trim());
        if (Integer.parseInt(st.nextToken()) != 100) return;
        rowSize= Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        rabbitCount = Integer.parseInt(st.nextToken());

        // rabbit id를 인덱스로 두고 거리 기록 
        rabbitDistanceForPId = new HashMap<>();
        for (int rabbitIdx = 0; rabbitIdx < rabbitCount; rabbitIdx++) {
            int rabbitPId = Integer.parseInt(st.nextToken());
            int rabbitDistance = Integer.parseInt(st.nextToken());
            rabbitList.add(new Rabbit(rabbitPId, rabbitDistance));
            rabbitDistanceForPId.put(rabbitPId, rabbitDistance);
        }

        commands = new int[commandCount - 2][3]; // 첫번째와 마지막은 뺀다.
        // 중간에 있는 명령들
        for (int commandIdx = 0; commandIdx < commandCount -2; commandIdx++) {
            st = new StringTokenizer(br.readLine().trim());
            int commandNumber = Integer.parseInt(st.nextToken());
            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());
            commands[commandIdx] = new int[]{commandNumber, number1, number2};
        }

        // 마지막 명령 pass
        st = new StringTokenizer(br.readLine().trim());
    }
}