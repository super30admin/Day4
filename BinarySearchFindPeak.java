// Time Complexity : O(Log(N))
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach

class BinarySearchFindPeak {
    
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if((low == mid || nums[mid] > nums[mid-1]) && (mid == high || nums[mid] > nums[mid+1])){
                return mid;
            }else if(mid == high || nums[mid] < nums[mid+1]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
    return -1;
    }
}