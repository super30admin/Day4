// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Start with the mid point and always move towards the side in which the
// adjacent value to mid is greater than mid until we encounter the peak.

class Solution {
    int mid;
    public int searchPeak(int[] arr,int begin,int end){
        mid = begin + (end-begin)/2;
        if(mid == 0){
            if(arr[mid] > arr[mid+1]){
                return mid;
            }
        }
        if(mid == arr.length-1){
            if(arr[mid] > arr[mid-1]){
                return mid;
            }
        }
        if(arr[mid]>arr[mid+1] && arr[mid] > arr[mid-1]){
            return mid;
        }
        else{
            if(arr[mid+1] > arr[mid]){
               return searchPeak(arr, mid+1,end);
            }
            else{
                return searchPeak(arr, begin, mid-1);
            }
            
        }
    }
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        return searchPeak(nums,0,nums.length-1);
    }
}