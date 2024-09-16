Time Complexity :O(log N)
// Space Complexity : constant
// Did this code successfully run on Leetcode :Yes
class Solution {
    public int findPeakElement(int[] nums) {
        int peakIndex;
        if(nums.length == 1) return 0;
        if(nums[nums.length-1] > nums[nums.length-2] ) return nums.length-1;
        int j = 1, k = nums.length-2;
        while(j<k){
            int check = (j + k)/2;
            if(nums[check] > nums[check + 1] && nums[check] > nums[check-1])
                return check;

            else if(nums[check] < nums[check+1]){
                j = check+1;
            }
            else{
                k = check-1;
            }
        }
        return k;
    }
}
        
