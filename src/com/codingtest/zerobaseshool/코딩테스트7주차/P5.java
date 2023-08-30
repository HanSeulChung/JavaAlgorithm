package com.codingtest.zerobaseshool.코딩테스트7주차;

public class P5 {
    int[] nums, cumSum;
    public int solution(int[] nums) {
        int N = nums.length;
        this.nums = nums;
        cumSum = new int[N];
        cumSum[0] = nums[0];
        for (int i = 1; i < N; i++) {
            cumSum[i] = cumSum[i - 1] + nums[i];
        }

        return solve(0, N - 1);
    }

    public int S(int l, int r) { // 구간 합을 누적합으로 빠르게 계산
        if (l == 0) {
            return cumSum[r];
        } else {
            return cumSum[r] - cumSum[l];
        }
    }

    // left ~ right 사이에서 최적값 찾기
    // 아래 세 구간으로 나누어서 구간별로 최적합 찾기
    // (재귀)           (투포인터)             (재귀)
    // left~mid 구간,    mid에 걸쳐있는 구간,    mid~right 구간

    public int solve(int left, int right) {
        if (left == right) {
            return nums[left] * nums[left];
        }

        int mid = left + (right - left) / 2;
        int ret = Math.max(solve(left, mid), solve(mid + 1, right));

        int l = mid;
        int r = mid + 1;
        int mn = Math.min(nums[l], nums[r]);
        ret = Math.max(ret, (nums[l] + nums[r]) * mn);

        while (left < l || r < right) {
            if ((r < right) && (left == l || nums[l - 1] < nums[r + 1])) {
                r++;
                mn = Math.min(mn, nums[r]);
            } else {
                l--;
                mn = Math.min(mn, nums[l]);
            }
            ret = Math.max(ret, S(l, r) * mn);
        }
        return ret;
    }
}
