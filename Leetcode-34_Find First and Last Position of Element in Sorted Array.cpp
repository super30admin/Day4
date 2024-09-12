// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution 
{
    public:
        vector<int> searchRange(vector<int>& nums, int target) 
        {
            vector<int>res(2,-1);
            
            int low = 0, high = nums.size()-1;
            
            if (high == -1 || (high==0 && nums[high] != target))
                return res;
            
            res[0] = returnFirstOrLastIndex(nums, low, target);
            
            if(res[0] == -1)
                return res;
            
            res[1] = returnFirstOrLastIndex(nums, res[0], target, 0);
            
        return res;
                
        }
    
    int returnFirstOrLastIndex(vector<int> & nums, int low, int target, int first=1)
    {
        int high = nums.size()-1;
        
        while(low<=high)
        {
            int mid = low+ (high-low)/2;
            
            if(nums[mid] == target)
            {
                if (first ==1)
                {
					// if mid is first, last element, otherwise previous ele is less than target
                    if(mid == low || nums[mid-1] <target)
                        return mid;
                     
					// proceed to left half to find the first occurrence
                    else
                        high = mid-1;
                }
                
                else
                {
					// if mid is first, last element, otherwise next ele is greater than target
                    if(mid ==high || nums[mid+1] >target)
                        return mid;
                      
					// proceed to right half to find the last occurrence					  
                    else
                        low = mid+1;
                }
            }
            
			
			// search in left half
            else if(nums[mid]> target)
                high = mid-1;
            
			// search in right half
            else
                low = mid+1;
            
        }
        
        return -1;
    }
};