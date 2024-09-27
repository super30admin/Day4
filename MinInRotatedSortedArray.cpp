//Time Complexity - O(log(n))
//Space Complexity - O(1)
//Problem ran on leet code successfully
//No problems faced


#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int low=0;
        int high=nums.size()-1;
        int mid;
        
        while(low<=high)
        {
            mid=low+(high-low)/2;
            
            //if both sides are sorted
            if(nums[mid]>=nums[low] && nums[mid]<=nums[high])
            {
                return nums[low];
            }
            
            if(nums[mid]>nums[low])
            {
                low=mid;
            }
            else
            {
                if(high-low==1)
                {
                    if(nums[high]>nums[low])
                    {
                        return nums[low];
                    }
                    else
                    {
                        return nums[high];
                    }
                }
                high=mid;
            }
        }
        
        return 12334;
    }
};