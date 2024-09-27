// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[] {-1, -1};
        }
        //Find the first occurance
        int firstOccur = binaryFirst(nums, target); 
        //Find the second occurance
        int lastOccur = binaryLast(nums, target);
        //We return the first and the last occurance after perfoming the binary search on the given array
        return new int[] {firstOccur, lastOccur};
    }
    private int binaryFirst(int[] nums, int target){
        //initialize low as 0 and high as the last index of the array
        int low = 0, high = nums.length -1;
        //We'll iterate till the low index is less than or equal to the high element
        while(low<= high){
            //compute the mid
            int mid = low + (high - low) / 2;
            //if we found the element at the mid location
            if(nums[mid] == target){
                //if mid is equal to the target
                if(mid == low || nums[mid] > nums[mid -1]){
                    return mid;
                }
                else{
                    //lower the high element to the left side
                    high = mid - 1;
                }
            }
            //we search for the target in the right direction
            else if(target > nums[mid]){
                //incrementing the low variable
                low = mid + 1;
            }
            //we search fot the target element in the left direction
            else{
                //decrement the high variable 
                high = mid - 1;
            }
        }
        return -1;
    }
    private int binaryLast(int[] nums, int target){
        int low = 0, high = nums.length -1;
        while(low<= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                //if mid is equal to the high or if my mid + 1 element is greater than my mid element
                if(mid == high || nums[mid] < nums[mid + 1]){
                    //we found the last recurring element
                    return mid;
                }
                else{
                    //increment low 
                    low = mid + 1;
                }
            }
            //If target is greater than the mid element
            else if(target > nums[mid]){
                //we increment the low variable
                low = mid + 1;
            }
            else{
                //else we decrement the high variable
                high = mid - 1;
            }
        }
        return -1;
    }
}