/*
 *                  Find Minimum in Rotated Sorted Array
 *
 * Leetcode : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * 
 * Time complexity : O(logN)
 * Space complexity : O(1)
 * 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : -
 * Your code here along with comments explaining your approach in three sentences only
 *          - Perform binary search twice, once to find the first occurrence and 
 *            once to find the last occurrence of the target.
 */
#include<iostream>
#include<vector>

using namespace std;

int minRotatedArray(vector<int> &nums) {
    int minimum = INT_MAX;
    for(int i = 0; i < nums.size(); i++) {
        minimum = min(nums[i], minimum);
    }
    return minimum;
}
int main() {

    vector<int> nums = {4,5,6,7,1,2};

    int ans = minRotatedArray(nums);
    cout << "Minimum is " << ans << endl;
    return 0;
}