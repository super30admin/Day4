class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int low = 0, high = nums.size()-1;
        int lowIndex = -1, highIndex = -1;
        vector<int> v;
       
        if(nums.size() == 0){
            v.push_back(lowIndex);
            v.push_back(highIndex);
            return v;
        } 
        while(low<=high) 
        {
            
            int mid = low + (high-low)/2; 
            if((mid == 0 && nums[mid] == target) ||
               ((mid-1)>=0 ) && nums[mid] == target && (nums[mid-1] < target || mid-1 == -1))
            {
                lowIndex = mid;
                break;
                
            }
            else if(nums[mid]<target){
                low = mid + 1;
            }
            
            else{
                high = mid - 1;
            }
          
        }
        low = 0, high = nums.size()-1;
        while(low<=high) 
        {            
           int mid = low + (high-low)/2
           if ((mid+1)<=high && nums[mid] == target && nums[mid+1] >target)
            {
                highIndex = mid;
                break;     
            }
            else if(nums[mid]<target){
                
                low = mid + 1;
            }
            else if(nums[mid] == target){
                highIndex = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
            
        }
        
        v.push_back(lowIndex);
        v.push_back(highIndex);
        return v;
    }
};
