#include <vector>
#include "limits.h"

using namespace std;


//Time Complexity : O(log n)
//Space Complexity : O(1)
//Leetcode : Yes
//Problem : No

class Solution {
public:
    int findMin(vector<int>& nums) {
        
        if(nums.size() == 0)
        {
            return INT_MAX;
        }
        int low = 0;
        int high = nums.size() - 1;
        if(nums[low] <= nums[high])
        {
            return nums[low];
        }
        
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(nums[low] <= nums[high])
            {
                return nums[low];
            }
            
            if(( mid == 0 || nums[mid] < nums[mid - 1]) &&  (mid == nums.size() - 1 || nums[mid] < nums[mid + 1]))
            {
                return nums[mid];
            }
            
            else if(nums[mid] >= nums[low])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        
        return INT_MAX;
    }
};