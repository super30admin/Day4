//Time Complexity - O(log(n))
//Space Complexity - O(1)
//Problem ran on leet code successfully
//No problems faced

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low=0;
        int high=nums.size()-1;
        int mid;
        while(low<=high)
        {
            mid=low + (high-low)/2;
            
            if(( mid==0|| nums[mid]>nums[mid-1]) && (mid==nums.size()-1 || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            if(nums[mid+1]>nums[mid])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return 213212;
    }
};