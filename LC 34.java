
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    private int BinarySearchFirst(int[] nums,int target){
        int low = 0;
        int high = nums.length;
        while(low <= high){
            int mid = low + (high-low)/2;
            if (target == nums[mid]){
                if(mid == 0 || nums[mid-1] < nums[mid]){
                    return mid;
                }else if(nums[mid-1] == nums[mid]){
                    high = mid - 1;
                }
            }else if(target > nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
    private int BinarySearchSecond(int[] nums,int target,int low){
        
        int high = nums.length;
        while(low <= high){
            int mid = low + (high-low)/2;
            if (target == nums[mid]){
                if(mid == nums.length - 1 || nums[mid] < nums[mid+1]){
                    return mid;
                }else if(nums[mid+1] == nums[mid]){
                    low = mid + 1;
                }
            }else if(target > nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return new int[] {-1,-1};
        }
        if (target < nums[0] || target > nums[nums.length-1]){
            return new int[] {-1,-1};
        }
        int[] targetRange = {-1, -1};
        int first = BinarySearchFirst(nums,target);
        if(first == -1){
            return targetRange;
        }
        int second = BinarySearchSecond(nums,target,first);
        return new int[]{first,second};
        
        
        
        
        
    } 
}
