// Finding Peak

//Time Complexity: O(logn)
//Space Complexity: O(1)
//Did this code successfully run on Leetcode : Yes

//Approach: 
//First we calculate the mid. We need conditions to check if mid is a corner element or if not compare with neighbours. 
//If mid is greater than neighbours, return index of mid.
//Else move the mid in the direction of greater neighbour.

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low = 0; 
        int high = nums.size() - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] > nums[mid - 1]) && 
            (mid == nums.size() - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }
            else if(mid < nums.size() - 1 && nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }

        }
        return low;
    }
};