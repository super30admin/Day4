// Time Complexity : worst case: O(log n) for, n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no                                              


// Your code here along with comments explaining your approach

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if(nums.size() == 1 || nums[0] > nums[1])
            return 0;

        if(nums[nums.size() - 1] > nums[nums.size() - 2])
            return nums.size() - 1;

        int low = 1;
        int high = nums.size() - 2;

        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;
            
            else if (nums[mid] < nums[mid+1])
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
        
    }
};