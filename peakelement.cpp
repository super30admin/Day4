//TC O(logn)
//SC O(1)
//here first we will check if it is the peak or not if ti is return it & taking care of the edge case
//if it is not peak we will move to the inc side since that will give us the peak element
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        int s =0;
        int e = n-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid ==e || nums[mid]>nums[mid+1])) return mid;
            else if(nums[mid]<nums[mid+1]) s =mid+1;
            else  e = mid-1;
        }
        return -1;
    }
};