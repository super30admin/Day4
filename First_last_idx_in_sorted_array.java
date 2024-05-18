// Time Complexity : O(log n)
// Space Complexity : 1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Find first index and then second index in O(log n) + O(log n) = O(log n) 
// Alogorithm based on checking mid element with it's immediate neighbours 
// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[] {-1,-1};
        }

        int first = findFirstIndex(nums, target);
        if(first == -1){
            return new int [] {-1,-1};
        }
        int  second = findSecondIndex(nums, target);
        if(first == -1){
            return new int [] {-1,-1};
        }
        return new int[] {first,second};
    }

    private int findFirstIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high -low)/2; // prevent inetger overflow
            
            if(nums[mid] == target){ // if target match & left element is not target found first position 
                if(mid == 0 || nums[mid - 1] != target){
                    return mid;
                }
                high = mid - 1; // else there is same element on left
            } 
            else if(target > nums[mid]){ // if target greater than mid element move to right side of array
                low = mid + 1;
            }
            else{   // else move to left side of array
                high = mid -1;
            }
        }
        return -1;
    }

    private int findSecondIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high -low)/2; // prevent inetger overflow
            if(nums[mid] == target){ // if target match & right element is not target found second position
                if(mid == nums.length-1 || nums[mid+1] != target){ 
                    return mid;
                }
                low = mid + 1; // else there is same element on right
            }  
            else if (target < nums[mid]){ // if target less than mid element move to left 
                high = mid -1;
            }
            else{
                low = mid + 1; // else move to right
            }
        }
        return -1;
    }
}