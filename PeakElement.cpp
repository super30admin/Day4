// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        if (n==1) return 0;
        // if (nums[0] > nums[1]) return 0;
        // if (nums[n-1] > nums[n-2]) return n-1;
        int l = 0;
        int h = n-1;
        while (l<=h) {
            int mid = l+(h-l)/2;
            if ((mid == 0 || nums[mid] > nums[mid-1])
              && (mid == n-1 ||nums[mid] > nums[mid+1])) return mid;
            else if (mid >0 && nums[mid] < nums[mid-1]) h = mid-1;
            else l = mid+1;
        }
        return -1;
    }
};