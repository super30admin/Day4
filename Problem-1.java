/*
   
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.*/

//Time comlpexity - O(log n)
//space complexity - O(1)
// Did this code successfully run on Leetcode : Yes
/*
Any problem you faced while coding this : None

*/

// Your code here along with comments explaining your approach
//two pointer approach where you search the target from the front and back
class Solution {
    //find the first occurance of the target
    public int firstOccurance(int[] nums, int low, int high, int target)
    {
        while (low <= high){
            int mid = low + (high - low)/2;//find the mid value
            if(nums[mid] == target){
                if( mid == low ||  nums[mid - 1] < nums[mid]) return mid;
                else high = mid - 1; //keep going left by changing high index
            } else if(nums[mid] > target){
                high = mid - 1; //keep moving to the left by changing the high index
            } else low = mid + 1; //keep moving the right by changing the right index
        }
        return -1; //if not found return -1
    }
    
    public int secondOccurance(int[] nums, int low, int high, int target)
    {
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid + 1] > target) return mid;
                else low = mid + 1;//keep moving to the right
            } else if(nums[mid] > target){
                high = mid - 1;//move left
            } else low = mid + 1; //keep moving to the right by changing the low index
        }
        return -1; //if not found then return -1
    }
    public int[] searchRange(int[] nums, int target) {
        //find the target using binary search approach
        int left = firstOccurance(nums, 0, nums.length - 1, target);//get the first target us
        int right = secondOccurance(nums, 0, nums.length - 1, target); //get the 2nd target
        return new int[] {left,right};
    }
}