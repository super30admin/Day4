/*
Time Complexity : O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach,
 */
public class FindMinimumInRotatedSortedArray {
    public static int findMinimum(int[] nums){
        if(nums == null) return 0;
        if(nums.length == 1){return nums[0];}

        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int mid = left + (right-left)/2;
            /*
            1. condition if mid element is already less than right, then we can assume that array is sorted and can move
            our right pointer to mid as we are supposed to calculate minimum element which surely be in the
            left half of the array
            2. else is the case if the array is sorted but rotated then we have  to move our left pointer towards right
            to find minimum element, now we know our left pointer points to the minimum value we can return value at left
             pointer
             */

            if(nums[mid]<nums[right]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args){
        int[] arr = {7,6,5,1,2,3,4};
        System.out.println("Minimum element in the array: "+findMinimum(arr));
    }
}
