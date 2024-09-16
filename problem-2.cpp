//Time Complexity : O(logn)
//Space Complexity : O(1)
//Passed in leetcode : Yes
//Faced any problem : No

class Solution {
public:
    int findMin(vector<int>& nums) {
        int s=0,e=nums.size()-1,mid;
        while(s<=e){
            mid = s + (e-s)/2;
            if(mid==nums.size()-1)
                break;
            if(nums[mid]>nums[mid+1]){
                break;
            }
            if(nums[mid]>=nums[0]){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        if(mid==nums.size()-1)
            return min(nums[mid],nums[0]);
        return nums[mid+1];
    }
};