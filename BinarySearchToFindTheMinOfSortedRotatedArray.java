// Time Complexity : O(logn)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


//Understood the inout will be a rotated sorted array with just one valley
//Which means one side of the mid will be sorted and other will be unsorted
//And we canconfidently say that the sorted side will not have the mininum value(We check by checking the previous value of mid and since its sortted w).Hence we can ignore looking for min in the sorted side
//And search continues in the unsorted side
//
public class BinarySearchToFindTheMinOfSortedRotatedArray {

    public int findMin(int[] nums)
    {
        if(nums == null || nums.length ==0)
            return -1;
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
             if(nums[low]<nums[high])
                 return nums[low];
             if((mid ==0 || nums[mid]<nums[mid -1] )&& (mid == nums.length-1 || nums[mid]> nums[mid+1]))
             return nums[mid];
             //left sorted
             else if (nums[low] <= nums[mid])
                 low = mid+1;
             //right sorted
             else
                 high = mid +1;
        }
        return -1;
    }

    

}