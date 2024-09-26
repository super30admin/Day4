// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //return default if array is empty
        if(nums.length == 0)
            return new int[]{-1,-1};
        
        int lower = 0;
        int upper = nums.length-1;
        int mid = 0;

        //binary search to find the target
        while(lower<=upper){
            mid = lower + (upper-lower)/2;
            if(nums[mid] == target)
                break;
            else if(nums[mid]<target)
                lower = mid+1;
            else
                upper = mid-1;
        }

        //if target not found
        if(nums[mid] != target)
            return new int[]{-1,-1};
        
        int[] arr = new int[]{mid,mid};

        //check if numbers before mid are target, and update the start position
        if(mid>0 && nums[mid-1]==target){
            for(int i=mid-1; i>=0; i--){
                if(nums[i]==target){
                    arr[0] = i;
                }
                else
                    break;
            }
        }

        //check if numbers next to mid are target, and update the end position
        if(mid<nums.length-1 && nums[mid+1]==target){
            for(int i=mid+1; i<nums.length; i++){
                if(nums[i]==target){
                    arr[1] = i;
                }
                else
                    break;
            }
        }
        
        return arr;
    }
}