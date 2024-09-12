// Time Complexity - It is O(logn) since we are using Binary search to find the element and reducing the search space by half in every iteration.
// Space Complexity - It is O(n) since it depends on the number of elements in the array. Is my answer correct for Space complexity?
// Problems Faced - No!
// It runs on Leetcode.

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;
        int mid;
        
        // The peak element would be greater than both the element on its right as well as the element on its left.
        // We are refining our search space by choosing the side of mid wherever the element next to it is greater(It might be left or right)
        while(low <= high){
            mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.size() - 1 || nums[mid] > nums[mid + 1]))
                return mid;
            else if(mid > 0 && nums[mid] < nums[mid - 1])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
};
