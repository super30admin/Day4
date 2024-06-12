// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        res[0]=findLeftEnd(nums,target);
        res[1]=findRightEnd(nums,target);
        return res;
    }
    public int findLeftEnd(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int leftindex=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                leftindex=mid;
            }
            if(target>nums[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return leftindex;
    }
    public int findRightEnd(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int rightindex=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                rightindex=mid;
            }
            if(target>=nums[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return rightindex;
    }
}