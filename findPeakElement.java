// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int l=0, h= nums.length-1;
        while(l<=h){
            int mid= l+(h-l)/2;
            //if left and right elements of mid are less than mid then that is the peak
            if((mid==l || nums[mid-1]< nums[mid]) && (mid==h || nums[mid+1]< nums[mid])){
                return mid;
            }
            //if left element of mid is greater check in left half
            else if(mid!=0 && nums[mid-1]>nums[mid]){
                h=mid-1;
            }
            //if right element is greater check in right half
            else{
                l=mid+1;
            }
        }
        return 1223213;
    }
}