// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Run a binary search and get the position of any target element in the array
// and update the min and max based on the position. Check if position before
// min in the array is target element if yes then run binary search on that 
// left part. Check if position after max in the array is target element if yes
// then run binary search on that right part.

class Solution {
    int min = Integer.MAX_VALUE; 
    int max = Integer.MIN_VALUE;
    int[] range = new int[2];
    public int binarySearch(int[] arr,int begin,int end,int tar){
        if(begin>end){
            return -1;
        }
        int mid = Math.floorDiv(begin+end,2);
        if(arr[mid]==tar){
            return mid;
        }
        else if(arr[mid]<tar){
            return binarySearch(arr,mid+1,end,tar);
        }
        else{
            return binarySearch(arr,begin,mid-1,tar);
        }
    }
    public int[] search(int[] arr,int begin,int end,int tar){
        if(begin <= end){
            
        int pos = binarySearch(arr,begin,end,tar);
        if(pos < min){
            min = pos;
            range[0] = min;
        }
        if(pos > max){
            max = pos;
            range[1] = max;
        }
        if(min == -1 && max == -1){
            return range;
        }
        if(min-1 >= 0 && arr[min-1] == tar){
            search(arr,begin,min-1,tar);
        }
        if(max+1 <= arr.length-1 && arr[max+1]==tar){
            search(arr,max+1,end,tar);
        }
        }
        return range;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            range[0] = -1;
            range[1] = -1;
            return range;
        }
        return search(nums,0,nums.length-1,target);
    }
}