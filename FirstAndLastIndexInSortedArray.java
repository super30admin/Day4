// time complexity: O(Log N), N elements in the array, at each step we discard half of the array we are scanning and hence, we're done after a logarithmic number of steps.
// We  perform binary search twice in this case.
//space complexity: O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach

class FirstAndLastIndexInSortedArray {
    int first;
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};

        first = binarySearchLeft(nums, target);
        if(first == -1)
            return new int[]{-1, -1};
        int last = binarySearchRight(nums, target);
        return new int[]{first, last};
    }
    private int binarySearchLeft(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < nums[mid] )
                    return mid;
                else
                    hi = mid-1;
            }
            else if(nums[mid]>target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return -1;
    }
    private int binarySearchRight(int[] nums, int target){
        int lo = first, hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid+1] )
                    return mid;
                else
                    lo = mid+1;
            }
            else if(nums[mid]>target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return -1;
    }
}