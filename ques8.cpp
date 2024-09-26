Time Complexity-O(log n)
Space Complexity-O(1)
Did the code run on Leetcode-yes

#include <iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size()==0)
        {
            return -1;
        }
        int l=0,h=nums.size()-1;
        while(l<h)
        {
            int mid=l+(h-l)/2;
            if(nums[mid]>nums[h])
            {
                l=mid+1;
            }
            else
            {
                h=mid;
            }
        }
        return nums[l];
    }
};

int main() {
    vector<int>m={3,4,5,1,2};
    Solution soln;
    int result=soln.findMin(m);
    cout<<result;
	
	return 0;
}
