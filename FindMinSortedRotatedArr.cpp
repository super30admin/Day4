// Time Complexity = O(log(n))
// Space Complexity = O(1)
// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Find Minimum in Rotated Sorted Array.
// Memory Usage: 10.2 MB, less than 22.04% of C++ online submissions for Find Minimum in Rotated Sorted Array.




class Solution {
public:
    int findMin(vector<int>& nums) {
        
        int low = 0, high = nums.size()-1;
        int mid;
        
        if (nums[low] <= nums[high]) return nums[low];
        
        while(low <= high) {
            mid = (low+high)/2;
            
            if (nums[mid] > nums[mid+1]) return nums[mid+1];
            else if (nums[mid-1] > nums[mid]) return nums[mid];
            else if (nums[high] > nums[mid]) high = mid-1;
            else low = mid+1;
        }
        return nums[mid];
    }
};