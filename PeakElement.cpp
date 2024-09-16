// Time Complexity : O(Log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


// Your code here along with comments explaining your approach
/*
 * Use binary search.
 * If mid is greater than its left and right element then return mid as peak element.
 * Else apply the binary search on the subarray which has a larger element i,e, (mid - 1) or (mid + 1).
 */

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if (nums.size() == 0)
            return -1;
        
        int low = 0;
        int high = nums.size() - 1;
        int mid;
        
        while (low <= high)
        {
            mid = low + (high - low)/2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && 
                (mid == nums.size() - 1 || nums[mid] > nums[mid + 1]))
                return mid;
            
            if (nums[mid] < nums[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
};