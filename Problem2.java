/*
## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0
*/

// Time Complexity : O(log N): Binary Search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Optimised solution
// Your code here along with comments explaining your approach
//Approach-We will consider modified Binary Search. 
//base case: If mid element is lesser than its neighbouring element, then return mid element or 
//if during the iterative process, if mid element reaches the leftmost or rightmost element, return mid element
//otherwise, if mid element is lesser than high element, then bring high pointer to left side of mid, else bring low pointer to right side of mid.

class Solution {
    public int findMin(int[] nums){
        //edge case
        if(nums == null || nums.length == 0) return -1;
        //initialising low and high pointers
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            //case:if its perfectly sorted array, just return low element
            if(nums[low] < nums[high]){
                return nums[low];
            }
            //Finding mid element is iterative process. This is used to avoid integer overflow
            int mid = low + (high-low)/2;
            //base case
            //1.if mid element reaches leftmost or right most element, we will return mid element as it will be min.
            //2.if mid element is lesser than its neighbouring element, then return mid element
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length - 1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            else if(nums[mid] < nums[high]){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

//Brute force approach-Linear search takes O(N).
//Under this for each element is the array, if each element is lesser than its neighbouring element, return that element as min