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
// Brute force approach : O(N)
int minRotatedArray(vector<int> &nums) {
    int minimum = INT_MAX;
    for(int i = 0; i < nums.size(); i++) {
        minimum = min(nums[i], minimum);
    }
    return minimum;
}

// Binary Search

int minBinarySearch(vector<int> &nums) {
    int low = 0;
    int high = nums.size() - 1;

    while (low <= high) {
        if (nums[low] <= nums[high]) { // Condition where everything is sorted
            return nums[low];
        }

        int mid = (low + high)/2;

        if ( mid > 0 && nums[mid] < nums[mid - 1] ) { // Mid is the minimum number
            return nums[mid];
        } else if (nums[low] <= nums[mid]) { // Left is sorted
            low = mid + 1;
        } else { 
            high = mid - 1;
        }
    }

}
int main() {

    vector<int> nums = {4,5,6,7,1,2};

    //int ans = minRotatedArray(nums);
    int ans = minBinarySearch(nums);
    cout << "Minimum is " << ans << endl;
    return 0;
}