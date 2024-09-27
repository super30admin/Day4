// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
1. If mid is target see if its the first by comparing the left element, if not go left to find the first element
2. If no first element found return -1
3. If mid is the target element, compare to the next element
4. If next element is also the target element do  binary search on the right half to find last index
5. If no last element is found return last element
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = -1;
        int right = - 1;
        left = findStartIndex(nums, target);
        right = findEndIndex(nums, target);
        int[] ans = new int[2];
        ans[0] = left;
        ans[1] = right;
        
        return ans;
    }
    
    public int findStartIndex(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid-1] < nums[mid]) 
                    return mid;
                else
                    end = mid - 1;
            } else {
                if(nums[mid] < target)
                    start = mid+1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
    
    public int findEndIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
                
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid+1] > nums[mid]) 
                    return mid;
                else
                    start = mid + 1;
            } else {
                if(nums[mid] < target)
                    start = mid+1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}