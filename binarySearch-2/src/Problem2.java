//TC : O(logn) as binary search is used
//SC : O(1)

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Problem2 {

    public int findMin(int[] nums) {

        int low=0;
        int high=nums.length-1;

        //incase the array is not rotated
        if(nums[0] <= nums[high])
            return nums[0];

        while(low<=high)
        {
            int mid = low + (high-low)/2;

            //this will only happen at the pivot of rotation
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];

            //if this is true, it means mid is in left sorted sub array and hence need to scan the right part
            //Hence set low = mid+1
            if(nums[mid] >= nums[0])
                low=mid+1;

                //if this is true, it means mid is in right sorted sub array and hence need to scan the left part
                //Hence set high=mid-1;
            else
                high=mid-1;

        }

        return 0;
    }



}
