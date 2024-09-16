// Time Complexity : O(log n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Method: 1
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=0,right =nums.length-1;
        
        // Binary search to find the lowest point of the target element
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] >= target){
                right = mid-1;
            }
            else left = mid+1;
        }
        int low = 0,high = nums.length-1;
        
        // Binary Search to find the highest point of the target element
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] <= target){
                low = mid+1;
            }
            else high = mid-1;
        }
        if(left > high) return new int[]{-1,-1};
        else return new int[]{left,high};
    }
}

// Method: 2
/*
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        res[0] = indexRange(nums,target,false);
        if(res[0] != -1) res[1] = indexRange(nums,target,true);
        return res;
    }
    public int indexRange(int[] nums,int target,boolean flag){
        int keyIndex = -1;
        int left =0,right = nums.length-1,mid;
        while(left<=right){
            mid = left+(right-left)/2;
            if(nums[mid] < target) left =mid+1;
            else if(nums[mid] > target) right = mid-1;
            else{
                keyIndex = mid;
                if(flag)
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return keyIndex;
    }
}
*/
