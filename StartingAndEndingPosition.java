/*
  Time Complexity : O(log(n))
  Space Complexity : O(1)

 Did this code successfully run on Leetcode : YES
 Any problem you faced while coding this :No 

Approach:Binary Search Approach
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length <=0 ){
            return new int[] {-1,-1};
        }
        int starting = getFirstElement(nums,target);
        int last = getLastElement(nums, target);
        return  new int[] {starting, last};
    }
        int getFirstElement(int[] arr, int target){
        int low =0;
        int high = arr.length-1;
        while(low<=high){
            int mid =  low + (high -low)/2;
            
            if(arr[mid] == target){
                if (mid == 0 || arr[mid-1]<target){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if(arr[mid]<target){
                low = mid+1;
            }
            else if(arr[mid] >target){
                high = mid-1;
            }
        }
            return -1;
            
        }
