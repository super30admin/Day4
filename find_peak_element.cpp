// Time Complexity : log N - we are using binary search 
// Space Complexity : O(1). We are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


// Find mid, check if mid is peak 
// if not, move towards higher "slope" i.e. whichever neighbour is greater than mid
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;

        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid-1] < nums[mid]) &&
               (mid == nums.size() -1 || nums[mid+1] < nums[mid]))
            {
                return mid;
            }
            else if(mid == 0 || nums[mid-1] < nums[mid])
            {
                low = mid+1;
            }
            else
            {
                high = mid -1;
            }
        }
        return -1;
        
    }
};