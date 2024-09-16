/*
LeetCode Submitted = YES
Time complexity = O(logN)
Space complexity = O(1) */
/* The approach I used is assume the middle of the array is peak and then recursively call the left part of the array and right part of the array to see the peak still valid otherwise update peak with another value 
*/

class Solution {
    public int peakElements(int[] nums,int l,int r){
        //local peak element
        int mid  = (l + (r - l)/2);
        
        //Base case
        if(l > r)
            return -1;
        
        //mid == l and mid == nums.length -1 is necessary for checking and improve performance
        //returning the value i.e. only possible peak in that sub-array
        if((mid == l || nums[mid-1]<nums[mid]) && (nums.length -1 == mid || nums[mid] > nums[mid+1]))
            return mid;
        
        //recursively calling on left side of mid or right side of msi
        if(mid == r || nums[mid] < nums[mid + 1])
            l = mid + 1;
        else
            r = mid - 1;
        
        return(peakElements(nums,l,r));
    }
    
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length <1)
            return -1;
        if(nums.length == 1)
            return 0;
        else{
            return peakElements(nums,0,nums.length-1);
        }
    }
}
