
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class FindMinimumRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        int l=0;
        int h= nums.length-1;
        
        while(h >= l){
            
            int mid = l + (h-l)/2;
            //checking that mid is mid-1 > mid < mid +1 with all edge cases
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])) {
                return nums[mid];
            } else if (nums[mid] > nums[h]){
                l = mid +1;
            } else {
                h = mid -1;
            }
        }
        
        return -1;
    }
}