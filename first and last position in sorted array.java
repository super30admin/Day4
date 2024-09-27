// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes	
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    private int binaryFirstSearch(int [] nums, int target){
        int l = 0;
        int h = nums.length - 1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }
                else{
                    h = mid - 1;
                }
            }
            else if(nums[mid] > target){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return -1;
    }
    private int binaryLastSearch(int [] nums, int target){
        int l = 0;
        int h = nums.length - 1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else{
                    l = mid + 1;
                }
            }
            else if(nums[mid] > target){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return new int [] {-1, -1};
        if(nums[nums.length - 1] < target || nums[0] > target) return new int [] {-1, -1};
        int f = binaryFirstSearch(nums, target);
        int l = binaryLastSearch(nums, target);
        return new int [] {f, l};
    }
}