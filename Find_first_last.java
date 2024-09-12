// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return new int[]{-1,-1};

        int [] ans = new int[]{-1,-1};
        ans[0] = first(nums,target);
        ans[1] = last(nums,target);
        return ans;
    }

    int first(int[] nums, int target){
        int l =0;
        int h = nums.length-1;
        while(l<=h){
            int mid = l +(h-l)/2;
            if(nums[mid]<target)
                l = mid+1;
            else if(nums[mid]>target)
                h = mid-1;
            else {
                if(mid==0 || nums[mid-1]!=target){
                    return mid;
                }
                else{
                    h= mid-1;
                }
            }
        }
        return -1;
    }
    int last(int[] nums, int target){
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int mid = l +(h-l)/2;
            if(nums[mid]<target)
                l = mid+1;
            else if(nums[mid]>target)
                h = mid-1;
            else{
                if(mid==nums.length-1 || nums[mid+1]!=target){
                    return mid;
                }
                else{
                    l = mid+1;
                }
            }
        }
        return -1;
    }
}