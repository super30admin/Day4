// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            // check if the array is sorted -> return nums[low]
            // = to because the array can be of size == 1
            if(nums[low] <= nums[high]) return nums[low];
            // check for min
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.size() - 1 || nums[mid] < nums[mid + 1])) return nums[mid];
            // check for the sorted side & eliminate that as min will be present in the unsorted side as the array is rotated so min is going towards unsorted side & 1st half is low till mid, 2nd half is mid + 1 till high
            // = to as nums can be of size 2
            else if(nums[low] <= nums[mid]) low = mid + 1;
            else high = mid - 1;
           }
        return -1;
   }           
};