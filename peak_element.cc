// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
class Solution {
public:
    
    int peakFinder(int low, int high, vector<int>& nums){
        if(nums.empty()) return -1;
        if(nums.size() == 1) return 0;
        if(low > high) return -1;
        int mid = low + (high - low)/2;
        //Peak is always greater than it's immediate neighbors
        if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.size() - 1 || nums[mid] > nums[mid + 1])){
            return mid;
        }
        //Move towards the greater side always
        else if(mid > 0 && nums[mid] < nums[mid - 1]){
            high = mid - 1;
        }
        else if((mid < nums.size() - 1 && nums[mid] < nums[mid + 1])){
            low = mid + 1;
        }
        return peakFinder(low, high, nums);
    }
    
    
    int findPeakElement(vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;
        return peakFinder(low, high, nums);
        
    }
};
