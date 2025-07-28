class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        long sum = 0L;
        for(int num : nums) sum += num;

        int n = nums.length;
        int k = (int)(target/sum);
        int res = n;

        target %= sum;
        if (target == 0) return k*n;

        HashMap<Long, Integer> dp = new HashMap<>();
        dp.put(0L, -1);

        sum = 0L;

        for(int i=0;i<2*n;i++) {
            sum += nums[i%n];

            if(dp.containsKey(sum - target)) {
                res = Math.min(res, i - dp.get(sum - target));
            }

            dp.put(sum, i);
        }

        return res < n ? res + k * n : -1;
    }
}