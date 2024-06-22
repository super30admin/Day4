// Time Complexity: O(log n)
// Space Complexity: O(1)

/*
 * Logic in 3 lines:
 * This code implements binary search to find the first and last occurrences of target in a sorted array nums. 
 * The first method adjusts low and high bounds to find the first occurrence by checking adjacent elements.
 * The last method adjusts bounds similarly to find the last occurrence. 
 * The searchRange method combines results from first and last to return the indices of the first and last occurrences of target,
 *  or [-1, -1] if target is not found.
 */

class Solution {

    public int first(int[] nums, int target,int low, int high)
    {
 
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]==target) {
                if(mid==low||nums[mid]>nums[mid-1]) {
                    return mid;
                }
                else {
                    high=mid-1;
                }
            }

            else if(nums[mid]<target) {
                low = mid+1;
            }
            else if(nums[mid]>target) {
                high=mid-1;
            }
        }
        return -1;
      
    }

    public int last(int[] nums, int target,int low, int high) {
        while(low<=high) {
            int mid = low+(high-low)/2;
  
            if (nums[mid]==target) {
                if (mid==high||nums[mid]<nums[mid+1]) {
                    return mid;
                }
                else {
                    low=mid+1;
                }
            }

            else if (nums[mid]<target) {
                low = mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return -1;
        
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) {
            return new int[]{-1,-1};
        }

        return new int[]{first(nums,target,0,nums.length-1),last(nums,target,0,nums.length-1)};
    }
}