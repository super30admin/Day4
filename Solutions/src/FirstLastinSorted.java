// Time Complexity :
//O(logN)
// Space Complexity :
//O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
class FirstLastinSorted {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length ==0){
            return new int[]{-1,-1};
        }
        int start,end;
        start = RightMostIndex(nums,target-1);
        end = RightMostIndex(nums,target);

        if (start == end){
            return new int[] {-1,-1};
        }
        return new int[]{start+1,end};
    }


    private int RightMostIndex(int[] nums,  int target){
        if (target>=nums[nums.length-1]) return (nums.length-1);
        if (target < nums[0]) return -1;
        int low=0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if (nums[mid]<=target && target<nums[mid+1]){
                return mid;
            }

            if (nums[mid]<=target){
                low = mid+1;
            }
            else{
                high= mid-1;
            }
        }
        return -1;
    }
}