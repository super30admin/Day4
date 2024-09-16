
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class FindMinimumRotatedSortedArray_153 {
    public int findPeakElement(int[] nums) {
        int l=0;
        int h= nums.length -1;
        
        while(h >= l){
            
            int mid = l + ( h-l) /2 ;
            //checking mid is bigger than mid-1 < mid > mid +1
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
                return mid;
            } else if (nums[mid] < nums[mid+1]){
                l = mid+1;
            } else {
                h = mid -1;
            }
        }
        
        return -1;
    }
}