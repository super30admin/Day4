/*The code aims to find the minimum element in a rotated sorted array using binary search.
It compares the middle element with its neighbors to determine if the minimum lies to the left or right.
The search space is adjusted accordingly until the minimum element is found.
Time Complexity: O(log n)
Space Complexity: O(1)*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;
            if (nums[mid] < nums[next] && nums[mid] < nums[prev]) {
                return nums[mid];
            } else if (nums[l] <= nums[mid] && nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
     
        return nums[0];
    }
};
