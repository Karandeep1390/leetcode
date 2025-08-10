class Solution {
    public double averageWaitingTime(int[][] customers) {
        double timeWaiting = 0;
        int finishedPrev = 0;
        int n = customers.length;

        for(int [] times : customers) {
            int arriveTime = times[0];
            int startTime = Math.max(arriveTime, finishedPrev);
            int endTime = startTime + times[1];

            finishedPrev = endTime;
            timeWaiting += endTime - arriveTime;
        }

        return timeWaiting/n;
    }
}