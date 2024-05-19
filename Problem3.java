// Time Complexity : O(logn)
// Space Complexity : O(1)

//This code aims to find a peak element in an array using binary search. 
// It starts by initializing pointers `low` and `high` to cover the entire array and iteratively adjusts them based on comparisons with neighboring elements. 
// The peak element is identified when it satisfies the conditions of being greater than its neighbors, ensuring it's either at the start, end, or a local peak within the array. 
// If found, the function returns the index of the peak element; otherwise, it returns `-1` if no peak exists in the array.

class Solution {
    public int findPeakElement(int[] nums) {
       if(nums.length == 0){
        return 0;
       }
       int low = 0;
       int high = nums.length -1;
       int n = nums.length;
       while(low <=high){
        int mid = low + (high-low)/2;
        if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == n-1 || nums[mid] > nums[mid+1])){
           return mid;
        }else if(mid >0 && nums[mid-1] > nums[mid]){
            high = mid-1;
        }else{
            low = mid+1;
        }
       }
       return -1;
    }
}