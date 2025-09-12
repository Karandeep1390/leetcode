class Solution {
    public boolean search(int[] nums, int target) {
        int hi = nums.length-1;
        int lo = 0;
        
        while(lo <= hi) {
            int mid = (hi + lo)/2;
            
            if(nums[mid] == target) return true;
            else if (nums[lo] == nums[mid] && nums[hi] == nums[mid]) {
                lo++;
                hi--;
            } else if (nums[lo] <= nums[mid]) {
                if(nums[lo] <= target && nums[mid] > target) {
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }
            } else if (nums[mid] <= nums[hi]) {
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
        }
        
        return false;
    }
}