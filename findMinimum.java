/*
* All test cases passed on leetcode
* Time complexity : O(logn)
* Space Complexity : O(1)
*/
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        int mid;
        while(low <= high){
            if(nums[low] < nums[high]){
                return nums[low];
            }
            mid = low + (high - low)/2;
            if((low == mid || nums[mid-1] > nums[mid]) && (high == mid || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
}