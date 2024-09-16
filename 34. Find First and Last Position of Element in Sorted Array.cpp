//TC-logN
//SC-O(N)
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
         int first_count=-1;
        int second_count=-1;
        vector<int> result;
            int low=0;
        int high=nums.size()-1;
        int low2=0;
        int high2=nums.size()-1;
        while(low<=high){
    ;
            int mid=low+(high-low)/2;
            if(target>nums[mid]){
                low=mid+1;
            }
            if(target<nums[mid]){
                high=mid-1;
            }
            if(target==nums[mid]){
                first_count=mid;
                high=mid-1;
            }
        }
             while(low2<=high2){
        
      
            int mid=low2+(high2-low2)/2;
            if(target>nums[mid]){
                low2=mid+1;
            }
            if(target<nums[mid]){
                high2=mid-1;
            }
            if(target==nums[mid]){
                second_count=mid;
                low2=mid+1;
            }
        }
        result.push_back(first_count);
        result.push_back(second_count);
        return result;
    }
};