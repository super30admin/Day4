Problem 1: Find First and Last Position of Element in Sorted Array
// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only

// Make two binary search methods one for searching the left index by checking mid == target and then mid-1 = target for the left side 
// Same way find the right index by mid = target and then mid + 1 = target for the right side of he array 


class Solution {
    private int leftBinarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            if(nums[0]==target){
                return 0;
            }
            int mid = left + (right-left)/2;
            
            if(nums[mid]==target){
                
                if(mid != 0 && nums[mid-1]!=target){
                    return mid;
                }else{
                    right = mid-1;
                }
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    private int rightBinarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            if(nums[nums.length-1]==target){
                return nums.length -1;
            }
            int mid = left + (right-left)/2;
            
            if(nums[mid]==target){
                if(mid != nums.length-1 && nums[mid+1]!=target){
                    return mid;
                }else{
                    left = mid+1;
                }
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int i=-1, j=-1;
        i = leftBinarySearch(nums, target);
        if(i==-1) return new int[]{-1,-1};
        j = rightBinarySearch(nums, target);
        return new int[]{i, j};
    }
}