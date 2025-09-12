class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = Arrays.stream(weights).max().getAsInt();
        int hi = Arrays.stream(weights).sum();
        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;

            if (checkIfPossible(mid, days, weights)) {
                ans = mid;
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }

        return ans;
    }

    private boolean checkIfPossible(int capacity, int totalDays, int[] weights) {
        int daysRequiredToShip = 1;
        int eachDayWeight = 0;

        for(int wt : weights) {
            if (eachDayWeight + wt > capacity) {
                daysRequiredToShip++;
                eachDayWeight = 0;
            }
            eachDayWeight += wt;
        }

        return daysRequiredToShip <= totalDays;
    }
}