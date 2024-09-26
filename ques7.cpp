Time Complexity- O(log n)
Space Complexity-O(1)
Did the code execute on Leetcode- Yes

#include <iostream>
#include<vector>
using namespace std;

class Solution {
private:
    int lowerbound(vector<int>&nums,int target)
    {
        int low=0,high=nums.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]>=target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        if(low==nums.size()|| nums[low]!=target)
        {
            return -1;
        }
        return low;
    }
    
    int upperbound(vector<int>&nums,int target)
    {
        int low=0,high=nums.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]<=target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        if(high==-1 || nums[high]!=target)
        {
            return -1;
        }
        return high;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int>m={-1,-1};
        int l=0,h=nums.size()-1,k=0,q=0;
        m[0]=lowerbound(nums,target);
        m[1]=upperbound(nums,target);
        return m;
    }
};

int main() {
    vector<int>nums={5,7,7,8,8,10};
	Solution soln;
	vector<int>m=soln.searchRange(nums,8);
	for(int i=0;i<m.size();i++)
	{
	    if(i==m.size()-1)
	    {
	        cout<<m[i];
	    }
	    else
	    {
	    cout<<m[i]<<",";
	    }
	}
	return 0;
}
