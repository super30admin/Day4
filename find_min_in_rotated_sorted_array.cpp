// Time Complexity : log N - we are using binary search 
// Space Complexity : O(1). We are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


// Check if the array range is sorted - if it is simply return the first element in search range
// If array is not sorted, find mid, check if mid is the minimum 
// if not, check if left array is sorted, if yes, min is in the right array
// if not, min is the left array. 

class Solution {
public:
    int findMin(vector<int>& nums) {

        int low = 0;
        int high = nums.size() - 1;
        while(low <= high)
        {
            if(nums[low] <= nums[high])
            {
                return nums[low];
            }
            
            int mid = low + ((high - low)/2);

            if(( mid == 0 || nums[mid] < nums[mid-1]) && 
                ( mid == nums.size()-1 || nums[mid] < nums[mid+1]))
            {
                return nums[mid];
            }
            else if( nums[low] <= nums[mid])
            {
                low = mid+1;
            }
            else
            {
                high = mid -1;
            }
        }

        return nums[0];
    }
};