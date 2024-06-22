// It adjusts the search range based on whether the middle element is greater than the rightmost element, thereby narrowing down to the smallest value. The loop continues until the search range converges, and the minimum value is returned.

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        if (nums == null || nums.length == 0) {
            return -1;
        }
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>nums[r]){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return nums[l];
    }
}