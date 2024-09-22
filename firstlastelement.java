// Time Complexity : 2* O(log n) = O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        int i=0, first=-1,last=-1; //initialize to -1 to cover target not found case
        int j=nums.length-1;

        while(i<=j){
            int mid= i + (j-i)/2;
            if(nums[mid]== target && (mid==0 || nums[mid-1]<target)){ //check for 1st position of target element 
                first=mid;break;
            }
            else if(nums[mid]>=target){
                j=mid-1;
            }
            else i=mid+1;
        }
        i=0;
        j=nums.length-1;
        while(i<=j){
            int mid=i + (j-i)/2;
            if(nums[mid]==target && (mid==nums.length-1 || nums[mid+1]>target)){ //check for last position of target element 
                last=mid;break;
            }
            else if(nums[mid]<=target){
                i=mid+1;
            }
            else j = mid -1;
        }
        return new int[]{first,last};
    }
}
