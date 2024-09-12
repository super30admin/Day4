// Time Complexity : O(logn)
// Space Complexity : O(1) constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Bruteforce for this would be two pointers and checking the min element in the array. TC= O(n^2);
// Your code here along with comments explaining your approach 

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[] { -1, -1};
        if(target < nums[0] || target > nums[nums.length - 1])
            return new int[] {-1, -1};
        //BinarySearch for first element
        int first = binarySearchFirst(nums, target);
	//BinarySearch for last element
        int last = binarySearchLast(nums, target);
        
        return new int[] {first, last};
    }
        
        private int binarySearchFirst(int[] nums, int target){
            int low = 0;
            int high = nums.length-1;
            
            while(low <= high){
                int mid = low + (high-low)/2;
                //disregarding the search space by focusing going towards left
                if(nums[mid] == target){
                    if(mid == 0 || nums[mid] > nums[mid - 1]) return mid;
                    else high = mid - 1;
                }
                else if(target < nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            return -1;
        }
        
        private int binarySearchLast(int[] nums, int target){
            int low = 0;
            int high = nums.length-1;
            while(low <= high){
                int mid = low + (high-low)/2;
                //disregarding the search space by focusing going towards right
                if(nums[mid] == target){
                    if(mid == nums.length-1 || nums[mid] < nums[mid+1]) return mid;
                    else low = mid + 1;
                }
                else if(target < nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            return -1;
        }
     
}

