// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {

        if(nums == null || nums.length==0) return -1;

        int low = 0;
        int high = nums.length -1;

        while(low < high) {
            int mid = low+(high-low)/2;
            if(nums[mid] > nums[high]){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}