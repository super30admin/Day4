// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// In a rotated sorted array one half is always sorted so in every step 
// navigate towards the unsorted part until we find the pivot.

class Solution {
    int mid;
    public int pivot (int [] arr, int begin,int end){
        mid = Math.floorDiv(begin+end,2);
        if(arr[begin] <= arr[mid] && arr[mid] <= arr[end]){
            return arr[0];
        }
        if(mid == begin || mid == end){
            return arr[end];
        }
        if(arr[mid] < arr[begin]){
            return pivot(arr,begin,mid);
        }
        else{
            return pivot(arr,mid,end);
        }
    }
    public int findMin(int[] nums) {
        return pivot(nums,0,nums.length-1);
    }
}