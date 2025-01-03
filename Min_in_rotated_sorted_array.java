// ## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

// Find the minimum element.

// You may assume no duplicate exists in the array.

// Example 1:
// Input: [3,4,5,1,2]
// Output: 1

// Example 2:
// Input: [4,5,6,7,0,1,2]
// Output: 0


// Time Complexity :O (log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes


class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0){         //Base condition
            return -1;
        }
        int low=0;
        int high=nums.length-1;
        while(low<=high){                      // To find mid there are 3 condition 1. if the array is sorted return the first element. 
                                                //2. If both the adjacent elements are greater than the element return it ELSE move to unsorted side
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            if((mid>low && nums[mid] < nums[mid-1]) && (mid<high && nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            else{
                if(nums[low]<=nums[mid]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}



