// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if(nums.size() == 1)
            return 0;
        int low = 0;
        int high = nums.size()-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            //if the mid you have reached is the peak, return it 
            if((mid==0 || nums[mid] > nums[mid-1]) and (mid == nums.size()-1 || nums[mid] > nums[mid+1])){
                return mid;
            }
            //otherwise, always go to the side where there is a higher element
            //if there is atleast 1 higher element, the peak *has* to exist there
            //why? The last element is -infinity -> if nothing, atkeast that element you checked will be the peak
            if(nums[mid] < nums[mid+1]){
                low = mid+1;
            }

            //if right is not the higher element, go to left
            else
                high = mid-1;
        }
        return -1;
    }
};