// Time Complexity - O(logN)
// Space Complexity - O(logN)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// we use binary search to solve this problem.
// the idea is to compare the middle element with the last element
// and continue to search in the rotated part as the minimum element will always be in the rotated part.

class Solution {
    public int findMin(int[] nums) {  
     int low = 0;
     int high = nums.length-1;
     
     return findMinimum(nums,low,high);
    }
    
    public int findMinimum(int[] n,int low, int high){
        if(high==low)
            return n[low];
        
        int mid = (high+low)/2;
        
        if(n[mid]>n[high])
            return findMinimum(n, mid+1,high);
        else
            return  findMinimum(n, low, mid);
    }
}