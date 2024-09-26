/**

// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

problem Statement 
input :
nums = [1,2,3,1] peak is - 3
nums = [1,2,1,3,5,6,4] peak is 2

Assumptions :
- array is not empty
- multiple pivots then can be return any one of this.

Possible Solutions -
- Binary Search- O(logn)

[1]
[1,2]
[1,2,3]


**/
class Solution {
    public int findPeakElement(int[] nums) {
        
        if (nums.length == 1)
        {
            return 0;
        }
        
        if (nums.length == 2)
        {
            return nums[0] > nums[1] ? 0 : 1;
        }
        
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end - 1)
        {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] > nums[mid+1] && nums[mid] > nums[mid - 1])
            {
                return mid;
            }
            else if (nums[mid+1] > nums[mid])
            {
                start = mid;
            }
            else if (nums[mid-1] > nums[mid])
            {
                end = mid;
            }
        }
        
        return nums[start] > nums[end] ? start : end;
    }
}