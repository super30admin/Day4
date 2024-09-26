/**

// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

ProblemStatement - 
nums = [5,7,7,8,8,10], target = 8
ouput = [3,4]

nums = [5,7,7,8,8,10], target = 9
ouput = [-1, -1]

Assumptions & clarifying quesions
- n <= 10^5
- array is not empty.

Solutions:
nums = [5,7,7,8,8,10]
mid = 7
target > mid then both start & end is on right side.

target < mid both on the left 

target == mid then it can be start, end, middle point.
 -> apply binary search on left portion including mid 
 -> apply binary search on right portion including mid.

TC - O(logn)
SC - O(1)

**/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if (nums == null || nums.length == 0)
        {
            return new int[] {-1, -1};
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        // refine the condition later 
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            
            if (target > nums[mid])
            {
                start = mid + 1;
            }
            else if (target < nums[mid])
            {
                end = mid - 1;
            }
            else
            {
                int output[] = new int[2];
                output[0] = searchInLeftHalf(nums, start, mid, target);
                output[1] = searchInRightHalf(nums, mid + 1, end, target);
                
                return output;
            }
        }
        
        return new int[] {-1, -1};
    }
    
    private int searchInLeftHalf(int nums[], int start, int end, int target)
    {
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            
            if (target > nums[mid])
            {
                start = mid + 1;
            }
            else if (target <= nums[mid])
            {
                end = mid - 1;
            }
        }
        
        return nums[start] == target ? start : -1;
    }
    
    
    private int searchInRightHalf(int nums[], int start, int end, int target)
    {
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            
            if (target >= nums[mid])
            {
                start = mid + 1;
            }
            else if (target < nums[mid])
            {
                end = mid - 1;
            }
        }
        
        return nums[end] == target ? end : -1;
    }
}