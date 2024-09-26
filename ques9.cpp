Time Complexity-O(log n)
Space Complexity-O(1)
Did the code execute successfully on Leetcode-Yes

#include <iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low=0,high=nums.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && 
               (mid==nums.size()-1 || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(nums[mid+1]>nums[mid])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }
};

int main() {
    vector<int>nums={1,2};
    Solution soln;
    int result=soln.findPeakElement(nums);
	cout<<result;
	return 0;
}
