//TC: O(log(N))
//SC: O(1)

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        
        //if(nums.size() == 0) return {-1, -1};
        
        int l = 0;
        int r = nums.size()-1;
        
        //search in the array for left most element first and then right more element
        
        int low = searchHelp(nums, 0, r, target, true);
        int high = searchHelp(nums, 0, r, target, false);
        
        vector<int> ans = {low, high};
        
        return ans;
        
    }
    
    
    //helper function to do binary search for left and right side 
    int searchHelp(vector<int>& nums, int l, int r, int target, bool left){
        
        while(l <= r){
            
            int mid = l+ (r-l)/2;
                
            if(nums[mid] == target){
                
                if(left){
                    //if searching in left side, then check if mid is first or if mid-1 is not mid. If we reach this then we have reached the left most part.
                    //Similar story for right
                    if(mid == 0 || nums[mid-1] != nums[mid])
                        return mid;
                    else r= mid-1;
                } else{
                    if(mid == nums.size()-1 || nums[mid+1] != nums[mid])
                        return mid;
                    else l = mid+1;
                }
            }
            
            //else do normal binary search till we find the required element
            else if(target > nums[mid])
                l = mid+1;
            else r = mid-1;     
        }
        
        return -1;
        
        
    }
    
    
};