/**
 * Time Complexity - O(logn)
 * Space Complexity - O(1)
 * Yes, this code ran on leetcode
 * In this problem as well we need to focus only conditions after evaculating mid for where to go left or right.
 */

class Solution {
    public int findMin(int[] nums) {
        int low=0, high= nums.length-1;

        if(nums.length==1)
            return nums[0];

        while(low < high){
            int mid = (low+high) >>1;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }else if(nums[mid] > nums[high]){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}