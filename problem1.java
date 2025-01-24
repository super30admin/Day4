// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : struggled with the end condition (l<r or l<=r) of the binary search for the two passes. 


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[] {-1,-1};
        }
        if(nums.length == 1){
            if(nums[0] == target){
                return new int [] {0,0};
            }
            else{
                return new int [] {-1,-1};
            }
        }
        
        int start = -1, end = -1;
        int l = 0, r = nums.length - 1;

        while(l < r){
            int mid = l + (r - l)/2;

            if(nums[mid] >= target){
                r = mid;
            }
            else if(nums[mid] < target){
                l = mid + 1;
            }
        }

        if(nums[l] == target){
            start = l;
        }

        l = 0; r = nums.length-1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(nums[mid] <= target){
                l = mid + 1;
            }
            else if(nums[mid] > target){
                r = mid - 1;
            }
        }

        if(l != 0 && nums[l-1] == target){
            end = l-1;
        }

        if(start != -1 && end != -1){
            return new int[] {start,end};
        }

        return new int[] {-1,-1};
    }
}