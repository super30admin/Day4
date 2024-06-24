# Binary-Search-2
Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].


Method:For FirstOccurence. I am checking if the middle element matches the target and if it does and then I am comparing the mid with mid-1 and at the same time mid==0 then returning mid. Else im moving to the right side of array. Then check if the target value is less or greater than the array firt or last element and manipulate the left and right pointers accordingly. I am doing the same for last occurance and then returning the index.


Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=searchFirst(nums,target,0, nums.length-1);
        if(first==-1)
            return new int[]{-1,-1};
        int last=searchLast(nums,target,first,nums.length-1 );
        int result[]=new int[2];
        result[0]=first;
        result[1]=last;
        return result;
    }
    
    public int searchFirst(int[] arr,int target,int left,int right){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                if(mid==0|| arr[mid]!=arr[mid-1]){
                    return mid;
                }
                else{
                    right=mid-1;
                }
            }
            else if(arr[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
            }
        return -1;
        }
        
    public int searchLast(int[] arr,int target,int left,int right){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                if(mid==arr.length-1 || arr[mid]!=arr[mid+1]){
                    return mid;
                }
                else{
                    left=mid+1;
                }
            }
            else if(arr[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
            }
        return -1;
    }
    
}

Method: Here I am checking if the middle element is smaller than its previous. If so I am directly returning mid since it is a rotated sorted array. Then I am checking if the left or right side of mid is sorted and the side which is sorted should probably be having the min element.
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

class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            if(mid!=0 &&nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            else if(nums[low]<=nums[mid])
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
}

Method: Checking if the middle element is greater than its left and right neighbours along with the edge cases of mid being 0 or length -1. If so directly returning mid. Else I am checking which side has greater element than the mid and adjusting the left and right pointer accordingly.
## Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 

             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.


class Solution {
    public int findPeakElement(int[] nums) {
        
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1]))
                    return mid;
            else if(mid>0 && nums[mid]<nums[mid-1]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}