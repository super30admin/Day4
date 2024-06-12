package com.ds.rani.algo;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

//Approach:Find first position separately and last position separately.
//If the first position itself is -1 it means there is no element in the array so dont check in the right part as well.

public class FirstLastPosInArray {

    //Time complexity:log(n)+log(n)=o(log n)
    //Space complexity:o(1)

    /**
     * Function to find first and last position of target in an array
     * @param nums array of integers
     * @param target value to be searched
     * @return integer array of indexes of first and last element if found else -1,-1.
     */
    public static int[] searchRange(int[] nums, int target) {
        int right=nums.length-1;
        int[] result=new int[2];
        if(nums==null || nums.length==0)
            return new int[]{-1,-1};

        result[0]= findFirstPosition(nums,target,0,right);
        //if first position itself is -1 it means there is no target in the num
        if(result[0]!=-1)
            result[1]= findLastPosition(nums,target,result[0],right);
        else
            result[1]=-1;

        return result;
    }

    //Time complexity:o(log n)
    //Space complexity:o(1)

    /**
     * Binary search function to find the first position of element in an array
     * @param nums array of integers
     * @param target value to be searched
     * @param left left index in array
     * @param right index in an array
     * @return index lue of first occurance  of target
     */
    static int findFirstPosition(int[] nums, int target,int left,int right){
        while(left<=right){
            int mid=left+(right-left)/2;

            //If the target found
            if(nums[mid]==target){
                //if this is the first target from left
                if(mid==0 ||nums[mid-1]<nums[mid])
                    return mid;
                else{
                    //there are more targets available at left
                    right=mid-1;
                }
            }
            if(target<nums[mid]){
                right=mid-1;
            }else if(target>nums[mid]){
                left=mid+1;
            }

        }
        return -1;
    }

    //Time complexity:o(log n)
    //Space complexity:o(1)
/**
 * Binary search function to find the last position of element in an array
 * @param nums array of integers
 * @param target value to be searched
 * @param left left index in array
 * @param right index in an array
 * @return index lue of last occurance  of target
 */
    static int findLastPosition(int[] nums, int target,int left,int right){
        while(left<=right){
            int mid=left+(right-left)/2;

            //If the target found
            if(nums[mid]==target){
                //if this is the last target from right
                if(mid==nums.length-1 ||nums[mid]<nums[mid+1])
                    return mid;
                else{
                    //there are more targets available at right
                    left=mid+1;
                }
            }
            if(target<nums[mid]){
                right=mid-1;
            }else if(target>nums[mid]){
                left=mid+1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(searchRange(nums,target  ));


    }
}
