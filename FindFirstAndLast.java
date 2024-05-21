// Time Complexity : o(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

// logic:
// To find first position: If mid - 1 position element is not equal to the target element then return mid.
// Else change high to mid-1 position.
// If target element is less than mid position element change high to mid-1 position else change low to mid+1 position.

// To find last position: If mid + 1 position element is not equal to the target element then return mid.
// Else change low to mid+1 position.
// If target element is less than mid position element change high to mid-1 position else change low to mid+1 position.



class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return new int[] {-1, -1};
        }
        int first = SearchFirstOccurance(nums, target);
        int last = SearchLastOccurance(nums, target);

        return new int[] {first, last};
    }

    private  int SearchFirstOccurance(int[]nums,int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2 ; // prevent integer overflow
            if(nums[mid] == target){
                if(mid == low || nums[mid - 1]!= target){
                    return mid;
                }
                high = mid - 1;
            }
            else if(target < nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }

    private  int SearchLastOccurance(int[]nums,int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2 ; // prevent integer overflow
            if(nums[mid] == target){
                if(mid == high || nums[mid + 1]!= target){
                    return mid;
                }
                low = mid + 1;
            }
            else if(target < nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }
}