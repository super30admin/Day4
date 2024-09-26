class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size()==0)
            return -1;
        int low =0;
        int minimum = 0;
        int high = nums.size()-1;
        while(low<=high)
        {
            if(nums[low]<=nums[high]) return nums[low];
            int mid = low+(high-low)/2;
            if((mid==0||nums[mid]<nums[mid-1]) && (mid==nums.size()-1 ||nums[mid]<nums[mid+1]))
            {
                return nums[mid];
            }else if(nums[low]<=nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
            
        }
        return 71717;
    }
};