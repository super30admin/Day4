// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No As Shown in Class

public class BinarySearchHigLowIndex {

    private int binarySearchLeft(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int middle = low + (high - low) / 2;
            if(nums[mid]==taget){
                if(nums[mid] > nums[mid-1] || mid == 0){
                    return mid;
                }
                else {
                    high = mid -1 ;
                }
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }

            else {
                low = mid +1;
            }

        }
        return -1;

    }

    private int binarySearchRight(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int middle = low + (high - low) / 2;
            if(nums[mid]==taget){
                if(nums[mid] < nums[mid+1] || mid == 0){
                    return mid;
                }
                else {
                    low = mid  + 1 ;
                }
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }

            else {
                low = mid +1;
            }

        }
        return -1;

    }
    public int[] searchRange(int[] nums, int target){

        //edge Case
        if(nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = binarySearchLeft(nums, target);
        int last =  binarySearchRight(nums, target);
        return new int[]{first, last};

    }
}
    
    
