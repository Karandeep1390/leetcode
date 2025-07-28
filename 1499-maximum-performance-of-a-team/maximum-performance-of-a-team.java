class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int [][] pairs = new int[n][2];
        for(int i=0;i<n;i++) {
            pairs[i] = new int[]{speed[i], efficiency[i]};
        }

        Arrays.sort(pairs, (a,b) -> b[1] - a[1]);
        long res = 0, sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int [] pair : pairs) {
            int sp = pair[0];
            int ef = pair[1];

            sum += sp;
            pq.add(sp);

            if (pq.size() > k) sum -= pq.poll();
            res = Math.max(res, ef * sum);
        }

        return (int) (res % (long)(1e9 + 7));


    }
}