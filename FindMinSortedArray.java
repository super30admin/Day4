//Time complexity is O(log N)
//Space complexity is O(1)
//able to submit in leetcode
class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r = nums.length-1;
        if(nums[l]<nums[r] || nums.length==1)
            return nums[l];
        while(l<=r){
            int m = l+(r-l)/2;
            if (nums[m] > nums[m + 1]) {
                return nums[m + 1];
            }

            if (nums[m - 1] > nums[m]) {
                return nums[m];
            }
            if(nums[m]>nums[0]){
                l = m+1;
            }
            else
                r= m-1;
        }

        return nums[0];
    }
}
