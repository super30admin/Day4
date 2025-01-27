// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();
        // if (n==1) return nums[0];
        int l = 0;
        int h = n-1;
        while (l<=h) {
            if (nums[l] <=nums[h]) return nums[l];
            int mid = l + (h-l)/2;
            if ((mid ==0 || nums[mid] < nums[mid-1]) && (mid==n-1 || nums[mid] <nums[mid+1])) return nums[mid];
            else if (nums[l] <= nums[mid]) l = mid+1;
            else h = mid-1;
        }
        return -1;
    }
};