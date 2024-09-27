// Time Complexity : O(log(N) , as we are using binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class Problem2{

    public int findMin(int[] nums) {


        //null check
        if(nums == null || nums.length==0 ) return 0;

        int low =0;
        int high = nums.length-1;
        while(low <=high)
        {

            int mid = low + (high-low)/2;

            //checking if the subarray is already sorted
            if(nums[low] <=nums[high] ) return nums[low];

            //checking if the mid is the minimum element
            if((mid ==0 ||nums[mid]<nums[mid-1] ) &&
                    ( mid == nums.length-1 || nums[mid]<nums[mid+1])){

                return nums[mid];

            }else if(nums[low] <= nums[mid]) {

                low = mid+1;
                //move to the unsorted side
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }






}