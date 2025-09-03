class Solution {
     public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        k = k%n;
        reverse(0, n, nums);
        reverse(0, k, nums);
        reverse(k, n, nums);
    }

    private void reverse(int left, int right, int[] nums) {
        int i = left;
        int j = right-1;
        
        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }
    
    private void swap(int i, int j, int [] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}