// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class FirstAndLastPosInSortedArray {
    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }

        // first check if the target is available in given array using the binary search
        int firstIdx = binarySearchFirst(nums, target);
        // if target doesnt exist, then return -1,-1
        if(firstIdx == -1){
            return new int[]{-1,-1};
        }
        // find the second index of the target
        int secondIdx = binarySearchSecond(nums, target);
        return new int[]{firstIdx,secondIdx};
    }

    public int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            // mid is target
            if(nums[mid] == target) {
                // checking mid-1 is not equal to target or not, means that will be the starting index of the target so returning mid
                if(mid ==0 || nums[mid-1] != target) {
                    return mid;
                }else{
                    // if mid-1 also equal to target, then need to change the search range by setting high= mid-1
                    high = mid -1;
                }
                // if mid > target, then target will be in the left sub array, so set high to mid-1
            }else if(nums[mid] > target) {
                high = mid -1;
            }else{
                // else target will be in the right sub array
                low = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchSecond(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == high || nums[mid+1] != target) {
                    return mid;
                }else{
                    low = mid +1;
                }
            }else if(nums[mid] > target) {
                high = mid -1;
            }else {
                low = mid +1;
            }
        }
        return -1;
    }
}