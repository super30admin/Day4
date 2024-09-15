package DataStructure.BinarySearch;

// Time Complexity : Add : O(log (n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int start = 0;
        int end = nums.length -1;

        //The below conditions means the array is already sorted, so return first element
        if(nums[start] < nums[end])
            return nums[0];

        while(start<=end){
            int midpoint = start + (end - start)/2;
            if(nums[midpoint] > nums[midpoint + 1])
                return nums[midpoint+1];

            if(nums[midpoint] < nums[midpoint-1])
                return nums[midpoint];

            if(nums[midpoint] > nums[start])
                start = midpoint+1;
            if(nums[midpoint] > nums[end])
                end = midpoint-1;

        }
    return -1;
    }

    public static void main(String[] args) {
        int[] nums = {6,7,8,9,10,2,3,4,5};
        System.out.println(findMin(nums));
    }
}
