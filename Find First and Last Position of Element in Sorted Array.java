/*
Time Complexity : O(log N)
Space Complexity : O(1)
*/
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    //first occurence
    public int binarySearchFirst(int nums[],int target){
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid==0 || nums[mid-1]<nums[mid]){
                    return mid;
                }
                else if(nums[mid-1]==nums[mid]){
                    high = mid-1;
                }
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    //second occurence
    public int binarySearchSecond(int nums[],int target,int first){
        int low=first,high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid==nums.length-1 || nums[mid+1]>nums[mid]){
                    return mid;
                }
                else if(nums[mid+1]==nums[mid]){
                    low = mid+1;
                }
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0 || nums==null){
            return new int[]{-1,-1};
        }
        //apply binary search in the left and right part of the input array to find teh fiest and last occurence
        int first = binarySearchFirst(nums,target);
        //if first is -1 then no need to find second
        if(first == -1){
            return new int[]{-1,-1};
        }
        int second = binarySearchSecond(nums, target,first);// search in the second half
        return new int[]{first,second};
    }
}