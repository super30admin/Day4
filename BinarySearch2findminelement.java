//Time complexity: O(log n)
//Space Complexity: O(1)
//In this program the aim is to find the minimum value in a sorted array.
class Solution
{
    public int findMin(int[] nums)
    {
        return findPivot(nums,0,nums.length-1);
    }
    // FInd Pivot function to find the value
    public int findPivot(int [] nums,int left,int right)
    {
        //Check if the value at the left is lesser than the value of the right 
        if(nums[left] <= nums[right])
            return nums[0];
        //loop while the left index is less than the right index
        while(left <= right)
        {
            // find the mid index
            int mid = (low + (h -low) )/ 2;
            //check if value at the mid position is greater than the value to the right of the mid value
            if(nums[mid] > nums[mid+1])
                // return the value on the right of the mid value
                return nums[mid+1];
            // check if the value on the left of the mid value is greater than the value mid the return the value at mid 
            if(nums[mid-1] > nums[mid])
                return nums[mid];
            // if value at left index is smaller than or equal to value at mid index
            if(nums[left] <=nums[mid])
            // assign left index to mid+1 index
                left = mid +1;
            else
            //else to mid-1 index
                right = mid-1;
        }
        // return -1
        return -1;
    }
}