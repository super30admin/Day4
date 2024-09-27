#include <vector>
#include "limits.h"

using namespace std;


//Time Complexity : O(log n)
//Space Complexity : O(1)
//Leetcode : Yes
//Problem : No

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size() == 0)
        {
            return vector<int>{-1,-1};
        }
        
        int left = binarySearchLeft(nums,target);
        int right = binarySearchRight(nums,target);
        
        return vector<int>{left , right};
    }
    
    int binarySearchLeft(vector<int>& nums,int target)
    {
        int low = 0;
        int high = nums.size() - 1;
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2; //To avoid integer overflow
            
            if(nums[mid] == target)
            {
                if(mid == 0 || nums[mid - 1] < target)
                {
                    return mid;
                }
                else
                {
                    high = mid - 1;
                }
            }
            else if(nums[mid] < target)
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
    
    int binarySearchRight(vector<int>& nums,int target)
    {
        int low = 0;
        int high = nums.size() - 1;
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2; //To avoid integer overflow
            
            if(nums[mid] == target)
            {
                if(mid == nums.size() - 1 || nums[mid + 1] > target)
                {
                    return mid;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else if(nums[mid] < target)
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