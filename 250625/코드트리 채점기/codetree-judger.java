import java.util.*;
import java.io.*;

/*
    명령수(Q, commandCount)대로 명령어 정보 주어짐

    [100 N u0] -> 채점기 준비, N개의 채점기가 있고 초기 문제의 url이 u0임을 의미
    [200 t p u] -> t초에 채점 우선순위가 p이고 url이 u인 문제에 대한 채점 요청이 들어옴
    [300 t] -> t초에 채점 대기 큐에서 즉시 채점이 가능한 경우 
            우선순위가 가장 높은 채점 task를 골라 채점을 진행하게된다는 의미
    [400 t J_id] t초에 Jid번 채점기가 진행하던 채점이 종료됨을 의미
    [500 t] -> t초에 채점 대기 큐에 있는 채점 task의 수를 출력
*/
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;

    static int commandCount;
    static String[] commands;
    static Task initTask;
    static int gradingMachineCount;
    static Task[] gradingMachine; // 채점기
    static Map<String, Task> domainMap;
    static PriorityQueue<Task> waitingQueue; // 대기 큐
    static Set<String> domainSet;
    static Set<String> urlSet;

    static class Task implements Comparable<Task> {
        int priorityOrder;
        int startTime;
        String domain;
        String url; // domain/문제ID

        boolean isComplete;
        int endTime;
        int gap;

        public Task(int priorityOrder, int startTime, String url) {
            this.priorityOrder = priorityOrder;
            this.startTime = startTime;
            this.url = url;
            this.domain = url.split("/")[0];

            this.endTime = 0;
            this.gap = 0;
            this.isComplete = false;
        }

        @Override
        public int compareTo(Task t) {
            if (t.priorityOrder != this.priorityOrder) return this.priorityOrder - t.priorityOrder;
            return this.startTime - t.startTime;
        }

        public void complete(int endTime) {
            this.isComplete = true;
            this.endTime = endTime;
            this.gap = this.endTime - this.startTime;
        }

        public void start(int startTime) {
            this.startTime = startTime;
        }

        public String toString() {
            return "this task.url: " + this.url;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initInput();
        br.close();

        grading();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void grading() {
        sb = new StringBuilder();
        domainMap = new HashMap<>();
        domainSet = new HashSet<>();

        for (String command: commands) {
            String[] commandArr = command.split(" ");
            int commandValue = Integer.parseInt(commandArr[0]);
            switch(commandValue) {
                case 200:
                    requestGrading(Integer.parseInt(commandArr[1]), 
                        Integer.parseInt(commandArr[2]), commandArr[3]);
                    break;
                case 300:
                    doGrading(Integer.parseInt(commandArr[1]));
                    break;
                case 400:
                    completeTask(Integer.parseInt(commandArr[1]), 
                        Integer.parseInt(commandArr[2]) - 1);
                    break;
                case 500:
                    sb.append(waitingQueue.size()).append("\n");
                    break;
            }
        }
    }

    private static void requestGrading(int time, int priorityOrder, String url) {
        if (urlSet.contains(url)) return;

        waitingQueue.add(new Task(priorityOrder, time, url));
        urlSet.add(url);
    }

    private static void doGrading(int time) {
        PriorityQueue<Task> tempQueue = new PriorityQueue<>();
        boolean isAssigned = false;

        while (!waitingQueue.isEmpty()) {
            Task task = waitingQueue.poll();
            Task prevTask = domainMap.get(task.domain);

            if (domainSet.contains(task.domain) || 
                (prevTask != null && prevTask.startTime + 3 * prevTask.gap > time)) {
                tempQueue.add(task);
                continue;
            }

            // 채점 가능한 채점기 찾기
            for (int idx = 0; idx < gradingMachineCount; idx++) {
                if (gradingMachine[idx] == null) {
                    task.start(time);
                    gradingMachine[idx] = task;
                    domainSet.add(task.domain);
                    urlSet.remove(task.url);
                    isAssigned = true;
                    break;
                }
            }

            if (!isAssigned) tempQueue.add(task);
            break; // 조건 맞는 task였는데 채점기는 없던 경우
        }

        // 나머지 되돌리기
        waitingQueue.addAll(tempQueue);
    }


    private static void completeTask(int time, int idx) {
        // idx인 채점기에 있는 task를 뺀다.
        Task completeTask = gradingMachine[idx];
        
        if (completeTask == null) return;

        // 채점기에서도 빼고, task 를 완료 시킨다.
        gradingMachine[idx] = null;
        completeTask.complete(time);

        // 해당 도메인의 Map과 Set을 갱신한다.
        domainMap.put(completeTask.domain, completeTask);
        domainSet.remove(completeTask.domain);
    }

    private static void initInput() throws IOException {
        commandCount = Integer.parseInt(br.readLine().trim());

        st = new StringTokenizer(br.readLine().trim());
        if (Integer.parseInt(st.nextToken()) != 100) {
            System.out.println("첫 명령어가 100이 아닙니다.");
            return;
        }
        
        gradingMachineCount = Integer.parseInt(st.nextToken());
        gradingMachine = new Task[gradingMachineCount];
        initTask = new Task(1, 0, st.nextToken());

        waitingQueue = new PriorityQueue<>();
        waitingQueue.add(initTask);

        urlSet = new HashSet<>();
        urlSet.add(initTask.url);
        commands = new String[commandCount - 1];
        for (int idx = 0; idx < commandCount - 1; idx++) {
            commands[idx] = br.readLine().trim();
        }
    }
}