class Solution {
    public int removeDuplicates(int[] nums) {
        int insert = 0;

        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[insert]) {
                insert++;
                nums[insert] = nums[i];
            }
        }

        return insert+1;
    }
}