package com.ds.rani.algo;

//Approach :Use binary search,check which part is sorted,left of mid or right of mid.
//move our search to the part which is not sorted and apply the same logic till we doesnt find our element
/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * find minimum number in ana array
 * You may assume no duplicate exists in the array.
 */
public class SerchMinInRotatedSortedArray {

    //Time complexity:o(log n)
    //Space complexity:o(1)
    /**
     * Search  min element in rotated sorted array
     * @param nums array of integers which is sorted
     * @return minimum element in from array
     */
    public static int findMin(int[] nums) {
        if (nums==null || nums.length==0) {
            return Integer.MIN_VALUE;
        }
        int left = 0, right = nums.length-1;
        //take example [3,4,5,1,2]
        while (left < right) {
            int mid = left + (right-left)/2;

            //right part is not sorted so search smaller element there
            if (nums[mid] > nums[right]) {
                left = mid+1;
            }
            else {// if right part is sorted then search in left part
                right = mid;
            }
        }
        return nums[left];

    }


    public static void main(String[] args) {
        int nums[]={4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
        int nums1[]={3,4,5,1,2};
        System.out.println(findMin(nums1));
        int nums2[]={9,8,7,6,5,4,3,2};
        System.out.println(findMin(nums2));
        int nums3[]={4,5,6,7};
        System.out.println(findMin(nums3));
    }
}
