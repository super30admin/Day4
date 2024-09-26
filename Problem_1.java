// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 34. Find First and Last Position of Element in Sorted Array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // int n = nums.length;
        if(nums == null) return new int[]{-1, -1};
        int first = firstocc(nums, target);
        if (first == -1){
            return new int[]{-1, -1};
        }
        int last = lastocc(nums, target);
        return new int[]{first, last}; 
    }
        private int firstocc(int[] nums, int t){
            int n = nums.length;
            int mid;
            int low = 0;
            int high = n - 1;
            while (low <= high){
                mid = low + (high - low) / 2;
                if(nums[mid] == t){
                    if((mid == 0) || (nums[mid - 1] < t)){
                        return mid;
                    }
                    else{
                        high = mid -1;
                    }
                }
                if(nums[mid] < t){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
                
            }
            return -1;
        }
        
        private int lastocc(int[] nums, int t){
            int n = nums.length;
            int mid;
            int low = 0;
            int high = n - 1;
            while (low <= high){
                mid = low + (high - low) / 2;
                if(nums[mid] == t){
                    if((mid == n - 1) || (nums[mid + 1] > t)){
                        return mid;
                    }
                    else{
                        low = mid + 1;
                    }
                }
                if(nums[mid] > t){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
                
            }
            return -1;
        }
        
       
}