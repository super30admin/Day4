/*
 *                  Find First and Last Position of Element in Sorted Array
 *
 * Leetcode : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * 
 * Time complexity : O(logN) using binary search and O(N) using two pointers
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

// Using two pointer method :
// Time complexity : O(N) and Space Complexity : O(1)
vector<int> two_pointers(vector<int> nums, int target) {
    int low, high = 0;
    bool found = false;

    for(int i = 0; i < nums.size(); i++) {
        if (nums[i] == target) {
            if (!found) {
                low = i;
                found = true; 
            }
            high = i;
        } else if (found) {
            break;
        }
    }

    if (!found) {
        return {-1, -1};
    }

    return {low, high};
}
// Using binary search
// Time complexity : O(log N)  and Space Complexity : O(1)
int searchFirstArray(vector<int> nums, int target) {

    int left = 0;
    int right = nums.size() - 1;

    while (left <= right) {
        int mid = (left + right)/2;

        if (nums[mid] == target) {
            if (mid == left || nums[mid - 1] < nums[mid]) {
                return mid;
            }
            else {
                right = mid - 1;
            }
        }

        if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}

int searchSecondArray(vector<int> nums, int target) {

    int left = 0;
    int right = nums.size() - 1;

    while (left <= right) {
        int mid = (left + right)/2;

        if (nums[mid] == target) {
            if (mid == right || nums[mid + 1] > target) {
                return mid;
            }
            else {
                left = mid + 1;
            }
        }
        if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}

int main() {

    vector<int> nums = {5,7,7,8,8,10};
    vector<int> result;
    int start, end = 0;

    start = searchFirstArray(nums, 8);
    end = searchSecondArray(nums, 8);

    result.push_back(start);
    result.push_back(end);
    for(int i = 0; i < result.size(); i++) {
        cout << result[i] << " ";
    }

    return 0;
}