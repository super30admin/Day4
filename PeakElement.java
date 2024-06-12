package com.ds.rani.algo;

/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 * Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your function should
 * return the index number 2.
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4] Output: 1 or 5 Explanation: Your function can return either index number 1
 * where the peak element is 2,or index number 5 where the peak element is 6.
 */

//Approach:Use binary search, find mid check if value of mid is greater than mid-1 and mid+1 then return it
// otherwise search at right side if mid+1 is greater than the mid element else search in left part
public class PeakElement {

    //Time Complexity:o(n)
    //Space complexity:o(1)
    public static int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            //check mid is greter than its neigbours then it is peak
            if((mid==0 || nums[mid]>nums[mid-1])&&(mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            //check in the right side when nums[mid+1]>nums[mid] value
            if(nums[mid+1]>nums[mid]){
                left=mid+1  ;
            }else
            {
                right=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[]={1,2,1,3,5,6,4};
        System.out.println(findPeakElement( nums ));
        int nums1[]={3,5,4,7,8,9};
        System.out.println(findPeakElement( nums1 ));
    }

}
