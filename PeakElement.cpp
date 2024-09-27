#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if(nums.size() == 0)
        {
            return -1;
        }
        
        int low = 0;
        int high = nums.size() - 1;
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2; //To avoid integer overflow
            
            if((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.size() - 1 || nums[mid + 1] < nums[mid]))
            {
                return mid;
            }
            else if(nums[mid + 1] > nums[mid])
            {
                low = mid + 1;     
            }
            else
            {
                high = mid - 1;       
            }
        }
        return -1;
    }
};