/*
Time Complexity: O(log(n))
Space Complexity: O(log(n))
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach,
1. Using recursion and applying search on the left and right half of the array

 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums){
        return findPeak(nums, 0, nums.length-1);
    }
    public static int findPeak(int[]nums, int start, int end){
        int mid = start + (end-start)/2;
        if(mid> 0 && nums[mid]<nums[mid-1]){
            return findPeak(nums, start, mid-1);
        }else if(mid<nums.length-1 &&  nums[mid]<nums[mid+1]){
            return findPeak(nums, mid+1, end);
        }else{
            return mid;
        }
    }

    public static void main(String[] args){
        int [] arr = {1,2,3,1};
        System.out.println("Peak Element's index: "+findPeakElement(arr));
    }
}
