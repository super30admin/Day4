//Time Complexity- O(logn)
//Space Complexity- O(1)

class Solution {
public:
    int findMin(vector<int>& nums) {
        
        if(nums.size()==1){
            return nums[0];
        }
        
        if(nums[0]<nums[nums.size()-1]){
            return nums[0];
        }
        
        int start=0;
        int end=nums.size()-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(mid<nums.size()-1 && nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            else if(mid>0 && nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            else if(nums[mid]>=nums[start]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
};