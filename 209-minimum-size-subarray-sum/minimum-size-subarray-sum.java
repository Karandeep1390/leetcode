class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int window = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;

        int right = 0;

        while (right < nums.length) {
            window += nums[right];
            while (window >= target) {
                ans = Math.min(ans, right - left + 1);
                window -= nums[left++];
            }
            right++;
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}