// Time Complexity : O(log(N) , as we are using binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class Problem1 {
    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int n = nums.length;
        if(nums[0] >target || nums[n-1] <target ) return new int[]{-1,-1};

        int first;
        first = binarySearchFirst(nums, target);

        //element does not exist
        if(first == -1) return new int[]{-1,-1};

        int last = binarySearchLast(nums, first, n-1, target);

        return new int[]{first, last};

    }

    //method for first binary search
    //first is the first occurence of our element
    private static int binarySearchFirst(int[] nums, int target){

        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            //setting the mid to avoid integer overflow
            int mid = low + (high-low)/2;

            //checking if mid is the target and is the first position
            if(nums[mid] == target ){

                if(mid ==0 || nums[mid]> nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid-1;
                }

            }else if(nums[mid] < target ){
                low = mid +1;

            }
            else {
                high = mid -1;
            }

        }
        return -1;

    }

    //method for searching the last position
    private static int binarySearchLast(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1; //move to right
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}