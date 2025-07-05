import java.util.*;

/*
    RR 형식으로 1초간 음식을 먹는다.
    k 시간대(long type)에서 시작되는 index 값을 return
    => 만일 모든 음식이 다 먹고 없다면 -1 return
    
    k 시간대가 음식 갯수보다 많을 경우,
    음식 중 가장 적은 섭취 시간(minValue)을 뽑고 그 값과 k / foodCount 값과 비교한다.
    몫(p) = k / foodCount이 minValue 보다 크거나 같다면 
        해당 minValue를 0으로 없애고 모든 값들도 -1 * minValue값을 빼준다. 
    몫 < minValue 라면 
        나눈 값(q) = k % foodCount한 인덱스 값을( + 1) return 한다.
        
    ㄴ> 이 방법은 pq를 매번 돌려서 모든 값에 -minValue 만큼 빼주어야함 비효율적.
    
    prev값과 now값을 저장하여 
    k 시간대가 (now - prev) * foodCount 값 보다 크면 음식 배열을 1바퀴 돌 수 있고 가장 작은 now 값을 다 먹을 수 있음.
    
    [한바퀴 돌았을 경우]
    pq.poll(); // 음식 없앰
    foodCount--;    
    k -= (now - prev) * foodCount
    해당 now 값을 prev값에 저장
        
    .. 다시 k 시간대와 (now - prev) * foodCount로 1바퀴를 돌 수 있는 지 확인 (반복)
    => k 시간대가 작아서 한바퀴를 돌 수 없으면 index가 적은 순으로 순회하여 k % foodCount 값으로 index를 return한다.
*/
class Solution {
    
    public int solution(int[] food_times, long k) {
        long totalFoodTime = 0;
        for (long time : food_times) {
            totalFoodTime += time;
        }
        // 애초에 모든 음식의 시간보다 k 시간대가 크거나 같으면 
        // 다먹은 상태에서 return 할수있는건 없음 -> -1 return
        if (totalFoodTime <= k) return -1;

        long foodCount = food_times.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) return Long.compare(o1[1], o2[1]);
            return Long.compare(o1[0], o2[0]);
        });
        
        for (int idx = 0; idx < foodCount; idx++) {
            pq.offer(new long[] {idx + 1, food_times[idx]}); // 1-based
        }
        
        long prev = 0;
        long now = 0;
        long minusValue = 0;
        
        while (!pq.isEmpty()) {
            now = pq.peek()[1];
            minusValue = (now - prev) * foodCount;

            if (k >= minusValue) {
                k -= minusValue;
                prev = now;
                pq.poll();
                foodCount--;
            } else {
                break;
            }
        }
        
        List<long[]> remains = new ArrayList<>(pq);
        remains.sort(Comparator.comparingLong(o -> o[0]));

        return (int) remains.get((int)(k % foodCount))[0];
    }
}
