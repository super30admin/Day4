// Question:

//  Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Description: 
// Time Complexity :O (log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0 || nums==null){              //Base condition
            return new int[] {-1,-1};
        }
        if(target < nums[0] || target > nums[nums.length-1]){     //If target is less than or greater than low and high respectively
            return new int[] {-1,-1};
        }
        
        int start=-1;
        int end=-1;
        start = findStartIndex(nums,target);         //We will find the first occurence 
        if(start!=-1){                                  
            end=findLastIndex(nums,target);        // If first occurence is present then only search for last instance 
        }

        return new int[]{start,end};                //Return first and last

    }
    private int findStartIndex(int[] nums, int target){   //Function to find start index
        int low=0;  
        int high=nums.length-1;
        while(low<=high){                                   //We will find mid and then the  instance if it is found then go to left to find the first instance and if not then return the found instance else if not found then return -1
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                if(mid > low && nums[mid-1]==target){
                    high=mid-1;
                }else{
                    return mid;
                }
            }
            else if(target> nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }


    private int findLastIndex(int[] nums, int target){     //This is function to find last instance
        int low=0;
        int high=nums.length-1;
        while(low<=high){                                   ////We will find mid and then the  instance if it is found then go to righr to find the last instance and if not then return the found instance else if not found then return -1
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                if(mid < high && nums[mid+1]==target){
                    low=mid+1;
                }else{
                    return mid;
                }
            }
            else if(target> nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}
