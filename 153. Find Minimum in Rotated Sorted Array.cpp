// TC-O(LogN)
//     SC-O(1)
class Solution {
public:
    int findMin(vector<int>& nums) {
        int n=nums.size();
        int low=0;
        int high=n-1;
        int mid=0;
        
        
        while(low<high){
            mid=low+(high-low)/2;
            
            if(mid>0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
           else if(nums[mid]>=nums[low] && nums[mid]>nums[high]){
                low=mid+1;
            }
            else {
            high=mid-1;
            }
        }
        return nums[low];//when array is perfectly sorted
    }
};