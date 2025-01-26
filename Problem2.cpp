// Find minimum on sorted array

// Time complexity is O(logn) 
// space complexity is O(1)
// Did this code successfully run on Leetcode : Yes

// Approach:
// Binary Search. We want to find pivot element

// First check if element in low <= element in high in whichcasw return nums[low]
// Else get mid and check if middle element(if not in the starting or ending) is lesser than neighbours in whichcase it is pivot
// If not, Pivot will be in UNSORTED side so move there

class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0; 
        int high = nums.size() - 1; 
        while(low <= high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.size() - 1 || 
            nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return 7;
    }
};
