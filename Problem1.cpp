class Solution {
private: 
    int binarySearchLeft(vector<int>& nums, int target){
        int low=0; int high = nums.size()-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid ==0||nums[mid]>nums[mid-1]){
                    return mid;
                }else {//left
                high = mid-1;
                }
            }else if(nums[mid]>target){
                high = mid-1;
            }else {
                low = mid+1;
            }
           
        }
         return -1;
    }
    
    int binarySearchRight(vector<int>& nums, int target){
        int low=0; int high = nums.size()-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                if(mid == nums.size()-1||nums[mid]<nums[mid+1]){
                    return mid;
                }else {//left
                low = mid+1;
            }
            }
            else if(nums[mid]>target)
            {
                high = mid-1;
            }else {
                low = mid+1;
            }
            
        }
        return -1;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        //if(nums.size()==NULL) return int[]{-1,-1};//if null
        
        vector<int> res(2, -1);
        if (nums.size() == 0 || (nums.size() == 1 && nums[0] != target))
            return res;
        res[0] = binarySearchLeft(nums,target);
        res[1] = binarySearchRight(nums,target);
        return res;
        
        
    }
};