// Time Complexity : O(Log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


// Your code here along with comments explaining your approach
/*
 * Use binary search.
 * If mid is less than its left and right element then return mid as the smallest element.
 * Else search in the unsorted part of array.
 */

class Solution {
public:
    int findMin(vector<int>& nums) {
        
        if (nums.size() == 1)
            return nums[0];
        
        int low = 0;
        int high = nums.size() - 1;
        int mid;
        
        while (low <= high)
        {
            if(nums[low] < nums[high])
                return nums[low];
            
            mid = low + (high - low)/2;
            
            if ((mid == 0 || (nums[mid] < nums[mid - 1])) && ((mid == nums.size() - 1) || (nums[mid] < nums[mid + 1])))
                return nums[mid];
                
            if (nums[low] <= nums[mid])
            {
                low = mid + 1;        
            }
            else
            {
                high = mid - 1;
            }
        }
        
        return -1;
        
    }
};