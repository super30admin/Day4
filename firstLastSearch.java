// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int lowForLast;
        //First BS for to check ement is there or not (if there return mid) (if not no need for Second BS)
        private int binarySearchFirst(int [] nums, int target){
            int low = 0;
            int high = nums.length -1;
            while(low<=high){
                int mid = low+(high - low)/2;
                if(nums[mid] == target){
                    if(mid == 0 || nums[mid] > nums[mid-1]){
                        return mid;
                    }else{
                        high = mid-1;
                    }
                }else if(nums[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return -1;
        }
        
        //Second BS for finding the First and last element
        private int binarySearchLast(int [] nums,int target){
            int low = lowForLast;
            int high = nums.length -1;
            while(low<=high){
                int mid = low+(high - low)/2;
                if(nums[mid] == target){
                    if(mid == nums.length -1 || nums[mid] < nums[mid + 1]){
                        return mid;
                    }else{
                        low = mid + 1;
                    }
                }else if(nums[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return -1;
        }
        
    public int[] searchRange(int[] nums, int target) {
        // for null case
        if(nums == null || nums.length == 0) return new int[] {-1,-1};
        if(nums[0] > target || nums[nums.length -1] < target) return new int[] {-1,-1};     
        int first = binarySearchFirst(nums, target);
        if(first == -1) return new int[] {-1,-1};
        lowForLast = first;
        int last = binarySearchLast(nums, target);
        return new int [] {first,last};
            
            
    }
}