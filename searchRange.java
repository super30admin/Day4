// Time Complexity : O(n + log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[]{-1, -1};
        if (nums.length == 0){
            return result;
        }
        int start = 0, end = nums.length-1;
        int mid = 0, left = -1, right = -1;
        boolean found = false;
        while(start <= end){
            mid = start + (end - start)/2;
            if(nums[mid] == target){
                found = true;
                break;
            } else {
                if(nums[mid] < target){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        if(found){
            left = goLeft(mid, nums);
            right = goRight(mid, nums);
            result[0] = left;
            result[1] = right;
        } 
            
        return result;
        
    }
    
    private int goLeft(int mid, int[] nums){
        int start = mid-1;
        while(start >= 0 && nums[start] == nums[mid]){
         
                start--;
        
        }
        return start+1;
    }
    
     private int goRight(int mid, int[] nums){
        int end = mid+1;
        while(end <= nums.length-1 && nums[end] == nums[mid]){
    
                end++;

        }
        return end-1;
    }
}