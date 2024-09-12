// Time Complexity - It is O(logn) since we are using Binary search to find the element and reducing the search space by half in every iteration.
// Space Complexity - It is O(n) since it depends on the number of elements in the array. Is my answer correct for Space complexity?
// Problems Faced - No!
// It runs on Leetcode.

class Solution {
public:
    int findMin(vector<int>& nums) {
        
        int low = 0;
        int high = nums.size() - 1;
        int mid;
        
        // We are trying to find the pivot and the rule we are implementing is that our pivot will be less than both the element on its left and the lement on its right.
        // To refine our search space we are checking which side is sorted(left or right of "mid"). The pivot will surely lie on the side which is unsorted.
        // We also check if we have reached a situation where both sides are sorted(In that case nums[low] <= nums[high])
        while(low <= high){
            if(nums[low] <= nums[high])
                return nums[low];
            mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.size() - 1 || nums[mid] < nums[mid+1]))
                return nums[mid];
            else if(nums[low] <= nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return -1;
    }
};
