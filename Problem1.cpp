// FIrst and last element in Sorted Array

// Time complexity is 2 * O(logn) = O(logn)
// Space complexity is O(1)
// Did this code successfully run on Leetcode : Yes

// Approach:
// We want to use binary search twice. 
//First to find the first index of target
//If target is found we initialize low to that index and then use the second bonary search to find right

class Solution {
private: 
    int binarySearchFirst(vector<int> nums, int low, int high, int target){
         while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] != nums[mid - 1]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }
            else{low = mid + 1;}
        }
        return -1; 
    }

    int binarySearchLast(vector<int> nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.size() - 1 || nums[mid] != nums[mid + 1]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }
            else{low = mid + 1;}
        }
        return -1; 
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size() == 0){
            return {-1, -1};
        }
        if(target < nums[0] || target > nums[nums.size() - 1]){
            return {-1, -1};
        }
        int first = binarySearchFirst(nums, 0, nums.size() - 1, target);
        if(first == -1){return {-1, -1};}
        int last = binarySearchLast(nums, first, nums.size() - 1, target);
        return {first, last};
    }
};