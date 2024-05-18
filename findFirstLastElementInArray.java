/*
 * First and last occurence of element approach
 * First element from binary search, calculate mid and go through the binary search algo,
 * Once the element is found make sure that in a sorted array, first occurence is the left most occurence,
 * Since its a sorted array, if we check the element to the immediate left is the less than the first occurence, then that will be the first occurence
 * 
 * Last occurence
 * Calculate mid follow binary search algo
 * always check the next element to the right since a sorted array, we keep this on until we find and element greater than the element value in the situation
 * 
 * Time complexity : O(log n)
 * Space Complexity: constant - O(1)
 */


public class Solution {
    public int[] searchRange(int[] nums, int target) {

        if(nums == null && nums.length == 0) return new int[] {-1, -1};

        int first = binarySearchFirst(nums, target);
        if(first == -1) return new int[] {-1, -1};

        int last = binarySearchLast(nums, target); // searching last position
        return new int[] {first, last};
    }
        

        //find first occurence
        private int binarySearchFirst(int[] nums, int target){
            int low = 0;
            int high = nums.length - 1;
            
            while(low<=high){
                int mid = low + (high - low)/2; //avoid integer overflow
                if(nums[mid] == target){
                    if(mid == 0 ||  nums[mid - 1] != target) // cannot be swapped, since it can ge tout of range
                        return mid;
                    high = mid - 1;
                } else if(target > nums[mid]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        // find last occurence
        private int binarySearchLast(int[] nums, int target){
            int low = 0;
            int high = nums.length - 1;
            while(low <= high) {
                int mid = low + (high - low)/2; //avoid integer overflow
                if(nums[mid] == target){
                    if(mid == nums.length -1 || nums[mid + 1] != target) {
                        return mid;
                    }
                    low = mid + 1;
                } else if(target > nums[mid]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
}