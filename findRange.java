/*
* All test cases passed on leetcode
* Time complexity : O(logn)
* Space Complexity : O(1)
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeftMostIndex(nums, 0, nums.length -1, target);
        int right = findRightMostIndex(nums, 0, nums.length -1, target);
        
        return new int[]{left,right};
       
    }
    public int findLeftMostIndex(int[] nums, int low, int high, int target){
        int mid;
        while(low <= high){
            mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(low == mid || nums[mid - 1] < nums[mid]){
                    return mid;
                }
                else{
                    high = mid -1;
                }
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    
    public int findRightMostIndex(int[] nums, int low, int high, int target){
        int mid;
        while(low <= high){
            mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(high == mid || nums[mid] < nums[mid + 1]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}