// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:

    int find(vector<int>& nums, int target, int l, int h, bool isFirst) {
                    int res = -1;
        while (l<=h) {
            int mid = l + (h-l)/2;
            if (nums[mid] == target) {
                res = mid;
                if (isFirst) h = mid-1;
                else l = mid+1;
            }
            else if (nums[mid] < target) l = mid+1;
            else h = mid-1;
        }
        return res;
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        if (nums.size() == 0) return {-1,-1};
        int n = nums.size();
        int first  = find(nums, target, 0, n-1, true);
        if(first == -1) return {-1,-1};
        int second = find(nums, target, first, n-1, false);
        return {first, second};
    }
};