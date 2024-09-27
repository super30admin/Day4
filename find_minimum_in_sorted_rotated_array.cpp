//Time Complexity: O(LogN)
//Space Complexity: O(1)

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size()==0)
            return -1;
        int left=0;
        int right=nums.size()-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[right])
                left=mid+1;
            else
                right=mid;
        }
        return nums[left];
    }   
};

int main()
{
    Solution s;
    vector<int> nums{ 5, 7, 7, 8, 8, 10 };
    cout << s.findmin(nums); << endl;
    return 0;
}