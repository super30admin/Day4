// Time Complexity : O(Log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


// Your code here along with comments explaining your approach
/* Find first occurance of target using binary search.
 *    If mid is equal to target then check the left element, if it is smaller then return the mid as first occurance, else change higher bound to mid - 1.
 *    If mid is not equal to target then continue with binary search to find target.
 * After finding first occurance, use the binary search on sub-array after first occurance to get last occurance.
 *    If mid is equal to target then check the right element, if it is larger then return the mid as last occurance, else change lower bound to mid + 1.
 *    If mid is not equal to target then continue with binary search to find target.
 */

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if (nums.size() == 0)
            return {-1, -1};
        
        int start, end;
        
        start = binarySearchLeft(nums, 0, nums.size() - 1, target);
        
        if (start == -1)
            return {-1, -1};
        
        end = binarySearchRight(nums, start, nums.size() - 1, target);
        return {start, end};
    }
    
    int binarySearchLeft(vector<int>& nums, int low, int high, int target)
    {
        int mid;
        while (low <= high)
        {
            mid = low + (high - low) / 2;
            
            if (nums[mid] == target)
            {
                if (mid == 0 || nums[mid - 1] < target)
                    return mid;
                high = mid - 1;
            }
            else 
            {
                if (nums[mid] < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        
        return -1;
    }
    
    int binarySearchRight(vector<int>& nums, int low, int high, int target)
    {
        int mid;
        while (low <= high)
        {
            mid = low + (high - low) / 2;
            
            if (nums[mid] == target)
            {
                if (mid == nums.size() - 1 || nums[mid + 1] > target)
                    return mid;
                low = mid + 1;
            }
            else
            {
                if (nums[mid] < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }       
        return -1;
    }
};