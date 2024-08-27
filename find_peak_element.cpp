/*
 *                  Find Peak element in an array
 *
 * Leetcode : https://leetcode.com/problems/find-peak-element/
 * 
 * Time complexity : O(logN)
 * Space complexity : O(1)
 * 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : -
 * Your code here along with comments explaining your approach in three sentences only
 *          - Perform binary search towards the increasing side
 */
#include<iostream>
#include<vector>

using namespace std;

int peak_element_binary_search(vector<int> nums) {
    int low = 0;
    int high = nums.size() - 1;

    while(low <= high) {
        int mid = (low + high)/2;

        // Middle element is the peak element
        if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.size() - 1 || nums[mid] > nums[ mid + 1])) {
            return mid;
        } else if (mid > 0 && nums[mid] < nums[mid - 1]) { //
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return  -1;
}

int main() {

    vector<int> nums = {1,2,1,3,5,6,4};

    int ans = peak_element_binary_search(nums);
    cout << "Peak element is " << ans << endl;
    return 0;
}