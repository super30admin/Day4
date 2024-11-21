// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// find the target then check if the next value is grater or less as per the left or right case and then reduce reassign the high and low pointer
// Your code here along with comments explaining your approach
class Solution {
    private int bsLeft(int[] nums, int target){
        int low = 0; int high = nums.length-1;
        while( low <= high ){
            int mid = low + (high - low) / 2;
            if( nums[mid] == target){
                if(mid == 0||nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if ( nums[mid] > target ){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    private int bsRight(int[] nums, int target){
        int low = 0; int high = nums.length-1;
        while( low <= high ){
            int mid = low + (high - low) / 2;
            if( nums[mid] == target){
                if(mid == high ||nums[mid+1] > nums[mid]){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if ( nums[mid] > target ){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int index = 0;
        int [] result = new int [] {-1,-1};
        // null
        if( nums == null || nums.length == 0) return result;
        if( nums[0] > target || nums[nums.length-1] < target ) return result;
        int low = 0;
        int left = bsLeft(nums, target);
        if( left == -1) return result;
        result[index++] = left;
        int right = bsRight(nums, target);
        result[index++] = right;
        return result;
    }
}