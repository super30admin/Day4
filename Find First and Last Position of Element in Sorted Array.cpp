// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// We are doing separate binary search for first and last elements
// Because for finding first occurence we keep doing binary search in left half when we encounter mid that is same as mid-1 element.
// We should not iterate linearly towards left and right after finding mid that is equal to target. If we do a linear search then asymptotic time complexity will again become O(n)
class Solution {
public:
    int lowForLast = -1;
    int binarySearchFirst(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high) {
            int mid = (high - low) / 2 + low;
            if(nums[mid] == target) { // if we find target then find firs occurrence by doing BS until 0 or we find the first occurence, nums[mid - 1] < nums[mid]
                // checking for the first pos of target
                if(mid == 0 || nums[mid - 1] < nums[mid]) return mid;
                else high = mid - 1;
            }
            else if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    int binarySearchLast(vector<int>& nums, int target) {
        // optimization to search from the first occurence rather than starting search from the first index
        int low = lowForLast;
        int high = nums.size() - 1;
        while(low <= high) {
            int mid = (high - low) / 2 + low;
            if(nums[mid] == target) { // if we find target then find firs occurrence by doing BS until nums.size() - 1, or we find the first occurence, nums[mid] < nums[mid + 1]
                // checking for the last pos of target
                // imp take care of the order, first check validity of mid
                if(mid == nums.size() - 1 || nums[mid] < nums[mid + 1]) return mid;
                else low = mid + 1;
            }
            else if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size() == 0) return vector<int> {-1, -1};
        if(nums[0] > target || nums[nums.size() - 1] < target) return vector<int> {-1, -1};
        int first = binarySearchFirst(nums, target);
        if(first == -1) return vector<int> {-1, -1};
        lowForLast = first;
        int last = binarySearchLast(nums, target);
        return vector<int> {first, last};
    }
};