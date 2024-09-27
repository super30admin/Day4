// Time Complexity : O(log n) + O(log n) == O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
public:
    int leftBinarySearch(int low, int high, vector<int>& nums, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            //If mid is the starting index
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] < nums[mid])){
                return mid;
            }
            //If mid is equal to target but not greater than it's predecessor, just move towards the left
            else if(nums[mid] == target && (mid == 0 || nums[mid - 1] == nums[mid])){
                high = mid - 1;
            }
            //normal binary search stuff
            else if(target <= nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }   
        }
        return -1;
    }
    
    int rightBinarySearch(int low, int high, vector<int>& nums, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            //If mid is the ending index
            if(nums[mid] == target && ((mid == nums.size() - 1) || nums[mid + 1] > nums[mid])){
                return mid;
            }
            //If mid is equal to target but not lesser than it's succesor, just move towards the right
            else if(nums[mid] == target && ((mid == nums.size() - 1) || nums[mid + 1] == nums[mid])){
                low = mid + 1;
            }
            //normal binary search stuff
            else if(nums[mid] <= target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }   
        }
        return -1;
    }
    
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> res;
        if(nums.size() == 0 || target < nums[0] || target > nums[nums.size() - 1]){
            res.push_back(-1);
            res.push_back(-1);
            return res;
        }
        if(nums.size() == 1 & target==nums[0]){
            res.push_back(0);
            res.push_back(0);
            return res;
        }
        //Search only for the start index
        int start = leftBinarySearch(0, nums.size() - 1, nums, target);
        //search only for the last index
        int end = rightBinarySearch(start, nums.size() - 1, nums, target);
        
        res.push_back(start);
        res.push_back(end);
        return res;
    }
};
