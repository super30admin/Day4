# Binary-Search-2
Explain your approach in **three sentences only** at top of your code


## Problem 1: Find First and Last Position of Element in Sorted Array

```Java
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Solution {
    private static int binarySearchLast(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else{
                    //keep moving right
                    low=mid+1;
                }
            }
            else if(nums[mid] < target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    private static int binarySearchFirst(int[] nums, int target){
        int low=0;
        int high=nums.length;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid == 0 || nums[mid]>nums[mid-1]){
                    return mid;
                }
                else{
                    //we have to search the left part
                    high=mid-1;                
                }
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }        
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        //validate for null
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};
        
        //validate if target < first element OR if target > the last element
        if(nums[0] > target || nums[nums.length-1] < target)
            return new int[]{-1, -1};
        
    
        int first = binarySearchFirst(nums, target);
        
        if(first == -1)
            return new int[]{-1, -1};
        
        int last = binarySearchLast(nums, first, nums.length-1, target);
        
        return new int[]{first, last};
        
    }
}
```

## Problem 2: Find Minimum in Rotated Sorted Array

```Java
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Solution {
    public int findMin(int[] nums) {
        //check null
        if(nums == null || nums.length==0){
            return -1;
        }

        int low=0;
        int high=nums.length-1;

        while(low<=high){
            if(nums[low]<=nums[high]){ //already sorted
                return nums[low];
            }

            int mid=low+(high-low)/2;
            //check id mid is minimum
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){ //check if sorted
                low=mid+1; //if not, go to unsorted side
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}
```

## Problem 3: Find Peak Element

```Java
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Solution {
    public int findPeakElement(int[] nums) {
        //check for null
        if(nums == null || nums.length == 0)
            return -1;
        
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            //check if mid is the peak
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid == nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            //left search
            else if(mid>0 && nums[mid-1]>nums[mid]){
                high=mid-1;
            }
            else{
                //right search
                low=mid+1;
            }
        }
        return -1;
    }
}
```


