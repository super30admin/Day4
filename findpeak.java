/*
* All test cases passed on leetcode
* Time complexity : O(logn)
* Space Complexity : O(1)
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        int mid;
        while(low <= high){
            mid = low + (high - low)/2;
            if((low == mid || nums[mid-1] < nums[mid]) && (high == mid || nums[mid] > nums[mid + 1])){
                return mid;
            }
            if(mid == high || nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
}