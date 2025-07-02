
/*
    전체 방 개수(long)에서 손님에게 배정되는 방 번호를 순서대로 배열에 담아 return
    
    [방 배정 규칙]
    1. 손님이 원하는 방번호가 비어있는 방일 경우 바로 배정
    2. 손님이 원하는 방번호가 비어있지않은 경우 비어있는 방중에 가장 작은 방번호로 배정
*/

import java.util.*;

class Solution {
    static Map<Long, Long> map;
    
    public long[] solution(long k, long[] room_number) {
        int guestCount = room_number.length;
        long[] answer = new long[guestCount];
        map = new HashMap<>();
        
        for (int idx = 0; idx < guestCount; idx++) {
            answer[idx] = getRoomNumber(room_number[idx]);
        }
        
        return answer;
    }
    
    private long getRoomNumber(long wantedRoomNumber) {
        if (map.get(wantedRoomNumber) == null) {
            map.put(wantedRoomNumber, wantedRoomNumber + 1);
            return wantedRoomNumber;
        }
          
        long next = getRoomNumber(map.get(wantedRoomNumber));
        map.put(wantedRoomNumber, next);
        return map.get(wantedRoomNumber);
    }
}
