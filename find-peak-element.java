//Time Complexity: O(logn)
//Space Complexity: O(1)

/*
    * This code finds a peak element in an array using binary search:
    * It initializes pointers l (start) and h (end).
    * It iteratively adjusts l or h based on comparisons with adjacent elements until a peak element is found.
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==0) {
            return -1;
        }
        int l=0;
        int h = nums.length-1;
        while(l<=h) {
            int mid = l+(h-l)/2;
            if((mid==nums.length-1 ||nums[mid]>nums[mid+1]) && (mid==0 || nums[mid]>nums[mid-1])) {
                return mid;
            }
            else if(mid==0 || nums[mid]>=nums[mid-1]) {
                l=mid+1;
            }
            else {
                h=mid-1;
            }
        }
        return -1;
    }
}