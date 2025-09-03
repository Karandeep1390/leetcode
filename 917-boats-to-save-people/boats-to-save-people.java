class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boatsCount = 0;

        int i = 0;
        int j = people.length-1;

        while (i <= j) {
            int weight = people[i] + people[j];
            if (weight <= limit) {
                boatsCount++;
                i++;
                j--;
            } else {
                j--;
                boatsCount++;
            }
        }

        return boatsCount;
    }
}