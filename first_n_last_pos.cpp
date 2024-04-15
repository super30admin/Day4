//Time O(log n)
//Space O(1)
//leetcode: YES
//Issues seen: NONE
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int start = 0;
        int end = nums.size()-1;
        int mid = 0;

        while(start <= end) {
            mid = start + (end - start)/2;
            if(target <= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(start == nums.size() || nums[start] != target) {
            return {-1, -1};
        }
        //now we have the start index, now we need the right most limit
        int left = start;
         end = nums.size()-1;

         while(start <= end) {
            mid = start + (end - start)/2;
            if(nums[mid] > target) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return {left, end}; 
        
    }
};
