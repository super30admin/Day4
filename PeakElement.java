package com.Aug2020.BinarySearch;

//Time Complexity : O(log n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :
//there are several occasions where manipulating start and end element was a problem.
//how to make the solution work using one-stack only to avoid extra stack.

class PeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length -1;
       int index = -1;
        
        while (start < end) {
                 int mid = start + (end-start)/2;
                 
                if (nums[mid] > nums[mid + 1])
                end = mid;
            else
                start = mid + 1;
                 
        }
        return start;
    
    }
}
