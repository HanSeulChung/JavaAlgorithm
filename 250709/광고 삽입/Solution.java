class Solution {
    static int playSec;
    static int advSec;
    static long maxViewSum;
    static int maxSumOfStartTime;
    static long[] viewSums;
    static String[] logs;
    
    public String solution(String play_time, String adv_time, String[] logs) {
        playSec = getTotalSec(play_time);
        advSec = getTotalSec(adv_time);
        this.logs = logs;
        
        checkAllViews();
        
        return getStringHMS(maxSumOfStartTime);
    }
    
    private void checkAllViews() {
        viewSums = new long[playSec + 1];
        for (String log : logs) {
            String[] timeLine = log.split("-");
            int startTime = getTotalSec(timeLine[0]);
            int endTime = getTotalSec(timeLine[1]);
            viewSums[startTime] += 1;
            viewSums[endTime] -= 1;
        }
        
        for (int time = 0; time < playSec; time++) {
            viewSums[time + 1] += viewSums[time]; // prefixSum
        }
        
        long curViewSum = 0;
        maxSumOfStartTime = 0;
        for (int time = 0; time < advSec; time++) {
            curViewSum += viewSums[time];
        }
        
        maxViewSum = curViewSum;
        for (int startTime = 1; startTime + advSec <= playSec; startTime++) {
            curViewSum -= viewSums[startTime - 1];
            curViewSum += viewSums[startTime  - 1 + advSec];
            
            if (curViewSum > maxViewSum) {
                maxViewSum = curViewSum;
                maxSumOfStartTime = startTime;
            }
        }
    }

    private int getTotalSec(String hms) {
        String[] arr = hms.split(":");
        return Integer.parseInt(arr[0]) * 3600 + Integer.parseInt(arr[1]) * 60 + Integer.parseInt(arr[2]);
    }

    private String getStringHMS(int totalSec) {
        int h = totalSec / 3600;
        int m = (totalSec % 3600) / 60;
        int s = totalSec % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
