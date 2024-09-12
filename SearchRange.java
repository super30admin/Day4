import java.util.*;

// Time Complexity : O(logn+logn).
// Space Complexity : O(n) size of array is n.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was able to think through but couldn't code it until I saw Jaspinder sir
// code it. I also couldn't think of the optimizations

class Solution {
    static int lowForLast;
    private static int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid]>nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchLast(int[] nums, int target){
        int low = lowForLast;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid]<nums[mid+1]){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int []{-1,-1};
        if(nums[0]>target || nums[nums.length-1]<target) return new int[] {-1,-1};
        int first = binarySearchFirst(nums,target);
        if(first==-1) return new int[] {-1,-1};
        lowForLast = first;
        int last = binarySearchLast(nums, target);
        return new int[] {first, last};
    }

    public static void main(String [] args){
        int [] nums = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
        System.out.println(Arrays.toString(searchRange(nums, 6)));
    }
}