// TC-O(logN)
// SC-O(1)
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low=0;
        int high=nums.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==nums.size()-1||nums[mid]>nums[mid+1])&&(mid==0||nums[mid]>nums[mid-1])){
                return mid;
            }
            if(mid==nums.size()-1||nums[mid]<nums[mid+1]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return nums[low];
    }
};