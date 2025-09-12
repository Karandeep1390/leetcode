class Solution {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        int hi = x;
        int lo = 0;
        int ans = 0;

        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;

            if(mid > 0 && mid <= x/mid) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
}