//Time Complexity- O(logn)
//Space Complexity- O(1)

class Solution {
public:
    
    int first_index(vector<int> nums,int x){
        
        int n=nums.size();
        int index=-1;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==x){
                index=mid;
                end=mid-1;
            }
            else if(nums[mid]>x){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return index; 
    }
    
    int last_index(vector<int> nums,int x){
        int n=nums.size();
        int index=-1;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==x){
                index=mid;
                start=mid+1;
            }
            else if(nums[mid]>x){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return index; 
    }
    
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result(2);
        result[0]=first_index(nums,target);
        result[1]=last_index(nums,target);
        
        return result;
    }
};